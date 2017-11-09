package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaPrincipal extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JDesktopPane desktopPane_1; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 593);
		
		desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(desktopPane_1, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNovoSepultamento = new JMenu("Cadastrar");
		menuBar.add(mnNovoSepultamento);
		
		JMenuItem mntmNovoSepultamento = new JMenuItem("Novo Sepultamento");
		mntmNovoSepultamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarSepultamento tlCadastrarSepultamento;
				try {
					tlCadastrarSepultamento = new TelaCadastrarSepultamento();
					desktopPane_1.add(tlCadastrarSepultamento);
					tlCadastrarSepultamento.setVisible(true);
					tlCadastrarSepultamento.setPosicao();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
			}
		});
		mnNovoSepultamento.add(mntmNovoSepultamento);
		
		JMenu mnBuscar = new JMenu("Buscar");
		menuBar.add(mnBuscar);
		
		JMenuItem mntmPorCpfDo = new JMenuItem("Por CPF do Requerente");
		mntmPorCpfDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaBuscarCpfRequerente tlBuscarRequerente = new TelaBuscarCpfRequerente();
				desktopPane_1.add(tlBuscarRequerente);
				tlBuscarRequerente.setVisible(true);
				tlBuscarRequerente.setPosicao();
			}
		});
		mnBuscar.add(mntmPorCpfDo);
		
		JMenuItem mntmPorDataDo = new JMenuItem("Por Data de Sepultamento");
		mntmPorDataDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaBuscarPorData tlBuscarData = new TelaBuscarPorData();
				desktopPane_1.add(tlBuscarData);
				tlBuscarData.setVisible(true);
				tlBuscarData.setPosicao();
			}
		});
		mnBuscar.add(mntmPorDataDo);
		
		
	}
}
