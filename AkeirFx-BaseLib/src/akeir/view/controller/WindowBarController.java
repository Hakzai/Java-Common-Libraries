/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akeir.view.controller;

import akeir.view.base.ControllerBase;
import akeir.view.screen.AboutScreen;
import akeir.view.screen.MainScreen;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class WindowBarController extends ControllerBase {

    private double x, y;

    private WindowBarController() { }

    public static WindowBarController createInstance()
    {
        return new WindowBarController();
    }

    public void closeAction(Event event)
    {
        if(event.getSource() instanceof MenuItem)
        {
            closeActionFromContextMenu(event);
        }
        else
        {
            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

            if(((Node) event.getSource()).getScene().getRoot() instanceof MainScreen)
            {
                WindowController.exitAction();
            }
        }
    }

    protected void closeActionFromContextMenu(Event event)
    {
        ((Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow()).close();

        if(((Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow()).getScene().getRoot() instanceof MainScreen)
        {
            WindowController.exitAction();
        }
    }

    public void barMousePressedAction(MouseEvent event)
    {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    public void barMouseDraggedAction(MouseEvent event)
    {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @Override
    protected void createContextMenu()
    {
        super.createContextMenu();

        MenuItem aboutItem = new MenuItem("About");
        aboutItem.setOnAction(e -> aboutAction(e));
        contextMenu.getItems().add(aboutItem);

        contextMenu.getItems().add(new SeparatorMenuItem());

        MenuItem minimizeItem = new MenuItem("Minimize");
        minimizeItem.setOnAction(e -> minimizeAction(e));
        contextMenu.getItems().add(minimizeItem);

        MenuItem closeItem = new MenuItem("Close");
        closeItem.setOnAction(e -> closeAction(e));
        contextMenu.getItems().add(closeItem);
    }
    
    public void minimizeAction(Event event)
    {
        ((Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow()).setIconified(true);
    }

    //TODO: Implement action later
    public void aboutAction(Event event)
    {
        if(null == AboutScreen.get().getScene() || null == AboutScreen.get().getScene().getWindow())
        {
            WindowController.createWindow(AboutScreen.get(), "About");
        }

        ((Stage) AboutScreen.get().getScene().getWindow()).show();
    }
}
