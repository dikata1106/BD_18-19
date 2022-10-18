package BDLab6;

import java.sql.*;

public class Ocho {

	public static void main(String[] args) {
		System.out.println("Prueba Oracle");
		System.out.println("");
		try {
			Connection Proy_Oracle = DriverManager.getConnection("jdbc:oracle:thin:@vsids11.si.ehu.es:1521:GIPUZKOA",
					"DBDC_09", "DBDC_09");
			Statement s = Proy_Oracle.createStatement();
			// 8: Insertar tres tuplas tratándolas dentro de una transacción. Una de ellas
			// será una tupla de un dni ya existente y al tratarlas las tres dentro de una
			// transacción, no se deberán insertar ninguna de las tres.
			ResultSet rs = s.executeQuery("Select cliente.dni from cliente");
			// ESCRIBE EL RESTO DE C�DIGO
			rs.next();
			String dniExistente = rs.getString("dni");// Primary key for duplication
			Proy_Oracle.setAutoCommit(false);
			s.executeUpdate("Insert into cliente values ('88888888', 'nombre8', 'direccion8', '123456789')");
			System.out.println("Insert 1");
			s.executeUpdate(
					"Insert into cliente values ('" + dniExistente + "', 'nombre8', 'direccion8', '123456789')");
			System.out.println("Insert 2");
			s.executeUpdate("Insert into cliente values ('99999999', 'nombre9', 'direccion9', '123456789')");
			System.out.println("Insert 3");
			Proy_Oracle.commit();
			s.close();
			rs.close();
			Proy_Oracle.close();
		} catch (Exception error) {
			Connection Proy_Oracle;
			try {
				Proy_Oracle = DriverManager.getConnection("jdbc:oracle:thin:@vsids11.si.ehu.es:1521:GIPUZKOA",
						"DBDC_09", "DBDC_09");
				Proy_Oracle.rollback();
				Proy_Oracle.close();
				System.out.println("rollback actived");
			} catch (SQLException e) {

				System.out.println(error.getMessage());

			}
			System.out.println(error.getMessage());
		}
	}
}
