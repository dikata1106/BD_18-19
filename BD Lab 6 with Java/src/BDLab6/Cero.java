package BDLab6;

import java.sql.*;
//import java.io.*;
//import java.util.*;

public class Cero {
	public static void main(String[] args) {
		System.out.println("Prueba Mysql");
		System.out.println("");
		try {
			Connection Proy_Mysql = DriverManager.getConnection("jdbc:mysql://dif-mysql.ehu.es:3306/DBDCXX", "DBDCXX",
					"DBDCXX");
			Statement s = Proy_Mysql.createStatement();
			ResultSet rs = s.executeQuery(null);
			// ESCRIBE EL RESTO DE CÓDIGO

			rs.close();
			Proy_Mysql.close();
		} catch (Exception error) {
			System.out.println(error.getMessage());

		}
	}
}
