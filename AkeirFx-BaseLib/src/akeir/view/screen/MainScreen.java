/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akeir.view.screen;

import akeir.view.base.WindowBase;
import akeir.view.builder.MainScreenBuilder;
import akeir.view.controller.MainScreenController;
import akeir.view.controller.WindowController;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainScreen extends WindowBase {

    protected static MainScreenController controller;

    protected VBox vbMain;
    protected Button btnLog;
    protected Stage logWindow;

    public MainScreen()
    {
        super();
        buildScreen();
        addControlListeners();
    }
    
    @Override
    protected MainScreenBuilder createInstanceForBuilder()
    {
        return new MainScreenBuilder(this);
    }

    @Override
    protected void createInstanceForElements() 
    {
        vbMain = new VBox();
        btnLog = new Button();
        logWindow = WindowController.createLogWindow();
    }

    @Override
    protected void createController()
    {
        controller = MainScreenController.createInstance(this);
    }

    @Override
    protected void setElementsAction() 
    {
        btnLog.setOnAction(e -> controller.logAction());
    }

    protected void addControlListeners()
    {
    }

    public Button getBtnLog()
    {
        return btnLog;
    }

    public Stage getLogWindow()
    {
        return logWindow;
    }

    public VBox getVbMain()
    {
        return vbMain;
    }
}
