//LeetCode: Problem 1
package TwoSum;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] answer = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(answer[0] + " " + answer[1]);
    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> seen = new HashMap<>();
        int diff;
        for (int i = 0; i< nums.length; i++) {
            diff = target - nums[i];
            if (seen.get(diff) != null) {
                return new int[]{seen.get(diff), i};
            } else {
                seen.put(nums[i], i);
            }
        }
        return new int[]{9, 9};
    }

}
