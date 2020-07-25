package z4;

import java.util.*;

// ALT + Ins -> generate
public class Storage {
    private Map<String, List<String>> products;
    public Storage(Map<String, List<String>> products) {
        this.products = products;
    }
    private void addToStorage(String key, String value){
//        if(!products.containsKey(key)){
//            products.put(key, new ArrayList<>(Arrays.asList(value)));
//        } else {
//            List<String> currentProducts = products.get(key);       // metoda pobiera do listy wartości pod kluczem key
//            currentProducts.add(value);
//            products.put(key, currentProducts);
//        }
        products.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
        System.out.println(products);
    }
    private void printValues(String key){
        products.get(key).forEach(System.out::println);
    }
    private List<String> findValues(String value){
        List<String> keys = new ArrayList<>();
        products.forEach((k, v) -> {
            if (v.contains(value))
                keys.add(k);
        });
        return keys;
    }
    public static void main(String[] args) {
        Storage storage = new Storage(new HashMap<>());
        storage.addToStorage("1","P1");
        storage.addToStorage("2","P2");
        storage.addToStorage("1","P3");
        storage.addToStorage("3","P4");
        storage.addToStorage("1","P5");
        storage.addToStorage("5","P1");
        storage.printValues("1");
        System.out.println(storage.findValues("P1"));
        System.out.println(storage.findValues("P10"));
    }
}
