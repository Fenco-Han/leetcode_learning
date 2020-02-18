//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表

package leetcode.editor.cn;

import com.sun.jmx.snmp.SnmpNull;

/**
 * Java：两两交换链表中的节点
 */
public class P24SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new P24SwapNodesInPairs().new Solution();
        // TO TEST
    }


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }


    /**
     * 方法二：
     * 定义一个
     *
     */
/*    class Solution {
    public ListNode swapPairs(ListNode head) {
        //设置哨兵节点prehead,并指定为0，最后直接输出prehead.next即为结果
        ListNode prehead = new ListNode(0);
        prehead.next = head;
        //设置prev指针用来做下标。(最关键的就是prev,因为下面用到的start,end都是从prev来，
        // 所以，当改变prev的值时，等下一个循环时，就可以再次进行交换。)
        ListNode prev = prehead;
        while (prev.next != null && prev.next.next != null) {
            ListNode start = prev.next;
            ListNode end = prev.next.next;
            //将prehead节点指向end节点，0-->2
            prev.next = end;
            //第一个节点指向end之后的节点1-->3
            start.next = end.next;
            //end节点指向第一个节点 2-->1
            end.next = start;
            //综上：0-->2-->1-->3-->4,这里仅仅只是2和1位置变化了，要继续变化位置
            //所以，要将原来prev指针改变位置，进而start,end也会变化。
            //我们要变成1-->4-->3,所以1变成原来的0
            prev = start;
            //这时候根据上面，prev为1的下标，strat = prev.next,则，start为3的下标
            //end = prev.next.next,则，end为4的下标。则有一次交换指针开始了。
        }
        return prehead.next;
    }
}*/


    /**
     * 递归方式
     * [1,2,3,4,5,6]
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {
            //判断为null的话，直接return
            if (head == null || head.next == null) {
                return head;
            }
            //1的下标为head,定义2的下标为next;
            ListNode next = head.next;
            //让1指向f(3,4,5,6,null);
            head.next = swapPairs(next.next);
            //让2指向1
            next.next = head;
            //综上2-->1-->f(3,4,5,6,null)
            //f(3,4,5,6):4-->3-->f(5,6，null);
            //f(5,6):6-->5-->f(null)
            //结果：2->1->4->3->6->5->null
            return next;
        }
    }
}