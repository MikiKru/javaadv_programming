package sesja_samodzielna.s5;

import java.util.List;
import java.util.stream.Collectors;

public class S5 {
    public List<String> search(List<String> list) {
        return list.stream()
                .filter(s -> s.startsWith("a"))
                .filter(s -> s.length() == 3)
                .collect(Collectors.toList());
    }
}
