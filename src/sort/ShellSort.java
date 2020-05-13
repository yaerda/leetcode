package sort;

public class ShellSort extends Sort {

    @Override
    void init() {
        this.setName("希尔排序");
    }

    @Override
    void doSort() {
        int[] list = getList();
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
        setResult(list);
    }
}
