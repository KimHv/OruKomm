package orukomm.gui.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import orukomm.Settings;
import orukomm.data.entities.User;
import orukomm.data.repositories.UserRepository;
import orukomm.gui.MainWindow;
import orukomm.logic.Validation;

public class Register extends javax.swing.JPanel {

	private MainWindow parentFrame;
	private UserRepository userRepo;

	public Register(MainWindow parentFrame) {
		this.parentFrame = parentFrame;
		initComponents();
		userRepo = new UserRepository();

		// Registration submit event.
		btnRegister.addActionListener((ActionEvent e) -> {
			User newUser = new User();
			newUser.setFirstName(txtfFirstName.getText());
			newUser.setSurname(txtfSurname.getText());
			newUser.setUsername(txtfUsername.getText());
			newUser.setPassword(pswPassword.getText());
			
			// TODO generate salt and password hash.
			
			switch (cmbRoles.getSelectedIndex()) {
				case 0:
					newUser.setRole(User.PermissionFlag.USER.getPermissionValue(Settings.USER_ROLE));
					break;
					
				case 1:
					newUser.setRole(User.PermissionFlag.ADMIN.getPermissionValue(Settings.ADMIN_ROLE));
					break;
					
				case 2:
					newUser.setRole(User.PermissionFlag.SUPERADMIN.getPermissionValue(Settings.SUPERADMIN_ROLE));
					break;
			}
			
			// Validate submitted user.
			if (Validation.isEmptyOrNull(newUser.getFirstName())
					|| Validation.isEmptyOrNull(newUser.getSurname())
					|| Validation.isEmptyOrNull(newUser.getUsername())
					|| Validation.isEmptyOrNull(newUser.getPassword())
					|| Validation.isEmptyOrNull(pswPasswordConfirmation.getText())) {
				JOptionPane.showMessageDialog(parentFrame, "Inga fält får lämnas tomma.", "Valideringsfel", JOptionPane.ERROR_MESSAGE);
				
				return;
			}
			
			if (!newUser.getPassword().equals(pswPasswordConfirmation.getText())) {
				JOptionPane.showMessageDialog(parentFrame, "Lösenorden du angav matchar inte varandra.", "Valideringsfel", JOptionPane.ERROR_MESSAGE);
				
				return;
			}
			
			// Check if username exists in data context.
			if (userRepo.userExists(newUser.getUsername())) {
				JOptionPane.showMessageDialog(parentFrame, "Användarnamnet du angav existerar redan.", "Användarnamn upptaget", JOptionPane.ERROR_MESSAGE);
			}
			
			// User registration survived the validation: write new user to data context.
			userRepo.add(newUser);
			parentFrame.switchPanel(new Index(parentFrame));
			JOptionPane.showMessageDialog(parentFrame, "Den nya användaren har registrerats.", "Användare registrerad", JOptionPane.INFORMATION_MESSAGE);
		});
		
		pswPasswordConfirmation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnRegister.doClick();
			}
		});
	}

	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                pnlRegisterContainer = new javax.swing.JPanel();
                lblFirstName = new javax.swing.JLabel();
                lblSurname = new javax.swing.JLabel();
                lblUsername = new javax.swing.JLabel();
                lblPassword = new javax.swing.JLabel();
                txtfFirstName = new javax.swing.JTextField();
                txtfSurname = new javax.swing.JTextField();
                txtfUsername = new javax.swing.JTextField();
                pswPassword = new javax.swing.JPasswordField();
                btnRegister = new javax.swing.JButton();
                lblRegisterHeading = new javax.swing.JLabel();
                pswPasswordConfirmation = new javax.swing.JPasswordField();
                lblPasswordConfirmation = new javax.swing.JLabel();
                cmbRoles = new javax.swing.JComboBox<>();
                lblUserRole = new javax.swing.JLabel();

                setPreferredSize(new java.awt.Dimension(1024, 768));

                lblFirstName.setText("Förnamn");

                lblSurname.setText("Efternamn");

                lblUsername.setText("Användarnamn");

                lblPassword.setText("Lösenord");

                btnRegister.setText("Registrera");

                lblRegisterHeading.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
                lblRegisterHeading.setText("Registrera ny användare");

                lblPasswordConfirmation.setText("Bekräfta lösenord");

                cmbRoles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Användare", "Admin", "Superadmin" }));

                lblUserRole.setText("Användarroll");

                javax.swing.GroupLayout pnlRegisterContainerLayout = new javax.swing.GroupLayout(pnlRegisterContainer);
                pnlRegisterContainer.setLayout(pnlRegisterContainerLayout);
                pnlRegisterContainerLayout.setHorizontalGroup(
                        pnlRegisterContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlRegisterContainerLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlRegisterContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(pnlRegisterContainerLayout.createSequentialGroup()
                                                .addComponent(lblRegisterHeading)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(pnlRegisterContainerLayout.createSequentialGroup()
                                                .addGroup(pnlRegisterContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(pnlRegisterContainerLayout.createSequentialGroup()
                                                                .addGroup(pnlRegisterContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lblFirstName)
                                                                        .addComponent(lblSurname)
                                                                        .addComponent(lblUsername)
                                                                        .addComponent(lblPassword))
                                                                .addGap(50, 50, 50))
                                                        .addComponent(lblPasswordConfirmation, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblUserRole, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addGroup(pnlRegisterContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(pnlRegisterContainerLayout.createSequentialGroup()
                                                                .addGap(1, 1, 1)
                                                                .addGroup(pnlRegisterContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(txtfUsername)
                                                                        .addComponent(txtfSurname)
                                                                        .addComponent(txtfFirstName)
                                                                        .addComponent(pswPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(pnlRegisterContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(btnRegister)
                                                                .addComponent(pswPasswordConfirmation, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(cmbRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(39, 39, 39))))
                );
                pnlRegisterContainerLayout.setVerticalGroup(
                        pnlRegisterContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlRegisterContainerLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblRegisterHeading)
                                .addGap(18, 18, 18)
                                .addGroup(pnlRegisterContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblFirstName)
                                        .addComponent(txtfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlRegisterContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblSurname)
                                        .addComponent(txtfSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlRegisterContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblUsername)
                                        .addComponent(txtfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlRegisterContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblPassword)
                                        .addComponent(pswPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlRegisterContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(pswPasswordConfirmation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblPasswordConfirmation))
                                .addGap(18, 18, 18)
                                .addGroup(pnlRegisterContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cmbRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblUserRole))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(btnRegister)
                                .addGap(67, 67, 67))
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(311, 311, 311)
                                .addComponent(pnlRegisterContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(214, 214, 214)
                                .addComponent(pnlRegisterContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(58, Short.MAX_VALUE))
                );
        }// </editor-fold>//GEN-END:initComponents


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnRegister;
        private javax.swing.JComboBox<String> cmbRoles;
        private javax.swing.JLabel lblFirstName;
        private javax.swing.JLabel lblPassword;
        private javax.swing.JLabel lblPasswordConfirmation;
        private javax.swing.JLabel lblRegisterHeading;
        private javax.swing.JLabel lblSurname;
        private javax.swing.JLabel lblUserRole;
        private javax.swing.JLabel lblUsername;
        private javax.swing.JPanel pnlRegisterContainer;
        private javax.swing.JPasswordField pswPassword;
        private javax.swing.JPasswordField pswPasswordConfirmation;
        private javax.swing.JTextField txtfFirstName;
        private javax.swing.JTextField txtfSurname;
        private javax.swing.JTextField txtfUsername;
        // End of variables declaration//GEN-END:variables
}
