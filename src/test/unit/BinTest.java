package test.unit;

/**
 * Created by IntelliJ IDEA.
 * User: hshi
 * Date: 17/05/12
 * Time: 3:03 AM
 */
import main.util.BinaryConversions;

public class BinTest {
  public static void main(String[] args){

    testBinToDecimal();
    testBinToBinary();
    testBinToText();
  }

  private static void testBinToDecimal(){
    BinaryConversions converter = new BinaryConversions();

    System.out.println("========hexToDecimal==========");

    String test1 = converter.binToDecimal("01000001 01000010");
    assert (test1.equals("65 66")) : "Test 1 - Invalid binToDecimal conversion";
    String test2 = converter.binToDecimal("01000001 01000010 010");
    assert (test2.equals("65 66 2")) : "Test 2 - Invalid binToDecimal conversion";
    String test3 = converter.binToDecimal("01000001 AB01000010 C010657547");
    assert (test3.equals("65 66 2")) : "Test 3 - Invalid binToDecimal conversion";
  }

  private static void testBinToBinary(){
    BinaryConversions converter = new BinaryConversions();

    String test1 = converter.binToHex("01000001 01000010");
    assert (test1.equals("41 42")) : "Test 1 - Invalid binToDecimal conversion";
    String test2 = converter.binToHex("01000001 01000010 010");
    assert (test2.equals("41 42 2")) : "Test 2 - Invalid binToDecimal conversion";
    String test3 = converter.binToHex("01000001 AB01000010 C010657547");
    assert (test3.equals("41 42")) : "Test 3 - Invalid binToDecimal conversion";

    System.out.println("========hexToBinary==========");

  }

  private static void testBinToText(){
    BinaryConversions converter = new BinaryConversions();

    String test1 = converter.binToText("01000001 01000010");
    assert (test1.equals("AB")) : "Test 1 - Invalid binToDecimal conversion";
    String test2 = converter.binToText("01000001 01000010 010");
    assert (test2.equals("AB")) : "Test 2 - Invalid binToDecimal conversion";
    String test3 = converter.binToText("01000001 AB01000010 C010657547");
    assert (test3.equals("AB")) : "Test 3 - Invalid binToDecimal conversion";

    System.out.println("========hexToText==========");

    //Test 1 - HEX String

  }
}


