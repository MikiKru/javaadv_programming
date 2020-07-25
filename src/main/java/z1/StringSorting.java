package z1;

import java.util.*;
import java.util.stream.Collectors;

public class StringSorting {
    private String stringToLowerCase(String s){
        return s.toLowerCase();
    }
    private List<String> orderByStringDesc(List<String> strs){
        return strs                                                                     // List<String>
                .stream()                                                               // Stream<String>
                .sorted(Comparator.comparing(this::stringToLowerCase).reversed())       // Stream<String>
                .collect(Collectors.toList());                                          // List<String>
    }
    private List<String> orderByStringLength(List<String> strs){
        return strs
                .stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }
    private Map<Integer, List<String>> groupStringByLength(List<String> strs){
        return strs
                .stream()
                .collect(Collectors.groupingBy(String::length));
    }

    public static void main(String[] args) {
        System.out.println("Z1");
        System.out.println(new StringSorting().groupStringByLength(new ArrayList<>(Arrays.asList(
                "Z","A","s","a","aa","dse","223ddfsfds"
        ))));
    }
}
