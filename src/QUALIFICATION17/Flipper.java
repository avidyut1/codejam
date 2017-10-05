package QUALIFICATION17;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;

/**
 * created by asheshvidyut on 08/04/17
 **/
public class Flipper {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int i = 0; i < tc; i++) {
                String inp[] = in.readLine().split(" ");
                char s[] = inp[0].toCharArray();
                int k = Integer.parseInt(inp[1]);
                boolean ar[] = new boolean[s.length];
                for (int j = 0; j < s.length; j++) {
                    ar[j] = s[j] == '+';
                }
                int count = 0;
                for (int j = 0; j < s.length; j++) {
                    if (!ar[j] && j + k - 1 < s.length) {
                        count++;
                        for (int l = j; l <= j + k - 1; l++) {
                            ar[l] = !ar[l];
                        }
                    }
                }
                boolean allTrue[] = new boolean[s.length];
                Arrays.fill(allTrue, true);
                if (Arrays.equals(allTrue, ar)) {
                    out.write("Case #" + (i + 1) + ": " + Integer.toString(count));
                }
                else{
                    out.write("Case #" + (i + 1) + ": IMPOSSIBLE");
                }
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
