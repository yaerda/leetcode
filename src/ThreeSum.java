import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        List<List<Integer>> sumList = new ArrayList<>();
        sumList.add(Arrays.asList(-1, 0, 1, 2, -1, -4));
        sumList.add(Arrays.asList(0, 0));
        sumList.add(Arrays.asList(0, 0, 0));
        sumList.add(Arrays.asList(0, 0, 0, 0));
        sumList.add(Arrays.asList(-2, 0, 1, 1, 2));
        sumList.add(Arrays.asList(-1, 0, 1, 2, -1, -4));
        sumList.add(Arrays.asList(-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6));
        sumList.forEach(o -> System.out.println(threeSum2(o.stream().mapToInt(Integer::valueOf).toArray())));
        sumList.forEach(o -> System.out.println(threeSum(o.stream().mapToInt(Integer::valueOf).toArray())));
    }

    private static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> sumList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        sumList.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo + 1] == nums[lo]) lo++;
                        while (lo < hi && nums[hi - 1] == nums[hi]) hi--;
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return sumList;
    }


    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sumList = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j - 1) {
            int m = i + 1;
            j = nums.length - 1;
            while (m < j) {
                if (nums[i] + nums[j] + nums[m] < 0) {
                    int temp = nums[m];
                    while (m < j) {
                        if (nums[++m] != temp) {
                            break;
                        }
                    }
                } else if (nums[i] + nums[j] + nums[m] > 0) {
                    int temp = nums[j];
                    while (m < j) {
                        if (nums[--j] != temp) {
                            break;
                        }
                    }
                } else {
                    sumList.add(Arrays.asList(nums[i], nums[m], nums[j]));
                    int temp = nums[m];
                    while (m < j) {
                        if (nums[++m] != temp) {
                            break;
                        }
                    }
                }
            }
            int temp = nums[i];
            while (i < j - 1) {
                if (nums[++i] != temp) {
                    break;
                }
            }
        }
        return sumList;
    }
}
