package figures_herency_example.two_dimensions_figures;

import figures_herency_example.TwoDimensionalFigures;

public class Circle extends TwoDimensionalFigures {

    private final double radio;

    public Circle(double radio) {
        this.radio = radio;

        this.area = calculateArea();
        this.perimeter = calculatePerimeter();
    }

    @Override
    protected double calculateArea() {
        return Math.pow(this.radio, 2) * Math.PI;
    }

    @Override
    protected double calculatePerimeter() {
        return this.radio * 2 * Math.PI;
    }
}
