package feladat02;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class DBKezelo {
	
	private static Ingatlan ingatlanPeldany;

	private static Connection kapcsolat;
	
	private static PreparedStatement sqlUtasitas;	

	
	private DBKezelo() {
		
	}
	
	public static Connection csatlakozas() {
		
		Connection kapcsolat = null;
		
		try {
			
			String connectionURL = "jdbc:mysql://localhost:3306/ingatlan_db?autoReconnect=true&useSSL=false";
			
			kapcsolat = DriverManager.getConnection(connectionURL,"root","Ruander2023");
			
			
		} catch (Exception e) {
			
			System.err.println("A csatlakozás sikertelen, a program bezárul!");
			
		}
		
		return kapcsolat;
		
	}
	
	
	public static List<Ingatlan> ingatlanAdatai() {
		List<Ingatlan> ingatlanList = new ArrayList<Ingatlan>();

		
		try (Connection kapcsolat = csatlakozas()){
			
			String sql = "SELECT * FROM ingatlan";
			
			PreparedStatement ps = kapcsolat.prepareStatement(sql);

			
			ResultSet res = ps.executeQuery();
			if (res.isBeforeFirst()) {
								
				while (res.next()) {
					
					ingatlanPeldany = new Ingatlan(res.getString("tulajdonos"), res.getString("hrsz"), res.getInt("alapterulet"), res.getInt("becsultertek"));		
					ingatlanList.add(ingatlanPeldany);

				}				
			}		
		} catch (SQLException e) {
			
			System.err.println("DB hiba! "+e.getMessage());
			
		}
		
		return ingatlanList;
		
		
	}

	public static void torles(String hrsz) {


		
		boolean ujra;
		
		do {
			
			ujra = false;
			try (Connection kapcsolat = csatlakozas()){
								

				String sql = "DELETE FROM ingatlan where hrsz=?";
				PreparedStatement ps = kapcsolat.prepareStatement(sql);
				ps.setString(1, hrsz);
						
				int eredmeny = ps.executeUpdate();
				 System.out.println(eredmeny+" db sor lett módosítva.");		
	
			} catch (SQLException e) {
				
				System.err.println("DB hiba! "+e.getMessage());
				
			} 
			
			
			
		}while (ujra);

	}
	
	
	

}
