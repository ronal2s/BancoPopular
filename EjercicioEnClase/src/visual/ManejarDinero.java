package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logical.Banco;
import logical.Cuenta;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ManejarDinero extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMonto;
	private JTextField txtBalance;
	private JTextField txtNumeroCuenta;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			ManejarDinero dialog = new ManejarDinero();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public ManejarDinero(String accion) {
		setTitle("Manejo de efectivo");
		setBounds(100, 100, 415, 280);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel PanelIngresarDinero = new JPanel();
			contentPanel.add(PanelIngresarDinero, BorderLayout.CENTER);
			PanelIngresarDinero.setLayout(null);
			{
				JLabel lblNumeroDeCuenta = new JLabel("Numero de cuenta");
				lblNumeroDeCuenta.setBounds(15, 16, 174, 20);
				PanelIngresarDinero.add(lblNumeroDeCuenta);
			}
			{
				txtMonto = new JTextField();
				txtMonto.setHorizontalAlignment(SwingConstants.RIGHT);
				txtMonto.setColumns(10);
				txtMonto.setBounds(15, 99, 230, 23);
				PanelIngresarDinero.add(txtMonto);
			}
			{
				JLabel lblMonto = new JLabel("Monto");
				lblMonto.setBounds(15, 74, 92, 14);
				PanelIngresarDinero.add(lblMonto);
			}
			{
				txtBalance = new JTextField();
				txtBalance.setBackground(SystemColor.info);
				txtBalance.setHorizontalAlignment(SwingConstants.RIGHT);
				txtBalance.setEnabled(false);
				txtBalance.setColumns(10);
				txtBalance.setBounds(222, 138, 146, 23);
				PanelIngresarDinero.add(txtBalance);
			}
			{
				JLabel lblBalance = new JLabel("Balance");
				lblBalance.setBounds(138, 140, 69, 20);
				PanelIngresarDinero.add(lblBalance);
			}
			{
				txtNumeroCuenta = new JTextField();
				txtNumeroCuenta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ArrayList<Cuenta> cuentas = Banco.getInstance().getCuentas();
						int i = Banco.getInstance().getCuentaOfCliente(txtNumeroCuenta.getText());
						if(i!= -1)
						{
							txtBalance.setText(String.valueOf(cuentas.get(i).getSaldo()));
						}
					}
				});
				txtNumeroCuenta.setHorizontalAlignment(SwingConstants.RIGHT);
				txtNumeroCuenta.setColumns(10);
				txtNumeroCuenta.setBounds(15, 40, 230, 23);
				PanelIngresarDinero.add(txtNumeroCuenta);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Double balance = Double.valueOf(txtBalance.getText());
						if(accion.equalsIgnoreCase("Ingreso"))
						{
							Banco.getInstance().ingresarDinero(txtNumeroCuenta.getText(), Integer.valueOf(txtMonto.getText()));
							balance = balance + Double.valueOf(txtMonto.getText());
							txtBalance.setText(String.valueOf(balance));
							
						}
						else
						{
							Banco.getInstance().retirarDinero(txtNumeroCuenta.getText(), Integer.valueOf(txtMonto.getText()));
							balance = balance - Double.valueOf(txtMonto.getText());
							txtBalance.setText(String.valueOf(balance));
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
