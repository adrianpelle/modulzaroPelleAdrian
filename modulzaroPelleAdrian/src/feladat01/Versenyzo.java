package feladat01;

import java.util.Random;

public class Versenyzo implements IFordulok {
	
	private String nev;
	private String rajtazonosito;
	private int abszolutRekord;
	private int reszeredmeny;

	
	public Versenyzo(String nev, String rajtazonosito, int abszolutRekord, int reszeredmeny) {
		this.nev = nev;
		this.rajtazonosito = rajtazonosito;
		this.abszolutRekord = abszolutRekord;
		this.reszeredmeny = reszeredmeny;
	}


	public int getAbszolutRekord() {
		return abszolutRekord;
	}


	public void setAbszolutRekord(int abszolutRekord) {
		this.abszolutRekord = abszolutRekord;
	}


	public int getReszeredmeny() {
		return reszeredmeny;
	}


	public void setReszeredmeny(int reszeredmeny) {
		this.reszeredmeny = reszeredmeny;
	}


	public String getNev() {
		return nev;
	}


	public String getRajtazonosito() {
		return rajtazonosito;
	}


	@Override
	public int loves() {
		Random r = new Random();
		int veletlenLovesErtek = r.nextInt(21)+80;
		return veletlenLovesErtek;
	}


	@Override
	public String rekordEllenorzes(int hanyadikKor) {
		String eredmeny;
		if (reszeredmeny>abszolutRekord) {
			eredmeny = "új egyéni rekord";
		} else if (reszeredmeny+100*(5-hanyadikKor)>=abszolutRekord) {
			eredmeny = "még dönthet rekordot";
		} else eredmeny = "már maxponttal sem dönthet rekordot";
		
		return eredmeny;
	}
	
	

	
	

}
