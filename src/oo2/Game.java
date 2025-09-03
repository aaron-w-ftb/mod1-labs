package oo2;

public class Game {
    private Ball[] balls;
    
    public Game() {
        Ball.setWorld(300, 300);

        balls = new Ball[3];
        balls[0] = new Ball(50, 50, 30, 30, 2, 3);
        balls[1] = new Ball(150, 100, 20, 20, -1, 2);
        balls[2] = new Ball(250, 200, 40, 40, 3, -1);
        
        System.out.println("Game initialised with world size: " + Ball.worldW + "x" + Ball.worldH);
        System.out.println("Created " + balls.length + " balls:");
        for (Ball ball : balls) {
            System.out.println("  " + ball);
        }
    }

    public void moveAllBalls() {
        for (Ball ball : balls) {
            ball.move();
        }
    }

    public void displayBalls() {
        System.out.println("Current ball positions:");
        for (int i = 0; i < balls.length; i++) {
            System.out.println("  Ball " + (i + 1) + ": " + balls[i]);
        }
        System.out.println();
    }

    public void simulate(int steps) {
        System.out.println("Starting simulation for " + steps + " steps...\n");
        
        for (int step = 1; step <= steps; step++) {
            System.out.println("Step " + step + ":");
            moveAllBalls();
            displayBalls();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Simulation interrupted");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.displayBalls();
        game.simulate(10);
    }
}