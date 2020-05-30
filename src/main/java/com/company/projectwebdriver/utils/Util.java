package com.company.projectwebdriver.utils;

import java.util.Random;

public class Util {

    public static String generateRandomNumber(){

        Integer randomNumber = (new Random()).nextInt(900000) + 100000;
        return "" +randomNumber;
    }
}
