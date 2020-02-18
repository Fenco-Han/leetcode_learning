//给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。 
//
// 示例 1: 
//
// 输入: [3,0,1]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [9,6,4,2,3,5,7,0,1]
//输出: 8
// 
//
// 说明: 
//你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现? 
// Related Topics 位运算 数组 数学

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Java：缺失数字
 */
public class P268MissingNumber {
    public static void main(String[] args) {
        Solution solution = new P268MissingNumber().new Solution();
        // TO TEST
    }


    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一：排序
     */
    class Solution {
        public int missingNumber(int[] nums) {
            Arrays.sort(nums);
            int len = nums.length;
            //先判断0是否出现在首位
            if (nums[0] != 0) {
                return 0;
                //判断n是否出现在末位
            } else if (nums[len - 1] != nums.length) {
                return nums.length;
            }
            //若不缺少0，也不缺少n，则在0-n中有缺少的数
            for (int i = 1; i < len; i++) {
                int expectedNum = nums[i - 1] + 1;
                if (nums[i] != expectedNum) {
                    return expectedNum;
                }
            }
            //没有缺失数字
            return -1;
        }
    }


    /**
     * 方法二：哈希表
     */
    class Solution2 {
        public int missingNumber(int[] nums) {
            Set<Integer> numSet = new HashSet<Integer>();
            //把所有序列中的数加入到HashSet中
            for (int num : nums
            ) {
                numSet.add(num);
            }
            for (int number = 0; number <= nums.length; number++) {
                if (!numSet.contains(number)) {
                    return number;
                }
            }
            return -1;
        }
    }


    /**
     * 方法三：位运算
     */
    class Solution3 {
        public int missingNumber(int[] nums) {
            if (nums == null) {
                return 0;
            }
            int missing = nums.length;
            for (int i = 0; i < nums.length; i++) {
                missing ^= i ^ nums[i];
            }
            return missing;
        }
    }


    /**
     * 方法四：数学方法，missing = sum + len;
     * [0,1,2,3,4,5,7,8,9]
     * [0,1,2,3,4,5,6,7,8]
     */
    class Solution4 {
        public int missingNumber(int[] nums) {
            if (nums == null) {
                return 0;
            }
            int len = nums.length;
            int sum = 0;
            for (int i = 0; i < len; i++) {
                sum += (i - nums[i]);
            }
            return sum + len;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
