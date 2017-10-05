package ROUND1B16;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 14/04/17
 **/
public class CloseMatch {
    static int diff = Integer.MAX_VALUE;
    static String ans = "";
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 1; t <= tc; t++) {
                diff = Integer.MAX_VALUE;
                ans = "";
                char s[] = (in.readLine()).toCharArray();
                fillAll(s);
                out.write("Case #"+(t)+": ");
                out.write(ans);
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void fillAll(char c[]) {
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '?') {
                for (int j = 0; j < 10; j++) {
                    c[i] = Integer.toString(j).charAt(0);
                    fillAll(c);
                }
                c[i] = '?';
            }
        }
        String s = new String(c);
        if(s.indexOf('?') >= 0){
            return;
        }
        String sar[] = s.split(" ");
        Integer first = Integer.parseInt(sar[0]);
        Integer sec = Integer.parseInt(sar[1]);
        if (diff > Math.abs(first - sec)) {
            diff = Math.abs(first - sec);
            ans = s;
        }
    }
}
