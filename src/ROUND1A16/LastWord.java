package ROUND1A16;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 13/04/17
 **/
public class LastWord {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                char c[] = in.readLine().toCharArray();
                String res = "";
                for (int i = 0; i < c.length; i++) {
                    String f = res + c[i];
                    String s = c[i] + res;
                    if (f.compareTo(s) > 0) {
                        res = f;
                    }
                    else {
                        res = s;
                    }
                }
                out.write("Case #"+(t+1)+": "+res);
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
