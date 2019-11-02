package com.djd.fun.techchapter.hanoi;

import static com.djd.fun.techchapter.hanoi.States.Move.LEFT_TO_MIDDLE;
import static com.djd.fun.techchapter.hanoi.States.Move.LEFT_TO_RIGHT;
import static com.djd.fun.techchapter.hanoi.States.Move.MIDDLE_TO_LEFT;
import static com.djd.fun.techchapter.hanoi.States.Move.MIDDLE_TO_RIGHT;
import static com.djd.fun.techchapter.hanoi.States.Move.RIGHT_TO_LEFT;
import static com.djd.fun.techchapter.hanoi.States.Move.RIGHT_TO_MIDDLE;
import static com.google.common.truth.Truth.assertThat;

import org.junit.Before;
import org.junit.Test;

public class HanoiTest {

  private static final Disk DISK_1 = new Disk(1);
  private static final Disk DISK_2 = new Disk(2);
  private static final Disk DISK_3 = new Disk(3);
  private Hanoi hanoi;

  @Before
  public void setUp() {
    hanoi = new Hanoi(3);
  }

  @Test
  public void moveLeftToMiddle_300To210() {
    assertThat(hanoi.move(LEFT_TO_MIDDLE)).isTrue();
  }

  @Test
  public void moveLeftToRight_300To201() {
    assertThat(hanoi.move(LEFT_TO_RIGHT)).isTrue();
  }

  @Test
  public void moveMiddleToLeft_300To300() {
    assertThat(hanoi.move(MIDDLE_TO_LEFT)).isFalse();
  }

  @Test
  public void moveMiddleToRight_300To300() {
    assertThat(hanoi.move(MIDDLE_TO_RIGHT)).isFalse();
  }

  @Test
  public void moveRightToLeft_300To300() {
    assertThat(hanoi.move(RIGHT_TO_LEFT)).isFalse();
  }

  @Test
  public void moveRightToMiddle_300To300() {
    assertThat(hanoi.move(RIGHT_TO_MIDDLE)).isFalse();
  }

  @Test
  public void getDisksOnLeftPeg() {
    assertThat(hanoi.getDisksOnLeftPeg()).containsExactly(DISK_3, DISK_2, DISK_1).inOrder();
  }

  @Test
  public void getDisksOnMiddlePeg() {
    hanoi.move(LEFT_TO_MIDDLE);
    assertThat(hanoi.getDisksOnMiddlePeg()).containsExactly(DISK_1).inOrder();
  }

  @Test
  public void getDisksOnRightPeg() {
    hanoi.move(LEFT_TO_RIGHT);
    assertThat(hanoi.getDisksOnRightPeg()).containsExactly(DISK_1).inOrder();
  }
}
