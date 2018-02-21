package test.unit;

/**
 * Created by IntelliJ IDEA.
 * User: hshi
 * Date: 17/05/12
 * Time: 3:03 AM
 */
import main.util.DecimalConversions;

public class DecTest {

  static DecimalConversions converter = new DecimalConversions();

  public static void main(String[] args){

    testDecToText();
    testDecToHex();
    testDecToBinary();
  }

  private static void testDecToText(){

    //Test 1 - HEX String
    String test1 = converter.decToText("34 62 54 85 56");
    //assert (test1.equals("1 2 3 171 205 160 13 ")) : "Test 1 - Invalid hexToDecimal conversion";
  }

  private static void testDecToHex(){
    String test1 = converter.decToHex("34 62 54 85 56");

  }

  private static void testDecToBinary(){

    String test1 = converter.decToBinary("34 62 54 85 56");

  }
}


