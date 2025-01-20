/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akeir.view.base;

import akeir.view.component.WindowBar;
import javafx.scene.layout.AnchorPane;

public abstract class WindowBase extends SceneBase {

    protected WindowBar windowBar;

    protected WindowBase()
    {
        super();

        windowBar = new WindowBar();
        AnchorPane.setTopAnchor(windowBar, 0.0);
        AnchorPane.setLeftAnchor(windowBar, 0.0);
        AnchorPane.setRightAnchor(windowBar, 0.0);
        this.getChildren().add(windowBar);
    }

    public WindowBar getWindowBar()
    {
        return windowBar;
    }
}
