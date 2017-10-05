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
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                ans = -1;
                int n = in.readInt();
                int ts = in.readInt();
                int tf = in.readInt();
                int s[] = new int[n - 1];
                int f[] = new int[n - 1];
                int d[] = new int[n - 1];
                for (int i = 0; i < n - 1; i++) {
                    s[i] = in.readInt();
                    f[i] = in.readInt();
                    d[i] = in.readInt();
                }
                recurse(n, 0, 0, 0, s, f, d, ts, tf);
                out.write("Case #"+t+": "+Integer.toString(ans));
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void recurse(int n, int citiIndex, int time, int lans, int s[], int f[], int d[], int ts, int tf) {
        if (citiIndex == n - 1) {
            if (time <= tf) {
                ans = Math.max(lans, ans);
            }
            return;
        }
        int newTime = time + ts;
        int x = (int)Math.ceil((double)((newTime) - s[citiIndex]) / (f[citiIndex]));
        while (s[citiIndex] + (x * f[citiIndex]) < newTime) {
            x++;
        }
        newTime = s[citiIndex] + (x * f[citiIndex]) + d[citiIndex];
        recurse(n, citiIndex + 1, newTime, lans + 1, s, f, d, ts, tf);
        newTime = time;
        x = (int)Math.ceil((double)(newTime) - s[citiIndex]) / (f[citiIndex]);
        while (s[citiIndex] + (x * f[citiIndex]) < newTime) {
            x++;
        }
        newTime = s[citiIndex] + (x * f[citiIndex]) + d[citiIndex];
        recurse(n, citiIndex + 1, newTime, lans, s, f, d, ts, tf);
    }
}
