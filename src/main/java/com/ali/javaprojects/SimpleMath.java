package com.ali.javaprojects;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class SimpleMath {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("What is the first number? ");
    String firstNumberStr = scanner.nextLine().trim();
    BigDecimal n1;

    try {
      n1 = new BigDecimal(firstNumberStr);
    } catch (NumberFormatException e) {
      System.out.println("Please enter a number");
      scanner.close();
      return;
    }

    System.out.print("What is the second number? ");
    String secondNumberStr = scanner.nextLine().trim();

    BigDecimal n2;
    try {
      n2 = new BigDecimal(secondNumberStr);
    } catch (NumberFormatException e) {
      System.out.println("Please enter a number");
      scanner.close();
      return;
    }

    BigDecimal sum = new BigDecimal(n1.doubleValue() + n2.doubleValue());
    BigDecimal subtraction = new BigDecimal(n1.doubleValue() - n2.doubleValue());
    BigDecimal product = new BigDecimal(n1.doubleValue() * n2.doubleValue());
    BigDecimal division = new BigDecimal(n1.doubleValue() / n2.doubleValue());

    System.out.println(String.format("%s + %s = %s", firstNumberStr,
        secondNumberStr,
        sum.setScale(2, RoundingMode.HALF_UP)
            .stripTrailingZeros()
            .toPlainString()));

    System.out.println(
        String.format("%s - %s = %s", firstNumberStr, secondNumberStr,
            subtraction.setScale(2, RoundingMode.HALF_UP)
                .stripTrailingZeros()
                .toPlainString()));

    System.out.println(String.format("%s * %s = %s", firstNumberStr,
        secondNumberStr,
        product.setScale(2, RoundingMode.HALF_UP)
            .stripTrailingZeros()
            .toPlainString()));

    System.out.println(String.format("%s / %s = %s", firstNumberStr,
        secondNumberStr,
        division.setScale(2, RoundingMode.HALF_UP)
            .stripTrailingZeros()
            .toPlainString()));

    scanner.close();
  }
}
