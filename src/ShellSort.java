public class ShellSort {
    public static void main(String[] args) {
        int[] list = {2, 3, 5, 69, 21, 52, 65, 1, 56, 7, 2, 7};
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + ",");
        }
        int l = list.length;
        int h = 1;
        while (h < l / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < l; i++) {
                for (int j = i; j >= h && list[j] < list[j - h]; j -= h) {
                    int temp = list[j];
                    list[j] = list[j - h];
                    list[j - h] = temp;
                }
            }
            h = h / 3;
        }
        System.out.println();
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + ",");
        }
    }
}
