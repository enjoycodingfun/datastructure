//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,7,11,15], target = 9
//输出：[2,7] 或者 [7,2]
// 
//
// 示例 2： 
//
// 输入：nums = [10,26,30,31,47,60], target = 40
//输出：[10,30] 或者 [30,10]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^6 
// 
// 👍 62 👎 0


package leetcode.editor.cn;

import java.util.HashSet;

//Java：和为s的两个数字
public class P剑指 Offer 57和为s的两个数字{
    public static void main(String[] args) {
        Solution solution = new P剑指 Offer 57和为s的两个数字().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //return method1(nums,target);
        return method2(nums,target);
    }

        private int[] method2(int[] nums, int target) {
            int left = 0,right = nums.length-1;
            while (left < right){
                if (nums[left]+nums[right] < target){
                    left++;
                }else if (nums[left]+nums[right] > target){
                    right--;
                }else {
                    return new int[]{nums[left],nums[right]};
                }
            }
            return new int[0];
        }

        /**
         * 时间复杂度和空间复杂度
         * @param nums
         * @param target
         * @return
         */
        private int[] method1(int[] nums, int target) {
            HashSet set = new HashSet<>();
            for (int num : nums) {
                if (set.contains(target-num)){
                    return new int[]{num,target-num};
                }
                set.add(num);
            }
            return new int[0];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
