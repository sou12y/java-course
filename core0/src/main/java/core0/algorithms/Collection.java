package core0.algorithms;

public final class Collection {
  private Collection() {
  }

  public static int getIndexOfMin(int[] array) {
    int minIndex = 0;
    for (int i = 1; i < array.length; i++) {
      if (array[i] < array[minIndex]) {
        minIndex = i;
      }
    }

    return minIndex;
  }

  public static int getIndexOfMax(int[] array) {
    int maxIndex = 0;
    for (int i = 1; i < array.length; i++) {
      if (array[i] > array[maxIndex]) {
        maxIndex = i;
      }
    }

    return maxIndex;
  }

  public static int getIndexOfMin2(int[] array) {
    int min1stIndex = 0;
    int min2ndIndex = 0;

    for (int i = 1; i < array.length; i++) {
      if (array[i] < array[min1stIndex]) {
        min2ndIndex = min1stIndex;
        min1stIndex = i;
      } else if (array[i] < array[min2ndIndex] && array[i] != array[min1stIndex]) {
        min2ndIndex = i;
      }
    }

    return min2ndIndex;
  }

  public static int getIndexOfMax2(int[] array) {
    int max1stIndex = 0;
    int max2ndIndex = 0;
    for (int i = 1; i < array.length; i++) {
      if (array[i] > array[max1stIndex]) {
        max2ndIndex = max1stIndex;
        max1stIndex = i;
      } else if (array[i] > array[max2ndIndex] && array[i] != array[max1stIndex]) {
        max2ndIndex = i;
      }
    }

    return max2ndIndex;
  }

  public static int[] trim(int[] array, int length) {
    length = Math.min(array.length, length);
    int[] trimmed = new int[length];

    for (int i = 0; i < trimmed.length; i++) {
      trimmed[i] = array[i];
    }

    return trimmed;
  }

  public static int[] shiftLeft(int[] array, int count) {
    throw new UnsupportedOperationException();
  }

  public static int[] removeAll(int[] array, int value) {
    throw new UnsupportedOperationException();
  }

  public static int[] combine(int[] a, int[] b) {
    int[] c = new int[a.length + b.length];
    int aIndex = 0;
    int bIndex = 0;
    int cIndex = 0;

    while (aIndex < a.length) {
      c[cIndex] = a[aIndex];
      cIndex += 1;
      aIndex += 1;
    }
    while (bIndex < b.length) {
      c[cIndex] = b[bIndex];
      cIndex += 1;
      bIndex += 1;
    }

    return c;
  }

  public static int[][] separateEvenOdd(int[] array) {
    int[] evens = new int[array.length];
    int[] odds = new int[array.length];
    int evenIndex = 0;
    int oddIndex = 0;

    for (int item : array) {
      if (item % 2 == 0) {
        evens[evenIndex] = item;
        evenIndex += 1;
      } else {
        odds[oddIndex] = item;
        oddIndex += 1;
      }
    }
    int[][] separated = new int[2][];
    separated[0] = trim(evens, evenIndex);
    separated[1] = trim(odds, oddIndex);

    return separated;
  }

  public static int gcd(int[] array) {
    int gcd = array[0];
    for (int i = 1; i < array.length; i++) {
      gcd = Numeric.gcd(gcd, array[i]);
    }

    return gcd;
  }

  public static void reverse(int[] array) {
    int lower = 0;
    int upper = array.length - 1;

    while (lower < upper) {
      int temp = array[lower];
      array[lower] = array[upper];
      array[upper] = temp;
      lower += 1;
      upper -= 1;
    }
  }

  public static int linearSearch(int[] array, int key) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] == key) {
        return i;
      }
    }

    return -1;
  }

  public static int linearSearch(String[] array, String key) {
    for (int i = 0; i < array.length; i++) {
      if (array[i].compareTo(key) == 0) {
        return i;
      }
    }

    return -1;
  }

  public static int binarySearch(int[] array, int key) {
    int lower = 0;
    int upper = array.length - 1;

    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (array[middle] == key) {
        return middle;
      }

      if (array[middle] > key) {
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return -1;
  }

  public static int binarySearch(String[] array, String key) {
    int lower = 0;
    int upper = array.length - 1;

    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      int order = array[middle].compareTo(key);
      if (order == 0) {
        return middle;
      }

      if (order > 0) {
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return -1;
  }

  public static void selectionSort(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[minIndex]) {
          minIndex = j;
        }
      }
      if (i != minIndex) {
        int temp = array[minIndex];
        array[minIndex] = array[i];
        array[i] = temp;
      }
    }
  }

  public static void selectionSort(String[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j].compareTo(array[minIndex]) < 0) {
          minIndex = j;
        }
      }
      if (i != minIndex) {
        String temp = array[minIndex];
        array[minIndex] = array[i];
        array[i] = temp;
      }
    }
  }

  public static void bubbleSort(int[] array) {
    boolean swapped = true;
    int i = 0;
    while (swapped) {
      swapped = false;
      i++;
      for (int j = 0; j < array.length - i; j++) {
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
          swapped = true;
        }
      }
    }
  }

  public static void bubbleSort(String[] array) {
    boolean swapped = true;
    int i = 0;
    while (swapped) {
      swapped = false;
      i++;
      for (int j = 0; j < array.length - i; j++) {
        if (array[j].compareTo(array[j + 1]) > 0) {
          String temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
          swapped = true;
        }
      }
    }
  }

  public static void insertionSort(int[] array) {
    throw new UnsupportedOperationException();
  }

  public static void insertionSort(String[] array) {
    throw new UnsupportedOperationException();
  }

  public static String select(int[] indexes, String[] values, int key) {
    int valueIndex = linearSearch(indexes, key);
    return values[valueIndex];
  }
}
