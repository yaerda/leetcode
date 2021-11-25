package baseAlgorithm.sort;

public class SortApplication {
    public static void main(String[] args) {
        sort(new ShellSort());
        sort(new MergeSort());
    }

    private static void sort(Sort sort) {
        sort.doSort();
    }
}
