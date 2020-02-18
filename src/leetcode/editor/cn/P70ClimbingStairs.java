//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划
/**
 * 方法一： 斐波那契数列公式：
 */
package leetcode.editor.cn;
//Java：爬楼梯
public class P70ClimbingStairs{
    public static void main(String[] args) {
        Solution solution = new P70ClimbingStairs().new Solution();
        // TO TEST
        int resoult = solution.climbStairs(4);
        System.out.println(resoult);
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
    //方式一：斐波那契数列公式
/*class Solution {
    public int climbStairs(int n) {
        //定义一个根号5
        double sqrt_5 = Math.sqrt(5);
        double fib_n = Math.pow((1 + sqrt_5) / 2, n + 1) - Math.pow((1 - sqrt_5) / 2, n + 1);
        return (int) (fib_n / sqrt_5);
    }
}*/

    /**
     * 方法二：
     *     1。爬上n-1阶方法的数量+再爬1阶
     *     2。爬上n-2阶方法的数量+再爬2阶。
     *     公式：f(n) = f(n-1) + f(n-2);
     *     f(0) = 1,  f(1) = 1
     *     本方法是给定了f(0)=1,f(1)=1,;
     *     把所有的f(n) = f(n-1) + f(n-2);
     *                 = f(n-2) + f(n-3) + f(n-3) + f(n-4);
     *                 = ......
     *                 = X * f(0) +  Y *f(1)
     */
/*    class Solution {
        public int climbStairs(int n) {
            int[] f = new int[n + 1];
            f[0] = 1;
            f[1] = 1;
            for (int i =2; i <= n; i++) {
                f[i] = f[i - 1] + f[i - 2];
            }
            return f[n];
        }
    }*/

    /**
     * 简单实现方法：
     * b = b + a;  b=2;
     * a = b - a;  a=1;
     * b = b + a;  b=3;
     * a = b - a;  a=2;
     * f(n) = f(n-1) + f(n -2);
     * .....
     * f(0)=1, f(1)=1,
     * f(4) = f(3) + f(2)
     *      = f(2) + f(1) + f(2);
     */
    class Solution {
        public int climbStairs(int n) {
            int a = 1,b = 1;//f(0)=1,f(1)=1
            while (n-- > 0) {
                a = (b += a) - a;//f(b)=f(0) + f(1);f(a) = f(0) + f(1) - f(0)
            }
            return a;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)
}