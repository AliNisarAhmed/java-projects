package com.ali.javaprojects;

import java.time.LocalDateTime;
import java.util.Scanner;

public class RetirementAge {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("What is your current age? ");
    String ageStr = scanner.nextLine().trim();

    int age;
    int retirementAge;

    try {
      age = Integer.parseInt(ageStr);
    } catch (NumberFormatException e) {
      System.out.println("Please enter an integer");
      scanner.close();
      return;
    }

    System.out.print("At what age would you like to retire? ");
    String retirementAgeStr = scanner.nextLine().trim();

    try {
      retirementAge = Integer.parseInt(retirementAgeStr);
    } catch (NumberFormatException e) {
      System.out.println("Please enter an integer");
      scanner.close();
      return;
    }

    LocalDateTime dateTime = LocalDateTime.now();
    int currentYear = dateTime.getYear();

    int retirementYear = currentYear + retirementAge - age;

    if (retirementYear <= currentYear) {
      System.out.println("You can retire right now!!!");
      scanner.close();
      return;
    }

    System.out.println(String.format(
        "You have %d years left until you can retire.", retirementAge - age));

    System.out.println(String.format("It's %d, so you can retire in %d",
        currentYear, retirementYear));
  }
}
