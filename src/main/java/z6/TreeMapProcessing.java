package z6;

import java.util.*;
import java.util.stream.Collectors;

public class TreeMapProcessing {
    private void getEntrySet(Map<Integer, String> strs){
        List<Map.Entry> entries = new ArrayList<>(strs.entrySet());
        System.out.println(entries.get(0));
        System.out.println(entries.get(entries.size() - 1));
    }

    public static void main(String[] args) {
        Map<Integer, String> strs = new TreeMap<>();
        strs.put(10,"P1");
        strs.put(3,"P0");
        strs.put(4,"P5");
        strs.put(2,"P4");
        System.out.println(strs);
        new TreeMapProcessing().getEntrySet(strs);
    }
}   
