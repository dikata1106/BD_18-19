package BDLab6;

import java.sql.*;

public class Dos {
	public static void main(String[] args) {
		System.out.println("Prueba Mysql");
		System.out.println("");
		try {
			Connection Proy_Mysql = DriverManager.getConnection("jdbc:mysql://dif-mysql.ehu.es:3306/DBDC09", "DBDC09",
					"DBDC09");
			Statement s = Proy_Mysql.createStatement();
			// 2: Obtener el nombre del cliente con dni 10000001
			ResultSet rs = s.executeQuery("Select cliente.nombre from cliente where cliente.dni='10000001'");
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