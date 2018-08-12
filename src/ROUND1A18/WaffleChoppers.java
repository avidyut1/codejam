package ROUND1A18;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 14/04/18
 **/
public class WaffleChoppers {
	public static void main(String args[]) {
		try {
			InputReader in = new InputReader(System.in);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
			int tc = in .readInt();
			for (int t = 0; t < tc; t++) {
				int r = in .readInt();
				int c = in .readInt();
				int h = in .readInt();
				int v = in .readInt();
				char mat[][] = new char[r][c];
				for (int i = 0; i < r; i++) {
					mat[i] = in .readLine().toCharArray();
				}
				int totalChocolates = 0;
				int columnSum[] = new int[c];
				int rowSum[] = new int[r];
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if (mat[i][j] == '@') {
							totalChocolates++;
							columnSum[j]++;
							rowSum[i]++;
						}
					}
				}
				int countPeople = (h + 1) * (v + 1);
				boolean flag = false;
				HashMap < Integer, Vector < Integer >> possibleDivision = new HashMap < > ();
				for (int i = 1; i <= totalChocolates; i++) {
					boolean pos = true;
					if (countPeople % i == 0) {
						int sum = 0;
						Vector < Integer > cuts = new Vector < > ();
						boolean isPossible = true;
						int countVerticalCuts = 0;
						for (int j = 0; j < c; j++) {
							sum += columnSum[j];
							if (sum == (h + 1) * i) {
								if (j != c - 1) {
									countVerticalCuts++;
									cuts.add(j);
								}
								sum = 0;
							} else if (j == c - 1) {
								isPossible = false;
							}
						}
						if (countVerticalCuts != v) {
							pos = false;
						} else if (isPossible) {
							possibleDivision.put(i, cuts);
						}
					}
					if (pos) {
						flag = true;
					}
				}
				boolean pos = false;
				if (flag) {
					for (int eachPeople: possibleDivision.keySet()) {
					    int rangeL = -1 , rangeR = -1;
						int ep = eachPeople;
						int sum = 0;
						boolean flagcheck = true;
						Vector<Integer> rangesl = new Vector<>();
						Vector<Integer> rangesr = new Vector<>();
						Vector < Integer > cuts = possibleDivision.get(eachPeople);
						for (int i = 0; i < r; i++) {
							for (int j = 0; j < c; j++) {
								if (cuts.contains(i) || (j == c - 1 && sum > 0)) {

								}
							    sum += (mat[i][j] == '@') ? 1 : 0;
							    if (sum == ep) {
							        rangeL = i;
									for (int k = i + 1; k < r; k++) {
										rangeR = k;
										if (mat[k][j] == '@') {
											break;
										}
									}
								}
							}
						}
						if (flagcheck) {
							pos = true;
						}
					}
				}
				if ((flag && pos) || (totalChocolates == 0)) {
					out.write("Case #"+(t + 1)+": POSSIBLE");
				} else {
					out.write("Case #"+(t + 1)+": IMPOSSIBLE");
				}
				out.newLine();
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}