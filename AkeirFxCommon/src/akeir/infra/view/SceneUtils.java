/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akeir.infra.view;

import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 *
 * @author Codeiro
 */
public class SceneUtils {
    
    private SceneUtils() { }
    
    public static void clearTxtFields(Pane pane)
    {
        if(null == pane) return;
        
        for(Node node : pane.getChildren())
        {
            if(node instanceof TextField)
            {
                ((TextField) node).clear();
            }
        }
    }
    
    public static boolean isAnyTxtFieldEmpty(Pane pane)
    {
        if(null == pane) return false;
        
        for(Node node : pane.getChildren())
        {
            if(node instanceof TextField && ((TextField) node).getText().isEmpty())
            {
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean isAnyComboBoxEmpty(Pane pane)
    {
        if(null == pane) return false;
        
        for(Node node : pane.getChildren())
        {
            if(node instanceof ComboBox && ((ComboBox) node).getValue() == null)
            {
                return true;
            }
        }
        
        return false;
    }
}
