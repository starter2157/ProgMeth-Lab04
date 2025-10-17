package entity.container;

import entity.base.Container;
import entity.base.Ingredient;
import logic.StringUtil;

public class Dish extends Container {

    private int dirty;

    public Dish(){
        super("Dish", 4);
        setDirty(0);
    }

    public Dish(int dirty){
        super("Dish", 4);
        setDirty(dirty);
    }

    public boolean isDirty(){
        return dirty > 0;
    }

    public boolean verifyContent(Ingredient i){
        return !isDirty() && i.isEdible();
    }

    public void clean(int amount){
        setDirty(getDirty() - amount);
    }

    public String toString(){
        if(isDirty()) return StringUtil.formatNamePercentage(getName(), getDirty());
        else return super.toString();
    }

    public int getDirty() {
        return dirty;
    }

    public void setDirty(int dirty) {
        this.dirty = Math.max(0, dirty);
        if(getDirty()>0) setName("Dirty Dish");
        else setName("Dish");
    }
}
