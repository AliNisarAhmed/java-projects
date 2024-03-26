package com.ali.javaprojects;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class AreaOfRectangularRoom {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Rectangle rectangle = readUserInput(scanner);

    NumberFormat formatter = new DecimalFormat("0.#");
    formatter.setRoundingMode(RoundingMode.UP);
    formatter.setMinimumFractionDigits(0);
    formatter.setMaximumFractionDigits(3);

    System.out.println(
        String.format("You entered dimensions of %s feet by %s feet.",
            formatter.format(rectangle.getLength()),
            formatter.format(rectangle.getWidth())));

    System.out.println("The area is");

    System.out.println(
        String.format("%s square feet", formatter.format(rectangle.getArea())));
    System.out.println(
        String.format("%s square meters",
            formatter.format(rectangle.getAreaInSqMeters())));
    scanner.close();
  }

  private static Rectangle readUserInput(Scanner scanner) {
    System.out.println("What is the length of the room in feet? ");
    double length = Double.parseDouble(scanner.nextLine().trim());

    System.out.println("What is the width of the room in feet? ");
    double width = Double.parseDouble(scanner.nextLine().trim());

    return new Rectangle(length, width);
  }
}
