package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logical.Banco;
import logical.CC;
import logical.CV;
import logical.Cliente;
import logical.Cuenta;
import logical.FI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridLayout;

public class RegistrarCuenta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtSaldo;
	private JTextField txtMontoMensual;
	private JTextField txtInteresFijo;
	private JPanel CVPanel;
	private JPanel FIPanel;
	private JComboBox comboCliente;
	private JSpinner spinnerTiempo;
	private JTextField txtMontoMaximo;
	private JPanel CCPanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarCuenta dialog = new RegistrarCuenta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarCuenta() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarCuenta.class.getResource("/img/if_user_173122.png")));
		setTitle("Registro de cuenta");
		setBounds(100, 100, 562, 392);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCdulanmeroDeIdentidad = new JLabel("C\u00F3digo");
		lblCdulanmeroDeIdentidad.setBounds(154, 85, 232, 14);
		contentPanel.add(lblCdulanmeroDeIdentidad);
		
		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setBounds(154, 110, 232, 23);
		setLocationRelativeTo(null);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblNombres = new JLabel("Corte del mes");
		lblNombres.setBounds(401, 85, 101, 14);
		contentPanel.add(lblNombres);
		
		txtSaldo = new JTextField();
		txtSaldo.setEnabled(false);
		txtSaldo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSaldo.setColumns(10);
		txtSaldo.setBounds(277, 169, 225, 23);
		contentPanel.add(txtSaldo);
		
		JLabel lblDireccin = new JLabel("Saldo");
		lblDireccin.setBounds(277, 149, 92, 14);
		contentPanel.add(lblDireccin);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(RegistrarCuenta.class.getResource("/img/if_credit_card_1814100 (1).png")));
		label.setBounds(15, 82, 112, 128);
		contentPanel.add(label);
		
		JSpinner spinnerCorte = new JSpinner();
		spinnerCorte.setEnabled(false);
		spinnerCorte.setBounds(401, 107, 101, 26);
		contentPanel.add(spinnerCorte);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(154, 149, 101, 14);
		contentPanel.add(lblEstado);
		
		JComboBox comboEstado = new JComboBox();
		comboEstado.setEnabled(false);
		comboEstado.setModel(new DefaultComboBoxModel(new String[] {"Habilitada", "Bloqueada", "Cancelada"}));
		comboEstado.setBounds(154, 168, 101, 26);
		contentPanel.add(comboEstado);
		
		JLabel lblTipoDeCuenta = new JLabel("Tipo de cuenta");
		lblTipoDeCuenta.setBounds(25, 16, 112, 20);
		contentPanel.add(lblTipoDeCuenta);
		
		JComboBox comboCuenta = new JComboBox();
		comboCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch(comboCuenta.getSelectedItem().toString())
				{
				case "Cuenta Corriente": CCPanel.setVisible(true); CVPanel.setVisible(false); FIPanel.setVisible(false); break;
				case "Cuenta Vivienda": CVPanel.setVisible(true); CCPanel.setVisible(false); FIPanel.setVisible(false); break;
				case "Fondo Inversión": FIPanel.setVisible(true); CCPanel.setVisible(false); CVPanel.setVisible(false); break;
				}
			}
		});
		comboCuenta.setModel(new DefaultComboBoxModel(new String[] {"Cuenta Corriente", "Cuenta Vivienda", "Fondo Inversi\u00F3n"}));
		comboCuenta.setBounds(25, 43, 230, 26);
		contentPanel.add(comboCuenta);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(347, 19, 101, 14);
		contentPanel.add(lblCliente);
		
		comboCliente = new JComboBox();
		comboCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean enabled = true;
				if(comboCliente.getSelectedIndex() != 0)
				{
					enabled = true;
				}
				else
				{
					enabled = false;
				}
				txtCodigo.setEnabled(enabled);
				txtInteresFijo.setEnabled(enabled);
				txtMontoMensual.setEnabled(enabled);
				txtSaldo.setEnabled(enabled);
				txtMontoMaximo.setEnabled(enabled);
				spinnerCorte.setEnabled(enabled);
				spinnerTiempo.setEnabled(enabled);
				comboEstado.setEnabled(enabled);

			}
		});
		
		CVPanel = new JPanel();
		CVPanel.setBounds(25, 200, 523, 90);
		contentPanel.add(CVPanel);
		CVPanel.setLayout(null);
		
		JLabel lblTiempoDeApertura = new JLabel("Tiempo");
		lblTiempoDeApertura.setBounds(125, 8, 157, 14);
		CVPanel.add(lblTiempoDeApertura);
		
		spinnerTiempo = new JSpinner();
		spinnerTiempo.setEnabled(false);
		spinnerTiempo.setBounds(125, 38, 101, 26);
		CVPanel.add(spinnerTiempo);
		
		txtMontoMensual = new JTextField();
		txtMontoMensual.setEnabled(false);
		txtMontoMensual.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMontoMensual.setColumns(10);
		txtMontoMensual.setBounds(279, 38, 202, 23);
		CVPanel.add(txtMontoMensual);
		
		JLabel lblMontoMensual = new JLabel("Monto mensual");
		lblMontoMensual.setBounds(279, 8, 129, 14);
		CVPanel.add(lblMontoMensual);
		CVPanel.setVisible(false);
		comboCliente.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar"}));
		comboCliente.setBounds(285, 43, 217, 26);
		contentPanel.add(comboCliente);
		
		FIPanel = new JPanel();
		FIPanel.setBounds(25, 200, 523, 90);
		contentPanel.add(FIPanel);
		FIPanel.setLayout(null);
		
		txtInteresFijo = new JTextField();
		txtInteresFijo.setEnabled(false);
		txtInteresFijo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtInteresFijo.setColumns(10);
		txtInteresFijo.setBounds(126, 46, 202, 23);
		FIPanel.add(txtInteresFijo);
		
		JLabel lblIntersFijo = new JLabel("Inter\u00E9s fijo");
		lblIntersFijo.setBounds(126, 16, 129, 14);
		FIPanel.add(lblIntersFijo);
		
		CCPanel = new JPanel();
		CCPanel.setBounds(25, 200, 523, 90);
		contentPanel.add(CCPanel);
		CCPanel.setLayout(null);
		
		JLabel lblMontoMximo = new JLabel("Monto m\u00E1ximo");
		lblMontoMximo.setBounds(124, 16, 106, 20);
		CCPanel.add(lblMontoMximo);
		
		txtMontoMaximo = new JTextField();
		txtMontoMaximo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMontoMaximo.setEnabled(false);
		txtMontoMaximo.setColumns(10);
		txtMontoMaximo.setBounds(119, 40, 225, 23);
		CCPanel.add(txtMontoMaximo);
		FIPanel.setVisible(false);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Cuenta cuenta = null;
						Cliente cliente = null;
						ArrayList<Cuenta> clienteCuentas;
						String codigo = txtCodigo.getText();
						int corteDelMes = Integer.valueOf(spinnerCorte.getValue().toString());
						int puntos = 0;
						String estado = comboEstado.getSelectedItem().toString();
						double saldo = Double.valueOf(txtSaldo.getText());
						int tiempoADurar = 0;
						double montoMensual = 0;
						double interesFijo = 0;
						String clienteDato = comboCliente.getSelectedItem().toString();
						String[] partes = clienteDato.split("-");
						
						switch(comboCuenta.getSelectedItem().toString())
						{
							case "Cuenta Corriente": 
								double montoMaximo = Double.valueOf(txtMontoMaximo.getText());
								cuenta = new CC(codigo, corteDelMes, puntos, estado, saldo, montoMaximo); break;
							case "Cuenta Vivienda": 
								montoMensual = Double.valueOf(txtMontoMensual.getText());
								tiempoADurar = Integer.valueOf(spinnerTiempo.getValue().toString());
								cuenta = new CV(codigo, corteDelMes, puntos, estado, saldo, tiempoADurar, montoMensual);  break;
							case "Fondo Inversión":
								interesFijo = Double.valueOf(txtInteresFijo.getText());
								cuenta = new FI(codigo, corteDelMes, puntos, estado, saldo, interesFijo); break;
						}
						cliente = Banco.getInstance().buscarCliente(partes[0]);
						//clienteCuentas = cliente.getCuentas();
						//clienteCuentas.add(cuenta);
						//cliente.setCuentas(clienteCuentas);
						Banco.getInstance().agregarCuenta(cliente, cuenta);
						txtCodigo.setText("");
						txtInteresFijo.setText("");
						txtMontoMensual.setText("");
						txtSaldo.setText("");
						txtMontoMaximo.setText("");
						comboEstado.setSelectedIndex(0);
						comboCliente.setSelectedIndex(0);
						spinnerCorte.setValue(0);
						spinnerTiempo.setValue(0);
						txtCodigo.requestFocus();
						JOptionPane.showMessageDialog(null, "Agregado");
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		cargarClientes();
	}
	public void cargarClientes()
	{
		ArrayList<Cliente> clientes = Banco.getInstance().getClientes();
		if(clientes.size() >0 )
		{
			for (Cliente cliente : clientes) {
					comboCliente.addItem(cliente.getCedula() + "-" + cliente.getNombre() + " " + cliente.getApellidos());
			}
		}

	}
}
