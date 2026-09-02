package org.example;

public class Sphere implements Shape {

    private final Vector3D center;
    private final double radius;

    public Sphere(Vector3D center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Vector3D getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public HitResult hit(Ray ray) {

        Vector3D originMinusCenter = ray.getOrigin().subtract(center);

        double a = ray.getDirection().dot(ray.getDirection());

        double b = 2.0 * originMinusCenter.dot(ray.getDirection());

        double c = originMinusCenter.dot(originMinusCenter) - radius * radius;

        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            return new HitResult(false, 0);
        }

        double distance =
                (-b - Math.sqrt(discriminant)) / (2.0 * a);

        return new HitResult(true, distance);
    }
}