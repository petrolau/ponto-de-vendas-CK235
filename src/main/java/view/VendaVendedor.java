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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class VendaVendedor extends JPanel {
	private JTable table;
	private JTextField textFieldInputTotal;
	private JTextField textFieldQuantidade;
	/**
	 * Create the panel.
	 */
	public VendaVendedor() {
		setBackground(Color.WHITE);
		this.setBounds(0, 0, 768, 580);
		setLayout(null);
		
		JLabel lblVender = new JLabel("VENDER");
		lblVender.setBounds(341, 5, 115, 33);
		lblVender.setFont(new Font("Fira Code", Font.PLAIN, 25));
		lblVender.setForeground(new Color(129,129,129));
		add(lblVender);
		
		JLabel lblFiltrarPor = new JLabel("Adicionar produto a venda:");
		lblFiltrarPor.setBounds(418, 178, 164, 14);
		lblFiltrarPor.setForeground(new Color(134, 134, 134));
		lblFiltrarPor.setFont(new Font("Fira Code",Font.PLAIN,13));
		add(lblFiltrarPor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(418, 203, 206, 38);
		add(comboBox);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVoltar.setBackground(new Color(102, 206, 214));
		btnVoltar.setBounds(157, 512, 90, 28);
		add(btnVoltar);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 255, 255), 30, true));
		panel.setBounds(3, 49, 396, 50);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setBounds(32, 21, 102, 16);
		lblProduto.setFont(new Font("Fira Code",Font.PLAIN,18));
		lblProduto.setForeground(Color.WHITE);
		panel.add(lblProduto);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(144, 21, 102, 16);
		lblQuantidade.setForeground(Color.WHITE);
		lblQuantidade.setFont(new Font("Fira Code",Font.PLAIN,18));
		panel.add(lblQuantidade);
		
		JLabel lblPreco= new JLabel("Preço");
		lblPreco.setBounds(294, 21, 58, 16);
		lblPreco.setForeground(Color.WHITE);
		lblPreco.setFont(new Font("Fira Code",Font.PLAIN,18));
		panel.add(lblPreco);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table.setBorder(new LineBorder(new Color(128, 128, 128)));
		table.setRowSelectionAllowed(false);
		table.setShowGrid(false);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.setBounds(3, 97, 396, 385);
		add(table);
		
		JButton btnMenos = new JButton("-");
		btnMenos.setForeground(Color.WHITE);
		btnMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMenos.setBackground(new Color(102, 206, 214));
		btnMenos.setBounds(634, 208, 45, 28);
		add(btnMenos);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setForeground(Color.WHITE);
		btnFinalizar.setBackground(new Color(102, 206, 214));
		btnFinalizar.setBounds(610, 512, 90, 28);
		add(btnFinalizar);
		
		JLabel lblTotal = new JLabel("TOTAL:");
		lblTotal.setForeground(new Color(134, 134, 134));
		lblTotal.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblTotal.setBounds(553, 477, 45, 14);
		add(lblTotal);
		
		textFieldInputTotal = new JTextField();
		textFieldInputTotal.setBackground(Color.WHITE);
		textFieldInputTotal.setBounds(610, 475, 90, 20);
		add(textFieldInputTotal);
		textFieldInputTotal.setColumns(10);
		
		JButton btnAdicionar_1 = new JButton("Adicionar");
		btnAdicionar_1.setForeground(Color.WHITE);
		btnAdicionar_1.setBackground(new Color(102, 206, 214));
		btnAdicionar_1.setBounds(418, 252, 90, 28);
		add(btnAdicionar_1);
		
		JButton btnMais = new JButton("+");
		btnMais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMais.setForeground(Color.WHITE);
		btnMais.setBackground(new Color(102, 206, 214));
		btnMais.setBounds(713, 208, 45, 28);
		add(btnMais);
		
		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setBounds(681, 212, 29, 20);
		add(textFieldQuantidade);
		textFieldQuantidade.setColumns(10);
		
	

	}
}
