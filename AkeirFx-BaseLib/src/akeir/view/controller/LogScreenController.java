/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akeir.view.controller;

import akeir.view.screen.LogScreen;
import javafx.scene.layout.Pane;

/**
 *
 * @author Alencar
 */
public class LogScreenController {
    
    private static LogScreen logScreenRef;

    private LogScreenController() { }

    public static LogScreenController createInstance(Pane screen)
    {
        if(screen instanceof LogScreen)
        {
            logScreenRef = (LogScreen) screen;
            return new LogScreenController();
        }

        return null;
    }

    public void copyAction()
    {
        logScreenRef.getTxtLog().selectAll();
        logScreenRef.getTxtLog().copy();
        logScreenRef.getTxtLog().deselect();
    }

    public void wrapAction()
    {
        if(!logScreenRef.getTxtLog().isWrapText())
        {
            logScreenRef.getTxtLog().setWrapText(true);
            logScreenRef.getBtnWrapText().setText("Unwrap Text");
        }
        else
        {
            logScreenRef.getTxtLog().setWrapText(false);
            logScreenRef.getBtnWrapText().setText("Wrap Text");
        }
    }

    public void clearAction()
    {
        logScreenRef.getTxtLog().clear();
    }
}
