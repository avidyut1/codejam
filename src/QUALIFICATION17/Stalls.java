package QUALIFICATION17;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;

/**
 * created by asheshvidyut on 08/04/17
 **/
public class Stalls {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                long n = in.readLong();
                long k = in.readLong();
                Queue<Long> queue = new PriorityQueue<>(1000000, Collections.reverseOrder());
                queue.add(n);
                long maxs = -1, mins = -1;
                for (int i = 0; i < k; i++) {
                    long range = queue.poll();
                    if (range % 2 != 0) {
                        queue.add(range / 2);
                        queue.add(range / 2);
                        maxs = (range / 2);
                        mins = (range / 2);
                    }
                    else {
                        queue.add(range / 2);
                        queue.add((range / 2) - 1);
                        maxs = (range / 2);
                        mins = (range / 2) - 1;
                    }
                }
                out.write("Case #"+(t + 1) +": "+(Long.toString(maxs))+" " + Long.toString(mins));
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
