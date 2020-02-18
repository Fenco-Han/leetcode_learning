//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
//
// 说明：不允许修改给定的链表。 
//
// 
//
// 示例 1： 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：tail connects to node index 1
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2], pos = 0
//输出：tail connects to node index 0
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 
//
// 示例 3： 
//
// 输入：head = [1], pos = -1
//输出：no cycle
//解释：链表中没有环。
// 
//
// 
//
// 
//
// 进阶： 
//你是否可以不用额外空间解决此题？ 
// Related Topics 链表 双指针

package leetcode.editor.cn;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import sun.awt.windows.WPrinterJob;

import javax.swing.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Java：环形链表 II
 */
public class P142LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new P142LinkedListCycleIi().new Solution();
        // TO TEST
    }


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
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


//leetcode submit region end(Prohibit modification and deletion)


    /**
     * 方法一：利用哈希表
     * 将遍历过的元素保存进去，如果遇到重复的则，return node;
     * 没遇到重复的则visited.add(node);
     * node往后移动，node = node.next;
     */
/*    public class Solution {
        public P142LinkedListCycleIi.ListNode detectCycle(P142LinkedListCycleIi.ListNode head) {
            Set<ListNode> visited = new HashSet<>();

            ListNode node = head;
            while (node != null) {
                if (visited.contains(node)) {
                    return node;
                }
                visited.add(node);
                node = node.next;
            }
            return null;
        }
    }*/


    /**
     * 方法二：Floyd算法
     */
/*    public class Solution {
        //利用快慢指针，先判断是否有环，若有环则返回slow,fast重合位置。
        //备注：slow,fast重合位置不一定就是入环节点。
        // (环形链表 I)只需要判断是否含有环，
        // 而（环形链表 II）,需要返回入环节点。
        private ListNode getIntersect(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    return slow;
                }
            }
            return null;
        }

        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            //获取重合节点
            ListNode index = getIntersect(head);
            if (index == null) {
                return null;
            }
            //重合节点与head节点同步走时，这一次重合点就是入环口节点。
            ListNode start = head;
            ListNode end = index;
            while (start != end) {
                start = start.next;
                end = end.next;
            }
            return start;
        }
    }*/

    /**
     * 方法二的简化版本（推荐）
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    ListNode slow2 = head;
                    while (slow != slow2) {
                        slow = slow.next;
                        slow2 = slow2.next;
                    }
                    return slow;
                }
            }
            return null;
        }
    }
}