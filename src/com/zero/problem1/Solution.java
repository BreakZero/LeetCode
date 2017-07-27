package com.zero.problem1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Zero on 2017/6/29.
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example :
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 */
public class Solution {
    public static void main(String[] args) {
        int[] result = twoSum(new int[]{3, 2, 4, 5, 1}, 6);
        for (int i = 0; i < result.length; i ++) {
            System.out.println(result[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    if (!temp.containsKey(i)) {
                        temp.put(i, i);
                    }
                    if (!temp.containsKey(j)) {
                        temp.put(j, j);
                    }
                }
            }
        }
        Iterator it = temp.entrySet().iterator();
        int index = 0;
        int[] result = new int[temp.size()];
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            result[index] = (int) entry.getValue();
            index++;
        }
        return result;
    }
}
