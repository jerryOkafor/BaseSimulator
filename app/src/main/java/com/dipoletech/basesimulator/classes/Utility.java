package com.dipoletech.basesimulator.classes;/**
 * Created by DABBY(3pleMinds) on 21-Oct-15.
 */

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * DABBY(3pleMinds) 21-Oct-15 1:34 PM 2015 10
 * 21 13 34 BaseSimulator
 **/
public class Utility {

    public static Integer getDecimalFromBinary(String s) {
        int strLen = s.length() - 1;
        int dec = 0;
        for (int i = strLen; i >= 0; i--) {
            dec += (Math.pow(2, i) * Integer.parseInt(String.valueOf(s.charAt(strLen - i))));
        }

        return dec;

    }

    public static String padUpZeros(String str) {
        int length = str.length();
        String retStr = "";
        switch (length) {
            case 1:
                retStr = "0000000" + str;
                break;
            case 2:
                retStr = "000000" + str;
                break;
            case 3:
                retStr = "00000" + str;
                break;
            case 4:
                retStr = "0000" + str;
                break;
            case 5:
                retStr = "000" + str;
                break;
            case 6:
                retStr = "00" + str;
                break;
            case 7:
                retStr = "0" + str;
                break;
            case 8:
                retStr = str;
                break;
            default:
                retStr = str;
                break;
        }
        return retStr;
    }

    public static String getBinaryStringFromImageView(List<ImageView> images) {
        //now get the array
        //recall that game start should be called when ever the small buttons are clicked
        String stringBitValue = "";
        int biValue;
        List<Integer> bitValues = new ArrayList<>();
        for (ImageView image : images) {
            String tag = (String) image.getTag();
            if (tag == "on") {
                biValue = 1;
                bitValues.add(biValue);
            } else {
                biValue = 0;
                bitValues.add(biValue);
            }

        }
        //revers all the integer
        for (int i = bitValues.size() - 1; i >= 0; i--) {
            stringBitValue += (bitValues.get(i));
        }

        //we are good to go
        return stringBitValue;
    }

    public static String addTwoBinaryStrings(String str1, String str2){
        List<Integer> firstOperandBits = new ArrayList<>();
        List<Integer> secondOperandBits = new ArrayList<>();

        int carry = 0;
        int counter = 0;
        String binaryOutput = "";

        //convert all the string tin Integers
        for (int count = str1.length() - 1; count >= 0; count--) {
            int bit = Integer.parseInt(String.valueOf(str1.charAt(count)));
            firstOperandBits.add(bit);
        }
        for (int count = str2.length() - 1; count >= 0; count--) {
            int bit = Integer.parseInt(String.valueOf(str2.charAt(count)));
            secondOperandBits.add(bit);
        }
        //do the calculations actually
        for (int i = 0; i<= firstOperandBits.size() - 1; i++)
        {
            int c = firstOperandBits.get(i)+ secondOperandBits.get(i)+carry;
            if (c == 0) //this implies 10
            {
                c = 0;
                carry = 0;
            } else if(c == 1) //this implies 10
            {
                c = 1;
                carry = 0;
            }else if(c == 2) //this implies 10
            {
                c = 0;
                carry = 1;
            }else if (c == 3) //this implies 11
            {    c = 1;
                carry = 1;
            }

            counter +=c;
            binaryOutput += String.valueOf(c);

        }
        return padUpZeros(reversebinaryString(binaryOutput));

    }

    public static String subtractTwoBinaryStrings(String str1, String str2) {
        List<Integer> firstOperandBits = new ArrayList<>(8);
        List<Integer> secondOperandBits = new ArrayList<>(8);


        int counter = 0;
        String binaryOutput = "";

        //convert all the string tin Integers
        for (int count = str1.length() - 1; count >= 0; count--) {
            int bit = Integer.parseInt(String.valueOf(str1.charAt(count)));
            firstOperandBits.add(bit);
        }
        for (int count = str2.length() - 1; count >= 0; count--) {
            int bit = Integer.parseInt(String.valueOf(str2.charAt(count)));
            secondOperandBits.add(bit);
        }
        //do the calculations actually
        for (int i =0; i <= firstOperandBits.size() - 1; i++) {
            int c = firstOperandBits.get(i) - secondOperandBits.get(i);

            counter += c;

            binaryOutput +=String.valueOf(c);
        }
        return padUpZeros(reversebinaryString(binaryOutput));

    }

    public static String multiplyBinaryStrings(String str1, String str2) {
        List<Integer> firstOperandBits = new ArrayList<>();
        List<Integer> secondOperandBits = new ArrayList<>();


        int counter = 0;
        String binaryOutput = "";

        //convert all the string to Integers
        for (int count = str1.length() - 1; count >= 0; count--) {
            int bit = Integer.parseInt(String.valueOf(str1.charAt(count)));
            firstOperandBits.add(bit);
        }
        for (int count = str2.length() - 1; count >= 0; count--) {
            int bit = Integer.parseInt(String.valueOf(str2.charAt(count)));
            secondOperandBits.add(bit);
        }
        //do the calculations actually
        for (int i = 0; i <= firstOperandBits.size() - 1 ; i++) {
            int c = firstOperandBits.get(i) * secondOperandBits.get(i);
            counter+=c;

            binaryOutput += String.valueOf(c);
        }

        return padUpZeros(reversebinaryString(binaryOutput));

    }

    public static String divideBinaryStrings(String str1, String str2) {
        //so much shall be done here to get a good algorithm
        List<Integer> firstOperandBits = new ArrayList<>(8);
        List<Integer> secondOperandBits = new ArrayList<>(8);

        int carry = 0;
        int counter = 0;

        //convert all the string to Integers
        for (int count = str1.length() - 1; count >= 0; count--) {
            int bit = Integer.parseInt(String.valueOf(str1.charAt(count)));
            firstOperandBits.add(bit);
        }
        for (int count = str2.length() - 1; count >= 0; count--) {
            int bit = Integer.parseInt(String.valueOf(str2.charAt(count)));
            secondOperandBits.add(bit);
        }

        return Integer.toBinaryString(getDecimalFromBinary(str1)/getDecimalFromBinary(str2));

    }


public static String reversebinaryString(String str)
{
    String reversedString  = "";
    for(int i = str.length()-1; i>=0; i--)
    {
        reversedString+=String.valueOf(str.charAt(i));
    }
    return  reversedString;
}

}
