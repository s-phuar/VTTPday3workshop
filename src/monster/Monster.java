package monster;
public class Monster implements Damageable{
    private String name;
    private int hitPoints;

    public String getName(){return name;}
    public void setName(String name) {this.name = name;}
    public int getHitPoints() {return hitPoints;}
    public void setHitPoint(int hitPoints) {this.hitPoints = hitPoints;}

    //methods that implements damageable interface, implemented the trait damageable
    public void damage(int damage){
        this.hitPoints -= damage;
    }
    public int getDamage(){return this.hitPoints;}
    

    @Override
    public String toString(){
        return "Monster{name=%s, hitPoints=%d}".formatted(name, hitPoints);
    }
    


}
