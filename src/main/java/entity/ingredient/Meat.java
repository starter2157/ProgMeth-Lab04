package entity.ingredient;

import entity.base.Choppable;
import entity.base.Cookable;
import entity.base.Ingredient;
import logic.StringUtil;

public class Meat extends Ingredient implements Choppable, Cookable {

    private boolean chopState;
    private int cookedPercentage;

    public Meat(){
        super("Meat");
        this.chopState = false;
        setCookedPercentage(0);
    }

    public void chop(){
        if(!isChopped() || cookedPercentage != 0){
            this.setName("Minced Meat");
            this.chopState = true;
        }
    }

    public void cook(){
        if(!isChopped()) {
            setCookedPercentage(getCookedPercentage() + 10);
            if (getCookedPercentage() <= 50) {
                setName("Raw Meat");
                setEdible(false);
            } else if (getCookedPercentage() <= 80) {
                setName("Medium Rare Steak");
                setEdible(true);
            } else if (getCookedPercentage() <= 100) {
                setName("Well Done Steak");
                setEdible(true);
            } else {
                setName("Burnt Steak");
                setEdible(false);
            }
        } else {
            setCookedPercentage(getCookedPercentage() + 15);
            if (getCookedPercentage() <= 80) {
                setName("Raw Burger");
                setEdible(false);
            } else if (getCookedPercentage() <= 100) {
                setName("Cooked Burger");
                setEdible(true);
            } else {
                setName("Burnt Burger");
                setEdible(false);
            }
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

    public boolean isChopped(){
        return chopState;
    }
}
