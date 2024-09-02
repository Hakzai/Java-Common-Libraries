/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akeir.scene.dark.control;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;

/**
 *
 * @author Codeiro
 */
public class LabelDark extends Label {
    
    public LabelDark() 
    {
        super();
        this.setText("I AM LABEL! Read me!");
        setDefaultStyle();
    }

    public LabelDark(String text) 
    {
        super(text);
        setDefaultStyle();
    }

    public LabelDark(String text, Node graphic) 
    {
        super(text, graphic);
        setDefaultStyle();
    }
    
    private void setDefaultStyle()
    {
        this.setStyle("-fx-text-fill: white; -fx-font-size: 14px ");
        this.setPrefWidth(100.0);
        this.setPrefHeight(30.0);
        this.setAlignment(Pos.CENTER_LEFT);
    }
}
