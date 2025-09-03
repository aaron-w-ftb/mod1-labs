package oo2GraphicalResize;

public class Ball {
    public double x, y, w, h;
    private double dirX, dirY;

    private double originalX, originalY, originalW, originalH;
    private double originalDirX, originalDirY;
    private static final int ORIGINAL_WORLD_W = 400;
    private static final int ORIGINAL_WORLD_H = 400;

    public static int worldW;
    public static int worldH;

    public Ball(int x, int y, int w, int h, int dirX, int dirY) {
        this.x = this.originalX = x;
        this.y = this.originalY = y;
        this.w = this.originalW = w;
        this.h = this.originalH = h;
        this.dirX = this.originalDirX = dirX;
        this.dirY = this.originalDirY = dirY;
    }
    
    public Ball(int x, int y, int w, int h) {
        this(x, y, w, h, -1, -1);
    }

    public static void setWorld(int w, int h) {
        worldW = w;
        worldH = h;
    }
    
    public void updateScale() {
        double scaleX = (double) worldW / ORIGINAL_WORLD_W;
        double scaleY = (double) worldH / ORIGINAL_WORLD_H;
        
        x = originalX * scaleX;
        y = originalY * scaleY;
        w = originalW * scaleX;
        h = originalH * scaleY;
        dirX = originalDirX * scaleX;
        dirY = originalDirY * scaleY;

        originalX = x;
        originalY = y;
    }

    public void move() {
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

        originalX = x;
        originalY = y;
    }

    public String toString() {
        return "Ball at (" + (int)x + "," + (int)y + ") size " + (int)w + "x" + (int)h + " moving (" + (int)dirX + "," + (int)dirY + ")";
    }
}