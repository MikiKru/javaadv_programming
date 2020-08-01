package sesja_samodzielna.s6;

import java.util.List;
import java.util.stream.Collectors;

public class S6 {
    public String getString(List<Integer> list) {
        return list
                .stream()
                .map(i -> i % 2 == 0 ? "e" + i : "o" + i)
                .collect(Collectors.joining(","));
    }
}
