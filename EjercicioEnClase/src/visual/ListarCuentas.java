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
import logical.CC;
import logical.CV;
import logical.Cliente;
import logical.Cuenta;
import logical.FI;

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
import java.awt.SystemColor;

public class ListarCuentas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static Object[] fila;
	private static DefaultTableModel model;
	private String tipoLista;
	private String id;
	private String cedula;
	
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
	public ListarCuentas(String cedula) {
		this.cedula = cedula;
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListarCuentas.class.getResource("/img/if_list_103613.png")));
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				loadTable("");
			}
		});
		setResizable(false);
		setTitle("Cuentas");
		tipoLista = cedula;


		
		setBounds(100, 100, 708, 254);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.activeCaption);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(5, 16, 683, 124);
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
							//id = (String)table.getModel().getValueAt(index, 0);
							//System.out.println(id);				
						}
					}
				});
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				//CODIGO AGREGADO POR MI

				String[] columnNames = {"Tipo","Código","Meses de apertura","Corte","Puntos", "Estado", "Saldo"};				

				model = new DefaultTableModel();
				model.setColumnIdentifiers(columnNames);
				table.setModel(model);
				loadTable("");
				scrollPane.setViewportView(table);
			}
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.activeCaption);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
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
		for (Cliente c : Banco.getInstance().getClientes()) {
//				String[] columnNames = {"Tipo","Código","Meses de apertura","Corte","Puntos", "Estado", "Saldo"};				
					if(c.getCedula().equalsIgnoreCase(cedula))
					{
						for (Cuenta cuenta : c.getCuentas()) {
							if(cuenta instanceof CC)
								fila[0] = "Corriente";
							if(cuenta instanceof CV)
								fila[0] = "Vivienda";
							if(cuenta instanceof FI)
								fila[0] = "Inversión";
							fila[1] = cuenta.getCodigo();
							fila[2] = cuenta.getMesesApertura();
							fila[3] = cuenta.getCorteDelMes();
							fila[4] = cuenta.getPuntos();
							fila[5] = cuenta.getEstado();
							fila[6] = cuenta.getSaldo();
							model.addRow(fila);

						}
					}

				}
		
	}	
}


