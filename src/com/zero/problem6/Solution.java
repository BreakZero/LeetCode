package com.zero.problem6;

/**
 * Created by Zero on 2017/7/19.
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(convert("ABC", 3));
    }


    private static final char NANCHAR = ' ';

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int len = s.length();
        int c = len % (numRows + 1) == 0 ? len / (numRows + 1) * 2 : len / (numRows + 1) * 2 + 1;
        char[][] arr = new char[numRows][c];
        char[] sChars = s.toCharArray();
        int index = 0;
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < numRows; j++) {
                if (i % 2 == 1) {
                    if (j == (numRows / 2 == 0 ? 1 : numRows / 2)) {
                        if (index >= len) arr[j][i] = NANCHAR;
                        else arr[j][i] = sChars[index];
                        index++;
                    }
                } else {
                    if (index >= len) arr[j][i] = NANCHAR;
                    else arr[j][i] = sChars[index];
                    index++;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 0) continue;
                result.append(arr[i][j]);
            }
        }
        return result.toString().trim();
    }
}
