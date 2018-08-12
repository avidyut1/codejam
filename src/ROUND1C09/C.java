package ROUND1C09;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 16/07/18
 **/
public class C {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 1; t <= tc; t++) {
                int p = in.readInt();
                int q = in.readInt();
                int ar[] = new int[q];
                for (int i = 0; i < q; i++) {
                    ar[i] = in.readInt() - 1;
                }
                long sol1 = 0L;
                long sol2 = 0L;
                TreeSet<Integer> empty = new TreeSet<>();
                for (int i = 0; i < q; i++) {
                    Integer lower = empty.floor(ar[i]);
                    if (lower != null) {
                        sol1 += ar[i] - lower - 1;
                    }
                    else {
                        sol1 += ar[i];
                    }
                    Integer higher = empty.ceiling(ar[i]);
                    if (higher != null) {
                        sol1 += higher - ar[i] - 1;
                    }
                    else {
                        sol1 += p - 1 - ar[i];
                    }
                    empty.add(ar[i]);
                }
                empty.clear();
                for (int i = q - 1; i >= 0; i--) {
                    Integer lower = empty.floor(ar[i]);
                    if (lower != null) {
                        sol2 += ar[i] - lower - 1;
                    }
                    else {
                        sol2 += ar[i];
                    }
                    Integer higher = empty.ceiling(ar[i]);
                    if (higher != null) {
                        sol2 += higher - ar[i] - 1;
                    }
                    else {
                        sol2 += p - 1 - ar[i];
                    }
                    empty.add(ar[i]);
                }
                out.write("Case #"+t+": "+Long.toString(Math.min(sol1, sol2)));
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
