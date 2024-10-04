package monster;

public class Main {

    public static void main (String[] args){
        Monster m = new Monster();
        m.setName("Kaiju no 8");
        m.setHitPoint(100);

        System.out.println(m);

        //get hit
        Link link = new Link();
        link.hit(m);
        System.out.println(m);

        //Godzilla arrives and gets hit by link
        Godzilla g = new Godzilla();
        System.out.println(g);
        link.hit(g);
        System.out.println(g);


        Box b = new Box();
        link.hit(b);

        //dog does not have damagable trait
        //Dog dog = new Dog();
        //Link.hit(dog);

    }
    
}
