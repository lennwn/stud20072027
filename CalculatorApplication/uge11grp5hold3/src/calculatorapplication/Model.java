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
    String display, display2, id, memory;

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
        id = "plus";
    }

    public void minusButton() {
        display2 = display;
        display = "";
        id = "minus";
    }

    public void gangeButton() {
        display2 = display;
        display = "";
        id = "gange";
    }

    public void dividereButton() {
        display2 = display;
        display = "";
        id = "dividere";
    }

    /* Følgende blev ikke fuldført.
    public void sinusButton() {
    float int1 = Float.parseFloat(display);
    display = (float) Math.sin(int1);
    }
     */
    
    // Her udregnes og vises resultatet når result køres på model-objektet 
    // (model.result()).
    public void result() {
        if (id == "plus") {
            int int1 = Integer.parseInt(display);
            int int2 = Integer.parseInt(display2);
            // int int3 = Integer.parseInt(display3);
            int result = int1 + int2;
            display = "" + result;
        } else if (id == "minus") {
            int int1 = Integer.parseInt(display);
            int int2 = Integer.parseInt(display2);
            // int int3 = Integer.parseInt(display3);
            int result = int2 - int1;
            display = "" + result;
        } else if (id == "gange") {
            int int1 = Integer.parseInt(display);
            int int2 = Integer.parseInt(display2);
            // int int3 = Integer.parseInt(display3);
            int result = int1 * int2;
            display = "" + result;
        } else if (id == "dividere") {
            float int1 = Float.parseFloat(display);
            float int2 = Float.parseFloat(display2);
            // int int3 = Integer.parseInt(display3);
            float result = int2 / int1;
            display = "" + result;
        }
    }

    public void mSave() {
        memory = display;
    }

    public void mRecall() {
        display = "" + memory;
    }

    public void mClear() {
        memory = "";
    }

    public void mClearAndSave() {
        memory = display;
        display = "";
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
