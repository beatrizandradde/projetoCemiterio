package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TabableView;

import Entidades.Sepultamento;

public class TelaListaSepultamentos extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableSepultamentos;
	private String[] cabecalho = { "Nome do Falecido", "Nome do Requerente"};
	private ArrayList<Sepultamento> sepultamentos;

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
	 * 
	 * @param sepultamentos
	 */
	public TelaListaSepultamentos(ArrayList<Sepultamento> sepultamentos) {
		this.sepultamentos = sepultamentos;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		tableSepultamentos = new JTable();
		tableSepultamentos.setEnabled(false);
		tableSepultamentos.setBounds(10, 263, 414, -257);
		//getContentPane().add(tableSepultamentos);
		gerarLista();
		
		JScrollPane scrollPane = new JScrollPane(tableSepultamentos);
		//getContentPane().add(contentPane);
		getContentPane().add(scrollPane);
		
	
	}
	
	private void gerarLista() {
		
		for (Sepultamento sepultamento : sepultamentos) {
			System.out.println(sepultamento.getNome_falecido());
		}

		Object[][] dados = new Object[sepultamentos.size()][2];

		for (int i = 0; i < dados.length; i++) {
			dados[i][0] = sepultamentos.get(i).getNome_falecido();
			dados[i][1] = sepultamentos.get(i).getNome_requerente();
		}

		tableSepultamentos.setModel(new DefaultTableModel(dados, cabecalho));
	}

	public void setPosicao() {
		Dimension d = this.getDesktopPane().getSize();
		this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
	}
	
}
