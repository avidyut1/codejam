package KICKSTART17E;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class CopyandPaste {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 1; t <= tc; t++) {
                char s[] = (" "+in.readLine()).toCharArray();
                int n = s.length - 1;
                //valid[i][j][k] = true if we there is same string from i-j and string starting from k
                //of same length
                boolean valid[][][] = new boolean[n + 1][n + 1][n + 1];
                for (int i = 1; i <= n; i++) {
                    for (int j = i + 1; j <= n; j++) {
                        valid[i][i][j] = (s[i] == s[j]);
                    }
                }
                //O(n3)
//                for (int len = 2; len <= n; len++) {
//                    for (int i = 1; i + len - 1 <= n; i++) {
//                        for (int j = i + len; j + len - 1<= n; j++) {
//                            valid[i][i + len - 1][j] = (valid[i][i + len - 2][j] && s[i + len - 1] == s[j + len - 1]);
//                        }
//                    }
//                }
                //O(n4)
                for (int i = 0; i <= n; i++) {
                    for (int j = i + 1; j <= n; j++) {
                        int len = j - i;
                        for (int k = j + 1; k <= n; k++) {
                            if (k + len <= n) {
                                boolean equal = true;
                                int kindex = k;
                                for (int l = i; l <= j; l++) {
                                    if (s[l] == s[kindex]) {
                                        kindex++;
                                    }
                                    else {
                                        equal = false;
                                    }
                                }
                                if (equal) {
                                    valid[i][j][k] = true;
                                }
                            }
                        }
                    }
                }
                int dp[][][] = new int[n + 1][n + 1][n + 1];
                int INF = (int)1e5 + 1;
                for (int i = 0; i <= n; i++) {
                    for (int j = 0; j <= n; j++) {
                        for (int k = 0; k <= n; k++) {
                            dp[i][j][k] = INF;
                        }
                    }
                }
                int ans[] = new int[n + 1];
                for (int i = 0; i <= n; i++) {
                    ans[i] = INF;
                }
                ans[0] = 1;
                //dp[i][j][k] - solution (min operation) by copying and pasting string
                //from index j to k
                dp[0][0][0]=0;
                for (int i = 1; i <= n; i++) {
                    dp[i][0][0] = dp[i - 1][0][0] + 1;
                    ans[i] = dp[i][0][0];
                    for (int j = 1; j <= n; j++) {
                        for (int k = 1; k <= n; k++) {
                            dp[i][j][k] = dp[i - 1][j][k] + 1;
                            if (i - k + j >= 0 && i - k + j <= n && valid[j][k][i - (k - j)]) {
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - (k - j + 1)][j][k] + 1);
                                dp[i][j][k]= Math.min(dp[i][j][k], ans[i - (k - j + 1)] + 2);
                            }
                            ans[i] = Math.min(ans[i], dp[i][j][k]);
                        }
                    }
                }
                out.write("Case #"+t+": "+Integer.toString(ans[n]));
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
