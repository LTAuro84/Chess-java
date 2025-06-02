import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Piece {
    public BufferedImage image;
    public int col, row;
    public int xPos, yPos;

    public Piece(BufferedImage image, int col, int row) {
        this.image = image;
        this.col = col;
        this.row = row;
        this.xPos = col * Board.SQUARE_SIZE;
        this.yPos = row * Board.SQUARE_SIZE;

    }

    public void draw(Graphics2D g2) {
        g2.drawImage(image, xPos, yPos, Board.SQUARE_SIZE, Board.SQUARE_SIZE, null);
    }
}