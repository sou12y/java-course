package core0.algorithms;

public final class NumericGames {
  private NumericGames() {
  }

  public static int minDigit(int number) {
    int minDigit = 9;
    while (number != 0) {
      int lastDigit = number % 10;
      minDigit = Math.min(minDigit, lastDigit);
      number /= 10;
    }

    return minDigit;
  }

  public static int maxDigit(int number) {
    int maxDigit = 0;
    while (number != 0) {
      int lastDigit = number % 10;
      maxDigit = Math.max(maxDigit, lastDigit);
      number /= 10;
    }

    return maxDigit;
  }

  public static int minFrequentDigit(int number) {
    /*
     * TASK(author): Improve it using an array.
     */

    int minFrequentDigit = 0;
    int minFrequency = Integer.MAX_VALUE;

    for (int d = 0; d <= 9; d++) {
      int currentFrequency = 0;
      int temp = number;

      while (temp != 0) {
        int lastDigit = temp % 10;
        if (lastDigit == d) {
          currentFrequency += 1;
        }
        temp /= 10;
      }

      if (currentFrequency != 0 && currentFrequency < minFrequency) {
        minFrequency = currentFrequency;
        minFrequentDigit = d;
      }
    }

    return minFrequentDigit;
  }

  public static int maxFrequentDigit(int number) {
    /*
     * TASK(author): Improve it using an array.
     */

    int maxFrequentDigit = 0;
    int maxFrequency = Integer.MIN_VALUE;

    for (int d = 0; d <= 9; d++) {
      int currentFrequency = 0;
      int temp = number;

      while (temp != 0) {
        int lastDigit = temp % 10;
        if (lastDigit == d) {
          currentFrequency += 1;
        }
        temp /= 10;
      }

      if (currentFrequency != 0 && currentFrequency > maxFrequency) {
        maxFrequency = currentFrequency;
        maxFrequentDigit = d;
      }
    }

    return maxFrequentDigit;
  }

  public static int getDigitsSum(int number) {
    int sum = 0;
    while (number != 0) {
      int lastDigit = number % 10;
      sum += lastDigit;
      number /= 10;
    }

    return sum;
  }

  public static int getDivisorsSum(int number) {
    int sum = 1;
    for (int d = 2; d <= number / 2; d++) {
      if (number % d == 0) {
        sum += d;
      }
    }

    return sum;
  }

  public static boolean isHarshad(int number) {
    int sum = getDigitsSum(number);
    return sum != 0 && number % sum == 0;
  }

  public static boolean isPerfect(int number) {
    return getDivisorsSum(number) == number;
  }

  public static boolean isPalindromic(int number) {
    return number > 0 && Numeric.reverse(number) == number;
  }

  public static boolean isMunchausen(int number) {
    int result = 0;
    int temp;

    temp = number;
    while (temp != 0) {
      int lastDigit = temp % 10;
      result += (int) Math.pow(lastDigit, lastDigit);
      temp /= 10;
    }

    return result == number;
  }

  public static boolean isFactorion(int number) {
    /*
     * TASK(author): Improve it using an array.
     */

    int result = 0;
    int temp = number;

    while (temp != 0) {
      int lastDigit = temp % 10;
      result += Numeric.factorial(lastDigit);
      temp /= 10;
    }

    return result == number;
  }

  public static boolean isNarcissistic(int number) {
    int digitsCount = 0;
    int result = 0;
    int temp;

    temp = number;
    while (temp != 0) {
      digitsCount += 1;
      temp /= 10;
    }

    temp = number;
    while (temp != 0) {
      int lastDigit = temp % 10;
      result += (int) Math.pow(lastDigit, digitsCount);
      temp /= 10;
    }

    return result == number;
  }

  public static boolean isPolydivisible(int number) {
    boolean isPoldivNum = true;
    int digitsCount = 0;
    int temp;

    temp = number;
    while (temp != 0) {
      digitsCount += 1;
      temp /= 10;
    }

    if (digitsCount == 0) {
      return false;
    }

    temp = number;
    while (temp > 9) {
      if (temp % digitsCount != 0) {
        isPoldivNum = false;
        break;
      }
      digitsCount -= 1;
      temp /= 10;
    }

    return isPoldivNum;
  }

  public static boolean isAutomorphic(int number) {
    int square = number * number;
    while (number != 0) {
      int sLastDigit = square % 10;
      int nLastDigit = number % 10;
      if (sLastDigit != nLastDigit) {
        return false;
      }

      square /= 10;
      number /= 10;
    }

    return true;
  }

  public static boolean isHappy(int number) {
    while (number > 9) {
      int result = 0;
      while (number != 0) {
        int lastDigit = number % 10;
        result += lastDigit * lastDigit;
        number /= 10;
      }
      number = result;
    }

    return number == 1 || number == 7;
  }

  public static boolean isKaprekar(int number) {
    boolean isKapNum = false;
    int digitsCount = 0;
    int square = number * number;

    while (square != 0) {
      digitsCount += 1;
      square /= 10;
    }

    for (int i = 1; i <= digitsCount; i++) {
      int part = (int) Math.pow(10, i);
      if (part == number) {
        break;
      }

      int sum = square / part + square % part;
      if (sum == number) {
        isKapNum = true;
        break;
      }
    }

    return isKapNum;
  }

  public static boolean isEvil(int number) {
    long binary = Numeric.binary(number);
    int count = 0;

    while (binary != 0) {
      int lastDigit = (int) (binary % 10);
      if (lastDigit == 2) {
        count += 1;
      }
    }

    return count % 2 == 0;
  }

  public static boolean isPalindromicPrime(int number) {
    return isPalindromic(number) && Numeric.isPrime(number);
  }

  public static boolean isEmirp(int number) {
    if (Numeric.isPrime(number)) {
      int reverse = Numeric.reverse(number);
      if (Numeric.isPrime(reverse)) {
        return true;
      }
    }

    return false;
  }

  public static boolean isTwinPrime(int a, int b) {
    return Numeric.isPrime(a) && Numeric.isPrime(b) && Math.abs(a - b) == 2;
  }
}
