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
                Vector<Integer> row[] = new Vector[n];
                Vector<Integer> col[] = new Vector[n];
                for (int i = 0; i < n; i++) {
                    row[i] = new Vector<>();
                    col[i] = new Vector<>();
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (mat[i][j] == 'X') {
                            row[i].add(j);
                            col[j].add(i);
                        }
                    }
                }
                boolean impos = false;
                for (int r = 0; r < n; r++) {
                    if (row[r].size() > 2 || row[r].size() == 0) {
                        impos = true;
                        break;
                    }
                    else if (row[r].size() == 1) {
                        int c = row[r].get(0);
                        if (col[c].size() != 1) {
                            impos = true;
                            break;
                        }
                    }
                    else {
                        //checking same config of column
                        int col1 = row[r].get(0);
                        int col2 = row[r].get(1);
                        if (col[col1].equals(col[col2])) {
                            if (col[col1].size() == 2) {
                                int or = col[col1].get(0);
                                if (or == r) {
                                    or = col[col1].get(1);
                                }
                                if (row[or].equals(row[r])) {
                                    continue;
                                }
                            }
                        }
                        impos = true;
                        break;
                    }
                }
                if (impos) {
                    out.write("Case #"+(t)+": IMPOSSIBLE");
                }
                else {
                    out.write("Case #"+(t)+": POSSIBLE");
                }
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
