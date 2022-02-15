/*
- Lista/Array av Npc's
- Beteende bestäms av randomizer
- De rör sig mellan rummen, plockar upp, lägger ned saker
- Ska finnas en "showPerson" -> visar personens namn och vad de bär på
 */

public abstract class Npc {
    String name;
    Inventory inventory;

    public Npc(String name){
        this.name = name;
        this.inventory = new Inventory(1);
    }

    public Inventory getInventory(){ return this.inventory;
    }

    public String toString(){
        return this.name + " is carrying " +this.inventory;
    }

    public String getName(){return this.name;}
}
