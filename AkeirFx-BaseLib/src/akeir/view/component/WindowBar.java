/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akeir.view.component;

import akeir.view.base.SceneBase;
import akeir.view.resources.ResourcesConstants;
import akeir.view.builder.WindowBarBuilder;
import akeir.view.controller.WindowBarController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Alencar
 */
public class WindowBar extends SceneBase {
    
    private WindowBarController controller;

    private Button btnClose;
    private Label lbTitle;
    private Image imgIcon;
    private ImageView viewIcon;

    public WindowBar()
    {
        super();
        buildScreen();
    }
    
    @Override
    protected WindowBarBuilder createInstanceForBuilder()
    {
        return new WindowBarBuilder(this);
    }

    protected void createInstanceForElements() 
    {
        btnClose = new Button("X");
        lbTitle = new Label();
        imgIcon = new Image(ResourcesConstants.EJB_ICON_PATH);
        viewIcon = new ImageView(imgIcon);
    }

    protected void createController() 
    {
        controller = WindowBarController.createInstance();
    }

    protected void setElementsAction() 
    {
        this.getBtnClose().setOnAction(e -> controller.closeAction(e));
        this.setOnMousePressed(e -> controller.barMousePressedAction(e));
        this.setOnMouseDragged(e -> controller.barMouseDraggedAction(e));
        this.setOnMouseClicked(e -> controller.barMouseClickAction(e));
    }

    public Button getBtnClose()
    {
        return btnClose;
    }

    public Label getLbTitle()
    {
        return lbTitle;
    }

    public ImageView getViewIcon()
    {
        return viewIcon;
    }
}
