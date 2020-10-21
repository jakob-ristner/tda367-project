package model;

import java.util.ArrayList;
import java.util.List;

/**
 * This is where we create our Kharacters. We are using a factory class so that our hard coded characters are located
 * at the same place. Kharacter constructor has a string and an int[] as parameters more info->Kharacter.
 */

public abstract class KharacterFactory {

    public static Kharacter createRufus(){
        return (new Kharacter("Rufus von Gross",new int[]{2,2,3,6}));

    }
    public static Kharacter createMedera(){
        return (new Kharacter("Medera Calvados",new int[]{3,6,2,2}));

    }
    public static Kharacter createSarah(){
        return (new Kharacter("Sarah Woodstock",new int[]{6,2,6,2}));

    }
    public static Kharacter createSven(){
        return (new Kharacter("Sven Nordstadt",new int[]{3,3,4,3}));

    }

    public static Kharacter createDebugKhar(){
        return (new Kharacter("Debug", new int[]{99,99,99,99}));
    }
    public static List<Kharacter> getCharacters(){
        List<Kharacter> kharacters = new ArrayList<>();
        kharacters.add(createMedera());
        kharacters.add(createRufus());
        kharacters.add(createSven());
        kharacters.add(createSarah());
        kharacters.add(createDebugKhar());
        return kharacters;
    }


}
