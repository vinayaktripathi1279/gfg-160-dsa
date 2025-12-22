 import java.util.*;

public class maxsubarray {
    int maxProduct(int[] arr) {

        int maxProd = Integer.MIN_VALUE;

        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];

        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] * arr[i];
        }

        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end++) {

                int currentProd;

                if (start == 0) {
                    currentProd = prefix[end];
                } else {
                    if (prefix[start - 1] == 0) {

                        currentProd = 1;
                        for (int k = start; k <= end; k++) {
                            currentProd *= arr[k];
                        }

                    } else {
                        currentProd = prefix[end] / prefix[start - 1];
                    }
                }

                maxProd = Math.max(maxProd, currentProd);
            }
        }

        return maxProd;
    }

    public static void main(String[] args) {

        maxsubarray obj = new maxsubarray();

        int arr[] = {2, 3, -2, 4};

        int result = obj.maxProduct(arr);

        System.out.println("Maximum Product Subarray = " + result);
    }
}
