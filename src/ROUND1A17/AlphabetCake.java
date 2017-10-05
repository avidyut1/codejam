package ROUND1A17;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 15/04/17
 **/
public class AlphabetCake {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 1; t <= tc; t++) {
                int r = in.readInt();
                int c = in.readInt();
                char cake[][] = new char[r][c];
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        cake[i][j] = in.readCharacter();
                    }
                }
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (cake[i][j] != '?') {
                            for (int k = i + 1; k < r; k++) {
                                if (cake[k][j] == '?') {
                                    cake[k][j] = cake[i][j];
                                }
                                else
                                    break;
                            }
                            for (int k = i - 1; k >= 0; k--) {
                                if (cake[k][j] == '?') {
                                    cake[k][j] = cake[i][j];
                                }
                                else
                                    break;
                            }
                        }
                    }
                }
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (cake[i][j] == '?') {
                            if (j - 1 >= 0)
                                cake[i][j] = cake[i][j - 1];
                            if (cake[i][j] == '?') {
                                int k = j;
                                while(k < c && cake[i][j] == '?') {
                                    k++;
                                }
                                cake[i][j] = cake[i][k];
                            }
                        }
                    }
                }
                out.write("Case #" +(t)+": ");
                out.newLine();
                for (int i = 0; i < r; i++) {
                    out.write(cake[i]);
                    out.newLine();
                }
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
