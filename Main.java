import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) { 
    JFrame window = new JFrame("Chess");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false); //cant resize window

    //add the gamepanel
    GamePanel gp = new GamePanel();
    window.add(gp);
    window.pack(); //the window adjusts its size to the gamepanel

    window.setLocationRelativeTo(null); //will be at the center of your monitor
    window.setVisible(true);

    gp.launchGame();

    }
} 