//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针

package leetcode.editor.cn;

/**
 * Java：移动零
 *
 * @author fenco
 */
public class P283MoveZeroes {
    public static <nums> void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        int[] nums = {1, 0, 3, 0, 0, 2, 3};
        solution.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num);
        }
    }


    /**
     * 方法1：遍历所有的数，并统计0的个数，将所有非0数往前移动，最后在数组末尾添加所统计个数的0。
     * ps:每个非0数往前移动的步数就是该非0数前面0的个数。
     * 执行用时：0ms  |   内存消耗37.9MB
     */
/*    static class Solution {
        public void moveZeroes(int[] nums) {
            //统计0的个数
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    count++;
                } else {
                    //非0数往前移动步数就是该非0数前面0的个数。
                    nums[i - count] = nums[i];
                }
            }
            //在数组末尾添加0
            for (int i = nums.length - count; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }*/

    /**
     * 对与方法1的改进：
     * 1.通过交换改进在尾部添加0
     * 2.通过判断count是否>0避免不必要的交换
     * 执行用时：0ms  |   内存消耗37.5MB
     */
/*    static class Solution {
        public void moveZeroes(int[] nums) {
            //统计0的个数
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    count++;
                } else if (count > 0) {
                    //如果前面判断有0，则进行交换：每个非0数往前移动的步数就是该非0数前面0的个数。
                    //同时把0交换到尾部。
                    int temp = nums[i - count];
                    nums[i - count] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }*/

    /**
     * 方法2：把所有非零数移动至前面，后面不补零。
     * 用i来指向为零的下标
     * 用j来向前遍历
     * 执行用时：0ms  |   内存消耗37.6MB
     */
/*    static class Solution {
        public void moveZeroes(int[] nums) {
            int i = 0;
            //当该数为非零时，i==j。
            //当该数为0时，i>j.就相当于，每次遇到零时，i++,故i就是记录了零的个数。
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != 0) {
                    nums[i] = nums[j];
                    i++;
                }
            }
            for ( int p = i; p < nums.length; p++) {
                nums[p] = 0;
            }
        }

        1030023
        i=1 j=1
        j=2

    }*/

    /**
     * 对方案2的优化失败：内存消耗变多
     * 执行用时：0ms  |   内存消耗38.1MB
     */
/*    static class Solution {
        public void moveZeroes(int[] nums) {
            int i = 0;
            int j = 0;
            for (; j < nums.length; j++) {
                if (nums[j] != 0) {
                    nums[i++] = nums[j];
                }
            }
            for (; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }*/


    /**
     * 根据方案2的改编。
     * 执行用时：0ms  |   内存消耗37.6MB
     */
/*    static class Solution {
        public void moveZeroes(int[] nums) {
            int i = 0;
            int j = 0;
            for (; j < nums.length; j++) {
                if (nums[j] != 0) {
                    nums[i] = nums[j];
                    if (i != j) {
                        nums[j] = 0;
                    }
                    i++;
                }
            }
        }
    }*/


    //总结：
    //方案1：遍历数组，统计零的个数，将非零数移动至前面，末尾插入统计的零的个数。或者将0移动至末尾。
    //方案2：一边遍历一边互换位置，直到把所有的零移动至末尾。


    /**
     * 外网解决方案：与方案2一致。但是代码看着简单。
     */
    static class Solution {
        public void moveZeroes(int[] nums) {
            if (nums == null || nums.length == 0) return;

            int insertPos = 0;
            for (int num: nums) {
                if (num != 0) nums[insertPos++] = num;
            }

            while (insertPos < nums.length) {
                nums[insertPos++] = 0;
            }
        }
    }
}

