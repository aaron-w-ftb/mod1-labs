package oo2GraphicalResize;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JPanel {

    private Ball[] balls;
    private Timer animationTimer;
    private static final int MIN_WIDTH = 200;
    private static final int MIN_HEIGHT = 200;
    
    public Game() {
        Ball.setWorld(400, 400);

        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);

        balls = new Ball[3];
        balls[0] = new Ball(50, 50, 30, 30, 2, 3);
        balls[1] = new Ball(150, 100, 20, 20, -1, 2);
        balls[2] = new Ball(250, 200, 40, 40, 3, -1);
        
        animationTimer = new Timer(4, new ActionListener() {
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
        
        int currentWidth = getWidth();
        int currentHeight = getHeight();
        
        if (currentWidth != Ball.worldW || currentHeight != Ball.worldH) {
            Ball.setWorld(currentWidth, currentHeight);
            
            for (Ball ball : balls) {
                ball.updateScale();
            }
        }
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.BLUE);

        for (Ball ball : balls) {
            g2d.fillOval((int)ball.x, (int)ball.y, (int)ball.w, (int)ball.h);
        }

        g2d.setColor(Color.BLACK);
        g2d.drawRect(0, 0, Ball.worldW - 1, Ball.worldH - 1);
    }

    public void startAnimation() {
        animationTimer.start();
    }
    
    public void stopAnimation() {
        animationTimer.stop();
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Bouncing Balls - OO2 Lab (Resizable)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Game gamePanel = new Game();
        frame.add(gamePanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setMinimumSize(new Dimension(MIN_WIDTH + 16, MIN_HEIGHT + 39));
        frame.setVisible(true);

        gamePanel.startAnimation();
        
        System.out.println("Graphical application started. Resize the window to see scaling in action!");
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