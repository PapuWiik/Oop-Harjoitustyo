package harjoitustyo;

import java.io.Serializable;

public class Character implements Serializable {
    
    //Hahmon attribuutit
    protected int number;
    protected boolean glasses;
    protected String hairColor;
    protected boolean cap;
    protected boolean looseHair;
    protected boolean hairBand;
    protected String shirtColor;
    
    //Hahmon konstruktorit, joista toisessa kaikki sen arvot jätetään tyhjiksi
    public Character(int number) {
        this.number = number;
    }
    
    public Character(int number, boolean glasses, String hairColor, boolean cap, boolean looseHair, boolean hairBand, String shirtColor) {
        this.number = number;
        this.glasses = glasses;
        this.cap = cap;
        this.looseHair = looseHair;
        this.hairBand = hairBand;
        this.hairColor = hairColor;
        this.shirtColor = shirtColor;
    }
    
    //Tarpeelliset getterit ja setterit
    public int getNumber() {
        return number;
    }
    
    private void setNumber(int number) {
        this.number = number;
    }
    
    protected void setGlasses(boolean glasses) {
        this.glasses = glasses;
    }
    protected void setHairColor(String hairColor) {
        if (hairColor == "dark brown" || hairColor == "light brown" || hairColor == "blonde" || hairColor == "ginger") {
            this.hairColor = hairColor;
        }
    }
    protected void setCap (boolean cap) {
        this.cap = cap;
    }
    protected void setLooseHair(boolean looseHair) {
        this.looseHair = looseHair;
    }
    protected void setHairBand(boolean hairBand) {
        this.hairBand = hairBand;
    }
    protected void setShirtColor(String shirtColor) {
        if (shirtColor == "red" || shirtColor == "blue" || shirtColor == "yellow" || shirtColor == "green" || shirtColor == "orange") {
            this.shirtColor = shirtColor;
        }   
    }
}

//Alta löytyvät hahmon perivät mies ja nainen luokat sekä niiden konstruktorit
class Male extends Character {
    final int sex = 0;

    public Male(int number) {
        super(number);
    }
    
    public Male(int number, boolean glasses, String hairColor, boolean cap, boolean looseHair, boolean hairBand, String shirtColor) {
        super(number, glasses, hairColor, cap, looseHair, hairBand, shirtColor);
    }
}

class Female extends Character {
    final int sex = 1;
    
    public Female(int number) {
        super(number);
    }
    
    public Female(int number, boolean glasses, String hairColor, boolean cap, boolean looseHair, boolean hairBand, String shirtColor) {
        super(number, glasses, hairColor, cap, looseHair, hairBand, shirtColor);
    }
}