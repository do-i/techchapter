package com.djd.fun.techchapter.demo016;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class T9Test {

  @Test
  public void toDigitChars() {
    assertThat(T9.toDigitChars(8733)).asList().containsExactly('8', '7', '3', '3');
  }
}
