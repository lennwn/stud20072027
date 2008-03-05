/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorapplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

/**
 * Alle variabler er skrevet med fed sort i Netbeans, mens de steder hvor der står
 * noget. Således er appendListener en variabel, mens getActionCommand() er forudbestemt
 * (Vidst nok mere en note til mig selv, men hvis I kan bruge den er det godt)
 * @author Benjamin og Rasmus (Instruktor)
 */
public class Controller implements ActionListener {

    Model model;

    // et model-objekt oprettes
    public Controller() {
        model = new Model();
    }

    /**
     * Her afgøres det hvad der skal ske når der trykkes på en knap.
     * Grunden til at vi kan se hvad der sker er fordi der inde i View er en
     * "addActionListener". Det ergument som bliver medgivet derfra er en sting
     * (også selv om det er et tal).
     */
    public void actionPerformed(ActionEvent e) {
        // Hvis ActionEvent e er lig med strengen "1".
        if (e.getActionCommand().equals("1")) {
            // Kør da metoden "addToDisplay" i model-objektet.
            model.addToDisplay("1");
        } else if (e.getActionCommand().equals("2")) {
            model.addToDisplay("2");
        } else if (e.getActionCommand().equals("3")) {
            model.addToDisplay("3");
        } else if (e.getActionCommand().equals("4")) {
            model.addToDisplay("4");
        } else if (e.getActionCommand().equals("5")) {
            model.addToDisplay("5");
        } else if (e.getActionCommand().equals("6")) {
            model.addToDisplay("6");
        } else if (e.getActionCommand().equals("7")) {
            model.addToDisplay("7");
        } else if (e.getActionCommand().equals("8")) {
            model.addToDisplay("8");
        } else if (e.getActionCommand().equals("9")) {
            model.addToDisplay("9");
        } else if (e.getActionCommand().equals("0")) {
            model.addToDisplay("0");
        } else if (e.getActionCommand().equals("+")) {
            model.plusButton();
        } else if (e.getActionCommand().equals("=")) {
            model.result();
        } else if (e.getActionCommand().equals("Clear")) {
            model.clear();
        }
        // Her gives besked om at model er blevet ændret 
        model.modelChanged();
    }

    // Indsætter en observer i modellen, der "lytter" til aktiviteter i modellen
    public void appendListener(Observer o) {
        model.addObserver(o);
    }
}
