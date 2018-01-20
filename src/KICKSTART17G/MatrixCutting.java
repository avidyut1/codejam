package KICKSTART17G;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class MatrixCutting {
    long ans = Long.MIN_VALUE;
    private void solve() throws IOException{
        InputReader in = new InputReader(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = in.readInt();
        for (int t = 1; t <= tc; t++) {
            int n = in.readInt();
            int m = in.readInt();
            int arr[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = in.readInt();
                }
            }
            int mini[][][][] = new int[n][m][n][m];
            ans = Long.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < m; l++) {
                            int min = Integer.MAX_VALUE;
                            for (int o = i; o <= k; o++) {
                                for (int p = j; p <= l; p++) {
                                    min = Math.min(min, arr[o][p]);
                                }
                            }
                            mini[i][j][k][l] = min;
                        }
                    }
                }
            }
            //start from smaller size of submatrix and compute its answer
            //for a submatrix i, j, k, l
            //it can be cut into two parts either vertically or horizontally
            //taking max of all vertical cuts and max of all horizontal cut
            //and adding min of that submatrix
            int dp[][][][] = new int[n][m][n][m];
            for (int size1 = 1; size1 <= n; size1++) {
                for (int size2 = 1; size2 <= m; size2++) {
                    for (int i = 0; i + size1 - 1 < n; i++) {
                            for (int j = 0; j + size2 - 1 < m; j++) {
                            int k = i + size1 - 1;
                            int l = j + size2 - 1;
                            int res = 0;
                            for (int o = i; o < k; o++) {
                                res = Math.max(res, dp[i][j][o][l] + dp[o + 1][j][k][l]);
                            }
                            for (int o = j; o < l; o++) {
                                res = Math.max(res, dp[i][j][k][o] + dp[i][o + 1][k][l]);
                            }
                            if (i != k || j != l) {
                                res += mini[i][j][k][l];
                            }
                            dp[i][j][k][l] = res;
                        }
                    }
                }
            }
            ans = dp[0][0][n - 1][m - 1];
            out.write("Case #"+t+": "+ans);
            out.newLine();
        }
        out.close();
    }
    public static void main(String args[]) {
        try {
            MatrixCutting matrixCutting = new MatrixCutting();
            matrixCutting.solve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
