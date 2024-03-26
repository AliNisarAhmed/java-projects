package com.ali.javaprojects;

public class Rectangle {
  private double length;
  private double width;

  private final double FACTOR = 0.09290304;

  public Rectangle(double length, double width) {
    // both in feet
    this.length = length;
    this.width = width;
  }

  public double getLength() {
    return length;
  }

  public void setLength(double length) {
    this.length = length;
  }

  public double getWidth() {
    return width;
  }

  public void setWidth(double width) {
    this.width = width;
  }

  public double getArea() {
    // area in square feet
    return length * width;
  }

  public double getAreaInSqMeters() {
    return FACTOR * length * width;
  }
}
