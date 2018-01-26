package orukomm.gui.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import orukomm.data.repositories.UserRepository;

public class Register extends javax.swing.JPanel {

    public Register(JFrame parentFrame) {
        initComponents();
	
	btnSubmit.addActionListener((ActionEvent e) -> {
		
	});
    }

    @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                txtfFirstName = new javax.swing.JTextField();
                txtfLastName = new javax.swing.JTextField();
                txtfEmail = new javax.swing.JTextField();
                txtfUsername = new javax.swing.JTextField();
                pswfPW = new javax.swing.JPasswordField();
                pswfConfirmPW = new javax.swing.JPasswordField();
                lblFirstName = new javax.swing.JLabel();
                lblLastName = new javax.swing.JLabel();
                lblEmail = new javax.swing.JLabel();
                lblUsername = new javax.swing.JLabel();
                lblPW = new javax.swing.JLabel();
                lblConfirmPW = new javax.swing.JLabel();
                btnSubmit = new javax.swing.JButton();

                setPreferredSize(new java.awt.Dimension(1024, 768));

                pswfPW.setText("jPasswordField1");

                pswfConfirmPW.setText("jPasswordField2");

                lblFirstName.setText("Förnam");

                lblLastName.setText("Efternamn");

                lblEmail.setText("E-mail");

                lblUsername.setText("Användarnamn");

                lblPW.setText("Lösenord");

                lblConfirmPW.setText("Bekräfta lösenord");

                btnSubmit.setText("Registrera");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblFirstName)
                                        .addComponent(lblLastName)
                                        .addComponent(lblEmail)
                                        .addComponent(lblUsername)
                                        .addComponent(lblPW)
                                        .addComponent(lblConfirmPW))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(pswfConfirmPW, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                        .addComponent(pswfPW, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                        .addComponent(txtfUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                        .addComponent(txtfEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtfLastName, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtfFirstName, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(819, Short.MAX_VALUE)
                                .addComponent(btnSubmit)
                                .addGap(133, 133, 133))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(506, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblFirstName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblLastName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblEmail))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblUsername))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(pswfConfirmPW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblPW))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(pswfPW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblConfirmPW))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSubmit)
                                .addGap(21, 21, 21))
                );
        }// </editor-fold>//GEN-END:initComponents


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnSubmit;
        private javax.swing.JLabel lblConfirmPW;
        private javax.swing.JLabel lblEmail;
        private javax.swing.JLabel lblFirstName;
        private javax.swing.JLabel lblLastName;
        private javax.swing.JLabel lblPW;
        private javax.swing.JLabel lblUsername;
        private javax.swing.JPasswordField pswfConfirmPW;
        private javax.swing.JPasswordField pswfPW;
        private javax.swing.JTextField txtfEmail;
        private javax.swing.JTextField txtfFirstName;
        private javax.swing.JTextField txtfLastName;
        private javax.swing.JTextField txtfUsername;
        // End of variables declaration//GEN-END:variables
}
