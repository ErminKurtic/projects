public class Person extends Npc implements Runnable{

    private int position;

    public Person(String name, int startRoom){
        super(name);
        this.position = startRoom;
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

    public synchronized void move(int x){
        this.position =x;
    }

    @Override
    public void run(){
        int rand = (int)(Math.random()*100)+1;
        if(rand<50 && this.position !=0){
            this.position -= 1;
            System.out.println(this.name + " goes to position: " + this.position);
        }
        else {
            this.position +=1;
            System.out.println(this.name + " goes to position: "+ this.position);
        }
    }
}
