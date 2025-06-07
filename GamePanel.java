import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable{
    public static final int WIDTH = 1100;
    public static final int HEIGHT = 800;
    final int FPS = 60;
    Thread gameThread;
    Board board = new Board();

    // color
    public static final int WHITE = 0;
    public static final int BLACK = 1;
    int currentColor = WHITE;

    // pieces
    public static ArrayList<Piece> pieces = new ArrayList<>();
    public static ArrayList<Piece> simPieces = new ArrayList<>();


    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.black);

        setPieces();
        copyPieces(pieces, simPieces);
    }

    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();
        //basically calls the run method
    }

    public void setPieces() {

        //white team
        pieces.add(new Pawn(WHITE, 0, 6));
        pieces.add(new Pawn(WHITE, 1, 6));
        pieces.add(new Pawn(WHITE, 2, 6));
        pieces.add(new Pawn(WHITE, 3, 6));
        pieces.add(new Pawn(WHITE, 4, 6));
        pieces.add(new Pawn(WHITE, 5, 6));
        pieces.add(new Pawn(WHITE, 6, 6));
        pieces.add(new Pawn(WHITE, 7, 6));
        pieces.add(new Rook(WHITE, 0, 7));
        pieces.add(new Rook(WHITE, 7, 7));
        pieces.add(new Knight(WHITE, 1, 7));
        pieces.add(new Knight(WHITE, 6, 7));
        pieces.add(new Bishop(WHITE, 2,7));
        pieces.add(new Bishop(WHITE, 5, 7));
        pieces.add(new Queen(WHITE, 3, 7));
        pieces.add(new King(WHITE, 4, 7));

        //black team
        pieces.add(new Pawn(BLACK, 0, 6));
        pieces.add(new Pawn(BLACK, 1, 6));
        pieces.add(new Pawn(BLACK, 2, 6));
        pieces.add(new Pawn(BLACK, 3, 6));
        pieces.add(new Pawn(BLACK, 4, 6));
        pieces.add(new Pawn(BLACK, 5, 6));
        pieces.add(new Pawn(BLACK, 6, 6));
        pieces.add(new Pawn(BLACK, 7, 6));
        pieces.add(new Rook(BLACK, 0, 7));
        pieces.add(new Rook(BLACK, 7, 7));
        pieces.add(new Knight(BLACK, 1, 7));
        pieces.add(new Knight(BLACK, 6, 7));
        pieces.add(new Bishop(BLACK, 2,7));
        pieces.add(new Bishop(BLACK, 5, 7));
        pieces.add(new Queen(BLACK, 3, 7));
        pieces.add(new King(BLACK, 4, 7));


    }

    private void copyPieces(ArrayList<Piece> source, ArrayList<Piece> target) {
        target.clear();
        for (int i = 0; i < source.size(); i++) {
            target.add(source.get(i));
        }
    }

    @Override
    public void run() {

        //loop

        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTIme = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTIme) / drawInterval;
            lastTIme = currentTime;

            if (delta >= 1) {
                update();
                repaint(); //calls paintComponent method
                delta--;
            }
        }
        
    }

    private void update() {

    }

    //draws the chessboard, messages, etc...
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        board.draw(g2);

        //pieces
        for (Piece p : simPieces) {
            p.draw(g2);
        }
    }

   

}
