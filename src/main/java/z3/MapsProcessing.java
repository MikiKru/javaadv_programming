package z3;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapsProcessing {
    private void printMapElements(Map<String, Integer> myMap){
        System.out.println(
                myMap.keySet()          // zwraca zbior kluczy
                .stream()                                   // Stream<String>
                .map(s -> String.format("Klucz: %s, Warotść: %d", s, myMap.get(s)))
                .collect(Collectors.joining(",\n"))   // String
                + "."
        );
    }
    public static void main(String[] args) {
        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("Java",1);
        myMap.put("Python",2);
        myMap.put("C#",4);
        myMap.put("C++",10);
        new MapsProcessing().printMapElements(myMap);
    }
}
