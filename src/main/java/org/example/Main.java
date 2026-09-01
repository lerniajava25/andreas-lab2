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
}}

