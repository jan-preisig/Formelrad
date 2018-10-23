package application;

/**
 * Berechnet das Formelrad
 *
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Calculator {

    private final double leistung;
    private final double spannung;
    private final double strom;
    private final double widerstand;

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

    public void calculate() {
        /* Hier auf Grund der vorhanden Werte entscheiden
         * welche Methode unten aufgerufen werden muss.
         */
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
