package KICKSTARTPracticeRound;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 04/03/18
 **/
public class GBus {
    public static void main(String args[]) {
        try {
            final int MAX_HOUSE = 5002;
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                int n = in.readInt();
                String gbus[] = in.readLine().split(" ");
                int house[] = new int[MAX_HOUSE];
                for (int i = 0; i < gbus.length; i+=2) {
                    int start = Integer.parseInt(gbus[i]);
                    int end = Integer.parseInt(gbus[i + 1]);
                    house[start]++;
                    house[end + 1]--;
                }
                for (int i = 1; i < MAX_HOUSE; i++) {
                    house[i] = house[i] + house[i - 1];
                }
                int q = in.readInt();
                String res = "";
                for (int i = 0; i < q; i++) {
                    res += Integer.toString(house[in.readInt()]) + " ";
                }
                out.write("Case #"+(t + 1)+": "+res);
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
