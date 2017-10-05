package KICKSTART17C;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 26/06/17
 **/
public class AmibougousCipher {
    public static boolean ans;
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 1; t <= tc; t++) {
                ans = true;
                char inp[] = in.readLine().toCharArray();
                int num[] = new int[inp.length];
                for (int i = 0; i < inp.length; i++) {
                    num[i] = inp[i] - 'A';
                }
                int n = inp.length;
                int sol[] = new int[n];
                Arrays.fill(sol, -1);
                sol[1] = num[0];
                sol[n - 2] = num[n - 1];
                for (int i = 3; i < n; i+=2) {
                    sol[i] = ((- sol[i - 2] + num[i - 1]) + 26) % 26;
                }
                for (int i = n - 4; i >= 0; i-=2) {
                    sol[i] = ((- sol[i + 2] + num[i + 1]) + 26) % 26;
                }
                for (int i = 0; i < n; i++) {
                    if (sol[i] == -1) {
                        ans = false;
                    }
                }
                if (ans) {
                    out.write("Case #"+t+ ": ");
                    for (int i = 0; i < n; i++) {
                        out.write(sol[i] + 'A');
                    }
                }
                else {
                    out.write("Case #"+t+ ": AMBIGUOUS");
                }
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
