package org.example;

public interface Shape {

    HitResult hit(Ray ray);

    Color getColor();
}