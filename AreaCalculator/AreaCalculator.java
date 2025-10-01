import java.lang.Math;

public class AreaCalculator {
    public double calculate(double radius) {
        // Circle: Area = 𝜋 × radius²
        double rounded = (Math.round((Math.PI * radius * radius) * 100));
        return rounded / 100;
    }

    public double calculate(double width, double height) {
        /*
         * Rectangle: Area = width × height
         * 
         * Triangle: Area = ½ × base × height
         * 
         * Square: Area = side²
         * 
         */
        return width * height;
    }

    public double calculate(double base, double height, boolean isTriangle) {
        // calculate area of triangle
        return 0.5 * base * height;
    }

    public double calculate(double side, boolean isSquare) {
        // calculate area of square
        return side * side;
    }
}