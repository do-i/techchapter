package com.djd.fun.techchapter.demo020sort;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class MergeSortTest {

  @Test
  public void positiveTest() {
    int[] actual = {7, 10, 5, 1, 6, 2, 9, 3, 4, 8};
    int[] expect = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    MergeSort.mergeSort(actual);
    assertThat(actual).isEqualTo(expect);
  }
}
