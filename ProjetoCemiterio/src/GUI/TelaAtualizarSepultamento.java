package GUI;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import org.jdesktop.swingx.JXDatePicker;

import DAO.SepultamentoDAO;
import Entidades.Sepultamento;

import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;

public class TelaAtualizarSepultamento extends JInternalFrame {

	/**
	 * Launch the application.
	 */
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
	private JComboBox<String> txtSexo;
	private String sexo;
	private JComboBox<String> txtRaca;
	private String raca;
	private JComboBox<String> txtEstado;
	private String estado;
	private JTextField txtNomeR;
	private JTextField txtEndereco;
	private JTextField txtTelefone;
	private JTextField txtTelefone2;
	private JTextField txtRg;
	private JTextField txtCpf;
	private JTextField txtOrgao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizarSepultamento frame = new TelaAtualizarSepultamento(null, null, null, null);
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
	public TelaAtualizarSepultamento(Sepultamento umSepultamento, String sexo, String raca, String estado) throws ParseException {
		setResizable(false);
		setTitle("Atualizar Sepultamento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 530, 692);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 MaskFormatter mascaraTel = null;
         MaskFormatter mascaraCpf = null;
         MaskFormatter mascaraRg = null;

         try {
                mascaraTel = new MaskFormatter("(##)#####-####");
                mascaraCpf = new MaskFormatter("###.###.###-##");
                mascaraRg = new MaskFormatter("##.###.###-#");
                mascaraTel.setPlaceholderCharacter('_');
                mascaraCpf.setPlaceholderCharacter('_');
                mascaraRg.setPlaceholderCharacter('_');
         } catch(ParseException excp) {
                System.err.println("Erro na formatação: " + excp.getMessage());
                System.exit(-1);
         }
		
		JLabel lblNmeroDoProcesso = new JLabel("N\u00FAmero do Processo:");
		lblNmeroDoProcesso.setBounds(20, 36, 129, 14);
		lblNmeroDoProcesso.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(lblNmeroDoProcesso);
				
		txtNumProcesso = new JTextField(Integer.toString(umSepultamento.getNumero_processo_obito()));
		txtNumProcesso.setEnabled(false);
		txtNumProcesso.setEditable(false);
		txtNumProcesso.setBounds(20, 61, 129, 20);
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
		
		JLabel lblDataDobito = new JLabel("Data e Hora do \u00D3bito:");
		lblDataDobito.setBounds(333, 36, 136, 14);
		lblDataDobito.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(lblDataDobito);
		

        txtData = new JXDatePicker();
        txtData.setBounds(333, 61, 160, 20);
        txtData.setDate(Calendar.getInstance().getTime());
        txtData.setFormats(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss"));
        contentPane.add(txtData);
        
		JLabel lblNomeDoFalecido = new JLabel("Nome do Falecido:");
		lblNomeDoFalecido.setBounds(20, 92, 129, 14);
		lblNomeDoFalecido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(lblNomeDoFalecido);
		
		txtFalecido = new JTextField(umSepultamento.getNome_falecido());
		txtFalecido.setBounds(20, 117, 330, 20);
		contentPane.add(txtFalecido);
		txtFalecido.setColumns(10);
		
		JLabel lblNomeDoPai = new JLabel("Nome do Pai:");
		lblNomeDoPai.setBounds(20, 148, 82, 14);
		lblNomeDoPai.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(lblNomeDoPai);
		
		txtPai = new JTextField(umSepultamento.getNome_pai());
		txtPai.setBounds(20, 170, 233, 20);
		contentPane.add(txtPai);
		txtPai.setColumns(10);
		
		JLabel lblNomeDaMe = new JLabel("Nome da M\u00E3e:");
		lblNomeDaMe.setBounds(263, 148, 91, 14);
		lblNomeDaMe.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(lblNomeDaMe);
		
		txtMae = new JTextField(umSepultamento.getNome_mae());
		txtMae.setBounds(263, 170, 230, 20);
		contentPane.add(txtMae);
		txtMae.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(360, 120, 46, 14);
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(lblIdade);
		
		txtIdade = new JTextField(Integer.toString(umSepultamento.getIdade()));
		txtIdade.setBounds(411, 117, 82, 20);
		txtIdade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				String caracteres="0987654321";
				       if(!caracteres.contains(ev.getKeyChar()+"")){
				              ev.consume();
				       }
				}
		});
		contentPane.add(txtIdade);
		txtIdade.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(20, 201, 46, 14);
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(lblSexo);
		
