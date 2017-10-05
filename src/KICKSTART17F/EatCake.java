package KICKSTART17F;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class EatCake {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                int n = in.readInt();
                int dp[] = new int[n + 1];
                Arrays.fill(dp, (int)1e5 + 1);
                for (int i = 0; i <= Math.sqrt(n); i++) {
                    dp[i * i] = 1;
                }
                dp[0] = 1;
                for (int i = 1; i <= n; i++) {
                    for (int j = 0; j <= n; j++) {
                        if (i >= j && dp[i - j] >= 1) {
                            dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
                        }
                    }
                }
                System.out.println("Case #"+(t+1)+": "+dp[n]);
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
