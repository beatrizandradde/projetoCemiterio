package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import Entidades.Falecido;

public class FalecidoDAO extends AbstractDAO {

	public boolean cadastrar(Falecido umFalecido, String sexo, String raca, String estado, String umCpf) {
		int n = 0;

		try {
			PreparedStatement stmt = conexao.prepareStatement(
					"insert into falecido (numero_processo_obito, orgao_emissor, obito_data, obito_hora, nome_falecido, nome_pai,"
					+ "nome_mae, idade, sexo, raca_cor, estado_civil, causa_morte, medico_nome, medico_crm, requerente_cpf)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			stmt.setInt(1, umFalecido.getNumero_processo_obito());
			stmt.setString(2, umFalecido.getOrgao_emissor());
			stmt.setTimestamp(3, new Timestamp(umFalecido.getObito_data().getTime()));
			stmt.setTimestamp(4, new Timestamp(umFalecido.getHora().getTime()));
			stmt.setString(5, umFalecido.getNome_falecido());
			stmt.setString(6, umFalecido.getNome_pai());
			stmt.setString(7, umFalecido.getNome_mae());
			stmt.setInt(8, umFalecido.getIdade());
			stmt.setString(9, sexo);
			stmt.setString(10, raca);
			stmt.setString(11, estado);
			stmt.setString(12, umFalecido.getCausa_morte());
			stmt.setString(13, umFalecido.getMedico_nome());
			stmt.setInt(14, umFalecido.getMedico_crm());
			stmt.setString(15, umCpf);

			n = stmt.executeUpdate();
		} catch (SQLException e) {
			n = 0;
			e.printStackTrace();
		}

		return n == 1;
	}
	
	public Falecido buscarNumeroProcesso(String numProc) {
		Falecido f = null;

		try {
			PreparedStatement stmt = conexao.prepareStatement("select * from falecido where numero_processo_obito = ?");

			stmt.setString(1, numProc);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				f = new Falecido();
				
				f.setNumero_processo_obito(rs.getInt("numero_processo_obito"));
				f.setOrgao_emissor(rs.getString("orgao_emissor"));
				f.setObito_data(rs.getDate("obito_data"));
				f.setHora(rs.getDate("obito_hora"));
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
				
				RequerenteDAO dao = new RequerenteDAO();
				f.setRequerente_cpf(dao.buscarPorCpf("requerente_cpf"));
				
	}
		} catch (SQLException e) {
			f = null;
			System.out.println("Erro ao buscar número de processo: \n\t" + e);
		}

		return f;
	}
}
