/*
//给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例: 
//
// 输入: [1,8,6,2,5,4,8,3,7]
//输出: 49 
// Related Topics 数组 双指针

package leetcode.editor.cn;
*/
/**
 *Java：盛最多水的容器
 *//*

public class P11ContainerWithMostWater{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        int[] height = {1,8,6,2,5,4,8,3,7};
        int maxArea = solution.maxArea(height);
        System.out.println(maxArea);
    }
    

//leetcode submit region begin(Prohibit modification and deletion)

    */
/**
     * 方案一：双指针法（推荐）
     * 定义i,j分别在容器两端，向中间聚集，只到i==j结束，定义最大容积为res
     * 利用三元函数，当height[i]与height[j]比较，取最小值。
     * 当height[i]较小时，则res = Math.max(res, (j -i) * height[i++])
     * 当height[j]较小时，则res = Math.max(res, (j -i) * height[j--])
     *//*

*/
/*    class Solution {
    public int maxArea(int[] height) {
        int j,res;
        int i = 0; j = height.length - 1; res = 0;
        while (i < j) {
            res = height[i] < height[j] ? Math.max(res, (j - i) * height[i++]) : Math.max(res, (j - i) * height[j--]);
        }
        return res;
        }
    }*//*


    */
/**
     * 方案二：暴力法
     * 定义i，j = i+1，两层循环得到容积的最大
     * 问题，有好多本身冗余的值
     *//*

    class Solution {
        public int maxArea(int[] height) {
         int res = 0;
         for (int i = 0; i < height.length; i++) {
             for (int j = i + 1; j < height.length; j++) {
                 res = Math.max(res,Math.min(height[i],height[j]) * (j - i));
                 return res;
             }
         }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
*/
