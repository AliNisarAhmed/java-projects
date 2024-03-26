package com.ali.javaprojects;

import java.util.Scanner;

public class PizzaParty {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("How many people?");
    int people = Integer.parseInt(scanner.nextLine().trim());

    System.out.println("How many pizzas do you have?");
    int pizzas = Integer.parseInt(scanner.nextLine().trim());

    int totalSlices = pizzas * 8;
    int slicesPerPerson = totalSlices / people;
    int leftover = totalSlices % people;

    System.out.println(
        String.format("%s people with %s pizza%s", String.valueOf(people),
            String.valueOf(pizzas), pizzas > 1 ? "s" : ""));
    System.out.println(String.format("Each person gets %s piece%s of pizza.",
        String.valueOf(slicesPerPerson),
        slicesPerPerson > 1 ? "s" : ""));
    System.out.println(String.format("There are %s leftover pieces",
        String.valueOf(leftover)));

    scanner.close();
  }
}
