abstract class Character {

    public void takeTurn() {
        startTurn();
        performAction();
        endTurn();
    }
     
    protected abstract void startTurn();
     
    protected abstract void performAction();
     
    protected abstract void endTurn();
}
 
class Hitesh extends Character {
     
    @Override
    protected void startTurn() {
        System.out.println("Hitesh is preparing for the turn.");
    }
 
    @Override
    protected void performAction() {
        System.out.println("Hitesh is attacking with a sword.");
    }
 
    @Override
    protected void endTurn() {
        System.out.println("Hitesh is resting after the turn.");
    }
}
 
class Sravya extends Character {
     
    @Override
    protected void startTurn() {
        System.out.println("Sravya is focusing energy for the turn.");
    }
 
    @Override
    protected void performAction() {
        System.out.println("Sravya is casting a spell.");
    }
 
    @Override
    protected void endTurn() {
        System.out.println("Sravya is recovering after the turn.");
    }
}
 

public class Main2 {
    public static void main(String[] args) {
        Character Hitesh = new Hitesh();
        Character Sravya = new Sravya();

        System.out.println("Hitesh's Turn:");
        Hitesh.takeTurn();
         
        System.out.println("\nsravya's Turn:");
        Sravya.takeTurn();
    }
}