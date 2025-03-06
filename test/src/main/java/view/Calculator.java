package view;
import org.example.Operatii;
import org.example.Polinom;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Calculator extends JFrame {
    private JButton derivare;
    private JButton integrare;
    private JButton adunare;
    private JTextField poli1TextField;
    private JTextField poli2TextField;
    private JTextField rezultatTextField;
    private JPanel panelMare;
    private JTextField textField1;
    private JPanel rezultat;
    private JButton impartire;
    private JButton inmultire;
    private JButton scadere;
    private JFrame rama = new JFrame();

    public Calculator() {
        rama.setTitle("My computer");
        rama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rama.add(panelMare);
        ascultaAdunare();
        ascultaInmultire();
        ascultaImpartire();
        ascultaScadere();
        ascultaIntegrare();
        ascultaDerivare();
        rama.setSize(500, 600);
        rama.setLocationRelativeTo(null);
        rama.setVisible(true);
    }

    void ascultaDerivare() {
        derivare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p1 = poli1TextField.getText();
                Polinom poli1 = new Polinom();
                poli1.adaugaMonoame(p1);
                Operatii derivare = new Operatii();
                Polinom rezultat = derivare.deriveaza(poli1);
                String rez = rezultat.dinPolinomInString(rezultat);
                if (rez.equals(""))
                    rez = "0";

                rezultatTextField.setText(rez);
                textField1.setText("");

            }
        });
    }

    void ascultaAdunare() {
        adunare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p1 = poli1TextField.getText();
                String p2 = poli2TextField.getText();
                Polinom poli1 = new Polinom();
                Polinom poli2 = new Polinom();
                Polinom poli3 = new Polinom();
                poli1.adaugaMonoame(p1);
                poli2.adaugaMonoame(p2);
                Operatii adunare = new Operatii();
                poli3.setPolinom(adunare.aduna(poli1, poli2));
                String rezultat = poli1.dinPolinomInString(poli3);
                if (rezultat.equals(""))
                    rezultat = "0";
                rezultatTextField.setText(rezultat);
                textField1.setText("");
            }
        });
    }

    void ascultaScadere() {
        scadere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p1 = poli1TextField.getText();
                String p2 = poli2TextField.getText();
                Polinom poli1 = new Polinom();
                Polinom poli2 = new Polinom();
                Polinom poli3 = new Polinom();
                poli1.adaugaMonoame(p1);
                poli2.adaugaMonoame(p2);
                Operatii scadere = new Operatii();
                poli3.setPolinom(scadere.scade(poli1, poli2));
                String rezultat = poli1.dinPolinomInString(poli3);
                if (rezultat.equals(""))
                    rezultat = "0";
                rezultatTextField.setText(rezultat);
                textField1.setText("");
            }
        });
    }

    void ascultaInmultire() {
        inmultire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p1 = poli1TextField.getText();
                String p2 = poli2TextField.getText();
                Polinom poli1 = new Polinom();
                Polinom poli2 = new Polinom();
                Polinom poli3 = new Polinom();
                poli1.adaugaMonoame(p1);
                poli2.adaugaMonoame(p2);
                Operatii inmultire = new Operatii();
                poli3.setPolinom(inmultire.inmulteste(poli1, poli2));
                String rezultat = poli3.dinPolinomInString(poli3);
                if (rezultat.equals(""))
                    rezultat = "0";
                rezultatTextField.setText(rezultat);
                textField1.setText("");
            }
        });
    }

    void ascultaImpartire() {
        impartire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p1 = poli1TextField.getText();
                String p2 = poli2TextField.getText();
                if (p2.equals("0"))
                    rezultatTextField.setText("nu se poate imparti la 0!");
                else {
                    Polinom poli1 = new Polinom();
                    Polinom poli2 = new Polinom();
                    Polinom poli3;
                    poli1.adaugaMonoame(p1);
                    poli2.adaugaMonoame(p2);
                    Operatii impartire = new Operatii();
                    poli3 = impartire.imparte(poli1, poli2);
                    String rezultat = poli1.dinPolinomInString(poli3);
                    String restt = poli1.dinPolinomInString(poli1);
                    if (rezultat.equals(""))
                        rezultat = "0";
                    rezultatTextField.setText(rezultat);
                    textField1.setText(restt);
                }
            }
        });
    }

    void ascultaIntegrare() {
        integrare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p1 = poli1TextField.getText();
                Polinom poli1 = new Polinom();
                Polinom rezultat;
                poli1.adaugaMonoame(p1);
                Operatii integrare = new Operatii();
                rezultat = integrare.integreaza(poli1);
                String rez = rezultat.dinPolinomInString(rezultat);
                rezultatTextField.setText(rez);
                textField1.setText("");

            }
        });
    }
}



