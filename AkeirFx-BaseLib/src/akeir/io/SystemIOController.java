/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akeir.io;

import java.io.OutputStream;
import java.io.PrintStream;

import akeir.view.screen.LogScreen;

public class SystemIOController {
	
    private static PrintStream originalSysOut;
    private static PrintStream originalSysErr;

    private SystemIOController() { }

    public static void setSystemOutToLogScreen()
    {
    // Redirect System.out to the TextArea
    PrintStream printStream = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
                // Ensure thread-safety by running the code on the JavaFX Application Thread
                javafx.application.Platform.runLater(() -> LogScreen.get().getTxtLog().appendText(String.valueOf((char) b)));
            }
        });

        backupOriginalSysOut();
        System.setOut(printStream);
        System.setErr(printStream);
    }

    private static void backupOriginalSysOut()
    {
        originalSysOut = System.out;
        originalSysErr = System.err;
    }

    public static void setSystemOutToConsole()
    {
        restoreOriginalSysOut();
    }

    private static void restoreOriginalSysOut()
    {
        if(null != originalSysOut) System.setOut(originalSysOut);
        if(null != originalSysErr) System.setErr(originalSysErr);
    }
}
