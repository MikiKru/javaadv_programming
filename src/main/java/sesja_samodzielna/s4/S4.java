package sesja_samodzielna.s4;

import java.util.List;
import java.util.stream.Collectors;

public class S4 {
    public List<String> upperCase(List<String> list) {
        return list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList()); }
}
