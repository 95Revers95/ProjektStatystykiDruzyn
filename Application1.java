package client;

import java.awt.Dimension;
import java.awt.Toolkit;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.UIManager;
/**
 * Główna klasa aplikacji, dzieki ktorej mozemy zrobic wszystko co wymaga porgram. 
 * Program pozwala uzytkownikowi na zobaczenie statystyk poszczegolnych druzyn z kilku lig.
 * Mamy do wyboru ligi tj: Premier LEague, Championship, League 1, League 2, 1. Bundelsiga, 2. Bundesliga,
 * Liga BBVa, Segunda Division, Serie A, Serie B.
 * W tym programie, mozemy rowniez edytowac statystyki pilkarzy oraz ich dane osobowe. Mozemy rowniez
 * dodawac i usuwać zawodnikóœ z zespołów.
 * @author Michał Rewers
 */
public class Application1 {
    /**
     * 
     * @throws SQLException 
     */
    public Application1() throws SQLException {
       
        JFrame frame = new Login();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
           frameSize.width = screenSize.width;
        }
        frame.setLocation( ( screenSize.width - frameSize.width ) / 2, ( screenSize.height - frameSize.height ) / 2 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible(true);
        
        
    }
    /**
     * 
     * @param args
     * @throws SQLException 
     */
    public static void main(String[] args) throws SQLException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
          
        } catch (Exception e) {
            e.printStackTrace();

        }
        new Application1();
    }
}
