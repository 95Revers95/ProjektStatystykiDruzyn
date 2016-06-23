package client;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;

public class Accept extends JFrame {
    
    private Connection conn;
    private int id;
    private int idDruzyny;
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel4 = new JLabel();
    private JLabel jLabel5 = new JLabel();
    private JLabel jLabel6 = new JLabel();
    private JLabel jLabel7 = new JLabel();
    private JButton jButton1 = new JButton();
    private JTextArea jTextArea1 = new JTextArea();
    private JTextArea jTextArea3 = new JTextArea();
    private JTextArea jTextArea4 = new JTextArea();
    private JTextArea jTextArea5 = new JTextArea();
    private JTextArea jTextArea6 = new JTextArea();
    private JTextArea jTextArea7 = new JTextArea();
    private JTextArea jTextArea8 = new JTextArea();
    private JPopupMenu jPopupMenu1 = new JPopupMenu();
    private JTextArea jTextArea2 = new JTextArea();
    private JLabel jLabel8 = new JLabel();
    private JTextArea jTextArea9 = new JTextArea();
    private JTextArea jTextArea10 = new JTextArea();
    private JLabel jLabel9 = new JLabel();
    private JLabel jLabel10 = new JLabel();
    private JLabel jLabel11 = new JLabel();
    private JLabel jLabel12 = new JLabel();
    private JLabel jLabel13 = new JLabel();
    private JLabel jLabel14 = new JLabel();
    private JLabel jLabel15 = new JLabel();
    private JLabel jLabel17 = new JLabel();
    private JLabel jLabel18 = new JLabel();
    private JLabel jLabel19 = new JLabel();
    private JLabel jLabel110 = new JLabel();
    private JLabel jLabel111 = new JLabel();


