package com.ali.javaprojects;

import java.util.Scanner;

public class MadLib {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a noun: ");
    String noun = scanner.nextLine().trim();

    System.out.print("Enter a verb: ");
    String verb = scanner.nextLine().trim();

    System.out.print("Enter a adjective: ");
    String adjective = scanner.nextLine().trim();

    System.out.print("Enter a adverb: ");
    String adverb = scanner.nextLine().trim();

    System.out.println(
        String.format("Do you %s your %s %s %s? That's hilarious!", verb,
            adjective, noun, adverb));

    scanner.close();
  }
}
