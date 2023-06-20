package feladat01;

public class LoveszetMain {

	public static void main(String[] args) {

		int maxPont = 0;
		String gyoztesek = null;
		Versenyzo[] versenyzoObj = new Versenyzo[5];

		versenyzoObj[0] = new Versenyzo("Franciska", "v0001", 467, 0);
		versenyzoObj[1] = new Versenyzo("Tibor", "v0002", 486, 0);
		versenyzoObj[2] = new Versenyzo("Zsolt", "v0003", 478, 0);
		versenyzoObj[3] = new Versenyzo("Erika", "v0004", 481, 0);
		versenyzoObj[4] = new Versenyzo("Lajos", "v0005", 472, 0);

		for (int i = 1; i <= 5; i++) {
			System.out.println(i + ". kör:");

			for (int j = 0; j < versenyzoObj.length; j++) {
				int aktualisLoves = versenyzoObj[j].loves();
				versenyzoObj[j].setReszeredmeny(versenyzoObj[j].getReszeredmeny() + aktualisLoves);
				System.out.println(versenyzoObj[j].getNev() + " " + aktualisLoves + " pont, összesen: "
						+ versenyzoObj[j].getReszeredmeny() + " pont - " + versenyzoObj[j].rekordEllenorzes(i));

				if (versenyzoObj[j].rekordEllenorzes(i).equals("új egyéni rekord")) {
					versenyzoObj[j].setAbszolutRekord(versenyzoObj[j].getReszeredmeny());
				}

			}

		}

		for (int j = 0; j < versenyzoObj.length; j++) {
			
			
			if (maxPont < versenyzoObj[j].getReszeredmeny()) {
				maxPont = versenyzoObj[j].getReszeredmeny();
				gyoztesek = versenyzoObj[j].getNev();
			} else if (maxPont == versenyzoObj[j].getReszeredmeny()) {
				gyoztesek = gyoztesek + ", " + versenyzoObj[j].getNev();

			}

		}
		
		System.out.println("\nA győztes/ek: "+gyoztesek);
		FajlKezeles.kiiras(versenyzoObj, "versenyzok.txt");
	}
}
