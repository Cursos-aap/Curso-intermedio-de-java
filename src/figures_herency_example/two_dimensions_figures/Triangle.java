package figures_herency_example.two_dimensions_figures;

import figures_herency_example.TwoDimensionalFigures;

public class Triangle extends TwoDimensionalFigures {
    private final float side_a;
    private final float side_b;
    private final float side_c;

    private final float height;
    private final float base;

    public Triangle(float side_a, float side_b, float side_c) {
        this.side_a = side_a;
        this.side_b = side_b;
        this.side_c = side_c;
        this.perimeter = calculatePerimeter();
        this.area = calculateArea();

        this.height = 0;
        this.base = 0;
    }

    public Triangle(float height, float base) {
        this.height = height;
        this.base = base;

        this.side_a = 0;
        this.side_b = 0;
        this.side_c = 0;
    }

    @Override
    protected double calculatePerimeter() {
        if(base == 0)
            return this.side_a + this.side_b + this.side_c;
        return -1;
    }

    @Override
    protected double calculateArea() {
        if(base == 0){
            final double s = this.calculatePerimeter() / 2;
            return Math.sqrt(s * (s - this.side_a) * (s - this.side_b) * (s - this.side_c));
        }
        return this.base * this.height / 2;
    }

}