		txtSexo = new JComboBox<String>();
		txtSexo.setBounds(20, 226, 116, 20);
		txtSexo.setModel(new DefaultComboBoxModel<String>(
		new String[] { "Masculino", "Feminino", "Ignorado" }));
	    contentPane.add(txtSexo);
	    txtSexo.setSelectedItem(sexo);
	    
		JLabel lblRaacor = new JLabel("Ra\u00E7a/Cor:");
		lblRaacor.setBounds(202, 201, 82, 14);
		lblRaacor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(lblRaacor);
		
		txtRaca = new JComboBox<String>();
		txtRaca.setBounds(202, 226, 116, 20);
		txtRaca.setModel(new DefaultComboBoxModel<String>(
		new String[] { "Branca", "Parda", "Preta", "Indígena" }));
	    contentPane.add(txtRaca);
	    txtRaca.setSelectedItem(raca);
		
		JLabel lblEstadoCivil = new JLabel("Estado Civil:");
		lblEstadoCivil.setBounds(375, 201, 82, 14);
		lblEstadoCivil.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(lblEstadoCivil);
		
		txtEstado = new JComboBox<String>();
		txtEstado.setBounds(376, 226, 117, 20);
		txtEstado.setModel(new DefaultComboBoxModel<String>(
		new String[] { "Solteiro", "Casado", "Viúvo", "Divorciado", "Ignorado" }));
	    contentPane.add(txtEstado);
	    txtEstado.setSelectedItem(estado);
		
		JLabel lblCausaDaMorte = new JLabel("Causa da Morte:");
		lblCausaDaMorte.setBounds(20, 257, 82, 14);
		lblCausaDaMorte.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(lblCausaDaMorte);
		
		txtCausaMorte = new JTextField(umSepultamento.getCausa_morte());
		txtCausaMorte.setBounds(20, 285, 473, 20);
		contentPane.add(txtCausaMorte);
		txtCausaMorte.setColumns(10);
		
		JLabel lblNomeDoMdico = new JLabel("Nome do M\u00E9dico:");
		lblNomeDoMdico.setBounds(20, 316, 82, 14);
		lblNomeDoMdico.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(lblNomeDoMdico);
		
		txtMedico = new JTextField(umSepultamento.getMedico_nome());
		txtMedico.setBounds(20, 341, 392, 20);
		contentPane.add(txtMedico);
		txtMedico.setColumns(10);
		
		JLabel lblCrm = new JLabel("CRM:");
		lblCrm.setBounds(423, 316, 46, 14);
		lblCrm.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(lblCrm);
		
		txtCrm = new JTextField(Integer.toString(umSepultamento.getMedico_crm()));
		txtCrm.setBounds(422, 341, 71, 20);
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
		
		Button btnCadastrar = new Button("Atualizar");
		btnCadastrar.setBounds(353, 603, 148, 39);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastrarSepultamento();
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(btnCadastrar);
		
		Button btnCancelar = new Button("Cancelar");
		btnCancelar.setBounds(185, 603, 148, 39);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(btnCancelar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 30, 491, 2);
		contentPane.add(separator);
		
		JLabel lblCadastroDoFalecido = new JLabel("Dados do Falecido");
		lblCadastroDoFalecido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastroDoFalecido.setBounds(10, 11, 139, 14);
		contentPane.add(lblCadastroDoFalecido);
		
		JLabel lblCadastroDoRequerente = new JLabel("Dados do Requerente");
		lblCadastroDoRequerente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastroDoRequerente.setBounds(10, 386, 139, 14);
		contentPane.add(lblCadastroDoRequerente);
		
		JLabel label = new JLabel("Nome:");
		label.setBounds(20, 422, 46, 14);
		contentPane.add(label);
		
		txtNomeR = new JTextField(umSepultamento.getNome_requerente());
		txtNomeR.setColumns(10);
		txtNomeR.setBounds(20, 444, 473, 20);
		contentPane.add(txtNomeR);
		
		JLabel label_1 = new JLabel("Endere\u00E7o:");
		label_1.setBounds(20, 475, 84, 14);
		contentPane.add(label_1);
		
		txtEndereco = new JTextField(umSepultamento.getEndereco());
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(20, 494, 473, 20);
		contentPane.add(txtEndereco);
		
		JLabel label_2 = new JLabel("Telefone:");
		label_2.setBounds(20, 525, 63, 14);
		contentPane.add(label_2);
		
