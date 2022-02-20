package org.zlyang.leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zlyang
 * @date: 2022-02-20 14:18
 * @description:
 */
public class GenerateParentheses {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        backtrack(new StringBuilder(), 0, 0, n);
        return res;
    }

    private void backtrack(StringBuilder sb, int l, int r, int max) {
        if (sb.length() == 2 * max) {
            res.add(sb.toString());
            return;
        }
        if (l < max) {
            sb.append("(");
            backtrack(sb, l+1, r, max);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (l > r) {
            sb.append(")");
            backtrack(sb, l, r+1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    /**
     * 利用迭代的方式，未测试，有bug
     * @param args
     */
//    public class ListNode {
//        int val;
//        StringBuilder par;
//        ListNode() {}
//        ListNode(int val) { this.val = val; }
//        ListNode(int val, StringBuilder par) { this.val = val; this.par = new StringBuilder(par); }
//        ListNode(int val, String par) {this.val = val; this.par = new StringBuilder(par);}
//    }
//    public List<String> generateParenthesis(int n) {
//        LinkedList<ListNode> record = new LinkedList<>();
//        record.add(new ListNode(n, ""));
//        for(int i = 0; i < 2*n; i++){
//            while(record.peek().par.length() == i){
//                ListNode first = record.remove();
//                if(first.val > 0){
//                    record.add(new ListNode(first.val - 1, first.par.toString() + '('));
//                }
//                first.par.append(')');
//                record.add(first);
//            }
//        }
//        return record.stream().map(e -> e.par.toString()).collect(Collectors.toList());
//    }

    public static void main(String[] args) {
        GenerateParentheses o = new GenerateParentheses();
        System.out.println(o.generateParenthesis(3));
    }
}
