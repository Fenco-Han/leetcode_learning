//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组

package leetcode.editor.cn;
//Java：加一
public class P66PlusOne{
    public static void main(String[] args) {
        Solution solution = new P66PlusOne().new Solution();
        // TO TEST
        int[] arr= {9,9,9,9};
        int[] re = solution.plusOne(arr);
        for (int i =0; i< re.length; i++) {
            System.out.println(re[i]);
        }
    }


    /**
     * 1.末尾没有进位，直接在末尾加一。前面也不会产生进位，直接返回。
     * 2.末尾有进位，中间进位停止，则需要找到进位标示，
     */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            //末尾没有进位，直接返回，有进位进入下一个循环处理下一位，知道至最后一位，发现
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0)
                return digits;
        }
        //循环到最后一位之后发现居然是10%10，故增加数组长度，向前进位
            digits = new int[len + 1];
            digits[0] = 1;
            return digits;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}