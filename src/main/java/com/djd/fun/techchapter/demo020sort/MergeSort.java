package com.djd.fun.techchapter.demo020sort;

/**
 * O(N * Log(N))
 * <p>
 * Depth is Log(N) each deapth iterate N for merge.
 * example: length 8 array, 1st depth is 4 each, 2nd is 2 each, 3rd is 1 each. Depth=3 = log(8) or
 * 2^3 = 8 or 2^Depth = N
 * Space: O(3N) => O(N) once reaches leaf node it deallocate sub array and move on to next merge.
 */
public class MergeSort {
  public static void mergeSort(int[] input) {
    if (input.length <= 1) {
      return;
    }
    int mid = input.length / 2;
    int[] left = createSubArray(input, 0, mid);
    int[] right = createSubArray(input, mid, input.length);

    mergeSort(left);
    mergeSort(right);
    merge(left, right, input);
  }

  private static int[] createSubArray(int[] input, int startIdxInc, int endIdxExc) {
    int[] output = new int[endIdxExc - startIdxInc];
    for (int outIdx = 0, i = startIdxInc; i < endIdxExc; i++) {
      output[outIdx++] = input[i];
    }
    return output;
  }

  private static void merge(int[] left, int[] right, int[] output) {
    int leftIdx = 0, rightIdx = 0, outIdx = 0;
    while (leftIdx < left.length && rightIdx < right.length) {
      if (left[leftIdx] < right[rightIdx]) {
        output[outIdx++] = left[leftIdx++];
      } else {
        output[outIdx++] = right[rightIdx++];
      }
    }
    while (leftIdx < left.length) {
      output[outIdx++] = left[leftIdx++];
    }
    while (rightIdx < right.length) {
      output[outIdx++] = right[rightIdx++];
    }
  }
}
