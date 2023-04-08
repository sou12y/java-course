package core0.algorithms;

public final class DateTime {
  private DateTime() {
  }

  public static boolean isLeapYear(int year) {
    return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
  }

  public static Time addSeconds(Time time, int secondsToAdd) {
    if (secondsToAdd == 0) {
      return time;
    }

    int seconds = time.hours * 3600 + time.minutes * 60 + time.seconds + secondsToAdd;

    int hours = seconds / 3600;
    seconds %= 3600;

    int minutes = seconds / 60;
    seconds %= 60;

    return new Time(hours, minutes, seconds);
  }

  public record Date(int years, int months, int days) {
  }

  public record Time(int hours, int minutes, int seconds) {
  }
}
