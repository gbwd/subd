
package Worker;

import Role.RoleModel;
import Entities.Role;
import Entities.Section;
import Entities.Worker;
import Help.JTextFieldLimit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

public class NewWorker extends javax.swing.JDialog {

    Connection c;
    Worker editItem;
    List<Role> list;

    public NewWorker(java.awt.Frame parent, boolean modal, Connection c) throws SQLException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.c = c;

        ((AbstractDocument) nameTxt.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        ((AbstractDocument) surname.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        ((AbstractDocument) patronymic.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        list = new ArrayList<>();
        role_id.setModel(new DefaultComboBoxModel(RoleModel.selectRole(c).toArray()));
        
    }

    public NewWorker(java.awt.Frame parent, boolean modal, Connection c, Worker u) throws SQLException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.c = c;
        editItem = u;

        ((AbstractDocument) nameTxt.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        ((AbstractDocument) surname.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        ((AbstractDocument) patronymic.getDocument()).setDocumentFilter(new JTextFieldLimit(30));
        list = new ArrayList<>();
        role_id.setModel(new DefaultComboBoxModel(RoleModel.selectRole(c).toArray()));
        fillFields();
    }

    
    private void fillFields() {
        nameTxt.setText(editItem.getFirstName());
        surname.setText(editItem.getSurname());
        patronymic.setText(editItem.getPatronymic());
        for (Role s : list) {
            if (s.getID() == editItem.getRole_id()) {
                role_id.setSelectedItem((s));
            }
        }
    }

    public boolean check() {
        if ("".equals(nameTxt.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "name cannot be empty");
            return false;
        }
        if ("".equals(surname.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "surname cannot be empty");
            return false;
        }        
        return true;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonOk = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        surname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        patronymic = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        role_id = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonOk.setText("OK");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jLabel1.setText("Name");

        nameTxt.setToolTipText("");
        nameTxt.setName(""); // NOI18N

        jLabel2.setText("Surname");

        surname.setToolTipText("");
        surname.setName(""); // NOI18N

        jLabel3.setText("Patronymic");

        patronymic.setToolTipText("");
        patronymic.setName(""); // NOI18N

        jLabel4.setText("Role");

        role_id.setToolTipText("");

        jButton1.setText("Добавить 1000 работников");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jButtonOk))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(patronymic, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(role_id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(surname, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patronymic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(role_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonOk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        
        if (!check()) {
            return;
        }
        try{            
            WorkerModel wm = new WorkerModel(c);
            wm.insertOrUpdate(editItem, nameTxt.getText(), surname.getText(), patronymic.getText(),
                    ((Role) role_id.getSelectedItem()).getID());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            return;
        }
        dispose();
    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{            
            WorkerModel wm = new WorkerModel(c);
            for (int i = 1; i < 1001; i++){
                Random rnd = new Random();
                wm.insertOrUpdate(null, names[rnd.nextInt(13)], surnames[rnd.nextInt(41)], patronymics[rnd.nextInt(100)],
                        rnd.nextInt(2)+1);
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            return;
        }        
        
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JTextField patronymic;
    private javax.swing.JComboBox<String> role_id;
    private javax.swing.JTextField surname;
    // End of variables declaration//GEN-END:variables
    String[] names = {"Аким","Александр","Алексей","Анатолий","Андрей","Антон","Аркадий","Арсений","Артём","Артемий",
        "Богдан","Богдан","Борис","Борислав"};
    String surnamesStr = "Иванов\n" +
    "Васильев\n" +
    "Петров\n" +
    "Смирнов\n" +
    "Михайлов\n" +
    "Фёдоров\n" +
    "Соколов\n" +
    "Яковлев\n" +
    "Попов\n" +
    "Андреев\n" +
    "Алексеев\n" +
    "Александров\n" +
    "Лебедев\n" +
    "Григорьев\n" +
    "Степанов\n" +
    "Семёнов\n" +
    "Павлов\n" +
    "Богданов\n" +
    "Николаев\n" +
    "Дмитриев\n" +
    "Егоров\n" +
    "Волков\n" +
    "Кузнецов\n" +
    "Никитин\n" +
    "Соловьёв\n" +
    "Тимофеев\n" +
    "Орлов\n" +
    "Афанасьев\n" +
    "Филиппов\n" +
    "Сергеев\n" +
    "Захаров\n" +
    "Матвеев\n" +
    "Виноградов\n" +
    "Кузьмин\n" +
    "Максимов\n" +
    "Козлов\n" +
    "Ильин\n" +
    "Герасимов\n" +
    "Марков\n" +
    "Новиков\n" +
    "Морозов";
    String[] surnames = surnamesStr.split("\n");
    String patronymicStr = "Ааронович\n" +
    "Абрамович\n" +
    "Августович\n" +
    "Авдеевич\n" +
    "Аверьянович\n" +
    "Адамович\n" +
    "Адрианович\n" +
    "Аксёнович\n" +
    "Александрович\n" +
    "Алексеевич\n" +
    "Анатольевич\n" +
    "Андреевич\n" +
    "Анисимович\n" +
    "Антипович\n" +
    "Антонович\n" +
    "Ануфриевич\n" +
    "Арсенович\n" +
    "Арсеньевич\n" +
    "Артёмович\n" +
    "Артемьевич\n" +
    "Артурович\n" +
    "Архипович\n" +
    "Афанасьевич\n" +
    "Бенедиктович\n" +
    "Богданович\n" +
    "Бориславич\n" +
    "Бориславович\n" +
    "Борисович\n" +
    "Брониславович\n" +
    "Валентинович\n" +
    "Валерианович\n" +
    "Валерьевич\n" +
    "Валерьянович\n" +
    "Васильевич\n" +
    "Венедиктович\n" +
    "Викентьевич\n" +
    "Викторович\n" +
    "Виленович\n" +
    "Вилорович\n" +
    "Витальевич\n" +
    "Владиленович\n" +
    "Владиславович\n" +
    "Владленович\n" +
    "Власович\n" +
    "Всеволодович\n" +
    "Вячеславович\n" +
    "Гавриилович\n" +
    "Гаврилович\n" +
    "Геннадиевич\n" +
    "Георгиевич\n" +
    "Герасимович\n" +
    "Германович\n" +
    "Гертрудович\n" +
    "Глебович\n" +
    "Гордеевич\n" +
    "Григорьевич\n" +
    "Гурьевич\n" +
    "Давидович\n" +
    "Давыдович\n" +
    "Даниилович\n" +
    "Данилович\n" +
    "Демидович\n" +
    "Демьянович\n" +
    "Денисович\n" +
    "Димитриевич\n" +
    "Дмитриевич\n" +
    "Дорофеевич\n" +
    "Евсеевич\n" +
    "Евстигнеевич\n" +
    "Егорович\n" +
    "Елизарович\n" +
    "Елисеевич\n" +
    "Еремеевич\n" +
    "Ермилович\n" +
    "Ермолаевич\n" +
    "Ерофеевич\n" +
    "Ефимович\n" +
    "Ефимьевич\n" +
    "Ефремович\n" +
    "Ефстафьевич\n" +
    "Жанович\n" +
    "Жоресович\n" +
    "Захарьевич\n" +
    "Зиновьевич\n" +
    "Игнатович\n" +
    "Игнатьевич\n" +
    "Игоревич\n" +
    "Измаилович\n" +
    "Изотович\n" +
    "Иларионович\n" +
    "Ильич\n" +
    "Ильясович\n" +
    "Иосипович\n" +
    "Иосифович\n" +
    "Исидорович\n" +
    "Марсович\n" +
    "Матвеевич\n" +
    "Тарасович\n" +
    "Теймуразович\n" +
    "Терентьевич\n" +
    "Тимурович\n" +
    "Тихонович\n" +
    "Трифонович\n" +
    "Трофимович\n" +
    "Устинович\n" +
    "Фадеевич\n" +
    "Фёдорович\n" +
    "Федосеевич\n" +
    "Федосьевич\n" +
    "Федотович\n" +
    "Феликсович\n" +
    "Феодосьевич\n";
    String[] patronymics = patronymicStr.split("\n");
}
