package window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ListModel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.JList;

import code.ListaUsuarios;

public class VentanaRankingRR extends JFrame {

	private JPanel panelRanking;
	private JPanel panelBotones;
	private JLabel ranking;
	private JButton salir;
	private JButton volver;
	private JList listaJugadores;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRankingRR frame = new VentanaRankingRR();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public VentanaRankingRR() throws FileNotFoundException {
		initialize();
	}
	private void initialize() throws FileNotFoundException {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaRankingRR.class.getResource("/imagenes/FotoIcono.jpg")));
		setTitle("VER RANKING");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.centrarVentana();
		panelRanking = new JPanel();
		panelRanking.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelRanking);
		panelRanking.setLayout(new BorderLayout(0, 0));
		panelRanking.add(getRanking(), BorderLayout.NORTH);
		panelRanking.add(getListaJugadores(), BorderLayout.CENTER);
		panelRanking.add(getPanelBotones(), BorderLayout.SOUTH);
		this.setVisible(true);
		ListaUsuarios.getMiListaJugadores().cargarJugadores();

	}
	

	private JPanel getPanelBotones() {
		if (panelBotones == null) {
			panelBotones = new JPanel();
			panelBotones.add(getVolver());
			panelBotones.add(getSalir());
		}
		return panelBotones;
	}
	private JLabel getRanking() {
		if (ranking == null) {
			ranking = new JLabel("Este es el ranking :");
		}
		return ranking;
	}
	private JButton getSalir() {
		if (salir == null) {
			salir = new JButton("SALIR");
			salir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					dispose();
				}
			});
			salir.setForeground(Color.BLUE);
			salir.setFont(new Font("Curlz MT", Font.BOLD | Font.ITALIC, 16));
		}
		return salir;
	}
	private JButton getVolver() {
		if (volver == null) {
			volver = new JButton("VOLVER ");
			volver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					try {
						new VentanaPrincipal();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					dispose();
				}
			});
			volver.setForeground(Color.BLUE);
			volver.setFont(new Font("Curlz MT", Font.BOLD | Font.ITALIC, 16));
		}
		return volver;
	}
	
	@Override
	public void setVisible(boolean arg0) {
		// TODO Auto-generated method stub
		super.setVisible(arg0);
	}
	
	
	private void centrarVentana() {
		/*
		 * CENTRAR VENTANA ********************************
		 * ************************************************
		 */
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension windowSize = this.getSize();
		if (windowSize.height > screenSize.height)
			windowSize.height = screenSize.height;
		if (windowSize.width > screenSize.width)
			windowSize.width = screenSize.width;

		setLocation((screenSize.width - windowSize.width) / 2,
				(screenSize.height - windowSize.height) / 2);

		// *************************************************
	}
	
	private JList getListaJugadores() throws FileNotFoundException {
			
		listaJugadores = new JList<String>();
		DefaultListModel<String> model = new DefaultListModel<>();
		ArrayList<String> ej = ListaUsuarios.getMiListaJugadores().imprimirRanking(ListaUsuarios.getMiListaJugadores().obtenerRanking(8));
		int i = 0;
		while(i<= 5){
			model.addElement(ej.get(i));
			i++;
		}
		   
		listaJugadores = new JList(model);
		return listaJugadores;
	}
}
