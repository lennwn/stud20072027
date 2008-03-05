/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorapplication;

import java.util.Observable;

/**
 * Model extender klassen Observable. Således indeholder denne klasse også
 * i forevejen kendte metoder.
 * @author Benjamin og Rasmus (Instruktor)
 */
public class Model extends Observable {

    // Her afgøres det at både display og display2 er strings
    String display, display2;

    // Display sættes til "" = blank
    public Model() {
        display = "";
    }

    // Når man kører metoden getDisplay på model-objektet, henter man den 
    // gemte værdi.
    public String getDisplay() {
        return display;
    }

    // Her tilføjes argumentet str, som er en string, til den værdi som 
    // allerede findes i display.
    public void addToDisplay(String str) {
        display = display + str;
    }

    // En plus-funktion. Efter plusfunktionen ryddes displayet.
    public void plusButton() {
        display2 = display;
        display = "";
    }

    // Her udregnes og vises resultatet når result køres på model-objektet 
    // (model.result()).
    public void result() {
        int int1 = Integer.parseInt(display);
        int int2 = Integer.parseInt(display2);
        int result = int1 + int2;
        display = "" + result;
    }

    public void clear() {
        display = "";
    }


    // MEGET VIGTIGT! Her gemmes ændringerne og der gives besked videre til
    // Observers (View) om de ændringer som er forekommet.
    public void modelChanged() {
        setChanged();
        // Der gives besked til Observer(s) med den nye værdi. Denne funktion er
        // beskrevet tidligere i klassen her.
        notifyObservers(getDisplay());
    }
}
