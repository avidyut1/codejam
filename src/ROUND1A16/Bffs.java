package ROUND1A16;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 13/04/17
 **/
public class Bffs {
    public static Vector<Vector<Integer>> cc;
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 1; t <= tc; t++) {
                int n = in.readInt();
                int bf[] = new int[n];
                for (int i = 0; i < n; i++) {
                    bf[i] = in.readInt();
                }
                Vector<Integer> g[] = new Vector[n];
                for (int i = 0; i < n; i++) {
                    g[i] = new Vector<>();
                }
                for (int i = 0; i < n; i++) {
                    g[i].add(bf[i] - 1);
                }
                cc = new Vector<>();
                dfs(g);
                int max = Integer.MIN_VALUE;
                for( Vector<Integer> components: cc) {
                    max = Math.max(components.size(), max);
                }
                out.write("Case #"+(t)+": "+max);
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void dfs(Vector<Integer> g[]) {
        boolean v[] = new boolean[g.length];
        for (int i = 0; i < g.length; i++) {
            if (!v[i]) {
                cc.add(new Vector<>());
                dfs_visit(g, i, v);
            }
        }
    }
    private static void dfs_visit(Vector<Integer> g[], int v, boolean vis[]) {
        if (vis[v]) {
            return;
        }
        vis[v] = true;
        cc.get(cc.size() - 1).add(v);
        for (int ch: g[v]) {
            Vector<Integer> ccThis = cc.get(cc.size() - 1);
            if (vis[ch] && ccThis.size() > 1 && ccThis.get(ccThis.size() - 2) == ch) {
                for (int i = 0; i < g.length; i++) {
                    if (!vis[i] && g[i].contains(ccThis.get(ccThis.size() - 1))) {
                        cc.get(cc.size() - 1).add(i);
                        vis[i] = true;
                        return;
                    }
                }
            }
            else {
                dfs_visit(g, ch, vis);
            }
        }
    }
}
