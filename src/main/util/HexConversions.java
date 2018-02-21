package main.util;

import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: hshi
 * Date: 17/05/12
 * Time: 2:41 AM
 */
public class HexConversions {

  private static String HEX_STRING = "0123456789ABCDEF";
  String tempHexValue;

  public String hexToDecimal(String hex) {
    StringBuilder result = new StringBuilder();
    tempHexValue = sanitiseHex(hex);

    //Go through every 2 byte
    for (int i = 0; i < tempHexValue.length(); i = i+2) {
      String temp = tempHexValue.substring(i, i+2);
      if (!temp.equals("0X")) {
        try {
          result.append(String.valueOf(Integer.parseInt(temp, 16))).append(" ");
        } catch (NumberFormatException e) {
          result.append("(").append(temp).append(")").append(" ");
        }
      }
    }

    return result.toString();
  }

  public String hexToBinary(String hex) {

    int intValue, intValue2;
    StringBuilder stringValue = new StringBuilder();
    StringBuilder result = new StringBuilder();
    String temp;

    tempHexValue = sanitiseHex(hex);

    //Go through every 2 byte
    for (int i = 0; i < tempHexValue.length(); i+=2)
    {
      if (i + 2 > tempHexValue.length()){
        temp = tempHexValue.substring(i);
        temp = "0" + temp;
      }
      else {
        temp = tempHexValue.substring(i, i+2);
      }

      if (!temp.equals("0X") && isHex(temp)) {
        stringValue.delete(0,4);
        // First bit
        intValue = HEX_STRING.indexOf(temp.charAt(0));
        stringValue.append(Integer.toBinaryString(intValue));
        if (stringValue.length() < 4) {
          for (int j = (4 - stringValue.length()); j > 0; j--)
          {
            stringValue.insert(0, "0");
          }
        }
        result.append(stringValue);

        stringValue.delete(0,4);

        // Second bit
        intValue2 = HEX_STRING.indexOf(temp.charAt(1));
        stringValue.append(Integer.toBinaryString(intValue2));
        if (stringValue.length() < 4) {
          for (int j = (4 - stringValue.length()); j > 0; j--)
            stringValue.insert(0, "0");
        }
        result.append(stringValue + " ");
      }
      else if (temp.equals("0X")) {}
      else {
        result.append("(").append(temp).append(")").append(" ");
      }
    }

    return result.toString();
  }

  public String hexToText(String hex) {

    StringBuilder result = new StringBuilder();
    hex = sanitiseHex(hex);
    String temp;

    for (int i = 0; i < (hex.length()-1); i+=2) {
      if (i + 2 > hex.length()){
        temp = hex.substring(i);
        temp = "0" + temp;
      }
      else {
        temp = hex.substring(i, i+2);
      }

      if (isHex(temp)) {
        int dec = Integer.parseInt(hexToDecimal(temp).replace(" ", ""));
        result.append((char)dec);
      }
      else if (temp.equals("0X")) {}
      else
        result.append("(").append(temp).append(")");
    }

    return result.toString();
  }

  public boolean isHex(String input){
    boolean result = input.matches("[0-9a-fA-F]{2}");
    return result;
  }

  public String sanitiseHex(String input){
    String result = input.toUpperCase().replaceAll(" ", "");
    return result;
  }
}