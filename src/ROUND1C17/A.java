package ROUND1C17;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 30/04/17
 **/
public class A {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 1; t <= tc; t++) {
                int n = in.readInt();
                int kc = in.readInt();
                Cylinder ar[] = new Cylinder[n];
                for (int i = 0; i < n; i++) {
                    long r = in.readLong();
                    long h = in.readLong();
                    ar[i] = new Cylinder(r, h);
                }
                Arrays.sort(ar, Collections.reverseOrder());
                Cylinder sortedAr[] = new Cylinder[kc];
                for (int i = 0; i < kc; i++) {
                    sortedAr[i] = ar[i];
                }
                Arrays.sort(sortedAr, new Comparator<Cylinder>() {
                    @Override
                    public int compare(Cylinder o1, Cylinder o2) {
                        if (o1.r > o2.r) {
                            return -1;
                        }
                        else if(o1.r < o2.r) {
                            return 1;
                        }
                        else if (o1.h > o2.h) {
                            return -1;
                        }
                        else {
                            return 1;
                        }
                    }
                });
                ar = sortedAr;
                int k = kc;
                double ans = (2 * Math.PI * ar[0].r * ar[0].h);
                k--;
                if (k == 0) {
                    ans += Math.PI * ar[0].r * ar[0].r;
                }
                if (k > 0) {
                    long prevRadius = ar[0].r;
                    int prevIndex = 0;
                    for (int i = 1; i < n; i++) {
                        if (ar[i].r > prevRadius) {
                            continue;
                        }
                        k--;
                        ans += (2 * Math.PI * ar[i].r * ar[i].h);
                        ans += (Math.PI * ar[prevIndex].r * ar[prevIndex].r) - (Math.PI * ar[i].r * ar[i].r);
                        prevRadius = ar[i].r;
                        prevIndex = i;
                        if (k == 0) {
                            ans += Math.PI * ar[i].r * ar[i].r;
                            break;
                        }
                    }
                }
                System.out.printf("Case #" + t + ": " + "%.9f\n", ans);
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Cylinder implements Comparable<Cylinder>{
    public long r; long h;
    public Cylinder(long r, long h) {
        this.r = r;
        this.h = h;
    }
    public int compareTo(Cylinder that) {
        Long fv = this.r * this.h;
        Long sv = that.r * that.h;
        if (fv.equals(sv)) {
            if (this.r < that.r) {
                return -1;
            }
            else if (this.r > that.r) {
                return 1;
            }
            else if (this.h < that.h) {
                return -1;
            }
            else return 1;
        }
        else {
            return fv.compareTo(sv);
        }
    }
}

