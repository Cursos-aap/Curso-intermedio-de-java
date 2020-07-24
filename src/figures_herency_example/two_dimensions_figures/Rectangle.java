package figures_herency_example.two_dimensions_figures;

import figures_herency_example.TwoDimensionalFigures;

public class Rectangle extends TwoDimensionalFigures {

    private final double height;
    private final double base;

    public Rectangle(double height, double base) {
        this.height = height;
        this.base = base;

        this.area = calculateArea();
        this.perimeter = calculatePerimeter();
    }

    @Override
    protected double calculateArea() {
        return this.height * this.base;
    }

    @Override
    protected double calculatePerimeter() {
        return 2 * this.base + 2 * this.height;
    }

    @Override
    protected String information(){
        return super.information() + ". Soy un rectángulo. Recibo mi base y mi altura";
    }

}
