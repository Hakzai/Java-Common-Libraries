/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akeir.scene.dark.control;

import javafx.scene.control.TextField;

/**
 *
 * @author Codeiro
 */
public class TextFieldDark extends TextField {

    public TextFieldDark()
    {
        super();
        this.setPromptText("I AM PROMPT! Write me!");
        setDefaultStyle();
    }
    
    public TextFieldDark(String text) 
    {
        super(text);
        setText(text);
        setDefaultStyle();
    }
    
    private void setDefaultStyle()
    {
        this.setStyle("-fx-background-color: gray; -fx-text-fill: white;");
        this.setPrefWidth(250.0);
        this.setPrefHeight(30.0);
    }
}
