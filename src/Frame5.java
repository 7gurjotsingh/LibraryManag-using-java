/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Windows
 */
public class Frame5 extends javax.swing.JInternalFrame {

    /**
     * Creates new form Frame5
     */
    public Frame5() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        usrnm = new javax.swing.JTextField();
        Login = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        searchNew = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        passwww = new javax.swing.JPasswordField();

        setClosable(true);
        setTitle("Student Portal");

        jLabel1.setText("Enter the Login Details");

        jLabel2.setText("Username/Roll No");

        Login.setText("Search");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        searchNew.setText("New");
        searchNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchNewActionPerformed(evt);
            }
        });

        jLabel3.setText("Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usrnm)
                            .addComponent(passwww, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(searchNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Login)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(usrnm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passwww, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Login)
                    .addComponent(searchNew))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        // TODO add your handling code here:
        username = usrnm.getText();
        password=passwww.getText();
         int i = 1 ;
            
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","");
            System.out.println("True");
            Statement St = cn.createStatement() ;
            String my ="SELECT * FROM studentinfo;";
            ResultSet rs = St.executeQuery(my);     
            while(rs.next()){
                if(rs.getString(1).equals(username)&&rs.getString(2).equals(password)){
                    i=0;
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        if(i==0){
        try{
           Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","");
            System.out.println("True");
            Statement St = cn.createStatement() ;
            String my ="SELECT * FROM studentdata WHERE RollNo = '"+username+"';";
            ResultSet rs = St.executeQuery(my);
            jTextArea1.setEditable(false);
            usrnm.setEditable(false);
            while(rs.next()){
                jTextArea1.setText(" Name \t "+rs.getString(2)+"\n Book 1 \t "+rs.getString(3)+"\n Book 2 \t "+rs.getString(4)+"\n Book 3 \t "+rs.getString(5)+"\n Book 4 \t "+rs.getString(6)+"\n Book 5 \t "+rs.getString(7)+"\n Date of Issue \t "+rs.getString(8));
          }
            Login.setVisible(false);
        }
        catch(Exception e){
            System.out.println(e);
        }}
        else{
            jTextArea1.setText("Try Again!!!!");
        }
        
    }//GEN-LAST:event_LoginActionPerformed

    private void searchNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchNewActionPerformed
        // TODO add your handling code here:
        usrnm.setEditable(true);
        usrnm.setText("");
        Login.setVisible(true);
        jTextArea1.setText("");
    }//GEN-LAST:event_searchNewActionPerformed
    
    String [] valid = new String [10];
        String [] pass = new String [10];
    String username;
    String password;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPasswordField passwww;
    private javax.swing.JButton searchNew;
    private javax.swing.JTextField usrnm;
    // End of variables declaration//GEN-END:variables
}
