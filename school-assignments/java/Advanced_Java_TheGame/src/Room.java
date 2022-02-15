/* - Ha unika namn
- ett inventory för rummet
- showMethod() som beskriver vad som finns för spelaren
 */

public class Room {

    private String name; // Rummets namn
    private String description;  // Rummets beskrivning
    private Inventory inventory;
    private Person[] person;

    public Room(String roomName, String roomDescription) {
        this.person = new Person[5];
        this.name = roomName;
        this.description = roomDescription;
        this.inventory = new Inventory(5);
    }

    public String toString(){
        return name + " : " + description +"\n" +inventory;
    }

    public void addObject(GameObject go){
        this.inventory.addObject(go);
    }

    public void addNpc(Person person){
        this.person[0] = person; //TODO Fixa fler personer, som i inventory listan, kolla lediga platser och lägg till ifall null
    }

    public Person getPersons(int i){
        if (this.person[0] == null){
            this.person[0] = new Person("Ghost", i);
        }
        return this.person[0];
    }

    public Inventory getInventory(){
        return this.inventory;
    }
}
