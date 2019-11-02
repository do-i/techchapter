package com.djd.fun.techchapter.demo014swing.maze.shapes;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.testing.EqualsTester;
import org.junit.Test;

public class DiamondTest {

  @Test
  public void with_row0col0size20() {
    Diamond diamond = Diamond.with(0, 0, 20);
    assertThat(diamond.npoints).isEqualTo(4);
    assertThat(diamond.xpoints).asList().containsExactly(10, 20, 10, 0).inOrder();
    assertThat(diamond.ypoints).asList().containsExactly(0, 10, 20, 10).inOrder();
  }

  @Test
  public void with_row3col3size20() {
    Diamond diamond = Diamond.with(2, 3, 20);
    assertThat(diamond.npoints).isEqualTo(4);
    assertThat(diamond.xpoints).asList().containsExactly(70, 80, 70, 60).inOrder();
    assertThat(diamond.ypoints).asList().containsExactly(40, 50, 60, 50).inOrder();
  }

  @Test(expected = IllegalArgumentException.class)
  public void with_badRow() {
    Diamond.with(-1, 0, 20);
  }

  @Test(expected = IllegalArgumentException.class)
  public void with_badCol() {
    Diamond.with(0, -1, 20);
  }

  @Test(expected = IllegalArgumentException.class)
  public void with_badSize() {
    Diamond.with(0, 0, 0);
  }

  @Test
  public void equality() {
    new EqualsTester()
        .addEqualityGroup(Diamond.with(0, 0, 20), Diamond.with(0, 0, 20))
        .addEqualityGroup(Diamond.with(1, 0, 20))
        .addEqualityGroup(Diamond.with(0, 1, 20))
        .addEqualityGroup(Diamond.with(0, 0, 80))
        .testEquals();
  }
}
