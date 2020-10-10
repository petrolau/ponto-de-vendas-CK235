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

public class PanelConsultaVendasVendedor extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("serial")
	public PanelConsultaVendasVendedor() {
		setBackground(Color.WHITE);
		this.setBounds(0, 0, 768, 580);
		setLayout(null);
		
		JLabel lblVendas = new JLabel("Vendas");
		lblVendas.setBounds(341, 5, 86, 33);
		lblVendas.setFont(new Font("Fira Code", Font.PLAIN, 25));
		lblVendas.setForeground(new Color(129,129,129));
		add(lblVendas);
		
		JLabel lblFiltrarPor = new JLabel("Filtrar por:");
		lblFiltrarPor.setBounds(10, 54, 99, 14);
		lblFiltrarPor.setForeground(new Color(134, 134, 134));
		lblFiltrarPor.setFont(new Font("Fira Code",Font.PLAIN,13));
		add(lblFiltrarPor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(10, 74, 206, 38);
		add(comboBox);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setForeground(new Color(129, 129, 129));

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Livro", "Um  Livro sobre Amor e amizade", "300", "R$ 240"},
				{"Livro", "Um livro sobre amizade e amor", "10", "R$ 120"},
			},
			new String[] {
				"Produtos", "Descricao", "Quantidade", "Pre\u00E7o"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(185);
		table.getColumnModel().getColumn(0).setMinWidth(185);
		table.getColumnModel().getColumn(0).setMaxWidth(185);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(185);
		table.getColumnModel().getColumn(1).setMinWidth(185);
		table.getColumnModel().getColumn(1).setMaxWidth(185);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(185);
		table.getColumnModel().getColumn(2).setMinWidth(185);
		table.getColumnModel().getColumn(2).setMaxWidth(185);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(185);
		table.getColumnModel().getColumn(3).setMinWidth(185);
		table.getColumnModel().getColumn(3).setMaxWidth(185);
		((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		
		table.setBounds(10, 187, 740, 328);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setFont(new Font("Fira Code",Font.PLAIN,13));
		add(table);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(102, 206, 214));
		btnVoltar.setBounds(337, 527, 90, 28);
		add(btnVoltar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 206, 214));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		panel.setBounds(10, 124, 740, 56);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setBounds(41, 21, 102, 16);
		lblProduto.setFont(new Font("Fira Code",Font.PLAIN,18));
		lblProduto.setForeground(Color.WHITE);
		panel.add(lblProduto);
		
		JLabel lblDesc = new JLabel("Descrição");
		lblDesc.setBounds(200, 21, 146, 16);
		lblDesc.setForeground(Color.WHITE);
		lblDesc.setFont(new Font("Fira Code",Font.PLAIN,18));
		panel.add(lblDesc);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(405, 21, 129, 16);
		lblQuantidade.setForeground(Color.WHITE);
		lblQuantidade.setFont(new Font("Fira Code",Font.PLAIN,18));
		panel.add(lblQuantidade);
		
		JLabel lblPreco= new JLabel("Preço");
		lblPreco.setBounds(591, 21, 129, 16);
		lblPreco.setForeground(Color.WHITE);
		lblPreco.setFont(new Font("Fira Code",Font.PLAIN,18));
		panel.add(lblPreco);
		
	}
}
