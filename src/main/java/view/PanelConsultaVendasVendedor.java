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

import controller.UsuarioController;
import controller.VendaController;
import model.Usuario;
import model.Venda;

import java.awt.CardLayout;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelConsultaVendasVendedor extends JPanel {
	private JTable table;
	private DefaultTableModel dfm;

	/**
	 * Create the panel.
	 */
	private void limparTabela() {
		while (dfm.getRowCount() > 0) {
			dfm.removeRow(dfm.getRowCount() - 1);
		}
	}

	private void atualizaTabela() {
		atualizaTabela(VendaController.getVendasListByUsuario(UsuarioController.getInstance().getLoggedUser()));

	}

	private void atualizaTabela(List<Venda> vendas) {
		limparTabela();
		for (Venda v : vendas) {
			dfm.addRow(new Object[] { v, v.getVendido().getDescricao(), v.getQtVendido(),
					"R$ " + v.getVendido().getPreco() });

		}
	}

	private void findUpdate(String s) {
		List<Venda> vendas=VendaController.getVendasListByUsuario(UsuarioController.getInstance().getLoggedUser());
		List<Venda> encontrados = new ArrayList<Venda>();
		for (Venda v : vendas) {
			if (v.getVendido().toString().toLowerCase().contains(s.toLowerCase())) {
				encontrados.add(v);
			}
		}
		atualizaTabela(encontrados);
	}

	public PanelConsultaVendasVendedor() {
		setBackground(Color.WHITE);
		this.setBounds(0, 0, 768, 580);
		setLayout(null);

		JLabel lblVendas = new JLabel("Vendas");
		lblVendas.setBounds(341, 5, 247, 33);
		lblVendas.setFont(new Font("Fira Code", Font.PLAIN, 25));
		lblVendas.setForeground(new Color(129, 129, 129));
		add(lblVendas);

		JLabel lblFiltrarPor = new JLabel("Filtrar por:");
		lblFiltrarPor.setBounds(10, 54, 99, 14);
		lblFiltrarPor.setForeground(new Color(134, 134, 134));
		lblFiltrarPor.setFont(new Font("Fira Code", Font.PLAIN, 13));
		add(lblFiltrarPor);

		JTextField FiltrarNomeField = new JTextField();
		FiltrarNomeField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!FiltrarNomeField.getText().isEmpty()) {
					findUpdate(FiltrarNomeField.getText());
				}else {
					atualizaTabela();
				}
			}
		});
		FiltrarNomeField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				atualizaTabela();
			}
		});
		FiltrarNomeField.setBackground(Color.WHITE);
		FiltrarNomeField.setBounds(10, 74, 206, 38);
		add(FiltrarNomeField);

		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setForeground(new Color(129, 129, 129));

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
				new Object[][] { { "Livro", "Um  Livro sobre Amor e amizade", "300", "R$ 240" }, },
				new String[] { "Produtos", "Descricao", "Quantidade", "Pre\u00E7o" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(185);
		table.getColumnModel().getColumn(0).setMinWidth(185);
		table.getColumnModel().getColumn(0).setMaxWidth(185);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.setRowHeight(30);
		dfm = (DefaultTableModel) table.getModel();
		atualizaTabela();
		table.setTableHeader(null);

		// table.setBounds(10, 187, 740, 328);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setFont(new Font("Fira Code", Font.PLAIN, 13));
		// add(table);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelController.getInstance().retornar();
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 187, 740, 328);
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(scrollPane);

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
		lblProduto.setFont(new Font("Fira Code", Font.PLAIN, 18));
		lblProduto.setForeground(Color.WHITE);
		panel.add(lblProduto);

		JLabel lblDesc = new JLabel("Descrição");
		lblDesc.setBounds(200, 21, 146, 16);
		lblDesc.setForeground(Color.WHITE);
		lblDesc.setFont(new Font("Fira Code", Font.PLAIN, 18));
		panel.add(lblDesc);

		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(405, 21, 129, 16);
		lblQuantidade.setForeground(Color.WHITE);
		lblQuantidade.setFont(new Font("Fira Code", Font.PLAIN, 18));
		panel.add(lblQuantidade);

		JLabel lblPreco = new JLabel("Preço");
		lblPreco.setBounds(591, 21, 129, 16);
		lblPreco.setForeground(Color.WHITE);
		lblPreco.setFont(new Font("Fira Code", Font.PLAIN, 18));
		panel.add(lblPreco);

	}
}
