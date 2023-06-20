package feladat02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class IngatlanMain {
	static List<Ingatlan> ingatlanok = DBKezelo.ingatlanAdatai();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		String menupont = "";
		System.out.println("Válasszon");
		do {
			System.out.println("1 - Összes ingatlan listázása");
			System.out.println("2 - Keresés HRSZ alapján");
			System.out.println("3 - Törlés HRSZ alapján");
			System.out.println("4 - Becsült érték módosítása HRSZ alapján");
			System.out.println("5 - Kilépés");
			try {
				menupont = br.readLine();
			} catch (IOException e) {
				System.out.println("I/O hiba van");
			}
			switch (menupont) {
			case "1":
				kilistazas();
			case "2":
				kereses();
			case "3":
				torles();
			}

		} while (!menupont.equals("5"));

	}

	private static void torles() throws IOException {

		System.out.println("Kérem a törlendő ingatlan HRSZ-át: ");
		String hrsz = br.readLine();
		int van = 0;
		if (ingatlanok.size() > 0) {

			for (Ingatlan ingatlan : ingatlanok) {

				if (hrsz.equals(ingatlan.getHrsz())) {
					DBKezelo.torles(hrsz);
					van = 1;
				}
			}
		} else
			System.out.println("nincs ingatlan a listában");
		if (van == 0) {
			System.out.println("nincs ilyen ingatlan a listában");
		}
		
	}

	private static void kereses() throws IOException {

		System.out.println("Kérem a keresett ingatlan HRSZ-át: ");
		String hrsz = br.readLine();
		int van = 0;
		if (ingatlanok.size() > 0) {

			for (Ingatlan ingatlan : ingatlanok) {

				if (hrsz.equals(ingatlan.getHrsz())) {
					System.out.println("Az ingatlan adatai: "+ingatlan);
					van = 1;
				}
			}
		} else
			System.out.println("nincs ingatlan a listában");
		if (van == 0) {
			System.out.println("nincs ilyen ingatlan a listában");
		}

	}

	private static void kilistazas() {
		if (ingatlanok.size() > 0) {

			for (Ingatlan ingatlan : ingatlanok) {

				System.out.println(ingatlan);

			}

		} else
			System.out.println("nincs ingatlan a listában");
	}
}
