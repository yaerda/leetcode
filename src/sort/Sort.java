package sort;

public abstract class Sort {
    private int[] list;
    private String name;
    
    Sort() {
        this.list = new int[]{2, 3, 5, 69, 21, 52, 65, 1, 56, 7, 2, 7};
        this.init();
    }

    void setName(String name) {
        this.name = name;
    }

    abstract void init();

    private void printOrg() {
        System.out.println("排序方法：" + this.name);
        System.out.print("原数组:");
        printList();
        System.out.println();
    }

    private void printResult() {
        System.out.print("排序后:");
        printList();
        System.out.println();
    }

    private void printList() {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + (i == list.length - 1 ? "" : ", "));
        }
    }

    int[] getList() {
        printOrg();
        return list;
    }

    abstract void doSort();

    void setResult(int[] list) {
        this.list = list;
        printResult();
    }

}
