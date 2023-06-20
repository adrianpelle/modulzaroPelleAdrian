package feladat01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FajlKezeles {

	public static void kiiras(Versenyzo[] versenyzok, String fajlnev) {
		
		try (OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fajlnev),"UTF-8")){
			

			for (Versenyzo versenyzo: versenyzok) {
				
				out.write(versenyzo.getNev()+";"+versenyzo.getRajtazonosito()+";"+versenyzo.getAbszolutRekord()+"\n");
				
			}
			
			System.out.println("Sikeres fájlbaírás");
			
		}catch (IOException e) {
			
			System.err.println("I/O hiba!");
		}
		
		
	}
}
