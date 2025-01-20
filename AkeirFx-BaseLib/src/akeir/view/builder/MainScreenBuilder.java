/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akeir.view.builder;

import akeir.view.base.BuilderBase;
import akeir.view.screen.MainScreen;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class MainScreenBuilder extends BuilderBase {
	
    protected MainScreen mainScreen;

    public MainScreenBuilder(AnchorPane pane)
    {
        if(pane instanceof MainScreen)
        {
            System.out.println("<< Creating main screen >>");
            mainScreen = (MainScreen) pane;
        }
    }

    @Override
    public void doBuild()
    {
        mainScreen.setId("mainScreen");
        mainScreen.setPrefSize(500.0, 375.0);
        mainScreen.getWindowBar().getLbTitle().setText("Main Window");

        VBox vbMainRef = mainScreen.getVbMain();
        vbMainRef.setId("vbMain");
        vbMainRef.setPrefSize(484.0, 370.0);
        vbMainRef.setLayoutX(8.0);
        vbMainRef.setLayoutY(mainScreen.getWindowBar().getPrefHeight() + 12.0);
        vbMainRef.setPadding(new Insets(5.0, 10.0, 0.0, 10.0));
        mainScreen.getChildren().add(vbMainRef);

        mainScreen.getBtnLog().setId("btnLog");
        mainScreen.getBtnLog().setText("View Logs");

        vbMainRef.getChildren().add(mainScreen.getBtnLog());
    }
}
