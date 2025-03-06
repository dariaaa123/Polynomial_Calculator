package org.example;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {

    private Map<Integer, Monom> polinom;

    public Polinom() {
        this.polinom = new HashMap<>();
    }

    public Map<Integer, Monom> getPolinom() {
        return polinom;
    }

    public void setPolinom(Map<Integer, Monom> polinom) {
        this.polinom = polinom;
    }

    public void adaugaMonoame(String polinom) {

        int exponent;
        Double coeficient;
        Pattern p = Pattern.compile("([-]?\\d+)x?[\\^]?(\\d+)?");
        Matcher m = p.matcher(polinom);
        while (m.find()) {
            coeficient = Double.parseDouble(m.group(1));

            if (null != m.group(2) && m.group(0).contains("^")) {
                exponent = Integer.parseInt(m.group(2));
            } else {
                int este = m.group(0).indexOf('x');
                if (este == -1) {
                    exponent = 0;
                } else {
                    exponent = 1;
                }
            }
            Monom monom = new Monom(coeficient, exponent);
            this.polinom.put(exponent, monom);
        }

    }
    public String dinPolinomInString(Polinom poli) {
        String rezultat = "";
        Iterator<Map.Entry<Integer, Monom>> iterator1 = poli.getPolinom().entrySet().iterator();
        while (iterator1.hasNext()) {
            Map.Entry<Integer, Monom> entry = iterator1.next();
           String coef = entry.getValue().getCoeficient().toString();
            if (coef.endsWith(".0"))
                coef = coef.substring(0, coef.length() - 2);
            if (entry.getValue().getCoeficient() != 0) {
                if (entry.getValue().getExponent() != 0) {
                    if (entry.getValue().getCoeficient() < 0) {
                        if (entry.getValue().getExponent() == 1)
                            rezultat = coef + "x" + rezultat;
                        else
                            rezultat = coef + "x^" + entry.getValue().getExponent() + rezultat;
                    } else if (entry.getValue().getExponent() == 1)
                        rezultat = "+" + coef + "x" + rezultat;
                    else
                        rezultat = "+" + coef + "x^" + entry.getValue().getExponent() + rezultat;
                } else if (entry.getValue().getCoeficient() < 0)

                    rezultat = coef + rezultat;
                else
                    rezultat = "+" + coef + rezultat;
            }
        }
        if (rezultat.indexOf('+') == 0)
            return rezultat.substring(1);
        if (rezultat == "") rezultat = "0";
        return rezultat;
    }
}






