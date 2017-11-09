package NGUI;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import DAO.RequerenteDAO;
import Entidades.Requerente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import javax.swing.JFormattedTextField;

public class TelaCadastrarRequerente extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtTelefone;
	private JTextField txtRg;
	private JTextField txtCpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarRequerente frame = new TelaCadastrarRequerente();
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
	public TelaCadastrarRequerente() {
		setResizable(false);
		setTitle("Cadastro do Requerente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 518, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
          MaskFormatter mascaraTel = null;
          MaskFormatter mascaraCpf = null;
          MaskFormatter mascaraRg = null;

          try{
                 mascaraTel = new MaskFormatter("(##)#####-####");
                 mascaraCpf = new MaskFormatter("###.###.###-##");
                 mascaraRg = new MaskFormatter("##.###.###-#");
                 mascaraTel.setPlaceholderCharacter('_');
                 mascaraCpf.setPlaceholderCharacter('_');
                 mascaraRg.setPlaceholderCharacter('_');
          }
          catch(ParseException excp) {
                 System.err.println("Erro na formatação: " + excp.getMessage());
                 System.exit(-1);
          }

		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 33, 492, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Endere\u00E7o:");
		lblNewLabel_1.setBounds(10, 64, 84, 14);
		contentPane.add(lblNewLabel_1);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(10, 83, 492, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 114, 63, 14);
		contentPane.add(lblTelefone);
		
		txtTelefone = new JFormattedTextField(mascaraTel);
		txtTelefone.setBounds(10, 139, 118, 20);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		txtTelefone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				String caracteres="0987654321";
				       if(!caracteres.contains(ev.getKeyChar()+"")){
				              ev.consume();
				       }
				}
		});
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(195, 114, 46, 14);
		contentPane.add(lblRg);
		
		txtRg = new JFormattedTextField(mascaraRg);
		txtRg.setBounds(195, 139, 118, 20);
		contentPane.add(txtRg);
		txtRg.setColumns(10);
		txtRg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				String caracteres="0987654321";
				       if(!caracteres.contains(ev.getKeyChar()+"")){
				              ev.consume();
				       }
				}
		});
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(374, 114, 46, 14);
		contentPane.add(lblCpf);
		
		txtCpf = new JFormattedTextField(mascaraCpf);
		txtCpf.setBounds(374, 139, 128, 20);
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
	
		Button btnCancelar = new Button("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setBounds(196, 196, 148, 39);
		contentPane.add(btnCancelar);
		
		Button btnCadastrar = new Button("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				acaoCadastrar();
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCadastrar.setBounds(354, 196, 148, 39);
		contentPane.add(btnCadastrar);
		
	}
	
	public void acaoCadastrar() {
		Requerente r = new Requerente();
		
		r.setNome(txtNome.getText());
		r.setEndereco(txtEndereco.getText());
		r.setTelefone(txtTelefone.getText());
		r.setRg(txtRg.getText());
		r.setCpf(txtCpf.getText());
		
		if (txtNome.getText().isEmpty() || txtEndereco.getText().isEmpty() || txtTelefone.getText().isEmpty()
				|| txtRg.getText().isEmpty() || txtCpf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Preencha todos os dados!", "", JOptionPane.ERROR_MESSAGE);
		} else {
			RequerenteDAO dao = new RequerenteDAO();
			
			if(dao.cadastrar(r)) {
				JOptionPane.showMessageDialog(this, "Os dados do requerente foram adicionados ao sistema!", "", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Erro ao adicionar os dados do requerente no sistema!", "", JOptionPane.ERROR_MESSAGE);

			}
		}	
	}
	
	public void setPosicao() {
	    Dimension d = this.getDesktopPane().getSize();
	    this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); }
	}
