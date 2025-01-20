/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akeir.view.builder;

import akeir.view.base.BuilderBase;
import akeir.view.component.WindowBar;
import javafx.scene.layout.AnchorPane;

public class WindowBarBuilder extends BuilderBase {

    private WindowBar windowBar;

    public WindowBarBuilder(AnchorPane pane)
    {
        if(pane instanceof WindowBar)
        {
            windowBar = (WindowBar) pane;
        }
    }

    @Override
    public void doBuild() 
    {
        windowBar.setId("windowBar");
        windowBar.setPrefHeight(25.0);

        windowBar.getBtnClose().setId("btnClose");
        windowBar.getBtnClose().getStyleClass().remove("button");
        windowBar.getBtnClose().getStyleClass().add("windowBarButton");
        AnchorPane.setTopAnchor(windowBar.getBtnClose(), 5.0);
        AnchorPane.setBottomAnchor(windowBar.getBtnClose(), 5.0);
        AnchorPane.setRightAnchor(windowBar.getBtnClose(), 5.0);
        windowBar.getChildren().add(windowBar.getBtnClose());

        windowBar.getLbTitle().setId("lbTitle");
        windowBar.getLbTitle().setText("WindowTitle");
        windowBar.getLbTitle().getStyleClass().remove("label");
        windowBar.getLbTitle().getStyleClass().add("windowBarLabel");
        AnchorPane.setLeftAnchor(windowBar.getLbTitle(), 30.0);
        windowBar.getChildren().add(windowBar.getLbTitle());

        windowBar.getViewIcon().setId("imgIcon");
        windowBar.getViewIcon().setFitWidth(20.0);
        windowBar.getViewIcon().setFitHeight(20.0);
        windowBar.getViewIcon().setLayoutY(5.0);
        AnchorPane.setLeftAnchor(windowBar.getViewIcon(), 5.0);
        windowBar.getChildren().add(windowBar.getViewIcon());
    }
}
