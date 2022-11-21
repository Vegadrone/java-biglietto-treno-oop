package org.biglietto.treno.oop;

import java.util.Scanner;

public class Biglietteria {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		try {
			System.out.print("Inserire l'età del passeggero: ");
			int etaPasseggero = sc.nextInt();
			
			System.out.print("Inserire km da percorrere: ");
			int kmPasseggero = sc.nextInt();
			
			Biglietto b1 = new Biglietto (etaPasseggero, kmPasseggero);
			System.out.println(b1.toString());			
			
		} catch (Exception e ) {
			System.err.println(e.getMessage());
		}
	}
}
