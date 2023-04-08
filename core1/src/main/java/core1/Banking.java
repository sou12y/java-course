package core1;

import java.io.Console;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * User Interface Layer -> main() method
 * Business Layer -> Service classes
 * Data Layer -> Model classes
 */

public class Banking {
  private static Console console = System.console();
  private static Scanner scanner = new Scanner(console.reader());

  private static Service<Customer> customerService = new CustomerCsvService();
  private static Service<Account> accountService = new AccountCsvService();

  public static void main(String[] args) {
    try {
      mainMenu();
    } catch (IOException e) {
      console.printf("\nSome error occurred.\nDo you want to view details? [Y/N]: ");

      var choice = scanner.nextLine().charAt(0);
      if (Character.toUpperCase(choice) == 'Y') {
        console.printf("%s\n", e.getMessage());
      }
    } finally {
      console.printf("\n\nThank you for using our banking service.\n");
    }
  }

  public static void mainMenu() throws IOException {
    int choice;
    while (true) {
      var menu = """
          1. Customer
          2. Account
          0. Exit
                 """;
      console.printf(menu);
      choice = scanner.nextInt();

      if (choice == 0) {
        break;
      }

      switch (choice) {
        case 1:
          customerMenu();
          break;
        case 2:
          accountMenu();
          break;
        default:
          console.printf("Try again!\n");
          break;
      }
    }
  }

  public static void customerMenu() throws IOException {
    int choice;
    while (true) {
      var menu = """
          1. Create Customer
          2. Update Customer
          3. Detail Customer
          4. Delete Customer
          9. Main Menu
                 """;
      console.printf(menu);
      choice = scanner.nextInt();

      if (choice == 9) {
        mainMenu();
        break;
      }

      String id;
      String data;
      Customer customer;
      switch (choice) {
        case 1:
          data = console.readLine("Enter customer data: ");
          customerService.create(data);
          break;
        case 2:
          data = console.readLine("Enter customer data: ");
          customerService.update(data);
          break;
        case 3:
          id = console.readLine("Enter customer id: ");
          customer = customerService.detail(id);
          if (customer == null) {
            console.printf("Customer not found.\n");
          } else {
            console.printf("%s\n", customer.toString());
          }
          break;
        case 4:
          id = console.readLine("Enter customer id: ");
          customer = customerService.delete(id);
          if (customer == null) {
            console.printf("Customer not found.\n");
          } else {
            console.printf("%s\n", customer.toString());
          }
          break;
        default:
          break;
      }
    }
  }

  public static void accountMenu() throws IOException {
    int choice;
    while (true) {
      var menu = """
          1. Create Account
          2. Update Account
          3. Detail Account
          4. Delete Account
          9. Main Menu
                 """;
      console.printf(menu);
      choice = scanner.nextInt();

      if (choice == 9) {
        mainMenu();
        break;
      }

      String id;
      String data;
      Account account;
      switch (choice) {
        case 1:
          data = console.readLine("Enter account data: ");
          accountService.create(data);
          break;
        case 2:
          data = console.readLine("Enter account data: ");
          accountService.update(data);
          break;
        case 3:
          id = console.readLine("Enter account id: ");
          account = accountService.detail(id);
          if (account == null) {
            console.printf("Account not found.\n");
          } else {
            console.printf("%s\n", account.toString());
          }
          break;
        case 4:
          id = console.readLine("Enter account id: ");
          account = accountService.delete(id);
          if (account == null) {
            console.printf("Account not found.\n");
          } else {
            console.printf("%s\n", account.toString());
          }
          break;
        default:
          console.printf("Try again!\n");
          break;
      }
    }
  }
}

// #region Service Classes

interface Service<T> {
  T create(String data) throws IOException;

  T detail(String id) throws IOException;

  T update(String data) throws IOException;

  T delete(String id) throws IOException;
}

class CustomerCsvService implements Service<Customer>, Serializable {
  public static final String SAMPLE_DATA = "ID=123456;NAME=Jatin;GENDER=Male;ADDRESS=1, Kartavya Path, NEW DELHI, 110001;PHONE=9876543210;EMAIL=jatin@example.com";

  private final Set<Customer> db = new HashSet<>();

  private final String dbPath;

  public CustomerCsvService() {
    this("C:\\customers.csv");
  }

  public CustomerCsvService(String dbPath) {
    this.dbPath = dbPath;
  }

