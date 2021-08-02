package com.hgf.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: HGF
 * @Date: 8/2/21
 */
  /*
    这是 LeetCode 上的 1337. 矩阵中战斗力最弱的 K 行 ，难度为 简单。
Tag : 「优先队列」、「二分」
给你一个大小为 m ∗nm * nm ∗n 的矩阵 matmatmat，矩阵由若干军人和平民组成，分别用 111 和 000 表示。
请你返回矩阵中战斗力最弱的 kkk 行的索引，按从最弱到最强排序。
如果第 iii 行的军人数量少于第 jjj 行，或者两行军人数量相同但 iii 小于 jjj，那么我们认为第 iii 行的战斗力比第 jjj 行弱。
军人 总是 排在一行中的靠前位置，也就是说 111 总是出现在 000 之前。
     */
public class LC1337 {


    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] all = new int[m][1];
        for (int i = 0; i < m; i++) {
            int cur = 0;
            for (int j = 0; j < n; j++) cur += mat[i][j];
            all[i] = new int[]{cur, i};
        }
        Arrays.sort(all, (a, b)->{
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) ans[i] = all[i][1];
        return ans;
    }
}
