/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akeir.view.builder;

import akeir.view.base.BuilderBase;
import akeir.view.screen.LogScreen;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class LogScreenBuilder extends BuilderBase {

    private LogScreen logScreen;

    public LogScreenBuilder(Pane pane)
    {
        if(pane instanceof LogScreen)
        {
            System.out.println("<< Creating log screen >>");
            logScreen = (LogScreen) pane;
        }
    }

    @Override
    public void doBuild() 
    {
        logScreen.setId("logScreen");
        logScreen.setPrefSize(700.0, 500.0);
        logScreen.getWindowBar().getLbTitle().setText("Logs");

        logScreen.getBtnCopyText().setId("btnCopy");
        AnchorPane.setBottomAnchor(logScreen.getBtnCopyText(), 15.0);
        AnchorPane.setLeftAnchor(logScreen.getBtnCopyText(), 15.0);
        logScreen.getBtnCopyText().setText("Copy Text");
        logScreen.getChildren().add(logScreen.getBtnCopyText());

        logScreen.getBtnWrapText().setId("btnWrap");
        AnchorPane.setBottomAnchor(logScreen.getBtnWrapText(), 15.0);
        AnchorPane.setLeftAnchor(logScreen.getBtnWrapText(), AnchorPane.getLeftAnchor(logScreen.getBtnCopyText())+115.0);
        logScreen.getBtnWrapText().setText("Wrap Text");
        logScreen.getChildren().add(logScreen.getBtnWrapText());

        logScreen.getBtnClearText().setId("btnClear");
        AnchorPane.setBottomAnchor(logScreen.getBtnClearText(), 15.0);
        AnchorPane.setRightAnchor(logScreen.getBtnClearText(), 15.0);
        logScreen.getBtnClearText().setText("Clear");
        logScreen.getChildren().add(logScreen.getBtnClearText());

        logScreen.getTxtLog().setId("txtLog");
        logScreen.getTxtLog().setPrefSize(670.0, 405.0);
        logScreen.getTxtLog().setLayoutX(15.0);
        logScreen.getTxtLog().setLayoutY(logScreen.getWindowBar().getPrefHeight()+15.0);
        logScreen.getTxtLog().setEditable(false);
        logScreen.getTxtLog().setEffect(new DropShadow());
        logScreen.getChildren().add(logScreen.getTxtLog());
    }
}