  @Override
  public Customer create(String data) throws CsvException {
    var customer = new Customer();
    customer.decode(data);

    var added = db.add(customer);
    if (!added) {
      throw new IllegalStateException("Another customer exists with same ID.");
    }

    return customer;
  }

  @Override
  public Customer detail(String id) {
    return db
        .stream()
        .filter(c -> c.getCustomerId().equalsIgnoreCase(id))
        .findFirst().get();
  }

  @Override
  public Customer update(String data) throws CsvException {
    var customer = new Customer();
    customer.decode(data);

    var removed = db.remove(customer);
    if (!removed) {
      throw new IllegalStateException("Customer does not exists with given ID.");
    }
    db.add(customer);

    return customer;
  }

  @Override
  public Customer delete(String id) {
    var data = detail(id);
    if (data != null) {
      db.remove(data);
    }
    return data;
  }

  @Override
  public String encode() {
    var rows = new StringBuilder();
    for (var customer : db) {
      var row = customer.encode();
      rows.append(row + "\n");
    }

    return rows.toString();
  }

  @Override
  public void decode(String data) throws CsvException {
    var rows = data.split("\n");
    db.clear();
    for (String row : rows) {
      create(row);
    }
  }
}

class AccountCsvService implements Service<Account>, Serializable {
  public static final String SAMPLE_DATA = "@Type=SA;ID=123456;NAME=Jatin;GENDER=Male;ADDRESS=1, Kartavya Path, NEW DELHI, 110001;PHONE=9876543210;EMAIL=jatin@example.com";

  private final Set<Account> db = new HashSet<>();

  private final String dbPath;

  public AccountCsvService() {
    this("C:\\accounts.csv");
  }

  public AccountCsvService(String dbPath) {
    this.dbPath = dbPath;
  }

  @Override
  public Account create(String data) throws CsvException {
    var account = Account.load(data);

    var added = db.add(account);
    if (!added) {
      throw new IllegalStateException("Another account exists with same ID.");
    }

    return account;
  }

  @Override
  public Account detail(String id) {
    return db
        .stream()
        .filter(c -> c.getAccountId().equalsIgnoreCase(id))
        .findFirst().get();
  }

  @Override
  public Account update(String data) throws CsvException {
    var account = Account.load(data);

    var removed = db.remove(account);
    if (!removed) {
      throw new IllegalStateException("Account does not exists with given ID.");
    }
    db.add(account);

    return account;
  }

  @Override
  public Account delete(String id) throws CsvException {
    var data = detail(id);
    if (data != null) {
      db.remove(data);
    }
    return data;
  }

  @Override
  public String encode() {
    var rows = new StringBuilder();
    for (var account : db) {
      var row = account.encode();
      rows.append(row + "\n");
    }

    return rows.toString();
  }

  @Override
  public void decode(String data) throws CsvException {
    var rows = data.split("\n");
    db.clear();
    for (String row : rows) {
      create(row);
    }
  }
}

// #endregion

// #region Model Classes

interface Serializable {
  String encode();

  void decode(String data) throws IOException;
}

class Branch implements Serializable {
  // #region Data Fields
  private String branchId;
  // #endregion

  // #region Navigational Fields
  private Set<Customer> customers;
  private Set<Account> accounts;
  // #endregion

  public String getBranchId() {
    return branchId;
  }

  public void setBranchId(String value) {
    branchId = value;
  }

  public Set<Customer> getCustomers() {
    return customers;
  }

  public void setCustomers(Set<Customer> value) {
    customers = value;
  }

  public Set<Account> getAccounts() {
    return accounts;
  }

  public void setAccounts(Set<Account> value) {
    accounts = value;
  }

  @Override
  public String encode() {
    // TODO(dev): Implement encode function.
    throw new UnsupportedOperationException();
  }

  @Override
  public void decode(String data) throws IOException {
    // TODO(dev): Implement decode function.
    throw new UnsupportedOperationException();
  }
}

class Customer implements Serializable {
  // #region Data Fields
  private String customerId;
  private String fullName;
  private Gender gender;
  private String address;
  private String phone;
  private String email;
  // #endregion

