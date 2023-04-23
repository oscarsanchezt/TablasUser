package proyecto;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class admin {

	private JFrame frame;
	private JTextField textFieldnombre;
	private JTextField textdni;
	private JTable table;
	private DefaultListModel<String> listModel;

	public static void main(String[] args) {
		admin window = new admin();
		window.frame.setVisible(true);
	}

	public admin() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(26, 95, 180));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textFieldnombre = new JTextField();
		textFieldnombre.setBounds(12, 12, 114, 21);
		frame.getContentPane().add(textFieldnombre);
		textFieldnombre.setColumns(10);

		textdni = new JTextField();
		textdni.setBounds(12, 45, 114, 21);
		frame.getContentPane().add(textdni);
		textdni.setColumns(10);

		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.setBounds(12, 78, 105, 27);
		frame.getContentPane().add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 117, 104, 144);
		frame.getContentPane().add(scrollPane);

		listModel = new DefaultListModel<String>();
		JList<String> list = new JList<String>(listModel);
		list.setBackground(new Color(98, 160, 234));
		scrollPane.setViewportView(list);

		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setBackground(new Color(98, 160, 234));
		table.setToolTipText("");
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "NOMBRE", "TELEFONO" }) {
			Class[] columnTypes = new Class[] { String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		table.setBounds(210, 48, 184, 192);
		frame.getContentPane().add(table);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textFieldnombre.getText();
				String dni = textdni.getText();
				listModel.addElement(nombre);
			}
		});

		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					String selectedNombre = list.getSelectedValue();
					DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
					tableModel.addRow(new Object[] { selectedNombre, textdni.getText() });
				}
			}
		});

	}
}
