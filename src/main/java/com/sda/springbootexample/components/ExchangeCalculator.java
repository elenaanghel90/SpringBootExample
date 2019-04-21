package com.sda.springbootexample.components;

import com.sda.springbootexample.exceptions.UnknownRateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ExchangeCalculator {
  @Autowired private CryptoData cryptoData;

  public double getUsdAmount(String coinType, double amount) throws UnknownRateException {
    double rate = cryptoData.getRate(coinType);
    return rate * amount;
  }
}
