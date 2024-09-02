/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akeir.infra;

/**
 *
 * @author Codeiro
 */
public class Utils {
    
    private Utils() { }
    
    public int stringToInt(String value)
    {
        try
        {
            return Integer.parseInt(value);
            
        } catch(NumberFormatException ex) {
            return -1;
        }        
    }
    
    public double stringToDouble(String value)
    {
        try
        {
            return Double.parseDouble(value);
            
        } catch(NumberFormatException ex) {
            return -1;
        }
    }
}
