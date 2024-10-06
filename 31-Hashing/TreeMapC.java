import java.util.TreeMap;

public class TreeMapC {
    public static void main(String[] args) {
        // TreeMap --------------------------------
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 100); // India (Key) & 100 (Value)
        tm.put("China", 150);
        tm.put("US", 50);
        tm.put("Indonesia", 6);
        System.out.println("Print TreeMap : " + tm); // {China=150, India=100, Indonesia=6, US=50} (TreeMap sorted map -> Based on Key)

    }
}
