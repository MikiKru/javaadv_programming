package z9;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Circle {
    private Point2D center;
    private Point2D point;

    public double getRadius(){
        return 0.0;
    }
    public double getPerimeter(){
        return 0.0;
    }
    public double getArea(){
        return 0.0;
    }


}
