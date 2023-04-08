package core0.algorithms;

import java.io.Console;

// CHECKSTYLE:OFF

public final class NumericPatterns {
  static Console console = System.console();

  private NumericPatterns() {
  }

  /*
   * 1 2 3 4
   * 1 2 3 4
   * 1 2 3 4
   * 1 2 3 4
   */
  public static void sqr_incV_incH_prnH(int lines) {
    for (int v = 1; v <= lines; v++) {
      for (int h = 1; h <= lines; h++) {
        console.printf(h + " ");
      }
      console.printf("\n");
    }
  }

  /*
   * 1 1 1 1
   * 2 2 2 2
   * 3 3 3 3
   * 4 4 4 4
   */
  public static void sqr_incV_incH_prnV(int lines) {
    for (int v = 1; v <= lines; v++) {
      for (int h = 1; h <= lines; h++) {
        console.printf(v + " ");
      }
      console.printf("\n");
    }
  }

  /*
   * 4 3 2 1
   * 4 3 2 1
   * 4 3 2 1
   * 4 3 2 1
   */
  public static void sqr_incV_decH_prnH(int lines) {
    for (int v = 1; v <= lines; v++) {
      for (int h = lines; h >= 1; h--) {
        console.printf(h + " ");
      }
      console.printf("\n");
    }
  }

  /*
   * 4 4 4 4
   * 3 3 3 3
   * 2 2 2 2
   * 1 1 1 1
   */
  public static void sqr_decV_incH_prnV(int lines) {
    for (int v = lines; v >= 1; v--) {
      for (int h = 1; h <= lines; h++) {
        console.printf(v + " ");
      }
      console.printf("\n");
    }
  }

  /*
   * 1
   * 1 2
   * 1 2 3
   * 1 2 3 4
   */
  public static void trn_incV_incH_prnH(int lines) {
    for (int v = 1; v <= lines; v++) {
      for (int h = 1; h <= v; h++) {
        console.printf(h + " ");
      }
      console.printf("\n");
    }
  }

  /*
   * 1
   * 2 2
   * 3 3 3
   * 4 4 4 4
   */
  public static void trn_incV_incH_prnV(int lines) {
    for (int v = 1; v <= lines; v++) {
      for (int h = 1; h <= v; h++) {
        console.printf(v + " ");
      }
      console.printf("\n");
    }
  }

  /*
   * 1
   * 2 1
   * 3 2 1
   * 4 3 2 1
   */
  public static void trn_incV_decH_prnH(int lines) {
    for (int v = 1; v <= lines; v++) {
      for (int h = v; h >= 1; h--) {
        console.printf(h + " ");
      }
      console.printf("\n");
    }
  }

  /*
   * 4 4 4 4
   * 3 3 3
   * 2 2
   * 1
   */
  public static void trn_decV_incH_prnV(int lines) {
    for (int v = lines; v >= 1; v--) {
      for (int h = 1; h <= v; h++) {
        console.printf(v + " ");
      }
      console.printf("\n");
    }
  }

  /*
   * 1 2 3 4
   * 1 2 3
   * 1 2
   * 1
   */
  public static void trn_decV_incH_prnH(int lines) {
    for (int v = lines; v >= 1; v--) {
      for (int h = 1; h <= v; h++) {
        console.printf(h + " ");
      }
      console.printf("\n");
    }
  }

  /*
   * 4 3 2 1
   * 3 2 1
   * 2 1
   * 1
   */
  public static void trn_decV_decH_prnH(int lines) {
    for (int v = lines; v >= 1; v--) {
      for (int h = v; h >= 1; h--) {
        console.printf(h + " ");
      }
      console.printf("\n");
    }
  }

  /*
   * 4
   * 4 3
   * 4 3 2
   * 4 3 2 1
   */
  public static void trn_incV_incH_prnLH(int lines) {
    for (int v = 1; v <= lines; v++) {
      for (int h = 1; h <= v; h++) {
        console.printf(lines - h + 1 + " ");
      }
      console.printf("\n");
    }
  }

  /*
   * 4
   * 3 3
   * 2 2 2
   * 1 1 1 1
   */
  public static void trn_incV_incH_prnLV(int lines) {
    for (int v = 1; v <= lines; v++) {
      for (int h = 1; h <= v; h++) {
        console.printf(lines - v + 1 + " ");
      }
      console.printf("\n");
    }
  }

  /*
   * 4
   * 3 4
   * 2 3 4
   * 1 2 3 4
   */
  public static void trn_incV_decH_prnLHH(int lines) {
    for (int v = 1; v <= lines; v++) {
      for (int h = v; h >= 1; h--) {
        console.printf(lines - h + 1 + " ");
      }
      console.printf("\n");
    }
  }

  /*
   * 1 1 1 1
   * 2 2 2
   * 3 3
   * 4
   */
  public static void trn_decV_incH_prnLV(int lines) {
    for (int v = lines; v >= 1; v--) {
      for (int h = 1; h <= v; h++) {
        console.printf(lines - v + 1 + " ");
      }
      console.printf("\n");
    }
  }

  /*
   * 4 3 2 1
   * 4 3 2
   * 4 3
   * 4
   */
  public static void trn_decV_incH_prnLH(int lines) {
    for (int v = lines; v >= 1; v--) {
      for (int h = 1; h <= v; h++) {
        console.printf(lines - h + 1 + " ");
      }
      console.printf("\n");
    }
  }

  /*
   * 1 2 3 4
   * 2 3 4
   * 3 4
   * 4
   */
  public static void trn_decV_decH_prnLH(int lines) {
    for (int v = lines; v >= 1; v--) {
      for (int h = v; h >= 1; h--) {
        console.printf(lines - h + 1 + " ");
      }
      console.printf("\n");
    }
  }

