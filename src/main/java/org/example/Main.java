package org.example;

public class Main {

    static void main() {

        Vector3D camera = new Vector3D(0, 0, 0);
        Vector3D forward = new Vector3D(0, 0, 1);

        Ray ray = new Ray(camera, forward);

        Scene scene = new Scene();

        Sphere sphere1 = new Sphere(
                new Vector3D(0, 0, 5),
                1
        );

        Sphere sphere2 = new Sphere(
                new Vector3D(3, 0, 7),
                2
        );

        Triangle triangle = new Triangle(
                new Vector3D(-1, -1, 5),
                new Vector3D(1, -1, 5),
                new Vector3D(0, 1, 5)
        );

        scene.addShape(sphere1);
        scene.addShape(sphere2);
        scene.addShape(triangle);

        System.out.println(
                "Shapes in scene: " + scene.getShapes().size()
        );

        for (Shape shape : scene.getShapes()) {
            HitResult hitResult = shape.hit(ray);

            System.out.println("Hit: " + hitResult.isHit());
        }
    }
}