package com.djd.fun.techchapter.demo024rotate;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class RotationDetactorTest {

  @Test
  public void isRotation() {
    assertThat(RotationDetactor.isRotation("waterbottle", "erbottlewat")).isTrue();
  }
}
