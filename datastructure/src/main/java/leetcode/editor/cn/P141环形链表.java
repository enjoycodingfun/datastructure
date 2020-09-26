//给定一个链表，判断链表中是否有环。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的
//位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。 
//
// 如果链表中存在环，则返回 true 。 否则，返回 false 。 
//
// 
//
// 进阶： 
//
// 你能用 O(1)（即，常量）内存解决此问题吗？ 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 104] 
// -105 <= Node.val <= 105 
// pos 为 -1 或者链表中的一个 有效索引 。 
// 
// Related Topics 链表 双指针 
// 👍 762 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;
import leetcode.editor.cn.common.ListNode;

//Java：环形链表
public class P141环形链表{
    public static void main(String[] args) {
        Solution solution = new P141环形链表().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        /**
         * 经典的快慢指针题，定义一个快指针，定义一个慢指针，慢指针一次挪动一步，快指针一次挪动两步，如果链表有环，一定会再次相遇
         */
        //下面使用快慢指针的方式，时间复杂度（O(N),空间复杂度O(1)）
        //如果为空链表或者只有一个节点，肯定没有环
        if(head == null || head.next == null){
            return false;
        }
        /*
        //定义快慢指针,并初始化
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            //快指针移动两步，慢指针移动一步
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow){
                return true;
            }
        }
        return false;*/
        /**
         * 下面使用最常规的方法时间复杂度和空间复杂度都为O(N)
         */
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode cur = head;
        while (cur != null){
            if (nodeSet.contains(cur)){
                return true;
            }else{
                nodeSet.add(cur);
                cur = cur.next;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
