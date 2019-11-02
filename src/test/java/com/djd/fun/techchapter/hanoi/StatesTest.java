package com.djd.fun.techchapter.hanoi;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

public class StatesTest {

  private static final Disk DISK_1 = new Disk(1);
  private static final Disk DISK_2 = new Disk(2);

  @Test
  public void isValidMove() {
    assertThat(States.isValidMove(ImmutableList.of(DISK_1), ImmutableList.of(DISK_2))).isTrue();
  }

  @Test
  public void isValidMove_invalidMove() {
    assertThat(States.isValidMove(ImmutableList.of(DISK_2), ImmutableList.of(DISK_1))).isFalse();
  }

  @Test
  public void isValidMove_fromEmpty() {
    assertThat(States.isValidMove(ImmutableList.of(), ImmutableList.of(DISK_1))).isFalse();
  }

  @Test
  public void isValidMove_toEmpty() {
    assertThat(States.isValidMove(ImmutableList.of(DISK_1), ImmutableList.of())).isTrue();
  }
  //
  //  @Test
  //  public void mm() {
  //    States.State state1 = new States.State(ImmutableMap.of(States.PegName.LEFT,
  // ImmutableList.of(DISK_1)));
  //  }
}
