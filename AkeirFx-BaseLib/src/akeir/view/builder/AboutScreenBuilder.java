/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akeir.view.builder;

import akeir.infra.ExceptionUtils;
import akeir.view.base.BuilderBase;
import akeir.view.resources.ResourcesConstants;
import akeir.view.screen.AboutScreen;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class AboutScreenBuilder extends BuilderBase {

    private AboutScreen aboutScreen;	

    public AboutScreenBuilder(Pane pane)
    {
        if(pane instanceof AboutScreen)
        {
            System.out.println("<< Creating about screen >>");
            aboutScreen = (AboutScreen) pane;
        }
    }

    @Override
    public void doBuild() 
    {
        aboutScreen.setId("aboutScreen");
        aboutScreen.setPrefSize(600.0, 550.0);
        aboutScreen.getWindowBar().getLbTitle().setText("About");

        aboutScreen.getTxtAbout().setId("txtAbout");
        AnchorPane.setTopAnchor(aboutScreen.getTxtAbout(), aboutScreen.getWindowBar().getPrefHeight()+10.0);
        AnchorPane.setBottomAnchor(aboutScreen.getTxtAbout(), 10.0);
        AnchorPane.setLeftAnchor(aboutScreen.getTxtAbout(), 10.0);
        AnchorPane.setRightAnchor(aboutScreen.getTxtAbout(), 10.0);
        aboutScreen.getTxtAbout().setText(getAboutText());
        aboutScreen.getTxtAbout().setEditable(false);
        aboutScreen.getTxtAbout().setFocusTraversable(false);
        aboutScreen.getTxtAbout().setMouseTransparent(true);
        aboutScreen.getTxtAbout().setWrapText(true);
        aboutScreen.getChildren().add(aboutScreen.getTxtAbout());
    }

    private String getAboutText()
    {
        StringBuilder txtBuilder = new StringBuilder();
        
        try 
        {
            // Get resource as InputStream
            InputStream inputStream = getClass().getResourceAsStream(ResourcesConstants.ABOUT_TEXT_PATH);
            if (inputStream == null) 
            {
                throw new IllegalArgumentException("File not found: " + ResourcesConstants.ABOUT_TEXT_PATH);
            }

            // Read file
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) 
            {
                String line;
                while ((line = reader.readLine()) != null) 
                {
                    txtBuilder.append(line).append("\n");
                }
            }
        } catch (Exception ex) {
            ExceptionUtils.exceptionOnFile(ex);
        }

        return txtBuilder.toString();
    }
}
