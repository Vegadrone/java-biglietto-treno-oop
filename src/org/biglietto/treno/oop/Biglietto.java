package org.biglietto.treno.oop;

import java.math.BigDecimal;

public class Biglietto {
	
	//Setto Variabili d'ambiente
	
	private int etaPasseggero;
	private int kmPasseggero;
	
	//------------------------------------------------------------------------
	
	//Aggiungo le costanti
	
	private static final BigDecimal PREZZO_KM = new BigDecimal(0.21); 

	private static final BigDecimal OVER65_SCONTO = new BigDecimal(0.40);
	
	private static final BigDecimal UNDER18_SCONTO = new BigDecimal (0.20);
	
	//--------------------------------------------------------------------------
	
	//Costruttore
	
	public Biglietto(int etàPasseggero, int kmPasseggero) throws Exception{
		isValidEta(etàPasseggero);
		isValidKm(kmPasseggero);
	}
	
	//-------------------------------------------------------------------------

	// Getter e Setter
	public int getEtaPasseggero() {
		return etaPasseggero;
	}

	public void setEtaPasseggero(int etaPasseggero) {
		this.etaPasseggero = etaPasseggero;
	}

	public int getKmPasseggero() {
		return kmPasseggero;
	}

	public void setKmPasseggero(int kmPasseggero) {
		this.kmPasseggero = kmPasseggero;
	}
	
	//-----------------------------------------------------------------------------
	
	//Metodi
	
	public void isValidKm(int kmPasseggero) throws Exception {
		if (kmPasseggero <= 0) {
			throw new Exception("Non puoi inserire valori negativi o 0");
		} else {
			this.kmPasseggero = kmPasseggero;
		}
	}
	
	public void isValidEta (int etaPasseggero) throws Exception{
		if (etaPasseggero <= 0) {
			throw new Exception("Non puoi inserire valori negativi o 0");
		} else {
			this.etaPasseggero = etaPasseggero;
		}
	}
	
	private BigDecimal calcolaSconti() {
		if (etaPasseggero < 18) {
			return UNDER18_SCONTO.multiply(PREZZO_KM);
		} else if (etaPasseggero > 65) {
			return OVER65_SCONTO.multiply(PREZZO_KM);
		} else {
			return PREZZO_KM;
		}
		
	}
	
	public BigDecimal calcolaPrezzoBiglietto() {
		return calcolaSconti().multiply(BigDecimal.valueOf(kmPasseggero));
	}
	
	
	@Override
	public String toString() {
		return "Km: " + getKmPasseggero()
		+ "\nEtà: " + getEtaPasseggero()
		+ "\nPrezzo: " + calcolaPrezzoBiglietto();
	}
	
}
