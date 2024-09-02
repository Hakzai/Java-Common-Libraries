/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akeir.view.sample.builder;

import akeir.base.view.builder.BuilderBase;
import akeir.scene.dark.control.ButtonDark;
import akeir.scene.dark.control.LabelDark;
import akeir.view.sample.TestScene;

import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Codeiro
 */
public class TestSceneBuilder extends BuilderBase {
    
    private TestScene scene;

    public TestSceneBuilder(AnchorPane loginScene)
    {
        if(loginScene instanceof TestScene)
        {
            scene = (TestScene) loginScene;
        }
    }

    @Override
    public void doBuild() 
    {
        super.doBuild();

        scene.setPrefWidth(300.0);
        scene.setPrefHeight(400.0);

        scene.getBtnClickMe().setId("btnClickMe");
        scene.getBtnClickMe().setText("Click Me!");
        scene.getBtnClickMe().setLayoutX(100.0);
        scene.getBtnClickMe().setLayoutY(165.0);
        scene.getBtnClickMe().setPrefWidth(100.0);
        scene.getBtnClickMe().setPrefHeight(30.0);
        scene.getBtnClickMe().setAlignment(Pos.CENTER);
        scene.getChildren().add(scene.getBtnClickMe());
        
        scene.getLbHelloWorld().setId("lbHelloWorld");
        scene.getLbHelloWorld().setText("Hello World!!");
        scene.getLbHelloWorld().setLayoutX(100.0);
        scene.getLbHelloWorld().setLayoutY(205.0);
        scene.getLbHelloWorld().setPrefWidth(100.0);
        scene.getLbHelloWorld().setPrefHeight(30.0);
        scene.getLbHelloWorld().setAlignment(Pos.CENTER);
        scene.getLbHelloWorld().setVisible(false);
        scene.getChildren().add(scene.getLbHelloWorld());
    }

    @Override
    protected void createInstanceForElements() 
    {
        scene.setLbHelloWorld(new LabelDark());
        scene.setBtnClickMe(new ButtonDark());
    }
}