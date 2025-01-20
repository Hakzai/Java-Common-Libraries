package akeir.view.base;

import javafx.scene.layout.AnchorPane;

public abstract class SceneBase extends AnchorPane {

    protected BuilderBase builder;

    protected SceneBase()
    {
        super();
        initialize(1280.0, 720.0); //TODO: SET STD INIT FROM A SPECIFIC CONF FILE
    }
    
    protected SceneBase(double width, double height)
    {
        super();
        initialize(width, height);
    }
    
    private void initialize(double width, double height)
    {
        this.setPrefWidth(width);
        this.setPrefHeight(height);
        
        createInstanceForElements();
        createController();
        setElementsAction();
    }

    protected void buildScreen()
    {
        if(null == builder)
        {
            builder = createInstanceForBuilder();
        }
        
        builder.doBuild();
    }

    protected abstract BuilderBase createInstanceForBuilder();
    
    protected abstract void createInstanceForElements();

    protected abstract void createController(); 

    protected abstract void setElementsAction();
}
