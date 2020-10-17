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
import javax.swing.text.NumberFormatter;

import controller.ProdutoController;
import controller.UsuarioController;
import controller.VendaController;
import model.Produto;
import model.Venda;
import util.Utils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ItemEvent;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JFormattedTextField;

public class PanelVendasVendedor extends JPanel {
	private JTable table;
	private JTextField textFieldInputTotal;
	private JFormattedTextField textFieldQuantidade;
	private int numeroDeVendas = 0;
	private DefaultTableModel dfm;
	private List<Venda> vendas = new ArrayList<Venda>();
	private double total;

	/**
	 * Create the panel.
	 */
	private void atualizaQuant() {
		if (textFieldQuantidade != null)
			textFieldQuantidade.setText(Integer.toString(numeroDeVendas));
	}

	private void limparTabela() {
		while (dfm.getRowCount() > 0) {
			dfm.removeRow(dfm.getRowCount() - 1);
		}
	}

	private void atualizaTabela() {
		limparTabela();
		total = 0;
		for (Venda v : vendas) {
			dfm.addRow(new Object[] { v, v.getQtVendido(), "R$ " + v.getVendido().getPreco() });
			total += v.getQtVendido() * v.getVendido().getPreco();
			textFieldInputTotal.setText("R$ " + Double.toString(total));
		}
	}

	public PanelVendasVendedor() {
		setBackground(Color.WHITE);
		this.setBounds(0, 0, 768, 580);
		setLayout(null);

		JLabel lblVender = new JLabel("VENDER");
		lblVender.setBounds(341, 5, 115, 33);
		lblVender.setFont(new Font("Fira Code", Font.PLAIN, 25));
		lblVender.setForeground(new Color(129, 129, 129));
		add(lblVender);

		JLabel lblFiltrarPor = new JLabel("Adicionar produto a venda:");
		lblFiltrarPor.setBounds(418, 176, 164, 14);
		lblFiltrarPor.setForeground(new Color(134, 134, 134));
		lblFiltrarPor.setFont(new Font("Fira Code", Font.PLAIN, 13));
		add(lblFiltrarPor);

		JComboBox<Produto> comboBox = new JComboBox<>();

		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				System.out.println("mudou o item?");
				numeroDeVendas = 0;
				atualizaQuant();
			}
		});

		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(418, 203, 206, 38);
		for (Produto p : ProdutoController.getProdutoList()) {
			comboBox.addItem(p);
		}
		add(comboBox);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelController.getInstance().retornar();
			}
		});
		btnVoltar.setBackground(new Color(0, 191, 255));
		btnVoltar.setBounds(3, 512, 90, 28);
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
		lblProduto.setFont(new Font("Fira Code", Font.PLAIN, 18));
		lblProduto.setForeground(Color.WHITE);
		panel.add(lblProduto);

		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(146, 13, 102, 24);
		lblQuantidade.setForeground(Color.WHITE);
		lblQuantidade.setFont(new Font("Fira Code", Font.PLAIN, 18));
		panel.add(lblQuantidade);

		JLabel lblPreco = new JLabel("Preço");
		lblPreco.setBounds(294, 13, 58, 24);
		lblPreco.setForeground(Color.WHITE);
		lblPreco.setFont(new Font("Fira Code", Font.PLAIN, 18));
		panel.add(lblPreco);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, },
				new String[] { "New column", "New column", "New column" }) {
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(132);
		table.getColumnModel().getColumn(0).setMinWidth(132);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(132);
		table.getColumnModel().getColumn(1).setMinWidth(132);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(132);
		table.getColumnModel().getColumn(2).setMinWidth(132);
		table.setBorder(new LineBorder(new Color(128, 128, 128)));
		((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		table.setRowSelectionAllowed(false);
		table.setShowGrid(false);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.setTableHeader(null);
		dfm = (DefaultTableModel) table.getModel();
		limparTabela();
		// table.setBounds(3, 101, 396, 381);
		// add(table);

		JButton btnMenos = new JButton("-");
		btnMenos.setForeground(Color.WHITE);
		btnMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (numeroDeVendas >= 1) {
					numeroDeVendas--;
					atualizaQuant();
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(3, 101, 396, 381);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		add(scrollPane);
		btnMenos.setBackground(new Color(0, 191, 255));
		btnMenos.setBounds(634, 208, 45, 28);
		add(btnMenos);

		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!vendas.isEmpty()) {
					VendaController.Vender(vendas);
					Utils.infoMessage("Produtos vendidos com sucesso");
				}else {
					Utils.errorMessage("não é possível vender sem produtos");
				}
				
			}
		});
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
		textFieldInputTotal.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textFieldInputTotal.setText("R$ \r\n");
		textFieldInputTotal.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textFieldInputTotal.setBackground(Color.WHITE);
		textFieldInputTotal.setBounds(610, 475, 90, 20);
		add(textFieldInputTotal);
		textFieldInputTotal.setColumns(10);

		JButton btnAdicionar_1 = new JButton("Adicionar");
		btnAdicionar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto p = (Produto) comboBox.getSelectedItem();
				for (Venda v : vendas) {
					if (v.getVendido().equals(p)) {
						Utils.errorMessage(
								"Não é possível adicionar o mesmo produto duas vezes, remova e readicione com a quantidade desejada");
						return;
					}
				}
				if (numeroDeVendas != 0 && numeroDeVendas <= p.getQtEmEstoque()) {

					Venda v = new Venda();
					v.setQtVendido(numeroDeVendas);
					// double preco = p.getPreco();
					// total += numeroDeVendas * preco;
					v.setVendido(p);
					v.setUser(UsuarioController.getInstance().getLoggedUser());
					v.setDataVenda(new Date());
					vendas.add(v);

					atualizaTabela();
				} else {
					Utils.errorMessage("Verifique a quantidade de produtos");
				}
			}
		});
		btnAdicionar_1.setForeground(Color.WHITE);
		btnAdicionar_1.setBackground(new Color(0, 191, 255));
		btnAdicionar_1.setBounds(418, 252, 90, 28);
		add(btnAdicionar_1);

		JButton btnMais = new JButton("+");
		btnMais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto p = (Produto) comboBox.getSelectedItem();
				if (numeroDeVendas < p.getQtEmEstoque()) {
					numeroDeVendas++;
					atualizaQuant();
				} else {
					numeroDeVendas = p.getQtEmEstoque();
					atualizaQuant();
				}
			}
		});
		btnMais.setForeground(Color.WHITE);
		btnMais.setBackground(new Color(0, 191, 255));
		btnMais.setBounds(713, 208, 45, 28);
		add(btnMais);

		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(0);
		formatter.setMaximum(Integer.MAX_VALUE);
		formatter.setAllowsInvalid(false);
		formatter.setCommitsOnValidEdit(false);
		textFieldQuantidade = new JFormattedTextField(formatter);
		textFieldQuantidade.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

			}
		});
		textFieldQuantidade.setText("0");
		textFieldQuantidade.setFont(new Font("SansSerif", Font.PLAIN, 12));
		atualizaQuant();
		textFieldQuantidade.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textFieldQuantidade.setForeground(new Color(0, 0, 0));
		textFieldQuantidade.setBounds(681, 212, 29, 20);
		add(textFieldQuantidade);
		textFieldQuantidade.setColumns(10);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendas.remove(table.getSelectedRow());
				atualizaTabela();
			}
		});
		btnRemover.setForeground(Color.WHITE);
		btnRemover.setBackground(new Color(0, 191, 255));
		btnRemover.setBounds(309, 512, 90, 28);
		add(btnRemover);

	}
}
