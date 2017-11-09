package NGUI;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import DAO.RequerenteDAO;
import Entidades.Requerente;
import GUI.TelaPrincipal;

public class TelaBuscarRequerente extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCpf;

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
	public TelaBuscarRequerente() {
		setTitle("Atualizar Cadastro do Requerente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 264, 206);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 MaskFormatter mascaraCpf = null;
		 
		 try{
             mascaraCpf = new MaskFormatter("###.###.###-##");
             mascaraCpf.setPlaceholderCharacter('_');
      }
      catch(ParseException excp) {
             System.err.println("Erro na formatação: " + excp.getMessage());
             System.exit(-1);
      }
		
		JLabel lblInformeO = new JLabel("CPF do requerente::");
		lblInformeO.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformeO.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInformeO.setBounds(10, 31, 233, 14);
		contentPane.add(lblInformeO);

		txtCpf = new JFormattedTextField(mascaraCpf);
		txtCpf.setBounds(64, 56, 126, 31);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		txtCpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				String caracteres="0987654321";
				       if(!caracteres.contains(ev.getKeyChar()+"")){
				              ev.consume();
				       }
				}
		});
		
		Button btnBuscar = new Button("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					buscarRequerente();
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
	
	public void buscarRequerente() throws ParseException {
 		
		String cpf = txtCpf.getText();
		
		RequerenteDAO dao = new RequerenteDAO();
		Requerente r = dao.buscarRequerente(cpf);
		
		if (r == null) {
			JOptionPane.showMessageDialog(this, "o CPF não foi encontrado no sistema!", "", JOptionPane.ERROR_MESSAGE);
		} else {
			
			TelaAtualizarRequerente tlAtualizarRequerente = new TelaAtualizarRequerente(r);
			TelaPrincipal.desktopPane_1.add(tlAtualizarRequerente);
			tlAtualizarRequerente.setVisible(true);		
			tlAtualizarRequerente.setPosicao();
			dispose();
		}		
	}
	
	public void setPosicao() {
	    Dimension d = this.getDesktopPane().getSize();
	    this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); }
	}


