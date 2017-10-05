package QUALIFICATION17;

import APAC2015E.InputReader;

import java.io.*;

/**
 * created by asheshvidyut on 08/04/17
 **/
public class Tidy {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                char s[] = in.readLine().toCharArray();
                int ar[] = new int[s.length];
                for (int i = 0; i < s.length; i++) {
                    ar[i] = Integer.parseInt(Character.toString(s[i]));
                }
                int res[] = findResult(ar);
                String result = "";
                for (int i = 0; i < res.length; i++) {
                    result += res[i];
                }
                Long ans = Long.parseLong(result);
                out.write("Case #"+ (t + 1) + ": " + Long.toString(ans));
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int[] findResult(int ar[]) {
        if (isTidy(ar)) {
            return ar;
        }
        int k = ar.length - 1;
        while(k >= 0) {
            if (ar[k] == 9) {
                k--;
            }
            else {
                break;
            }
        }
        ar[k--] = 9;
        while(k >= 0 && ar[k] == 0) {
            ar[k--] = 9;
        }
        if (k >= 0)
            ar[k] = ar[k] - 1;
        return findResult(ar);
    }
    public static boolean isTidy(int ar[]) {
        for (int i = 0; i < ar.length - 1; i++) {
            if (ar[i] > ar[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
