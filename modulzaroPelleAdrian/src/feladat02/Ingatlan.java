package feladat02;

public class Ingatlan {

	
	private String tulajdonos;
	private String hrsz;
	private int alapterulet;
	private int ertek;
	
	public Ingatlan(String tulajdonos, String hrsz, int alapterulet, int ertek) {
		this.tulajdonos = tulajdonos;
		this.hrsz = hrsz;
		this.alapterulet = alapterulet;
		this.ertek = ertek;
	}

	public String getTulajdonos() {
		return tulajdonos;
	}

	public void setTulajdonos(String tulajdonos) {
		this.tulajdonos = tulajdonos;
	}

	public String getHrsz() {
		return hrsz;
	}

	public void setHrsz(String hrsz) {
		this.hrsz = hrsz;
	}

	public int getAlapterulet() {
		return alapterulet;
	}

	public void setAlapterulet(int alapterulet) {
		this.alapterulet = alapterulet;
	}

	public int getErtek() {
		return ertek;
	}

	public void setErtek(int ertek) {
		this.ertek = ertek;
	}

	@Override
	public String toString() {
		return tulajdonos + " " + hrsz + " " + alapterulet + " " + ertek;
	}
	
	
	
	
}
