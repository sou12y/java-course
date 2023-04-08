package core0.algorithms;

public final class Series {
  private Series() {
  }

  /*
   * Series: 1 + 1/2 + 1/3 + 1/4 + ... + 1/n
   */
  public static double sumOfHarmonicSeries(int range) {
    double sum = 0.0;
    for (int t = 1; t <= range; t++) {
      sum += 1.0 / t;
    }

    return sum;
  }

  /*
   * Series: 1 - 1/2 + 1/3 - 1/4 + ... ± 1/n
   */
  public static double sumOfAlternatingHarmonicSeries(int range) {
    double sum = 0.0;
    int sign = +1;
    for (int t = 1; t <= range; t++) {
      sum += sign / (double) t;
      sign *= -1;
    }

    return sum;
  }

  /*
   * Series: 1/2 - 1/4 + 1/8 - 1/16 + ... ± 1/n
   */
  public static double sumOfInverseOfPowerOfTwo(int range) {
    double sum = 0.0;
    int sign = +1;
    for (int t = 2; t <= range; t *= 2) {
      sum += sign / (double) t;
      sign *= -1;
    }

    return sum;
  }

  /*
   * Series: 1 + 1/2 + 1/3 + 1/5 + ... + 1/n
   */
  public static double sumOfInverseOfPrimes(int range) {
    double sum = 0.0;
    for (int t = 1; t <= range; t++) {
      if (Numeric.isPrime(t)) {
        sum += 1.0 / t;
      }
    }

    return sum;
  }

  /*
   * Series: 0! - 1! + 2! - 3! + ... ± n!
   */
  public static double sumOfAlternatingFactorial(int range) {
    double sum = 0.0;
    int sign = +1;
    for (int t = 0; t <= range; t++) {
      sum += sign * Numeric.factorial(t);
      sign *= -1;
    }

    return sum;
  }
}
