package main.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import main.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: hshi
 * Date: 19/05/12
 * Time: 2:26 AM
 */
public class MainForm {
  private JTabbedPane tabbedPane1;
  private JPanel panel1;
  private JButton convertDecimalButton;
  private JButton convertHexButton;
  private JButton convertBinaryButton;
  private JTextArea textArea;
  private JTextArea decimalArea;
  private JButton convertTextButton;
  private JTextArea hexArea;
  private JTextArea binaryArea;
  private JTextArea textArea1;
  private JTextArea textArea2;
  private JTextArea textArea3;
  private JButton button1;
  private JTextArea aboutTextArea;

  private static Logger LOGGER = Logger.getLogger(MainForm.class.getName());

  HexConversions hexConverter = new HexConversions();
  DecimalConversions decConverter = new DecimalConversions();
  BinaryConversions binConverter = new BinaryConversions();
  TextConversions textConverter = new TextConversions();

  public MainForm() {

    convertDecimalButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        String decString = decimalArea.getText();

        LOGGER.info("Converting dec");

        String textResult = decConverter.decToText(decString);
        String hexResult = decConverter.decToHex(decString);
        String binResult = decConverter.decToBinary(decString);

        LOGGER.info(textResult);
        LOGGER.info(hexResult);
        LOGGER.info(binResult);

        textArea.setText(textResult);
        hexArea.setText(hexResult);
        binaryArea.setText(binResult);
      }
    });

    convertHexButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        String hexString = hexArea.getText();

        LOGGER.info("Converting hex");

        String decResult = hexConverter.hexToDecimal(hexString);
        String binResult = hexConverter.hexToBinary(hexString);
        String textResult = hexConverter.hexToText(hexString);

        LOGGER.info(decResult);
        LOGGER.info(binResult);
        LOGGER.info(textResult);

        decimalArea.setText(decResult);
        binaryArea.setText(binResult);
        textArea.setText(textResult);
      }
    });

    convertBinaryButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        String binString = binaryArea.getText();
        String decResult, hexResult, textResult;

        LOGGER.info("Converting bin");

        decResult = binConverter.binToDecimal(binString);
        hexResult = binConverter.binToHex(binString);
        textResult = binConverter.binToText(binString);

        LOGGER.info(decResult);
        LOGGER.info(hexResult);
        LOGGER.info(textResult);

        decimalArea.setText(decResult);
        hexArea.setText(hexResult);
        textArea.setText(textResult);
      }
    });

    convertTextButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String textString = textArea.getText();
        String decResult, hexResult, binResult;

        LOGGER.info("Converting bin");

        decResult = textConverter.textToDecimal(textString);
        hexResult = textConverter.textToHex(textString);
        binResult = textConverter.textToBinary(textString);

        LOGGER.info(decResult);
        LOGGER.info(hexResult);
        LOGGER.info(binResult);

        decimalArea.setText(decResult);
        hexArea.setText(hexResult);
        binaryArea.setText(binResult);
      }
    });
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("HandyUtil");
    frame.setContentPane(new MainForm().panel1);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
    frame.setResizable(false);
  }
}
