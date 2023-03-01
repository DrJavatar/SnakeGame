package com.game.utilties;

public class Vector2d {
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
