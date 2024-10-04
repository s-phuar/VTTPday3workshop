package monster;

public class Box implements Damageable{

    private int integrity = 3;

    public int getIntegrity() {return integrity;}
    public void setIntegrity(int integrity) {this.integrity = integrity;}
    
    //methods ("Contracts") that implement the Damageable interface, granting them 'traits'
    public void damage(int damage){
        integrity -= damage;
    }
    
    public int getDamage() {return this.integrity;}
    

}
