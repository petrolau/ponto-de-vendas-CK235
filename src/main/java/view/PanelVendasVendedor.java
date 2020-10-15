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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class PanelVendasVendedor extends JPanel {
	private JTable table;
	private JTextField textFieldInputTotal;
	private JTextField textFieldQuantidade;
	/**
	 * Create the panel.
	 */
	public PanelVendasVendedor() {
		setBackground(Color.WHITE);
		this.setBounds(0, 0, 768, 580);
		setLayout(null);
		
		JLabel lblVender = new JLabel("VENDER");
		lblVender.setBounds(341, 5, 115, 33);
		lblVender.setFont(new Font("Fira Code", Font.PLAIN, 25));
		lblVender.setForeground(new Color(129,129,129));
		add(lblVender);
		
		JLabel lblFiltrarPor = new JLabel("Adicionar produto a venda:");
		lblFiltrarPor.setBounds(418, 176, 164, 14);
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
				PanelController.getInstance().retornar();
			}
		});
		btnVoltar.setBackground(new Color(0, 191, 255));
		btnVoltar.setBounds(157, 512, 90, 28);
		add(btnVoltar);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 191, 255), 30, true));
		panel.setBounds(3, 51, 396, 50);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setBounds(32, 13, 102, 24);
		lblProduto.setFont(new Font("Fira Code",Font.PLAIN,18));
		lblProduto.setForeground(Color.WHITE);
		panel.add(lblProduto);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(146, 13, 102, 24);
		lblQuantidade.setForeground(Color.WHITE);
		lblQuantidade.setFont(new Font("Fira Code",Font.PLAIN,18));
		panel.add(lblQuantidade);
		
		JLabel lblPreco= new JLabel("Preço");
		lblPreco.setBounds(294, 13, 58, 24);
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
		table.setBounds(3, 101, 396, 381);
		add(table);
		
		JButton btnMenos = new JButton("-");
		btnMenos.setForeground(Color.WHITE);
		btnMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMenos.setBackground(new Color(0, 191, 255));
		btnMenos.setBounds(634, 208, 45, 28);
		add(btnMenos);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setForeground(Color.WHITE);
		btnFinalizar.setBackground(new Color(0, 191, 255));
		btnFinalizar.setBounds(610, 512, 90, 28);
		add(btnFinalizar);
		
		JLabel lblTotal = new JLabel("TOTAL:");
		lblTotal.setForeground(new Color(134, 134, 134));
		lblTotal.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblTotal.setBounds(553, 477, 45, 14);
		add(lblTotal);
		
		textFieldInputTotal = new JTextField();
		textFieldInputTotal.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 206, 209)));
		textFieldInputTotal.setBackground(Color.WHITE);
		textFieldInputTotal.setBounds(610, 475, 90, 20);
		add(textFieldInputTotal);
		textFieldInputTotal.setColumns(10);
		
		JButton btnAdicionar_1 = new JButton("Adicionar");
		btnAdicionar_1.setForeground(Color.WHITE);
		btnAdicionar_1.setBackground(new Color(0, 191, 255));
		btnAdicionar_1.setBounds(418, 252, 90, 28);
		add(btnAdicionar_1);
		
		JButton btnMais = new JButton("+");
		btnMais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMais.setForeground(Color.WHITE);
		btnMais.setBackground(new Color(0, 191, 255));
		btnMais.setBounds(713, 208, 45, 28);
		add(btnMais);
		
		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 206, 209)));
		textFieldQuantidade.setForeground(new Color(0, 0, 0));
		textFieldQuantidade.setBounds(681, 212, 29, 20);
		add(textFieldQuantidade);
		textFieldQuantidade.setColumns(10);
		
	

	}
}
