/*
- Subklass till GameObject
- Låsa upp containers
- keyobjektet ska hålla koll på vilken instans av container den passar, eller tvärtom
 */

public class Key extends GameObject {

    Container container;

    public Key(String name, boolean moveable, Container c){
        super(name, moveable);
        this.container = c;
    }

    public boolean doesItFit(Container c){
        if (this.container.getName().equals(c.getName())){
            return true;
        }
        else {
            return false;
        }
    }
}
