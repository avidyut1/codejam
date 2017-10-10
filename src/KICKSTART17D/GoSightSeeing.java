package KICKSTART17D;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 16/07/17
 **/
public class GoSightSeeing {
    private static int ans = -1;
    static long inf = (long)1e18 + 18;
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                int n = in.readInt();
                int ts = in.readInt();
                int tf = in.readInt();
                int s[] = new int[n];
                int f[] = new int[n];
                int d[] = new int[n];
                for (int i = 1; i < n; i++) {
                    s[i] = in.readInt();
                    f[i] = in.readInt();
                    d[i] = in.readInt();
                }
                long dp[][] = new long[n + 1][n + 1];
                for (int i = 0; i <= n; i++) {
                    for (int j = 0; j <= n; j++) {
                        dp[i][j] = inf;
                    }
                }
                //dp[i][j] = Minimum time it takes to reach the ith city after sightseeing j cities
                dp[1][0] = 0;
                for (int i = 1; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        //if we have reached i th city after sight seeing j cities only then we can go to
                        // i + 1 city with j
                        if (dp[i][j] != inf) {
                            dp[i + 1][j] = Math.min(dp[i + 1][j] , get(i , dp[i][j], s, f, d));
                            dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1] , get(i , dp[i][j] + ts, s, f, d));
                        }
                    }
                }
                int ans = -1;
                for (int i = 0; i < n; i++) {
                    if (dp[n][i] <= tf) {
                        ans = i;
                    }
                }
                out.write("Case #"+(t + 1)+": ");
                if (ans == -1)
                    out.write("IMPOSSIBLE");
                else
                    out.write(Integer.toString(ans));
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static long get(int i, long cur, int s[], int f[], int d[]) {
        if (cur >= inf){
            return inf;
        }
        if (cur <= s[i]) {
            return d[i] + s[i];
        }
        long extra = cur - s[i];
        extra = (extra + f[i] - 1L) / f[i];
        extra *= f[i];
        cur = extra + s[i];
        cur += d[i];
        return cur;
    }
}
