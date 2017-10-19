package KICKSTART17C;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class MagicalThinking {
    int dp[][][] = new int[100][100][100];
    int dp2[][] = new int[100][100];
    int ans1, ans2;
    Vector<Boolean> v1 = new Vector<>();
    Vector<Boolean> v2 = new Vector<>();
    Vector<Boolean> me = new Vector<>();
    public int go1(int curr, int a, int b) {
        if (curr == v1.size()) {
            if (a == ans1 && b == ans2) {
                return 0;
            }
            return -7;
        }
        if (dp[curr][a][b] != -1) return dp[curr][a][b];
        //res1 = assuming q[curr] - true is correct and will give 1 point
        int res1 = go1(curr + 1 , a + (v1.get(curr) ? 1 : 0), b + (v2.get(curr) ? 1 : 0));
        if (res1 != -7) res1 = res1 + (me.get(curr) ? 1 : 0);
        //res2 = assuming q[curr] - false is correct and will give 1 point
        int res2 = go1(curr + 1 , a + (v1.get(curr) ? 0 : 1), b + (v2.get(curr) ? 0 : 1));
        if (res2 != -7) res2 = res2 + (me.get(curr) ? 0 : 1);
        dp[curr][a][b] = Math.max(res1, res2);
        return dp[curr][a][b];
    }
    public int go2(int curr, int a) {
        if (curr == v1.size()) {
            if (a == ans1) {
                return 0;
            }
            return -7;
        }
        if (dp2[curr][a] != -1) return dp2[curr][a];
        //res1 = assuming q[curr] - true is correct and will give 1 point
        int res1 = go2(curr + 1 , a + (v1.get(curr) ? 1 : 0));
        if (res1 != -7) res1 = res1 + (v2.get(curr) ? 1 : 0);
        //res2 = assuming q[curr] - false is correct and will give 1 point
        int res2 = go2(curr + 1 , a + (v1.get(curr) ? 0 : 1));
        if (res2 != -7) res2 = res2 + (v2.get(curr) ? 0 : 1);
        dp2[curr][a] = Math.max(res1, res2);
        return dp2[curr][a];
    }
    public void solve() {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 1; t <= tc; t++) {
                v1.clear();
                v2.clear();
                me.clear();
                int n = in.readInt();
                int q = in.readInt();
                if (n == 1) {
                    String p1 = in.readLine();
                    String u = in.readLine();
                    for (int i = 0; i < q; i++) {
                        v1.add(p1.charAt(i) == 'T');
                        v2.add(u.charAt(i) == 'T');
                    }
                    for (int i = 0; i < 100; i++) {
                        Arrays.fill(dp2[i], -1);
                    }
                    ans1 = in.readInt();
                    int res = go2(0, 0);
                    out.write("Case #"+t+": ");
                    out.write(Integer.toString(res));
                    out.newLine();
                }
                else {
                    for (int i = 0; i < 100; i++) {
                        for (int j = 0; j < 100; j++) {
                            Arrays.fill(dp[i][j], -1);
                        }
                    }
                    String p1 = in.readLine();
                    String p2 = in.readLine();
                    String u = in.readLine();
                    for (int i = 0; i < q; i++) {
                        v1.add(p1.charAt(i) == 'T');
                        v2.add(p2.charAt(i) == 'T');
                        me.add(u.charAt(i) == 'T');
                    }
                    ans1 = in.readInt();
                    ans2 = in.readInt();

                    int res = go1(0, 0, 0);
                    out.write("Case #"+t+": ");
                    out.write(Integer.toString(res));
                    out.newLine();
                }
            }
            out.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();;
        }
    }
    public static void main(String args[]) {
        try {
            MagicalThinking magicalThinking = new MagicalThinking();
            magicalThinking.solve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
