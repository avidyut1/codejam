package KICKSTART17C;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 26/06/17
 **/
public class Xsquared {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 1; t <= tc; t++) {
                int n = in.readInt();
                char [][] mat = new char[n][n];
                for (int i = 0; i < n; i++) {
                    mat[i] = in.readLine().toCharArray();
                }
                int numR1 = 0;
                int numC1 = 0;
                int numR2 = 0;
                int numC2 = 0;
                int extra = 0;
                for (int i = 0; i < n; i++) {
                    int countX = 0;
                    for (int j = 0; j < n; j++) {
                        if (mat[i][j] == 'X') {
                            countX++;
                        }
                    }
                    if (countX == 1) {
                        numR1++;
                    }
                    else if (countX == 2){
                        numR2++;
                    }
                    else {
                        extra++;
                    }
                }
                for (int i = 0; i < n; i++) {
                    int countX = 0;
                    for (int j = 0; j < n; j++) {
                        if (mat[j][i] == 'X') {
                            countX++;
                        }
                    }
                    if (countX == 1) {
                        numC1++;
                    }
                    else if (countX == 2){
                        numC2++;
                    }
                    else {
                        extra++;
                    }
                }
                if (extra == 0 && numR1 == 1 && numC1 == 1 && numR2 == n - 1 && numC2 == n - 1) {
                    out.write("Case #"+t+": POSSIBLE");
                }
                else {
                    out.write("Case #"+t+": IMPOSSIBLE");
                }
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
