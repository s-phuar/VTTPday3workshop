package monster;

public class Link {

    //*******hitting based on type**********
    //public void hit(Monster m){
    //    m.damage(5);
    //}
    //public void hit(Box b){
    //    b.setIntegrity(b.getIntegrity() - 5);
    //}

    //accept any object that implements the damageable interface
    //hitting based on damageable trait
    //link can hit anything 'd' being the monster that is damageable
    public void hit(Damageable d){
        d.damage(5);
    }




}
