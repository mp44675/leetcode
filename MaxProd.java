public class MaxProd {

    
    
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 2};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct (int[] nums) {
        int max = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                j = 1;
            }
             while (j < nums.length && j != i) {
                int prod = ((nums[i] - 1 )* (nums[j]-1));
                if (prod > max) {
                    max = prod;
                }
                j++;
            }
            j = 0;
        }
        return max;
    }
}

//https://leetcode.com/list/52657ph7/