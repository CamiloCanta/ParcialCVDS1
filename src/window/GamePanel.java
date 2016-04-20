package window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GamePanel frame = new GamePanel();
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
	public GamePanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelJuego = new JPanel();
		contentPane.add(panelJuego, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("New button");
		
		GroupLayout gl_panelJuego = new GroupLayout(panelJuego);
		gl_panelJuego.setHorizontalGroup(
			gl_panelJuego.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelJuego.createSequentialGroup()
					.addGap(35)
					.addComponent(btnNewButton)
					.addContainerGap(300, Short.MAX_VALUE))
		);
		gl_panelJuego.setVerticalGroup(
			gl_panelJuego.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelJuego.createSequentialGroup()
					.addGap(28)
					.addComponent(btnNewButton)
					.addContainerGap(200, Short.MAX_VALUE))
		);
		panelJuego.setLayout(gl_panelJuego);
	}

}
