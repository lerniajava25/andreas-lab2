package org.example;

public class Sphere implements Shape {

    private final Color color;
    private final Vector3D center;
    private final double radius;

    public Sphere(Vector3D center, double radius, Color color) {
        this.center = center;
        this.radius = radius;
        this.color = color;
    }

    public Vector3D getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public Color getColor() {
        return color;
    }

    public HitResult hit(Ray ray) {

        Vector3D originMinusCenter = ray.getOrigin().subtract(center);

        double a = ray.getDirection().dot(ray.getDirection());

        double b = 2.0 * originMinusCenter.dot(ray.getDirection());

        double c = originMinusCenter.dot(originMinusCenter) - radius * radius;

        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            return new HitResult(false, 0);
        }

        double distance1 =
                (-b - Math.sqrt(discriminant)) / (2.0 * a);

        double distance2 =
                (-b + Math.sqrt(discriminant)) / (2.0 * a);

        if (distance1 > 0) {
            return new HitResult(true, distance1);
        }

        if (distance2 > 0) {
            return new HitResult(true, distance2);
        }

        return new HitResult(false, 0);
}}