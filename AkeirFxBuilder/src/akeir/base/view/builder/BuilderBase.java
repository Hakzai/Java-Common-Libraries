package akeir.base.view.builder;

public abstract class BuilderBase {
	
    public void doBuild()
    {
        createInstanceForElements();
    }
	
    protected abstract void createInstanceForElements();

}