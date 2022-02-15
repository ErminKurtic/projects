/*
- Kickar igång allt här
- Spelloop -> Kommandon -> Uppdaterar spelet
 */

import java.util.Arrays;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Game {
    private Gui gui;
    private Room room1, room2, room3, room4;
    private Room[] map;
    boolean gameOn = true;
    boolean hasKey = false;

    public Game(){

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
        Person Springpojke = new Person("Springpojke", 1);
        room1.addNpc(Springpojke);
        Springpojke.getInventory().addObject(svamp);



        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(10);
        pool.scheduleAtFixedRate(Springpojke, 5, 5, TimeUnit.SECONDS);



        //- - - Inventory - - -
        Inventory playerInventory = new Inventory(5);


        //- - - Starta GUI:t - - -
        this.gui = new Gui();

        int position = 0;
        gui.setShowRoom(map[position].toString()); //Visa position i rumarrayen



        while (gameOn){

            String command = gui.getCommand();
            String[] choice = command.split("\\s", 2);

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
                    GameObject temp = map[0].getInventory().getGameObject(choice[1]);
                    if (position == 0) {
                        map[0].getInventory().findAndRemoveItem(choice[1]);
                        playerInventory.addObject(temp);
                        System.out.println(playerInventory);
                    }
                    else if (position == 1){
                        map[1].getInventory().findAndRemoveItem(choice[1]);
                        playerInventory.addObject(temp);
                        System.out.println(playerInventory);
                    }
                    else if (position == 2){
                        map[2].getInventory().findAndRemoveItem(choice[1]);
                        playerInventory.addObject(temp);
                        System.out.println(playerInventory);
                    }
                    else {
                        map[3].getInventory().findAndRemoveItem(choice[1]);
                        playerInventory.addObject(temp);
                        System.out.println(playerInventory);
                    }

                    if (temp == key){
                        System.out.println("YOU GOT THE KEY! NOW RUN TO ROOM 4 AND EXIT!");
                        hasKey = true;
                    }
                    updateGUI(Springpojke, position);
                    gui.gotCommand();
                    break;

                case "exit":
                    if (hasKey == true && position == 3){
                        System.out.println("YOU GOT OUT!!!");
                        gameOn = false;
                    }
                    gui.gotCommand();
                    break;

            }

            gui.setShowRoom(map[position].toString());
            gui.setShowInventory(playerInventory);

            if (map[position].getPersons(position) != null) { //Om map-positionen inte är null
            gui.setPerson(map[position].getPersons(position)); //Finns personen i rummet, printa den då på GUI
            }
        }


    }

    private void updateGUI(Person Springpojke, int position) {
        gui.setPerson(map[position].getPersons(position));
    }


}