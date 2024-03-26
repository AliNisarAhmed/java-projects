package com.ali.javaprojects;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AreaOfRectangularRoomGUI extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Group root = new Group();
    Scene scene = new Scene(root, 600, 600, Color.LIGHTSKYBLUE);

    Text text = new Text();
    text.setText("WHOAA");
    text.setX(50);
    text.setY(50);
    text.setFont(Font.font("Verdana", 50));
    text.setFill(Color.LIMEGREEN);

    root.getChildren().add(text);

    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
