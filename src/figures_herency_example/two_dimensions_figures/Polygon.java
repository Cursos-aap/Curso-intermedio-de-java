package figures_herency_example.two_dimensions_figures;

import figures_herency_example.TwoDimensionalFigures;

public class Polygon extends TwoDimensionalFigures {
    private final float apothem;
    private final short sides;
    private final float side_length;

    public Polygon(short sides, float side_length) {
        this.sides = sides;
        this.side_length = side_length;

        this.apothem = (float) (side_length/(2 * Math.tan(Math.toRadians((float) 360/ (sides * 2)))));
        this.area = calculateArea();
        this.perimeter = calculatePerimeter();
    }

    @Override
    protected double calculateArea() {
        return this.calculatePerimeter() * this.apothem * 0.5;
    }

    @Override
    protected double calculatePerimeter() {
        return this.sides * this.side_length;
    }
}
