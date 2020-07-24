package figures_herency_example.two_dimensions_figures;

import figures_herency_example.TwoDimensionalFigures;

public class Polygon extends TwoDimensionalFigures {
    private final double apothem;
    private final short sides;
    private final double side_length;

    public Polygon(short sides, double side_length) {
        this.sides = sides;
        this.side_length = side_length;

        this.apothem = (side_length/(2 * Math.tan(Math.toRadians(360/ (sides * 2.0)))));
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

    @Override
    protected String information(){
        return super.information() + ". Soy un polígono. Recibo cuántos lados tengo y cuán largos son";
    }
}
