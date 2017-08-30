package kmitl.lab03.benjarat58070079.simplemydot.model;


import android.graphics.Color;

import java.util.Random;

public class Dot {

    public interface OnDotChangedListener{
        void onDotChanged(Dot dot);
    }

    public void setListener(OnDotChangedListener listener) {
        this.listener = listener;
    }

    private OnDotChangedListener listener;

    private float centerX;
    private float centerY;
    private int radius;
    private int color;

    public Dot(OnDotChangedListener listener, float centerX, float centerY, int radius, int color) {
        this.listener = listener;
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.color = color;
        this.listener.onDotChanged(this);
    }

//    public Dot(int centerX, int centerY, int radius) {
//        this.centerX = centerX;
//        this.centerY = centerY;
//        this.radius = radius;
//        this.listener.onDotChanged(this);
//
//    }

    public float getCenterX() {
        return centerX;
    }

    public void setCenterX(float centerX) {
        this.centerX = centerX;
        this.listener.onDotChanged(this);
    }

    public float getCenterY() {
        return centerY;
    }

    public void setCenterY(float centerY) {
        this.centerY = centerY;
        this.listener.onDotChanged(this);
    }

    public int getColor() {
        return color;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
