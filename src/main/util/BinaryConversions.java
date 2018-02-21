package main.util;


import main.util.DecimalConversions;

/**
 * Created by IntelliJ IDEA.
 * User: hshi
 * Date: 19/05/12
 * Time: 11:23 PM
 */
public class BinaryConversions {

  String tempString;

  public String binToDecimal(String bin){

    StringBuilder result = new StringBuilder();
    int dec = 0, increment = 0;
    tempString = sanitiseBin(bin);
    int tempLength = tempString.length();

    //Go through every 8 byte
    for (int i = 0; i < tempString.length(); i+=increment){

      if ((tempLength % 8 == 0) || tempLength > 8) {
        increment = 8;
        tempLength -= increment;
      }
      else {
        increment = tempLength;
      }

      String temp = tempString.substring(i, i+increment);
      dec = Integer.parseInt(temp, 2);
      result.append(dec + " ");
    }

    return result.toString();
  }

  public String binToHex(String bin){

    StringBuilder result = new StringBuilder();

    int increment = 0;
    tempString = sanitiseBin(bin);
    int tempLength = tempString.length();

    //Go through every 8 byte
    for (int i = 0; i < tempString.length(); i+=increment){

      if ((tempLength % 4 == 0) || tempLength > 4) {
        increment = 4;
        tempLength -= increment;
      }
      else {
        increment = tempLength;
      }

      String temp = tempString.substring(i, i+increment);
      String hex = Integer.toHexString(Integer.parseInt(temp, 2));

      result.append(hex);
    }

    if (result.length() % 2 == 1)
      result.insert(result.length() - 1, 0);

    int idx = result.length() - 2;
    while (idx > 0) {
      result.insert(idx, " ");
      idx -= 2;
    }

    return result.toString();
  }

  public String binToText(String bin){

    StringBuilder result = new StringBuilder();
    int increment = 0;
    tempString = sanitiseBin(bin);
    int tempLength = tempString.length();

    //Go through every 8 byte
    for (int i = 0; i < tempString.length(); i+=increment){

      if ((tempLength % 8 == 0) || tempLength > 8) {
        increment = 8;
        tempLength -= increment;
      }
      else {
        increment = tempLength;
      }

      String temp = tempString.substring(i, i+increment);
      result.append((char) Integer.parseInt(temp, 2));
    }

    return result.toString();
  }

  public String sanitiseBin(String input){
    String result = input.replaceAll("[^0-1]", "");
    return result;
  }
}
