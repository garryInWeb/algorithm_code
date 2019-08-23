package al.a19;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class MapTest {
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> linkedHashMap = new LinkedHashMap<>(16,0.75f,true);
        linkedHashMap.put(1,"1");
        linkedHashMap.put(2,"2");
        linkedHashMap.put(3,"3");
        linkedHashMap.put(4,"4");
        System.out.println("Linked before");
        linkedHashMap.get(3);

        linkedHashMap.forEach((k,v) -> System.out.println(k + " : " + v));

        linkedHashMap.get(3);
        linkedHashMap.get(1);

        System.out.println("Linked");
        linkedHashMap.forEach((k,v) -> System.out.println(k + " : " + v));


        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1,"1");
        hashMap.put(2,"2");
        hashMap.put(3,"3");
        hashMap.put(4,"4");

        System.out.println("hash");
        hashMap.forEach((k,v) -> System.out.println(k + " : " + v));

        hashMap.get(3);
        hashMap.get(1);

        System.out.println("hash");
        hashMap.forEach((k,v) -> System.out.println(k + " : " + v));
    }
}
