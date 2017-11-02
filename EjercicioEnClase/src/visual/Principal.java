package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnRegistro = new JMenu("Registro");
		menuBar.add(mnRegistro);
		
		JMenuItem mntmRegistrarClientes = new JMenuItem("Registrar clientes");
		mntmRegistrarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarCliente regCliente = new RegistrarCliente();
				regCliente.setModal(true);
				regCliente.setVisible(true);
			}
		});
		mnRegistro.add(mntmRegistrarClientes);
		
		JMenuItem mntmRegistroDeCuenta = new JMenuItem("Registro de cuenta");
		mntmRegistroDeCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarCuenta regCuenta = new RegistrarCuenta();
				regCuenta.setModal(true);
				regCuenta.setVisible(true);
			}
		});
		mnRegistro.add(mntmRegistroDeCuenta);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
