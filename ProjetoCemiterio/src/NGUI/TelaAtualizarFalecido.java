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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.JXDatePicker;

import Entidades.Falecido;

public class TelaAtualizarFalecido extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNumProcesso;
	private JXDatePicker txtData;
	private JTextField txtFalecido;
	private JTextField txtPai;
	private JTextField txtMae;
	private JTextField txtIdade;
	private JTextField txtCausaMorte;
	private JTextField txtMedico;
	private JTextField txtCrm;

	/**
	 * Launch the application.
	 */
	public static void Iniciar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizarFalecido frame = new TelaAtualizarFalecido(null, null, null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public TelaAtualizarFalecido(Falecido umFalecido, String sexo, String raca, String estado) {
		setResizable(false);
		setTitle("Atualizar Cadastro do Falecido");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 517, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNmeroDoProcesso = new JLabel("N\u00FAmero do Processo:");
		lblNmeroDoProcesso.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNmeroDoProcesso.setBounds(10, 12, 129, 14);
		contentPane.add(lblNmeroDoProcesso);
		
		txtNumProcesso = new JTextField(Integer.toString(umFalecido.getNumero_processo_obito()));
		txtNumProcesso.setBounds(10, 34, 129, 20);
		contentPane.add(txtNumProcesso);
		txtNumProcesso.setColumns(10);
		txtNumProcesso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				String caracteres="0987654321";
				       if(!caracteres.contains(ev.getKeyChar()+"")){
				              ev.consume();
				       }
				}
		});
		txtNumProcesso.setEnabled(false);
		
		JLabel lblDataDobito = new JLabel("Data e Hora do \u00D3bito:");
		lblDataDobito.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDataDobito.setBounds(201, 12, 113, 14);
		contentPane.add(lblDataDobito);
	
		Date dateInDatePicker = (Date) umFalecido.getObito_data();
        txtData = new JXDatePicker(dateInDatePicker);
        txtData.setBounds(201, 34, 165, 20);
        txtData.setDate(Calendar.getInstance().getTime());
        txtData.setFormats(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss"));
        contentPane.add(txtData);
        
		JLabel lblNomeDoFalecido = new JLabel("Nome do Falecido:");
		lblNomeDoFalecido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNomeDoFalecido.setBounds(10, 65, 129, 14);
		contentPane.add(lblNomeDoFalecido);
		
		txtFalecido = new JTextField(umFalecido.getNome_falecido());
		txtFalecido.setBounds(10, 84, 488, 20);
		contentPane.add(txtFalecido);
		txtFalecido.setColumns(10);
		
		JLabel lblNomeDoPai = new JLabel("Nome do Pai:");
		lblNomeDoPai.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNomeDoPai.setBounds(10, 115, 82, 14);
		contentPane.add(lblNomeDoPai);
		
		txtPai = new JTextField(umFalecido.getNome_pai());
		txtPai.setBounds(10, 132, 233, 20);
		contentPane.add(txtPai);
		txtPai.setColumns(10);
		
		JLabel lblNomeDaMe = new JLabel("Nome da M\u00E3e:");
		lblNomeDaMe.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNomeDaMe.setBounds(251, 115, 91, 14);
		contentPane.add(lblNomeDaMe);
		
		txtMae = new JTextField(umFalecido.getNome_mae());
		txtMae.setBounds(253, 132, 245, 20);
		contentPane.add(txtMae);
		txtMae.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIdade.setBounds(418, 12, 46, 14);
		contentPane.add(lblIdade);
		
		txtIdade = new JTextField(Integer.toString(umFalecido.getIdade()));
		txtIdade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				String caracteres="0987654321";
				       if(!caracteres.contains(ev.getKeyChar()+"")){
				              ev.consume();
				       }
				}
		});
		txtIdade.setBounds(418, 34, 80, 20);
		contentPane.add(txtIdade);
		txtIdade.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSexo.setBounds(10, 163, 46, 14);
		contentPane.add(lblSexo);
		
		JComboBox<String> txtSexo = new JComboBox<String>();
		txtSexo.setModel(new DefaultComboBoxModel<String>(
		new String[] { "Masculino", "Feminino", "Ignorado" }));
		txtSexo.setBounds(10, 184, 116, 20);
	    contentPane.add(txtSexo);
	    txtSexo.setSelectedItem(sexo);
		
		JLabel lblRaacor = new JLabel("Ra\u00E7a/Cor:");
		lblRaacor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRaacor.setBounds(200, 165, 82, 14);
		contentPane.add(lblRaacor);
		
		JComboBox<String> txtRaca = new JComboBox<String>();
		txtRaca.setModel(new DefaultComboBoxModel<String>(
		new String[] { "Branca", "Parda", "Preta", "Indígena" }));
		txtRaca.setBounds(198, 184, 116, 20);
	    contentPane.add(txtRaca);
	    txtRaca.setSelectedItem(raca);
		
		JLabel lblEstadoCivil = new JLabel("Estado Civil:");
		lblEstadoCivil.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEstadoCivil.setBounds(380, 166, 82, 14);
		contentPane.add(lblEstadoCivil);
		
		JComboBox<String> txtEstado = new JComboBox<String>();
		txtEstado.setModel(new DefaultComboBoxModel<String>(
		new String[] { "Solteiro", "Casado", "Viúvo", "Divorciado", "Ignorado" }));
		txtEstado.setBounds(381, 184, 117, 20);
	    contentPane.add(txtEstado);
	    txtEstado.setSelectedItem(estado);

		JLabel lblCausaDaMorte = new JLabel("Causa da Morte:");
		lblCausaDaMorte.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCausaDaMorte.setBounds(10, 213, 82, 14);
		contentPane.add(lblCausaDaMorte);
		
		txtCausaMorte = new JTextField(umFalecido.getCausa_morte());
		txtCausaMorte.setBounds(10, 237, 488, 20);
		contentPane.add(txtCausaMorte);
		txtCausaMorte.setColumns(10);
		
		JLabel lblNomeDoMdico = new JLabel("Nome do M\u00E9dico:");
		lblNomeDoMdico.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNomeDoMdico.setBounds(10, 265, 82, 14);
		contentPane.add(lblNomeDoMdico);
		
		txtMedico = new JTextField(umFalecido.getMedico_nome());
		txtMedico.setBounds(10, 288, 392, 20);
		contentPane.add(txtMedico);
		txtMedico.setColumns(10);
		
		JLabel lblCrm = new JLabel("CRM:");
		lblCrm.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCrm.setBounds(412, 268, 46, 14);
		contentPane.add(lblCrm);
		
		txtCrm = new JTextField(Integer.toString(umFalecido.getMedico_crm()));
		txtCrm.setBounds(412, 288, 86, 20);
		contentPane.add(txtCrm);
		txtCrm.setColumns(10);
		txtCrm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				String caracteres="0987654321";
				       if(!caracteres.contains(ev.getKeyChar()+"")){
				              ev.consume();
				       }
				}
		});
		
		Button btnAtualizar = new Button("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAtualizar.setBounds(350, 337, 148, 39);
		contentPane.add(btnAtualizar);
		
		Button btnCancelar = new Button("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setBounds(191, 337, 148, 39);
		contentPane.add(btnCancelar);
	}

	public void setPosicao() {
	    Dimension d = this.getDesktopPane().getSize();
	    this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); }
	}
	
	/*public void CadastrarFalecido() {
		Falecido f = new Falecido();
		f.setNumero_processo_obito(Integer.parseInt(txtNumProcesso.getText()));
		Date dateInDatePicker = (Date) txtData.getEditor().getValue();
		f.setObito_data(dateInDatePicker);
		f.setNome_falecido(txtFalecido.getText());
		f.setNome_pai(txtPai.getText());
		f.setNome_mae(txtMae.getText());
		f.setIdade(Integer.parseInt(txtIdade.getText()));
		f.setSexo(sexo);
		f.setRaca_cor(raca);
		f.setEstado_civil(estado);
		f.setCausa_morte(txtCausaMorte.getText());
		f.setMedico_nome(txtMedico.getText());
		f.setMedico_crm(Integer.parseInt(txtCrm.getText()));
		
		FalecidoDAO dao = new FalecidoDAO();
		
		if (txtNumProcesso.getText() == null || txtData.getEditor().getValue() == null || txtFalecido.getText().isEmpty() || txtPai.getText().isEmpty()
				|| txtMae.getText().isEmpty() || txtIdade.getText() == null || txtMedico.getText().isEmpty() || txtCrm.getText() == null) {
			JOptionPane.showMessageDialog(this, "Preencha todos os dados!", "", JOptionPane.ERROR_MESSAGE);
		} else if (dao.cadastrar(f)) {
			JOptionPane.showMessageDialog(this, "Os dados do falecido foram adicionados ao sistema!", "", JOptionPane.INFORMATION_MESSAGE);
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "Erro ao adicionar os dados do falecido no sistema!", "", JOptionPane.ERROR_MESSAGE);

		}*/