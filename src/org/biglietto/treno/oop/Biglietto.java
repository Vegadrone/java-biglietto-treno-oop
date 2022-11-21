package org.biglietto.treno.oop;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Biglietto {
	
	//Setto Variabili d'ambiente
	
	private int etaPasseggero;
	private int kmPasseggero;
	
	private boolean flessibile;
	private LocalDate data;
	
	
	//------------------------------------------------------------------------
	
	//Aggiungo le costanti
	
	private static final BigDecimal PREZZO_KM = new BigDecimal(.21); 

	private static final BigDecimal OVER65_SCONTO = new BigDecimal(.40);
	
	private static final BigDecimal UNDER18_SCONTO = new BigDecimal (.20);
	
	private static final BigDecimal PREZZO_FLESSIBILE = new BigDecimal(.10);
	
	private static final int NORMALE = 30;
	private static final int FLESSIBILE = 90;
	
	//--------------------------------------------------------------------------
	
	//Costruttore
	
	public Biglietto(int etàPasseggero, int kmPasseggero, boolean flessibile) throws Exception{
		isValidEta(etàPasseggero);
		isValidKm(kmPasseggero);
		this.flessibile = flessibile;
		this.data = LocalDate.now();
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
		if(flessibile) {
    		return calcolaSconti().multiply(BigDecimal.valueOf(kmPasseggero).multiply(PREZZO_FLESSIBILE));
    	}
		return calcolaSconti().multiply(BigDecimal.valueOf(kmPasseggero));
	}
	
	public LocalDate calcolaScadenza() {
		if (flessibile) {
    		return data.plusDays(FLESSIBILE);
    	} 
    	return data.plusDays(NORMALE);
    }
	
	
	@Override
	public String toString() {
		return "Km: " + getKmPasseggero()
		+ "\nEtà: " + getEtaPasseggero()
		+ "\nPrezzo: " + calcolaPrezzoBiglietto()
		+ "\nFlessibile: " + (flessibile ? "sì" : "no")
		+ "\nData di scadenza: " + calcolaScadenza();
	}
	
}
