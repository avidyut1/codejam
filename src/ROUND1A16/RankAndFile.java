package ROUND1A16;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 13/04/17
 **/
public class RankAndFile {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                int n = in.readInt();
                int freq[] = new int[2501];
                for (int i = 0; i < 2 * n - 1; i++) {
                    for (int j = 0; j < n; j++) {
                        int val = in.readInt();
                        freq[val]++;
                    }
                }
                out.write("Case #"+(t+1)+": ");
                for (int i = 0; i < freq.length; i++) {
                    if (freq[i] % 2 != 0) {
                        out.write(Integer.toString(i) + " ");
                    }
                }
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
