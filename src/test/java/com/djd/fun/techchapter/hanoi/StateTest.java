package com.djd.fun.techchapter.hanoi;

import com.google.common.collect.ImmutableList;
import com.google.common.testing.EqualsTester;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class StateTest {
  private static final Disk DISK_1 = new Disk(1);
  private static final Disk DISK_2 = new Disk(2);
  private static final Disk DISK_3 = new Disk(3);
  private static final State STATE_1 = State.builder()
      .leftPeg(DISK_3)
      .leftPeg(DISK_2)
      .leftPeg(DISK_1)
      .build();
  private static final State STATE_2 = State.builder()
      .leftPeg(DISK_3)
      .leftPeg(DISK_1)
      .middlePeg(DISK_2)
      .build();
  private static final State STATE_3 = State.builder()
      .rightPeg(DISK_3)
      .rightPeg(DISK_1)
      .middlePeg(DISK_2)
      .build();
  private static final State STATE_4 = State.builder()
      .leftPeg(DISK_3)
      .leftPeg(DISK_2)
      .build();
  private static final State STATE_5 = State.builder()
      .leftPeg(DISK_3)
      .leftPeg(DISK_1)
      .build();
  private static final State STATE_6 = State.builder()
      .rightPeg(DISK_3)
      .middlePeg(DISK_2)
      .build();


  @Test
  public void equality() {
    new EqualsTester()
        .addEqualityGroup(STATE_1, State.builder(STATE_1).build())
        .addEqualityGroup(STATE_2)
        .testEquals();
  }

  @Test
  public void removeLastFromLeft() {
    State.Builder builder = State.builder(STATE_1);
    assertThat(builder.removeLastFromLeft().build()).isEqualTo(STATE_4);
  }

  @Test
  public void removeLastFromMiddle() {
    State.Builder builder = State.builder(STATE_2);
    assertThat(builder.removeLastFromMiddle().build()).isEqualTo(STATE_5);
  }

  @Test
  public void removeLastFromRight() {
    State.Builder builder = State.builder(STATE_3);
    assertThat(builder.removeLastFromRight().build()).isEqualTo(STATE_6);
  }

  @Test
  public void removeLastFromLeft_empty() {
    State.Builder builder = State.builder(STATE_3);
    assertThat(builder.removeLastFromLeft().build()).isEqualTo(STATE_3);
  }

  @Test
  public void removeLastFromMiddle_empty() {
    State.Builder builder = State.builder(STATE_1);
    assertThat(builder.removeLastFromMiddle().build()).isEqualTo(STATE_1);
  }

  @Test
  public void removeLastFromRight_empty() {
    State.Builder builder = State.builder(STATE_1);
    assertThat(builder.removeLastFromRight().build()).isEqualTo(STATE_1);
  }

  @Test
  public void checkOrdering_empty_valid() {
    State.checkOrdering(ImmutableList.of());
  }

  @Test
  public void checkOrdering_single_valid() {
    State.checkOrdering(ImmutableList.of(DISK_1));
  }

  @Test
  public void checkOrdering_two_valid() {
    State.checkOrdering(ImmutableList.of(DISK_2, DISK_1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void checkOrdering_badOrder_invalid() {
    State.checkOrdering(ImmutableList.of(DISK_2, DISK_3));
  }
}