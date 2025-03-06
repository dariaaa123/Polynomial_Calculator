package org.example;

import java.util.*;

public class Operatii {


    public Map<Integer, Monom> aduna(Polinom p1, Polinom p2) {
        Map<Integer, Monom> p3 = new HashMap<>();
        for (Map.Entry<Integer, Monom> entry1 : p1.getPolinom().entrySet()) {
            Integer grad1 = entry1.getKey();
            Monom value1 = entry1.getValue();
            Monom value2 = p2.getPolinom().get(grad1);

            if (value2 != null) {
                Monom value3 = new Monom(value1.getCoeficient() + value2.getCoeficient(), grad1);
                if (value3.getCoeficient() != 0)
                    p3.put(grad1, value3);
                p2.getPolinom().remove(grad1);
            } else {
                p3.put(grad1, value1);
            }
        }
        for (Map.Entry<Integer, Monom> entry2 : p2.getPolinom().entrySet()) {
            Integer grad2 = entry2.getKey();
            Monom value2 = entry2.getValue();
            value2.setCoeficient(value2.getCoeficient());
            p3.put(grad2, value2);
        }
        if (p3.isEmpty()) {
            Monom monom = new Monom(0.0, 0);
            p3.put(0, monom);
        }
        return p3;
    }

    public Map<Integer, Monom> scade(Polinom p1, Polinom p2) {
        Map<Integer, Monom> p3 = new HashMap<>();
        for (Map.Entry<Integer, Monom> entry1 : p1.getPolinom().entrySet()) {
            Integer grad1 = entry1.getKey();
            Monom value1 = entry1.getValue();
            Monom value2 = p2.getPolinom().get(grad1);

            if (value2 != null) {
                Monom value3 = new Monom(value1.getCoeficient() - value2.getCoeficient(), grad1);
                if (value3.getCoeficient() != 0)
                    p3.put(grad1, value3);
                p2.getPolinom().remove(grad1);
            } else {
                p3.put(grad1, value1);
            }
        }
        for (Map.Entry<Integer, Monom> entry2 : p2.getPolinom().entrySet()) {
            Integer grad2 = entry2.getKey();
            Monom value2 = entry2.getValue();
            value2.setCoeficient(-value2.getCoeficient());
            p3.put(grad2, value2);
        }
        if (p3.isEmpty()) {
            Monom monom = new Monom(0.0, 0);
            p3.put(0, monom);
        }
        return p3;
    }

    public Map<Integer, Monom> inmulteste(Polinom p1, Polinom p2) {
        Map<Integer, Monom> p3 = new HashMap<>();

        for (Map.Entry<Integer, Monom> entry1 : p1.getPolinom().entrySet()) {
            Integer grad1 = entry1.getKey();
            Monom value1 = entry1.getValue();
            for (Map.Entry<Integer, Monom> entry2 : p2.getPolinom().entrySet()) {
                Integer grad2 = entry2.getKey();
                Monom value2 = entry2.getValue();
                Integer grad3 = grad1 + grad2;
                Double value3 = value1.getCoeficient() * value2.getCoeficient();
                Monom monom3 = new Monom(value3, grad3);

                if (p3.containsKey(grad3)) {
                    p3.get(grad3).setCoeficient(p3.get(grad3).getCoeficient() + value3);
                    if (p3.get(grad3).getCoeficient() == 0) {
                        p3.remove(grad3);
                    }
                } else {
                    p3.put(grad3, monom3);
                    if (p3.get(grad3).getCoeficient() == 0) {
                        p3.remove(grad3);
                    }
                }
            }
        }
        Monom monomZero = new Monom(0.0, 0);
        if (p3.isEmpty())
            p3.put(0, monomZero);
        return p3;
    }

    Integer extrageExponentulMaxim(Polinom polinom) {
        Integer i = -1;
        for (Map.Entry<Integer, Monom> entry : polinom.getPolinom().entrySet()) {
            i = entry.getKey();
        }
        return i;
    }

    public Polinom imparte(Polinom p1, Polinom p2) {
        Polinom p3 = new Polinom();
        Integer a = extrageExponentulMaxim(p1);
        Integer b = extrageExponentulMaxim(p2);
        while (a >= b && p1.getPolinom().get(a).getCoeficient() != 0) {
            Monom monom = new Monom(p1.getPolinom().get(a).getCoeficient() / p2.getPolinom().get(b).getCoeficient(), a - b);
            if (p3.getPolinom().containsKey(a - b) == false)
                p3.getPolinom().put(a - b, monom);
            else
                p3.getPolinom().get(a - b).setCoeficient(p3.getPolinom().get(a - b).getCoeficient() + monom.getCoeficient());
            Polinom semip3 = new Polinom();
            semip3.getPolinom().put(a - b, p3.getPolinom().get(a - b));
            Polinom minusUnu = new Polinom();
            Monom minusOne = new Monom(-1.0, 0);
            Map<Integer, Monom> mapa = new HashMap<>();
            mapa.put(0, minusOne);
            minusUnu.setPolinom(mapa);
            Polinom aux = new Polinom();
            aux.setPolinom(inmulteste(semip3, minusUnu));
            Polinom aux1 = new Polinom();
            aux1.setPolinom(inmulteste(aux, p2));
            p1.setPolinom(aduna(p1, aux1));
            a = extrageExponentulMaxim(p1);
            if (p1.getPolinom().get(extrageExponentulMaxim(p1)).getExponent() < p2.getPolinom().get(extrageExponentulMaxim(p2)).getExponent())
                break;
            if (p3.getPolinom().containsKey(0) && p3.getPolinom().get(0).getCoeficient() == 0)
                break;
        }
        return p3;
    }

    public Polinom deriveaza(Polinom poli) {
        Polinom rezultat = new Polinom();
        Iterator<Map.Entry<Integer, Monom>> iterator = poli.getPolinom().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Monom> entry = iterator.next();
            Monom monom = new Monom(entry.getValue().getCoeficient() * entry.getValue().getExponent(), entry.getValue().getExponent() - 1);
            if (entry.getValue().getExponent() - 1 != -1)
                rezultat.getPolinom().put(entry.getValue().getExponent() - 1, monom);
        }
        return rezultat;
    }

    public Polinom integreaza(Polinom poli) {
        Polinom rezultat = new Polinom();
        Iterator<Map.Entry<Integer, Monom>> iterator = poli.getPolinom().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Monom> entry = iterator.next();
            Monom monom = new Monom(entry.getValue().getCoeficient() / (entry.getValue().getExponent() + 1), entry.getValue().getExponent() + 1);
            rezultat.getPolinom().put(entry.getValue().getExponent() + 1, monom);
        }
        return rezultat;
    }
}