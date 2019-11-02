package com.djd.fun.techchapter.hanoi;

import static com.google.common.truth.Truth.assertThat;

import java.util.Optional;
import org.junit.Before;
import org.junit.Test;

public class PegTest {

  private static final Disk DISK_1 = new Disk(1);
  private static final Disk DISK_2 = new Disk(2);
  private Peg peg;

  @Before
  public void setUp() {
    peg = new Peg();
  }

  @Test
  public void addDisk_bigOnSmall() {
    assertThat(peg.addDisk(DISK_1)).isTrue();
    assertThat(peg.addDisk(DISK_2)).isFalse();
    assertThat(peg.size()).isEqualTo(1);
  }

  @Test
  public void addDisk_sameSize() {
    assertThat(peg.addDisk(DISK_2)).isTrue();
    assertThat(peg.addDisk(DISK_2)).isFalse();
    assertThat(peg.size()).isEqualTo(1);
  }

  @Test
  public void addDisk_smallOnBig() {
    assertThat(peg.addDisk(DISK_2)).isTrue();
    assertThat(peg.addDisk(DISK_1)).isTrue();
    assertThat(peg.size()).isEqualTo(2);
  }

  @Test
  public void removeDisk_empty() {
    assertThat(peg.removeDisk()).isEqualTo(Optional.empty());
  }

  @Test
  public void removeDisk_twoDisks() {
    peg.addDisk(DISK_2);
    peg.addDisk(DISK_1);
    assertThat(peg.removeDisk().get()).isEqualTo(DISK_1);
    assertThat(peg.removeDisk().get()).isEqualTo(DISK_2);
    assertThat(peg.isEmpty()).isTrue();
  }
}
