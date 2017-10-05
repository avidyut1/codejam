package ROUND1B16;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 14/04/17
 **/
public class GettingDigits {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 1; t <= tc; t++) {
                char s[] = in.readLine().toCharArray();
                Vector<Character> chars = new Vector<>();
                for (int i = 0; i < s.length; i++) {
                    chars.add(s[i]);
                }
                int count[] = new int[10];
                //checking for 4
                while(chars.contains('U')){
                    chars.remove(new Character('F'));
                    chars.remove(new Character('O'));
                    chars.remove(new Character('U'));
                    chars.remove(new Character('R'));
                    count[4]++;
                }
                while(chars.contains('W')){
                    chars.remove(new Character('T'));
                    chars.remove(new Character('W'));
                    chars.remove(new Character('O'));
                    count[2]++;
                }
                while(chars.contains('Z')){
                    chars.remove(new Character('Z'));
                    chars.remove(new Character('E'));
                    chars.remove(new Character('R'));
                    chars.remove(new Character('O'));
                    count[0]++;
                }
                while(chars.contains('X')){
                    chars.remove(new Character('S'));
                    chars.remove(new Character('I'));
                    chars.remove(new Character('X'));
                    count[6]++;
                }
                while(chars.contains('G')){
                    chars.remove(new Character('E'));
                    chars.remove(new Character('I'));
                    chars.remove(new Character('G'));
                    chars.remove(new Character('H'));
                    chars.remove(new Character('T'));
                    count[8]++;
                }
                while(chars.contains('R')){
                    chars.remove(new Character('T'));
                    chars.remove(new Character('H'));
                    chars.remove(new Character('R'));
                    chars.remove(new Character('E'));
                    chars.remove(new Character('E'));
                    count[3]++;
                }
                while(chars.contains('F')){
                    chars.remove(new Character('F'));
                    chars.remove(new Character('I'));
                    chars.remove(new Character('V'));
                    chars.remove(new Character('E'));
                    count[5]++;
                }
                while(chars.contains('V')){
                    chars.remove(new Character('S'));
                    chars.remove(new Character('E'));
                    chars.remove(new Character('V'));
                    chars.remove(new Character('E'));
                    chars.remove(new Character('N'));
                    count[7]++;
                }
                while(chars.contains('O')){
                    chars.remove(new Character('O'));
                    chars.remove(new Character('N'));
                    chars.remove(new Character('E'));
                    count[1]++;
                }
                while(chars.contains('N')){
                    chars.remove(new Character('N'));
                    chars.remove(new Character('I'));
                    chars.remove(new Character('N'));
                    chars.remove(new Character('E'));
                    count[9]++;
                }
                out.write("Case #"+(t)+": ");
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < count[i]; j++) {
                        out.write(Integer.toString(i));
                    }
                }
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
