package com.djd.fun.techchapter.demo016;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;


public class StringRotationTest {

  @Test
  public void isStringRotation_bothEmpty() {
    assertThat(StringRotation.isStringRotation("", "")).isTrue();
  }

  @Test
  public void isStringRotation_s2Empty() {
    assertThat(StringRotation.isStringRotation("a", "")).isFalse();
  }

  @Test
  public void isStringRotation_s1Empty() {
    assertThat(StringRotation.isStringRotation("", "a")).isFalse();
  }

  @Test
  public void isStringRotation_bothSame() {
    assertThat(StringRotation.isStringRotation("a", "a")).isTrue();
  }

  @Test
  public void isStringRotation_catfish_fishcat() {
    assertThat(StringRotation.isStringRotation("catfish", "fishcat")).isTrue();
  }

  @Test
  public void isStringRotation_catfish_fishact() {
    assertThat(StringRotation.isStringRotation("catfish", "fishact")).isFalse();
  }

}