import com.onitama.gui.GuiBoard;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/**
 *
 * @author Matthew Samms
 * @date December 14, 2018
 */
public class Main {
    
    /**
     * Main method to initialize the game.
     * @param args 
     */
    public static void main(String[] args) {
        Runnable r = () -> {
            GuiBoard board1 = new GuiBoard();
            JFrame f = new JFrame("Onitama");
            f.add(board1.getGui());
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setLocationByPlatform(true);
            f.pack();
            f.setMinimumSize(f.getSize());
            f.setVisible(true);
        };
        SwingUtilities.invokeLater(r);
    }
}
