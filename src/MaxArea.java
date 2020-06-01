public class MaxArea {
    public static void main(String[] args) {
        int[] list = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(max(list));
        System.out.println(max2(list));
        System.out.println(max3(list));
    }

    private static int max3(int[] list) {
        int max = 0;
        int i = 0;
        int j = list.length - 1;
        for (; i < j; i++) {
            for (; j > i; j--) {
                max = Math.max((j - i) * Math.min(list[i], list[j]), max);
                if (list[j] > list[i]) {
                    break;
                }
            }
        }
        return max;
    }

    private static int max2(int[] list) {
        int max = 0;
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = list.length - 1; j > i; j--) {
                max = Math.max((j - i) * Math.min(list[i], list[j]), max);
                if (list[j] > list[i]) {
                    break;
                }
            }
        }
        return max;
    }

    private static int max(int[] list) {
        int max = 0;
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = i + 1; j < list.length; j++) {
                max = Math.max((j - i) * Math.min(list[i], list[j]), max);
            }
        }
        return max;
    }
}
