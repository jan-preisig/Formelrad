package application;

import static application.Main.lblWarnung;

/**
 * Berechnet das Formelrad
 *
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Calculator {

    private double leistung;
    private double strom;
    private double widerstand;
    private double spannung;

    public Calculator(double leistung, double spannung, double strom, double widerstand) {
        super();
        this.leistung = leistung;
        this.spannung = spannung;
        this.strom = strom;
        this.widerstand = widerstand;
    }

    public double pAusUundI(double u, double i) {
        return u * i;
    }

    public double pAusUundR(double u, double r) {
        return (u * u) / r;
    }

    public double pAusRundI(double r, double i) {
        return r * (i * i);
    }

    public double iAusPundR(double p, double r) {
        return Math.sqrt(p / r);
    }

    public double iAusPundU(double p, double u) {
        return p / u;
    }

    public double iAusUundR(double u, double r) {
        return u / r;
    }

    public double getLeistung() {
        return leistung;
    }

    public double getSpannung() {
        return spannung;
    }

    public double getStrom() {
        return strom;
    }

    public double getWiderstand() {
        return widerstand;
    }

    @Override
    public String toString() {
        return "Calculator [leistung=" + leistung +
                ", spannung=" + spannung +
                ", strom=" + strom +
                ", widerstand=" + widerstand + "]";
    }

    private boolean warning() {
        boolean warning = false;
        boolean fields[] = new boolean[4];

        fields[0] = leistung != 0;
        fields[1] = spannung != 0;
        fields[2] = strom != 0;
        fields[3] = widerstand != 0;

        int count = 0;
        for (int i = 0; i < fields.length; i++) {
            if (fields[i] = true) {
                count++;
            }
        }
        if (count > 2) warning = true;

        return warning;
    }

    public void calculate() {
        /* Hier auf Grund der vorhanden Werte entscheiden
         * welche Methode unten aufgerufen werden muss.
         */
        if (warning()) {
            lblWarnung.setText("Es müssen mindestens 2 Felder 0 sein!");
        } else {
            lblWarnung.setText("");
            if (leistung != 0 && strom != 0) {
                spannung = uAusPundI(leistung, strom);
                widerstand = rAusPundI(leistung, strom);
            } else if (spannung != 0 && widerstand != 0) {
                leistung = pAusUundR(spannung, widerstand);
                strom = iAusUundR(spannung, widerstand);
            } else if (leistung != 0 && spannung != 0) {
                widerstand = rAusUundP(spannung, leistung);
                strom = iAusPundU(leistung, spannung);
            }
        }
    }

    /* Hier die Methoden mit den Formlen hinzufügen
     */

    public double uAusRundI(Double r, Double i) {
        return r * i;
    }

    public double uAusPundI(Double p, Double i) {
        return p / i;
    }

    public double uAusPundR(Double p, Double r) {
        return Math.sqrt(p * r);
    }

    public double rAusUundI(Double u, Double i) {
        return u / i;
    }

    public double rAusPundI(Double p, Double i) {
        return p / Math.pow(i, i);
    }

    public double rAusUundP(Double u, Double p) {
        return Math.pow(u, u) / p;
    }


}
