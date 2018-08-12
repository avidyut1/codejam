package KICKSTART18D;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 29/07/18
 **/
public class Candies {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 1; t <= tc; t++) {
                int n = in.readInt();
                int o = in.readInt();
                long d = in.readLong();
                int x1 = in.readInt();
                int x2 = in.readInt();
                int a = in.readInt();
                int b = in.readInt();
                int c = in.readInt();
                int m = in.readInt();
                int l = in.readInt();
                int s[] = new int[n + 1];
                int x[] = new int[n + 1];
                s[1] = x1 + l; s[2] = x2 + l;
                x[1] = x1; x[2] = x2;
                for (int i = 3; i <= n; i++) {
                    x[i] = (int)((((long) a * x[i - 1]) % m + (((long)b * x[i - 2]) % m) + c) % m);
                    s[i] = x[i] + l;
                }
                long ans = Long.MIN_VALUE;
                long prefix[] = new long[n + 1];
                prefix[0] = 0;
                for (int i = 1; i <= n; i++) {
                    prefix[i] += s[i];
                    prefix[i] += prefix[i - 1];
                }
                int startIndex = -1;
                int oddCount = 0;
                TreeMap<Long, Integer> treeMap = new TreeMap<>();
                for (int i = 1; i <= n; i++) {
                    if(Math.abs(s[i]) % 2 == 1) {
                        oddCount++;
                    }
                    treeMap.put(prefix[i - 1], treeMap.containsKey(prefix[i - 1]) ? treeMap.get(prefix[i - 1]) + 1 : 1);
                    while(oddCount > o) {
                        startIndex++;
                        if (startIndex - 1 >= 0) {
                            if (treeMap.get(prefix[startIndex - 1]) == 1) {
                                treeMap.remove(prefix[startIndex - 1]);
                            }
                            else {
                                treeMap.put(prefix[startIndex - 1], treeMap.get(prefix[startIndex - 1]) - 1);
                            }
                        }
                        if (Math.abs(s[startIndex]) % 2 == 1) {
                            oddCount--;
                        }
                    }
                    if (startIndex > i)
                        continue;
                    Long higherKey = treeMap.ceilingKey(prefix[i] - d);
                    if (higherKey != null) {
                        ans = Math.max(ans, prefix[i] - higherKey);
                    }
                }
                if (ans == Long.MIN_VALUE) {
                    out.write("Case #"+t+": IMPOSSIBLE");
                }
                else {
                    out.write("Case #"+t+": "+ans);
                }
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
