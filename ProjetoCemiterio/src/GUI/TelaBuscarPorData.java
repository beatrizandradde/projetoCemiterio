package GUI;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.JXDatePicker;

import DAO.SepultamentoDAO;
import Entidades.Sepultamento;

public class TelaBuscarPorData extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JXDatePicker txtData;

	/**
	 * Create the frame.
	 */
	public TelaBuscarPorData() {
		setTitle("Buscar Por Data");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 264, 206);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInformeO = new JLabel("Data de Sepultamento:");
		lblInformeO.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformeO.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInformeO.setBounds(10, 31, 233, 14);
		contentPane.add(lblInformeO);

		txtData = new JXDatePicker();
		txtData.setBounds(64, 56, 126, 31);
		txtData.setDate(Calendar.getInstance().getTime());
		txtData.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
		contentPane.add(txtData);
		
		
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
		
		Date dataDate = (Date)txtData.getEditor().getValue();
		Timestamp data = new Timestamp(dataDate.getTime());

		SepultamentoDAO dao = new SepultamentoDAO();
		ArrayList<Sepultamento> sepultamentos = dao.buscarPorData(data);
		 
		if(sepultamentos.isEmpty()){
			JOptionPane.showMessageDialog(this, "A data de sepultamento não foi encontrada no sistema", "", JOptionPane.ERROR_MESSAGE);
		} else {
			TelaListaSepultamentos tlListaSepultamentos;
			tlListaSepultamentos = new TelaListaSepultamentos(data);
			TelaPrincipal.desktopPane_1.add(tlListaSepultamentos);
			tlListaSepultamentos.setVisible(true);
			tlListaSepultamentos.setPosicao();
			/*for (Sepultamento sepultamento : sepultamentos) {      
				System.out.println(sepultamento.getNome_falecido());
			}*/
		}
	}		

	public void setPosicao() {
		Dimension d = this.getDesktopPane().getSize();
		this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
		}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 TelaBuscarPorData frame = new TelaBuscarPorData();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}


