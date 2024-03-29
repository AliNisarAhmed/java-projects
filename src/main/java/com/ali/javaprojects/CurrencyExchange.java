package com.ali.javaprojects;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.RoundingMode;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

// NOTE: provide API key when invoking main as APP_ID env var

public class CurrencyExchange {

  private static final String APP_ID_KEY = "app_id";
  private static final String BASE_URL = "https://openexchangerates.org/api/latest.json";

  public static void main(String[] args) throws Exception {

    Scanner scanner = new Scanner(System.in);
    UserInput userInput = UserInput.getUserInput(scanner);
    OpenExchangeResponse rates = getRates(userInput.getFrom());
    double rate = Double.parseDouble(rates.getRates().get(userInput.getTo()));
    double result = userInput.getAmount() * rate;
    printResult(userInput, rate, result);

    scanner.close();
  }

  private static void printResult(UserInput userInput, double rate,
      double result) {
    NumberFormat formatter = new DecimalFormat("#.0");
    formatter.setRoundingMode(RoundingMode.UP);
    formatter.setMaximumFractionDigits(5);
    formatter.setMinimumFractionDigits(0);

    System.out.println(String.format(
        "%s %s at an exchange rate of %s is %s %s",
        formatter.format(userInput.getAmount()), userInput.getFrom(),
        formatter.format(rate), formatter.format(result), userInput.getTo()));
  }

  private static OpenExchangeResponse getRates(String base) throws Exception {
    String API_ID_VALUE = System.getenv("API_ID");

    HttpRequest request = HttpRequest.newBuilder()
        .uri(new URI(String.format("%s?%s=%s&base=%s", BASE_URL, APP_ID_KEY,
            API_ID_VALUE, base)))
        .headers("accept", "application/json")
        .GET()
        .build();

    HttpClient client = HttpClient.newBuilder().build();

    HttpResponse<String> httpResponse = client.send(request, BodyHandlers.ofString());

    if (httpResponse.statusCode() != 200) {
      throw new Exception("API error");
    }

    ObjectMapper mapper = new ObjectMapper().configure(
        DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    OpenExchangeResponse response = mapper.readValue(httpResponse.body(), OpenExchangeResponse.class);
    return response;
  }

  private static class UserInput {
    private String from;
    private String to;
    private double amount;

    public static UserInput getUserInput(Scanner scanner) {
      System.out.println("Enter currency exchanging from: ");
      String from = scanner.nextLine().trim();

      System.out.println("Enter amount: ");
      double amount = Double.parseDouble(scanner.nextLine().trim());

      System.out.println("Enter currency exchanging to: ");
      String to = scanner.nextLine().trim();

      return new UserInput(from, to, amount);
    }

    public UserInput(String from, String to, double amount) {
      this.from = from;
      this.to = to;
      this.amount = amount;
    }

    public String getFrom() {
      return from;
    }

    public String getTo() {
      return to;
    }

    public double getAmount() {
      return amount;
    }
  }
}
