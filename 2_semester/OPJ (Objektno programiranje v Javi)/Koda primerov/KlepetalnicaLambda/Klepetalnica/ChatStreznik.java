package Klepetalnica;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatStreznik {

	ArrayList<Uporabnik> uporabniki;

	ChatStreznik() {

		uporabniki = new ArrayList<Uporabnik>();

		try {
			ServerSocket prijavnaTocka = new ServerSocket(7777);

			while (true) {

				Socket kontakt = prijavnaTocka.accept();

				BufferedReader vhodni = new BufferedReader(new InputStreamReader(kontakt.getInputStream()));
				PrintWriter izhodni = new PrintWriter(new OutputStreamWriter((kontakt.getOutputStream())));

				Uporabnik novi = new Uporabnik(vhodni, izhodni, this);

				uporabniki.add(novi);

				new Thread(novi).start();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void poslji(String sporocilo) {

		for (Uporabnik clan : uporabniki) {

			clan.izhod.println(sporocilo);

			clan.izhod.flush();

		}

	}

	public static void main(String[] args) {
		new ChatStreznik();
	}

}
