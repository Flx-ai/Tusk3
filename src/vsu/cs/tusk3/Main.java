package vsu.cs.tusk3;

import java.util.Scanner;

public class Main {

    public static final Line L1 = new Line(0, 3, 0);
    public static final VerticalParabola V1 = new VerticalParabola(5, 1, -1);
    public static final Circle C1 = new Circle(-6, 4, 2);


    public static void main(String[] args) {

        double x = readCoordinate('x');
        double y = readCoordinate('y');
        printColorForPoint(x,y);

        printColorForPoint(5,9);
        printColorForPoint(6,-5);
        printColorForPoint(5,0.5);
        printColorForPoint(-6, 2.5);
        printColorForPoint(-5,4);


    }

    static double readCoordinate(char coordinateName){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Input %S: ", coordinateName);
        return scanner.nextDouble();
    }
    public static Enum.SimpleColor getColor(double x, double y) {

        if (L1.isPointAboveLine(x, y) && !C1.isPointInsideCircle(x, y)) {
            return Enum.SimpleColor.YELLOW;
        }

        if (C1.isPointInsideCircle(x, y) && L1.isPointAboveLine(x, y)
                || (!L1.isPointAboveLine(x, y) && !C1.isPointInsideCircle(x, y) && !V1.isPointInsideParabola(x, y))) {
            return Enum.SimpleColor.WHITE;
        }

        if (C1.isPointInsideCircle(x, y) && !L1.isPointAboveLine(x,y)) {
            return Enum.SimpleColor.ORANGE;
        }
        return  Enum.SimpleColor.GREEN;
    }

    public static void printColorForPoint(double x, double y){
        System.out.printf("(%.1f, %.1f) -> %S%n", x, y, getColor(x,y));
    }

}
