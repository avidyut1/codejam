package APAC2015E;

import java.io.*;
import java.util.*;
import java.math.*;

//Accepted Small
public class BeautifulNumber {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int tc = in.readInt();
            for (int i = 0; i < tc; i++) {
                int n = in.readInt();
                for (int b = 2; b <= n; b++) {
                    if (allone(n, b)) {
                        System.out.println("Case #"+(i + 1)+": "+(b));
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean allone(int n, int b) {
        while(n > 0) {
            int rem = n % b;
            if (rem != 1)
                return false;
            n /= b;
        }
        return true;
    }
}
