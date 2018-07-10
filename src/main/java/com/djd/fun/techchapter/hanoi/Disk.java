package com.djd.fun.techchapter.hanoi;

import java.util.Objects;

import com.google.common.collect.Comparators;

/**
 * A representation of a disk.
 */
public class Disk implements Comparable<Disk> {
  private final int size;

  public Disk(int size) {
    this.size = size;
  }

  public int getSize() {
    return size;
  }

  /**
   * Compares disks and returns {@code true} if this disk size is bigger than the given disk.
   */
  public boolean isBiggerThan(Disk otherDisk) {
    return compareTo(otherDisk) < 0;
  }

  /**
   * Compares disks and returns {@code true} if this disk size is smaller than the given disk.
   */
  public boolean isSmallerThan(Disk otherDisk) {
    return compareTo(otherDisk) > 0;
  }

  /**
   * Compares disks and returns {@code true} if this disk size is not smaller than the given disk.
   */
  public boolean isNotSmallerThan(Disk otherDisk) {
    return !isSmallerThan(otherDisk);
  }

  @Override
  public boolean equals(Object that) {
    if (this == that) {
      return true;
    }
    if (!(that instanceof Disk)) {
      return false;
    }
    Disk disk = (Disk)that;
    return size == disk.size;
  }

  @Override
  public int hashCode() {
    return Objects.hash(size);
  }

  @Override
  public String toString() {
    return "(Disk_" + size + ')';
  }

  /**
   * this > that: -1
   * this == that: 0
   * this < that: 1
   */
  @Override
  public int compareTo(Disk that) {
    return (this.size > that.size) ? -1 : ((this.size == that.size) ? 0 : 1);
  }
}
