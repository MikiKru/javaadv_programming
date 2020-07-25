package z8;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Parcel {
    private int xLength;
    private int yLength;
    private int zLength;
    private float weight;
    private boolean isExpress;
}
