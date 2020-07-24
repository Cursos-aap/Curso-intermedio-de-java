package figures_herency_example.three_dimensions_figures;

import figures_herency_example.ThreeDimensionalFiguresInheritProperties;
import figures_herency_example.two_dimensions_figures.Circle;

public class Sphere extends Circle implements ThreeDimensionalFiguresInheritProperties {

    public Sphere(double radio) {
        super(radio);
    }

    @Override
    public double calculateVolume() {
        return Math.PI * getRadio() * 4/3;
    }

    @Override
    public double calculateTotalArea() {
        return 4 * area;
    }

    @Override
    public void sayHello(){
        System.out.println("Hi");
    }
}
