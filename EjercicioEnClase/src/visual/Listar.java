package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logical.Banco;
import logical.Cliente;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Listar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static Object[] fila;
	private static DefaultTableModel model;
	private String tipoLista;
	private String id;
	private JTextField txtBuscar;

	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			Listar dialog = new Listar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public Listar(String tipoDeLista) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Listar.class.getResource("/img/if_list_103613.png")));
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				loadTable("");
			}
		});
		setResizable(false);
		setTitle("Lista");
		tipoLista = tipoDeLista;


		
		setBounds(100, 100, 699, 514);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(5, 45, 683, 385);
			scrollPane.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					loadTable("");
				}
			});
			contentPanel.setLayout(null);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						//Obtener index
						int index;
						if(table.getSelectedRow()>=0){
							//btnEliminar.setEnabled(true);
							//btnModificar.setEnabled(true);
							index = table.getSelectedRow();
							switch(tipoLista)
							{
								//case "Clientes": id = (String) table.getModel().getValueAt(index, 2);  break;
								//case "Barcos"  : id = (String) table.getModel().getValueAt(index,1); break;
								//case "Alquiler": ; break;
							}
							id = (String)table.getModel().getValueAt(index, 2);
							//System.out.println(id);				
						}
					}
				});
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				//CODIGO AGREGADO POR MI
				String[] columnNames = {""};
				if(tipoDeLista.equalsIgnoreCase("Clientes"))
				{
					String[] columnNamesClientes = {"Nombres","Apellidos","Cedula","Dirección", "Teléfono", "Cuentas"};
					columnNames = columnNamesClientes;
				}

				model = new DefaultTableModel();
				model.setColumnIdentifiers(columnNames);
				table.setModel(model);
				loadTable("");
				scrollPane.setViewportView(table);
			}
			
		}
		
		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(15, 9, 69, 20);
		contentPanel.add(lblBuscar);
		
		txtBuscar = new JTextField();
		txtBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable(txtBuscar.getText());
			}
		});
		txtBuscar.setHorizontalAlignment(SwingConstants.RIGHT);
		txtBuscar.setToolTipText("Mediante cedula o numero de cuenta");
		txtBuscar.setBounds(74, 6, 262, 28);
		contentPanel.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JLabel lblCedulanumeroDeCuenta = new JLabel("Cedula");
		lblCedulanumeroDeCuenta.setBounds(345, 10, 240, 20);
		contentPanel.add(lblCedulanumeroDeCuenta);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton botonOk = new JButton("Buscar cuentas");
				botonOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ListarCuentas listarc = new ListarCuentas(id);
						listarc.setModal(true);
						listarc.setVisible(true);
					}
				});

				botonOk.setActionCommand("OK");
				buttonPane.add(botonOk);
				getRootPane().setDefaultButton(botonOk);
			}
			{
				JButton cancelButton = new JButton("Revisi\u00F3n");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Double revision = Banco.getInstance().revision(id);
						JOptionPane.showMessageDialog(null, "Saldo total: RD$" + revision);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}
	public void loadTable(String busqueda) {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];		
	

		if(tipoLista.equalsIgnoreCase("Clientes"))
		{
		for (Cliente c : Banco.getInstance().getClientes()) {
				if(busqueda.equalsIgnoreCase(""))
				{
					fila[0] = c.getNombre();
					fila[1] = c.getApellidos();
					fila[2] = c.getCedula();
					fila[3] = c.getDireccion();
					fila[4] = c.getTelefono();
					fila[5] = c.getCuentas().size();
				}
				else
				{
					if(c.getCedula().equalsIgnoreCase(busqueda))
					{
						fila[0] = c.getNombre();
						fila[1] = c.getApellidos();
						fila[2] = c.getCedula();
						fila[3] = c.getDireccion();
						fila[4] = c.getTelefono();
						fila[5] = c.getCuentas().size();
					}
					
				}
				
				model.addRow(fila);

			}

		}
		
	}	
}


