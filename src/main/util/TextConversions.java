package main.util;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: hshi
 * Date: 19/05/12
 * Time: 11:23 PM
 */
public class TextConversions {

  public String textToDecimal(String text){

    StringBuilder result = new StringBuilder();
    byte[] byteString = text.getBytes();
    for (byte b : byteString){
      int temp = Integer.parseInt(Integer.toHexString(b), 16);

      result.append(temp + " ");
    }

    return result.toString();
  }

  public String textToBinary(String text){

    StringBuilder result = new StringBuilder();
    byte[] byteString = text.getBytes();
    for (byte b : byteString){
      String temp = Integer.toBinaryString(b);
      if (temp.length() < 8){
        for (int j = (8 - temp.length()); j > 0; j--)
          temp = 0 + temp;
    }
      result.append(temp);
    }

    int idx = result.length() - 8;
    while (idx > 0) {
      result.insert(idx, " ");
      idx -= 8;
    }

    return result.toString();
  }

  public String textToHex(String text){

    StringBuilder result = new StringBuilder();
    byte[] byteString = text.getBytes();
    for (byte b : byteString){
      String temp = Integer.toHexString(b);

      result.append(temp + " ");
    }

    return result.toString();
  }
}
