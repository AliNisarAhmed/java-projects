package com.ali.javaprojects;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class SimpleInterest {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    NumberFormat formatter = new DecimalFormat("#.0");
    formatter.setMaximumFractionDigits(2);
    formatter.setMinimumFractionDigits(0);
    formatter.setRoundingMode(RoundingMode.HALF_UP);

    System.out.println("Enter the principal: ");
    double principal = Double.parseDouble(scanner.nextLine().trim());

    System.out.println("Enter the Interest rate %: ");
    double rate = Double.parseDouble(scanner.nextLine().trim());

    System.out.println("Enter the number of years: ");
    int years = Integer.parseInt(scanner.nextLine().trim());

    double total = principal * (1 + rate * years / 100);

    System.out.println(String.format(
        "After %s years at %s%%, the investment will be worth $%s",
        String.valueOf(years), formatter.format(rate),
        formatter.format(total)));

    scanner.close();
  }
}
