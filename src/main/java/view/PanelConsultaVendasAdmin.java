package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.CardLayout;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelConsultaVendasAdmin extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("serial")
	public PanelConsultaVendasAdmin() {
		setBackground(Color.WHITE);
		this.setBounds(0, 0, 768, 580);
		setLayout(null);
		
		JLabel lblVendas = new JLabel("Vendas");
		lblVendas.setBounds(341, 5, 218, 33);
		lblVendas.setFont(new Font("Fira Code", Font.PLAIN, 25));
		lblVendas.setForeground(new Color(129,129,129));
		add(lblVendas);
		
		JLabel lblFiltrarPor = new JLabel("Filtrar por:");
		lblFiltrarPor.setBounds(10, 54, 99, 14);
		lblFiltrarPor.setForeground(new Color(134, 134, 134));
		lblFiltrarPor.setFont(new Font("Fira Code",Font.PLAIN,13));
		add(lblFiltrarPor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Vendedor"}));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(10, 74, 206, 38);
		add(comboBox);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setForeground(new Color(129, 129, 129));

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Cinthia", "Produtos", "10/05-18:52", "R$ 240"},
			},
			new String[] {
				"Produtos", "Produtos", "Quantidade", "Pre\u00E7o"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(185);
		table.getColumnModel().getColumn(0).setMinWidth(185);
		table.getColumnModel().getColumn(0).setMaxWidth(185);

		table.setRowHeight(30);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setBounds(10, 187, 740, 328);
		table.setFont(new Font("Fira Code",Font.PLAIN,13));
		add(table);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelController.getInstance().retornar();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(102, 206, 214));
		btnNewButton.setBounds(126, 541, 90, 28);
		add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 206, 214));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		panel.setBounds(10, 124, 740, 56);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblVendedor = new JLabel("Vendedor");
		lblVendedor.setBounds(12, 21, 102, 16);
		lblVendedor.setFont(new Font("Fira Code",Font.PLAIN,18));
		lblVendedor.setForeground(Color.WHITE);
		panel.add(lblVendedor);
		
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setBounds(189, 21, 107, 16);
		lblProdutos.setForeground(Color.WHITE);
		lblProdutos.setFont(new Font("Fira Code",Font.PLAIN,18));
		panel.add(lblProdutos);
		
		JLabel lblDataHora = new JLabel("Data/Hora");
		lblDataHora.setBounds(373, 21, 129, 16);
		lblDataHora.setForeground(Color.WHITE);
		lblDataHora.setFont(new Font("Fira Code",Font.PLAIN,18));
		panel.add(lblDataHora);
		
		JLabel lblPreco= new JLabel("Total");
		lblPreco.setBounds(557, 21, 129, 16);
		lblPreco.setForeground(Color.WHITE);
		lblPreco.setFont(new Font("Fira Code",Font.PLAIN,18));
		panel.add(lblPreco);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Produtos"}));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(228, 74, 206, 38);
		add(comboBox_1);
		
		JButton btnRelatrio = new JButton("Relat\u00F3rio");
		btnRelatrio.setForeground(Color.WHITE);
		btnRelatrio.setBackground(new Color(102, 206, 214));
		btnRelatrio.setBounds(570, 541, 90, 28);
		add(btnRelatrio);
		
	}
}
