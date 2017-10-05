package KICKSTART17F;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class CatchThemAll {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                int n = in.readInt();
                int m = in.readInt();
                int p = in.readInt();
                int dist[][] = new int[n][n];
                for (int i = 0; i < n; i++) {
                    Arrays.fill(dist[i], (int)1e9);
                }
                for (int i = 0; i < m; i++) {
                    int u = in.readInt() - 1;
                    int v = in.readInt() - 1;
                    int d = in.readInt();
                    dist[u][v] = d;
                    dist[v][u] = d;
                }
                for (int k = 0; k < n; k++) {
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                        }
                    }
                }
                double dpans[][] = new double[p + 1][n];
                for (int i = 0; i <= p; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i == 0) {
                            dpans[i][j] = 0.0d;
                        }
                        else {
                            double summation = 0.0d;
                            for (int k = 0; k < n; k++) {
                                if (k == j) {
                                    continue;
                                }
                                summation += (dpans[i - 1][k] + dist[j][k]);
                            }
                            dpans[i][j] = (summation) / (n - 1);
                        }
                    }
                }
                System.out.printf("Case #"+(t+1)+": %.9f\n", dpans[p][0]);
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
