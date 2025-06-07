import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Piece {
    public BufferedImage image;
    public int col, row, preCol, preRow;
    public int color;
    public int x, y;

    public Piece(int color, int col, int row) {
        this.color = color;
        this.col = col;
        this.row = row;
        x = getX(col);
        y = getY(row);
        preCol = col;
        preRow = row;

    }

    public BufferedImage getImage(String imagePath) {
    String fullPath = imagePath + ".png";
    System.out.println("Trying to load: " + fullPath);  // Debug

    try {
        InputStream stream = getClass().getResourceAsStream(fullPath);
        if (stream == null) {
            System.err.println("ERROR: Resource not found: " + fullPath);
            return null;
        }
        return ImageIO.read(stream);
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
}

    public int getX(int col) {
        return col * Board.SQUARE_SIZE;
    }

    public int getY(int row) { 
        return row * Board.SQUARE_SIZE;
    }
    
    public void draw(Graphics2D g2) {
        g2.drawImage(image, x, y, Board.SQUARE_SIZE, Board.SQUARE_SIZE, null);
    }

}