//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 例如，上图是一个7 x 3 的网格。有多少可能的路径？ 
//
// 
//
// 示例 1: 
//
// 输入: m = 3, n = 2
//输出: 3
//解释:
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向右 -> 向下
//2. 向右 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向右
// 
//
// 示例 2: 
//
// 输入: m = 7, n = 3
//输出: 28 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10 ^ 9 
// 
// Related Topics 数组 动态规划 
// 👍 735 👎 0


package leetcode.editor.cn;

//Java：不同路径
public class P62不同路径 {

    public static void main(String[] args) {
        Solution solution = new P62不同路径().new Solution();
        // TO TEST
    }

    /**
     * 典型的动态规划，有些像爬楼梯题目
     * https://leetcode-cn.com/problems/unique-paths/solution/dong-tai-gui-hua-by-powcai-2/
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int uniquePaths(int m, int n) {
            /**
             * 未优化版本
             * 假设d[i][j]是到达这个位置的最多路径（对于题目中右下角即为d[m][n]），则很容易知道d[i][j]=d[i][j-1]+d[i-1][j](因为只能向右或者向下)
             * 而第一列和第一行因为在边界上，所以只能有一种方式到达，就是沿着这一行或这一列一直走
             */
            int[][] dp = new int[m][n];
            //对于第一行和第一列的只有一种走法
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            for (int j = 0; j < n; j++) {
                dp[0][j] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
            return dp[m-1][n-1];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
