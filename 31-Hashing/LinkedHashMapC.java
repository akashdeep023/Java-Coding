import java.util.LinkedHashMap;

public class LinkedHashMapC {
    public static void main(String[] args) {
        // LinkedHashMap --------------------------------
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100); // India (Key) & 100 (Value)
        lhm.put("China", 150);
        lhm.put("US", 50);
        System.out.println("Print LinkedHashMap : " + lhm); // {India=100, China=150, US=50} (LinkedHashMap ordered map -> FIFO)
    }
}
