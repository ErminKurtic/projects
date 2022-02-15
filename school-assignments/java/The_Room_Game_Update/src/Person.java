public class Person extends Npc implements Runnable{

    private int position;
    private Room[] map;
    private Gui gui;

    public Person(String name, int startRoom, Room[] map, Gui gui){
        super(name);
        this.position = startRoom;
        this.map = map;
        this.gui = gui;
        this.map[this.position].addNpc(this);
        run();

    }

    public void setCurrentRoom(int i){
        this.position = i;
    }

    public int getCurrentRoom(){
        return this.position;
    }

    public void show(){
        System.out.println(this.name + " befinner sig i position "+ this.position);
    }

    public  void move(int x){
        this.position =x;
    }

    @Override
    public void run(){
        //Ta bort person från rummet
        this.map[this.position].removeNpc(this);

        int rand = (int)(Math.random()*100)+1;
        if(rand<50 && this.position !=0){
            this.position -= 1;
            System.out.println("\n - - - - - - - - - - - - ");
            System.out.println(this.name + " goes to position: " + this.position);
            System.out.println(" - - - - - - - - - - - - \n");
        }
        else if(this.position != 3){
            this.position +=1;
            System.out.println("\n - - - - - - - - - - - - ");
            System.out.println(this.name + " goes to position: "+ this.position);
            System.out.println(" - - - - - - - - - - - - \n");
        }
        //Lägg till person i rummet
        this.map[this.position].addNpc(this);

        if(this.map[this.position].isPlayerInCurrentRoom()){
            this.gui.setShowRoom(this.map[this.position].toString());
            //this.gui.setShowPersons(this);
            if (map[position].getPersons(position) == null) { //Om map-positionen inte är null
                gui.setPerson(map[position].getPersons(position)); //Finns personen i rummet, printa den då på GUI
            }
        }
    }
}
