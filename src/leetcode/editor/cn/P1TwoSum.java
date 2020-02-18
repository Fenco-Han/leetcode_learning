//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：两数之和
public class P1TwoSum{
    public static void main(String[] args) {
        Solution solution = new P1TwoSum().new Solution();
        // TO TEST
        int[] arr = {2,7,11,15};
        int target = 9;
        int[] results = solution.twoSum(arr,target);
        for (int i = 0; i < results.length; i++) {
            System.out.print(results[i]);
        }
    }


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一：
     * 暴力法：遍历每一个元素，运用两层for循环。进行判断
     */
/*    class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] {i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}*/
//总结：时间复杂度为：O(n^2)
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 方法二：
     * 两遍哈希表，通过空间换时间从O(n)-->O(1)
     */
/*    class Solution {
        public int[] twoSum(int[] nums, int target) {
            //声明一个HashMap
            Map<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                //利用map将数组元素与索引一一对应
                map.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                //现将所有能够满足target - num[i],找出，然后再去刚才保存的map中查询。
                int complement = target - nums[i];
                //找到所有满足complement且与i不冲突的
                if (map.containsKey(complement) && map.get(complement) != i) {
                    return new int[] {i, map.get(complement)};
                }
            }
            throw new IllegalArgumentException("No two sum solution")
        }
    }*/


    /**
     * 方法二：改进，使用一遍哈希表（执行用时：3ms）
     */
/*    class Solution {
        public int[] twoSum(int[] nums, int target) {
            //声明一个HashMap
            Map<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                //现将所有能够满足target - num[i],找出，然后再去之后保存的map中查询。
                int complement = target - nums[i];
                //找到所有满足complement且与i不冲突的
                if (map.containsKey(complement) && map.get(complement) != i) {
                    return new int[] {i, map.get(complement)};
                }
                //利用map将数组元素与索引一一对应
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }*/

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] map = new int[2048];
            for (int i = 0; i < nums.length; i++) {
                int b = map[(target - nums[i]) & 2047];
                if (b != 0) {
                    return  new int[] {b-1,i};
                }
                map[nums[i] & 2047] = i + 1;
            }
            return null;
        }
    }
}