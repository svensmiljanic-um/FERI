package si.feri.opj.smiljanic.ui; // Mapa, kjer se datoteka nahaja

import javax.swing.*; //za okna, gumbe, panele
import java.awt.*; //za CardLayout in dogodke ob klikih
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GlavnoOkno extends JFrame {
    private JPanel mainPanel;
    private JPanel menuPanel;
    private JButton gumbSportniki;
    private JButton gumbPrizorisca;
    private JButton gumbDogodki;
    private JPanel contentPanel;

    private SportnikiPanel sportnikiPanel = new SportnikiPanel();
    private PrizoriscaPanel prizoriscaPanel = new PrizoriscaPanel();
    private DogodkiPanel dogodkiPanel = new DogodkiPanel();
    /*
    Ustvarimo 3 posebne objekte, ki predstavljajo vsebino vsakega zavihka.
     */

    public GlavnoOkno() {
        UpravljalecDatotek.naloziPodatke(); // Naredi tabele ob zagonu
        setContentPane(mainPanel); // Okvir z glavnim Dashboardom
        setTitle("Športni informacijski sistem"); // Naslov, ki je zgoraj na sredini okna
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Rdeči X zgoraj v kotu
        setSize(800, 600); // Velikost okna
        setLocationRelativeTo(null); // Okno na sredini ekrana

        // KARTICE ZA CARDLAYOUT
        contentPanel.add(sportnikiPanel.getMainPanel(), "KARTICA_SPORTNIKI");
        contentPanel.add(prizoriscaPanel.getMainPanel(), "KARTICA_PRIZORISCA");
        contentPanel.add(dogodkiPanel.getMainPanel(), "KARTICA_DOGODKI");

        // IMPLEMENTACIJA Z ANONIMNIMI RAZREDI - metoda, da ustvarimo razred brez imena
        gumbSportniki.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) contentPanel.getLayout();
                cl.show(contentPanel, "KARTICA_SPORTNIKI");
            }
        });

        gumbPrizorisca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) contentPanel.getLayout();
                cl.show(contentPanel, "KARTICA_PRIZORISCA");
            }
        });

        gumbDogodki.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) contentPanel.getLayout();
                cl.show(contentPanel, "KARTICA_DOGODKI");
            }
        });

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                UpravljalecDatotek.shraniPodatke(); // Shrani podatke ob izhodu
            }
        });
    }

    public static void main(String[] args) {
        GlavnoOkno okno = new GlavnoOkno();
        okno.setVisible(true); // Prikaže okno na zaslonu
    }
}