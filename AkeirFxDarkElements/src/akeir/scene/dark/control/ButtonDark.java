/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akeir.scene.dark.control;

import javafx.scene.Node;
import javafx.scene.control.Button;

/**
 *
 * @author Codeiro
 */
public class ButtonDark extends Button {
    
    public ButtonDark()
    {
        super();
        this.setText("I AM BUTTON! Click me!");
        setDefaultStyle();
    }
    
    public ButtonDark(String text)
    {
        super(text);
        setDefaultStyle();
    }
    
    public ButtonDark(String text, Node graphics)
    {
        super(text, graphics);
        setDefaultStyle();
    }
    
    private void setDefaultStyle()
    {
        this.setStyle("-fx-background-color: #383838; -fx-text-fill: White;");
        this.setPrefWidth(180.0);
        this.setPrefHeight(25.0);
    }
}
