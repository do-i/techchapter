package com.djd.fun.techchapter.demo019changemachine;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class ChangeMachineTest {

  @Test
  public void pay() {
    assertThat(ChangeMachine.pay(1.08, 2.00)).isEqualTo(new ChangeMachine.Changes(3, 1, 1, 2));
  }

  @Test(expected = IllegalArgumentException.class)
  public void pay_underPay() {
    ChangeMachine.pay(1.08, 1.00);
  }

  @Test(expected = IllegalArgumentException.class)
  public void pay_overPay() {
    ChangeMachine.pay(1.08, 10.00);
  }

  @Test(expected = IllegalArgumentException.class)
  public void pay_negativePay() {
    ChangeMachine.pay(1.08, -2.00);
  }

  @Test(expected = IllegalArgumentException.class)
  public void pay_negativeCost() {
    ChangeMachine.pay(-1.08, -2.00);
  }
}
