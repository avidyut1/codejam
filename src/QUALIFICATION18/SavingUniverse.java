package QUALIFICATION18;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 07/04/18
 **/
public class SavingUniverse {
    public static int ans;
    public static HashMap<String, Integer> statesSwaps = new HashMap<>();
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                statesSwaps.clear();
                String inp[] = (in.readLine()).split(" ");
                ans = Integer.MAX_VALUE;
                int d = Integer.parseInt(inp[0]);
                char seq[] = inp[1].toLowerCase().toCharArray();
                long currentDamage = 0L;
                long multiplier = 1L;
                for (int i = 0; i < seq.length; i++) {
                    if (seq[i] == 'c') {
                        multiplier *= 2L;
                    }
                    else {
                        currentDamage += multiplier;
                    }
                }
                recurse(d, seq, currentDamage, 0);
                if (ans == Integer.MAX_VALUE) {
                    out.write("Case #"+(t + 1)+": IMPOSSIBLE");
                }
                else {
                    out.write("Case #"+(t + 1)+": "+Integer.toString(ans));
                }
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void recurse(int d, char s[], long curDam, int swaps) {
        if (curDam <= d) {
            ans = Math.min(ans, swaps);
            return;
        }
        if (statesSwaps.containsKey(new String(s)) && statesSwaps.get(new String(s)) <= swaps) {
            return;
        }
        else {
            statesSwaps.put(new String(s), swaps);
        }
        for (int i = 0; i < s.length - 1; i++) {
            char c = s[i];
            s[i] = s[i + 1];
            s[i + 1] = c;
            long cDam = 0L;
            long multiplier = 1L;
            for (int j = 0; j < s.length; j++) {
                if (s[j] == 'c') {
                    multiplier *= 2L;
                }
                else {
                    cDam += multiplier;
                }
            }
            if (s[i] == s[i + 1]) {
                recurse(d, s, cDam, swaps);
            }
            else {
                recurse(d, s, cDam,swaps + 1);
            }
            c = s[i];
            s[i] = s[i + 1];
            s[i + 1] = c;
        }
    }
}
