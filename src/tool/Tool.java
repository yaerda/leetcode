package tool;

import java.util.Arrays;

public class Tool {
    public static <T> void print(T[] array) {
        if (array == null) {
            System.out.println("null");
            return;
        }
        System.out.print("[");
        int pEnd = array.length - 1;
        for (int i = 0; i < pEnd; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.print(array[pEnd]);
        System.out.println("]");
    }

    public static void print(int[] array) {
        print(Arrays.stream(array).boxed().toArray());
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
