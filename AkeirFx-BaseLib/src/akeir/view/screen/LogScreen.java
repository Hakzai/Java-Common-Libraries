/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akeir.view.screen;

import akeir.view.base.WindowBase;
import akeir.view.builder.LogScreenBuilder;
import akeir.view.controller.LogScreenController;
import javafx.animation.PauseTransition;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.util.Duration;

public class LogScreen extends WindowBase {

    private static LogScreen instance;
    private static LogScreenController controller;

    private Button btnCopyText;
    private Button btnWrapText;
    private Button btnClearText;
    private TextArea txtLog;
    private Tooltip tipCopyMsg;

    private LogScreen()
    {
        super();

        builder = new LogScreenBuilder(this);
        builder.doBuild();

        addControlListeners();
    }

    public static LogScreen get()
    {
        if(instance == null)
        {
            instance = new LogScreen();
        }

        return instance;
    }
    
    @Override
    protected LogScreenBuilder createInstanceForBuilder()
    {
        return new LogScreenBuilder(this);
    }

    @Override
    protected void createInstanceForElements() 
    {
        btnCopyText = new Button();
        btnWrapText = new Button();
        btnClearText = new Button();
        txtLog = new TextArea();

        tipCopyMsg = new Tooltip("Text copied!");
    }

    @Override
    protected void createController() 
    {
        controller = LogScreenController.createInstance(this);
    }

    @Override
    protected void setElementsAction() 
    {
        btnCopyText.setOnAction(e -> controller.copyAction());
        btnWrapText.setOnAction(e -> controller.wrapAction());
        btnClearText.setOnAction(e -> controller.clearAction());
    }

    private void addControlListeners()
    {
        setTooltipWhenCopyText();
    }

    private void setTooltipWhenCopyText()
    {
        btnCopyText.armedProperty().addListener((obs) -> {
            tipCopyMsg.show(
                this.getScene().getWindow(), 
                this.getScene().getWindow().getX()+btnCopyText.getLayoutX()+13.0, // sums window X position on screen, btnCopy positon with 13.0 
                this.getScene().getWindow().getY()+btnCopyText.getLayoutY()+30.0 // sums window Y position on screen, btnCopy position with 30.0
            );

            // Hides tip after 2 secs
            PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.setOnFinished(e -> tipCopyMsg.hide());
            pause.play();
        });
    }

    public Button getBtnCopyText()
    {
        return btnCopyText;
    }

    public Button getBtnWrapText()
    {
        return btnWrapText;
    }

    public Button getBtnClearText()
    {
        return btnClearText;
    }

    public TextArea getTxtLog()
    {
        return txtLog;
    }

    public Tooltip getTipCopyMsg()
    {
        return tipCopyMsg;
    }
}