		txtTelefone = new JFormattedTextField(umSepultamento.getTelefone1());
		txtTelefone.setBounds(20, 550, 102, 20);
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
		
		txtRg = new JFormattedTextField(umSepultamento.getRg());
		txtRg.setBounds(265, 550, 102, 20);
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
		
		txtCpf = new JFormattedTextField(umSepultamento.getCpf());
		txtCpf.setEnabled(false);
		txtCpf.setEditable(false);
		txtCpf.setBounds(391, 550, 102, 20);
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
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 411, 491, 2);
		contentPane.add(separator_1);
		
//		JFormattedTextField txtTelefone2 = new JFormattedTextField(mascaraTel);
//		txtTelefone2.setColumns(10);
//		txtTelefone2.setBounds(142, 550, 102, 20);
//		contentPane.add(txtTelefone2);
		
		txtTelefone2 = new JFormattedTextField(umSepultamento.getTelefone2());
		txtTelefone2.setBounds(142, 550, 102, 20);
		contentPane.add(txtTelefone2);
		txtTelefone2.setColumns(10);
		txtTelefone2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				String caracteres="0987654321";
				       if(!caracteres.contains(ev.getKeyChar()+"")){
				              ev.consume();
				       }
				}
		});
		
		JLabel lblTelefone = new JLabel("Outro Telefone:");
		lblTelefone.setBounds(142, 525, 102, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblNewLabel = new JLabel("RG:");
		lblNewLabel.setBounds(263, 525, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCpf_1 = new JLabel("CPF:");
		lblCpf_1.setBounds(391, 525, 46, 14);
		contentPane.add(lblCpf_1);
		
		txtOrgao = new JTextField(umSepultamento.getOrgao_emissor());
		txtOrgao.setBounds(173, 61, 129, 20);
		contentPane.add(txtOrgao);
		txtOrgao.setColumns(10);
		
		JLabel lblOrgoEmissor = new JLabel("Org\u00E3o Emissor:");
		lblOrgoEmissor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOrgoEmissor.setBounds(173, 36, 91, 14);
		contentPane.add(lblOrgoEmissor);
	}
	
	public void setPosicao() {
	    Dimension d = this.getDesktopPane().getSize();
	    this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
	}
	

	public void CadastrarSepultamento() {
		sexo = (String)txtSexo.getSelectedItem();
		raca = (String)txtRaca.getSelectedItem();
		estado = (String)txtEstado.getSelectedItem();
		
		Sepultamento s = new Sepultamento();
		try {
			s.setOrgao_emissor(txtOrgao.getText());
			s.setIdade(Integer.parseInt(txtIdade.getText()));
			s.setNome_falecido(txtFalecido.getText());
			s.setNome_pai(txtPai.getText());
			s.setNome_mae(txtMae.getText());
			s.setCausa_morte(txtCausaMorte.getText());
			s.setMedico_nome(txtMedico.getText());
			s.setMedico_crm(Integer.parseInt(txtCrm.getText()));
			s.setNumero_processo_obito(Integer.parseInt(txtNumProcesso.getText()));
			Date data = (Date) txtData.getEditor().getValue();
			s.setObito_data(data);		
			s.setSexo(sexo);
			s.setRaca_cor(raca);
			s.setEstado_civil(estado);
			s.setNome_requerente(txtNomeR.getText());
			s.setEndereco(txtEndereco.getText());
			s.setTelefone1(txtTelefone.getText());
			s.setTelefone2(txtTelefone2.getText());
			s.setRg(txtRg.getText());
			s.setCpf(txtCpf.getText());
			
			SepultamentoDAO dao = new SepultamentoDAO();
			
			if (txtFalecido.getText().isEmpty() || txtCausaMorte.getText().isEmpty() || txtMedico.getText().isEmpty() || txtNomeR.getText().isEmpty()
					|| txtEndereco.getText().isEmpty() || txtTelefone.getText().isEmpty() || txtRg.getText().isEmpty() || txtCpf.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Preencha todos os dados!", "", JOptionPane.ERROR_MESSAGE);
			} else {
				 if (dao.atualizar(s, sexo, raca, estado)) {
					 JOptionPane.showMessageDialog(this, "Os dados do sepultamento foram atualizados ao sistema!", "", JOptionPane.INFORMATION_MESSAGE);
					 dispose();
				 } else {
					 JOptionPane.showMessageDialog(this, "Erro ao adicionar os dados do sepultamento no sistema!", "", JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Preencha todos os dados!", "", JOptionPane.ERROR_MESSAGE);
		}
	}
}