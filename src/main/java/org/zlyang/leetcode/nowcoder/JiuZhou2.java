package org.zlyang.leetcode.nowcoder;

/**
 * @author: zlyang
 * @date: 2022-08-28 14:47
 * @description:
 */
public class JiuZhou2 {

    public String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();
        int carry= 0;
        for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--) {
            int sum = carry;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;//若已遍历到首端无字符了便以0代替
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);//添加到StringBuffer中
            carry = sum / 2;//判断有无进位
        }
        ans.append(carry == 1 ? carry : "");//判断是否要进多一位
        return ans.reverse().toString();//反转并转化为字符串类型,注意String和StringBuffer是不同类型
    }

    public static void main(String[] args) {
        JiuZhou2 solution = new JiuZhou2();
        String s = solution.addBinary("0", "1");
        System.out.println(s);
    }

}
