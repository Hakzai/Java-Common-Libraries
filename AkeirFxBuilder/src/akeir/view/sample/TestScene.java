/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akeir.view.sample;

import akeir.base.view.SceneBase;
import akeir.view.sample.builder.TestSceneBuilder;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author Codeiro
 */
public class TestScene extends SceneBase {

    private Button btnClickMe;
    private Label lbHelloWorld;

    public TestScene()
    {
        builder = new TestSceneBuilder(this);
        executeBuild();
        
        setElementsAction();
    }

    @Override
    protected void setElementsAction()
    {
        btnClickMe.setOnAction(e -> showHelloWorldMessage());
    }

    public Label getLbHelloWorld() 
    {
        return lbHelloWorld;
    }

    public void setLbHelloWorld(Label lbHelloWorld) 
    {
        this.lbHelloWorld = lbHelloWorld;
    }

    public Button getBtnClickMe() 
    {
        return btnClickMe;
    }

    public void setBtnClickMe(Button btnClickMe) 
    {
        this.btnClickMe = btnClickMe;
    }
    
    private void showHelloWorldMessage()
    {
        lbHelloWorld.setVisible(true);
    }
}