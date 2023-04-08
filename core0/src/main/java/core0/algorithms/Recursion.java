package core0.algorithms;

import java.io.Console;

public final class Recursion {
  static Console console = System.console();

  private Recursion() {
  }

  public static long factorial(int value) {
    if (value == 0) {
      return 1;
    }

    return value * factorial(value - 1);
  }

  public static int reverse(int number) {
    throw new UnsupportedOperationException();
  }

  public static void printFibonacciSequence(int count) {
    int a = 0;
    int b = 1;
    console.printf("%d, %d", a, b);
    printFibonacciSequenceR(count - 2, a, b, 0);
  }

  private static void printFibonacciSequenceR(int count, int a, int b, int c) {
    if (count > 0) {
      c = a + b;
      a = b;
      b = c;
      console.printf("%d, ", c);
      printFibonacciSequenceR(count - 1, a, b, c);
    }
  }
}
