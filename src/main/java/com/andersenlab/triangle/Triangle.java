package com.andersenlab.triangle;

public class Triangle {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() throws TriangleException {
        double area = 0;
        if (checkTriangle()) {
            double perimeter = a + b + c;
            double p = perimeter / 2;
            area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        } else {
            area = 0;
        }
        if (area > 0) {
            return area;
        } else throw new TriangleException();
    }

    public boolean checkTriangle() {
        boolean isTriangle = !((a + b) <= c) && !((b + c) <= a) && !((c + a) <= b) && !(a <= 0) && !(b <= 0) && !(c <= 0);
        return isTriangle;
    }
}
