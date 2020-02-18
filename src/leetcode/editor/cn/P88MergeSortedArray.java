//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针

package leetcode.editor.cn;

import java.util.Arrays;

/**
 *
 *Java：合并两个有序数组
 * @author fenco
 */
public class P88MergeSortedArray{
    public static void main(String[] args) {
        Solution solution = new P88MergeSortedArray().new Solution();
        // TO TEST
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        solution.merge(nums1,6,nums2,3);
        for (int i:nums1) {
            System.out.println(nums1[i]);
        }
    }
    

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方案一：1ms,36.1MB
     * 合并后排序a
     * 时间复杂度：O((m+n)log(m+n))
     * 空间复杂度：O（1）
     */
/*    class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }
}*/


    /**
     * 方案二：双指针，从前往后
     * nums1:【1，2，3，0，0，0】   nums2:【2，5，6】  nums1_copy:【1,2,3,0,0,0】
     *         p                         p2                     p1
     */
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            //复制一份
            int [] nums1_copy = new int[m];
            System.arraycopy(nums1, 0, nums1_copy, 0, m);

            //p1为nums1的开头，p2为nums2的开头
            int p1 = 0;
            int p2 = 0;
            int p = 0;
            while ((p1 < m) && (p2 < n)) {
                nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
            }
            if (p1 < m) {
                System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
            }
            if (p2 < n) {
                System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}