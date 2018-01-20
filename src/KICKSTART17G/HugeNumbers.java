package KICKSTART17G;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class HugeNumbers {
    public void solve() throws IOException {
        InputReader in = new InputReader(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = in.readInt();
        for (int t = 1; t <= tc; t++) {
            long a = in.readLong();
            long n = in.readLong();
            long p = in.readLong();
            long res = a;
            for (int i = 1; i <= n; i++) {
                res = binPow(res, i, p);
            }
            res %= p;
            out.write("Case #"+t+": "+Long.toString(res));
            out.newLine();
        }
        out.close();
    }
    private long binPow(long a, long b, long MOD) {
        if (a == 1 || b == 0) {
            return 1L;
        }
        long res = binPow(a, b >> 1, MOD);
        res = res % MOD * res % MOD;
        res %= MOD;
        if (b % 2 != 0) {
            res = res * a;
            res %= MOD;
        }
        return res;
    }
    public static void main(String args[]) {
        try {
            HugeNumbers hugeNumbers = new HugeNumbers();
            hugeNumbers.solve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
