//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 分治算法 动态规划 
// 👍 182 👎 0


package leetcode.editor.cn;

//Java：连续子数组的最大和
public class P剑指 Offer 42连续子数组的最大和{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 42连续子数组的最大和().new Solution();
        // TO TEST
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 本题的最佳解法为动态规划解法，时间复杂度O(N)，空间复杂度O(1)最好
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        //return dp(nums);
        return dp2(nums);


    }

    /**
     * 动态规划方案二：针对空间进行优化，每个dp只和上一个dp有关系
     * @param nums
     * @return
     */
    private int dp2(int[] nums) {
        int pre = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre+nums[i],nums[i]);
            max = Math.max(pre,max);
        }
        return max;
    }

    /**
     * 动态规划方案
     * @param nums
     * @return
     */
    private int dp(int[] nums) {
        //建立dptable，dp[i]表示以数组元素nums[i]结尾的最大的子序和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //如果dp[i-1]小于0，dp[i]=nums[i]，否则等于加上前面的
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
        }
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            max = Math.max(max,dp[i]);
        }
        return max;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
