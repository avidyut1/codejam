package KICKSTART17B;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class MathEncoder {
    int MOD = (int)1e9 + 7;
    int MAX = (int)1e4 + 1;
    long ncr[][] = new long[MAX][MAX];
    public void precompute() {
        for (int i = 1; i < MAX; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    ncr[i][j] = 1L;
                }
                else if (j == 0) {
                    ncr[i][j] = 1L;
                }
                else {
                    ncr[i][j] = ncr[i - 1][j] + ncr[i - 1][j - 1];
                    ncr[i][j] %= MOD;
                }
            }
        }
    }
    public void solve() {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 1; t <= tc; t++) {
                int n = in.readInt();
                int ar[] = new int[n + 1];
                for (int i = 1; i <= n; i++) {
                    ar[i] = in.readInt();
                }
                Arrays.sort(ar);
                precompute();
                long sum = 0l;
                for (int i = 1; i <= n; i++) {
                    //taking ith as maximum
                    for (int j = 1; j <= i - 1; j++) {
                        sum += (ar[i] * ncr[i - 1][j]);
                    }
                    //taking ith as minimum
                    for (int j = 1; j <= n - i; j++) {
                        sum -= (ar[i] * ncr[n - i][j]);
                    }
                    sum %= MOD;
                }
                if (sum < MOD){
                    sum += MOD;
                }
                out.write("Case #"+t+": ");
                out.write(Long.toString(sum % MOD));
                out.newLine();
            }
            out.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) {
        try {
            MathEncoder mathEncoder = new MathEncoder();
            mathEncoder.solve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
