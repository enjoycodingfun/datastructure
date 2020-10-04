//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 
// 👍 644 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

//Java：翻转二叉树
public class P226翻转二叉树{
    public static void main(String[] args) {
        Solution solution = new P226翻转二叉树().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://mp.weixin.qq.com/s/izZ5uiWzTagagJec6Y7RvQ
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        //反转根节点的左右子节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        //如此递归调用即可
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
