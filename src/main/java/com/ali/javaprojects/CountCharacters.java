package com.ali.javaprojects;

import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CountCharacters extends Application {

  public static void main(String[] args) {
    launch();
  }

  @Override
  public void start(Stage stage) throws Exception {

    Label l = new Label("Hello, JavaFX");
    Scene scene = new Scene(new StackPane(l), 640, 480);
    stage.setScene(scene);
    stage.show();

    // Scanner scanner = new Scanner(System.in);
    // System.out.print("What is the input string? ");
    // String input = scanner.nextLine();
    // if (input.isBlank()) {
    // System.out.println("Please enter something ffs");
    // } else {
    // input = input.trim();
    // System.out.println(
    // String.format("%s has %s characters.", input, input.length()));
    // }
    // scanner.close();
  }
}
