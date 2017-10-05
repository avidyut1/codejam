package ROUND1A17;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 15/04/17
 **/
public class Ratatouille {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 1; t <= tc; t++) {
                int n = in.readInt();
                int p = in.readInt();
                long ar[] = new long[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = in.readLong();
                }
                long q[][] = new long[n][p];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < p; j++) {
                        q[i][j] = in.readLong();
                    }
                }
                int dp[][] = new int[n][p];
                List<Long> servingsAr[] = new ArrayList[n];
                for (int i = 0; i < n; i++) {
                    servingsAr[i] = new ArrayList<Long>();
                }
                for (int i = 0; i < p; i++) {
                    long servings = q[0][i] / ar[0];
                    double value1 = ((double) 90 / 100) * (ar[0] * servings);
                    double value2 = ((double) 110 / 100) * (ar[0] * servings);
                    if ((value1 - (double)q[0][i] >= 1e-9) && (value2 - (double)q[0][i]) >= 1e-9) {
                        dp[0][i] = 1;
                        servingsAr[0].add(servings);
                    }
                    value1 = ((double) 90 / 100) * (ar[0] * (servings + 1));
                    value2 = ((double) 110 / 100) * (ar[0] * (servings + 1));
                    if (value1 <= q[0][i] && value2 >= q[0][i]) {
                        dp[0][i] = 1;
                        servingsAr[0].add(servings + 1);
                    }
                }
                for (int i = 1; i < n; i++) {
                    for (int j = 0; j < p; j++) {
                        for (Long serving: servingsAr[i - 1]) {
                            double value = ((double) 90 / 100) * (ar[i] * serving);
                            double value2 = ((double) 110 / 100) * (ar[i] * serving);
                            if ((value - (double)q[i][j] >= 1e-9) && (value2 - (double)q[i][j]) >= 1e-9) {
                                dp[i][j] = 1;
                                servingsAr[i].add(serving);
                            }
                        }
                    }
                }
                int ans = 0;
                for (int i = 0; i < p; i++) {
                    ans += dp[n - 1][i];
                }
                out.write("Case #"+(t) + ": ");
                out.write(Integer.toString(ans));
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
