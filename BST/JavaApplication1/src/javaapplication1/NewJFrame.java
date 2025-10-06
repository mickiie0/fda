package javaapplication1;

import java.util.Random;

class Student {

    String code, name;
    double gpa;

    Student(String code, String name, double gpa) {
        this.code = code;
        this.name = name;
        this.gpa = gpa;
    }

    public String getCode() {
        return code;
    }

    public String toString() {
        return code + " " + name + " " + gpa;
    }
}

// Node class representing each node in the BST
class Node {

    Student data;
    Node left, right;

    public Node(Student key) {
        this.data = key;
        this.left = null;
        this.right = null;
    }

    // Getter and Setter for key
    public Student getKey() {
        return data;
    }

    public void setKey(Student key) {
        this.data = key;
    }

    // Getter and Setter for left
    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    // Getter and Setter for right
    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

// Binary Search Tree class
class BinarySearchTree {

    Node root;
    String in;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // Insert key into BST
    void add(Student key) {
        root = insertRec(root, key);
    }

    // Recursive insert function
    //Rec = Recursive
    Node insertRec(Node root, Student key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key.getCode().compareTo(root.getKey().getCode()) < 0) {
            root.left = insertRec(root.left, key);
        } else if (key.getCode().compareTo(root.getKey().getCode()) > 0) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    // Inorder traversal (left, root, right)
    void inorder() {
        in = "";
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            in+=root.data.toString() + " ";
//            System.out.print(root.data.toString() + " ");
            inorderRec(root.right);
        }
    }
    
    String getInorder(){
        return in;
    }

    // Search for a key in BST
    boolean search(Student key) {
        return searchRec(root, key);
    }

    boolean searchRec(Node root, Student key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        } else if (key.getCode().compareTo(root.getKey().getCode()) < 0) {
            return searchRec(root.left, key);
        } else {
            return searchRec(root.right, key);
        }
    }

}

public class NewJFrame extends javax.swing.JFrame {

    public static Student genStudent() {
        Random r = new Random();
        String code = "" + r.nextInt(90) + 10;
        String a = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String aa = "abcdefghijklmnopqrstuvwxyz";
        String name = a.charAt(r.nextInt(26)) + "";

        for (int i = 0; i < r.nextInt(5) + 3; i++) {
            name += aa.charAt(r.nextInt(26));
        }

        double gpa = r.nextInt(4) + ((r.nextDouble(100)) / 100);

        return new Student(code, name, gpa);
    }

    Student data[];
    int cap;
    BinarySearchTree bst = new BinarySearchTree();
    
    public NewJFrame() {
        initComponents();

//        BinarySearchTree bst = new BinarySearchTree();
//        for (int i = 0; i < 5; i++) {
//            Student x = genStudent();
//            System.out.println(x.toString());
//            bst.add(x);
//        }
//        System.out.println("");
//        bst.inorder();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Binary Search tree_650710161");

        jButton1.setText("GenStudent");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setText("0");

        jButton2.setText("CreateBST");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Inorder");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                    .addComponent(jTextField3))
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(187, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    //genstudent
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String a = jTextField1.getText();
        int x = Integer.parseInt(a);
        cap = x;
        data = new Student[x];
        
        if(x==0){
            return;
        }
        
        jTextField3.setText("");
        String show="";
        
        for (int i = 0; i < x; i++) {
            Student s = genStudent();
            data[i] = s;
            show += s.toString()+"/ ";
        }
        jTextField3.setText(show);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(data == null){
            return;
        }
        bst = new BinarySearchTree();
        for(int i=0;i<cap;i++){
            bst.add(data[i]);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(data == null) return;
        bst.inorder();
        jTextField2.setText(bst.getInorder());
    }//GEN-LAST:event_jButton3ActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
