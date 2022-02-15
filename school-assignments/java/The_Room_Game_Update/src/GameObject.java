/*
 - Ska hantera alla icke levenade objekt (möbler, nycklar etc)
 - GameObject ska innehålla en boolean som,
 - avgör om objektet går att ta med sig eller det är fastmonterat i rummet
 */

public class GameObject {



    private String name;
    boolean movable;

    public  GameObject(String name, boolean moveable){
        this.name = name;
        this.movable = moveable;
    }

    public String toString(){
        return this.name;
    }

    public String getName(){
        return this.name;
    }

    public String returnNameOfObject(){
        return this.name;
    }
}
