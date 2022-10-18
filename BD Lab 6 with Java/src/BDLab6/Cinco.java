package BDLab6;

import java.sql.*;

public class Cinco {
	public static void main(String[] args) {
		System.out.println("Prueba Mysql");
		System.out.println("");
		try {
			Connection Proy_Mysql = DriverManager.getConnection("jdbc:mysql://dif-mysql.ehu.es:3306/DBDC09", "DBDC09",
					"DBDC09");
			Statement s = Proy_Mysql.createStatement();
			// 5: Tratar un error con SQLException
			// ESCRIBE EL RESTO DE C�DIGO
			// el siguiente update ya se ha ejecutado una vez y estan los datos en la bd
			int i = s.executeUpdate("Insert into cliente values('04040404', 'ClaveRepe', 'calle/num', '456654555')");
			System.out.println("->afectadas:" + i);
			Proy_Mysql.close();
		} catch (SQLException error) {
			if (error.getErrorCode() == 1062) {
				System.out.println("Error de clave duplicada");
			} else {
				System.out.println(error.getMessage());
			}
		}
	}
}