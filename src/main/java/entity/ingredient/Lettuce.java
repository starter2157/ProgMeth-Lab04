package entity.ingredient;

import entity.base.Choppable;
import entity.base.Ingredient;

public class Lettuce extends Ingredient implements Choppable {

    private boolean chopState;

    public Lettuce(){
        super("Lettuce");
        this.setEdible(true);
        this.chopState = false;
    }

    public void chop(){
        if(!isChopped()){
            this.setName("Chopped Lettuce");
            this.chopState = true;
        }
    }

    public boolean isChopped(){
        return chopState;
    }
}
