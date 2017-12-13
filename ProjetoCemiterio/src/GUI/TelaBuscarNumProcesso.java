package GUI;

import java.awt.Button;
import java.awt.Dimension;
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

import DAO.FalecidoDAO;
import DAO.RequerenteDAO;
import Entidades.Falecido;
import Entidades.Requerente;

public class TelaBuscarNumProcesso extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNum;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public TelaBuscarNumProcesso() {
		setTitle("Cadastro do Sepultamento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 264, 206);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*MaskFormatter mascaraCpf = null;

		try{
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setPlaceholderCharacter('_');
		}
		catch(ParseException excp) {
			System.err.println("Erro na formataï¿½ï¿½o: " + excp.getMessage());
			System.exit(-1);
		}*/

		JLabel lblInformeO = new JLabel("Número do Processo do Falecido:");
		lblInformeO.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformeO.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInformeO.setBounds(10, 31, 233, 14);
		contentPane.add(lblInformeO);

		txtNum = new JFormattedTextField();
		txtNum.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtNum.setBounds(64, 56, 126, 31);
		contentPane.add(txtNum);
		txtNum.setColumns(10);
		txtNum.addKeyListener(new KeyAdapter() {
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
					buscarSepultamento();
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

	public void buscarSepultamento() throws ParseException {

		String numProc = txtNum.getText();

		FalecidoDAO faldao = new FalecidoDAO();
		Falecido f = faldao.buscarNumeroProcesso(numProc);

		if (f == null) {
			JOptionPane.showMessageDialog(this, "O número de processo não foi encontrado no sistema!", "", JOptionPane.ERROR_MESSAGE);
		} else {
			String cpf = f.getRequerente_cpf().toString();
			RequerenteDAO reqdao = new RequerenteDAO();
			Requerente r = reqdao.buscarPorCpf(cpf);

			TelaAtualizarSepultamento tlAtualizarSepultamento = new TelaAtualizarSepultamento(f, r);
			
			TelaPrincipal.desktopPane_1.add(tlAtualizarSepultamento);
			tlAtualizarSepultamento.setVisible(true);		
			tlAtualizarSepultamento.setPosicao();
			dispose();
		}
	}		

	public void setPosicao() {
		Dimension d = this.getDesktopPane().getSize();
		this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); }
}


