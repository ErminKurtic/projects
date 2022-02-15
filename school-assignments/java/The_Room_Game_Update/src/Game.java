/*
- Kickar igång allt här
- Spelloop -> Kommandon -> Uppdaterar spelet
 */

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Game {
    private Gui gui;
    private Room room1, room2, room3, room4;
    private Room[] map;
    boolean gameOn = true;
    boolean hasKey = false;

    public Game(){

        //- - - Starta GUI:t - - -
        this.gui = new Gui();

        int position = 0;

        //Skapa rum-variable först med konstruktor parametrarna NAMN + BESKRIVNING!
        room1 = new Room("[1]. Entry", "Beautiful entry, with some stuff lying around.");
        room2 = new Room("[2]. Hallway", "Narrow hallway connecting to another room.");
        room3 = new Room("[3]. Living Room", "Beautiful room with decors.");
        room4 = new Room("[4]. Kitchen", "You see an EXIT, but you need a key...");

        map = new Room[4]; // <- - - - -
        map[0] = room1;
        map[1] = room2;
        map[2] = room3;
        map[3] = room4;

        map[0].setBoolean(); // True/False om spelar är i rummet eller ej

        //- - - GameObjects - - -
        GameObject lampa = new GameObject("lampa", false);
        GameObject key = new GameObject("key", true);
        GameObject kanin = new GameObject("kanin", true);
        GameObject kaka = new GameObject("kaka", true);
        GameObject svamp = new GameObject("svamp", true);
        Container box = new Container("box", false, true);

        room1.addObject(kanin);
        room1.addObject(box);
        room2.addObject(lampa);
        room2.addObject(box);
        room3.addObject(lampa);
        room1.addObject(key);
        room4.addObject(kaka);

        // - - - NPC's - - -
        Person Springpojke = new Person("Springpojke", 1, map, gui);
        //room1.addNpc(Springpojke);
        Springpojke.getInventory().addObject(svamp);

       /* Person Hejsan = new Person("Hejsan", 3, map, gui);
        room3.addNpc(Hejsan);*/



        //- - - Inventory - - -
        Inventory playerInventory = new Inventory(5);


        gui.setShowRoom(map[position].toString()); //Visa position i rumarrayen

        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(10);
        pool.scheduleAtFixedRate(Springpojke, 2, 5, TimeUnit.SECONDS);

        //pool.scheduleAtFixedRate(Hejsan, 2, 3, TimeUnit.SECONDS);

        updatePlayerGui(position, playerInventory);

        while (gameOn){

            String command = gui.getCommand();
            String[] choice = command.split("\\s", 2);
            map[position].setBoolean();
            switch (choice[0]){

                case "1":
                    position = 0;
                    updateGUI(Springpojke, position);
                    gui.gotCommand();
                    break;

                case "2":
                    position = 1;
                    updateGUI(Springpojke, position);
                    gui.gotCommand();
                    break;

                case "3":
                    position = 2;
                    updateGUI(Springpojke, position);
                    gui.gotCommand();
                    break;

                case "4":
                    position = 3;
                    updateGUI(Springpojke, position);
                    gui.gotCommand();
                    break;

                case "pickup":

                    GameObject temp = map[position].getInventory().getGameObject(choice[1]);

                    if (position == 0) {
                        handlePickUpItem(position, map, choice[1], temp, playerInventory);
                        /*gotRemoved = map[0].getInventory().findAndRemoveItem(choice[1]);
                        if (gotRemoved) {
                            playerInventory.addObject(temp);
                        }
                        System.out.println(playerInventory);*/
                    }
                    else if (position == 1){
                        handlePickUpItem(position, map, choice[1], temp, playerInventory);
                    }
                    else if (position == 2){
                        handlePickUpItem(position, map, choice[1], temp, playerInventory);
                    }
                    else {
                        handlePickUpItem(position, map, choice[1], temp, playerInventory);
                    }

                    if (temp == key){
                        System.out.println("\n - - - - - - - - - - - - ");
                        System.out.println("YOU GOT THE KEY! NOW RUN TO ROOM 4 AND EXIT!");
                        System.out.println(" - - - - - - - - - - - - \n");
                        hasKey = true;
                    }
                    updateGUI(Springpojke, position);
                    gui.gotCommand();
                    break;

                case "drop":

                    GameObject temp2 = playerInventory.getGameObject(choice[1]);

                    if (position == 0) {
                        handleDropItem(position, map, choice[1], temp2, playerInventory);
                        /*gotRemoved = map[0].getInventory().findAndRemoveItem(choice[1]);
                        if (gotRemoved) {
                            playerInventory.addObject(temp);
                        }
                        System.out.println(playerInventory);*/
                    }
                    else if (position == 1){
                        handleDropItem(position, map, choice[1], temp2, playerInventory);
                    }
                    else if (position == 2){
                        handleDropItem(position, map, choice[1], temp2, playerInventory);
                    }
                    else {
                        handleDropItem(position, map, choice[1], temp2, playerInventory);
                    }
                    updateGUI(Springpojke, position);
                    gui.gotCommand();
                    break;


                case "exit":
                    if (hasKey == true && position == 3){
                        System.out.println("\n - - - - - - - - - - - - ");
                        System.out.println("YOU GOT OUT!!!");
                        System.out.println(" - - - - - - - - - - - - \n");
                        gameOn = false;
                    }
                    gui.gotCommand();
                    break;

            }

            updatePlayerGui(position, playerInventory);
        }


    }

    private void handleDropItem(int position, Room[] map, String choice, GameObject temp2, Inventory playerInventory) {

        boolean gotRemoved = playerInventory.findAndRemoveItem(choice);
        if (gotRemoved && temp2 != null) {
            //System.out.println("- TRYING TO REMOVE ITEM - ");
            map[position].getInventory().addObject(temp2);
        }
        System.out.println(playerInventory);
    }

    private void handlePickUpItem(int position, Room[] map, String choice, GameObject temp, Inventory playerInventory) {

        boolean gotRemoved = map[position].getInventory().findAndRemoveItem(choice);
        if (gotRemoved && temp != null) {
            playerInventory.addObject(temp);
        }
        System.out.println(playerInventory);
    }


    private void updatePlayerGui(int position, Inventory playerInventory) {
        gui.setShowRoom(map[position].toString());
        gui.setShowInventory(playerInventory);

        if (map[position].getPersons(position) == null) { //Om map-positionen inte är null
            gui.setPerson(map[position].getPersons(position)); //Finns personen i rummet, printa den då på GUI
        }
    }

    private void updateGUI(Person Springpojke, int position) {
        gui.setPerson(map[position].getPersons(position));
    }


}