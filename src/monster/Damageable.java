package monster;
    //better to identify objects by their traits(e.g damagable v invunerable v touchable) and not by type(e.g box v monster)
    //lets use interfaces, we have the ability to attach traits to classes now, without needing to identify the class
    //interfaces hide/grants implementations of traits(e.g. start v stop v reverse) a.k.a programming by contract

    //**********only write the signature of start and stop, not the body************
    //Note an interface cannot be instantiated, it is NOT a class
    //but classes can implement multiple interfaces
    //public interface Startable{
        //public void start();
        // public void stop();
    //}

    //public class Car implements Startable{
        //public void start() {....}
        //public void stop() {....}
    //}
public interface Damageable {

    //no implementation, e.g. no body and { }
    public void damage(int damage);
    public int getDamage();
    
}
