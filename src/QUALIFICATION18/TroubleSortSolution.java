package QUALIFICATION18;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 07/04/18
 **/
public class TroubleSortSolution {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                int n = in.readInt();
                int ar[] = new int[n];
                int sar[] = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = in.readInt();
                    sar[i] = ar[i];
                }
                Arrays.sort(sar);
                Vector<Integer> subvec = new Vector<>();
                for (int i = 0; i < n; i+=2) {
                    subvec.add(ar[i]);
                }
                Collections.sort(subvec);
                for (int i = 0, j = 0; i < n; i+=2) {
                    ar[i] = subvec.get(j++);
                }
                subvec.clear();
                for (int i = 1; i < n; i+=2) {
                    subvec.add(ar[i]);
                }
                Collections.sort(subvec);
                for (int i = 1, j = 0; i < n; i+=2) {
                    ar[i] = subvec.get(j++);
                }
                int ans = -1;
                for (int i = 0; i < n; i++) {
                    if (ar[i] != sar[i]) {
                        ans = i;
                        break;
                    }
                }
                if (ans == -1) {
                    out.write("Case #"+(t + 1)+": OK");
                }
                else {
                    out.write("Case #"+(t + 1)+": "+Integer.toString(ans));
                }
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
