package com.sda.springbootexample;

import com.sda.springbootexample.components.AtmService;
import com.sda.springbootexample.exceptions.UnknownRateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicMarkableReference;

@SpringBootApplication
public class SpringBootExampleApplication implements CommandLineRunner {
  @Autowired private AtmService atmService;

  public static void main(String[] args) throws UnknownRateException {
    SpringApplication.run(SpringBootExampleApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    if (args.length < 2) {
      System.out.println("Please provide coinType and amount: ");
      return;
    }
    try {
      double amount = Double.valueOf(args[1]);
      String coinType = args[0];
      System.out.println("You provided following arguments: " + Arrays.toString(args));

      double exchangeAmount = atmService.exchangeCoin(coinType,amount);
      System.out.println("Amount of $ you need to pay: " + amount + " " + coinType + " " + exchangeAmount);
    } catch (UnknownRateException e) {
      System.out.println(e.getMessage());
    }
  }
}
