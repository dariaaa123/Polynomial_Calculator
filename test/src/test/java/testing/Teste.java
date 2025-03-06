package testing;
import org.example.Operatii;
import org.example.Polinom;
import org.junit.Test;
import static org.junit.Assert.*;

public class Teste {
    @Test
    public void testDerivare() {
        Polinom poli1 = new Polinom();
        poli1.adaugaMonoame("2x+1");
        Operatii operatie=new Operatii();
        Polinom rez=operatie.deriveaza(poli1);
        String rezultat=rez.dinPolinomInString(rez);
        assertEquals("2",rezultat);

    }
    @Test
    public void testIntegrare() {
        Polinom poli1 = new Polinom();
        poli1.adaugaMonoame("2x+1");
        Operatii operatie=new Operatii();
        Polinom rez=operatie.integreaza(poli1);
        String rezultat=rez.dinPolinomInString(rez);
        assertEquals("1x^2+1x",rezultat);

    }
    @Test
    public void testAdunare() {
        Polinom poli1 = new Polinom();
        Polinom poli2 = new Polinom();
        Polinom rez= new Polinom();
        poli1.adaugaMonoame("2x+1");
        poli2.adaugaMonoame("-2x-1");
        Operatii operatie=new Operatii();
        rez.setPolinom(operatie.aduna(poli1,poli2));
        String rezultat=rez.dinPolinomInString(rez);
        assertEquals("0",rezultat);

    }
    @Test
    public void testScadere() {
        Polinom poli1 = new Polinom();
        Polinom poli2 = new Polinom();
        Polinom rez= new Polinom();
        poli1.adaugaMonoame("2x+1");
        poli2.adaugaMonoame("-2x-1");
        Operatii operatie=new Operatii();
        rez.setPolinom(operatie.scade(poli1,poli2));
        String rezultat=rez.dinPolinomInString(rez);
        assertEquals("4x+2",rezultat);

    }
    @Test
    public void testInmultire() {
        Polinom poli1 = new Polinom();
        Polinom poli2 = new Polinom();
        Polinom rez= new Polinom();
        poli1.adaugaMonoame("2x+1");
        poli2.adaugaMonoame("-2x-1");
        Operatii operatie=new Operatii();
        rez.setPolinom(operatie.inmulteste(poli1,poli2));
        String rezultat=rez.dinPolinomInString(rez);
        assertEquals("-4x^2-4x-1",rezultat);

    }
    @Test
    public void testImpartire() {
        Polinom poli1 = new Polinom();
        Polinom poli2 = new Polinom();
        poli1.adaugaMonoame("2x+1");
        poli2.adaugaMonoame("-2x-1");
        Operatii operatie=new Operatii();
        Polinom rez=operatie.imparte(poli1,poli2);
        String rezultat=rez.dinPolinomInString(rez);
        assertEquals("-1",rezultat);

    }


}
