package z5;

import java.util.HashSet;
import java.util.Set;

public class SDAHashSet<E> extends HashSet<E> {
    @Override
    public boolean add(E element){
         return super.add((E) ("SDA: " + element));
    }

    public static void main(String[] args) {
        // sda
        Set<String> sdaHashSet = new SDAHashSet<>();
        sdaHashSet.add("1");
        sdaHashSet.add("2");
        System.out.println(sdaHashSet.add("3"));
        System.out.println(sdaHashSet.add("3"));
        sdaHashSet.remove("SDA: 2");
        System.out.println(sdaHashSet);
        // oryginalny
        Set<String> hashSet = new HashSet<>();
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("3");
        System.out.println(hashSet);
    }
}
