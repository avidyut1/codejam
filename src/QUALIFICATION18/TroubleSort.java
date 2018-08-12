package QUALIFICATION18;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 07/04/18
 **/
public class TroubleSort {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                int n = in.readInt();
                int ar[] = new int[n];
                int sar[] = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = in.readInt();
                    sar[i] = ar[i];
                }
                boolean done = false;
                while(!done) {
                    done = true;
                    for (int i = 0; i < ar.length - 2; i++) {
                        if (ar[i] > ar[i + 2]) {
                            done = false;
                            int temp = ar[i];
                            ar[i] = ar[i + 2];
                            ar[i + 2] = temp;
                        }
                    }
                }
                Arrays.sort(sar);
                int ans = -1;
                for (int i = 0; i < n; i++) {
                    if (sar[i] != ar[i]) {
                        ans = i;
                        break;
                    }
                }
                if (ans == -1) {
                    System.out.println("OK");
                }
                else {

                }
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
