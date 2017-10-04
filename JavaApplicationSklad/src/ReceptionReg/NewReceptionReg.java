
package ReceptionReg;

import Section.SectionModel;
import Worker.WorkerModel;
import Product.ProductModel;
import Partner.PartnerModel;
import Entities.Section;
import Entities.Partner;
import Entities.Product;
import Entities.Worker;
import Entities.ReceptionReg;
import Help.JTextFieldLimit;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

public class NewReceptionReg extends javax.swing.JDialog {

    Connection c;
    ReceptionReg editItem;
    List<Section> list;
    List<Partner> list1;
    List<Product> list2;
    List<Worker> list3;

    public NewReceptionReg(java.awt.Frame parent, boolean modal, Connection c) throws SQLException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.c = c;

        ((AbstractDocument) date.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        ((AbstractDocument) quantity.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        list = new ArrayList<>();
        section_number.setModel(new DefaultComboBoxModel(SectionModel.selectSection(c).toArray()));
        ((AbstractDocument) price.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        list1 = new ArrayList<>();
        partner_id.setModel(new DefaultComboBoxModel(PartnerModel.selectPartner(c).toArray()));
        list2 = new ArrayList<>();
        product_id.setModel(new DefaultComboBoxModel(ProductModel.selectProduct(c).toArray()));
        list3 = new ArrayList<>();
        worker_id.setModel(new DefaultComboBoxModel(WorkerModel.selectWorker(c).toArray()));
        
    }

    public NewReceptionReg(java.awt.Frame parent, boolean modal, Connection c, ReceptionReg u) throws SQLException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.c = c;
        editItem = u;

        ((AbstractDocument) date.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        ((AbstractDocument) quantity.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        list = new ArrayList<>();
        section_number.setModel(new DefaultComboBoxModel(SectionModel.selectSection(c).toArray()));
        ((AbstractDocument) price.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        list1 = new ArrayList<>();
        partner_id.setModel(new DefaultComboBoxModel(PartnerModel.selectPartner(c).toArray()));
        list2 = new ArrayList<>();
        product_id.setModel(new DefaultComboBoxModel(ProductModel.selectProduct(c).toArray()));
        list3 = new ArrayList<>();
        worker_id.setModel(new DefaultComboBoxModel(WorkerModel.selectWorker(c).toArray()));
        fillFields();
    }

    private void fillFields() {
        date.setText(editItem.getDate());
        quantity.setText(String.valueOf(editItem.getQuantity()));
        price.setText(String.valueOf(editItem.getPrice()));
        for (Section s : list) {
            if (s.getNumber() == editItem.getSection_number()) {
                section_number.setSelectedItem((s));
            }
        }
        for (Product s : list2) {
            if (s.getID() == editItem.getProduct_id()) {
                product_id.setSelectedItem((s));
            }
        }
        for (Partner s : list1) {
            if (s.getID() == editItem.getPartner_id()) {
                partner_id.setSelectedItem((s));
            }
        }
        for (Worker s : list3) {
            if (s.getID() == editItem.getWorker_id()) {
                worker_id.setSelectedItem((s));
            }
        }
    }

    public boolean check() {
        if ("".equals(date.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "date cannot be empty");
            return false;
        }
        if ("".equals(quantity.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "quantity cannot be empty");
            return false;
        }
        if ("".equals(price.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "price cannot be empty");
            return false;
        }
        
        return true;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        section_number = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        worker_id = new javax.swing.JComboBox<>();
        product_id = new javax.swing.JComboBox<>();
        partner_id = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel4.setText("Price");

        section_number.setToolTipText("");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Date");

        date.setToolTipText("");
        date.setName(""); // NOI18N

        jLabel2.setText("Quantity");

        quantity.setToolTipText("");
        quantity.setName(""); // NOI18N

        jLabel3.setText("Section");

        price.setToolTipText("");
        price.setName(""); // NOI18N

        jLabel5.setText("Partner");

        jLabel6.setText("Product");

        jLabel7.setText("Worker");

        worker_id.setToolTipText("");
        worker_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                worker_idActionPerformed(evt);
            }
        });

        product_id.setToolTipText("");

        partner_id.setToolTipText("");

        jButton2.setText("Добавить 1000 записей");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(27, 27, 27)))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(partner_id, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(product_id, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(worker_id, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(section_number, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(section_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(partner_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(product_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(worker_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (!check()) {
            return;
        }
        try {
            ReceptionRegModel wm = new ReceptionRegModel(c);
            wm.insertOrUpdate(editItem, date.getText(), Integer.parseInt(quantity.getText()), 
                    ((Section) section_number.getSelectedItem()).getNumber(),
                    Integer.parseInt(price.getText()),
                    ((Partner) partner_id.getSelectedItem()).getID(),
                    ((Product) product_id.getSelectedItem()).getID(),
                    ((Worker) worker_id.getSelectedItem()).getID());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            return;
        }
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void worker_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_worker_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_worker_idActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{            
            ReceptionRegModel wm = new ReceptionRegModel(c);
            for (int i = 1; i < 1001; i++){
                Random rnd = new Random();
                section_number.setSelectedIndex(rnd.nextInt(section_number.getItemCount()));
                partner_id.setSelectedIndex(rnd.nextInt(partner_id.getItemCount()));
                product_id.setSelectedIndex(rnd.nextInt(product_id.getItemCount()));
                worker_id.setSelectedIndex(rnd.nextInt(worker_id.getItemCount()));
                wm.insertOrUpdate(null, "20"+(rnd.nextInt(7)+10)+"-"+(rnd.nextInt(11)+1)+"-"+(rnd.nextInt(11)+1),
                        rnd.nextInt(9)+1, ((Section) section_number.getSelectedItem()).getNumber(),
                        rnd.nextInt(5000)+1000,
                        ((Partner) partner_id.getSelectedItem()).getID(),
                        ((Product) product_id.getSelectedItem()).getID(),
                        ((Worker) worker_id.getSelectedItem()).getID());                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            return;
        }        
        
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField date;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox<String> partner_id;
    private javax.swing.JTextField price;
    private javax.swing.JComboBox<String> product_id;
    private javax.swing.JTextField quantity;
    private javax.swing.JComboBox<String> section_number;
    private javax.swing.JComboBox<String> worker_id;
    // End of variables declaration//GEN-END:variables
}
