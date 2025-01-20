/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akeir.view.screen;

import akeir.view.base.WindowBase;
import akeir.view.builder.AboutScreenBuilder;
import javafx.scene.control.TextArea;

/**
 *
 * @author Alencar
 */
public class AboutScreen extends WindowBase {
    
    private static AboutScreen instance;

    private TextArea txtAbout;

    private AboutScreen()
    {
        super();
        buildScreen();
    }

    public static AboutScreen get()
    {
        if(instance == null)
        {
            instance = new AboutScreen();
        }

        return instance;
    }
    
    @Override
    protected AboutScreenBuilder createInstanceForBuilder()
    {
        return new AboutScreenBuilder(this);
    }

    @Override
    protected void createInstanceForElements() 
    {
        txtAbout = new TextArea();
    }

    @Override
    protected void createController() 
    {
        // Not needed
    }

    @Override
    protected void setElementsAction() 
    {
        // Not needed
    }

    public TextArea getTxtAbout() 
    {
        return txtAbout;
    }
}
