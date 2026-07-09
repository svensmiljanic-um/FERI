package si.feri.opj.smiljanic.ui; // Mapa, kjer se datoteka nahaja

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sport.Sportnik;

public class SportnikiPanel {
    private JLabel Naslov;
    private JLabel Ime;
    private JTextField vnosIme;
    private JLabel Priimek;
    private JTextField vnosPriimek;
    private JButton ustvariButton;
    private JButton spremeniButton;
    private JButton izbrisiButton;
    private JPanel mainPanel;
    private JList<String> list1;
    private DefaultListModel<String> model = new DefaultListModel<>();

    public SportnikiPanel() {
        izbrisiButton.addActionListener(new BrisiListener(list1, Baza.vsiSportniki));
        ustvariButton.addActionListener(new DodajSportnikaListener());
        spremeniButton.addActionListener(new SpremeniSportnikaListener());

        if (list1 != null) {
            list1.setModel(model);
        } else {
            System.err.println("Opozorilo: list1 je null. Preveri povezavo v .form datoteki.");
        }

        list1.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int index = list1.getSelectedIndex();
                if (index != -1) {
                    Sportnik s = Baza.vsiSportniki.get(index);
                    vnosIme.setText(s.getIme());
                    vnosPriimek.setText(s.getPriimek());
                }
            }
        });
    }

    private class DodajSportnikaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Branje podatkov iz grafičnih komponent
            String ime = vnosIme.getText();
            String priimek = vnosPriimek.getText();

            if (!ime.isEmpty() && !priimek.isEmpty()) {
                // Ustvarjanje novega objekta in dodajanje v ArrayList
                Sportnik novSportnik = new Sportnik(ime, priimek);
                Baza.vsiSportniki.add(novSportnik);

                // Osvežimo vizualni seznam
                osveziSeznam();

                // Počistimo vnosna polja
                vnosIme.setText("");
                vnosPriimek.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Vnesite ime in priimek!");
            }
        }
    }

    private class SpremeniSportnikaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = list1.getSelectedIndex();

            if (index != -1) {
                String novoIme = vnosIme.getText();
                String novPriimek = vnosPriimek.getText();

                if (!novoIme.isEmpty() && !novPriimek.isEmpty()) {
                    // Posodobimo objekt v ArrayList kolekciji (Točka a)
                    Sportnik s = Baza.vsiSportniki.get(index);
                    s.setIme(novoIme);
                    s.setPriimek(novPriimek);

                    // Osvežimo vizualni prikaz
                    osveziSeznam();
                    JOptionPane.showMessageDialog(null, "Podatki športnika so bili spremenjeni.");
                } else {
                    JOptionPane.showMessageDialog(null, "Vnesite nove podatke v polja!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Prosim, izberite športnika na seznamu!");
            }
        }
    }

    // Metoda, ki sinhronizira ArrayList s prikazom v JList
    public void osveziSeznam() {
        model.clear();
        for (Sportnik s : Baza.vsiSportniki) {
            model.addElement(s.getIme() + " " + s.getPriimek());
        }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}