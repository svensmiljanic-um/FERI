package sport;

import infrastruktura.PlezalniCenter;
import infrastruktura.PlezalnaSmer;

public class Tekmovalec implements Runnable {
    private String ime;
    private String priimek;
    private int stevilkaTekmovalca;
    private PlezalniCenter center;
    private int preplezaneSmeri = 0;

    public Tekmovalec(String ime, String priimek, int stevilkaTekmovalca, PlezalniCenter center) {
        this.ime = ime;
        this.priimek = priimek;
        this.stevilkaTekmovalca = stevilkaTekmovalca;
        this.center = center;
    }

    public int getPreplezaneSmeri() {
        return preplezaneSmeri;
    }

    public int getStevilkaTekmovalca() {
        return stevilkaTekmovalca;
    }

    @Override
    public void run() {
        System.out.println("Tekmovalec št. " + stevilkaTekmovalca + " začne tekmovati.");
        while (true) {
            PlezalnaSmer smer = center.pripraviTekmovalnoSmer();
            if (smer == null) break; // Ni več smeri

            try {
                Thread.sleep((long) (Math.random() * 1000) + 500);
                preplezaneSmeri++;
                System.out.println("TEKMOVALEC: " + stevilkaTekmovalca +
                        " | PREPLEZANIH: " + preplezaneSmeri +
                        " | SMER: [" + smer.getOznaka() + "] " + smer.getIme() +
                        " (" + smer.getTezavnost() + ")");

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
