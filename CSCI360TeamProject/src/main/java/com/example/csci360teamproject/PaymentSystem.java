package com.example.csci360teamproject;

import java.time.LocalDate;

public class PaymentSystem {
    public static boolean checkPayment(PaymentInfo paymentInfo) {
        long cnumber;
        try {
            cnumber = Long.parseLong(paymentInfo.getCardNum());
        }
        catch (NumberFormatException e) {
            return false;
        }
        boolean cardRegexTest = paymentInfo.cardNum.matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d");
        if(!cardRegexTest) {
            return false;
        }
        boolean cardStuff = (thesize(cnumber) >= 13 && thesize(cnumber) <= 16) && (prefixmatch(cnumber, 4)
                || prefixmatch(cnumber, 5) || prefixmatch(cnumber, 37) || prefixmatch(cnumber, 6))
                && ((sumdoubleeven(cnumber) + sumodd(cnumber)) % 10 == 0);
        if(!cardStuff) {
            return false;
        }
        boolean cvv = paymentInfo.getCvv().matches("\\d\\d\\d");
        if(!cvv) {
            return false;
        }
        boolean dateRegex = paymentInfo.expDate.matches("(1|2|3|4|5|6|7|8|9|10|11|12)\\/\\d\\d");
        if(!dateRegex) {
            return false;
        }
        LocalDate now = LocalDate.now();
        String[] dateSplit = paymentInfo.expDate.split("/");
        boolean futureDateCheck = now.getYear() % 2000 <= Integer.parseInt(dateSplit[1]);
        if(now.getYear() % 2000 == Integer.parseInt(dateSplit[1])) {
            futureDateCheck = futureDateCheck && now.getMonthValue() <= Integer.parseInt(dateSplit[0]);
        }
        if(!futureDateCheck) {
            return false;
        }
        return true;
    }
    // Get the result from Step 2
    public static int sumdoubleeven(long cnumber) {
        int sum = 0;
        String num = cnumber + "";
        for (int i = thesize(cnumber) - 2; i >= 0; i -= 2)
            sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);
        return sum;
    }
    // Return this cnumber if it is a single digit, otherwise,
    // return the sum of the two digits
    public static int getDigit(int cnumber) {
        if (cnumber < 9)
            return cnumber;
        return cnumber / 10 + cnumber % 10;
    }
    // Return sum of odd-place digits in cnumber
    public static int sumodd(long cnumber) {
        int sum = 0;
        String num = cnumber + "";
        for (int i = thesize(cnumber) - 1; i >= 0; i -= 2)
            sum += Integer.parseInt(num.charAt(i) + "");
        return sum;
    }
    // Return true if the digit d is a prefix for cnumber
    public static boolean prefixmatch(long cnumber, int d) {
        return getprefx(cnumber, thesize(d)) == d;
    }
    // Return the number of digits in d
    public static int thesize(long d) {
        String num = d + "";
        return num.length();
    }
    // Return the first k number of digits from
    // number. If the number of digits in number
    // is less than k, return number.
    public static long getprefx(long cnumber, int k) {
        if (thesize(cnumber) > k) {
            String num = cnumber + "";
            return Long.parseLong(num.substring(0, k));
        }
        return cnumber;
    }
    }

