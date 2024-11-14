package com.dat.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeSubtractionOperation {
    public static void main(String[] args) {
        PrimeSubtractionOperation primeSubtractionOperation = new PrimeSubtractionOperation();
        int[] nums = {15,20,17,7,16};
        System.out.println(primeSubtractionOperation.primeSubOperation(nums));
    }
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        int[] primes = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997};

//        System.out.println(Arrays.toString(findPrimeByEratosthenes(1000)));
        for (int i = n - 2; i >= 0 ; i--) {
            int h = nums[i];
            if (h >= nums[i + 1]) {
                int l = h - (nums[i + 1] - 1);
                int p = findPrime(primes, l, h);
                if (p == h) {
                    return false;
                } else {
                    nums[i] = h - p;
                }
            }
        }
        return true;
    }

    private int findPrime(int[] primes, int l, int h) {
        for (int i = 0; i < primes.length ; i++) {
            if (l <= primes[i] && h > primes[i]) {
                return primes[i];
            } else if (h <= primes[i]) {
                return h;
            }
        }
        return h;
    }

    private Integer[] findPrimeByEratosthenes(int n) {
        List<Integer> list = new ArrayList<>();
        boolean[] arr = new boolean[n + 1];
        arr[0] = true;
        arr[1] = true;
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) {
                list.add(i);
                for (int j = i * 2; j < arr.length; j+=i) {
                    arr[j] = true;
                }
            }
        }


        return list.toArray(new Integer[0]);
    }
}
