package KICKSTART17E;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;

//WA
public class TrapeziodCounting {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                int n = in.readInt();
                Map<Long, Integer> freq = new HashMap<>();
                Vector<Long> lengths = new Vector<>();
                Set<Long> uniqueLengths = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    long size = in.readLong();
                    lengths.add(size);
                    freq.put(size, freq.containsKey(size) ? freq.get(size) + 1 : 1);
                    uniqueLengths.add(size);
                }
                Collections.sort(lengths);
                long ans = 0l;
                for (long c: uniqueLengths) {
                    if (freq.get(c) >= 2) {
                        for (long b: lengths) {
                            if (b == c)
                                continue;
                            long maxa = 2 * c + b - 1;
                            int count = upperBound(lengths, 0, lengths.size() - 1, maxa);
                            int count2 = Collections.binarySearch(lengths, b);
                            if (c >= b + 1 && c < b + (2 * c)) {
                                ans += (count - count2 - freq.get(c)) * nc2((long)freq.get(c));
                            }
                            else {
                                ans += (count - count2) * nc2((long)freq.get(c));
                            }
                        }
                    }
                }
                for (long c: uniqueLengths) {
                    if (freq.get(c) >= 3) {
                        for (long b: uniqueLengths) {
                            if (b != c) {
                                if (c > b || (c < b && 3 * c > b)) {
                                    ans += nc3((long)freq.get(c)) * freq.get(b);
                                }
                            }
                        }
                    }
                }
                out.write(Long.toString(ans));
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int upperBound(Vector<Long> v, int l, int h, long ele) {
        int mid = (l + h) >> 2;
        if (l < h) {
            while(v.get(h) > ele) {
                h--;
            }
            return h;
        }
        if (v.get(mid) == ele) {
            if (mid + 1 < v.size()) {
                if (v.get(mid + 1) > ele) {
                    return mid;
                }
            }
            else {
                return mid;
            }
        }
        if (v.get(mid) >= ele) {
            return upperBound(v, mid, h, ele);
        }
        else {
            return upperBound(v, l, mid, ele);
        }
    }
    public static long nc2(long n) {
        return (n * (n - 1)) / 2;
    }
    public static long nc3(long n) {
        return (n * (n - 1) * (n - 2)) / 6;
    }
}
