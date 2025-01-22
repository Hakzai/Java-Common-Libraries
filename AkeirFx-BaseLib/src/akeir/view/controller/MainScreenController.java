/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akeir.view.controller;

import akeir.view.base.ControllerBase;
import akeir.view.screen.MainScreen;
import javafx.scene.layout.AnchorPane;

public class MainScreenController extends ControllerBase {

    private static MainScreen mainScreenRef;

    protected MainScreenController() { }

    public static MainScreenController createInstance(AnchorPane screen)
    {
        if(screen instanceof MainScreen)
        {
            mainScreenRef = (MainScreen) screen;
            return new MainScreenController();
        }

        return null;
    }

    public void logAction()
    {
        if(!mainScreenRef.getLogWindow().isShowing())
        {
            mainScreenRef.getLogWindow().show();
        }
        else
        {
            mainScreenRef.getLogWindow().hide();
        }
    }
}
