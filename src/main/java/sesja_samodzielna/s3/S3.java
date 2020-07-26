package sesja_samodzielna.s3;

import java.util.List;

public class S3 {
    public Double average(List<Integer> list) {
        return list.stream()
                .mapToInt(i -> i)
                .average()
                .getAsDouble(); }
}
