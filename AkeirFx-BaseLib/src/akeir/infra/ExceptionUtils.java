/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akeir.infra;

/**
 *
 * @author Alencar
 */
public class ExceptionUtils {
    
    private ExceptionUtils() { }

    public static void exceptionOnLoad(Exception ex)
    {
        System.err.println("<< FATAL ERROR ON LOAD >>");
        Utils.writeStackTrace(ex);
        System.exit(1);
    }

    public static void exceptionOnFile(Exception ex)
    {
        System.err.println("<< FATAL ERROR ON FILE READING >>");
        System.out.println("<< EXCEPTION :: " + ex.toString() + " >>");
        System.out.println("<< Please check file >>");
    }
}
