package BDLab6;

import java.sql.*;

public class Seis {
	public static void main(String[] args) {
		System.out.println("Prueba Oracle");
		System.out.println("");
		try {
			Connection Proy_Oracle = DriverManager.getConnection("jdbc:oracle:thin:@vsids11.si.ehu.es:1521:GIPUZKOA",
					"DBDC_09", "DBDC_09");
			Statement s = Proy_Oracle.createStatement();
			// 6: Conectar con la base de datos GIPUZKOA e imprimir en pantalla los dni de
			// los clientes.
			ResultSet rs = s.executeQuery("Select cliente.dni from cliente"); // rs = resultfacto
			// ESCRIBE EL RESTO DE C�DIGO
			while (rs.next()) {
				System.out.println(rs.getString("dni"));
			}
			rs.close();
			Proy_Oracle.close();
		} catch (Exception error) {
			System.out.println(error.getMessage());
		}
	}
}