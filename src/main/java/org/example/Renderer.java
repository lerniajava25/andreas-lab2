package org.example;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Renderer {

    private final int width;
    private final int height;

    public Renderer(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void render(Scene scene) {

        BufferedImage image = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_RGB
        );

        Vector3D camera = new Vector3D(0, 0, 0);

        for (int y = 0; y < height; y++) {

            for (int x = 0; x < width; x++) {

                double viewportX = (x - width / 2.0) / width;
                double viewportY = (height / 2.0 - y) / height;

                Vector3D direction = new Vector3D(
                        viewportX,
                        viewportY,
                        1
                );

                Ray ray = new Ray(camera, direction);

                double closestDistance = Double.MAX_VALUE;
                Shape closestShape = null;

                for (Shape shape : scene.getShapes()) {

                    HitResult hitResult = shape.hit(ray);

                    if (hitResult.isHit()
                            && hitResult.getDistance() < closestDistance) {

                        closestDistance = hitResult.getDistance();
                        closestShape = shape;
                    }
                }

                Color pixelColor;

                if (closestShape != null) {
                    pixelColor = closestShape.getColor();
                } else {
                    pixelColor = new Color(0, 0, 0);
                }

                int rgb =
                        (pixelColor.getRed() << 16)
                                | (pixelColor.getGreen() << 8)
                                | pixelColor.getBlue();

                image.setRGB(x, y, rgb);
            }
        }

        try {
            ImageIO.write(image, "png", new File("render.png"));
        } catch (IOException e) {
            System.out.println("Could not save image.");
        }
    }
}