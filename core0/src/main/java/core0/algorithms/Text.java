package core0.algorithms;

public final class Text {
  private Text() {
  }

  public static int[] getFrequencyOfDigits(String text) {
    int[] frequency = new int[10];
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      if (Character.isDigit(c)) {
        frequency[c - '0']++;
      }
    }

    return frequency;
  }

  public static int[] getFrequencyOfAlphabets(String text) {
    int[] frequency = new int[26];
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      if (Character.isLetter(c)) {
        c = Character.toUpperCase(c);
        frequency[c - 'A']++;
      }
    }

    return frequency;
  }

  public static int countDigits(String text) {
    int sum = 0;
    int[] frequency = getFrequencyOfDigits(text);
    for (int i = 1; i < frequency.length; i++) {
      sum += frequency[i];
    }

    return sum;
  }

  public static int countAlphabets(String text) {
    int sum = 0;
    int[] frequency = getFrequencyOfAlphabets(text);
    for (int i = 1; i < frequency.length; i++) {
      sum += frequency[i];
    }

    return sum;
  }

  public static int countVowels(String text) {
    int s = 0;
    int[] f = getFrequencyOfAlphabets(text);
    // ___a_______e_____i______o_______u___
    s = f[1] + f[5] + f[9] + f[15] + f[21];

    return s;
  }

  public static int countConsonants(String text) {
    int sum = 0;
    int[] frequency = getFrequencyOfAlphabets(text);
    for (int i = 1; i < frequency.length; i++) {
      // _a_________e_________i_________o__________u_
      if (i == 1 || i == 5 || i == 9 || i == 15 || i == 21) {
        continue;
      }
      sum += frequency[i];
    }

    return sum;
  }

  public static int countWords(String text) {
    int count = 0;
    text = text.trim();
    if (text.isEmpty()) {
      return 0;
    }

    for (int i = 0; i < text.length() - 1; i++) {
      char c1 = text.charAt(i);
      char c2 = text.charAt(i + 1);
      if (Character.isWhitespace(c1) && !Character.isWhitespace(c2)) {
        count += 1;
      }
    }
    count += 1;

    return count;
  }

  public static String toTitleCase(String text) {
    char[] array = text.toCharArray();
    text = text.trim();
    for (int i = 0; i < text.length() - 1; i++) {
      char c1 = text.charAt(i);
      char c2 = text.charAt(i + 1);
      if (Character.isWhitespace(c1) && !Character.isWhitespace(c2) && Character.isLetter(c2)) {
        array[i + 1] = Character.toUpperCase(c2);
      }
    }
    if (Character.isLetter(array[0])) {
      array[0] = Character.toUpperCase(array[0]);
    }

    return new String(array);
  }

  public static String reverse(String text) {
    int lower = 0;
    int upper = text.length() - 1;
    char[] array = text.toCharArray();
    while (lower < upper) {
      char temp = array[lower];
      array[lower] = array[upper];
      array[upper] = temp;

      lower += 1;
      upper -= 1;
    }

    return new String(array);
  }

  public static String[] getTokens(String text) {
    return text.split(" ");
  }

  public static String reverseTokens(String text) {
    String[] tokens = getTokens(text);
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < tokens.length; i++) {
      builder.append(reverse(tokens[i]) + " ");
    }

    return builder.toString();
  }

  public static boolean isAnagram(String textA, String textB) {
    int[] frequency = getFrequencyOfAlphabets(textA);
    for (int i = 0; i < textA.length(); i++) {
      char c = Character.toUpperCase(textB.charAt(i));
      frequency[c - 'A']--;
      if (frequency[c - 'A'] != 0) {
        return false;
      }
    }

    return true;
  }

  public static boolean isPalindrome(String text) {
    int lower = 0;
    int upper = text.length() - 1;
    while (lower <= upper) {
      char lc = text.charAt(lower);
      char uc = text.charAt(upper);
      if (Character.toUpperCase(lc) != Character.toUpperCase(uc)) {
        return false;
      }

      lower += 1;
      upper -= 1;
    }

    return true;
  }

  public static boolean isValidISBN10(String value) {
    int length = value.length();
    int sum = 0;
    for (int i = 0; i < length; i++) {
      char c = value.charAt(i);
      if (!Character.isDigit(c)) {
        return false;
      }

      int d = c - '0';
      sum += d * (length - i);
    }

    return sum % 11 == 0;
  }

  public static boolean isValidISBN13(String value) {
    int length = value.length();
    int sum = 0;
    for (int i = 0; i < length - 1; i++) {
      char c = value.charAt(i);
      if (!Character.isDigit(c)) {
        return false;
      }

      int d = c - '0';
      sum += d * (i % 2 == 0 ? 1 : 3);
    }

    int checkDigit = value.charAt(length - 1) - '0';
    return 10 - (sum % 10) == checkDigit;
  }

  public static String numberToText(int value) {
    throw new UnsupportedOperationException();
  }
}
