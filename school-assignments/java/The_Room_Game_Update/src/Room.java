/* - Ha unika namn
- ett inventory för rummet
- showMethod() som beskriver vad som finns för spelaren
 */

import java.util.Arrays;
import java.util.List;

public class Room {

    private String name; // Rummets namn
    private String description;  // Rummets beskrivning
    private Inventory inventory;
    private Person[] person;
    private int npcCounter;
    private boolean isPlayerInRoom;

    public Room(String roomName, String roomDescription) {
        this.person = new Person[5];
        this.name = roomName;
        this.description = roomDescription;
        this.inventory = new Inventory(5);
        this.npcCounter = 0;
        this.isPlayerInRoom = false;
    }

    public void setBoolean(){
        this.isPlayerInRoom = !this.isPlayerInRoom;
    }

    public String toString(){
        return name + " : " + description +"\n" +inventory;
    }

    public void addObject(GameObject go){
        this.inventory.addObject(go);
    }

    public  void addNpc(Person person){
        this.person[this.npcCounter++] = person; //TODO Fixa fler personer, som i inventory listan, kolla lediga platser och lägg till ifall null
        //System.out.println("PERSON TO ADD" + person.toString());
    }

    public void removeNpc(Person person){
        //System.out.println("BEFORE" + this.person.length);
        printNpc();
        int index =  -1;
        for(int i = 0; i < this.npcCounter; i++){
            if(this.person[i].name.equals(person.getName())){
                index = i;
            }
        }
        if(index != -1){
            for (int i = index; i < this.person.length - 1; i++){
                this.person[index] = this.person[index + 1];
            }
            /*Person[] copy = new Person[this.person.length - 1];  // Kopierar arrayen
            System.arraycopy(this.person, 0, copy, 0, index);
            System.arraycopy(this.person, index+1, copy, index, this.person.length - index-1);*/
         /*   List<Person> personList = Arrays.asList(this.person);
            personList.remove(index);
            personList.toArray(new Person[index]);*/
            this.npcCounter--;
            //this.person = copy;
            //System.out.println("REMOVE PERSON!");
        }
        //System.out.println("- AFTER -" + this.person.length);
        printNpc();
    }

    public  Person[] getPersons(int i){  // Vi skapar tom person som representerar ett tomt rum, istället för att hanter null-värde
       /* if (this.person[0] == null){
            this.person[0] = new Person("Ghost", i, this);
        }*/
        return this.person;
    }

    public  Inventory getInventory(){
        return this.inventory;
    }

    public boolean isPlayerInCurrentRoom() {
        return isPlayerInRoom;
    }

    public void printNpc(){
        for (Person person:this.person
             ) {
            if (person != null) {
                System.out.println("-->" + person.toString());
            }
        }
    }
}
