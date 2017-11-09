package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entidades.Requerente;

public class RequerenteDAO extends AbstractDAO {
	
	public boolean cadastrar(Requerente umRequerente) {
		int n = 0;

		try {
			PreparedStatement stmt = conexao.prepareStatement(
					"insert into requerente (nome, endereco, telefone, rg, cpf) values (?, ?, ?, ?, ?)");

			stmt.setString(1, umRequerente.getNome());
			stmt.setString(2, umRequerente.getEndereco());
			stmt.setString(3, umRequerente.getTelefone());
			stmt.setString(4, umRequerente.getRg());
			stmt.setString(5, umRequerente.getCpf());

			n = stmt.executeUpdate();
		} catch (SQLException e) {
			n = 0;
			e.printStackTrace();
		}

		return n == 1;
	}
	
	public Requerente buscarRequerente(String umCpf) {
		Requerente r = null;

		try {
			PreparedStatement stmt = conexao.prepareStatement("select * from requerente where cpf = ?");

			stmt.setString(1, umCpf);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				r = new Requerente();
				
				r.setNome(rs.getString("nome"));
				r.setEndereco(rs.getString("endereco"));
				r.setTelefone(rs.getString("telefone"));
				r.setRg(rs.getString("rg"));
				r.setCpf(rs.getString("cpf"));
				
	}
		} catch (SQLException e) {
			r = null;
			System.out.println("Erro ao buscar requerente: \n\t" + e);
		}

		return r;
	}

}
