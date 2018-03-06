package KICKSTARTPracticeRound;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 06/03/18
 **/
public class Sort {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 1; t <= tc; t++) {
                int n = in.readInt();
                String flight[][] = new String [n][2];
                for (int i = 0; i < n; i++) {
                    flight[i][0] = in.readLine();
                    flight[i][1] = in.readLine();
                }
                String start = null;
                for (int i = 0; i < n; i++) {
                    boolean seen = false;
                    for (int j = 0; j < n; j++) {
                        if (i == j) {
                            continue;
                        }
                        if (flight[i][0].equals(flight[j][1])) {
                            seen = true;
                            break;
                        }
                    }
                    if (!seen) {
                        start = flight[i][0];
                    }
                }
                out.write("Case #"+t+": ");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (flight[j][0].equals(start)) {
                            out.write(flight[j][0] + "-" + flight[j][1]+" ");
                            start = flight[j][1];
                            break;
                        }
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
