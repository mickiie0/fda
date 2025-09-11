package pkg650710161;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import javax.swing.table.DefaultTableModel;

class Car {

    String code;
    String model;
    String brand;
    int price;
    int year;
    String type;

    String alphabeth = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String alphabeth_lower = "abcdefghijklmnopqrstuvwxyz";
    String[] b = {"Honda", "Toyota", "Ford", "Volvo", "GWM", "BMW"};
    String[] t = {"Gasoline", "Diesel", "Electric", "Hybrid"};

    public Car() {
        Random r = new Random();
        code = alphabeth.charAt(r.nextInt(26)) + "" + alphabeth.charAt(r.nextInt(26)) + "" + r.nextInt(10) + "" + r.nextInt(10) + "" + r.nextInt(10);
        model = "";
        for (int i = 0; i < r.nextInt(4, 11); i++) {
            if (i == 0) {
                model += alphabeth.charAt(r.nextInt(26));
            } else {
                model += alphabeth_lower.charAt(r.nextInt(26));
            }
        }
        brand = b[r.nextInt(b.length)];
        price = r.nextInt(500000, 10000001);
        year = r.nextInt(2000, 2026);
        type = t[r.nextInt(t.length)];
    }

    int getPrice() {
        return price;
    }

    public String toString() {
        return code + "," + model + "," + brand + "," + price + "," + year + "," + type;
    }

    public static Car[] addFirst(Car[] s, Car x) {
        Car[] newcar = new Car[s.length + 1];
        newcar[0] = x;

        System.arraycopy(s, 0, newcar, 1, s.length);
        return newcar;
    }

    public static Car[] addLast(Car[] s, Car x) {
        Car[] newcar = new Car[s.length + 1];
        newcar[s.length] = x;
        System.arraycopy(s, 0, newcar, 0, s.length);
        return newcar;
    }

    public static Car[] deleteFirst(Car[] s) {
        Car[] newcar = new Car[s.length - 1];
        for (int i = 0; i < newcar.length; i++) {
            newcar[i] = s[i + 1];
        }
        return newcar;
    }

    public static Car[] deleteLast(Car[] s) {
        Car[] newcar = new Car[s.length - 1];
        System.arraycopy(s, 0, newcar, 0, newcar.length);
        return newcar;
    }

}

class CarComparator implements Comparator<Car> {

    @Override
    public int compare(Car c1, Car c2) {
        return c1.getPrice() - (c2.getPrice());
    }
}

public class NewJFrame extends javax.swing.JFrame {

    Object[][] data;
    Car[] car;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(NewJFrame.class.getName());

    public NewJFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("650710161_assignment1");

        jButton1.setBackground(new java.awt.Color(153, 255, 204));
        jButton1.setText("GenData");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Code", "Model", "Brand", "Price", "Year", "Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jButton2.setBackground(new java.awt.Color(255, 255, 153));
        jButton2.setText("Sort");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(153, 153, 255));
        jButton3.setText("AddFirst");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(153, 153, 255));
        jButton4.setText("AddLast");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 51, 51));
        jButton5.setText("DeleteFirst");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 51, 51));
        jButton6.setText("DeleteLast");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(jButton5)))
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(99, 99, 99)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(48, 48, 48)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //gen data
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String[] columnName = {"Code", "Model", "Brand", "Price", "Year", "Type"};
        car = new Car[10];
        data = new Object[10][];
        for (int i = 0; i < 10; i++) {
            car[i] = new Car();
            data[i] = car[i].toString().split(",");
        }
        DefaultTableModel model = new DefaultTableModel(data, columnName);
        jTable1.setModel(model);

    }//GEN-LAST:event_jButton1ActionPerformed

    //sort
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Arrays.sort(car, new CarComparator());

        //displayer
        data = new Object[car.length][];
        for (int i = 0; i < car.length; i++) {
            data[i] = car[i].toString().split(",");
        }
        String[] columnName = {"Code", "Model", "Brand", "Price", "Year", "Type"};
        DefaultTableModel model = new DefaultTableModel(data, columnName);
        jTable1.setModel(model);
    }//GEN-LAST:event_jButton2ActionPerformed

    //addfirst
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Car nc = new Car();

        car = Car.addFirst(car, nc);

        data = new Object[car.length][];
        for (int i = 0; i < car.length; i++) {
            data[i] = car[i].toString().split(",");
        }
        String[] columnName = {"Code", "Model", "Brand", "Price", "Year", "Type"};
        DefaultTableModel model = new DefaultTableModel(data, columnName);
        jTable1.setModel(model);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Car nc = new Car();

        car = Car.addLast(car, nc);

        data = new Object[car.length][];
        for (int i = 0; i < car.length; i++) {
            data[i] = car[i].toString().split(",");
        }
        String[] columnName = {"Code", "Model", "Brand", "Price", "Year", "Type"};
        DefaultTableModel model = new DefaultTableModel(data, columnName);
        jTable1.setModel(model);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Car nc = new Car();

        car = Car.deleteFirst(car);

        data = new Object[car.length][];
        for (int i = 0; i < car.length; i++) {
            data[i] = car[i].toString().split(",");
        }
        String[] columnName = {"Code", "Model", "Brand", "Price", "Year", "Type"};
        DefaultTableModel model = new DefaultTableModel(data, columnName);
        jTable1.setModel(model);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Car nc = new Car();

        car = Car.deleteLast(car);

        data = new Object[car.length][];
        for (int i = 0; i < car.length; i++) {
            data[i] = car[i].toString().split(",");
        }
        String[] columnName = {"Code", "Model", "Brand", "Price", "Year", "Type"};
        DefaultTableModel model = new DefaultTableModel(data, columnName);
        jTable1.setModel(model);        
    }//GEN-LAST:event_jButton6ActionPerformed

    public static void main(String args[]) {

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

        java.awt.EventQueue.invokeLater(() -> new NewJFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
