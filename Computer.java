package harjoitustyo;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

public class Computer {
    
    //Tietokoneen attribuutit
    protected ArrayList<Character> characters = new ArrayList<>();
    protected int character;
    protected ArrayList<String> qlist2 = new ArrayList<>();
    protected ArrayList<Character> delete = new ArrayList<>();
    int x = 13;
    
    //Tietokoneen konstruktori, joka arpoo tietokoneelle yhden hahmoista sekä asettaa mahdolliset kysymykset
    public Computer() {
        Random rnd = new Random();
        character = rnd.nextInt(15);
        qlist2.add("Glasses?");
        qlist2.add("Hairband?");
        qlist2.add("Blonde hair?");
        qlist2.add("Light brown hair?");
        qlist2.add("Dark brown hair?");
        qlist2.add("Ginger hair?");
        qlist2.add("Cap?");
        qlist2.add("Hair loose?");
        qlist2.add("Red shirt?");
        qlist2.add("Yellow shirt?");
        qlist2.add("Blue shirt?");
        qlist2.add("Orange shirt?");
        qlist2.add("Green shirt?");
    }
    
    //Tarpeelliset getterit ja setterit
    public void setCharacter(ArrayList<Character> al) {
        characters = al;
    }
    
    public int getCharacter() {
        return character;
    }
    
    public void setCharacter(int i) {
        character = i;
    }
    
    public Computer getComputer() {
        return this;
    }
    
    public ArrayList<Character> getCharacters() {
        return characters;
    }
    
    public ArrayList<Character> getDeletableCharacters() {
        return delete;
    }
    
