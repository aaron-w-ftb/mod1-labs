package oo2Graphical;

public class Ball {
    public int x, y, w, h;
    private int dirX, dirY;

    public static int worldW;
    public static int worldH;

    public Ball(int x, int y, int w, int h, int dirX, int dirY) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.dirX = dirX;
        this.dirY = dirY;
    }
    
    public Ball(int x, int y, int w, int h) {
        this(x, y, w, h, -1, -1);
    }

    public static void setWorld(int w, int h) {
        worldW = w;
        worldH = h;
    }

    public void move() {
        // Update position
        x += dirX;
        y += dirY;

        if (x < 0) {
            x = 0;
            dirX = -dirX;
        }
        if (x > worldW - w) {
            x = worldW - w;
            dirX = -dirX;
        }

        if (y < 0) {
            y = 0;
            dirY = -dirY;
        }
        if (y > worldH - h) {
            y = worldH - h;
            dirY = -dirY;
            }
    }

    public String toString() {
        return "Ball at (" + x + "," + y + ") size " + w + "x" + h + " moving (" + dirX + "," + dirY + ")";
    }
}