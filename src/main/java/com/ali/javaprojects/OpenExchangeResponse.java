package com.ali.javaprojects;

import java.util.HashMap;
import java.util.Map;

public class OpenExchangeResponse {
  private Map<String, String> rates = new HashMap<>();
  private double timestamp;
  private String base;

  public Map<String, String> getRates() {
    return rates;
  }

  public void setRates(Map<String, String> rates) {
    this.rates = rates;
  }

  public double getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(double timestamp) {
    this.timestamp = timestamp;
  }

  public String getBase() {
    return base;
  }

  public void setBase(String base) {
    this.base = base;
  }
}
