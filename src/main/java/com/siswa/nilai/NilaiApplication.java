package com.siswa.nilai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
public class NilaiApplication {
	public static void main (String [] args) throws Exception {

		Connection conn = null;
		Statement stmt = null;

		Class.forName("org.h2.Driver");
		conn = DriverManager.getConnection("jdbc:h2:file:C:/springboot/nilai/nilai-siswa", "sa", "123qwe");
		stmt = conn.createStatement();

		stmt.execute("drop table if exists TBL_SISWA");
		stmt.execute("CREATE TABLE TBL_SISWA (\n" +
				"  id INT AUTO_INCREMENT  PRIMARY KEY,\n" +
				"  nomor_induk VARCHAR(250) NOT NULL,\n" +
				"  nama VARCHAR(250) NOT NULL,\n" +
				"  kelas VARCHAR(250) DEFAULT NULL\n" +
				");");
		stmt.execute("insert into TBL_SISWA ( nomor_induk, nama, kelas )     select \"nomor_induk\", \"nama\", \"kelas\"   from CSVREAD( 'C:\\springboot\\nilai\\input\\siswa.csv', 'nomor_induk,nama,kelas', null ) ");

		stmt.execute("drop table if exists TBL_NILAI");
		stmt.execute("CREATE TABLE TBL_NILAI (\n" +
				"  id INT AUTO_INCREMENT  PRIMARY KEY,\n" +
				"  nomor_induk VARCHAR(250) NOT NULL,\n" +
				"  mata_pelajaran VARCHAR(250) NOT NULL,\n" +
				"  nilai VARCHAR(250) DEFAULT NULL\n" +
				");");
		stmt.execute("insert into TBL_NILAI ( nomor_induk, mata_pelajaran, nilai )     select \"nomor_induk\", \"mata_pelajaran\", \"nilai\"   from CSVREAD( 'C:\\springboot\\nilai\\input\\nilai.csv', 'nomor_induk,mata_pelajaran,nilai', null ) ");

		stmt.close();

		SpringApplication.run(NilaiApplication.class, args);
	}
}

