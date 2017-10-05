package APAC2015E;

import java.io.*;
import java.util.*;
import java.math.*;

//TODO
public class PartitionNumber {
    static int ans = 0;
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int t = in.readInt();
            for (int tc = 0; tc < t; tc++) {
                ans = 0;
                int n = in.readInt();
                int d = in.readInt();
                for (int i = d; i <= n; i+=d) {
                    recurse(i, n - i, n);
                }
                System.out.println(ans);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void recurse(int prev, int rem, int total) {
        if (rem < 0) {
            return;
        }
        if (rem == 0) {
            ans++;
            return;
        }
        recurse(prev, rem - prev, total);
        recurse(prev + 1, rem - prev - 1, total);
    }
}
