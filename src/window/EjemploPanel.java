package window;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import code.Buscaminas;
import code.ListaUsuarios;
import code.Usuario;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;

public class EjemploPanel extends JFrame {

	private JPanel contentPane;
	private JButton [][] listaBotones;
	private VentanaRankingRR vR;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploPanel frame = new EjemploPanel(1, "hola");
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
	public EjemploPanel(int pNivel, String pNombre) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblBuscaminas = new JLabel("BUSCAMINAS");
		panel_1.add(lblBuscaminas);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				vR.setVisible(false);
				dispose();
			}
		});
		
		JButton btnComprobarResultados = new JButton("Comprobar Resultados");
		
		btnComprobarResultados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(Buscaminas.getMiBuscaminas().comprobar()){
					if(ListaUsuarios.getMiListaJugadores().buscarJugador(pNombre)){
						ListaUsuarios.getMiListaJugadores().modificarJugador(pNombre);
					}else{
						Usuario u = new Usuario(pNombre);
						ListaUsuarios.getMiListaJugadores().anadirJugador(u);
						ListaUsuarios.getMiListaJugadores().modificarJugador(pNombre);
					}
					try {
						ListaUsuarios.getMiListaJugadores().ranking();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						vR.dispose();
						vR = new VentanaRankingRR();
						vR.setTitle("HAS GANADO-->RANKING JUGADORES");
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					btnComprobarResultados.setBackground(Color.GREEN);
				}else{
					btnComprobarResultados.setBackground(Color.RED);
				}
				
			}
		});
		panel_2.add(btnComprobarResultados);
		panel_2.add(btnCerrar);
		
		JButton btnNuevoJuego = new JButton("Nuevo Juego");
		btnNuevoJuego.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LoginPanel l = new LoginPanel();
				l.setVisible(true);
				vR.setVisible(false);
				dispose();
			}
		});
		btnNuevoJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_2.add(btnNuevoJuego);
		
		JButton btnMostrarRanking = new JButton("Mostrar Ranking");
		btnMostrarRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMostrarRanking.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!vR.isVisible()){
					vR.setVisible(true);
				}
			}
		});
		panel_2.add(btnMostrarRanking);
		
		//Tamañano maximo
		int x;
		int y;
		if (pNivel==1) {
			x=4;
			y=4;
			 
		}else if (pNivel==2) {
			x=8;
			y=8;
		}else{
			y=16;
			x=16;
		}
		listaBotones = new JButton[x][y];
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				JButton btnEjemplo = new JButton(" ");
				int xT=i;
				int yT=j;

				btnEjemplo.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						if(!Buscaminas.getMiBuscaminas().estaDestapado(xT, yT)){
						if((arg0.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK){
							if(Buscaminas.getMiBuscaminas().esBomba(xT, yT)){
								System.out.println("Mina");
								lblBuscaminas.setText("HAS PERDIDO");
								panel.setVisible(false);
							}else{
								ArrayList<Integer> listaDestapar;
								System.out.println(listaDestapar = Buscaminas.getMiBuscaminas().destapar(xT,yT));
								int k =0;
								while (k < listaDestapar.size()) {
									listaBotones[listaDestapar.get(k)][listaDestapar.get(k+1)].setBackground(Color.WHITE);
									listaBotones[listaDestapar.get(k)][listaDestapar.get(k+1)].setText(Buscaminas.getMiBuscaminas().getValor(xT,yT));
									listaBotones[listaDestapar.get(k)][listaDestapar.get(k+1)].setEnabled(false);
									k = k+2;
								}
							}	
						}else{
						//Hacer contador de minas marcadas
					    //Buscaminas.getMiBuscaminas().marcarDesmarcar(xT,yT);
					    //If de control de banderitas
					    if (Buscaminas.getMiBuscaminas().marcarDesmarcar(xT,yT)) {
							if (btnEjemplo.getText().equals(" ")) {
								btnEjemplo.setText("$");
							} else {
								btnEjemplo.setText(" ");
							}
						}
					    
						}
						}
					}
				});
				GridBagConstraints gbc_btnEjemplo = new GridBagConstraints();
				gbc_btnEjemplo.gridx = i;
				gbc_btnEjemplo.gridy = j;
				gbc_btnEjemplo.weightx = 1.0;
				gbc_btnEjemplo.weighty = 1.0;
				gbc_btnEjemplo.gridheight = 1;
				gbc_btnEjemplo.gridwidth = 1;
				//gbc_btnEjemplo.fill = GridBagConstraints.BOTH;
				panel.add(btnEjemplo, gbc_btnEjemplo);
				listaBotones[i][j]=btnEjemplo;
			}
		}
		
		//VentanaRanking
		ListaUsuarios.getMiListaJugadores().cargarJugadores();
		try {
			vR = new VentanaRankingRR();
			vR.setVisible(false);//Por defecto
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.pack();
		
	}
}
