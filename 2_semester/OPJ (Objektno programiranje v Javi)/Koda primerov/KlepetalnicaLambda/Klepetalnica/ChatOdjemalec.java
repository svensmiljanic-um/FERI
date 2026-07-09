package Klepetalnica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatOdjemalec implements Runnable {

	private BufferedReader vhodni;
	
	public ChatOdjemalec(BufferedReader vhod) {
		vhodni = vhod;
	}

	public void run() {

		String sporociloSStreznika;

		while (true) {

			try {
				sporociloSStreznika = vhodni.readLine();
				System.out.println("***" + sporociloSStreznika);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// bomo poslusali, ce nam je streznik kaj poslal

	}

	public static void main(String[] args) {

		try {

			Scanner konzola = new Scanner(System.in);
			System.out.println("Kdo si?");
			String ime = konzola.nextLine();
			Socket kanal = new Socket("localhost", 7777);

			InputStream i = kanal.getInputStream();
			OutputStream o = kanal.getOutputStream();

			BufferedReader vhod = new BufferedReader(new InputStreamReader(i));
			PrintWriter izhod = new PrintWriter(new OutputStreamWriter(o));

			new Thread(new ChatOdjemalec(vhod)).start();

			while (true) {
				izhod.println(ime + ": "+ new BufferedReader(new InputStreamReader(System.in)).readLine());
				izhod.flush();
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
