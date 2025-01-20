/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akeir.view.controller;

import akeir.io.SystemIOController;
import akeir.view.resources.ResourcesConstants;
import akeir.view.screen.LogScreen;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class WindowController {

    private WindowController() { }

    public static Stage createLogWindow()
    {
        Stage logWindow = createWindow(LogScreen.get(), "Log Screen");
        SystemIOController.setSystemOutToLogScreen();

        return logWindow;
    }

    public static Stage createWindow(Pane screen, String title)
    {
        Stage window = new Stage();

        Scene scene = new Scene(screen);
        scene.getStylesheets().add(ResourcesConstants.DARK_THEME_CSS_PATH);
        scene.setFill(Color.TRANSPARENT);
        window.setScene(scene);
        window.initStyle(StageStyle.TRANSPARENT);
        window.initModality(Modality.WINDOW_MODAL);
        window.setResizable(false);
        window.setTitle(title);

        Image icon = new Image(ResourcesConstants.EJB_ICON_PATH);
        window.getIcons().add(icon);

        return window;
    }
        
    public static void openNewWindow(Stage callerScreen, Pane openingScreen, boolean isToHideCaller)
    {
        if(null == callerScreen || null == openingScreen) return;
        
        if(isToHideCaller)
        {
            callerScreen.hide();
        }
           
        Scene scene = new Scene(openingScreen);
        Stage stage = new Stage();
        stage.setTitle(openingScreen.getId());
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
        
        if(!callerScreen.isShowing())
        {
            callerScreen.show();
        }
    }

    public static void exitAction()
    {
        SystemIOController.setSystemOutToConsole();
        System.err.println("<< Stopping System >>");
        Platform.exit();
    }
}
