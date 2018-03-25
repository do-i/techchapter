package com.djd.fun.techchapter.demo016;

import org.junit.Ignore;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;


public class MaxIntTest {

  @Test
  public void max_8or3_8() {
    assertThat(MaxInt.max(8, 3)).isEqualTo(8);
  }

  @Test
  public void max_3or8_8() {
    assertThat(MaxInt.max(3, 8)).isEqualTo(8);
  }

  @Test
  public void max_negative3orNegative8_3() {
    assertThat(MaxInt.max(-3, -8)).isEqualTo(-3);
  }

  @Test
  public void max_negative8orNegative3_3() {
    assertThat(MaxInt.max(-8, -3)).isEqualTo(-3);
  }

  @Test
  public void max_8or8_8() {
    assertThat(MaxInt.max(8, 8)).isEqualTo(8);
  }

  @Test
  public void max_0or0_0() {
    assertThat(MaxInt.max(0, 0)).isEqualTo(0);
  }

  @Test
  public void signBit_negative_1() {
    assertThat(MaxInt.signBit(-3)).isEqualTo(1);
  }

  @Test
  public void signBit_positive_0() {
    assertThat(MaxInt.signBit(5)).isEqualTo(0);
  }

  @Test
  public void signBit_zero_0() {
    assertThat(MaxInt.signBit(0)).isEqualTo(0);
  }

  @Test
  public void flipSign_from0_to1() {
    assertThat(MaxInt.flipSign(0)).isEqualTo(1);
  }

  @Test
  public void flipSign_from1_to0() {
    assertThat(MaxInt.flipSign(1)).isEqualTo(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void flipSign_badArg() {
    MaxInt.flipSign(2);
  }

  @Test
  public void max_minOr0_0() {
    assertThat(MaxInt.max(Integer.MIN_VALUE, 0)).isEqualTo(0);
  }

  @Ignore("TODO handle overflow case")
  @Test
  public void max_0rrMin_0() {
    assertThat(MaxInt.max(0, Integer.MIN_VALUE)).isEqualTo(0);
  }

  @Test
  public void max_0rrMax_max() {
    assertThat(MaxInt.max(0, Integer.MAX_VALUE)).isEqualTo(Integer.MAX_VALUE);
  }

  @Test
  public void max_maxOr0_max() {
    assertThat(MaxInt.max(Integer.MAX_VALUE, 0)).isEqualTo(Integer.MAX_VALUE);
  }
}