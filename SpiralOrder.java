import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    
    public static void main(String[] args) {
        int [][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        List<Integer> spiral = spiralOrder(matrix);
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        
        int length = matrix[0].length;
        int width = matrix.length;
        List<Integer> res = new ArrayList<>(length+width);
        int i = 0;
        int j = 0;
        int size = res.size();
        int direction = 0; // 0 for length-wise , 1 for width-wise
        while (size == length+width) {
            res.add(matrix[i][j]);
            i++;
            j++;

        }
        return res;
        
    }
}
// 12345
// 67891
// 91231
// 12345
// len = 5
// wid = 4
// 0,0->[5][0] len-w
// 5,1->[5][5] wid-w
// 5,5->[0][5] len-w
// 0,5->[1][0] wid-w
// 1,0->[1][4] len-w
// 1,4->[2][]
