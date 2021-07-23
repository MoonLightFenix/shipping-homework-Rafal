package com.wixpress.homework;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PriceCalculator {
    public static final String OM = "OM";
    public static final String DH = "DH";
    public static final String LP = "LP";
    public static final String S = "S";
    public static final String M = "M";
    public static final String L = "L";
    //----------------OM provider prices
    public static final String OM_PRICE_S = "1";
    public static final String OM_PRICE_L = "7.20";
    //----------------DH provider prices
    public static final String DH_PRICE_S = "0.90";
    public static final String DH_PRICE_M = "3.40";
    //----------------LP provider prices
    public static final String LP_PRICE_S = "1.23";
    public static final String LP_PRICE_M = "3";
    public static final String LP_PRICE_L = "7";
    //----------------Discounts
    public static final String OM_DISCOUNT = "0";
    public static final String DH_DISCOUNT = "0";
    public static final String LP_DISCOUNT = "0.10";
    //----------------Discount limit per month
    public static final double MONTH_LIMIT = 10;

    public static final String ERROR = "ERROR";


    String[][] options = {
            {OM, S, OM_PRICE_S, OM_DISCOUNT},
            {OM, L, OM_PRICE_L, OM_DISCOUNT},
            {DH, S, DH_PRICE_S, DH_DISCOUNT},
            {DH, M, DH_PRICE_M, DH_DISCOUNT},
            {LP, S, LP_PRICE_S, LP_DISCOUNT},
            {LP, M, LP_PRICE_M, LP_DISCOUNT},
            {LP, L, LP_PRICE_L, LP_DISCOUNT}
    };

    DecimalFormat numberFormat = new DecimalFormat("0.00");
    int freeShipmentCountdown = 1;
    private String previousMonth = "00";
    private String month = "00";
    private String discounted = "0";

    public String getPrice(String transaction) {
        String shippingCompany = transaction.substring(13, 15);
        String size = transaction.substring(11, 12);
        String date = transaction.substring(0, 10);

        for (int i = 0, optionsLength = options.length; i < optionsLength; i++) {
            String[] option = options[i];
            if (option[0].equals(shippingCompany) && option[1].equals(size) && validateDateformat(date)) {  //Checking if the match of provider and size match as well as checking if the date format is correct
                setMonth(date.substring(5, 7));//setting up a current month
                if (checkForFreeProduct()) {   //Checking if the product can be received for free, if it's the 3rd purchase in the same month
                    if(Double.parseDouble(discounted)+Double.parseDouble(option[2])<MONTH_LIMIT){
                        transaction += " 0 " + option[2];
                        discountCounter(option[2]);
                    }
                    else{
                        transaction += " " +numberFormat.format(Double.parseDouble(option[2])-(MONTH_LIMIT - Double.parseDouble(discounted)))+" "+numberFormat.format(MONTH_LIMIT - Double.parseDouble(discounted));
                        discountCounter(numberFormat.format(MONTH_LIMIT - Double.parseDouble(discounted)));
                    } break;
                }
                if (size.equals(S) && !option[2].equals(findTheSmallestPrice())) {//Checking if it's the Small size  and if it's the cheapest
                    String smallPrice = findTheSmallestPrice();
                    String discount = numberFormat.format(Double.parseDouble(option[2]) - Double.parseDouble(smallPrice));
                    if(Double.parseDouble(discounted)+Double.parseDouble(discount)<MONTH_LIMIT){
                        transaction += " " + smallPrice + " " + discount;
                        discountCounter(discount);
                    }
                    else{
                        transaction += " " + numberFormat.format(Double.parseDouble(option[2]) - Double.parseDouble(discounted)+Double.parseDouble(discount) -MONTH_LIMIT) +" "+numberFormat.format(Double.parseDouble(discounted)+Double.parseDouble(discount) -MONTH_LIMIT);
                    } break;
                }
                if (shippingCompany.equals(LP)) {      //Checking if it's LP to give it 10% off
                    transaction += " " + priceDiscount(option[2], option[3]);
                    discountCounter(transaction.substring(transaction.length() - 3));
                    break;
                }
                transaction += " " + option[2]; //Last scenario, where no discounts can be given, sold for the full price
                break;
            }
            if (i == optionsLength - 1) {
                transaction += " " + ERROR;
            }

        }
        previousMonth = month; //before returning, marking the current month as previous month for future iterations
        return transaction;
    }


    private void discountCounter(String spent) {
        if (month.equals(previousMonth)) {
            discounted = numberFormat.format(Double.parseDouble(discounted) + Double.parseDouble(spent));
        } else {
            discounted = numberFormat.format(Double.parseDouble(spent));
        }
    }


    private String findTheSmallestPrice() {
        double a = Double.parseDouble(OM_PRICE_S);
        double b = Double.parseDouble(DH_PRICE_S);
        double c = Double.parseDouble(LP_PRICE_S);
        return String.valueOf(numberFormat.format(Math.min(Math.min(a, b), c)));
    }

    private boolean validateDateformat(String date) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        try {
            format.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    private String priceDiscount(String number, String discount) {
        double newPrice = Double.parseDouble(number) * (1 - Double.parseDouble(discount));
        double discountedAmount = Double.parseDouble(number) - newPrice;
        return numberFormat.format(newPrice) + " " + numberFormat.format(discountedAmount);
    }

    public void setMonth(String month) {
        this.month = month;
    }

    private boolean checkForFreeProduct() {
        boolean free = false;
        if (month.equals(previousMonth) && freeShipmentCountdown == 2) {
            free = true;
            freeShipmentCountdown = 1;
        } else if (month.equals(previousMonth)) {
            freeShipmentCountdown++;
        } else {
            freeShipmentCountdown = 1;
        }
        return free;
    }
}
