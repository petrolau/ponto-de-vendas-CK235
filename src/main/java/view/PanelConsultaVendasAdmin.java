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

import controller.ProdutoController;
import controller.UsuarioController;
import controller.VendaController;
import model.Produto;
import model.Usuario;
import model.Venda;
import util.Utils;

import java.awt.CardLayout;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class PanelConsultaVendasAdmin extends JPanel {
	private JTable table;
	private DefaultTableModel dfm;
	private JComboBox<Object> comboVendedores;
	private JComboBox<Object> comboProdutos;
	private List<Venda> exibindo;

	/**
	 * Create the panel.
	 */
	private void limparTabela() {
		while (dfm.getRowCount() > 0) {
			dfm.removeRow(dfm.getRowCount() - 1);
		}
	}

	private void atualizaTabela() {
		atualizaTabela(VendaController.getVendasList());
	}

	private void atualizaTabela(List<Venda> vendas) {
		limparTabela();
		for (Venda v : vendas) {
			dfm.addRow(new Object[] { v.getUser(), v.getVendido(), v.getDataVenda(),
					"R$ " + v.getVendido().getPreco() * v.getQtVendido() });
		}
		exibindo = vendas;

	}

	private void atualizaComboVendedores() {
		List<Usuario> usuarios = UsuarioController.getVendedorList();
		for (Usuario u : usuarios) {
			comboVendedores.addItem(u);
		}

	}

	private void atualizaComboProdutos() {
		List<Produto> produtos = ProdutoController.getProdutoList();
		for (Produto p : produtos) {
			comboProdutos.addItem(p);
		}
	}

	private void atualizaListaVendedores() {
		if (comboProdutos != null && comboVendedores != null) {
			List<Venda> vendas = VendaController.getVendasList();
			Produto ProdSelec;
			Usuario UserSelec;
			if (comboProdutos.getSelectedItem() instanceof String) {
				ProdSelec = null;
			} else {
				ProdSelec = (Produto) comboProdutos.getSelectedItem();
			}
			if (comboVendedores.getSelectedItem() instanceof String) {
				UserSelec = null;
			} else {
				UserSelec = (Usuario) comboVendedores.getSelectedItem();
			}
			List<Venda> remover = new ArrayList<Venda>();
			if (ProdSelec != null) {
				for (Venda v : vendas) {
					if (!v.getVendido().getId().equals(ProdSelec.getId())) {
						remover.add(v);
					}
				}
			}
			vendas.removeAll(remover);
			remover.clear();
			if (UserSelec != null) {
				for (Venda v : vendas) {
					if (!v.getUser().getId().equals(UserSelec.getId())) {
						remover.add(v);
					}
				}
			}
			vendas.removeAll(remover);
			atualizaTabela(vendas);
		}
	}

	@SuppressWarnings("serial")
	public PanelConsultaVendasAdmin() {
		setBackground(Color.WHITE);
		this.setBounds(0, 0, 768, 580);
		setLayout(null);

		JLabel lblVendas = new JLabel("Vendas");
		lblVendas.setBounds(341, 5, 218, 33);
		lblVendas.setFont(new Font("Fira Code", Font.PLAIN, 25));
		lblVendas.setForeground(new Color(129, 129, 129));
		add(lblVendas);

		JLabel lblFiltrarPor = new JLabel("Filtrar por:");
		lblFiltrarPor.setBounds(10, 54, 99, 14);
		lblFiltrarPor.setForeground(new Color(134, 134, 134));
		lblFiltrarPor.setFont(new Font("Fira Code", Font.PLAIN, 13));
		add(lblFiltrarPor);

		comboVendedores = new JComboBox<Object>();
		comboVendedores.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				atualizaListaVendedores();
			}
		});
		comboVendedores.setModel(new DefaultComboBoxModel(new String[] { "Vendedor" }));

		comboVendedores.setBackground(Color.WHITE);
		comboVendedores.setBounds(10, 74, 206, 38);
		add(comboVendedores);
		atualizaComboVendedores();
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setForeground(new Color(129, 129, 129));

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(new Object[][] { { "Cinthia", "Produtos", "10/05-18:52", "R$ 240" }, },
				new String[] { "Produtos", "Produtos", "Quantidade", "Pre\u00E7o" }) {
			Class[] columnTypes = new Class[] { String.class, Object.class, Object.class, Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setTableHeader(null);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(185);
		table.getColumnModel().getColumn(0).setMinWidth(185);
		table.getColumnModel().getColumn(0).setMaxWidth(185);

		table.setRowHeight(30);
		dfm = (DefaultTableModel) table.getModel();
		atualizaTabela();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		// table.setBounds(10, 187, 740, 328);
		table.setFont(new Font("Fira Code", Font.PLAIN, 13));
		// add(table);

		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelController.getInstance().retornar();
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		scrollPane.setBounds(10, 187, 740, 328);
		add(scrollPane);
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
		lblVendedor.setFont(new Font("Fira Code", Font.PLAIN, 18));
		lblVendedor.setForeground(Color.WHITE);
		panel.add(lblVendedor);

		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setBounds(189, 21, 107, 16);
		lblProdutos.setForeground(Color.WHITE);
		lblProdutos.setFont(new Font("Fira Code", Font.PLAIN, 18));
		panel.add(lblProdutos);

		JLabel lblDataHora = new JLabel("Data/Hora");
		lblDataHora.setBounds(373, 21, 129, 16);
		lblDataHora.setForeground(Color.WHITE);
		lblDataHora.setFont(new Font("Fira Code", Font.PLAIN, 18));
		panel.add(lblDataHora);

		JLabel lblPreco = new JLabel("Total");
		lblPreco.setBounds(557, 21, 129, 16);
		lblPreco.setForeground(Color.WHITE);
		lblPreco.setFont(new Font("Fira Code", Font.PLAIN, 18));
		panel.add(lblPreco);

		comboProdutos = new JComboBox();
		comboProdutos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				atualizaListaVendedores();
			}
		});
		comboProdutos.setModel(new DefaultComboBoxModel(new String[] { "Produtos" }));
		comboProdutos.setBackground(Color.WHITE);
		comboProdutos.setBounds(228, 74, 206, 38);
		add(comboProdutos);
		atualizaComboProdutos();

		JButton btnRelatrio = new JButton("Relat\u00F3rio");
		btnRelatrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.gerarRelatorioVendas(exibindo);
			}
		});
		btnRelatrio.setForeground(Color.WHITE);
		btnRelatrio.setBackground(new Color(102, 206, 214));
		btnRelatrio.setBounds(570, 541, 90, 28);
		add(btnRelatrio);

	}

}
