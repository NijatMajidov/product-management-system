package SearchAlgoritm;

import java.util.Arrays;

public class BinarySearchApp {
    public static void main(String[] args) {

    }
    public static int BinarySearchRes(int[] a, int fromIndex, int toIndex,
                                      int key){
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return 0;
    }
}
