package com.djd.fun.techchapter.hanoi;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Before;
import org.junit.Test;

public class DiskTest {

  private Disk disk;

  @Before
  public void setUp() {
    disk = new Disk(2);
  }

  @Test
  public void getSize() {
    assertThat(disk.getSize()).isEqualTo(2);
  }

  @Test
  public void isBiggerThan_2isNotBiggerThan3() {
    assertThat(new Disk(2).isBiggerThan(new Disk(3))).isFalse();
  }

  @Test
  public void isBiggerThan_3isBiggerThan2() {
    assertThat(new Disk(3).isBiggerThan(new Disk(2))).isTrue();
  }

  @Test
  public void isBiggerThan_2isNotBiggerThan2() {
    assertThat(new Disk(2).isBiggerThan(new Disk(2))).isFalse();
  }

  @Test
  public void isSmallerThan_3isNotSmallerThan2() {
    assertThat(new Disk(3).isSmallerThan(new Disk(2))).isFalse();
  }

  @Test
  public void isSmallerThan_2isSmallerThan3() {
    assertThat(new Disk(2).isSmallerThan(new Disk(3))).isTrue();
  }

  @Test
  public void isSmallerThan_2isNotSmallerThan2() {
    assertThat(new Disk(2).isSmallerThan(new Disk(2))).isFalse();
  }

  @Test
  public void isNotSmallerThan_3isNotSmallerThan2() {
    assertThat(new Disk(3).isNotSmallerThan(new Disk(2))).isTrue();
  }

  @Test
  public void isNotSmallerThan_2isSmallerThan3() {
    assertThat(new Disk(2).isNotSmallerThan(new Disk(3))).isFalse();
  }

  @Test
  public void isNotSmallerThan_2isNotSmallerThan2() {
    assertThat(new Disk(2).isNotSmallerThan(new Disk(2))).isTrue();
  }
}
