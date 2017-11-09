package NGUI;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.FalecidoDAO;
import Entidades.Falecido;
import GUI.TelaPrincipal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TelaBuscarFalecido extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNumProc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBuscarFalecido frame = new TelaBuscarFalecido();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaBuscarFalecido() {
		setTitle("Atualizar Cadastro do Falecido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 264, 206);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInformeO = new JLabel("N\u00FAmero de processo do \u00F3bito:");
		lblInformeO.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformeO.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInformeO.setBounds(10, 31, 233, 14);
		contentPane.add(lblInformeO);
		
		txtNumProc = new JTextField();
		txtNumProc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNumProc.setBounds(64, 56, 126, 31);
		contentPane.add(txtNumProc);
		txtNumProc.setColumns(10);
		
		Button btnBuscar = new Button("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					buscarFalecido();
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		});
		btnBuscar.setBounds(131, 116, 112, 39);
		contentPane.add(btnBuscar);
		
		Button button = new Button("Cancelar");
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button.setBounds(10, 116, 112, 39);
		contentPane.add(button);
	}
	
	public void buscarFalecido() throws ParseException {
		 		
		int numProcesso = Integer.parseInt(txtNumProc.getText());
		
		FalecidoDAO dao = new FalecidoDAO();
		Falecido f = dao.buscarFalecido(numProcesso);
		
		if (f == null) {
			JOptionPane.showMessageDialog(this, "Número do processo de óbito não foi encontrado no sistema!", "", JOptionPane.ERROR_MESSAGE);
		} else {
			String sexo = f.getSexo();
			String raca = f.getRaca_cor();
			String estado = f.getEstado_civil();
			TelaAtualizarFalecido tlAtualizarFalecido = new TelaAtualizarFalecido(f, sexo, raca, estado);
			TelaPrincipal.desktopPane_1.add(tlAtualizarFalecido);
			tlAtualizarFalecido.setVisible(true);		
			tlAtualizarFalecido.setPosicao();
			dispose();
		}		
	}
	
	public void setPosicao() {
	    Dimension d = this.getDesktopPane().getSize();
	    this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); }
	}
