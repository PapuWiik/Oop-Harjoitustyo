package harjoitustyo;

import java.awt.GridLayout;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.Random;
import static javax.swing.BoxLayout.Y_AXIS;
import javax.swing.border.*;

/* Game-luokka sisältää varsinaisen pelin, johon kuuluu sekä pelilaudan rakentaminen
että varsinaisesta pelin kulusta huolehtiminen
*/
public class Game extends JFrame implements ActionListener, MouseListener {
    
    // Luodaan container-paneeli, jonka sisällä ovat kaikki muut paneelit
    JPanel container = new JPanel();
    JPanel p=new JPanel();
    JPanel p3= new JPanel();
    JPanel pright0 = new JPanel();
    JPanel pright5 = new JPanel();
    JPanel pright1 = new JPanel();
    JPanel pright2 = new JPanel();
    JPanel pright3 = new JPanel();
    JPanel pright4 = new JPanel();
    
    //Objektit paneeleita varten
    JButton b = new JButton("Ask");
    JButton breset = new JButton("Reset");
    JButton bfinal = new JButton("Guess Character");
    JLabel bsettings = new JLabel(createImageIcon("images/setting.png","kuva1"));
    JLabel bpeople = new JLabel(createImageIcon("images/people.png","kuva1"));
    JLabel beye = new JLabel(createImageIcon("images/eye.png","kuva1"));
    JTextArea textarea = new JTextArea(40,30);
    String[] qlist = { "Glasses?", "Hairband?", "Blonde hair?", "Light brown hair?", "Dark brown hair?", "Ginger hair?", "Cap?","Hair loose?", "Red shirt?", "Yellow shirt?", "Blue shirt?", "Orange shirt?", "Green shirt?"};
    JLabel feed = new JLabel();
    JComboBox jb = new JComboBox(qlist);
    Font font = new Font("Calibri", Font.PLAIN, 35);
    Font font2 = new Font("Calibri", Font.PLAIN, 20);
    
    //Tekstit
    JLabel otsikko = new JLabel("Guess Who?");
    JLabel text = new JLabel("<html><br><br>You can hide characters from the table on the left by clicking on them.<br>By clicking the Reset button, all of the characters become visible again.<br>The reset button DOES NOT restart the whole game.<br><br></html>");
    JLabel text2 = new JLabel("Ask a Question:");
    JLabel text3 = new JLabel("Your character:  ");    
    
    //Kuvat
    JLabel icon1 = new JLabel(createImageIcon("images/1.png","kuva1"), JLabel.CENTER);
    JLabel icon2 = new JLabel(createImageIcon("images/2.png","kuva2"), JLabel.CENTER);
    JLabel icon3 = new JLabel(createImageIcon("images/3.png","kuva3"), JLabel.CENTER);
    JLabel icon4 = new JLabel(createImageIcon("images/4.png","kuva4"), JLabel.CENTER);
    JLabel icon5 = new JLabel(createImageIcon("images/5.png","kuva5"), JLabel.CENTER);
    JLabel icon6 = new JLabel(createImageIcon("images/6.png","kuva6"), JLabel.CENTER);
    JLabel icon7 = new JLabel(createImageIcon("images/7.png","kuva7"), JLabel.CENTER);
    JLabel icon8 = new JLabel(createImageIcon("images/8.png","kuva8"), JLabel.CENTER);
    JLabel icon9 = new JLabel(createImageIcon("images/9.png","kuva9"), JLabel.CENTER);
    JLabel icon10 = new JLabel(createImageIcon("images/10.png","kuva10"), JLabel.CENTER);
    JLabel icon11 = new JLabel(createImageIcon("images/11.png","kuva11"), JLabel.CENTER);
    JLabel icon12 = new JLabel(createImageIcon("images/12.png","kuva12"), JLabel.CENTER);
    JLabel icon13 = new JLabel(createImageIcon("images/13.png","kuva13"), JLabel.CENTER);
    JLabel icon14 = new JLabel(createImageIcon("images/14.png","kuva14"), JLabel.CENTER);
    JLabel icon15 = new JLabel(createImageIcon("images/15.png","kuva15"), JLabel.CENTER);
    JLabel icon16 = new JLabel(createImageIcon("images/16.png","kuva16"), JLabel.CENTER);
    JLabel icon1a = new JLabel(createImageIcon("images/1.png","kuva1"), JLabel.CENTER);
    JLabel icon2a = new JLabel(createImageIcon("images/2.png","kuva2"), JLabel.CENTER);
    JLabel icon3a = new JLabel(createImageIcon("images/3.png","kuva3"), JLabel.CENTER);
    JLabel icon4a = new JLabel(createImageIcon("images/4.png","kuva4"), JLabel.CENTER);
    JLabel icon5a = new JLabel(createImageIcon("images/5.png","kuva5"), JLabel.CENTER);
    JLabel icon6a = new JLabel(createImageIcon("images/6.png","kuva6"), JLabel.CENTER);
    JLabel icon7a = new JLabel(createImageIcon("images/7.png","kuva7"), JLabel.CENTER);
    JLabel icon8a = new JLabel(createImageIcon("images/8.png","kuva8"), JLabel.CENTER);
    JLabel icon9a = new JLabel(createImageIcon("images/9.png","kuva9"), JLabel.CENTER);
    JLabel icon10a = new JLabel(createImageIcon("images/10.png","kuva10"), JLabel.CENTER);
    JLabel icon11a = new JLabel(createImageIcon("images/11.png","kuva11"), JLabel.CENTER);
    JLabel icon12a = new JLabel(createImageIcon("images/12.png","kuva12"), JLabel.CENTER);
    JLabel icon13a = new JLabel(createImageIcon("images/13.png","kuva13"), JLabel.CENTER);
    JLabel icon14a = new JLabel(createImageIcon("images/14.png","kuva14"), JLabel.CENTER);
    JLabel icon15a = new JLabel(createImageIcon("images/15.png","kuva15"), JLabel.CENTER);
    JLabel icon16a = new JLabel(createImageIcon("images/16.png","kuva16"), JLabel.CENTER);

