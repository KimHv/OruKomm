/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orukomm.gui.panels;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import orukomm.data.FileStorage;
import orukomm.data.entities.Post;
import orukomm.data.repositories.PostRepository;
import orukomm.gui.MainWindow;

/**
 *
 * @author Ludvig
 */
public class ChangePost extends javax.swing.JPanel {

    /**
     * Creates new form FormalFeed
     */
    private ArrayList<Post> posts;
    
    private static String bildURL;
    private static String fileURL;
    private static String fileURL2;
    private static String fileURL3;
    private String title;
    private String description;
    private int post_id;
    DisplayPostV2 dsv;
    DisplayPostFormal formal;
    DisplayPostInformal informal;
    FileStorage fs = new FileStorage();
    
    public ChangePost(MainWindow parentFrame) {
        try {
            //this.dsv = new DisplayPostV2(pnlPost, description, title, post_id);
            this.formal = new DisplayPostFormal((this), description, title);
            this.informal = new DisplayPostInformal((this), description, title);
            initComponents();
            initPanels();
        } catch (IOException ex) {
            Logger.getLogger(ChangePost.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void initPanels() {
		pnlPost.setVisible(true);
	}
    
    public void switchPanel(JPanel panel) {
		pnlPost.removeAll();
		pnlPost.repaint();
		pnlPost.revalidate();
		pnlPost.add(panel);
		pnlPost.repaint();
		pnlPost.revalidate();
	}
    
  

    public void fillTable() {
        

        DefaultTableModel model = (DefaultTableModel) tblFormalFeed.getModel();  //Typecastar JTablemodellen till en DefaultTableModel
        Object[] row = new Object[4];    // Använder Object klassen så att Arrayn kan ta in vilka object som helst
        for (int i = 0; i < posts.size(); i++) {
            row[0] = posts.get(i).getTitle();
            row[1] = posts.get(i).getUsername();
            row[2] = posts.get(i).getDate();
            //row[3] = posts.get(i).getId(); //Ska tas bort när vi hittar lösning på hur vi hämtar ut post ID till attachments
            model.addRow(row);
        }

    }
    
    public void clearTable()
    {
     DefaultTableModel model = (DefaultTableModel) tblFormalFeed.getModel();
     model.setRowCount(0);
    }
    
    public int getPostId(){
        return post_id;
    }
    
    private void selectPost(){
        int columnTitle = 0;
        int columnPoster = 1;
        
        int columnId = 3; //Ska tas bort när vi hittar lösning på hur vi hämtar ut post ID till attachments
        
        int row = tblFormalFeed.getSelectedRow();
        title = tblFormalFeed.getModel().getValueAt(row, columnTitle).toString();
        String poster = tblFormalFeed.getModel().getValueAt(row, columnPoster).toString();
        description = "";
        String stringId = tblFormalFeed.getModel().getValueAt(row, columnId).toString();
        
        post_id = Integer.parseInt(stringId); //Ska tas bort när vi hittar lösning på hur vi hämtar ut post ID till attachments
        
        for (Post post : posts) {
            if (post.getUsername().equals(poster) && post.getTitle().equals(title)) {
                description = post.getDescription();
            }
        }
        try {
            switchPanel(new DisplayPostV2((this), description, title, post_id));
        } catch (IOException ex) {
            Logger.getLogger(ChangePost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void chooseDirectory() {

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Choose destination");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
            fs.selectFile(getPostId(), chooser.getSelectedFile().toString()+"\\");
        } else {
            System.out.println("No Selection ");
        }
    }

    public ArrayList<String> getFileName() {
        FileStorage fs = new FileStorage();               

        ArrayList<String> fileNames = new ArrayList<String>();

        String selectSQL = ("SELECT name FROM attachments WHERE post_id = ?");
        try (Connection conn = fs.connect();
                PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {

            pstmt.setInt(1, getPostId());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){

                fileNames.add(rs.getString("name"));               
                           }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return fileNames;
    }
    
        
        
    

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupFeed = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFormalFeed = new javax.swing.JTable();
        pnlPost = new javax.swing.JPanel();
        rbtnFormal = new javax.swing.JRadioButton();
        rbtnInformal = new javax.swing.JRadioButton();

        tblFormalFeed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titel", "Författare", "Datum", "ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFormalFeed.getTableHeader().setReorderingAllowed(false);
        tblFormalFeed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFormalFeedMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFormalFeed);
        if (tblFormalFeed.getColumnModel().getColumnCount() > 0) {
            tblFormalFeed.getColumnModel().getColumn(0).setResizable(false);
            tblFormalFeed.getColumnModel().getColumn(1).setResizable(false);
            tblFormalFeed.getColumnModel().getColumn(2).setResizable(false);
            tblFormalFeed.getColumnModel().getColumn(3).setResizable(false);
        }

        pnlPost.setLayout(new java.awt.CardLayout());

        btnGroupFeed.add(rbtnFormal);
        rbtnFormal.setText("Formella inlägg");
        rbtnFormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnFormalActionPerformed(evt);
            }
        });

        btnGroupFeed.add(rbtnInformal);
        rbtnInformal.setText("Informella inlägg");
        rbtnInformal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnInformalActionPerformed(evt);
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
                        .addComponent(rbtnFormal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnInformal))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlPost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(445, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnFormal)
                    .addComponent(rbtnInformal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlPost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(188, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblFormalFeedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFormalFeedMouseClicked
        selectPost();     
      
    }//GEN-LAST:event_tblFormalFeedMouseClicked

    private void rbtnFormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnFormalActionPerformed
        clearTable();
        PostRepository pr = new PostRepository();
            this.posts = pr.fillListFormal();
            fillTable();
    }//GEN-LAST:event_rbtnFormalActionPerformed

    private void rbtnInformalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnInformalActionPerformed
        clearTable();
        PostRepository pr = new PostRepository();
            this.posts = pr.fillListInformal();
            fillTable();
    }//GEN-LAST:event_rbtnInformalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupFeed;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlPost;
    private javax.swing.JRadioButton rbtnFormal;
    private javax.swing.JRadioButton rbtnInformal;
    public javax.swing.JTable tblFormalFeed;
    // End of variables declaration//GEN-END:variables
}
