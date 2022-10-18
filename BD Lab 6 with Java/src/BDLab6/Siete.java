
package BDLab6;

import java.sql.*;
import java.util.*;

public class Siete {
	public static void main(String[] args) {
		System.out.println("Prueba Oracle");
		System.out.println("");
		try {
			Connection Proy_Oracle = DriverManager.getConnection("jdbc:oracle:thin:@vsids11.si.ehu.es:1521:GIPUZKOA",
					"DBDC_09", "DBDC_09");
			Connection Proy_Mysql = DriverManager.getConnection("jdbc:mysql://dif-mysql.ehu.es:3306/DBDC09", "DBDC09",
					"DBDC09");
			Statement o = Proy_Oracle.createStatement();
			Statement s = Proy_Mysql.createStatement();
			ResultSet rs;
			// 7: Coger el dni, nombre y direccion de un cliente de la tabla GIPUZKOA y
			// pasarla a la tabla cliente de viajes de Mysql. El nro. de teléfono se queda
			// vacio.
			rs = o.executeQuery("Select cliente.dni, cliente.nombre, cliente.dir from cliente");
			rs.next();
			System.out.println("Insert into cliente (dni, nombre, direccion) values ('"
					+ /* String.valueOf(rs.getInt("dni")) */ rs.getString("dni") + "','" + rs.getString("nombre")
					+ "','" + rs.getString("dir") + "')"); // da error "nombre de columna no valido" pero igualmente lo
															// inserta
			int i = s.executeUpdate("Insert into cliente (dni, nombre, direccion) values ('" + rs.getString("dni")
					+ "','" + rs.getString("nombre") + "','" + rs.getString("dir") + "')");

			System.out.println(rs.getString("dni") + rs.getString("nombre") + rs.getString("direccion"));
			System.out.println("->afectadas: " + i);
			rs.close();
			s.close();
			Proy_Oracle.close();
			Proy_Mysql.close();

		} catch (SQLException error) {
			if (error.getErrorCode() == 1062) {
				Scanner sc = new Scanner(System.in);
				int opc;
				boolean notExit = true;
				System.out.println("Error de clave duplicada. Este objeto ya ha sido añadido anteriormente");
				while (notExit) {
					System.out.println("");
					System.out.println("Seleccione una opcion:");
					System.out.println("		0 para finalizar ejecucion");
					System.out.println("		1 para ver el contenido de la base de datos Mysql");
					System.out.println(
							"		2 para eliminar la entrada de la base de datos, para poder ser añadida en siguiente ejecucion");
					opc = sc.nextInt();
					System.out.println("");
					switch (opc) {
					case 0:
						sc.close();
						notExit = false;
						System.out.println("FIN");
						break;
					case 1:
						try {
							Connection Proy_Mysql = DriverManager
									.getConnection("jdbc:mysql://dif-mysql.ehu.es:3306/DBDC09", "DBDC09", "DBDC09");
							Statement s = Proy_Mysql.createStatement();
							ResultSet rs = s.executeQuery("Select * from cliente");
							while (rs.next()) {
								System.out.println(rs.getString("dni") + " " + rs.getString("nombre") + " "
										+ rs.getString("direccion") + " " + rs.getString("ntfono"));
							}
							rs.close();
							Proy_Mysql.close();
						} catch (SQLException e) {

							e.printStackTrace();
						}
						break;
					case 2:
						try {
							Connection Proy_Mysql = DriverManager
									.getConnection("jdbc:mysql://dif-mysql.ehu.es:3306/DBDC09", "DBDC09", "DBDC09");
							Statement s = Proy_Mysql.createStatement();
							s.executeUpdate("Delete from cliente where cliente.dni = '11111111'");
							System.out.println("Eliminado");
							s.close();
							Proy_Mysql.close();
						} catch (SQLException e) {

							e.printStackTrace();
						}
						break;
					}
				}
			} else {
				System.out.println(error.getMessage());
			}
		}
	}
}