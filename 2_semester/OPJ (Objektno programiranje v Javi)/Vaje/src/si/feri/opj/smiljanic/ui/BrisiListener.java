package si.feri.opj.smiljanic.ui; // Mapa, kjer se datoteka nahaja

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BrisiListener implements ActionListener {
    private JList<?> lista;
    private ArrayList<?> kolekcija;
    private DefaultListModel<?> model;

    public BrisiListener(JList<?> lista, ArrayList<?> kolekcija) {
        this.lista = lista;
        this.kolekcija = kolekcija;
        this.model = (DefaultListModel) model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = lista.getSelectedIndex();
        if (index != -1) {
            // Izbris iz ArrayList v bazi
            kolekcija.remove(index);
            // Izbris iz vizualnega modela (DefaultListModel)
            DefaultListModel model = (DefaultListModel) lista.getModel();
            model.remove(index);
            JOptionPane.showMessageDialog(null, "Element izbrisan.");
        } else {
            JOptionPane.showMessageDialog(null, "Prosim, izberite element v seznamu.");
        }
    }
}