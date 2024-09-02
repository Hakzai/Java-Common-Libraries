/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akeir.scene.dark.layout;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Codeiro
 */
public class AnchorPaneDark extends AnchorPane {
    
    public AnchorPaneDark()
    {
        super();
        setDefaultStyle();
    }
    
    public AnchorPaneDark(Node... children)
    {
        super(children);
        setDefaultStyle();
    }
    
    private void setDefaultStyle()
    {
        this.setStyle("-fx-background-color: #181818;"); // THIS IS DARK GRAY COLOR
        this.setPrefWidth(1280.0);
        this.setPrefHeight(720.0);
    }
}
