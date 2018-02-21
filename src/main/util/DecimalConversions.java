package main.util;

import java.math.BigInteger;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: hshi
 * Date: 19/05/12
 * Time: 11:24 PM
 */
public class DecimalConversions {

  public String decToText(String dec){

    StringBuilder result = new StringBuilder();
    String[] tempDec = dec.split(" ");

    for (int i = 0; i < tempDec.length; i++){
      BigInteger split = new BigInteger(tempDec[i]);
      result.append(String.valueOf((char) split.intValue()));
    }

    return result.toString();
  }

  public String decToBinary(String dec){
    StringBuilder result = new StringBuilder();
    String[] tempDec = dec.split(" ");

    for (int i = 0; i < tempDec.length; i++){
      BigInteger split = new BigInteger(tempDec[i]);
      StringBuilder splitEdit = new StringBuilder(Integer.toBinaryString(split.intValue()));
      if (splitEdit.length() < 8) {
        for (int j = (8 - splitEdit.length()); j > 0; j--)
        {
          splitEdit.insert(0, "0");
        }
      }
      result.append(splitEdit + " ");
    }

    return result.toString();
  }

  public String decToHex(String dec){
    StringBuilder result = new StringBuilder();
    String[] tempDec = dec.split(" ");

    for (int i = 0; i < tempDec.length; i++){
      BigInteger split = new BigInteger(tempDec[i]);
      result.append(Integer.toHexString(split.intValue()) + " ");
    }

    return result.toString();
  }

  public boolean isDec(String input){
    boolean result = input.matches("[0-9]{2,3}");
    return result;
  }

  public String sanitiseDec(String input){
    String result = input.toUpperCase().replaceAll(" ", "");
    return result;
  }
}
