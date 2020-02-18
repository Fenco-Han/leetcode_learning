//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表

package leetcode.editor.cn;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

/**
 * Java：反转链表
 */
public class P206ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new P206ReverseLinkedList().new Solution();
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
            next = null;
        }
    }


    /**
     *方法一：使用递归
     */
/*    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode prev = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return prev;
        }
    }*/


    /**
     * 方法二：使用迭代
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null || curr.next != null) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            return prev;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

