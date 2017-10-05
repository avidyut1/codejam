package APAC2015E;

import java.io.*;
import java.util.*;
import java.math.*;
//Accepted
public class Diwali {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int tc = in.readInt();
            for (int i = 0; i < tc; i++) {
                String s = in.readLine();
                long l = in.readLong();
                long r = in.readLong();
                long ans = findAns(s, r) - findAns(s, l - 1);
                System.out.println("Case #"+(i + 1)+": "+ans);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static long findAns(String s, long ind) {
        long times = ind / s.length();
        long rem = ind % s.length();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'B')
                count++;
        }
        long ans = (long)(count) * times;
        for (int i = 0; i < rem; i++) {
            if (s.charAt(i) == 'B') {
                ans++;
            }
        }
        return ans;
    }
}
