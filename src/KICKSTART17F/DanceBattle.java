package KICKSTART17F;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class DanceBattle {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                long e = in.readLong();
                int n = in.readInt();
                long si[] = new long[n];
                for (int i = 0; i < n; i++) {
                    si[i] = in.readLong();
                }
                Arrays.sort(si);
                int ans = 0;
                int epointer = si.length - 1;
                for (int i = 0; i < si.length && i <= epointer;) {
                    if (e > si[i]) {
                        ans++;
                        e -= si[i];
                        i++;
                    }
                    else {
                        if (ans == 0 || i == epointer) {
                            break;
                        }
                        else{
                            ans--;
                            e += si[epointer--];
                        }
                    }
                }
                out.write("Case #"+(t + 1)+": "+Integer.toString(Math.max(ans, 0)));
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
