package ROUND1B18;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 29/04/18
 **/
public class RoundingError {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 1; t <= tc; t++) {
                int n = in.readInt();
                int l = in.readInt();
                Long lang[] = new Long[l];
                int rem = 0;
                for (int i = 0; i < l; i++) {
                    lang[i] = in.readLong();
                    rem += lang[i];
                }
                Arrays.sort(lang);
                rem = n - rem;
                long max = 0;
                for (int i = 0; i < l; i++) {
                    long valOriginal = Math.round(((double)lang[i] / n) * 100);
                    double valWithoutRound = (double)(lang[i] / n) * 100;
                    long ans = 0;
                    long valOne = Math.round((((double)lang[i] + 1) / n) * 100);
                    if (valWithoutRound > valOriginal) {
                        if (rem > 0) {
                            rem--;
                            ans = valOne;
                        }
                        else {
                            ans = valOriginal;
                        }
                    }
                    else {
                        ans = valOriginal;
                    }
                    max += ans;
                }
                long ans = Math.round(((double)rem / n) * 100);
                ans = Math.max(ans, (Math.round((double) 1 / n) * 100) * rem);
                out.write("Case #"+t+": ");
                out.write(Long.toString(max + ans));
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
