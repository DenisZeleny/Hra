package Hra.entita;

import java.awt.*;

public class Entita {
    protected double x, y;
    private int  width, height;
    private boolean isAlive;

    public Entita(double x, double y, int width, int height, boolean isAlive) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isAlive = isAlive;
    }


    public void draw(Graphics g){}

    public Rectangle getBounds() {return new Rectangle((int)x, (int)y, width, height);}

    public int getX() {return (int) x;}

    public void setX(int x) {this.x = x;}

    public int getY() {return (int) y;}

    public void setY(int y) {this.y = y;}

    public int getWidth() {return width;}

    public void setWidth(int width) {this.width = width;}

    public int getHeight() {return height;}

    public void setHeight(int height) {this.height = height;}

    public boolean isAlive() {return isAlive;}

    public void setAlive(boolean alive) {isAlive = alive;}
}
