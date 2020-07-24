package figures_herency_example.three_dimensions_figures;


import figures_herency_example.ThreeDimensionalFiguresInheritProperties;
import figures_herency_example.ThreeDimensionalFiguresMethods;
import figures_herency_example.two_dimensions_figures.Rectangle;

public class RectangularPrism extends Rectangle
        implements ThreeDimensionalFiguresInheritProperties,
        ThreeDimensionalFiguresMethods {

    private final double deep;

    public RectangularPrism(double height, double base, double deep) {
        super(height, base);
        this.deep = deep;
    }

    @Override
    public double calculateVolume() {
        return super.area * deep;
    }

    @Override
    public double calculateTotalArea() {
        return 2 * ( super.area + deep * getHeight() + deep * base );
    }

    @Override
    public double calculateBaseArea() {
        return super.area;
    }
}
