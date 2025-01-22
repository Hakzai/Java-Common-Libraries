/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akeir.view.base;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Codeiro
 */
public abstract class ControllerBase {
    
    protected ContextMenu contextMenu;
    
    protected void createContextMenu()
    {
        contextMenu = new ContextMenu();
        contextMenu.setHideOnEscape(true);
        contextMenu.setAutoHide(true);
    }
    
    public void mouseClickAction(MouseEvent event)
    {
        if(event.getButton() == MouseButton.PRIMARY)
        {
            mouseLeftClickAction(event);
        }
        else if(event.getButton() == MouseButton.SECONDARY)
        {
            mouseRightClickAction(event);
        }
    }

    protected void mouseRightClickAction(MouseEvent event)
    {
        if(contextMenu == null)
        {
            createContextMenu();
        }
        //TODO: Implement diff action between source context and node
        if (!contextMenu.isShowing() && !contextMenu.getItems().isEmpty()) {
            contextMenu.show(((Node) event.getSource()).getWindow(), event.getScreenX(), event.getScreenY());
        } else {
            contextMenu.hide();
        }
    }
    
    protected void mouseLeftClickAction(MouseEvent event)
    {
        if (contextMenu.isShowing())
        {
            contextMenu.hide();
        }
    }
}
