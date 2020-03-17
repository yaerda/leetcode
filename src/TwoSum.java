import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] answer = sum(nums, target);
        if (answer != null) {
            System.out.println(String.format("This answer is: {%d, %d}", answer[0], answer[1]));
        } else {
            System.out.println("no answer");
        }
    }

    private static int[] sum(int[] nums, int target) {
        Map<Integer, Integer> sub_num = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int need = target - curr;
            if (sub_num.containsKey(need)) {
                return new int[]{sub_num.get(need), i};
            }
            sub_num.put(curr, i);
        }
        return null;
    }
}
