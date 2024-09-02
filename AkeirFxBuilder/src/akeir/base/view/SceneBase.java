package akeir.base.view;

import akeir.base.view.builder.BuilderBase;
import akeir.scene.dark.layout.AnchorPaneDark;

public abstract class SceneBase extends AnchorPaneDark {
    
    protected BuilderBase builder;

    protected void executeBuild()
    {
        if(null != builder)
        {
            builder.doBuild();
        }
    }

    protected abstract void setElementsAction();
}