    public Accept(Connection conn, Integer id, Integer idDruzyny) {
        this.conn = conn;
        this.id=id;
        this.idDruzyny=idDruzyny;
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(554, 612));
        this.setTitle( "Menu/Edycja Druzyn,Zawodnikow/Profil Druzyny/Potwierdz" );
        jLabel1.setText("Imie:");
        jLabel1.setBounds(new Rectangle(90, 10, 55, 30));
        jLabel1.setFont(new Font("Dialog", 0, 19));
        jLabel2.setText("Nazwisko:");
        jLabel2.setBounds(new Rectangle(40, 60, 105, 30));
        jLabel2.setFont(new Font("Dialog", 0, 19));
        jLabel3.setText("Data:");
        jLabel3.setBounds(new Rectangle(85, 260, 50, 30));
        jLabel3.setFont(new Font("Dialog", 0, 19));
        jLabel4.setText("Pensja:");
        jLabel4.setBounds(new Rectangle(70, 310, 105, 30));
        jLabel4.setFont(new Font("Dialog", 0, 19));
        jLabel5.setText("Gole Zdobyte:");
        jLabel5.setBounds(new Rectangle(15, 360, 185, 30));
        jLabel5.setFont(new Font("Dialog", 0, 19));
        jLabel6.setText("Gole Stracone: ");
        jLabel6.setBounds(new Rectangle(15, 410, 170, 30));
        jLabel6.setFont(new Font("Dialog", 0, 18));
        jLabel7.setText("Asysty:");
        jLabel7.setBounds(new Rectangle(70, 460, 70, 30));
        jLabel7.setFont(new Font("Dialog", 0, 19));
        jButton1.setText("ZATWIERDZ");
        jButton1.setBounds(new Rectangle(40, 500, 435, 60));
        jButton1.setFont(new Font("Dialog", 1, 22));
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    zatwierdz_actionPerformed(e);
                }
            });
        jTextArea1.setBounds(new Rectangle(145, 10, 255, 30));
        jTextArea3.setBounds(new Rectangle(145, 60, 255, 30));
        jTextArea4.setBounds(new Rectangle(145, 260, 255, 30));
        jTextArea5.setBounds(new Rectangle(145, 310, 255, 30));
        jTextArea6.setBounds(new Rectangle(145, 360, 255, 30));
        jTextArea7.setBounds(new Rectangle(145, 410, 255, 30));
        jTextArea8.setBounds(new Rectangle(145, 460, 255, 30));
        jPopupMenu1.setLabel("jPopupMenu1");
        jTextArea2.setBounds(new Rectangle(145, 110, 255, 30));
        jLabel8.setText("Kraj:");
        jLabel8.setBounds(new Rectangle(95, 110, 50, 30));
        jLabel8.setFont(new Font("Dialog", 0, 18));
        jTextArea9.setBounds(new Rectangle(145, 210, 255, 30));
        jTextArea10.setBounds(new Rectangle(145, 160, 255, 30));
        jLabel9.setText("Pozycja:");
        jLabel9.setBounds(new Rectangle(65, 160, 80, 30));
        jLabel9.setFont(new Font("Dialog", 0, 18));
        jLabel10.setText("Szczegolowa :");
        jLabel10.setBounds(new Rectangle(15, 190, 130, 65));
        jLabel10.setFont(new Font("Dialog", 0, 18));
        jLabel11.setText("Rewers");
        jLabel11.setBounds(new Rectangle(410, 5, 130, 30));
        jLabel11.setBounds(new Rectangle(420, 60, 115, 30));
        jLabel11.setFont(new Font("Dialog", 2, 17));
        jLabel12.setText("Michal");
        jLabel12.setBounds(new Rectangle(410, 5, 130, 30));
        jLabel12.setBounds(new Rectangle(420, 10, 115, 30));
        jLabel12.setFont(new Font("Dialog", 2, 17));
        jLabel13.setText("POL");
        jLabel13.setBounds(new Rectangle(410, 5, 130, 30));
        jLabel13.setBounds(new Rectangle(420, 110, 115, 30));
        jLabel13.setFont(new Font("Dialog", 2, 17));
        jLabel14.setText("POM");
        jLabel14.setBounds(new Rectangle(410, 5, 130, 30));
        jLabel14.setBounds(new Rectangle(420, 160, 115, 30));
        jLabel14.setFont(new Font("Dialog", 2, 17));
        jLabel15.setText("PP, LP");
        jLabel15.setBounds(new Rectangle(410, 5, 130, 30));
        jLabel15.setBounds(new Rectangle(420, 210, 60, 30));
        jLabel15.setFont(new Font("Dialog", 2, 17));
        jLabel17.setText("95/05/03");
        jLabel17.setBounds(new Rectangle(410, 5, 130, 30));
        jLabel17.setBounds(new Rectangle(420, 260, 115, 30));
        jLabel17.setFont(new Font("Dialog", 2, 17));
        jLabel18.setText("87000");
        jLabel18.setBounds(new Rectangle(410, 5, 130, 30));
        jLabel18.setBounds(new Rectangle(420, 310, 115, 30));
        jLabel18.setFont(new Font("Dialog", 2, 17));
        jLabel19.setText("12");
        jLabel19.setBounds(new Rectangle(410, 5, 130, 30));
        jLabel19.setBounds(new Rectangle(420, 360, 115, 30));
        jLabel19.setFont(new Font("Dialog", 2, 17));
        jLabel110.setText("0");
        jLabel110.setBounds(new Rectangle(410, 5, 130, 30));
        jLabel110.setBounds(new Rectangle(420, 410, 115, 30));
        jLabel110.setFont(new Font("Dialog", 2, 17));
        jLabel111.setText("7");
        jLabel111.setBounds(new Rectangle(410, 5, 130, 30));
        jLabel111.setBounds(new Rectangle(420, 460, 115, 30));
        jLabel111.setFont(new Font("Dialog", 2, 17));
        this.getContentPane().add(jLabel111, null);
        this.getContentPane().add(jLabel110, null);
        this.getContentPane().add(jLabel19, null);
        this.getContentPane().add(jLabel18, null);
        this.getContentPane().add(jLabel17, null);
        this.getContentPane().add(jLabel15, null);
        this.getContentPane().add(jLabel14, null);
        this.getContentPane().add(jLabel13, null);
        this.getContentPane().add(jLabel11, null);
        this.getContentPane().add(jLabel12, null);
        this.getContentPane().add(jLabel10, null);
        this.getContentPane().add(jLabel9, null);
        this.getContentPane().add(jTextArea10, null);
        this.getContentPane().add(jTextArea9, null);
        this.getContentPane().add(jLabel8, null);
        this.getContentPane().add(jTextArea2, null);
        this.getContentPane().add(jTextArea8, null);
        this.getContentPane().add(jTextArea7, null);
        this.getContentPane().add(jTextArea6, null);
        this.getContentPane().add(jTextArea5, null);
        this.getContentPane().add(jTextArea4, null);
        this.getContentPane().add(jTextArea3, null);
        this.getContentPane().add(jTextArea1, null);
        this.getContentPane().add(jLabel11, null);
        this.getContentPane().add(jButton1, null);
        this.getContentPane().add(jLabel7, null);
        this.getContentPane().add(jLabel6, null);
        this.getContentPane().add(jLabel5, null);
        this.getContentPane().add(jLabel4, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(jLabel1, null);
    }

    private void zatwierdz_actionPerformed(ActionEvent e) {
        
        try {
            Statement sql_stmt;
            sql_stmt = conn.createStatement();
            String imie = jTextArea1.getText();
            String nazwisko = jTextArea3.getText();
            String kraj = jTextArea2.getText();
            String data = jTextArea4.getText();
            String pensja = jTextArea5.getText();
            String g_zd = jTextArea6.getText();
            String g_st = jTextArea7.getText();
            String asysty = jTextArea8.getText();
            String pozycja = jTextArea10.getText();
            String pozycja_sz = jTextArea9.getText();
            String sql = "INSERT INTO Pilkarze VALUES("+id+", "+ idDruzyny + ",  "
                                                + "'"+imie+ "'"  + ", "  + "'"+ nazwisko+ "'"   + ", " 
                                                +  "'"+ kraj+ "'"  + ","  + "'"+ data + "'"  + ", "
                                                + pensja  + ", "+ "'"+ pozycja+ "'"+ ", "+ "'"+ pozycja_sz+ "'"+ ","  + g_zd  + ", "
                                                + g_st  + ", " + asysty +")";
            System.out.println(sql);
            sql_stmt.executeUpdate(sql);
            sql_stmt.close();
            
        } catch (SQLException fgh) {
            System.out.println(fgh.getMessage());
        }
        this.setVisible(false);
        
    }
}
