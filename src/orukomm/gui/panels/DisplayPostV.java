/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orukomm.gui.panels;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import orukomm.data.FileStorage;
import orukomm.gui.panels.FormalFeed;

/**
 *
 * @author Pontu
 */
public class DisplayPostV extends javax.swing.JPanel {

    private static String bildURL;
    private static String textPost;
    private static String title;
    private static String fileName;
    private static String fileName2;
    private static String fileName3;
    private static ImageIcon attachedImage;
    private FileStorage fs = new FileStorage();
    private ArrayList<String> fileNames = new ArrayList<String>();
    private JPanel panel;

    /**
     * Creates new form CreatedPost
     */
    
    
    
     
     public DisplayPostV(JPanel panel, String textPost, String title) throws IOException {
        initComponents();
        // bildURL = CreatePost.getBildURL();
        // fileName = CreatePost.getFileURL();
        // fileName2 = CreatePost.getFileURL2();
        // fileURL3 = CreatePost.getFileURL3();      

        fileNames = fs.getFileName();        

        //paintPicture(lblDisplay);
        this.panel = panel;
        this.textPost = textPost;
        setTxtCreatedPost();

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

    public void paintPicture(JLabel label) {
        resizeImage(label);
        label.setIcon(attachedImage);
    }

    private ImageIcon resizeImage(JLabel label1) {
        ImageIcon MyImage = new ImageIcon(bildURL);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label1.getWidth(), label1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    private void setAttachedFilesTxt() {

        for (int i = 0; i < fileNames.size(); i++) {
            lblURL1.setText(fileNames.get(0));
           
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

        lblHeading.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblHeading.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblBifogad1.setText("Bifogad fil 1:");

        lblBifogad3.setText("Bifogad fil 3:");

        lblURL1.setForeground(new java.awt.Color(0, 0, 255));
        lblURL1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblURL1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblURL1MouseClicked(evt);
            }
        });

        lblURL2.setForeground(new java.awt.Color(0, 0, 255));
        lblURL2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblURL3.setForeground(new java.awt.Color(0, 0, 255));
        lblURL3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblBifogad2.setText("Bifogad fil 2:");

        txtUserOutput.setColumns(20);
        txtUserOutput.setRows(5);
        jScrollPane1.setViewportView(txtUserOutput);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblHeading, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                                .addGap(12, 12, 12))))
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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblURL1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblURL1MouseClicked
        fs.chooseDirectory();
    }//GEN-LAST:event_lblURL1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
