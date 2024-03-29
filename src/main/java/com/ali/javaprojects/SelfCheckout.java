package com.ali.javaprojects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelfCheckout {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    List<LineItem> items = getLineItemsFromUser(scanner);

    Cart cart = new Cart(items);

    cart.print();

    scanner.close();
  }

  private static List<LineItem> getLineItemsFromUser(Scanner scanner) {
    List<LineItem> items = new ArrayList<>();
    int index = 1;
    String nextLine = null;

    do {
      System.out.printf(
          "Enter the price of item %d: (Press n to stop entering lineItems): ",
          index);
      nextLine = scanner.nextLine().trim();
      if ("n".equals(nextLine)) {
        break;
      }
      double price = Double.parseDouble(nextLine);

      System.out.printf(
          "Enter the quantity of item %d: (Press n to stop entering lineItems): ",
          index);
      nextLine = scanner.nextLine().trim();
      if ("n".equals(nextLine)) {
        break;
      }

      double quantity = Double.parseDouble(nextLine);

      items.add(new LineItem(quantity, price));
      index++;
    } while (true);

    return items;
  }
}
