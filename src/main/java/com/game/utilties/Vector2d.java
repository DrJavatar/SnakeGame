package com.game.utilties;

public class Vector2d {

    public final static Vector2d ZERO = new Vector2d(0, 0);

    private double x;
    private double y;

    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void set(double x, double y) {
        setX(x);
        setY(y);
    }

    public Vector2d add(Vector2d pos) {
        return new Vector2d(this.x + pos.getX(), this.y + pos.getY());
    }

    public double magnitude() {
        return Math.sqrt(x * x + y * y);
    }

    public boolean collidesWith(Vector2d other) {
        double distanceX = Math.abs(x - other.x);
        double distanceY = Math.abs(y - other.y);
        double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
        return distance < (this.magnitude() + other.magnitude());
    }
}
