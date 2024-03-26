package com.ali.javaprojects;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class PaintCalculator {

  private final static double ONE_GALLON_PAINT_AREA = 350;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Length of ceiling? ");
    double length = scanner.nextDouble();

    System.out.println("Width of ceiling? ");
    double width = scanner.nextDouble();

    double area = length * width;

    double gallons = Math.ceil(area / ONE_GALLON_PAINT_AREA);

    NumberFormat formatter = new DecimalFormat("0.#");
    formatter.setRoundingMode(RoundingMode.UP);
    formatter.setMaximumFractionDigits(3);
    formatter.setMinimumFractionDigits(0);

    System.out.println(String.format("You will need to purchase %s gallons " +
        "of paint to cover %s square feet.",
        formatter.format(gallons),
        formatter.format(area)));

    scanner.close();
  }
}
