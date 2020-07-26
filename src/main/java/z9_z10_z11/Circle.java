package z9_z10_z11;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

@Data
@AllArgsConstructor
public class Circle implements Movable {
    private Point2D center;
    private Point2D point;

    public double getRadius(){
        // x = sqrt((xa - xb)^2 + (ya - yb)^2)
        return sqrt(pow(center.getX() - point.getX(), 2) + pow(center.getY() - point.getY(), 2));
    }
    public double getPerimeter(){
        // obw = 2*pi*r
        return 2 * PI * getRadius();
    }
    public double getArea(){
        // P = pi * r^2
        return PI * pow(getRadius(),2);
    }
    public List<Point2D> getSlicePoints(){
        List<Point2D> slicesPoints = new ArrayList<>();
        slicesPoints.add(new Point2D(point.getX(), - point.getY()));
        slicesPoints.add(new Point2D( - point.getX(), point.getY()));
        slicesPoints.add(new Point2D( - point.getX(), - point.getY()));
        return slicesPoints;
    }
    @Override
    public void move(MoveDirection moveDirection) {
        center.move(moveDirection);
        point.move(moveDirection);
    }

    public static void main(String[] args) {
        Circle circle = new Circle(new Point2D(1,1), new Point2D(2,2));
        System.out.printf("Promień okręgu: %.2f cm\n", circle.getRadius());
        System.out.printf("Obwód okręgu: %.2f cm\n", circle.getPerimeter());
        System.out.printf("Pole okręgu: %.2f cm^2\n", circle.getArea());
        System.out.println("Punkty na okręgu: " + circle.getSlicePoints());

        circle.move(new MoveDirection(1,1));
        System.out.printf("Center: [%.2f,%.2f] Point: [%.2f,%.2f]\n",
                circle.center.getX(), circle.center.getY(), circle.point.getX(), circle.point.getY());
        System.out.printf("Promień okręgu: %.2f cm\n", circle.getRadius());
        System.out.printf("Obwód okręgu: %.2f cm\n", circle.getPerimeter());
        System.out.printf("Pole okręgu: %.2f cm^2\n", circle.getArea());
    }
}
