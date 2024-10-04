package monster;

//java can only do single inheritance
public class Godzilla extends Monster {
    
    @Override
    public void damage(int damage){
        int hitPoints = getHitPoints();
        setHitPoint(hitPoints - damage + 1);
    }

    public Godzilla(){
        setName("Godzilla");
        setHitPoint(100);
    }



}
