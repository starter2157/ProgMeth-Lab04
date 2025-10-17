package entity.container;

import entity.base.Container;
import entity.base.Cookable;
import entity.base.Ingredient;

import java.util.ArrayList;

public class Pan extends Container {

    public Pan(){
        super("Pan", 1);
    }

    public boolean verifyContent(Ingredient i){
        return i instanceof Cookable;
    }

    public void cook(){
        if(!isEmpty()){
            ArrayList<Ingredient> items = getContent();
            for(Ingredient item : items){
                ((Cookable) item).cook();
            }
        }
    }
}
