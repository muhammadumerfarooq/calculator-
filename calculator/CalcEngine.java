/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author Umer
 */
/**
 * The main part of the calculator doing the calculations.
 * 
 * @author: (none yet)
 * @version 0.1 (incomplete)
 */
public class CalcEngine
{
private int currentValue = 0;
private int displayValue = 0;
private int heldValue = 0;
private String previousOp = null;

    /**
     * Create a CalcEngine.
     */
    public CalcEngine()
    {
    }

    /**
     * @return The value that should currently be displayed
     * on the calculator display.
     */
    public int getDisplayValue()
    {
        return displayValue;
    }

    /**
     * A number button was pressed.
     * Either start a new operand, or incorporate this number as
     * the least significant digit of an existing one.
     * @param number The number pressed on the calculator.
     */
    public void numberPressed(int number) // SINGLE DIGIT!
    {
        currentValue = (currentValue * 10) + number;
        displayValue = currentValue;
        
    }

    /**
     * The 'plus' button was pressed. 
     */
    public void plus()
    {
        applyPreviousOperation();
        previousOp = "+";
        currentValue = 0;
    }

    /**
     * The 'minus' button was pressed.
     */
    public void minus()
    {
     applyPreviousOperation();
     previousOp = "-";
     currentValue = 0;   
    }

    /**
     * The '=' button was pressed.
     */
    public void equals()
    {
    applyPreviousOperation();
    currentValue = 0;    
    heldValue = 0;
    previousOp = null;
    }

    /**
     * The 'C' (clear) button was pressed.
     */
    public void clear()
    {
        currentValue = 0;
        displayValue = 0;
        heldValue = 0;
        previousOp = null;
    }
private void applyPreviousOperation() {
    if (previousOp ==null) {
        heldValue = currentValue;
    } else if (previousOp.equals("-")) {
       heldValue = heldValue - currentValue; 
       displayValue = heldValue;
    } else {
        heldValue = heldValue + currentValue; 
       displayValue = heldValue;
    }
}

    /**
     * @return The title of this calculation engine.
     */
    public String getTitle()
    {
        return "My Calculator";
    }

    /**
     * @return The author of this engine. This string is displayed as it is,
     * so it should say something like "Written by H. Simpson".
     */
    public String getAuthor()
    {
        return "Written by H. Simpson";
    }

    /**
     * @return The version number of this engine. This string is displayed as 
     * it is, so it should say something like "Version 1.1".
     */
    public String getVersion()
    {
        return "Version 1.1";
    }
    public static void main (String [] args )
    {
        CalcEngine cal =new CalcEngine();
        cal.numberPressed(0);
      System.out.println(cal.getDisplayValue());
 } 
}