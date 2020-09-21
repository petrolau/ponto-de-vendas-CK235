package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class PanelConsultaEstoqueAdmin extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelConsultaEstoqueAdmin() {
		setBackground(Color.WHITE);
		this.setBounds(0, 0, 768, 580);
		setLayout(null);
		
		JLabel lblEstoque = new JLabel("ESTOQUE");
		lblEstoque.setBounds(332, 12, 130, 20);
		lblEstoque.setFont(new Font("Fira Code", Font.PLAIN, 25));
		lblEstoque.setForeground(new Color(129,129,129));
		add(lblEstoque);
		
		JLabel lblFiltrarPor = new JLabel("Filtrar por:");
		lblFiltrarPor.setBounds(10, 54, 99, 14);
		lblFiltrarPor.setForeground(new Color(134, 134, 134));
		lblFiltrarPor.setFont(new Font("Fira Code",Font.PLAIN,13));
		add(lblFiltrarPor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(10, 74, 206, 38);
		add(comboBox);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(new Color(102, 206, 214));
		btnVoltar.setBounds(337, 546, 90, 28);
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
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(301, 21, 129, 16);
		lblQuantidade.setForeground(Color.WHITE);
		lblQuantidade.setFont(new Font("Fira Code",Font.PLAIN,18));
		panel.add(lblQuantidade);
		
		JLabel lblPreco= new JLabel("Pre�o");
		lblPreco.setBounds(584, 21, 129, 16);
		lblPreco.setForeground(Color.WHITE);
		lblPreco.setFont(new Font("Fira Code",Font.PLAIN,18));
		panel.add(lblPreco);
		
		table = new JTable();
		table.setBorder(new LineBorder(Color.LIGHT_GRAY));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"livro", "30", "52"},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(2).setResizable(false);
		table.setBounds(10, 180, 740, 328);
		add(table);

	}
}
