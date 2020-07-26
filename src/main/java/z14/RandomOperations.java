package z14;

import java.util.*;
import java.util.stream.Collectors;

public class RandomOperations {
    List<Integer> arr = new ArrayList<>();
    public RandomOperations() {
        for (int i = 0; i < 10; i++) {      // 10 wartości losowych
            arr.add(new Random().nextInt(11));  // wartości losowe od 0 do 10
        }
    }
    public Set<Integer> getUniqueElements(){
        return new HashSet<>(arr);      // zbiór usuwa duplikaty
    }
    public Set<Integer> getNonNuiqueElements(){
        Set<Integer> nonuniqueElems = new HashSet<>();
        Map<Integer, Integer> noNonUniqueElements = new HashMap<>();
        for(Integer v1 : arr){
            int count = 0;
            for (Integer v2 : arr){
                if(v1.equals(v2)){
                    count ++;
                    noNonUniqueElements.put(v1, count);
                }
            }
            if(count > 1){
                nonuniqueElems.add(v1);
            }
        }
        System.out.println(noNonUniqueElements);
        return nonuniqueElems;
    }

    public static void main(String[] args) {
        RandomOperations ro = new RandomOperations();
        ro.arr.forEach(value -> System.out.print(value + " "));
        System.out.println();
        System.out.println(ro.getUniqueElements());
        System.out.println(ro.getNonNuiqueElements());

    }
}