    public ArrayList<String> getQuestions() {
        return qlist2;
    }
    
    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    } 
    
    public void setQuestions(ArrayList<String> qlist2) {
        this.qlist2 = qlist2;
    }
    
    public void setDeletableCharacters(ArrayList<Character> delete) {
        this.delete = delete;
    }
    
    protected int chooseCharacter() {
        Random rnd = new Random();
        int i = rnd.nextInt(17);
        return i;
    }    
    
   /*Metodi, jota kutsumalla tietokone esittää kysymyksen
    
    Jokainen mahdollinen kysymys on kirjoitettu koodissa erikseen, jotta
    tietokoneesta tulee "älykäs pelaaja", ts. tietokone ei kysy ensin "Punainen paita?",
    johon vastataan kyllä, ja tämän jälkeen "Keltainen paita?"
    */
    
    public void askQuestion() {
        try {
            Random rnd = new Random();
            int i = rnd.nextInt(x);
            if (JOptionPane.showConfirmDialog(null,
            "Computer asks you: " + qlist2.get(i), "Your Answer", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (qlist2.get(i) == "Glasses?") {
                    for (Character c : characters) {
                        if (c.glasses == false) {
                            if (delete.indexOf(c) == -1) {
                                delete.add(c);
                            }
                        }
                    }
                    qlist2.remove("Glasses?");
                    qlist2.remove("Ginger hair?");
                    qlist2.remove("Red shirt?");
                    qlist2.remove("Yellow shirt?");
                    qlist2.remove("Cap?");
                    x = x - 5;
                }
                else if (qlist2.get(i) == "Hairband?") {
                    for (Character c : characters) {
                        if (c.hairBand == false) {
                            if (delete.indexOf(c) == -1) {
                                delete.add(c);
                            }
                        }
                    }
                    qlist2.remove("Hairband?");
                    qlist2.remove("Ginger hair?");
                    qlist2.remove("Blonde hair?");
                    qlist2.remove("Cap?");
                    qlist2.remove("Red shirt?");
                    qlist2.remove("Green shirt?");
                    x = x - 6;   
                }
                else if (qlist2.get(i) == "Blonde hair?") {
                    for (Character c : characters) {
                        if (c.hairColor != "blonde") {
                            if (delete.indexOf(c) == -1) {
                                delete.add(c);
                            }
                        }
                    }
                    qlist2.remove("Blonde hair?");
                    qlist2.remove("Dark brown hair?");
                    qlist2.remove("Light brown hair?");
                    qlist2.remove("Ginger hair?");
                    qlist2.remove("Cap?");
                    qlist2.remove("Hairband?");
                    qlist2.remove("Yellow shirt?");
                    x = x - 7;    
                }
                else if (qlist2.get(i) == "Light brown hair?") {
                    for (Character c : characters) {
                        if (c.hairColor != "light brown") {
                            if (delete.indexOf(c) == -1) {
                                delete.add(c);
                            }
                        }
                    }
                qlist2.remove("Blonde hair?");
                qlist2.remove("Dark brown hair?");
                qlist2.remove("Light brown hair?");
                qlist2.remove("Ginger hair?");
                qlist2.remove("Yellow shirt?");
                qlist2.remove("Red shirt?");
                x = x - 6;    
            }
            else if (qlist2.get(i) == "Dark brown hair?") {
                for (Character c : characters) {
                    if (c.hairColor != "dark brown") {
                        if (delete.indexOf(c) == -1) {
                            delete.add(c);
                        }
                    }
                }
                qlist2.remove("Blonde hair?");
                qlist2.remove("Dark brown hair?");
                qlist2.remove("Light brown hair?");
                qlist2.remove("Ginger hair?");
                qlist2.remove("Blue shirt?");
                x = x - 5;    
            }
            else if (qlist2.get(i) == "Ginger hair?") {
                for (Character c : characters) {
                    if (c.hairColor != "ginger") {
                        if (delete.indexOf(c) == -1) {
                            delete.add(c);
                        }
                    }
                }
                qlist2.remove("Blonde hair?");
                qlist2.remove("Dark brown hair?");
                qlist2.remove("Light brown hair?");
                qlist2.remove("Ginger hair?");
                qlist2.remove("Red shirt?");
                qlist2.remove("Yellow shirt?");
                qlist2.remove("Orange shirt?");
                qlist2.remove("Cap?");
                qlist2.remove("Hairband?");
                x = x - 9;    
            }
            else if (qlist2.get(i) == "Cap?") {
                for (Character c : characters) {
                    if (c.cap == false) {
                        if (delete.indexOf(c) == -1) {
                            delete.add(c);
                        }
                    }
                }
                qlist2.remove("Cap?");
                qlist2.remove("Yellow shirt?");
                qlist2.remove("Green shirt?");
                qlist2.remove("Blue shirt?");
                qlist2.remove("Hairband?");
                qlist2.remove("Ginger hair?");
                qlist2.remove("Blonde hair?");
                x = x - 7;   
            }
            else if (qlist2.get(i) == "Hair loose?") {
                for (Character c : characters) {
                    if (c.looseHair == false) {
                        if (delete.indexOf(c) == -1) {
                            delete.add(c);
                        }
                    }
                }
                qlist2.remove("Hair loose?");
                x = x - 1;   
            }
            else if (qlist2.get(i) == "Red shirt?") {
                for (Character c : characters) {
                    if (c.shirtColor != "red") {
                        if (delete.indexOf(c) == -1) {
                            delete.add(c);
                        }
                    }
                }
                qlist2.remove("Red shirt?");
                qlist2.remove("Yellow shirt?");
                qlist2.remove("Blue shirt?");
                qlist2.remove("Orange shirt?");
                qlist2.remove("Green shirt?");
                qlist2.remove("Glasses?");
                qlist2.remove("Hairband?");
                qlist2.remove("Light brown hair?");
                qlist2.remove("Ginger hair?");
                x = x - 9;    
            }
            else if (qlist2.get(i) == "Yellow shirt?") {
                for (Character c : characters) {
                    if (c.shirtColor != "yellow") {
                        if (delete.indexOf(c) == -1) {
                            delete.add(c);
                        }
                    }
                }
                qlist2.remove("Red shirt?");
                qlist2.remove("Yellow shirt?");
                qlist2.remove("Blue shirt?");
                qlist2.remove("Orange shirt?");
                qlist2.remove("Green shirt?");
                qlist2.remove("Glasses?");
                qlist2.remove("Cap?");
                qlist2.remove("Light brown hair?");
                qlist2.remove("Ginger hair?");
                qlist2.remove("Blonde hair?");
                x = x - 10;    
            }
            else if (qlist2.get(i) == "Blue shirt?") {
                for (Character c : characters) {
                    if (c.shirtColor != "blue") {
                        if (delete.indexOf(c) == -1) {
                            delete.add(c);
                        }
                    }
                }
                qlist2.remove("Red shirt?");
                qlist2.remove("Yellow shirt?");
                qlist2.remove("Blue shirt?");
                qlist2.remove("Orange shirt?");
                qlist2.remove("Green shirt?");
                qlist2.remove("Cap?");
                qlist2.remove("Dark brown hair?");
                x = x - 7;    
            }
            else if (qlist2.get(i) == "Orange shirt?") {
                for (Character c : characters) {
                    if (c.shirtColor != "orange") {
                        if (delete.indexOf(c) == -1) {
                            delete.add(c);
                        }
                    }
                }
                qlist2.remove("Red shirt?");
                qlist2.remove("Yellow shirt?");
                qlist2.remove("Blue shirt?");
                qlist2.remove("Orange shirt?");
                qlist2.remove("Green shirt?");
                qlist2.remove("Hairband?");
                qlist2.remove("Ginger hair?");
                qlist2.remove("Blonde hair?");
                x = x - 8;    
            }
            else if (qlist2.get(i) == "Green shirt?") {
                for (Character c : characters) {
                    if (c.shirtColor != "green") {
                        if (delete.indexOf(c) == -1) {
                            delete.add(c);
                        }
                    }
                }
                qlist2.remove("Red shirt?");
                qlist2.remove("Yellow shirt?");
                qlist2.remove("Blue shirt?");
                qlist2.remove("Orange shirt?");
                qlist2.remove("Green shirt?");
                qlist2.remove("Cap?");
                qlist2.remove("Light brown hair?");
                qlist2.remove("Hairband?");
                x = x - 8;    
            }
        }
        else {
            if (qlist2.get(i) == "Glasses?") {
                for (Character c : characters) {
                    if (c.glasses == true) {
                        if (delete.indexOf(c) == -1) {
                            delete.add(c);
                        }
                    }
                }
                qlist2.remove("Glasses?");
                x = x - 1;
            }
            else if (qlist2.get(i) == "Hairband?") {
                for (Character c : characters) {
                    if (c.hairBand == true) {
                        if (delete.indexOf(c) == -1) {
                            delete.add(c);
                        }
                    }
                }
                qlist2.remove("Hairband?");
                x = x - 1;   
            }
            else if (qlist2.get(i) == "Blonde hair?") {
                for (Character c : characters) {
                    if (c.hairColor == "blonde") {
                        if (delete.indexOf(c) == -1) {
                            delete.add(c);
                        }
                    }
                }
                qlist2.remove("Blonde hair?");
                x = x - 1;    
            }
            else if (qlist2.get(i) == "Light brown hair?") {
                for (Character c : characters) {
                    if (c.hairColor == "light brown") {
                        if (delete.indexOf(c) == -1) {
                            delete.add(c);
                        }
                    }
                }
                qlist2.remove("Light brown hair?");
                x = x - 1;    
            }
            else if (qlist2.get(i) == "Dark brown hair?") {
                for (Character c : characters) {
                    if (c.hairColor == "dark brown") {
                        if (delete.indexOf(c) == -1) {
                            delete.add(c);
                        }
                    }
                }
                qlist2.remove("Dark brown hair?");
                x = x - 1;    
            }
            else if (qlist2.get(i) == "Ginger hair?") {
                for (Character c : characters) {
                    if (c.hairColor == "ginger") {
                        if (delete.indexOf(c) == -1) {
                            delete.add(c);
                        }
                    }
                }
                qlist2.remove("Ginger hair?");
                x = x - 1;    
            }
            else if (qlist2.get(i) == "Cap?") {
                for (Character c : characters) {
                    if (c.cap == true) {
                        if (delete.indexOf(c) == -1) {
                            delete.add(c);
                        }
                    }
                }
                qlist2.remove("Cap?");
                x = x - 1;   
            }
            else if (qlist2.get(i) == "Hair loose?") {
                for (Character c : characters) {
                    if (c.looseHair == true) {
                        if (delete.indexOf(c) == -1) {
                            delete.add(c);
                        }
                    }
                }
                qlist2.remove("Hair loose?");
                x = x - 1;   
            }
            else if (qlist2.get(i) == "Red shirt?") {
                for (Character c : characters) {
                    if (c.shirtColor == "red") {
                        if (delete.indexOf(c) == -1) {
                            delete.add(c);
                        }
                    }
                }
                qlist2.remove("Red shirt?");
                x = x - 1;    
            }
            else if (qlist2.get(i) == "Yellow shirt?") {
                for (Character c : characters) {
                    if (c.shirtColor == "yellow") {
                        if (delete.indexOf(c) == -1) {
                            delete.add(c);
                        }
                    }
                }
                qlist2.remove("Yellow shirt?");
                x = x - 1;    
            }
            else if (qlist2.get(i) == "Blue shirt?") {
                for (Character c : characters) {
                    if (c.shirtColor == "blue") {
                        if (delete.indexOf(c) == -1) {
                            delete.add(c);
                        }
                    }
                }
                qlist2.remove("Blue shirt?");
                x = x - 1;    
            }
            else if (qlist2.get(i) == "Orange shirt?") {
                for (Character c : characters) {
                    if (c.shirtColor == "orange") {
                        if (delete.indexOf(c) == -1) {
                            delete.add(c);
                        }
                    }
                }
                qlist2.remove("Orange shirt?");
                x = x - 1;    
            }
            else if (qlist2.get(i) == "Green shirt?") {
                for (Character c : characters) {
                    if (c.shirtColor == "green") {
                        if (delete.indexOf(c) == -1) {
                            delete.add(c);
                        }
                    }
                }
                qlist2.remove("Green shirt?");
                x = x - 1;    
            }
        }
        //Pelin lopetustoimet tilanteessa, kun tietokoneella on jäljellä enää 0-1 hahmoa
        if (x <= 1) {
            characters.removeAll(delete);
            if (JOptionPane.showConfirmDialog(null,"Is your character number " + characters.get(0).getNumber()+"?", "Your Answer", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
                Object[] options = { "Close the game"};
                JOptionPane.showOptionDialog(null, "Computer won!", "Guess who?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                System.exit(0);
                }
            else {
                Object[] options = { "Close the game"};
                JOptionPane.showOptionDialog(null, "You won. But I no longer want to play with you if you lie like that.", "Guess who?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                System.exit(0);
            }
            }
        }
        catch (Exception e) {
            Object[] options = { "Close the game"};
            JOptionPane.showOptionDialog(null, "You won. But I no longer want to play with you if you lie like that.", "Guess who?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            System.exit(0);
        }
    }
}