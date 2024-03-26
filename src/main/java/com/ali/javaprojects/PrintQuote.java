package com.ali.javaprojects;

import java.util.Scanner;

public class PrintQuote {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("What is the quote?");
    String quote = scanner.nextLine().trim();
    if (quote.isBlank()) {
      System.out.println("Please enter a quote");
      scanner.close();
      return;
    }
    System.out.println("Who said it?");
    String author = scanner.nextLine().trim();
    if (author.isBlank()) {
      System.out.println("No author specified...");
    }

    System.out.println(String.format("%s says, \"%s\"", author, quote));

    scanner.close();
  }
}
