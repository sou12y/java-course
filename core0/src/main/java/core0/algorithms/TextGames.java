package core0.algorithms;

import java.util.Arrays;

public final class TextGames {
  private TextGames() {
  }

  public static boolean isAnagramText(String a, String b) {
    char[] aChars = a.toCharArray();
    char[] bChars = b.toCharArray();

    Arrays.sort(aChars);
    Arrays.sort(bChars);

    return Arrays.equals(aChars, bChars);
  }

  public static boolean isAnagramPhrase(String a, String b) {
    int[] frequency = new int[26];

    for (int i = 0; i < a.length(); i++) {
      char c = a.charAt(i);
      if (Character.isLetter(c)) {
        c = Character.toUpperCase(c);
        frequency[c - 'A']++;
      }
    }

    for (int i = 0; i < b.length(); i++) {
      char c = b.charAt(i);
      if (Character.isLetter(c)) {
        c = Character.toUpperCase(c);
        frequency[c - 'A']--;
      }
    }

    for (int i = 0; i < frequency.length; i++) {
      if (frequency[i] != 0) {
        return false;
      }
    }

    return true;
  }

  public static String[] splitN(String text, int n, boolean excludeSpecial, boolean changeCase) {
    var builder = new StringBuilder();
    for (int i = 0; i < text.length(); i++) {
      var c = text.charAt(i);
      if (!excludeSpecial || Character.isLetterOrDigit(c)) {
        builder.append(changeCase ? Character.toUpperCase(c) : c);
      }
    }

    return splitN(builder.toString(), n);
  }

  public static String[] splitN(String text, int n) {
    if (text.length() % n != 0) {
      throw new IllegalArgumentException("text length must be divisible by n.");
    }

    String[] parts = new String[n];
    int partSize = text.length() / n;

    int textIndex = 0;
    int partIndex = 0;
    while (textIndex < text.length()) {
      String part = text.substring(textIndex, textIndex + partSize);
      parts[partIndex] = part;

      textIndex += partSize;
      partIndex += 1;
    }

    return parts;
  }
}
