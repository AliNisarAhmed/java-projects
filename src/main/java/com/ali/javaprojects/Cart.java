package com.ali.javaprojects;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class Cart {

  private final double TAX_RATE = 0.055;

  private double subTotal;
  private double tax;
  private double total;
  private final NumberFormat formatter;

  public Cart(List<LineItem> lineItems) {
    double subTotal = lineItems.stream().mapToDouble(li -> li.totalPrice()).sum();
    double tax = subTotal * TAX_RATE;
    double total = subTotal + tax;

    this.subTotal = subTotal;
    this.tax = tax;
    this.total = total;

    NumberFormat numberFormat = new DecimalFormat("0.#");
    numberFormat.setMinimumFractionDigits(2);
    numberFormat.setMaximumFractionDigits(2);
    numberFormat.setRoundingMode(RoundingMode.UP);
    this.formatter = numberFormat;
  }

  public double getSubTotal() {
    return subTotal;
  }

  public void setSubTotal(double subTotal) {
    this.subTotal = subTotal;
  }

  public double getTax() {
    return tax;
  }

  public void setTax(double tax) {
    this.tax = tax;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  public void print() {
    System.out.println(
        String.format("Subtotal: $%s", formatter.format(subTotal)));
    System.out.println(String.format("Tax: $%s", formatter.format(tax)));
    System.out.println(String.format("Total: $%s", formatter.format(total)));
  }
}