  // #region Navigational Fields
  private Set<Account> accounts;
  // #endregion

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String value) {
    customerId = value;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String value) {
    fullName = value;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender value) {
    gender = value;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String value) {
    address = value;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String value) {
    phone = value;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String value) {
    email = value;
  }

  public Set<Account> getAccounts() {
    return accounts;
  }

  public void setAccounts(Set<Account> value) {
    accounts = value;
  }

  public String encode() {
    // TODO(dev): Implement encode function.
    throw new UnsupportedOperationException();
  }

  public void decode(String data) throws CsvException {
    var map = Csv.decode(data);
    for (var entry : map.entrySet()) {
      if (entry.getKey().equalsIgnoreCase("NAME")) {
        setFullName(entry.getValue());
      }
      if (entry.getKey().equalsIgnoreCase("GENDER")) {
        setGender(Gender.valueOf(entry.getValue()));
      }
      if (entry.getKey().equalsIgnoreCase("ADDRESS")) {
        setAddress(entry.getValue());
      }
      if (entry.getKey().equalsIgnoreCase("PHONE")) {
        setPhone(entry.getValue());
      }
      if (entry.getKey().equalsIgnoreCase("EMAIL")) {
        setEmail(entry.getValue());
      }
    }
  }
}

abstract class Account implements Serializable {
  // #region Data Fields
  private String accountId;
  private double interestRate;
  // #endregion

  // #region Navigational Fields
  // #endregion

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String value) {
    accountId = value;
  }

  public double getInterestRate() {
    return interestRate;
  }

  public void setInterestRate(double value) {
    interestRate = value;
  }

  public static Account load(String data) {
    // TODO(dev): Implement load function.
    throw new UnsupportedOperationException();
  }
}

class SavingsAccount extends Account {
  // #region Data Fields
  // TODO(dev): Add data fields.
  // #endregion

  @Override
  public String encode() {
    // TODO(dev): Implement encode function.
    throw new UnsupportedOperationException();
  }

  @Override
  public void decode(String data) throws CsvException {
    // TODO(dev): Implement decode function.
    throw new UnsupportedOperationException();
  }
}

class DepositAccount extends Account {
  // #region Data Fields
  // TODO(dev): Add data fields.
  // #endregion

  @Override
  public String encode() {
    // TODO(dev): Implement encode function.
    throw new UnsupportedOperationException();
  }

  @Override
  public void decode(String data) throws CsvException {
    // TODO(dev): Implement decode function.
    throw new UnsupportedOperationException();
  }
}

class LoanAccount extends Account {
  // #region Data Fields
  // TODO(dev): Add data fields.
  // #endregion

  @Override
  public String encode() {
    // TODO(dev): Implement encode function.
    throw new UnsupportedOperationException();
  }

  @Override
  public void decode(String data) throws CsvException {
    // TODO(dev): Implement decode function.
    throw new UnsupportedOperationException();
  }
}

class CustomerAccount {
  // #region Data Fields
  private String customerId;
  private String accountId;
  // #endregion

  // #region Navigational Fields
  private Customer customer;
  private Account account;
  // #endregion

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String value) {
    customerId = value;
  }

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String value) {
    accountId = value;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer value) {
    customer = value;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account value) {
    account = value;
  }
}

enum Gender {
  MALE,
  FEMALE,
  INTERSEX
}

final class Csv {
  private Csv() {
  }

  public static String encode(Map<String, String> data) {
    var builder = new StringBuilder();

    for (var entry : data.entrySet()) {
      builder.append(entry.getKey().trim());
      builder.append("=");
      builder.append(entry.getValue().trim());
      builder.append(";");
    }

    return builder.toString();
  }

  public static Map<String, String> decode(String data) throws CsvException {
    var entries = data.split(";");
    var map = new HashMap<String, String>();

    for (var entry : entries) {
      var pairs = entry.split("=");
      if (pairs.length != 2) {
        throw new CsvException("Error occurred when parsing: " + entry);
      }

      var key = pairs[0].trim().toUpperCase();
      var value = pairs[1].trim();
      if (map.containsKey(key)) {
        throw new CsvException("Entry can exist only once: " + entry);
      }

      map.putIfAbsent(key, value);
    }
    return map;
  }
}

// #endregion

// #region Utility Classes

class CsvException extends IOException {
  CsvException() {
  }

  CsvException(String message) {
    super(message);
  }

  CsvException(String message, Throwable cause) {
    super(message, cause);
  }

  CsvException(Throwable cause) {
    super(cause);
  }
}

// #endregion
