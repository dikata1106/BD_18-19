package BDLab6;

import java.sql.*;

public class Uno {
	public static void main(String[] args) {
		System.out.println("Prueba Mysql");
		System.out.println("");
		try {
			Connection Proy_Mysql = DriverManager.getConnection("jdbc:mysql://dif-mysql.ehu.es:3306/DBDC09", "DBDC09",
					"DBDC09");
			Statement s = Proy_Mysql.createStatement();
			// 1: Obtener los datos de los clientes.
			ResultSet rs = s.executeQuery("Select * from cliente"); // rs = resultfacto
			// ESCRIBE EL RESTO DE CoDIGO
			while (rs.next()) {
				System.out.println(rs.getString("dni") + " " + rs.getString("nombre") + " " + rs.getString("direccion")
						+ " " + rs.getString("ntfono"));
			}
			rs.close();
			Proy_Mysql.close();
		} catch (Exception error) {
			System.out.println(error.getMessage());

		}
	}
}