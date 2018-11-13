package application;

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
  private String warnung = "";

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

  public String getWarnung() {
    return warnung;
  }

  @Override
  public String toString() {
    return "Calculator [leistung=" + leistung + ", spannung=" + spannung + ", strom=" + strom + ", widerstand="
        + widerstand + "]";
  }

  public void calculate() {
    /* Hier auf Grund der vorhanden Werte entscheiden
     * welche Methode unten aufgerufen werden muss.
     */
    int countSet = 0;
    if (leistung != 0) {
      countSet++;
    }
    if (strom != 0) {
      countSet++;
    }
    if (widerstand != 0) {
      countSet++;
    }
    if (spannung != 0) {
      countSet++;
    }
    if (countSet > 2) {
      warnung = "Zu viele Felder ausgefüllt!";
    }
    if (leistung != 0 && widerstand != 0) {
      spannung = uAusPundR(leistung, widerstand);
      strom = iAusPundR(leistung, widerstand);
    } else if (spannung != 0 && strom != 0) {
      leistung = pAusUundI(spannung, strom);
      widerstand = rAusUundI(spannung, strom);
    } else if (leistung != 0 && strom != 0) {
      spannung = uAusPundI(leistung, strom);
      widerstand = rAusPundI(leistung, strom);
    } else if (strom != 0 && widerstand != 0) {
      spannung = uAusRundI(widerstand, strom);
      leistung = pAusRundI(widerstand, strom);
    } else if (widerstand != 0 && spannung != 0) {
      leistung = pAusUundR(spannung, widerstand);
      strom = iAusUundR(spannung, widerstand);
    } else if (spannung != 0 && leistung != 0) {
      strom = iAusPundU(leistung, spannung);
      widerstand = rAusUundP(leistung, spannung);
    }
  }

  /* Hier die Methoden mit den Formlen hinzuf�gen
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
