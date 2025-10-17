package entity.ingredient;

import entity.base.Cookable;
import entity.base.Ingredient;
import logic.StringUtil;

public class Egg extends Ingredient implements Cookable {

    private int cookedPercentage;

    public Egg(){
        super("Egg");
        setCookedPercentage(0);
    }

    public void cook(){
        setCookedPercentage(getCookedPercentage() + 12);
        if(getCookedPercentage() <= 50){
            setName("Raw Egg");
            setEdible(false);
        } else if(getCookedPercentage() <= 80){
            setName("Sunny Side Egg");
            setEdible(true);
        } else if(getCookedPercentage() <= 100){
            setName("Fried Egg");
            setEdible(true);
        } else {
            setName("Burnt Egg");
            setEdible(false);
        }
    }

    public boolean isBurnt(){
        return getCookedPercentage() > 100;
    }

    public String toString(){
        return StringUtil.formatNamePercentage(getName(), getCookedPercentage());
    }

    public int getCookedPercentage() {
        return cookedPercentage;
    }

    public void setCookedPercentage(int cookedPercentage) {
        this.cookedPercentage = Math.max(0, cookedPercentage);
    }
}
