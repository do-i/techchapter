package com.djd.fun.techchapter.demo022Bisection;

import java.util.function.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bisection {

  private static final Logger log = LoggerFactory.getLogger(Bisection.class);
  private static final float EPSILON = 0.0001f;

  public static void main(String[] args) {
    log.info(
        "The value of root is : {}",
        bisection(x -> -(((x * x) - 1) * ((x * x) - 4)) - (-4.01), -2, 10));
  }

  public static double bisection(
      Function<Double, Double> goofyFunction, double lowerBound, double upperBound) {
    double midPoint = lowerBound;
    while ((upperBound - lowerBound) >= EPSILON) {
      midPoint = (lowerBound + upperBound) / 2;
      if (goofyFunction.apply(midPoint) == 0.0) {
        log.info("It is miracle to see me.");
        return midPoint;
      }
      if (goofyFunction.apply(midPoint) * goofyFunction.apply(lowerBound) < 0) {
        upperBound = midPoint;
      } else {
        lowerBound = midPoint;
      }
    }
    return midPoint;
  }
}
