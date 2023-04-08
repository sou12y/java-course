import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    var console = System.console();
    var scanner = new Scanner(console.reader());

    console.printf("Enter a message: ");
    var message = scanner.nextLine();

    console.printf("%s", message);
  }
}
