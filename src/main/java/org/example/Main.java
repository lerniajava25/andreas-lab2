package org.example;

public class Main {
    static void main() {
        Vector3D position = new Vector3D(2, 3, 5);

        System.out.println("X: " + position.getX());
        System.out.println("Y: " + position.getY());
        System.out.println("Z: " + position.getZ());

    Vector3D camera = new Vector3D(0, 0, 0);
    Vector3D sphere = new Vector3D(0, 0, 5);

    Vector3D difference = sphere.subtract(camera);

System.out.println("X: " + difference.getX());
System.out.println("Y: " + difference.getY());
System.out.println("Z: " + difference.getZ());

        Vector3D forward = new Vector3D(0, 0, 1);

        Ray ray = new Ray(camera, forward);

        System.out.println("Origin Z: " + ray.getOrigin().getZ());
        System.out.println("Direction Z: " + ray.getDirection().getZ());


        Sphere sphereObject = new Sphere(
                new Vector3D(5, 0, 5),
                1
        );

        HitResult result = sphereObject.hit(ray);

        System.out.println("Sphere hit: " + result.isHit());
        System.out.println("Distance: " + result.getDistance());




}}

