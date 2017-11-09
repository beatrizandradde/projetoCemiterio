package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Entidades.Sepultamento;

public class SepultamentoDAO extends AbstractDAO {

	public boolean cadastrar(Sepultamento umSepultamento, String sexo, String raca, String estado) {
		int n = 0;

		try {
			PreparedStatement stmt = conexao.prepareStatement(
					"insert into sepultamento (numero_processo_obito, orgao_emissor, obito_data, nome_falecido, nome_pai,"
					+ "nome_mae, idade, sexo, raca_cor, estado_civil, causa_morte, medico_nome, medico_crm,"
					+ "nome_requerente, endereco, telefone1, telefone2, rg, cpf) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			stmt.setInt(1, umSepultamento.getNumero_processo_obito());
			stmt.setString(2, umSepultamento.getOrgao_emissor());
			stmt.setTimestamp(3, new Timestamp(umSepultamento.getObito_data().getTime()));
			stmt.setString(4, umSepultamento.getNome_falecido());
			stmt.setString(5, umSepultamento.getNome_pai());
			stmt.setString(6, umSepultamento.getNome_mae());
			stmt.setInt(7, umSepultamento.getIdade());
			stmt.setString(8, sexo);
			stmt.setString(9, raca);
			stmt.setString(10, estado);
			stmt.setString(11, umSepultamento.getCausa_morte());
			stmt.setString(12, umSepultamento.getMedico_nome());
			stmt.setInt(13, umSepultamento.getMedico_crm());
			stmt.setString(14, umSepultamento.getNome_requerente());
			stmt.setString(15, umSepultamento.getEndereco());
			stmt.setString(16, umSepultamento.getTelefone1());
			stmt.setString(17, umSepultamento.getTelefone2());
			stmt.setString(18, umSepultamento.getRg());
			stmt.setString(19, umSepultamento.getCpf());

			n = stmt.executeUpdate();
		} catch (SQLException e) {
			n = 0;
			e.printStackTrace();
		}

		return n == 1;
	}
	
	public Sepultamento buscarCpfRequerente(String umCpf) {
		Sepultamento s = null;

		try {
			PreparedStatement stmt = conexao.prepareStatement("select * from sepultamento where cpf = ?");

			stmt.setString(1, umCpf);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				s = new Sepultamento();
				
				s.setNumero_processo_obito(rs.getInt("numero_processo_obito"));
				s.setOrgao_emissor(rs.getString("orgao_emissor"));
				s.setObito_data(rs.getDate("obito_data"));
				s.setNome_falecido(rs.getString("nome_falecido"));
				s.setNome_pai(rs.getString("nome_pai"));
				s.setNome_mae(rs.getString("nome_mae"));
				s.setIdade(rs.getInt("idade"));
				s.setSexo(rs.getString("sexo"));
				s.setRaca_cor(rs.getString("raca_cor"));
				s.setEstado_civil(rs.getString("estado_civil"));
				s.setCausa_morte(rs.getString("causa_morte"));
				s.setMedico_nome(rs.getString("medico_nome"));
				s.setMedico_crm(rs.getInt("medico_crm"));
				s.setNome_requerente(rs.getString("nome_requerente"));
				s.setEndereco(rs.getString("endereco"));
				s.setTelefone1(rs.getString("telefone1"));
				s.setTelefone2(rs.getString("telefone2"));
				s.setRg(rs.getString("rg"));
				s.setCpf(rs.getString("cpf"));
			
	}
		} catch (SQLException e) {
			s = null;
			System.out.println("Erro ao buscar sepultamento: \n\t" + e);
		}

		return s;
	}
	
	public boolean atualizar(Sepultamento umSepultamento, String sexo, String raca, String estado) {
		int n = 0;

		try {
			PreparedStatement stmt = conexao.prepareStatement(
					"update sepultamento set orgao_emissor = ?, obito_data = ?, nome_falecido = ?, nome_pai = ?,"
					+ "nome_mae = ?, idade = ?, sexo = ?, raca_cor = ?, estado_civil = ?, causa_morte = ?, medico_nome = ?, medico_crm = ?,"
					+ "nome_requerente = ?, endereco = ?, telefone1 = ?, telefone2 = ?, rg = ? where cpf = ?");

			stmt.setString(1, umSepultamento.getOrgao_emissor());
			stmt.setTimestamp(2, new Timestamp(umSepultamento.getObito_data().getTime()));
			stmt.setString(3, umSepultamento.getNome_falecido());
			stmt.setString(4, umSepultamento.getNome_pai());
			stmt.setString(5, umSepultamento.getNome_mae());
			stmt.setInt(6, umSepultamento.getIdade());
			stmt.setString(7, sexo);
			stmt.setString(8, raca);
			stmt.setString(9, estado);
			stmt.setString(10, umSepultamento.getCausa_morte());
			stmt.setString(11, umSepultamento.getMedico_nome());
			stmt.setInt(12, umSepultamento.getMedico_crm());
			stmt.setString(13, umSepultamento.getNome_requerente());
			stmt.setString(14, umSepultamento.getEndereco());
			stmt.setString(15, umSepultamento.getTelefone1());
			stmt.setString(16, umSepultamento.getTelefone2());
			stmt.setString(17, umSepultamento.getRg());
			stmt.setString(18, umSepultamento.getCpf());

			n = stmt.executeUpdate();
		} catch (SQLException e) {
			n = 0;
			e.printStackTrace();
		}

		return n == 1;
	}

	public ArrayList<Sepultamento> buscarPorData(Timestamp time) {
		Sepultamento s = null;
		ArrayList<Sepultamento> sepultamentos = new ArrayList<Sepultamento>();

		try {
			PreparedStatement stmt = conexao.prepareStatement("select * from sepultamento where obito_data = ?");

			stmt.setTimestamp(1, time);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				s = new Sepultamento();
				
				s.setNumero_processo_obito(rs.getInt("numero_processo_obito"));
				s.setOrgao_emissor(rs.getString("orgao_emissor"));
				s.setObito_data(rs.getDate("obito_data"));
				s.setNome_falecido(rs.getString("nome_falecido"));
				s.setNome_pai(rs.getString("nome_pai"));
				s.setNome_mae(rs.getString("nome_mae"));
				s.setIdade(rs.getInt("idade"));
				s.setSexo(rs.getString("sexo"));-
				s.setRaca_cor(rs.getString("raca_cor"));
				s.setEstado_civil(rs.getString("estado_civil"));
				s.setCausa_morte(rs.getString("causa_morte"));
				s.setMedico_nome(rs.getString("medico_nome"));
				s.setMedico_crm(rs.getInt("medico_crm"));
				s.setNome_requerente(rs.getString("nome_requerente"));
				s.setEndereco(rs.getString("endereco"));
				s.setTelefone1(rs.getString("telefone1"));
				s.setTelefone2(rs.getString("telefone2"));
				s.setRg(rs.getString("rg"));
				s.setCpf(rs.getString("cpf"));
				sepultamentos.add(s);
			
	}
		} catch (SQLException e) {
			sepultamentos = null;
			System.out.println("Erro ao buscar sepultamento: \n\t" + e);
		}

		return sepultamentos;
	}

	
}
