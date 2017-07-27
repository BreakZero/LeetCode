package com.zero.problem5;

/**
 * Created by Zero on 2017/7/19.
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example:
 * Input: "babad"
 *
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
    public static String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        String temp = "";
        int len = s.length();
        int right = len;
        int start = 0;
        for (int left = 0; left < len; left++) {
            right--;
            if (arr[left] == arr[right]) {
                continue;
            }
            temp = temp.length() > (left - start) ? temp : s.substring(start, left);
            start = left + 1;
        }
        return temp;
    }
}
