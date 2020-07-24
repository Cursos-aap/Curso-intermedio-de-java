package figures_herency_example.three_dimensions_figures;

import figures_herency_example.ThreeDimensionalFiguresInheritProperties;
import figures_herency_example.ThreeDimensionalFiguresMethods;
import figures_herency_example.two_dimensions_figures.Polygon;

public class PolygonalPrism extends Polygon
        implements ThreeDimensionalFiguresInheritProperties,
        ThreeDimensionalFiguresMethods {

    private final double deep;

    public PolygonalPrism(short sides, double side_length, double deep) {
        super(sides, side_length);
        this.deep = deep;
    }

    @Override
    public double calculateVolume() {
        return super.area * deep;
    }

    @Override
    public double calculateTotalArea() {
        return super.area * 2 + super.perimeter * deep ;
    }

    @Override
    public double calculateBaseArea() {
        return this.area;
    }
}