    //Luodaan pelaaja ja tietokone
    Player p1 = new Player();
    Computer com = new Computer();

    //BasicSwingin konstruktori eli varsinainen pelin rakennus
    public Game() {
        super();
        setResizable(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setUndecorated(true);
        setVisible(true);
        setTitle("Guess Who?");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground( new Color(255,255,255) );
        
        //Luodaan taulukko kuville
        p.setLayout(new GridLayout(4, 5));
        
        //Asetetaan kaikki elementit läpikuultaviksi, jos taustaväriä halutaan vaihtaa
        p.setOpaque(false);
        p3.setOpaque(false);
        pright0.setOpaque(false);
        pright1.setOpaque(false);
        pright2.setOpaque(false);
        pright3.setOpaque(false);
        pright4.setOpaque(false);
        pright5.setOpaque(false);
        container.setOpaque(false);
        
        p3.setLayout(new BoxLayout(p3,Y_AXIS));
        
        p3.add(pright0);
        //p3.add(pright1);
        p3.add(pright2);
        p3.add(pright3);
        p3.add(pright4);
        
        //Sijoitetaan JPaneelit containeriin
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        container.add(p);
        container.add(p3);
        
        //Lisätään kuvat taulukkoon
        p.add(icon1);
        p.add(icon2);
        p.add(icon3);
        p.add(icon4);
        p.add(icon5);
        p.add(icon6);
        p.add(icon7);
        p.add(icon8);
        p.add(icon9);
        p.add(icon10);
        p.add(icon11);
        p.add(icon12);
        p.add(icon13);
        p.add(icon14);
        p.add(icon15);
        p.add(icon16);
        
        //Asetetaan kaikkien tekstiä sisältävien elementtien fontit
        text2.setFont(font2);
        text.setFont(font2);
        text3.setFont(font2);
        otsikko.setFont(font);
        feed.setFont(font);
        breset.setFont(font2);
        jb.setFont(font2);
        b.setFont(font2);
        bfinal.setFont(font2);

        //Lisätään oikean puoleisen JPaneelin elementit
        pright0.add(otsikko);
        pright0.add(pright5);
        pright5.add(beye);
        pright5.add(bpeople);
        pright5.add(bsettings);
        pright1.add(text);
        pright1.add(breset);
        pright2.add(text2);
        pright2.add(jb);
        pright2.add(b);
        //pright2.add(bfinal);
        pright3.add(text3);
        pright4.add(feed);
        
        //Asetetaan väli oikean paneelin nappien väliin
        Border border = beye.getBorder();
        Border margin = new EmptyBorder(25,25,25,25);
        beye.setBorder(new CompoundBorder(border,margin));
        bpeople.setBorder(new CompoundBorder(border,margin));
        bsettings.setBorder(new CompoundBorder(border,margin));
        
        //Lisätään actionlistenerit
        b.addActionListener(this);
        breset.addActionListener(this);
        bfinal.addActionListener(this);
        bpeople.addMouseListener(this);
        bsettings.addMouseListener(this);
        beye.addMouseListener(this);
        icon1.addMouseListener(this);
        icon2.addMouseListener(this);
        icon3.addMouseListener(this);
        icon4.addMouseListener(this);
        icon5.addMouseListener(this);
        icon6.addMouseListener(this);
        icon7.addMouseListener(this);
        icon8.addMouseListener(this);
        icon9.addMouseListener(this);
        icon10.addMouseListener(this);
        icon11.addMouseListener(this);
        icon12.addMouseListener(this);
        icon13.addMouseListener(this);
        icon14.addMouseListener(this);
        icon15.addMouseListener(this);
        icon16.addMouseListener(this);
        
        //Lisätään kaikki elementit ruudulle
        add(container);
        setVisible(true);
        
    //Luodaan hahmot-oliot ja sijoitetaan ne pelaajan ja tietokoneen pelilaudoille
        Character c1 = new Male(1,false,"light brown",true,false,false,"orange");
        Character c2 = new Male(2,false,"dark brown",true,false, false,"red");
        Character c3 = new Female(3, false,"blonde",false,true,false,"red");
        Character c4 = new Male(4,false,"ginger",false,true,false,"blue");
        Character c5 = new Female(5, false,"ginger",false,false,false,"green");
        Character c6 = new Female(6, false,"blonde",false,true,false,"green");
        Character c7 = new Male(7,false,"dark brown",false,true,false,"yellow");
        Character c8 = new Female(8,false,"dark brown",false,false,false,"red");
        Character c9 = new Female(9, false,"dark brown",false,true,true,"yellow");
        Character c10 = new Female(10, false,"light brown",false,true,true,"brown");
        Character c11 = new Female(11,false,"dark brown",false,false,true,"red");
        Character c12 = new Female(12,false,"light brown",false,false,false,"blue");
        Character c13 = new Male(13,true,"dark brown",false,true,false,"green");
        Character c14 = new Female(14,true,"blonde",false,false,false,"blue");
        Character c15 = new Female(15,true,"light brown",false,true,true,"blue");
        Character c16 = new Male(16,true,"dark brown",false,true,false,"orange");
        
        ArrayList<Character> characters = new ArrayList<>();
        characters.add(c1);
        characters.add(c2);
        characters.add(c3);
        characters.add(c4);
        characters.add(c5);
        characters.add(c6);
        characters.add(c7);
        characters.add(c8);
        characters.add(c9);
        characters.add(c10);
        characters.add(c11);
        characters.add(c12);
        characters.add(c13);
        characters.add(c14);
        characters.add(c15);
        characters.add(c16);
        
        p1.setCharacter(characters);
        com.setCharacter(characters);
        
        //Luodaan alkuvalikko, josta pelaaja valitsee oman hahmonsa
        Object[] options= { "Character 1", "Character 2","Character 3","Character 4","Character 5","Character 6","Character 7","Character 8","Character 9","Character 10","Character 11","Character 12","Character 13","Character 14","Character 15","Character 16" };
        Object selectedValue = JOptionPane.showInputDialog(null, "<html>Welcome!<br><br>The object of the game is to be the first to determine which character your opponent has selected.<br>You can hide characters from the table on the left by clicking on them.<br>If you want to make all your characters visible again, you can do so by clicking the eye icon.<br>The character icon next to the eye is used to make your final guess when you think you know the correct character. <br><br>Good luck!<br><br>Choose your character to start a game:</html>","Guess who?", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        
        //Asetetaan valinnan mukainen hahmo pelaajan näkymään
        if (selectedValue == "Character 1") {
            pright3.add(icon1a);
        }
        else if (selectedValue == "Character 2") {
            pright3.add(icon2a);
        }
        else if (selectedValue == "Character 3") {
            pright3.add(icon3a);
        }
        else if (selectedValue == "Character 4") {
            pright3.add(icon4a);
        }
        else if (selectedValue == "Character 5") {
            pright3.add(icon5a);
        }
        else if (selectedValue == "Character 6") {
            pright3.add(icon6a);
        }
        else if (selectedValue == "Character 7") {
            pright3.add(icon7a);
        }
        else if (selectedValue == "Character 8") {
            pright3.add(icon8a);
        }
        else if (selectedValue == "Character 9") {
            pright3.add(icon9a);
        }
        else if (selectedValue == "Character 10") {
            pright3.add(icon10a);
        }
        else if (selectedValue == "Character 11") {
            pright3.add(icon11a);
        }
        else if (selectedValue == "Character 12") {
            pright3.add(icon12a);
        }
        else if (selectedValue == "Character 13") {
            pright3.add(icon13a);
        }
        else if (selectedValue == "Character 14") {
            pright3.add(icon14a);
        }
        else if (selectedValue == "Character 15") {
            pright3.add(icon15a);
        }
        else {
            pright3.add(icon16a);
        }
        //Päivitetään pelilauta, jotta uusi kuvake tulee näkyviin
        validate();
        repaint();
       
        Random rnd = new Random();
        Character pCharacter = characters.get(rnd.nextInt(15));
        int cCharacter = com.getCharacter();
        
    }
    
// Seuraavassa metodissa käsitellään kaikki tilanteet, jotka syntyvät hiiren klikkauksesta
public void mouseClicked (MouseEvent e) {
    // Jos pelaaja klikkaa hahmokuvaketta, se piilotetaan
        if (e.getSource()== icon1) {
            icon1.setVisible(false);
        }
        else if (e.getSource()== icon2) {
            icon2.setVisible(false);
        }
        else if (e.getSource()== icon3) {
            icon3.setVisible(false);
        }
        else if (e.getSource()== icon4) {
            icon4.setVisible(false);
        }
        else if (e.getSource()== icon5) {
            icon5.setVisible(false);
        }
        else if (e.getSource()== icon6) {
            icon6.setVisible(false);
        }
        else if (e.getSource()== icon7) {
            icon7.setVisible(false);
        }
        else if (e.getSource()== icon8) {
            icon8.setVisible(false);
        }
        else if (e.getSource()== icon9) {
            icon9.setVisible(false);
        }
        else if (e.getSource()== icon10) {
            icon10.setVisible(false);
        }
        else if (e.getSource()== icon11) {
            icon11.setVisible(false);
        }
        else if (e.getSource()== icon12) {
            icon12.setVisible(false);
        }
        else if (e.getSource()== icon13) {
            icon13.setVisible(false);
        }
        else if (e.getSource()== icon14) {
            icon14.setVisible(false);
        }
        else if (e.getSource()== icon15) {
            icon15.setVisible(false);
        }
        else if (e.getSource()== icon16) {
            icon16.setVisible(false);
        }
        // Jos pelaaja klikkaa silmäkuvaketta, kaikki hahmot palautetaan näkyviksi
        else if (e.getSource() == beye) {
            icon1.setVisible(true);
            icon2.setVisible(true);
            icon3.setVisible(true);
            icon4.setVisible(true);
            icon5.setVisible(true);
            icon6.setVisible(true);
            icon7.setVisible(true);
            icon8.setVisible(true);
            icon9.setVisible(true);
            icon10.setVisible(true);
            icon11.setVisible(true);
            icon12.setVisible(true);
            icon13.setVisible(true);
            icon14.setVisible(true);
            icon15.setVisible(true);
            icon16.setVisible(true);
        }
        /*Jos pelaaja klikkaa hahmon arvausnappia, heitetään arvausikkuna.
        Erilaiset mahdolliset pelin lopetustilanteet tässä tapauksessa löytyvät alta.
        */
        else if (e.getSource() == bpeople) {
            Object[] options= { "Character 1", "Character 2","Character 3","Character 4","Character 5","Character 6","Character 7","Character 8","Character 9","Character 10","Character 11","Character 12","Character 13","Character 14","Character 15","Character 16" };
            Object[] options2 = {"Close the game"};
            Object selectedValue2 = JOptionPane.showInputDialog(null, "Make your guess:","Guess who?", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if (selectedValue2 == null) {   
            }
            else if (selectedValue2 == "Character 1" && com.getCharacter() == 0) {
                JOptionPane.showOptionDialog(null, "You guessed correctly. Victory!", "Guess who?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options2, options2[0]);
                System.exit(0);
            }
            else if (selectedValue2 == "Character 2" && com.getCharacter() == 1) {
                JOptionPane.showOptionDialog(null, "You guessed correctly. Victory!", "Guess who?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options2, options2[0]);
                System.exit(0);
            }
            else if (selectedValue2 == "Character 3"&& com.getCharacter() == 2) {
                JOptionPane.showOptionDialog(null, "You guessed correctly. Victory!", "Guess who?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options2, options2[0]);
                System.exit(0);
            }
            else if (selectedValue2 == "Character 4"&& com.getCharacter() == 3) {
                JOptionPane.showOptionDialog(null, "You guessed correctly. Victory!", "Guess who?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options2, options2[0]);
                System.exit(0);
            }
            else if (selectedValue2 == "Character 5"&& com.getCharacter() == 4) {
                JOptionPane.showOptionDialog(null, "You guessed correctly. Victory!", "Guess who?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options2, options2[0]);
                System.exit(0);
            }
            else if (selectedValue2 == "Character 6"&& com.getCharacter() == 5) {
                JOptionPane.showOptionDialog(null, "You guessed correctly. Victory!", "Guess who?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options2, options2[0]);
                System.exit(0);
            }
            else if (selectedValue2 == "Character 7"&& com.getCharacter() == 6) {
                JOptionPane.showOptionDialog(null, "You guessed correctly. Victory!", "Guess who?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options2, options2[0]);
                System.exit(0);
            }
            else if (selectedValue2 == "Character 8"&& com.getCharacter() == 7) {
                JOptionPane.showOptionDialog(null, "You guessed correctly. Victory!", "Guess who?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options2, options2[0]);
                System.exit(0);
            }
            else if (selectedValue2 == "Character 9"&& com.getCharacter() == 8) {
                JOptionPane.showOptionDialog(null, "You guessed correctly. Victory!", "Guess who?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options2, options2[0]);
                System.exit(0);
            }
            else if (selectedValue2 == "Character 10"&& com.getCharacter() == 9) {
                JOptionPane.showOptionDialog(null, "You guessed correctly. Victory!", "Guess who?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options2, options2[0]);
                System.exit(0);
            }
            else if (selectedValue2 == "Character 11"&& com.getCharacter() == 10) {
                JOptionPane.showOptionDialog(null, "You guessed correctly. Victory!", "Guess who?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options2, options2[0]);
                System.exit(0);
            }
            else if (selectedValue2 == "Character 12"&& com.getCharacter() == 11) {
                JOptionPane.showOptionDialog(null, "You guessed correctly. Victory!", "Guess who?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options2, options2[0]);
                System.exit(0);
            }
            else if (selectedValue2 == "Character 13"&& com.getCharacter() == 12) {
                JOptionPane.showOptionDialog(null, "You guessed correctly. Victory!", "Guess who?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options2, options2[0]);
                System.exit(0);
            }
            else if (selectedValue2 == "Character 14"&& com.getCharacter() == 13) {
                JOptionPane.showOptionDialog(null, "You guessed correctly. Victory!", "Guess who?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options2, options2[0]);
                System.exit(0);
            }
            else if (selectedValue2 == "Character 15"&& com.getCharacter() == 14) {
                JOptionPane.showOptionDialog(null, "You guessed correctly. Victory!", "Guess who?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options2, options2[0]);
                System.exit(0);
            }
            else if (selectedValue2 == "Character 16"&& com.getCharacter() == 15) {
                JOptionPane.showOptionDialog(null, "You guessed correctly. Victory!", "Guess who?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options2, options2[0]);
                System.exit(0);
            }
            else {
                JOptionPane.showOptionDialog(null, "Your guess was wrong. Computer had character number "+com.getCharacter()+". Computer won!", "Guess who?", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options2, options2[0]);
                System.exit(0);
            }
        }
        // Jos pelaaja klikkaa asetuspainiketta, avataan valikko ja toimitaan pelaajan valinnan mukaisesti
        else if (e.getSource() == bsettings) {
            Object[] options = {"Save game", "Load game", "Exit game"};
            int i = JOptionPane.showOptionDialog(null, "What would you like to do?", "Settings", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if (i == JOptionPane.YES_OPTION) {
                saveGame();
            }
            else if (i == JOptionPane.NO_OPTION) {
                loadGame();
            }
            else if (i == JOptionPane.CANCEL_OPTION) {
                System.exit(0);
            }
        }
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e){ 
    }
    public void mouseEntered(MouseEvent e){
    }
    public void mousePressed(MouseEvent e){ 
    }

    //Metodi, jossa käsitellään kaikki loput pelaajan käynnistämät toiminnot
    public void actionPerformed(ActionEvent e) {
        //Kun pelaaja painaa Ask-nappia
        if (e.getSource() == b) {
            if (p1.askQuestion(jb.getSelectedIndex(),com) == true) {
                feed.setText(qlist[jb.getSelectedIndex()] +" Yes. ");
                validate();
                repaint();
            }
            else {
                feed.setText(qlist[jb.getSelectedIndex()] +" No. ");
                validate();
                repaint();
            }
            com.askQuestion();
        }
        }
    
    //Metodi, jonka seurauksena peli tallennetaan saveFileihin 1-21
    public void saveGame() {
        try {
            FileOutputStream saveFile1 = new FileOutputStream("saveFile1.sav");
            ObjectOutputStream save1 = new ObjectOutputStream(saveFile1);
            Component icon = pright3.getComponent(1);
            save1.writeObject(icon);
            save1.close();
            
            FileOutputStream saveFile2 = new FileOutputStream("saveFile2.sav");
            ObjectOutputStream save2 = new ObjectOutputStream(saveFile2);
            String text = feed.getText();
            save2.writeObject(text);
            save2.close();
            
            FileOutputStream saveFile3 = new FileOutputStream("saveFile3.sav");
            ObjectOutputStream save3 = new ObjectOutputStream(saveFile3);
            int x = com.getX();
            save3.writeInt(x);
            save3.close();
            
            FileOutputStream saveFile4 = new FileOutputStream("saveFile4.sav");
            ObjectOutputStream save4 = new ObjectOutputStream(saveFile4);
            ArrayList<Character> delete = com.getDeletableCharacters();
            save4.writeObject(delete);
            save4.close();
            
            FileOutputStream saveFile5 = new FileOutputStream("saveFile5.sav");
            ObjectOutputStream save5 = new ObjectOutputStream(saveFile5);
            int finalCharacter = com.getCharacter();
            save5.writeInt(finalCharacter);
            save5.close();
            
            FileOutputStream saveFile6 = new FileOutputStream("saveFile6.sav");
            ObjectOutputStream save6 = new ObjectOutputStream(saveFile6);
            boolean visible1 = icon1.isVisible();
            save6.writeBoolean(visible1);
            save6.close();
            
            FileOutputStream saveFile7 = new FileOutputStream("saveFile7.sav");
            ObjectOutputStream save7 = new ObjectOutputStream(saveFile7);
            boolean visible2 = icon2.isVisible();
            save7.writeBoolean(visible2);
            save7.close();
            
            FileOutputStream saveFile8 = new FileOutputStream("saveFile8.sav");
            ObjectOutputStream save8 = new ObjectOutputStream(saveFile8);
            boolean visible3 = icon3.isVisible();
            save8.writeBoolean(visible3);
            save8.close();
            
            FileOutputStream saveFile9 = new FileOutputStream("saveFile9.sav");
            ObjectOutputStream save9 = new ObjectOutputStream(saveFile9);
            boolean visible4 = icon4.isVisible();
            save9.writeBoolean(visible4);
            save9.close();
            
            FileOutputStream saveFile10 = new FileOutputStream("saveFile10.sav");
            ObjectOutputStream save10 = new ObjectOutputStream(saveFile10);
            boolean visible5 = icon5.isVisible();
            save10.writeBoolean(visible5);
            save10.close();
            
            FileOutputStream saveFile11 = new FileOutputStream("saveFile11.sav");
            ObjectOutputStream save11 = new ObjectOutputStream(saveFile11);
            boolean visible6 = icon6.isVisible();
            save11.writeBoolean(visible6);
            save11.close();
            
            FileOutputStream saveFile12 = new FileOutputStream("saveFile12.sav");
            ObjectOutputStream save12 = new ObjectOutputStream(saveFile12);
            boolean visible7 = icon7.isVisible();
            save12.writeBoolean(visible7);
            save12.close();
            
            FileOutputStream saveFile13 = new FileOutputStream("saveFile13.sav");
            ObjectOutputStream save13 = new ObjectOutputStream(saveFile13);
            boolean visible8 = icon8.isVisible();
            save13.writeBoolean(visible8);
            save13.close();
            
            FileOutputStream saveFile14 = new FileOutputStream("saveFile14.sav");
            ObjectOutputStream save14 = new ObjectOutputStream(saveFile14);
            boolean visible9 = icon9.isVisible();
            save14.writeBoolean(visible9);
            save14.close();
            
            FileOutputStream saveFile15 = new FileOutputStream("saveFile15.sav");
            ObjectOutputStream save15 = new ObjectOutputStream(saveFile15);
            boolean visible10 = icon10.isVisible();
            save15.writeBoolean(visible10);
            save15.close();
            
            FileOutputStream saveFile16 = new FileOutputStream("saveFile16.sav");
            ObjectOutputStream save16 = new ObjectOutputStream(saveFile16);
            boolean visible11 = icon11.isVisible();
            save16.writeBoolean(visible11);
            save16.close();
            
            FileOutputStream saveFile17 = new FileOutputStream("saveFile17.sav");
            ObjectOutputStream save17 = new ObjectOutputStream(saveFile17);
            boolean visible12 = icon12.isVisible();
            save17.writeBoolean(visible12);
            save17.close();
            
            FileOutputStream saveFile18 = new FileOutputStream("saveFile18.sav");
            ObjectOutputStream save18 = new ObjectOutputStream(saveFile18);
            boolean visible13 = icon13.isVisible();
            save18.writeBoolean(visible13);
            save18.close();
            
            FileOutputStream saveFile19 = new FileOutputStream("saveFile19.sav");
            ObjectOutputStream save19 = new ObjectOutputStream(saveFile19);
            boolean visible14 = icon14.isVisible();
            save19.writeBoolean(visible14);
            save19.close();
            
            FileOutputStream saveFile20 = new FileOutputStream("saveFile20.sav");
            ObjectOutputStream save20 = new ObjectOutputStream(saveFile20);
            boolean visible15 = icon15.isVisible();
            save20.writeBoolean(visible15);
            save20.close();
            
            FileOutputStream saveFile21 = new FileOutputStream("saveFile21.sav");
            ObjectOutputStream save21 = new ObjectOutputStream(saveFile21);
            boolean visible16 = icon16.isVisible();
            save21.writeBoolean(visible16);
            save21.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Metodi, jonka seurauksena peli ladataan saveFileistä 1-21
    public void loadGame() {
        try {
            FileInputStream saveFile1 = new FileInputStream("saveFile1.sav");
            ObjectInputStream restore1 = new ObjectInputStream(saveFile1);
            Component icon = (Component) restore1.readObject();
            restore1.close();
            
            FileInputStream saveFile2 = new FileInputStream("saveFile2.sav");
            ObjectInputStream restore2 = new ObjectInputStream(saveFile2);
            String text = (String) restore2.readObject();
            restore2.close();
            
            FileInputStream saveFile3 = new FileInputStream("saveFile3.sav");
            ObjectInputStream restore3 = new ObjectInputStream(saveFile3);
            int x = (int) restore3.readInt();
            restore3.close();
            
            FileInputStream saveFile4 = new FileInputStream("saveFile4.sav");
            ObjectInputStream restore4 = new ObjectInputStream(saveFile4);
            ArrayList<Character> delete = (ArrayList<Character>) restore4.readObject();
            restore4.close();
            
            FileInputStream saveFile5 = new FileInputStream("saveFile5.sav");
            ObjectInputStream restore5 = new ObjectInputStream(saveFile5);
            int finalCharacter = (int) restore5.readInt();
            restore5.close();
            
            FileInputStream saveFile6 = new FileInputStream("saveFile6.sav");
            ObjectInputStream restore6 = new ObjectInputStream(saveFile6);
            boolean visible1 = (boolean) restore6.readBoolean();
            restore6.close();
            
            FileInputStream saveFile7 = new FileInputStream("saveFile7.sav");
            ObjectInputStream restore7 = new ObjectInputStream(saveFile7);
            boolean visible2 = (boolean) restore7.readBoolean();
            restore7.close();
            
            FileInputStream saveFile8 = new FileInputStream("saveFile8.sav");
            ObjectInputStream restore8 = new ObjectInputStream(saveFile8);
            boolean visible3 = (boolean) restore8.readBoolean();
            restore8.close();
            
            FileInputStream saveFile9 = new FileInputStream("saveFile9.sav");
            ObjectInputStream restore9 = new ObjectInputStream(saveFile9);
            boolean visible4 = (boolean) restore9.readBoolean();
            restore9.close();
            
            FileInputStream saveFile10 = new FileInputStream("saveFile10.sav");
            ObjectInputStream restore10 = new ObjectInputStream(saveFile10);
            boolean visible5 = (boolean) restore10.readBoolean();
            restore10.close();
            
            FileInputStream saveFile11 = new FileInputStream("saveFile11.sav");
            ObjectInputStream restore11 = new ObjectInputStream(saveFile11);
            boolean visible6 = (boolean) restore11.readBoolean();
            restore11.close();
            
            FileInputStream saveFile12 = new FileInputStream("saveFile12.sav");
            ObjectInputStream restore12 = new ObjectInputStream(saveFile12);
            boolean visible7 = (boolean) restore12.readBoolean();
            restore12.close();
            
            FileInputStream saveFile13 = new FileInputStream("saveFile13.sav");
            ObjectInputStream restore13 = new ObjectInputStream(saveFile13);
            boolean visible8 = (boolean) restore13.readBoolean();
            restore13.close();
            
            FileInputStream saveFile14 = new FileInputStream("saveFile14.sav");
            ObjectInputStream restore14 = new ObjectInputStream(saveFile14);
            boolean visible9 = (boolean) restore14.readBoolean();
            restore14.close();
            
            FileInputStream saveFile15 = new FileInputStream("saveFile15.sav");
            ObjectInputStream restore15 = new ObjectInputStream(saveFile15);
            boolean visible10 = (boolean) restore15.readBoolean();
            restore15.close();
            
            FileInputStream saveFile16 = new FileInputStream("saveFile16.sav");
            ObjectInputStream restore16 = new ObjectInputStream(saveFile16);
            boolean visible11 = (boolean) restore16.readBoolean();
            restore16.close();
            
            FileInputStream saveFile17 = new FileInputStream("saveFile17.sav");
            ObjectInputStream restore17 = new ObjectInputStream(saveFile17);
            boolean visible12 = (boolean) restore17.readBoolean();
            restore17.close();
            
            FileInputStream saveFile18 = new FileInputStream("saveFile18.sav");
            ObjectInputStream restore18 = new ObjectInputStream(saveFile18);
            boolean visible13 = (boolean) restore18.readBoolean();
            restore18.close();
            
            FileInputStream saveFile19 = new FileInputStream("saveFile19.sav");
            ObjectInputStream restore19 = new ObjectInputStream(saveFile19);
            boolean visible14 = (boolean) restore19.readBoolean();
            restore19.close();
            
            FileInputStream saveFile20 = new FileInputStream("saveFile20.sav");
            ObjectInputStream restore20 = new ObjectInputStream(saveFile20);
            boolean visible15 = (boolean) restore20.readBoolean();
            restore20.close();
            
            FileInputStream saveFile21 = new FileInputStream("saveFile21.sav");
            ObjectInputStream restore21 = new ObjectInputStream(saveFile21);
            boolean visible16 = (boolean) restore21.readBoolean();
            restore21.close();
            feed.setText(text);
            com.setX(x);
            pright3.removeAll();
            pright3.add(text3);
            pright3.add(icon);
            com.setDeletableCharacters(delete);
            com.setCharacter(finalCharacter);
            icon1.setVisible(visible1);
            icon2.setVisible(visible2);
            icon3.setVisible(visible3);
            icon4.setVisible(visible4);
            icon5.setVisible(visible5);
            icon6.setVisible(visible6);
            icon7.setVisible(visible7);
            icon8.setVisible(visible8);
            icon9.setVisible(visible9);
            icon10.setVisible(visible10);
            icon11.setVisible(visible11);
            icon12.setVisible(visible12);
            icon13.setVisible(visible13);
            icon14.setVisible(visible14);
            icon15.setVisible(visible15);
            icon16.setVisible(visible16);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Metodi, jolla luodaan kuvakkeet pelilaudalla näkyville hahmoille
    protected ImageIcon createImageIcon(String path,
                                           String description) {
    java.net.URL imgURL = getClass().getResource(path);
    if (imgURL != null) {
        return new ImageIcon(imgURL, description);
    } else {
        System.err.println("Couldn't find file: " + path);
        return null;
    }
}
}
