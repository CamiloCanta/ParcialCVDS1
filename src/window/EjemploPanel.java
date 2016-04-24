package window;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import code.Buscaminas;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;

public class EjemploPanel extends JFrame {

	private JPanel contentPane;
	private JButton [][] listaBotones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploPanel frame = new EjemploPanel(1);
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
	public EjemploPanel(int pNivel) {
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
		btnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		panel_2.add(btnCerrar);
		
		JButton btnNuevoJuego = new JButton("Nuevo Juego");
		panel_2.add(btnNuevoJuego);
		
		JButton btnMostrarRanking = new JButton("Mostrar Ranking");
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
						if((arg0.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK){
							ArrayList<Integer> listaDestapar;
							System.out.println(listaDestapar = Buscaminas.getMiBuscaminas().destapar(xT,yT));
							int k =0;
							while (k < listaDestapar.size()) {
								listaBotones[listaDestapar.get(k)][listaDestapar.get(k+1)].setText("Vacio");
								k = k+2;
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
				});
				GridBagConstraints gbc_btnEjemplo = new GridBagConstraints();
				gbc_btnEjemplo.gridx = i;
				gbc_btnEjemplo.gridy = j;
				panel.add(btnEjemplo, gbc_btnEjemplo);
				listaBotones[i][j]=btnEjemplo;
			}
		}
		
	}
}
