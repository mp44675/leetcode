import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class median {
    
    public static void main(String[] args) {
        int[] num1 = {1, 1};
        int[] num2 = {1, 2};
        System.out.println(findMedianSortedArrays(num1, num2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length+nums2.length;
        int[] arr = new int[size];
        mergeArrays(nums1, nums2, nums1.length, nums2.length, arr);
        if ((size % 2) == 1) {
            //odd so its just the mid value
            return arr[(int) Math.ceil(size/2)];
        } else {
            //even
            int index1 = (size/2)-1;
            int index2 = size/2;
            double res = ((double) arr[index1] + (double) arr[index2]) / 2;
            return res;
        }
    }
    public static void mergeArrays(int[] arr1, int[] arr2, int n1, int n2, int[] arr3)
    {
        int i = 0, j = 0, k = 0;
        while (i<n1 && j <n2)
        {
            if (arr1[i] < arr2[j]) {
                arr3[k] = arr1[i];
                k++;
                i++;
            }
            else{
                arr3[k] = arr2[j];
                k++;
                j++;
            }
                
        }
    
        while (i < n1)
            arr3[k++] = arr1[i++];
        while (j < n2)
            arr3[k++] = arr2[j++];
    }

}
