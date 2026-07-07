package si.feri.opj.smiljanic.ui; // Mapa, kjer se datoteka nahaja

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sport.Tekma;
import sport.Trening;
import sport.Termin;
import java.time.LocalDate;

public class DogodkiPanel {
    private JTextField vnosNaziv;
    private JTextField vnosDatum;
    private JLabel trener;
    private JTextField vnosTrener;
    private JList<String> list1;
    private JLabel Naziv;
    private JPanel mainPanel;
    private JButton gumbSpremeniDogodek;
    private JLabel naslov;
    private JButton gumbIzbrisiDogodek;
    private JButton gumbIzbrisiSportnika;
    private JButton gumbUstvariSportnika;
    private JLabel Datum;
    private JButton gumbUstvariTekmo;
    private JButton gumbUstvariTrening;
    private DefaultListModel<String> model = new DefaultListModel<>(); // Hrani podatke in osvežuje seznam

    public DogodkiPanel() {
        list1.setModel(model);

        gumbUstvariTekmo.addActionListener(new DodajDogodekListener(true));
        gumbUstvariTrening.addActionListener(new DodajDogodekListener(false));
        gumbIzbrisiDogodek.addActionListener(new BrisiListener(list1, Baza.vsiDogodki));
        gumbSpremeniDogodek.addActionListener(new SpremeniDogodekListener());
        gumbUstvariSportnika.addActionListener(new DodajSportnikaNaDogodekListener());

        // Poslušalec za izbiro v seznamu
        list1.addListSelectionListener(e -> {
            // lambda - izvede vsakič, ko uporabnik z miško klikne na določen dogodek v seznamu
            if (!e.getValueIsAdjusting()) {
                // !e.getValueIsAdjusting() - poskrbi, da se koda izvede samo enkrat na klik
                int index = list1.getSelectedIndex();
                if (index != -1) {
                    Object d = Baza.vsiDogodki.get(index);
                    if (d instanceof Tekma) {
                        Tekma t = (Tekma) d;
                        vnosNaziv.setText(t.getNaziv());
                        vnosDatum.setText(t.getTermin().getTermin().toString());
                        vnosTrener.setText("");
                    } else if (d instanceof Trening) {
                        Trening tr = (Trening) d;
                        vnosNaziv.setText(tr.getNaziv());
                        vnosTrener.setText(tr.getImeTrenerja());
                        vnosDatum.setText("");
                    }
                }
            }
        });

        gumbIzbrisiSportnika.addActionListener(e -> {
            int indexDogodka = list1.getSelectedIndex();

            if (indexDogodka != -1) {
                sport.Dogodek dogodek = Baza.vsiDogodki.get(indexDogodka);

                // Preverimo, če so na dogodku sploh kakšni športniki
                if (dogodek.getSeznamSportnikov().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Na tem dogodku ni nobenega športnika."); // Pop-up
                    return;
                }

                // Ustvarimo seznam imen športnikov, ki so trenutno na dogodku
                java.util.ArrayList<sport.Sportnik> sportnikiNaDogodku = dogodek.getSeznamSportnikov();
                String[] imena = new String[sportnikiNaDogodku.size()];
                for (int i = 0; i < sportnikiNaDogodku.size(); i++) {
                    imena[i] = sportnikiNaDogodku.get(i).getIme() + " " + sportnikiNaDogodku.get(i).getPriimek();
                }

                // Prikažemo okno za izbiro športnika za izbris
                String zaIzbris = (String) JOptionPane.showInputDialog(
                        null, "Izberite športnika, ki ga želite odstraniti:", "Odstranjevanje",
                        JOptionPane.QUESTION_MESSAGE, null, imena, imena[0]);

                if (zaIzbris != null) {
                    // Poiščemo izbranega športnika in ga odstranimo
                    int indexZaIzbris = -1;
                    for (int i = 0; i < imena.length; i++) {
                        if (imena[i].equals(zaIzbris)) indexZaIzbris = i;
                    }

                    if (indexZaIzbris != -1) {
                        dogodek.getSeznamSportnikov().remove(indexZaIzbris);
                        osveziPrikaz(); // Osvežimo JList, da izgine ime športnika
                        JOptionPane.showMessageDialog(null, "Športnik odstranjen z dogodka.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Najprej izberite dogodek na seznamu!");
            }
        });
    }

    private class DodajDogodekListener implements ActionListener {
        private boolean jeTekma;

        public DodajDogodekListener(boolean jeTekma) {
            this.jeTekma = jeTekma;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String naziv = vnosNaziv.getText();
            String datumString = vnosDatum.getText();

            if (!naziv.isEmpty()) {
                try {
                    if (jeTekma) {
                        LocalDate datumLD = LocalDate.parse(datumString);
                        Termin termin = new Termin(datumLD);
                        Baza.vsiDogodki.add(new Tekma(naziv, termin));
                    } else {
                        Trening novTrening = new Trening(naziv);
                        novTrening.setImeTrenerja(vnosTrener.getText());
                        Baza.vsiDogodki.add(novTrening);
                    }
                    osveziPrikaz();
                    pocistiPolja();
                } catch (Exception ex) {
                    Loger.zapisiDogodek("NAPAKA", "Neuspešno dodajanje dogodka: " + ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Napaka pri vnosu podatkov (preveri format datuma LLLL-MM-DD).");
                }
            }
        }
    }

    private class SpremeniDogodekListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = list1.getSelectedIndex();

            if (index != -1) {
                String naziv = vnosNaziv.getText();
                Object d = Baza.vsiDogodki.get(index);

                if (!naziv.isEmpty()) {
                    if (d instanceof Tekma) {
                        Tekma t = (Tekma) d;
                        t.setNaziv(naziv);
                        try {
                            LocalDate novDatum = LocalDate.parse(vnosDatum.getText());
                            t.setTermin(new Termin(novDatum));
                        } catch (Exception ex) { /* Pusti stari datum, če je vnos napačen */ }
                    } else if (d instanceof Trening) {
                        Trening tr = (Trening) d;
                        tr.setNaziv(naziv);
                        tr.setImeTrenerja(vnosTrener.getText());
                    }

                    osveziPrikaz();
                    pocistiPolja();
                    JOptionPane.showMessageDialog(null, "Dogodek uspešno posodobljen.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Izberite dogodek na seznamu!");
            }
        }
    }

    private class DodajSportnikaNaDogodekListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Preverimo, kateri dogodek je izbran v seznamu
            int indexDogodka = list1.getSelectedIndex();

            if (indexDogodka != -1) {
                // Odpremo pogovorno okno za izbiro športnika iz Baze
                // Ker so športniki v Baza.vsiSportniki, jih moramo uporabniku prikazati
                if (Baza.vsiSportniki.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "V bazi ni športnikov! Najprej jih ustvarite.");
                    return;
                }

                // Ustvarimo seznam imen športnikov za izbiro
                String[] imena = new String[Baza.vsiSportniki.size()];
                for (int i = 0; i < Baza.vsiSportniki.size(); i++) {
                    imena[i] = Baza.vsiSportniki.get(i).getIme() + " " + Baza.vsiSportniki.get(i).getPriimek();
                }

                String izbranSportnikIme = (String) JOptionPane.showInputDialog(
                        null, "Izberite športnika:", "Dodajanje na dogodek",
                        JOptionPane.QUESTION_MESSAGE, null, imena, imena[0]);

                if (izbranSportnikIme != null) {
                    // Poiščemo objekt športnika in ga dodamo dogodku
                    int indexSportnika = -1;
                    for (int i = 0; i < imena.length; i++) {
                        if (imena[i].equals(izbranSportnikIme)) indexSportnika = i;
                    }

                    sport.Dogodek dogodek = Baza.vsiDogodki.get(indexDogodka);
                    sport.Sportnik izbran = Baza.vsiSportniki.get(indexSportnika);
                    dogodek.dodajSportnika(izbran);                    osveziPrikaz();
                    JOptionPane.showMessageDialog(null, "Športnik dodan na dogodek!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Najprej izberite dogodek na seznamu!");
            }
        }
    }

    public void osveziPrikaz() {
        model.clear();
        for (Object d : Baza.vsiDogodki) {
            model.addElement(d.toString());
        }
    }

    private void pocistiPolja() {
        vnosNaziv.setText("");
        vnosDatum.setText("");
        vnosTrener.setText("");
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}