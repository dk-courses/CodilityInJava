package com.cutajarjames.codility.caterpillarmethod;

import java.util.Arrays;

public class CountDistinctSlices {
    public int solution(int M, int[] A) {
        int totalSlices = 0;
        boolean[] inCurrentSlice = new boolean[M + 1];
        Arrays.fill(inCurrentSlice, false);
        int head = 0;
        for (int tail = 0; tail < A.length; tail++) {
            while (head < A.length && !inCurrentSlice[A[head]]) {
                inCurrentSlice[A[head]] = true;
                head += 1;
                totalSlices += (head - tail);
                if (totalSlices > 1000000000)
                    totalSlices = 1000000000;
            }
            inCurrentSlice[A[tail]] = false;
        }
        return totalSlices;
    }

    public static void main(String[] args) {
        System.out.println(new CountDistinctSlices().solution(6, new int[]{3, 4, 5, 5, 2}));
        System.out.println(new CountDistinctSlices().solution(6, new int[]{3, 5, 4, 5, 2}));
        System.out.println(new CountDistinctSlices().solution(6, new int[]{5, 3, 4, 2, 5}));
        System.out.println(new CountDistinctSlices().solution(6, new int[]{5, 5, 5, 4, 5}));
        System.out.println(new CountDistinctSlices().solution(6, new int[]{5}));
        System.out.println(new CountDistinctSlices().solution(6, new int[]{0, 1}));
    }
}
