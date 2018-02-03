package orukomm.gui.dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import orukomm.data.entities.Category;
import orukomm.data.repositories.CategoryRepository;
import orukomm.gui.MainWindow;
import orukomm.logic.security.Validation;

public class AddCategory extends javax.swing.JDialog {

    private CategoryRepository categoryRepo;
    private Category category;

    public AddCategory(MainWindow parentFrame, boolean modal) {
        super(parentFrame, modal);
        categoryRepo = new CategoryRepository();
        category = new Category();
        initComponents();
        setLocationRelativeTo(null);

        // Submit event.
        btnAddCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Validation.isEmptyOrNull(txtfCategory.getText())) {
                    JOptionPane.showMessageDialog(parentFrame, "Fältet får inte vara tomt.", "Valideringsfel", JOptionPane.ERROR_MESSAGE);

                    return;
                }

                // Create category object.
                category.setCategory(txtfCategory.getText());
                categoryRepo.add(category);
                JOptionPane.showMessageDialog(parentFrame, "Kategorin lades till.", "Kategori tillagd", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });

        // Cancel event.
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        txtfCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAddCategory.doClick();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCategory = new javax.swing.JLabel();
        txtfCategory = new javax.swing.JTextField();
        btnAddCategory = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lägg till kategori");
        setResizable(false);

        lblCategory.setText("Kategori");

        btnAddCategory.setText("Lägg till");

        btnCancel.setText("Avbryt");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddCategory))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCategory)
                        .addGap(18, 18, 18)
                        .addComponent(txtfCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategory)
                    .addComponent(txtfCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddCategory)
                    .addComponent(btnCancel))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCategory;
    private javax.swing.JButton btnCancel;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JTextField txtfCategory;
    // End of variables declaration//GEN-END:variables
}
