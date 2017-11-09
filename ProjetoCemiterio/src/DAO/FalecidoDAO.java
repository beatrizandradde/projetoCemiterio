package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import Entidades.Falecido;

public class FalecidoDAO extends AbstractDAO {

	public boolean cadastrar(Falecido umFalecido, String sexo, String raca, String estado) {
		int n = 0;

		try {
			PreparedStatement stmt = conexao.prepareStatement(
					"insert into falecido (numero_processo_obito, obito_data, nome_falecido, nome_pai,"
					+ "nome_mae, idade, sexo, raca_cor, estado_civil, causa_morte, medico_nome, medico_crm)"
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			stmt.setInt(1, umFalecido.getNumero_processo_obito());
			stmt.setTimestamp(2, new Timestamp(umFalecido.getObito_data().getTime()));
			stmt.setString(3, umFalecido.getNome_falecido());
			stmt.setString(4, umFalecido.getNome_pai());
			stmt.setString(5, umFalecido.getNome_mae());
			stmt.setInt(6, umFalecido.getIdade());
			stmt.setString(7, sexo);
			stmt.setString(8, raca);
			stmt.setString(9, estado);
			stmt.setString(10, umFalecido.getCausa_morte());
			stmt.setString(11, umFalecido.getMedico_nome());
			stmt.setInt(12, umFalecido.getMedico_crm());

			n = stmt.executeUpdate();
		} catch (SQLException e) {
			n = 0;
			e.printStackTrace();
		}

		return n == 1;
	}
	
	public Falecido buscarFalecido(int umNumeroProcesso) {
		Falecido f = null;

		try {
			PreparedStatement stmt = conexao.prepareStatement("select * from falecido where numero_processo_obito = ?");

			stmt.setInt(1, umNumeroProcesso);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				f = new Falecido();
				
				f.setNumero_processo_obito(rs.getInt("numero_processo_obito"));
				f.setObito_data(rs.getDate("obito_data"));
				f.setNome_falecido(rs.getString("nome_falecido"));
				f.setNome_pai(rs.getString("nome_pai"));
				f.setNome_mae(rs.getString("nome_mae"));
				f.setIdade(rs.getInt("idade"));
				f.setSexo(rs.getString("sexo"));
				f.setRaca_cor(rs.getString("raca_cor"));
				f.setEstado_civil(rs.getString("estado_civil"));
				f.setCausa_morte(rs.getString("causa_morte"));
				f.setMedico_nome(rs.getString("medico_nome"));
				f.setMedico_crm(rs.getInt("medico_crm"));
				
	}
		} catch (SQLException e) {
			f = null;
			System.out.println("Erro ao buscar falecido: \n\t" + e);
		}

		return f;
	}
}
