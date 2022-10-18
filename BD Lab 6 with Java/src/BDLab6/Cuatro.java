package BDLab6;

import java.sql.*;

public class Cuatro {
	public static void main(String[] args) {
		System.out.println("Prueba Mysql");
		System.out.println("");
		try {
			Connection Proy_Mysql = DriverManager.getConnection("jdbc:mysql://dif-mysql.ehu.es:3306/DBDC09", "DBDC09",
					"DBDC09");
			Statement s = Proy_Mysql.createStatement();
			ResultSet rs;
			// 4: Actualizar la base de datos con UPDATE, DELETE y INSERT
			int i = s.executeUpdate("Insert into cliente values('99999999', 'SrPatata', 'LaHuerta27', '456456456')");
			rs = s.executeQuery("Select * from cliente where cliente.dni='99999999'");
			System.out.println(
					"Insert into cliente('99999999', 'SrPatata', 'LaHuerta27', '456456456')     ->afectadas:" + i);
			System.out.println("Select * from cliente where cliente.dni='99999999'");
			while (rs.next()) {
				System.out.println(rs.getString("dni") + " " + rs.getString("nombre") + " " + rs.getString("direccion")
						+ " " + rs.getString("ntfono"));
			}
			System.out.println("-----------------");
			int u = s.executeUpdate(
					"Update cliente set cliente.direccion='ElInvernadero18' where cliente.dni='99999999'");
			rs = s.executeQuery("Select * from cliente where cliente.dni='99999999'");
			System.out.println(
					"Update cliente set cliente.direccion='ElInvernadero18' where cliente.dni='99999999'     ->afectadas:"
							+ u);
			System.out.println("Select * from cliente where cliente.dni='99999999'");
			while (rs.next()) {
				System.out.println(rs.getString("dni") + " " + rs.getString("nombre") + " " + rs.getString("direccion")
						+ " " + rs.getString("ntfono"));
			}
			System.out.println("-----------------");
			int d = s.executeUpdate("Delete from cliente where cliente.dni='99999999'");
			rs = s.executeQuery("Select * from cliente where cliente.dni='99999999'");
			System.out.println("Delete from cliente where cliente.dni='99999999'     ->afectadas:" + d);
			System.out.println("Select * from cliente where cliente.dni='99999999'");
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