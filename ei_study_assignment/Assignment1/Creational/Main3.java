class Singleton {
    private static Singleton single_instance = null;

    public String s;

    private Singleton()
    {
        s = "Hello everyone, This is Sai Hitesh";
    }
 

    public static Singleton Singleton()
    {

        if (single_instance == null) {
            single_instance = new Singleton();
        }
        return single_instance;
    }
}
 
// Class 2
// Main class
class Main3 {

    public static void main(String args[])
    {
        Singleton x = Singleton.Singleton();
 
        Singleton y = Singleton.Singleton();

        Singleton z = Singleton.Singleton();

        x.s = (x.s).toUpperCase();

        System.out.println("String from x is " + x.s);
        System.out.println("String from y is " + y.s);
        System.out.println("String from z is " + z.s);
        System.out.println("\n");
 

        z.s = (z.s).toLowerCase();
 
        System.out.println("String from x is " + x.s);
        System.out.println("String from y is " + y.s);
        System.out.println("String from z is " + z.s);
    }
}