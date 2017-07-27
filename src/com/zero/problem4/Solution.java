package com.zero.problem4;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Zero on 2017/6/30.
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 *
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0 && len2 == 0) throw new NullPointerException("both arrays is null");

        if (len1 == 0) {
            if (1 == len2) return nums2[0];
            return len2 % 2 == 0 ? (nums2[len2 / 2 - 1] + nums2[len2 / 2]) / 2.0 :
                    nums2[len2 / 2];
        }
        if (len2 == 0) {
            if (1 == len1) return nums1[0];
            return len1 % 2 == 0 ? (nums1[len1 / 2 - 1] + nums1[len1 / 2]) / 2.0 :
                    nums1[len1 / 2];
        }

        int total = len1 + len2;
        int index1 = 0;
        int index2 = 0;
        int[] tracker = new int[total];
        for (int i = 0; i < total; i++) {
            if (index1 == len1 && index2 < len2) {
                tracker[i] = nums2[index2];
                index2 ++;
                continue;
            }
            if (index2 == len2 && index1 < len1) {
                tracker[i] = nums1[index1];
                index1 ++;
                continue;
            }
            tracker[i] = Math.min(nums1[index1], nums2[index2]);
            if (nums1[index1] <= nums2[index2]) {
                index1 ++;
            } else {
                index2 ++;
            }
        }
        System.out.println((tracker[total / 2 - 1] + tracker[total / 2]));
        return total % 2 == 0 ? (tracker[total / 2 - 1] + tracker[total / 2]) / 2.0 :
                tracker[total / 2];
    }
}
