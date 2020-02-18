//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针

package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.*;

/**
 *Java：三数之和
 */
public class P15ThreeSum{
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
        // TO TEST
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = solution.threeSum(nums);
        for (List i:lists) {
            System.out.println(i);
        }
    }
    

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方案一：暴力法，直接三层循环
     * 结果会出现重复数据
     */
/*    class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    }
                }
            }
        }
        return res;
    }
}*/


    /**
     * 方案二：
     * 首先对该数组进行排序，然后进行判断：
     *     当数组长度小于3，直接return;
     *     当nums[i] > 0,则三数之和一定大于0，因为一开始已经排序了，直接break;
     *
     */
/*    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            int len = nums.length;
            if (nums == null || len < 3) {
                return ans;
            }
            Arrays.sort(nums);//排序
            for (int i = 0; i < len; i++) {
                if (nums[i] > 0) {
                    //如果当前数字>0，则三数之和一定大于0，则结束循环
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    //如果当前数字重复，则跳过。
                    continue;
                }
                int L = i + 1;
                int R = len - 1;
                while (L < R) {
                    int sum = nums[i] + nums[L] + nums[R];
                    if (sum == 0) {
                        ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                        while (L < R && nums[L] == nums[L+1]) {
                            L++;
                        }
                        while (L < R && nums[R] == nums[R-1]) {
                            R--;
                        }
                        L++;
                        R--;
                    }
                    else if (sum < 0) {
                        L++;
                    }
                    else if (sum > 0) {
                        R--;
                    }
                }
            }
            return ans;
        }
    }*/


    /**
     * 方案二的改进：（推荐）
     * 也是用到了双向指针
     */

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums);//排序
            for (int i = 0; i < nums.length - 2; i++) {
                if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                    int L = i + 1, R = nums.length - 1, sum = 0 - nums[i];
                    while (L < R) {
                        if (nums[L] + nums[R] == sum) {
                            ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                            while (L < R && nums[L] == nums[L+1]) {
                                //去重
                                L++;
                            }
                            while (L < R && nums[R] == nums[R-1]) {
                                //去重
                                R--;
                            }
                            L++;
                            R--;
                        } else if (nums[L] + nums[R] < sum) {
                            //向右移动
                            L++;
                        }else {
                            //向左移动
                            R--;
                        }
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}