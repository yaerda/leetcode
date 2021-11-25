package baseAlgorithm.sort;

public class MergeSort extends Sort {
    @Override
    void init() {
        this.setName("归并排序");
    }

    @Override
    void doSort() {
        int[] list = getList();
        sort(list, 0, list.length - 1);
        setResult(list);
    }

    void sort(int[] list, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(list, lo, mid);
        sort(list, mid + 1, hi);
        merge(list, lo, mid, hi);

    }

    void merge(int[] list, int lo, int mid, int hi) {

        int[] listUx = new int[list.length];

        for (int i = 0; i < list.length; i++) {
            listUx[i] = list[i];
        }
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                list[k] = listUx[j++];
            } else if (j > hi) {
                list[k] = listUx[i++];
            } else if (listUx[i] < listUx[j]) list[k] = listUx[i++];
            else list[k] = listUx[j++];

        }
    }
}
