package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.SepultamentoDAO;
import Entidades.Sepultamento;

public class TelaListaSepultamentos extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableSepultamentos;
	private String[] cabecalho = { "Nome do Falecido", "Nome do Requerente"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaSepultamentos frame = new TelaListaSepultamentos(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param data 
	 */
	public TelaListaSepultamentos(Timestamp data) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		tableSepultamentos = new JTable();
		tableSepultamentos.setBounds(10, 263, 414, -257);
		getContentPane().add(tableSepultamentos);
		gerarLista();
		
	
	}
	
	private void gerarLista() {
		
		SepultamentoDAO dao = new SepultamentoDAO();
		List<Sepultamento> lista = dao.buscarPorData(data);
		dao.fechar();

		Object[][] dados = new Object[lista.size()][2];

		for (int i = 0; i < dados.length; i++) {
			dados[i][0] = lista.get(i).getNome_falecido();
			dados[i][1] = lista.get(i).getNome_requerente();
		}

		tableSepultamentos.setModel(new DefaultTableModel(dados, cabecalho));
	}

	public void setPosicao() {
		Dimension d = this.getDesktopPane().getSize();
		this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
		}
	
}
