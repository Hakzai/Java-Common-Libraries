/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akeir.infra.view;

import javafx.collections.ObservableList;
import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Codeiro
 */
public class SceneUtils {
    
    private SceneUtils() { }
    
    public static void clearTxtFields(Pane pane, boolean isToClearRecursively)
    {
        if(null == pane) return;
        
        for(Node node : pane.getChildren())
        {
            if(node instanceof TextField)
            {
                ((TextField) node).clear();
            }
            else if(node instanceof Pane && isToClearRecursively)
            {
                clearTxtFields((Pane) node, true);
            }
        }
    }
    
    public static void clearComboBoxes(Pane pane, boolean isToClearRecursively)
    {
        if(null == pane) return;
        
        for(Node node : pane.getChildren())
        {
            if(node instanceof ComboBox)
            {
                ((ComboBox) node).setValue(null);
            }
            else if(node instanceof Pane && isToClearRecursively)
            {
                clearComboBoxes((Pane) node, true);
            }
        }
    }
    
    public static boolean isAnyTxtFieldEmpty(Pane pane, boolean isToCheckRecursively)
    {
        if(null == pane) return false;
        
        for(Node node : pane.getChildren())
        {
            if(node instanceof TextField && ((TextField) node).getText().isEmpty())
            {
                return true;
            }
            else if(node instanceof Pane && isToCheckRecursively)
            {
                isAnyTxtFieldEmpty((Pane) node, true);
            }
        }
        
        return false;
    }
    
    public static boolean isAnyComboBoxEmpty(Pane pane, boolean isToCheckRecursively)
    {
        if(null == pane) return false;
        
        for(Node node : pane.getChildren())
        {
            if(node instanceof ComboBox && ((ComboBox) node).getValue() == null)
            {
                return true;
            }
            else if(node instanceof Pane && isToCheckRecursively)
            {
                isAnyComboBoxEmpty((Pane) pane, true);
            }
        }
        
        return false;
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
    
    public static boolean isNewEntry(ObservableList<Node> nodeList, String newEntryTextFieldId)
    {
        if(null == newEntryTextFieldId) return false;
        
        for(Node node : nodeList)
        {
            if(node instanceof TextField)
            {
                if(newEntryTextFieldId.equals(((TextField) node).getId()) && ((TextField) node).getText().isEmpty())
                {
                    return true;
                }
            }
            else if(node instanceof Pane)
            {
                if(isNewEntry(((Pane) node).getChildren(), newEntryTextFieldId))
                {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static boolean createImage(Pane screen, ImageView image, String id, double height, double width, double posX, double posY, boolean isPickOnBounds, boolean isPreserveRatio, String externalFormURL)
    {
        if(null == screen || null == image || null == id || null == externalFormURL) return false;
        
        image.setId("imgInstructions");
        image.setFitHeight(height);
        image.setFitWidth(width);
        image.setLayoutX(posX);
        image.setLayoutY(posY);
        image.setPickOnBounds(isPickOnBounds);
        image.setPreserveRatio(isPreserveRatio);
        image.setImage(new Image(externalFormURL)); // EXTERNAL FORM SHOULD BE WROTE LIKE this >> getClass().getResource("LOCAL_PATH_GOES_HERE").toExternalForm()
        
        return screen.getChildren().add(image);
    }
    
    public static void showImage(ImageView image, boolean isToShow)
    {
        if(null == image) return;
        
        image.setVisible(isToShow);
        
        if(image.isVisible())
        {
            image.toFront();
        }
    }
    
    public static void rotateImg(ImageView image, String axis, double rotationDegree)
    {
        if(null == image || null == axis) return;
                
        switch (axis.toUpperCase())
        {
            case "X":
                image.setRotationAxis(new Point3D(1.0, 0.0, 0.0));
                break;
            case "Y":
                image.setRotationAxis(new Point3D(0.0, 1.0, 0.0));
                break;
            case "Z":
                image.setRotationAxis(new Point3D(0.0, 0.0, 1.0));
                break;
            default:
                return;
        }
        
        image.setRotate(rotationDegree);
    }
    
    public static void setNodeAnchors(Node node, double leftAnchor, double topAnchor, double rightAnchor, double bottomAnchor)
    {
        if(null == node) return;
        
        if(leftAnchor > 0.0)
            AnchorPane.setLeftAnchor(node, leftAnchor);

        if(topAnchor > 0.0)
            AnchorPane.setTopAnchor(node, topAnchor);
        
        if(rightAnchor > 0.0)
            AnchorPane.setRightAnchor(node, rightAnchor);
        
        if(bottomAnchor > 0.0)
            AnchorPane.setBottomAnchor(node, bottomAnchor);
    }
}
