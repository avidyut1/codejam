package KICKSTART18A;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 18/03/18
 **/
class Calculator {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 1; t <= tc; t++) {
                long n = in.readLong();
                int countPlus = Integer.MAX_VALUE;
                int countMinus = Integer.MAX_VALUE;
                char num[] = Long.toString(n).toCharArray();
                int numar[] = new int[num.length];
                for (int i = 0; i < num.length; i++) {
                    numar[i] = Integer.parseInt(Character.toString(num[i]));
                }
                int dp[][] = new int[num.length][5];
                for (int i = 0; i < num.length; i++) {
                    Arrays.fill(dp[i], Integer.MAX_VALUE);
                }
                int evend[] = new int[]{2, 4, 6, 8, 10};
                for (int i = 0; i < 5; i++) {
                    if (numar[num.length - 1] <= evend[i]) {
                        dp[num.length - 1][i] = evend[i] - numar[num.length - 1];
                    }
                }
                for (int i = num.length - 2; i >= 0; i--) {
                    for (int j = 0; j < 5; j++) {
                        for (int k = 0; k < 5; k++) {
                            dp[i][j] = Math.min(dp[i][j], (dp[i + 1][k] + ((int) Math.pow(10, 1)) * (evend[j] - numar[i])));
                        }
                    }
                }
                String ans = Integer.toString(Math.min(countMinus, countPlus));
                out.write("Case #"+t+": "+ans);
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


