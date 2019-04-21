package com.sda.springbootexample.components;

import com.sda.springbootexample.exceptions.UnknownRateException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CryptoData {
    private Map<String, Double> cryptoMap=new HashMap(){{
       put("bitcoin", 5286.26);
       put("ethereum", 169.23);
       put("xrp", 0.320977);
       }
    };

    /**
     * Get the rate from internal map.
     * @param coinType
     * @return
     * @throws UnknownRateException
     */

    public double getRate(String coinType) throws UnknownRateException {
        Double rate= cryptoMap.get(coinType);
        if(rate==null){
            throw new UnknownRateException(cryptoMap.keySet());
        }
        return rate;
    }
}
