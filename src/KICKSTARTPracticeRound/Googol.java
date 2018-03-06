package KICKSTARTPracticeRound;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 05/03/18
 **/
public class Googol {
    public static final int maxbit = 60;
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                long k = in.readLong();
                int ans = solve(maxbit, k);
                out.write("Case #"+(t + 1)+": "+ans);
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // sn = sn-1 + "0" + switch(reverse(sn - 1))
    // 2 ** 60 ~ 10 ^ 18
    // checking for every bit, evaluating for bit - 1
    // because this bit value comes from bit - 1
    // if k == len + 1, then it is the value at k = 0
    // because mid part is "0" in sn
    // otherwise if k > len
    // solving for bit - 1, with reverse k
    // and then switching the result
    private static int solve(int bit, long k) {
        long len = (1L << (bit - 1)) - 1;
        if (k <= len) {
            return solve(bit - 1, k);
        }
        else if (k == len + 1) {
            return 0;
        }
        else {
            k -= len + 1;
            int val = solve(bit - 1, len + 1 - k);
            return val == 1 ? 0 : 1;
        }
    }
}
