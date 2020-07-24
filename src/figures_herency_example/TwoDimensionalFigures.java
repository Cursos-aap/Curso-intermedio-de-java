package figures_herency_example;

public abstract class TwoDimensionalFigures {

    /*  Properties  */

    protected double area;
    protected double perimeter;

    /*  Methods  */

    protected abstract double calculateArea();
    protected abstract double calculatePerimeter();
    protected String information(){
        return "2D figure";
    }

}
