//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组

package leetcode.editor.cn;

import com.sun.xml.internal.fastinfoset.algorithm.FloatEncodingAlgorithm;

//Java：旋转数组
public class P189RotateArray{
    public static void main(String[] args) {
        Solution solution = new P189RotateArray().new Solution();
        // TO TEST
        int[] nums = {1,2,3,4,5,6,7};
        solution.rotate(nums,3);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
    

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 暴力法：每旋转一次移动一个元素，旋转k次。
     * 时间复杂度：O（n^k）,空间复杂度：O(1)
     */
/*    class Solution {
    public void rotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
}*/
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 使用额外的数组：
     * 【1，2，3，4，5，6，7】 k=3
     * 【5，6，7，1，2，3，4】
     * src:要复制的原数组
     * srcPos:复制原数组起始位置
     * dest:目标数组
     * destPos:目标数组下标位置
     * length:复制的长度
     */
    class Solution {
        public void rotate(int[] nums, int k) {
            if (nums.length <= 1) return;
            k %= nums.length;
            int[] temp = new int[k];
            System.arraycopy(nums, nums.length - k, temp, 0, k);
            System.arraycopy(nums, 0 , nums, k, nums.length - k);
            System.arraycopy(temp, 0, nums, 0, temp.length);
        }
    }


    /**
     * 使用反转：
     * [1,2,3,4,5,6,7]
     * 反转一次：【7，6，5，4，3，2，1】
     * 左侧k位反转：【5，6，7，4，3，2，1】
     * 右侧num.length - k位反转：[5,6,7,1,2,3,4]
     */
/*    class Solution {
        public void rotate(int[] nums, int k) {
            k %= nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums,0,k - 1);
            reverse(nums, k, nums.length - 1);
        }
        public void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }*/
}