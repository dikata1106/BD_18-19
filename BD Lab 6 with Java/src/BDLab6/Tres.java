package BDLab6;

import java.sql.*;
import java.util.*;

public class Tres {
	public static void main(String[] args) {
		System.out.println("Prueba Mysql");
		System.out.println("");
		try {
			Connection Proy_Mysql = DriverManager.getConnection("jdbc:mysql://dif-mysql.ehu.es:3306/DBDC09", "DBDC09",
					"DBDC09");
			Statement s = Proy_Mysql.createStatement();
			// 3: Teclear un dni de un cliente y obtener el nombre
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce dni (ej: 10000001)");
			String dni = sc.nextLine();
			sc.close();
			ResultSet rs = s.executeQuery("Select cliente.nombre from cliente where cliente.dni=" + dni);
			// ESCRIBE EL RESTO DE C�DIGO
			while (rs.next()) {
				System.out.println(rs.getString("nombre"));
			}
			rs.close();
			Proy_Mysql.close();
		} catch (Exception error) {
			System.out.println(error.getMessage());

		}
	}
}