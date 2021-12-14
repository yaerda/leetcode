package tool;

import java.util.Arrays;
import java.util.stream.Stream;

public class Tool {


    public static void print(String s) {
        System.out.println(s);
    }

    public static void print(Object s) {
        System.out.println(s);
    }

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

    public static void print(byte[] array) {
        Byte[] bytes = new Byte[array.length];
        for (int i = 0; i < array.length; i++) {
            bytes[i] = array[i];
        }
        print(bytes);
    }

    public static void swap(int[] nums, int a, int b) {
        if (a == b) {
            return;
        }
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
