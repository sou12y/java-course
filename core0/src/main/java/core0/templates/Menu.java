package core0.templates;

import java.io.Console;
import java.util.Scanner;

public final class Menu {
  static Console console = System.console();

  private Menu() {
  }

  public static void showMenu() {
    Scanner in = new Scanner(System.in);
    int choice = 0;
    do {
      // Display menu.
      console.printf("""
          1. Option A
          2. Option B
          3. Exit
          """);
      choice = in.nextInt();
      switch (choice) {
        case 1:
          // Perform task A and display the result.
          taskA();
          break;
        case 2:
          // Perform task B and display the result.
          taskB();
          break;
        case 3:
          // Do nothing. We will exit the loop next time.
          break;
        default:
          console.printf("Invalid choice. Retry.\n");
          break;
      }
      console.printf("\n");
    } while (choice != 3);

    in.close();
  }

  private static void taskA() {
    console.printf("Option A was selected. Task A will be performed.");
  }

  private static void taskB() {
    console.printf("Option B was selected. Task B will be performed.");
  }
}
