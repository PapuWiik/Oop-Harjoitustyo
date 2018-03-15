package harjoitustyo;

public class Main {
    public static void main (String[] args) {
        
        try {
            new Game();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}