package com.sda.springbootexample.components;

import com.sda.springbootexample.exceptions.UnknownRateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtmService {

    @Autowired
            private ExchangeCalculator exchangeCalculator;
  double atmFee = 1.1;

    /**
     *
     * @param coinType
     * @param amount
     * @return
     * @throws UnknownRateException
     */
  public double exchangeCoin(String coinType, double amount) throws UnknownRateException {
    double baseAmount = exchangeCalculator.getUsdAmount(coinType, amount);
    return baseAmount*atmFee;
  }


}