  /*
   * 1
   * 2 3
   * 4 5 6
   * 7 8 9 10
   * 11 12 13 14 15
   */
  public static void trn_incV_incH_prnK(int lines) {
    int k = 1;
    for (int v = 1; v <= lines; v++) {
      for (int h = 1; h <= v; h++, k++) {
        console.printf(k + " ");
      }
      console.printf("\n");
    }
  }

  /*
   * 2
   * 4 8
   * 16 32 64
   * 128 256 512 1024
   * 2048 4096 8192 16384 32768
   */
  public static void trn_incV_incH_prnK2(int lines) {
    long k = 2;
    for (int v = 1; v <= lines; v++) {
      for (int h = 1; h <= v; h++, k *= 2) {
        console.printf(k + " ");
      }
      console.printf("\n");
    }
  }

  /*
   * ------1
   * ----2 2
   * --3 3 3
   * 4 4 4 4
   */
  public static void trn_incV_incH_decS_prnV(int lines) {
    for (int v = 1; v <= lines; v++) {
      for (int s = lines; s > v; s--) {
        console.printf("  "); // 2 spaces
      }
      for (int h = 1; h <= v; h++) {
        console.printf(v + " ");
      }
      console.printf("\n");
    }
  }

  /*
   * 4 4 4 4
   * --3 3 3
   * ----2 2
   * ------1
   */
  public static void trn_decV_incH_incS_prnV(int lines) {
    for (int v = lines; v >= 1; v--) {
      for (int s = v; s < lines; s++) {
        console.printf("  "); // 2 spaces
      }
      for (int h = 1; h <= v; h++) {
        console.printf(v + " ");
      }
      console.printf("\n");
    }
  }

  /*
   * ------1
   * ----2 2
   * --3 3 3
   * 4 4 4 4
   * --3 3 3
   * ----2 2
   * ------1
   */
  public static void rgh_top_btm_trn(int lines) {
    // Top Half
    for (int v = 1; v <= lines; v++) {
      for (int s = lines; s > v; s--) {
        console.printf("  "); // 2 spaces
      }
      for (int h = 1; h <= v; h++) {
        console.printf(v + " ");
      }
      console.printf("\n");
    }

    // Bottom Half
    lines -= 1;
    for (int v = lines; v >= 1; v--) {
      console.printf("  ");
      for (int s = v; s < lines; s++) {
        console.printf("  "); // 2 spaces
      }
      for (int h = 1; h <= v; h++) {
        console.printf(v + " ");
      }
      console.printf("\n");
    }
  }

  /*
   * ------1
   * ----2 2 2
   * --3 3 3 3 3
   * 4 4 4 4 4 4 4 4
   */
  public static void lft_rgh_top_trn(int lines) {
    for (int v = 1; v <= lines; v++) {
      for (int s = lines; s > v; s--) {
        console.printf("  "); // 2 spaces
      }
      // Left + Right Half
      for (int h = 1; h < v * 2; h++) {
        console.printf(v + " ");
      }
      console.printf("\n");
    }
  }

  /*
   * --------1
   * ------2 2 2
   * ----3 3 3 3 3
   * --4 4 4 4 4 4 4
   * 5 5 5 5 5 5 5 5 5
   * --4 4 4 4 4 4 4
   * ----3 3 3 3 3
   * ------2 2 2
   * --------1
   */
  public static void lft_rgh_top_btm_trn(int lines) {
    // Top Half
    for (int v = 1; v <= lines; v++) {
      for (int s = lines; s > v; s--) {
        console.printf("  "); // 2 spaces
      }
      // (Left + Right) Top Quarter
      for (int h = 1; h < v * 2; h++) {
        console.printf(v + " ");
      }
      console.printf("\n");
    }

    // Bottom Half
    lines -= 1;
    for (int v = lines; v >= 1; v--) {
      console.printf("  ");
      for (int s = v; s < lines; s++) {
        console.printf("  "); // 2 spaces
      }
      // (Left + Right) Bottom Quarter
      for (int h = 1; h < v * 2; h++) {
        console.printf(v + " ");
      }
      console.printf("\n");
    }
  }

  /*
   * R
   * R E
   * R E P
   * R E P U
   * R E P U B
   * R E P U B L
   * R E P U B L I
   * R E P U B L I C
   */
  public static void lft_str_trn(String text) {
    int lines = text.length();

    for (int v = 1; v <= lines; v++) {
      for (int h = 1; h <= v; h++) {
        char c = text.charAt(h - 1);
        console.printf(c + " ");
      }
      console.printf("\n");
    }
  }

  /*
   * 1 2 3 4
   * 1 --- 4
   * 1 --- 4
   * 1 2 3 4
   */
  public static void incBorder_sqr(int lines) {
    for (int v = 1; v <= lines; v++) {
      for (int h = 1; h <= lines; h++) {
        if ((v > 1 && h > 1) && (v < lines && h < lines)) // (2, 2) - (3, 3)
          console.printf("  ");
        else
          console.printf(h + " ");
      }
      console.printf("\n");
    }
  }

  /*
   * 1 2 3 4
   * 2 --- 3
   * 3 --- 2
   * 4 3 2 1
   */
  public static void cylBorder_sqr(int lines) {
    int l = 1;
    int r = lines;
    int t = l + 1;
    int b = r - 1;

    for (int v = 1; v <= lines; v++) {
      for (int h = 1; h <= lines; h++) {
        if (h == 1)
          console.printf(l++ + " ");
        else if (h == lines)
          console.printf(r-- + " ");
        else if (v == 1)
          console.printf(t++ + " ");
        else if (v == lines)
          console.printf(b-- + " ");
        else
          console.printf("  ");
      }
      console.printf("\n");
    }
  }
}

// CHECKSTYLE:ON
