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

  private static LineItem getLineItemFromUser(Scanner scanner, int index) {
    System.out.printf("Enter the price of item %d: ", index);
    double price = scanner.nextDouble();

    System.out.printf("Enter the quantity of item %d: ", index);
    double quantity = scanner.nextDouble();

    return new LineItem(quantity, price);
  }

  private static List<LineItem> getLineItemsFromUser(Scanner scanner) {
    List<LineItem> items = new ArrayList<>();
    int index = 1;

    do {
      LineItem item = getLineItemFromUser(scanner, index);
      items.add(item);
      index++;
    } while (scanner.hasNextDouble());

    return items;
  }
}
