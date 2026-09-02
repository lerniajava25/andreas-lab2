package org.example;

public class Triangle implements Shape {

    private final Vector3D v0;
    private final Vector3D v1;
    private final Vector3D v2;

    public Triangle(Vector3D v0, Vector3D v1, Vector3D v2) {
        this.v0 = v0;
        this.v1 = v1;
        this.v2 = v2;
    }

    @Override
    public HitResult hit(Ray ray) {

        double epsilon = 0.000001;

        Vector3D edge1 = v1.subtract(v0);
        Vector3D edge2 = v2.subtract(v0);

        Vector3D h = ray.getDirection().cross(edge2);
        double a = edge1.dot(h);

        if (a > -epsilon && a < epsilon) {
            return new HitResult(false, 0);
        }

        double f = 1.0 / a;

        Vector3D s = ray.getOrigin().subtract(v0);
        double u = f * s.dot(h);

        if (u < 0.0 || u > 1.0) {
            return new HitResult(false, 0);
        }

        Vector3D q = s.cross(edge1);
        double v = f * ray.getDirection().dot(q);

        if (v < 0.0 || u + v > 1.0) {
            return new HitResult(false, 0);
        }

        double distance = f * edge2.dot(q);

        if (distance > epsilon) {
            return new HitResult(true, distance);
        }

        return new HitResult(false, 0);
    }
}