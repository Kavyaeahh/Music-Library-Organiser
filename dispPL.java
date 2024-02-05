
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.mysql.cj.jdbc.result.ResultSetImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author kavya
 */
public class dispPL extends javax.swing.JFrame {

    /**
     * Creates new form dispPL
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    
          Connection con;  // Declare Connection at the class level
          Statement st;
    public dispPL() throws SQLException, ClassNotFoundException {
        initComponents();
        ImageIcon icon = new ImageIcon("logo.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(lb2.getWidth(),lb2.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        lb2.setIcon(scaledIcon);
        jt1.setVisible(false);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        
            // Create connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/music", "root", "");
            st = con.createStatement();
            ResultSetImpl rs = (ResultSetImpl) st.executeQuery("show tables");
            //int rowCount = 0;
            jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.Y_AXIS));
            while (rs.next()) {
                String tableName = rs.getString(1);
                JLabel label = new JLabel(tableName);
                Font labelFont = label.getFont();
                label.setFont(new Font(labelFont.getFontName(), Font.PLAIN, 20));
                JButton button = new JButton("View " + tableName);
                button.addActionListener((ActionEvent e) -> {
                    // Add your logic for button click here
                    songPL ob = new songPL(tableName);
                    String str = tableName;
                    ob.jl2.setText(str);
                    ob.setVisible(true);
                    
                    /*try {
                        // Execute an SQL SELECT statement for the clicked table
                        try (Statement st1 = con.createStatement()) {
                            // Execute an SQL SELECT statement for the clicked table
                            String selectQuery = "select substring(song_name,1,length(song_name)-4) from" + tableName;
                            ResultSet result = (ResultSet) st1.executeQuery(selectQuery);
                            
                            // Display the data in a new panel
                            displayDataPanel(result);
                            
                            // Close the resources
                            result.close();
                        }
                    }catch (SQLException ex) {
                        ex.printStackTrace();
                    }*/
                });
                jPanel2.add(label);
                jPanel2.add(button);
            }
            SwingUtilities.invokeLater(() -> {
                try {
                    // Refresh the panel to reflect the changes
                    jPanel2.revalidate();
                    jPanel2.repaint();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });

            
             
        } catch (SQLException e) {
            // Handle the exception according to your needs
            
        } finally {
            // Close resources in the finally block
            
        }
        
    }
    private void displayDataPanel(ResultSet resultSet) throws SQLException {
        // Create a new panel to display the data
        
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new BorderLayout());

        // Create a JTextArea to display the data
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Display the data in the JTextArea
        while (resultSet.next()) {
            // Example: Append the values in the first column to the JTextArea
            textArea.append(resultSet.getString(1) + "\n");
        }

        // Add the JTextArea to the panel
        dataPanel.add(scrollPane, BorderLayout.CENTER);

        // Create a JButton to go back to the main panel
        JButton backButton = new JButton("Back to Main Panel");
        backButton.addActionListener((ActionEvent e) -> {
            // Remove the dataPanel from the frame
            jPanel2.removeAll();
            jPanel2.revalidate();
            jPanel2.repaint();
        });

        // Add the JButton to the panel
        dataPanel.add(backButton, BorderLayout.SOUTH);

        // Add the dataPanel to the frame
        jPanel2.add(dataPanel);
        jPanel2.revalidate();
        jPanel2.repaint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lb2 = new javax.swing.JLabel();
        jb1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("View All");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("View All");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jt1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Names"
            }
        ));
        jScrollPane1.setViewportView(jt1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jb1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jb1.setText("BACK");
        jb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lb2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jb1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
                .addComponent(jb1)
                .addGap(15, 15, 15))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("YOUR PLAYLISTS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(328, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb1ActionPerformed
        // TODO add your handling code here:
        MainFrame obj = new MainFrame();
        setVisible(false);
        obj.setVisibile(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_jb1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jt1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dispPL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dispPL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dispPL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dispPL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new dispPL().setVisible(true);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(dispPL.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb1;
    private javax.swing.JTable jt1;
    private javax.swing.JLabel lb2;
    // End of variables declaration//GEN-END:variables

    void setVisibile(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
