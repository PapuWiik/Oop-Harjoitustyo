package harjoitustyo;

import java.util.ArrayList;

public class Player {
    
    //Pelaajan attribuutit
    protected ArrayList<Character> characters = new ArrayList<>();
    protected String[] qlist = { "Glasses?", "Hairband?", "Blonde hair?", "Light brown hair?", "Dark brown hair?", "Ginger hair?", "Cap?", "Hair loose?", "Red shirt?", "Yellow shirt?", "Blue shirt?", "Orange shirt?", "Green shirt?"};
    protected boolean honest = true;
    
    //Konstruktori
    public Player() {
    }
    
    //Tarpeelliset getterit ja setterit
    protected void setCharacter(ArrayList<Character> al) {
        characters = al;
    }
    
    /* Pelaajan metodi, jolla kysytään kysymys
    
    Parametreina annettava esitetyn kysymyksen indeksi int i sekä tietokoneolio,
    jota vastaan pelataan. Metodi palauttaa booleanin sen mukaan, vastaako kysymys
    tietokoneen hahmon piirteitä.
    */
    public boolean askQuestion(int i, Computer c) {
        if (i == 0 && characters.get(c.getCharacter()).glasses == true) {
            return true;
        }
        else if (i == 1 && characters.get(c.getCharacter()).hairBand == true) {
            return true;
        }
        else if (i == 2 && characters.get(c.getCharacter()).hairColor == "blonde") {
            return true;
        }
        else if (i == 3 && characters.get(c.getCharacter()).hairColor == "light brown") {
            return true;
        }
        else if (i == 4 && characters.get(c.getCharacter()).hairColor == "dark brown") {
            return true;
        }
        else if (i == 5 && characters.get(c.getCharacter()).hairColor == "ginger") {
            return true;
        }
        else if (i == 6 && characters.get(c.getCharacter()).cap == true) {
            return true;
        }
        else if (i == 7 && characters.get(c.getCharacter()).looseHair == true) {
            return true;
        }
        else if (i == 8 && characters.get(c.getCharacter()).shirtColor == "red") {
            return true;
        }
        else if (i == 9 && characters.get(c.getCharacter()).shirtColor == "yellow") {
            return true;
        }
        else if (i == 10 && characters.get(c.getCharacter()).shirtColor == "blue") {
            return true;
        }
        else if (i == 11 && characters.get(c.getCharacter()).shirtColor == "orange") {
            return true;
        }
        else if (i == 12 && characters.get(c.getCharacter()).shirtColor == "green") {
            return true;
        }
        else {
            return false;
        }
    }
}