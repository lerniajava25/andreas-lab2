package org.example;

public class Main {

    static void main() {

        Vector3D camera = new Vector3D(0, 0, 0);
        Vector3D forward = new Vector3D(0, 0, 1);

        Ray ray = new Ray(camera, forward);

        Scene scene = new Scene();

        Sphere sphere1 = new Sphere(
                new Vector3D(-1.5, 0, 6),
                1,
                new Color(255, 0, 0)
        );

        Sphere sphere2 = new Sphere(
                new Vector3D(1.5, 0, 7),
                1,
                new Color(0, 0, 255)
        );

        Triangle triangle = new Triangle(
                new Vector3D(-1, -1.5, 5),
                new Vector3D(1, -1.5, 5),
                new Vector3D(0, 0.5, 5),
                new Color(0, 255, 0)
        );

        scene.addShape(sphere1);
        scene.addShape(sphere2);
        scene.addShape(triangle);

        Renderer renderer = new Renderer(200, 200);
        renderer.render(scene);

    }
}