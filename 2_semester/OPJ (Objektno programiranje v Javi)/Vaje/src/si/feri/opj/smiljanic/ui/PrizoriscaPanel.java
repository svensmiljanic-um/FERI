package si.feri.opj.smiljanic.ui; // Mapa, kjer se datoteka nahaja

import infrastruktura.Dvorana;
import infrastruktura.Prizorisce;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrizoriscaPanel {
    private JLabel Naslov;
    private JLabel ime;
    private JTextField vnosIme;
    private JButton ustvariButton;
    private JButton spremeniButton;
    private JButton izbrisiButton;
    private JPanel mainPanel;
    private JList<String> listaPrizorisc;
    private DefaultListModel<String> model = new DefaultListModel<>();

    public PrizoriscaPanel() {
        if (listaPrizorisc != null) {
            listaPrizorisc.setModel(model);
        }

        izbrisiButton.addActionListener(new BrisiListener(listaPrizorisc, Baza.vsaPrizorisca));
        ustvariButton.addActionListener(new DodajPrizorisceListener());
        spremeniButton.addActionListener(new SpremeniPrizorisceListener());

        listaPrizorisc.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int index = listaPrizorisc.getSelectedIndex();
                if (index != -1) {
                    Prizorisce p = Baza.vsaPrizorisca.get(index);
                    vnosIme.setText(p.getIme());
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private class DodajPrizorisceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String imePrizorisca = vnosIme.getText();
            if (!imePrizorisca.isEmpty()) {
                Prizorisce novo = new Dvorana(imePrizorisca, "000-000-000", 100, true);
                Baza.vsaPrizorisca.add(novo);
                osveziSeznam();
                vnosIme.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Vnesite ime prizorišča!");
            }
        }
    }

    private class SpremeniPrizorisceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = listaPrizorisc.getSelectedIndex();
            if (index != -1) {
                String novoIme = vnosIme.getText();
                if (!novoIme.isEmpty()) {
                    // Posodobimo obstoječi objekt v ArrayList kolekciji
                    Prizorisce p = Baza.vsaPrizorisca.get(index);
                    p.setIme(novoIme);

                    osveziSeznam();
                    vnosIme.setText("");
                    JOptionPane.showMessageDialog(null, "Prizorišče uspešno posodobljeno.");
                } else {
                    JOptionPane.showMessageDialog(null, "Vnesite novo ime prizorišča!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Prosim, izberite prizorišče na seznamu!");
            }
        }
    }

    public void osveziSeznam() {
        model.clear();
        for (Prizorisce p : Baza.vsaPrizorisca) {
            model.addElement(p.getIme());
        }
    }
}