package javaapplication14;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import javax.swing.table.DefaultTableModel;

class Citizen {

    String id, name, gender, birthplace, birthdate;

    public Citizen(String id, String name, String gender, String birthplace, String birthdate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthplace = birthplace;
        this.birthdate = birthdate;
    }

    public Citizen() {
        Random r = new Random();
        this.id = "" + r.nextInt(90) + 10;
        String text1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String text2 = "abcdefghijklmnopqrstuvwxyz";
        String temp = "";
        String[] g = {"Male", "Female"};
        this.gender = g[r.nextInt(g.length)];

        String[] bp = {"Bangkok", "Nakornpathom", "Chonburi", "Yala"};
        this.birthplace = bp[r.nextInt(bp.length)];

        String name = "" + text1.charAt(r.nextInt(text1.length() - 1));
        String birthdate = "";
        int n = r.nextInt(3) + 3;
        for (int i = 0; i < n; i++) {
            temp += text2.charAt(r.nextInt(text2.length() - 1));

            //name += text2.charAt(r.nextInt(text2.length()-1));
        }

        this.name = temp;

        int year = r.nextInt(34) + 1990;
        int month = r.nextInt(12) + 1;
        int day = 0;

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = r.nextInt(31) + 1;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day = r.nextInt(30) + 1;
                break;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    day = r.nextInt(29) + 1;
                } else {
                    day = r.nextInt(28) + 1;

                }
                break;
        }
        this.birthdate = day + "/" + month + "/" + year;
    }

    @Override
    public String toString() {
        return id + "-" + name + "-" + gender + "-" + birthplace + "-" + birthdate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public String getBirthdate() {
        return birthdate;
    }
}

class Node {

    Citizen data;
    int key, height;
    Node left, right;

    Node(Citizen data, int key) {
        this.data = data;
        this.key = key;
        this.height = 1;
    }

    public Citizen genData() {
        return data;
    }

    public int getHeight() {
        return height;
    }
}

class AVLTree {

    private Node root;

    int height(Node N) {
        return (N == null) ? 0 : N.height;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    int getBalance(Node N) {
        return (N == null) ? 0 : height(N.left) - height(N.right);
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = (x != null) ? x.right : null;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(y.left), height(y.right)) + 1;

        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = (y != null) ? y.left : null;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public void insert(Citizen c, int key) {
        root = insert(root, c, key);
    }

    Node insert(Node node, Citizen c, int key) {
        if (node == null) {
            return new Node(c, key);
        }

        if (key < node.key) {
            node.left = insert(node.left, c, key);
        } else if (key > node.key) {
            node.right = insert(node.right, c, key);
        } else {
            node.data = c;
            return node;
        }

        node.height = 1 + max(height(node.left), height(node.right));

        int b = getBalance(node);

        // LL 
        if (b > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        //RR
        if (b < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        //LR
        if (b > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        //RL
        if (b < -1 && key < node.right.key) {
            node.left = leftRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    void postOrder(Node node) {
        if (node != null) {
            preOrder(node.left);
            preOrder(node.right);
            System.out.println(node.data + " ");
        }
    }

    //List for push data into Object for Print in jTable
    public java.util.List<Citizen> getPreOrderList() {
        java.util.List<Citizen> list = new java.util.ArrayList<>();
        collectPreOrder(root, list);
        return list;
    }

    private void collectPreOrder(Node node, java.util.List<Citizen> list) {
        if (node != null) {
            list.add(node.data);
            collectPreOrder(node.left, list);
            collectPreOrder(node.right, list);
        }
    }

    public java.util.List<Citizen> getPostOrderList() {
        java.util.List<Citizen> list = new java.util.ArrayList<>();
        collectPostOrder(root, list);
        return list;
    }

    private void collectPostOrder(Node node, java.util.List<Citizen> list) {
        if (node != null) {
            collectPostOrder(node.left, list);
            collectPostOrder(node.right, list);
            list.add(node.data);
        }
    }

    public String bfs() {
        if (root == null) {
            return "empty";
        }

        StringBuilder sb = new StringBuilder();
        java.util.Queue<Node> q = new java.util.LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            Node cur = q.poll();
            sb.append(cur.data.getName()).append(",   ");

            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }

        }

        return sb.toString();
    }

}

public class NewJFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(NewJFrame.class.getName());

    public static Citizen[] data;
    public static AVLTree tree;

    public static Object[][] data1;
    public static Object[][] data2;

    public String[] ColName = {"id", "name", "gender", "birthPlace", "birthDate"};

    public Object[][] buildTableData(java.util.List<Citizen> list) {
        Object[][] tableData = new Object[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            Citizen c = list.get(i);
            tableData[i][0] = c.getId();
            tableData[i][1] = c.getName();
            tableData[i][2] = c.getGender();
            tableData[i][3] = c.getBirthplace();
            tableData[i][4] = c.getBirthdate();
        }
        return tableData;
    }

    public Object[][] buildTableData(Citizen[] arr) {
        if (arr == null) {
            return new Object[0][0];
        }
        Object[][] rows = new Object[arr.length][5];
        for (int i = 0; i < arr.length; i++) {
            Citizen c = arr[i];
            rows[i][0] = c.getId();
            rows[i][1] = c.getName();
            rows[i][2] = c.getGender();
            rows[i][3] = c.getBirthplace();
            rows[i][4] = c.getBirthdate();
        }
        return rows;
    }

    public NewJFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("GenData");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("GenBST");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("GenAVL");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("BFS");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("PreOrder");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("PostOrdder");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);

        jTextField2.setEditable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton4)
                                    .addComponent(jButton2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton6)))))))
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(244, 244, 244))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        StringBuilder sb = new StringBuilder();
        data = new Citizen[5];

        for (int i = 0; i < 5; i++) {
            data[i] = new Citizen();
            System.out.println(data[i].toString());
            sb.append(data[i].toString()).append(",   ");
        }

        Object[][] rows = buildTableData(data);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(rows, ColName));

        jTextField1.setText(sb.toString());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.out.println("AVL");
        StringBuilder sb = new StringBuilder();
        //data = new Citizen[5];
        tree = new AVLTree();

        for (int i = 0; i < data.length; i++) {
            int key = Integer.parseInt(data[i].getId());
            tree.insert(data[i], key);
            sb.append(data[i].toString()).append(",   ");
            System.out.println(data[i].toString());
        }
        jTextField2.setText("Successfully");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String result = tree.bfs();

        java.util.List<Citizen> preorder = tree.getPreOrderList();
        data1 = buildTableData(preorder);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(data1, ColName));

        jTextField2.setText(result);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //TextField
        ByteArrayOutputStream ba = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(ba);
        PrintStream old = System.out;

        System.setOut(ps);
        tree.preOrder();

        System.out.flush();
        System.setOut(old);

        jTextField2.setText(ba.toString());

        //Table
        java.util.List<Citizen> preorder = tree.getPreOrderList();
        data1 = buildTableData(preorder);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(data1, ColName));
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //Table
        java.util.List<Citizen> preorder = tree.getPostOrderList();
        data1 = buildTableData(preorder);
        jTable2.setModel(new DefaultTableModel(data1, ColName));
    }//GEN-LAST:event_jButton6ActionPerformed
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new NewJFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
