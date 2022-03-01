package org.zlyang.leetcode.nowcoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * @author ：zlyang
 * @description：
 * @date ：2022/2/28 19:33
 */


public class AandBPowN {
    static final int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            String[] params = br.readLine().split(" ");
            int A = Integer.parseInt(params[0]);
            int B = Integer.parseInt(params[1]);
            int n = Integer.parseInt(params[2]);
            if(n == 1){
                System.out.println(A);
            }else if(n == 2){
                System.out.println(A*A - 2*B);
            }else{
                long dp1 = 2L, dp2 = (long)A, dp = 0L;
                for(int i = 2; i <= n; i++){
                    // 注意相减之后可能越界，加上个MOD防止溢出
                    dp = ((A * dp2) % MOD - (B * dp1) % MOD + MOD) % MOD;
                    dp1 = dp2;
                    dp2 = dp;
                }
                System.out.println(dp);
            }
        }
    }
}
