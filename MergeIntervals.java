import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MergeIntervals {


    public static int[][] merge (int [][] intervals) {
        Set<Integer> s = new TreeSet<Integer>();
        //add numbers to set
        for (int i = 0; i < intervals.length; i++) {
            s.add(intervals[i][0]);
            s.add(intervals[i][1]);
        }
        
        System.out.println();
        return intervals;
        
    }
    public static void main (String[] args) {
        int [][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        intervals = merge(intervals);
    }
}