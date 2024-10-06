
// import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Math;

public class HashMap_Implementation {
    static class HashMap<K, V> { // generic (parameterized type -> Any type of String,Integer,etc.)
        private class Node {
            K key;
            V value;

            public Node(K key, V value) { // Node constructor
                this.key = key;
                this.value = value;
            }
        }

        private int n; // size of the nodes - n
        private int N; // size of the buckets - N
        private LinkedList<Node> buckets[]; // buckets of LinkedList type

        @SuppressWarnings("unchecked") // Remove Warning -> new LinkedList[4] (ex- int[4])
        public HashMap() { // Hashmap constructor
            this.N = 4; // initialize bucket size (N = 4)
            this.buckets = new LinkedList[N]; // Bucket type LinkedList & size 4 fixed (N = 4)
            for (int i = 0; i < buckets.length; i++) { // initialize
                this.buckets[i] = new LinkedList<>(); // create LL for each bucket
            }
        }

        // Hash functions ---
        private int hashFunction(K key) {
            int hc = key.hashCode(); // return the hash code (31431, -36923 -> random number)
            return Math.abs(hc) % N; // convert absolute value / bucket size = return idx (1 to 3)
        }

        // Search in LinkedList ---
        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0; // data index
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key == key) {
                    return di; // return node index
                }
                di++;
            }
            return -1; // not found
        }

        // Rehashing ---
        @SuppressWarnings("unchecked") // Remove Warning -> new LinkedList[2 * N] (ex- int[k])
        private void rehash() {
            LinkedList<Node> oldBuckets[] = buckets; // create old buckets and store buckets data
            buckets = new LinkedList[2 * N]; // old buckets * 2
            N = 2 * N; // update buckets size
            for (int i = 0; i < buckets.length; i++) { // initialize
                this.buckets[i] = new LinkedList<>(); // create LL for each bucket
            }
            for (int i = 0; i < oldBuckets.length; i++) { // nodes -> add in buckets
                LinkedList<Node> ll = oldBuckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove(j);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) { // TC = O(lambda) -> O(1)
            int bi = hashFunction(key); // index
            int di = searchInLL(key, bi); // valid, -1
            if (di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++; // increment nodes size
            }
            double lambda = (double) n / N; // node size / bucket size
            if (lambda > 2.0) { // thressold value -> let = 2.0 
                rehash();
            }
        }

        public boolean containsKey(K key) { // TC = O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di != -1) { // valid index 
                return true;
            } else { // -1 index
                return false;
            }
        }

        public V remove(K key) { // TC = O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di != -1) { // valid index 
                Node node = buckets[bi].remove(di);
                n--; // decrement nodes size
                return node.value;
            } else { // -1 index
                return null;
            }
        }

        public V get(K key) { // TC = O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di != -1) { // valid index 
                Node node = buckets[bi].get(di);
                return node.value;
            } else { // -1 index
                return null;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }
    }

    public static void main(String[] args) {
        // HashMap Implementation -------------------------------- 
        // create hash map ---
        HashMap<String, Integer> hm = new HashMap<>();
        // put ---
        hm.put("India", 100);
        hm.put("USA", 50);
        hm.put("China", 150);
        hm.put("Nepal", 10);

        // keySet ---
        System.out.println("Print all keys :-");
        ArrayList<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.println(key);
        }
        System.out.println();

        // get ---
        System.out.println("India Value : " + hm.get("India"));

        // remove ---
        System.out.println("India Remove : " + hm.remove("India"));
        System.out.println("India Value : " + hm.get("India"));

        // containsKey ---
        System.out.println("India containsKey : " + hm.containsKey("India"));
        System.out.println("China containsKey : " + hm.containsKey("China"));

        // isEmpty ---
        System.out.println("Hashmap isEmpty : " + hm.isEmpty());
    }
}
