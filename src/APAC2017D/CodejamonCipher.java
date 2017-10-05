package APAC2017D;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class CodejamonCipher {
    public static long dp[];
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 1; t <= tc; t++) {
                int n = in.readInt();
                int m = in.readInt();
                int freq[][] = new int[n][26];
                for (int i = 0; i < n; i++) {
                    char s[] = in.readLine().toCharArray();
                    for (int j = 0; j < s.length; j++) {
                        freq[i][s[j] - 'a']++;
                    }
                }
                out.write("Case #"+t+": ");
                for (int i = 0; i < m; i++) {
                    char st[] = in.readLine().toCharArray();
                    dp = new long[st.length];
                    int MOD = (int)1e9 + 7;
                    Arrays.fill(dp, -1);
                    out.write(Long.toString(go(0, st, freq, MOD))+" ");
                }
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static long go(int index, char st[], int freq[][], int MOD) {
        if (index >= st.length) {
            return 1;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        dp[index] = 0;
        int freqc[] = new int[26];
        for (int i = index; i < st.length; i++) {
            freqc[st[i] - 'a']++;
            for (int j = 0; j < freq.length; j++) {
                if (Arrays.equals(freqc, freq[j])) {
                    dp[index] += go(i + 1, st, freq, MOD);
                    dp[index] %= MOD;
                }
            }
        }
        return dp[index];
    }
}
