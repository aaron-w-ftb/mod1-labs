package oo2Graphical;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JPanel {

    private Ball[] balls;
    private Timer animationTimer;
    
    public Game() {
        Ball.setWorld(400, 400);

        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);

        balls = new Ball[3];
        balls[0] = new Ball(50, 50, 30, 30, 2, 3);
        balls[1] = new Ball(150, 100, 20, 20, -1, 2);
        balls[2] = new Ball(250, 200, 40, 40, 3, -1);
        
        animationTimer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Ball ball : balls) {
                    ball.move();
                }
                repaint();
            }
        });
        
        System.out.println("Game initialised with world size: " + Ball.worldW + "x" + Ball.worldH);
        System.out.println("Created " + balls.length + " balls:");
        for (Ball ball : balls) {
            System.out.println("  " + ball);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);

        for (Ball ball : balls) {
            g.fillOval(ball.x, ball.y, ball.w, ball.h);
        }

        g.setColor(Color.BLACK);
        g.drawRect(0, 0, Ball.worldW - 1, Ball.worldH - 1);
    }

    public void startAnimation() {
        animationTimer.start();
    }
    
    // Method to stop the animation
    public void stopAnimation() {
        animationTimer.stop();
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Bouncing Balls - OO2 Lab");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Game gamePanel = new Game();
        frame.add(gamePanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        gamePanel.startAnimation();
        
        System.out.println("Graphical application started. Close the window to exit.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}