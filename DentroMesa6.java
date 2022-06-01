import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Vinicius
 */
public class DentroMesa6 extends javax.swing.JFrame {

    /**
     * Creates new form DentroMesa6
     */
    public DentroMesa6() {
        initComponents();
    }                      
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        DentroMesa6 = new javax.swing.JTable();
        txtMesa6 = new javax.swing.JLabel();
        btPagar6 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableItensMenu6 = new javax.swing.JTable();
        btAdd6 = new javax.swing.JButton();
        txtItemDaMesa6 = new javax.swing.JLabel();
        txtItemDoMenu = new javax.swing.JLabel();
        btVoltar6 = new javax.swing.JButton();
        
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DentroMesa6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(DentroMesa6);

        txtMesa6.setText("Mesa 6 :");

        btPagar6.setText("PAGAR");
        btPagar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPagar6ActionPerformed(evt);
            }
        });

        tableItensMenu6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tableItensMenu6);

        btAdd6.setText("ADICIONAR ");
        btAdd6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdd6ActionPerformed(evt);
            }
        });

        txtItemDaMesa6.setText("Itens da mesa :");

        txtItemDoMenu.setText("Itens do menu :");

        btVoltar6.setText("Voltar");
        btVoltar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltar6(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtMesa6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btAdd6, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(txtItemDoMenu))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtItemDaMesa6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btVoltar6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btPagar6, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMesa6)
                    .addComponent(btVoltar6))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtItemDoMenu)
                    .addComponent(txtItemDaMesa6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPagar6)
                    .addComponent(btAdd6))
                .addContainerGap(18, Short.MAX_VALUE))
        );


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurante_login","root","Vinivini14!");
            java.sql.Statement st = con.createStatement();
            String query="select * from mesa6";
            ResultSet rs=st.executeQuery(query);
            java.sql.ResultSetMetaData rsmd=rs.getMetaData();
        
            DefaultTableModel model= (DefaultTableModel) DentroMesa6.getModel();
            
            int cols = 1;
            String[] colName=new String[cols];
            for(int i=0;i<cols;i++)
                colName[i]=rsmd.getColumnName(i+1);
            model.setColumnIdentifiers(colName);
        
            String item;
            while(rs.next()) {
                item=rs.getString(1);
                String[] row= {item};
                model.addRow(row);
                
            }
        
            con.close();
            } 
            catch (ClassNotFoundException | SQLException e1){
                
            }


            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurante_login","root","Vinivini14!");
                java.sql.Statement st = con.createStatement();
                String query="select * from menu";
                ResultSet rs=st.executeQuery(query);
                java.sql.ResultSetMetaData rsmd=rs.getMetaData();
            
                DefaultTableModel model= (DefaultTableModel) tableItensMenu6.getModel();
                
                int cols = 1;
                String[] colName=new String[cols];
                for(int i=0;i<cols;i++)
                    colName[i]=rsmd.getColumnName(i+1);
                model.setColumnIdentifiers(colName);
            
                String item;
                while(rs.next()) {
                    item=rs.getString(1);
                    String[] row= {item};
                    model.addRow(row);
                    
                }
                con.close();
                
                } 
                catch (ClassNotFoundException | SQLException e1){
                }
                    
        

        pack();
    }                

    private void btPagar6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurante_login","root","Vinivini14!");
            java.sql.Statement st = con.createStatement();
            String query= "SELECT ROUND(SUM(preco), 2) FROM mesa6;";
            ResultSet rs=st.executeQuery(query);
           while(rs.next()){
               Float valorMesa6 = rs.getFloat(1);
               JOptionPane.showMessageDialog(this, "Valor a ser pago:R$"+valorMesa6+"!");
               String query2 = "TRUNCATE mesa6;";
               st.executeUpdate(query2);
               DentroMesa6 mesa6 = new DentroMesa6();
                       mesa6.show();
                       dispose();
           }
            
            con.close();

        }
        catch (ClassNotFoundException | SQLException e1){
            System.out.println(e1);




        
    }       
}

    private void btVoltar6(java.awt.event.ActionEvent evt){
        HomePage home = new HomePage();
            home.show();
            dispose();
            }

    



    private void btAdd6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        int index = tableItensMenu6.getSelectedRow();
        String selectedRowFromTbMenu6 = (String) tableItensMenu6.getValueAt(index, 0);
        

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurante_login","root","Vinivini14!");
            java.sql.Statement st = con.createStatement();
            String query= "INSERT INTO mesa6 SELECT item,preco FROM menu WHERE item='"+selectedRowFromTbMenu6+"';";
            st.executeUpdate(query);
            
            

        }
        catch (ClassNotFoundException | SQLException e1){
            System.out.println(e1);
        }
        DentroMesa6 mesa6 = new DentroMesa6();
        mesa6.show();
        dispose();
    }


 
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DentroMesa6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DentroMesa6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DentroMesa6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DentroMesa6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DentroMesa6().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btPagar6;
    private javax.swing.JButton btVoltar6; 
    private javax.swing.JTable tableItensMenu6;
    private javax.swing.JButton btAdd6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable DentroMesa6;
    private javax.swing.JLabel txtItemDaMesa6;
    private javax.swing.JLabel txtItemDoMenu;
    private javax.swing.JLabel txtMesa6;
    // End of variables declaration                   
}