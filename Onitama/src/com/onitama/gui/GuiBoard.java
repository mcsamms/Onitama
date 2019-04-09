package com.onitama.gui;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.border.*;
import java.net.URL;
import javax.imageio.ImageIO;
import com.onitama.engine.*;
import static java.util.Collections.list;
/**
 *
 * @author Matthew Samms
 */
public class GuiBoard implements MouseListener {
    
    private final int SIZE = 80;
    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JPanel cards;
    private JButton[][] boardSquares = new JButton[5][5];
    private Image[][] pieceImages = new Image[2][2];
    private JPanel board;
    private final JLabel message = new JLabel(
            "Enter a message to display");
    private static final String COLS = "ABCDE";
    
    public static final int STUDENT = 0, MASTER = 1;
    public static final int[] STARTING_ROW = {
        STUDENT, STUDENT, MASTER, STUDENT, STUDENT
    };
    public static final int RED = 0, GREEN = 1;
    private Card[] list;

    public GuiBoard() {
        initializeGui();
    }

    public final void initializeGui() {
        // Pulls the images and coverts them to a usable format
        createImages();

        // set up the main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        Action newGameAction = new AbstractAction("New") {

            @Override
            public void actionPerformed(ActionEvent e) {
                setupNewGame();
            }
        };
        tools.add(newGameAction);
        tools.add(new JButton("Save"));
        tools.addSeparator();
        tools.add(new JButton("Resign"));
        tools.addSeparator();
        tools.add(message);
        
        cards = new JPanel();
        cards.setLayout(new GridLayout(3,3));
        cards.setOpaque(true);
        cards.setBackground(Color.WHITE);
        

        gui.add(new JLabel("Card Goes here", JLabel.LEFT), BorderLayout.SOUTH);

        board = new JPanel(new GridLayout(0, 6)) {
            
            // This resizes the board to the window.
            @Override
            public final Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                Dimension prefSize = null;
                Component c = getParent();
                if (c == null) {
                    prefSize = new Dimension(
                            (int)d.getWidth(),(int)d.getHeight());
                } else if (c!=null &&
                        c.getWidth()>d.getWidth() &&
                        c.getHeight()>d.getHeight()) {
                    prefSize = c.getSize();
                } else {
                    prefSize = d;
                }
                int w = (int) prefSize.getWidth();
                int h = (int) prefSize.getHeight();
                // if the width is greater than the height get the oposite
                // this allows width and height to be sized correctly and
                // passed as new dimensions.
                int s = (w>h ? h : w);
                return new Dimension(s,s);
            }
        };
        board.setBorder(new CompoundBorder(
                new EmptyBorder(5,5,5,5),
                new LineBorder(Color.BLACK)
                ));
        Color backgroundColor = new Color(0xf5544e);
        board.setBackground(new Color(255,255,255));
        JPanel boardConstrain = new JPanel(new GridBagLayout());
        boardConstrain.setBackground(backgroundColor);
        boardConstrain.add(board);
        gui.add(boardConstrain);

        // create the board squares
        Insets buttonMargin = new Insets(0, 0, 0, 0);
        for (int i = 0; i < boardSquares.length; i++) {
            for (int j = 0; j < boardSquares[i].length; j++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);

                // Sets the image side for the incoming images.
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(SIZE, SIZE, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                
                // Setting the background colour of the tiles.
                if ((j % 2 == 1 && i % 2 == 1)
                        || (j % 2 == 0 && i % 2 == 0)) {
                    b.setBackground(Color.WHITE);
                } else {
                    b.setBackground(Color.GRAY);
                }
                boardSquares[j][i] = b;
            }
        }

        /*
         * fill the game board
         */
        board.add(new JLabel(""));
        for (int i = 0; i < 5; i++) {
            board.add(
                    // Prints the letters around the board
                    new JLabel(COLS.substring(i, i + 1),
                    SwingConstants.CENTER));
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                switch (j) {
                    case 0:
                        // Prints the numbers on the board
                        board.add(new JLabel("" + (5-(i + 1)),
                                SwingConstants.CENTER));
                    default:
                        board.add(boardSquares[j][i]);
                }
            }
        }
    }
    
    /**
     * Gets the gui element set in initializeGui()
     * @return Returns the GUI
     */
    public final JComponent getGui() {
        return gui;
    }

    /**
     * Pulls images from the Internet and parses them using the
     * BufferedImage ImageIO reader.
     */
    private final void createImages() {
        try {
            URL redMaster = new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2d/Chess_krt45.svg/200px-Chess_krt45.svg.png");
            URL greenMaster = new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/Chess_kgt45.svg/200px-Chess_kgt45.svg.png");
            URL redStudent = new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f8/Chess_prt45.svg/200px-Chess_prt45.svg.png");
            URL greenStudent = new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/Chess_pgt45.svg/200px-Chess_pgt45.svg.png");
            BufferedImage biRM = ImageIO.read(redMaster);
            BufferedImage biGM = ImageIO.read(greenMaster);
            BufferedImage biRS = ImageIO.read(redStudent);
            BufferedImage biGS = ImageIO.read(greenStudent);
            pieceImages[0][1] = biRM.getScaledInstance(SIZE, SIZE, Image.SCALE_SMOOTH);
            pieceImages[1][1] = biGM.getScaledInstance(SIZE, SIZE, Image.SCALE_SMOOTH);
            pieceImages[0][0] = biRS.getScaledInstance(SIZE, SIZE, Image.SCALE_SMOOTH);
            pieceImages[1][0] = biGS.getScaledInstance(SIZE, SIZE, Image.SCALE_SMOOTH);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Sets up the game board when the new game button is clicked.
     * Can be set up for varying board sizes if the starting row is changed
     */
    private final void setupNewGame() {
        message.setText("A new game has started!");
        // set up the red player
        // 
        for (int i = 0; i < STARTING_ROW.length; i++) {
            boardSquares[i][0].setIcon(
                    new ImageIcon(pieceImages[RED][STARTING_ROW[i]]));
        }
        // set up the green player
        for (int i = 0; i < STARTING_ROW.length; i++) {
            boardSquares[i][4].setIcon(
                    new ImageIcon(pieceImages[GREEN][STARTING_ROW[i]]));
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
