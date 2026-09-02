package org.example;

public class HitResult {

    private final boolean hit;
    private final double distance;

    public HitResult(boolean hit, double distance) {
        this.hit = hit;
        this.distance = distance;
    }

    public boolean isHit() {
        return hit;
    }

    public double getDistance() {
        return distance;
    }
}