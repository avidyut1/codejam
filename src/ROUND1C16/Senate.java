package ROUND1C16;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 20/04/17
 **/
public class Senate {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 1; t <= tc; t++) {
                int n = in.readInt();
                int count[] = new int[n];
                String ans = "";
                for (int i = 0; i < n; i++) {
                    count[i] = in.readInt();
                }
                int allZero[] = new int[n];
                while(!Arrays.equals(allZero, count)) {
                    int max = Integer.MIN_VALUE;
                    for (int i = 0; i < n; i++) {
                        max = Math.max(max, count[i]);
                    }
                    String evac = "";
                    int gz = 0;
                    for (int i = 0; i < n; i++) {
                        if (count[i] == max) {
                            evac += (char)(i + 'A');
                            count[i]--;
                            gz++;
                        }
                    }
                    if (gz > 2) {
                        ans += evac.substring(0, 1)+" ";
                    }
                    else {
                        ans += evac.substring(0, 2)+" ";
                    }
                }
                out.write("Case #"+t+": "+ans);
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
