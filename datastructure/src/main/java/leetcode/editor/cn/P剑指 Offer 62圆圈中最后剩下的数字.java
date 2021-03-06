//0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。 
//
// 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。 
//
// 
//
// 示例 1： 
//
// 输入: n = 5, m = 3
//输出: 3
// 
//
// 示例 2： 
//
// 输入: n = 10, m = 17
//输出: 2
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10^5 
// 1 <= m <= 10^6 
// 
// 👍 274 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;

//Java：圆圈中最后剩下的数字
public class P剑指 Offer 62圆圈中最后剩下的数字{
    public static void main(String[] args) {
        Solution solution = new P剑指 Offer 62圆圈中最后剩下的数字().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lastRemaining(int n, int m) {
        //return method1(n,m);
        return method2(n,m);
    }

        /**
         * 最后只剩下一个元素，假设这个最后存活的元素为 num, 这个元素最终的的下标一定是0 （因为最后只剩这一个元素），
         * 所以如果我们可以推出上一轮次中这个num的下标，然后根据上一轮num的下标推断出上上一轮num的下标，
         * 直到推断出元素个数为n的那一轮num的下标，那我们就可以根据这个下标获取到最终的元素了。推断过程如下：
         *
         * 首先最后一轮中num的下标一定是0， 这个是已知的。
         * 那上一轮应该是有两个元素，此轮次中 num 的下标为 (0 + m)%n = (0+3)%2 = 1; 说明这一轮删除之前num的下标为1；
         * 再上一轮应该有3个元素，此轮次中 num 的下标为 (1+3)%3 = 1；说明这一轮某元素被删除之前num的下标为1；
         * 再上一轮应该有4个元素，此轮次中 num 的下标为 (1+3)%4 = 0；说明这一轮某元素被删除之前num的下标为0；
         * 再上一轮应该有5个元素，此轮次中 num 的下标为 (0+3)%5 = 3；说明这一轮某元素被删除之前num的下标为3；
         * ....
         *
         * 因为我们要删除的序列为0-n-1, 所以求得下标其实就是求得了最终的结果。比如当n 为5的时候，num的初始下标为3，
         *  所以num就是3，也就是说从0-n-1的序列中， 经过n-1轮的淘汰，3这个元素最终存活下来了，也是最终的结果。
         *
         * 总结一下推导公式：(此轮过后的num下标 + m) % 上轮元素个数 = 上轮num的下标
         * @param n
         * @param m
         * @return
         */
        private int method2(int n, int m) {
            int ans = 0;
            for (int i = 2; i <= n; i++) {
                ans = (ans + m)%i;
            }
            return ans;
        }

        /**
         * 方法一：约瑟夫环问题，采用arraylist来模拟，idx从0开始，每次要删除的数字是(idx+m-1),但是由于到结尾的时候需要从0开始，
         * 所以应该是（idx+m-1）%n
         * @param n
         * @param m
         * @return
         */
        private int method1(int n, int m) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
            int idx = 0;
            while (n>1){
                idx = (idx + m -1)%n;
                list.remove(idx);
                n--;
            }
            return list.get(0);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
