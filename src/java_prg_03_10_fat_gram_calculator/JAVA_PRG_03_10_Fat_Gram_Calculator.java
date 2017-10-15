/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_prg_03_10_fat_gram_calculator;

import javax.swing.JOptionPane;
/**
 *
 * @author bluebackdev
 * Write a program that asks the user to enter the number of calories and fat
 * grams in a food item. The program should display the percentage of the
 * calories that come from fat. One gram of fat has 9 calories; therefore:
 * 
 *      Calories from fat = Fat grams * 9
 * 
 * The percentage of calories from fat can be calculated as follows:
 * 
 *      Calories from fat / Total Calories
 * 
 * If the calories from fat are less than 30 percent of the total calories of
 * the food, it should also display a message indicating the food is low in fat.
 */
public class JAVA_PRG_03_10_Fat_Gram_Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Define float divisor constant
        final float FLT_FAT_CALORIE_DIVISOR = 9.0f;
        final float FLT_FAT_CALORIE_PERCENTAGE = 30.0f;
        
        // Declare floats to hold user inputs and fat percentage calculation
        float fltCalories;
        float fltFatGrams;
        float fltFatCalories;
        float fltFatPercentage;
        
        // Declare strings to hold user inputs and formatted output
        String strCalories;
        String strFatGrams;
        String strOutput;
        
        // Get user inputs
        strCalories = JOptionPane.showInputDialog("Please enter the " +
                "number of\ncalories in your food item.");
        strFatGrams = JOptionPane.showInputDialog("Please enter the " +
                "number of\ngrams of fat in your food item.");
        
        // Convert user input from strings to floats
        fltCalories = Float.parseFloat(strCalories);
        fltFatGrams = Float.parseFloat(strFatGrams);
        
        // Calculate fat grams percentage
        fltFatCalories = fltFatGrams * FLT_FAT_CALORIE_DIVISOR;
        fltFatPercentage = fltFatCalories / fltCalories;
        // Convert fat percentage to whole number value
        fltFatPercentage = fltFatPercentage * 100.0f;
        
        // Compare calculated fat percentage against constant
        // to see if food item is low-fat, not low-fat or has
        // too many grams of fat and not enough calories to calculate
        // (throw error on third case)
        if(fltFatPercentage < FLT_FAT_CALORIE_PERCENTAGE)
        {
            strOutput = String.format("With %.1f fat calories, that food item\n" +
                    "has a fat percentage of %.1f%% and is low-fat.",
                    fltFatCalories, fltFatPercentage);
            JOptionPane.showMessageDialog(null, strOutput);
        }
        else if(fltFatPercentage >= FLT_FAT_CALORIE_PERCENTAGE && fltFatPercentage <= 100.0f)
        {
            strOutput = String.format("Your food is not low-fat\nwith %.1f fat calories and a\n" +
                    "fat percentage of %.1f%%.",
                    fltFatCalories, fltFatPercentage);
            JOptionPane.showMessageDialog(null, strOutput);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "ERROR YOUR FOOD HAS " +
                    "MORE\nGRAMS OF FAT THAN THERE ARE CALORIES");
        }
        
        // For JOptionPane
        System.exit(0);
    }
    
}
