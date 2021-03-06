//给你一个升序排列的整数数组 nums ，和一个整数 target 。 
//
// 假设按照升序排序的数组在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。 
//
// 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// nums 肯定会在某个点上旋转 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 二分查找 
// 👍 1045 👎 0


package leetcode.editor.cn;

//Java：搜索旋转排序数组
public class P33搜索旋转排序数组 {

    public static void main(String[] args) {
        Solution solution = new P33搜索旋转排序数组().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int search(int[] nums, int target) {
            /**
             * 方法一：傻瓜式操作
             */
           /* for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }
            return -1;*/
            /**
             * 方法二：二分查找，参考https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/duo-si-lu-wan-quan-gong-lue-bi-xu-miao-dong-by-swe/
             */
            int left = 0, right = nums.length-1;
            while (left <= right){
                int mid = left +(right-left)/2;
                if (nums[mid] == target){
                    return mid;
                }
                //根据mid值与nums[left]关系判断mid在左段还是右段
                if (nums[mid]>=nums[left]){
                    //mid值在左段，接下来判断目标值与mid坐标值的关系
                    if (target >= nums[left] && target < nums[mid]){
                        right = mid - 1;
                    }else {
                        left = mid + 1;
                    }
                }else{
                    if (target > nums[mid] && target <= nums[right]){
                        left = mid + 1;
                    }else{
                        right = mid -1;
                    }
                }
            }
            return -1;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
