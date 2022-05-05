import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Google {

    public static int findNthDigit(int n) {
        int i = 1; //i is the count
        if(n <= 9) {
            return n;
        } else {
            n = n-9;

        }
        return i;
    }

    public static String frequenceSort(String s) {
        Map<Character,Integer> m = new HashMap<>();
        for (int i = 0; i < s.length();i++) {
            if (m.containsKey(s.charAt(i))) {
                //in the map so increment key
                Integer inc = m.get(s.charAt(i));
                inc+=1;
                m.put(s.charAt(i), inc);
            } else {
            // not in the map
                m.put(s.charAt(i),1);
            }
        }
        Stream<Map.Entry<Character,Integer>> sorted =
        m.entrySet().stream()
       .sorted(Map.Entry.comparingByValue());
       System.out.println();
        return null;
    }
    
    public static void main (String[] args) {
        System.out.println(frequenceSort("tree"));
    }
}
