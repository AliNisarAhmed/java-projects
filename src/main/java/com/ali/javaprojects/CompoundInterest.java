package com.ali.javaprojects;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class CompoundInterest {

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

    System.out.println(
        "What is the number of times the interest is compounded per year? ");
    int times = Integer.parseInt(scanner.nextLine().trim());

    double total = principal * Math.pow(1 + rate / (100 * times), times * years);

    System.out.println(String.format(
        "$%s invested at %s%% for %s years componded %s "
            + "times per year is $%s",
        formatter.format(principal), formatter.format(rate),
        String.valueOf(years), String.valueOf(times), formatter.format(total)));

    scanner.close();
  }
}
