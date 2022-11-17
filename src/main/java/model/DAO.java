package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

public class DAO {
	/** Módulo de conexão **/
	// Parâmetros de conexão
	private String drviver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimeZone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "";

	// Método de conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(drviver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** CRUD CREATE **/
	public void inserirUtilzador(JavaBeans utilzador) {
		String create = " INSERT INTO utilizador (name,email,phone,user,password) values(?,?,?,?,?)";
		try {
			// open conection
			Connection con = conectar();
			// preparar querry para execução na base de dados
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os parametros (?) pelo conteudo das variaveis JavaBeans
			pst.setString(1, utilzador.getName());
			pst.setString(2, utilzador.getEmail());
			pst.setString(3, utilzador.getPhone());
			pst.setString(4, utilzador.getUser());
			pst.setString(5, utilzador.getPassword());
			// Executar a querry
			pst.executeUpdate();
			// closeConnection
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	/** CRUD READ **/
	public ArrayList<JavaBeans> listarUtilizadores() {
		// Criando objecto JavaBeans
		ArrayList<JavaBeans> utilizador = new ArrayList<>();
		String read = "SELECT * FROM utilizador order by name";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// variaveis de apoio que recebem dados da base de dados
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String user = rs.getString(5);
				String password = rs.getString(5);
				// save into ArrayList
				utilizador.add(new JavaBeans(name, email, phone, user,password));
			}
			con.close();
			return utilizador;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// teste de conexão
	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println("Teste de conexão" + con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
