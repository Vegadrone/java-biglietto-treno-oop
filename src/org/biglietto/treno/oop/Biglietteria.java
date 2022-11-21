package org.biglietto.treno.oop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Biglietteria {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Biglietto b1 = null;
		
		try {
			System.out.print("Inserire l'età del passeggero: ");
			int etaPasseggero = sc.nextInt();
			
			System.out.print("Inserire km da percorrere: ");
			int kmPasseggero = sc.nextInt();
			
			System.out.print("Tariffa Flessibile: true/false");
			boolean flessibile = sc.nextBoolean();
		
			b1 = new Biglietto (etaPasseggero, kmPasseggero, flessibile);
			System.out.println(b1.toString());
			
			sc.close();
			
		} catch (Exception e ) {
			System.err.println(e.getMessage());
		}
		
		FileWriter w = null;
		
		try {
			w = new FileWriter("./biglietto-treno.txt", true);
			w.write("\n" + b1.toString());
			w.write("\n----------");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				w.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		File f = new File("./biglietto-treno.txt");
		
		Scanner filesc = null;
		
		try {
			filesc = new Scanner(f);
			
			while(filesc.hasNextLine()) {
				String line = filesc.nextLine();
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} finally {
			filesc.close();
		}
	}
}
