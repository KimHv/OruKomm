/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orukomm.gui.panels;

import java.awt.Cursor;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import orukomm.data.FileStorage;

/**
 *
 * @author Pontu
 */
public class DisplayPostInformal extends javax.swing.JPanel {

    private static String bildURL;
    private static String textPost;
    private static String title;
    private static String fileName;
    private static String fileName2;
    private static String fileName3;
    private ImageIcon attachedImage;
    private FileStorage fs = new FileStorage();
    private ArrayList<String> fileNames = new ArrayList<String>();
    private InformalFeed iff;
    private ImageIcon image;
    private ChangePost chp;


    /**
     * Creates new form CreatedPost
     */
    public DisplayPostInformal(InformalFeed feed, String textPost, String title) throws IOException {
        initComponents();
        // bildURL = CreatePost.getBildURL();
        // fileName = CreatePost.getFileURL();
        // fileName2 = CreatePost.getFileURL2();
        // fileURL3 = CreatePost.getFileURL3();  

        
        
        this.iff = feed;
        
        this.textPost = textPost;

        this.fileNames = iff.getFileName();
        this.title = title;
        
        setTxtHeadingPost();
        setTxtCreatedPost();
        setAttachedFilesTxt();

        txtUserOutput.setEditable(false);

        txtUserOutput.setLineWrap(true);

        txtUserOutput.setWrapStyleWord(true);

    }
    
    public DisplayPostInformal(ChangePost feed, String textPost, String title) throws IOException {
        initComponents();
        // bildURL = CreatePost.getBildURL();
        // fileName = CreatePost.getFileURL();
        // fileName2 = CreatePost.getFileURL2();
        // fileURL3 = CreatePost.getFileURL3();  

        //paintPicture(lblDisplay);
        this.chp = feed;
        this.textPost = textPost;
        setTxtCreatedPost();
        fileNames = chp.getFileName();
        this.title = title;
        setTxtHeadingPost();

        setAttachedFilesTxt();

        txtUserOutput.setEditable(false);

        txtUserOutput.setLineWrap(true);

        txtUserOutput.setWrapStyleWord(true);

    }

    private void setTxtCreatedPost() {
        txtUserOutput.setText(textPost);

    }

    public void setTxtHeadingPost() {
        lblHeading.setText(title);

    }     
     
    public void paintPicture(JLabel label) throws IOException {
        resizeImage(label);
        label.setIcon(image);
    }

    private ImageIcon resizeImage(JLabel label1) throws IOException {
        ImageIcon MyImage = iff.selectImage();
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label1.getWidth(), label1.getHeight(), Image.SCALE_SMOOTH);
        image = new ImageIcon(newImg);
        return image;
    }

    private void setAttachedFilesTxt() {

        if (fileNames.size() == 1) {
            lblURL1.setText(fileNames.get(0));
            lblBifogad1.setText("Bifogad fil1: ");
            
            lblURL1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        if (fileNames.size() == 2) {
            lblURL1.setText(fileNames.get(0));
            lblURL2.setText(fileNames.get(1));
            
            lblBifogad1.setText("Bifogad fil1: ");
            lblBifogad2.setText("Bifogad fil2: ");
            
            lblURL1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            lblURL2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        if (fileNames.size() == 3) {
            lblURL1.setText(fileNames.get(0));
            lblURL2.setText(fileNames.get(1));
            lblURL3.setText(fileNames.get(2));
            
            lblBifogad1.setText("Bifogad fil1: ");
            lblBifogad2.setText("Bifogad fil2: ");
            lblBifogad3.setText("Bifogad fil3: ");
            
            lblURL1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            lblURL2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            lblURL3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }              
        
        

    }

    /**
     * /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDisplay = new javax.swing.JLabel();
        lblHeading = new javax.swing.JLabel();
        lblBifogad1 = new javax.swing.JLabel();
        lblBifogad3 = new javax.swing.JLabel();
        lblURL1 = new javax.swing.JLabel();
        lblURL2 = new javax.swing.JLabel();
        lblURL3 = new javax.swing.JLabel();
        lblBifogad2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtUserOutput = new javax.swing.JTextArea();
        btnImage = new javax.swing.JButton();

        lblHeading.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblHeading.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblURL1.setForeground(new java.awt.Color(0, 0, 255));
        lblURL1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblURL1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblURL1MouseClicked(evt);
            }
        });

        lblURL2.setForeground(new java.awt.Color(0, 0, 255));
        lblURL2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblURL3.setForeground(new java.awt.Color(0, 0, 255));
        lblURL3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtUserOutput.setColumns(20);
        txtUserOutput.setRows(5);
        jScrollPane1.setViewportView(txtUserOutput);

        btnImage.setText("Visa Bild");
        btnImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblBifogad2)
                                .addGap(18, 18, 18)
                                .addComponent(lblURL2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblBifogad1)
                                .addGap(18, 18, 18)
                                .addComponent(lblURL1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblBifogad3)
                                .addGap(18, 18, 18)
                                .addComponent(lblURL3, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 183, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnImage)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblBifogad1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblURL1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblBifogad2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblURL2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblBifogad3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblURL3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblURL1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblURL1MouseClicked
        iff.chooseDirectory();
    }//GEN-LAST:event_lblURL1MouseClicked

    private void btnImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImageActionPerformed
        try {
            paintPicture(lblDisplay);
        } catch (IOException ex){
            Logger.getLogger(DisplayPostInformal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException n){
            JOptionPane.showMessageDialog(null, "Ingen bild att visa");
        }
    }//GEN-LAST:event_btnImageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImage;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBifogad1;
    private javax.swing.JLabel lblBifogad2;
    private javax.swing.JLabel lblBifogad3;
    private javax.swing.JLabel lblDisplay;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblURL1;
    private javax.swing.JLabel lblURL2;
    private javax.swing.JLabel lblURL3;
    private javax.swing.JTextArea txtUserOutput;
    // End of variables declaration//GEN-END:variables
}
