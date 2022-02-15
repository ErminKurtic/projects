class myObject {

    Boolean bool = false;
    int value;
    String name;

    public myObject(Boolean bool, int value, String name){
        this.bool = bool;
        this.value = value;
        this.name = name;
    }

    public String toString(){
        return ("Boolean: " + this.bool + " " + "Name: " + this.name + " " + "Value: " + this.value + "\n");
    }

    public Boolean getBool(){
        return bool;
    }
    public int getValue(){
        return value;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}