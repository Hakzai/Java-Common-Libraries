/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akeir.infra;

import java.io.PrintWriter;
import java.io.StringWriter;

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
    
    public static String writeStackTrace(Exception ex)
    {
        if(ex == null) return Constants.EMPTY_STRING;
        
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ex.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }
    
    //TODO: Further implementation
//    public static void printOutput(Object output)
//    {
//        System.err.println("<< Output Object >>" + "\n");
//
//        XStream xs = new XStream();
//        xs.toXML(output.getClass().cast(output), System.out);
//    }
}
