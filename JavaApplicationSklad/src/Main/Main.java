
package Main;

import java.awt.HeadlessException;
import Partner.Partners;
import Worker.Workers;  
import ReceptionReg.ReceptionRegs;
import WriteOffReg.WtriteOffRegs;
import Product.Products;
import Section.Sections;
import Role.Roles;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

    Connection connection = null;
    
    
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        NewConnection nc = new NewConnection(this, true);
        nc.setVisible(true);
        if (nc.ready) {
            connection = nc.getConnection();
        }
        try {
            if (connection != null) {
                DatabaseMetaData dmd = connection.getMetaData();
                String url = dmd.getURL();
                status.setText("Подключение к БД: " 
                        + url.substring(url.lastIndexOf("/") + 1));
            } else {
                status.setText("Нет подключений");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        status = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        Partners = new javax.swing.JMenuItem();
        Products = new javax.swing.JMenuItem();
        Section = new javax.swing.JMenuItem();
        Roles = new javax.swing.JMenuItem();
        Workers = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        receptionReg = new javax.swing.JMenuItem();
        writeOffReg = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        status.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        status.setEnabled(false);

        jMenu1.setText("Подключение");

        jMenuItem1.setText("Новое подключение");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Отключиться");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Выход");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Сущности");

        Partners.setText("Контрагенты");
        Partners.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PartnersActionPerformed(evt);
            }
        });
        jMenu2.add(Partners);

        Products.setText("Продукция");
        Products.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductsActionPerformed(evt);
            }
        });
        jMenu2.add(Products);

        Section.setText("Секции");
        Section.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SectionActionPerformed(evt);
            }
        });
        jMenu2.add(Section);

        Roles.setText("Должности");
        Roles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RolesActionPerformed(evt);
            }
        });
        jMenu2.add(Roles);

        Workers.setText("Работники");
        Workers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WorkersActionPerformed(evt);
            }
        });
        jMenu2.add(Workers);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Действия");

        receptionReg.setText("Регистрация поступлений");
        receptionReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receptionRegActionPerformed(evt);
            }
        });
        jMenu3.add(receptionReg);

        writeOffReg.setText("Регистрация списания");
        writeOffReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                writeOffRegActionPerformed(evt);
            }
        });
        jMenu3.add(writeOffReg);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        NewConnection nc = new NewConnection(this, true);
        nc.setVisible(true);
        if (nc.ready) {
            connection = nc.getConnection();
        }
        try {
            if (connection != null) {
                DatabaseMetaData dmd = connection.getMetaData();
                String url = dmd.getURL();
                status.setText("Подключение к БД: " 
                        + url.substring(url.lastIndexOf("/") + 1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            connection.close();
            JOptionPane.showMessageDialog(new JFrame(), "Успех");
            connection = null;
            status.setText("Нет подкючений");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        dispose();
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void PartnersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PartnersActionPerformed
        if (connection != null) {
            try {
                Partners p = new Partners(this, true, connection);
                p.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Нет подключений");
        }
    }//GEN-LAST:event_PartnersActionPerformed

    private void ProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductsActionPerformed
        if (connection != null) {
            try {
                Products p = new Products(this, true, connection);
                p.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Нет подключений");
        }
    }//GEN-LAST:event_ProductsActionPerformed

    private void SectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SectionActionPerformed
       if (connection != null) {
            try {
                Sections s = new Sections(this, true, connection);
                s.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Нет подключений");
        }
    }//GEN-LAST:event_SectionActionPerformed

    private void RolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RolesActionPerformed
        if (connection != null) {
            try {
                Roles r = new Roles(this, true, connection);
                r.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Нет подключений");
        }
    }//GEN-LAST:event_RolesActionPerformed

    private void WorkersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WorkersActionPerformed
       if (connection != null) {
           try {
                Workers w = new Workers(this, true, connection);
                w.setVisible(true);
                } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Нет подключений");
        }
    }//GEN-LAST:event_WorkersActionPerformed

    private void receptionRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receptionRegActionPerformed
        if (connection != null) {
           try {
                ReceptionRegs w = new ReceptionRegs(this, true, connection);
                w.setVisible(true);
                } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Нет подключений");
        }
    }//GEN-LAST:event_receptionRegActionPerformed

    private void writeOffRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_writeOffRegActionPerformed
        if (connection != null) {
           try {
                WtriteOffRegs w = new WtriteOffRegs(this, true, connection);
                w.setVisible(true);
                } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Нет подключений");
        }
    }//GEN-LAST:event_writeOffRegActionPerformed

    
    public static void main(String args[]) {
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Partners;
    private javax.swing.JMenuItem Products;
    private javax.swing.JMenuItem Roles;
    private javax.swing.JMenuItem Section;
    private javax.swing.JMenuItem Workers;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem receptionReg;
    private javax.swing.JTextField status;
    private javax.swing.JMenuItem writeOffReg;
    // End of variables declaration//GEN-END:variables
}
