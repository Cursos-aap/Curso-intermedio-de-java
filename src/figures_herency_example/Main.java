package figures_herency_example;

import figures_herency_example.three_dimensions_figures.Sphere;
import figures_herency_example.two_dimensions_figures.Circle;
import figures_herency_example.two_dimensions_figures.Polygon;
import figures_herency_example.two_dimensions_figures.Rectangle;
import figures_herency_example.two_dimensions_figures.Triangle;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        Sphere sphere = new Sphere(14);
        sphere.sayHello();

    }

}