package com.codegym.model.service;

import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl implements CalculateService {

    @Override
    public String save(double numberFirst, double numberSecond, String operator) {
        double result = 0;
        String print = "";

        if (operator.equals("+")) {
            result = numberFirst + numberSecond;
        } else if (operator.equals("-")) {
            result = numberFirst - numberSecond;
        } else if (operator.equals("*")) {
            result = numberFirst * numberSecond;
        } else {
            if (numberSecond == 0) {
                print = "Khong the chia cho 0";
                return print;
            }
            result = numberFirst / numberSecond;
        }
        print = String.valueOf(result);
        return print;
    }
}
