//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

package leetcode.editor.cn;

import java.util.List;

/**
 *Java：合并两个有序链表
 */
public class P21MergeTwoSortedLists{
    public static void main(String[] args) {
        Solution solution = new P21MergeTwoSortedLists().new Solution();
        // TO TEST
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}



/**
 * 递归方法：利用mergeTwoLists本身进行递归。
 */
/*class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }else if (l2 == null) {
            return l1;
        }else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else if (l1.val > l2.val) {
            l2.next = mergeTwoLists(l1,l2.next);
        }return l2;
    }
}*/
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 迭代
     */
    class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //设置哨兵节点prehead，并指定为-1
        ListNode prehead = new ListNode(-1);
        //设置prev指针用来做下标。
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                //则prev.next指向较小的
                prev.next = l1;
                //由于该l1已经比较过了，所以向后移动一位，l1 = l1.next;
                l1 = l1.next;
            }else {
                prev.next = l2;
                l2 = l2.next;
            }
            //一轮比较结束后，将prev也向后移动一位
            prev = prev.next;
        }
        //全部比较结束后，prev.next 指向不为null的值。
        //由于最有一轮比较结束后出现了l1 == null或者l2 == null,
        // 所以接下来也就是说某一链表已经没有元素了。
        //所以直接将prev.next指向不为null的那个链表就行。
        prev.next = l1 == null ? l2 : l1;
        //返回prehead.next指向的链表即为合并之后的链表。
        return prehead.next;
    }
}
}