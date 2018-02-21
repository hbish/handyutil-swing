package test.unit;

/**
 * Created by IntelliJ IDEA.
 * User: hshi
 * Date: 17/05/12
 * Time: 3:03 AM
 */
import main.util.HexConversions;

public class HexTest {
  public static void main(String[] args){

    testHexToDecimal();
    testHexToBinary();
    testHexToText();
  }

  private static void testHexToDecimal(){
    HexConversions converter = new HexConversions();

    System.out.println("========hexToDecimal==========");

    //Test 1 - HEX String
    String test1 = converter.hexToDecimal("010203ABCDA00D");
    assert (test1.equals("1 2 3 171 205 160 13 ")) : "Test 1 - Invalid hexToDecimal conversion";
    //Test 2 - HEX String with 0x prepending
    String test2 = converter.hexToDecimal("0x010203ABCDA00D");
    assert (test2.equals("1 2 3 171 205 160 13 ")) : "Test 2 - Invalid hexToDecimal conversion";
    //Test 3 - HEX String with spaces
    String test3 = converter.hexToDecimal("01 02 03 AB CD A0 0D");
    assert (test3.equals("1 2 3 171 205 160 13 ")) : "Test 3 - Invalid hexToDecimal conversion";
    //Test 4 - HEX String with spaces and 0x prepended
    String test4 = converter.hexToDecimal("0x01 02 03 AB CD A0 0D");
    assert (test4.equals("1 2 3 171 205 160 13 ")) : "Test 4 - Invalid hexToDecimal conversion";
    //Test 5 - HEX String with invalid character
    String test5 = converter.hexToDecimal("0123-#3456");
    assert (test5.equals("1 35 (-#) 52 86 ")) : "Test 5 - Invalid hexToDecimal conversion";
    //Test 6 - HEX String with invalid character, 0x prepend and spaces
    String test6 = converter.hexToDecimal("0x01 23 -# 34 56");
    assert (test6.equals("1 35 (-#) 52 86 ")) : "Test 6 - Invalid hexToDecimal conversion";
    //Test 7 - HEX String with invalid character, 0x prepend, spaces and a single hex
    //String test7 = converter.hexToDecimal("0x01 23 -# 34 56 A");
    //assert (test7.equals("00000001 00100011 (-#) 00110100 01010110 00001010 ")) : "Test 7 - Invalid hexToBinary conversion";
  }

  private static void testHexToBinary(){
    HexConversions converter = new HexConversions();

    System.out.println("========hexToBinary==========");

    //Test 1 - HEX String
    String test1 = converter.hexToBinary("010203ABCDA00D");
    assert (test1.equals("00000001 00000010 00000011 10101011 11001101 10100000 00001101 ")) : "Test 1 - Invalid hexToBinary conversion";
    //Test 2 - HEX String with 0x prepending
    String test2 = converter.hexToBinary("0x010203ABCDA00D");
    assert (test2.equals("00000001 00000010 00000011 10101011 11001101 10100000 00001101 ")) : "Test 2 - Invalid hexToBinary conversion";
    //Test 3 - HEX String with spaces
    String test3 = converter.hexToBinary("01 02 03 AB CD A0 0D");
    assert (test3.equals("00000001 00000010 00000011 10101011 11001101 10100000 00001101 ")) : "Test 3 - Invalid hexToBinary conversion";
    //Test 4 - HEX String with spaces and 0x prepended
    String test4 = converter.hexToBinary("0x01 02 03 AB CD A0 0D");
    assert (test4.equals("00000001 00000010 00000011 10101011 11001101 10100000 00001101 ")) : "Test 4 - Invalid hexToBinary conversion";
    //Test 5 - HEX String with invalid character
    String test5 = converter.hexToBinary("0123-#3456");
    assert (test5.equals("00000001 00100011 (-#) 00110100 01010110 ")) : "Test 5 - Invalid hexToBinary conversion";
    //Test 6 - HEX String with invalid character, 0x prepend and spaces
    String test6 = converter.hexToBinary("0x01 23 -# 34 56");
    assert (test6.equals("00000001 00100011 (-#) 00110100 01010110 ")) : "Test 6 - Invalid hexToBinary conversion";
    //Test 7 - HEX String with invalid character, 0x prepend, spaces and a single hex
    String test7 = converter.hexToBinary("0x01 23 -# 34 56 A");
    assert (test7.equals("00000001 00100011 (-#) 00110100 01010110 00001010 ")) : "Test 7 - Invalid hexToBinary conversion";
  }

  private static void testHexToText(){
    HexConversions converter = new HexConversions();

    System.out.println("========hexToText==========");

    //Test 1 - HEX String
    String test1 = converter.hexToText("546869732069732061207465737421");
    assert (test1.equals("This is a test!")) : "Test 1 - Invalid conversion";
    //Test 2 - HEX String with 0x prepending
    String test2 = converter.hexToText("0x546869732069732061207465737421");
    assert (test2.equals("This is a test!")) : "Test 2 - Invalid conversion";
    //Test 3 - HEX String with spaces
    String test3 = converter.hexToText("54 68 69 73 20 69 73 20 61 20 74 65 73 74 21");
    assert (test3.equals("This is a test!")) : "Test 3 - Invalid conversion";
    //Test 4 - HEX String with spaces and 0x prepended
    String test4 = converter.hexToText("0x54 68 69 73 20 69 73 20 61 20 74 65 73 74 21");
    assert (test4.equals("This is a test!")) : "Test 4 - Invalid conversion";
    //Test 5 - HEX String with invalid character
    String test5 = converter.hexToText("54686973206973*&2061207465%%%%737421");
    assert (test5.equals("This is(*&) a te(%%)(%%)st!")) : "Test 5 - Invalid hexToDecimal conversion";
    //Test 6 - HEX String with invalid character, 0x prepend and spaces
    String test6 = converter.hexToText("0x54 68 69 73 20 69 73 *& 20 61 20 74 65 %% %% 73 74 21");
    assert (test6.equals("This is(*&) a te(%%)(%%)st!")) : "Test 6 - Invalid hexToDecimal conversion";
    //Test 7 - HEX String with invalid character, 0x prepend, spaces and a single hex
    String test7 = converter.hexToText("0x54 68 69 73 20 69 73 *& 20 61 20 74 65 %% %% 73 74 21 A");
    assert (test7.equals("This is(*&) a te(%%)(%%)st!")) : "Test 7 - Invalid hexToBinary conversion";
  }
}


