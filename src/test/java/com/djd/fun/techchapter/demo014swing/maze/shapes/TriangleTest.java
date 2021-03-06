package com.djd.fun.techchapter.demo014swing.maze.shapes;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.testing.EqualsTester;
import org.junit.Test;

public class TriangleTest {

  @Test
  public void up() {
    Triangle triangle = Triangle.up(0, 0, 100);
    assertThat(triangle.xpoints).asList().containsExactly(50, 4, 96).inOrder();
    assertThat(triangle.ypoints).asList().containsExactly(4, 96, 96).inOrder();
    assertThat(triangle.npoints).isEqualTo(3);
  }

  @Test
  public void up_row2_col3_size20() {
    Triangle triangle = Triangle.up(2, 3, 20);
    assertThat(triangle.xpoints).asList().containsExactly(70, 64, 76).inOrder();
    assertThat(triangle.ypoints).asList().containsExactly(44, 56, 56).inOrder();
    assertThat(triangle.npoints).isEqualTo(3);
  }

  @Test
  public void down() {
    Triangle triangle = Triangle.down(0, 0, 100);
    assertThat(triangle.xpoints).asList().containsExactly(4, 96, 50).inOrder();
    assertThat(triangle.ypoints).asList().containsExactly(4, 4, 96).inOrder();
    assertThat(triangle.npoints).isEqualTo(3);
  }

  @Test
  public void down_row2_col3_size20() {
    Triangle triangle = Triangle.down(2, 3, 20);
    assertThat(triangle.xpoints).asList().containsExactly(64, 76, 70).inOrder();
    assertThat(triangle.ypoints).asList().containsExactly(44, 44, 56).inOrder();
    assertThat(triangle.npoints).isEqualTo(3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void up_badRow() {
    Triangle.up(-1, 0, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void up_badCol() {
    Triangle.up(0, -1, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void up_badSize() {
    Triangle.up(0, 0, 0);
  }

  @Test
  public void equality() {
    new EqualsTester()
        .addEqualityGroup(Triangle.up(0, 0, 20), Triangle.up(0, 0, 20))
        .addEqualityGroup(Triangle.down(0, 0, 20), Triangle.down(0, 0, 20))
        .addEqualityGroup(Triangle.up(1, 0, 20))
        .addEqualityGroup(Triangle.up(0, 1, 20))
        .addEqualityGroup(Triangle.up(0, 0, 80))
        .addEqualityGroup(Triangle.down(1, 0, 20))
        .addEqualityGroup(Triangle.down(0, 1, 20))
        .addEqualityGroup(Triangle.down(0, 0, 80))
        .testEquals();
  }
}
