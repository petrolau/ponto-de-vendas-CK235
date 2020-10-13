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

import model.Produto;
import model.Usuario;
import util.Utils;
import controller.ProdutoController;
import controller.UsuarioController;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PanelConsultaEstoqueAdmin extends JPanel {
	private JTable table;
	private DefaultTableModel dfm;
	List<Produto> produtos;
	/**
	 * Create the panel.
	 */
	public void limparTabela() {
		
		while (dfm.getRowCount() > 0) {
			dfm.removeRow(dfm.getRowCount() - 1);
		}
	}
	public void resetarTabela() {
		limparTabela();
		produtos = ProdutoController.getProdutoList();
		for (Produto p : produtos) {
			dfm.addRow(new Object[] { p, p.getQtEmEstoque(), "R$ " + p.getPreco() });
		}
	}
	public List<Produto> find(String s){

		List<Produto> encontrados=new ArrayList<Produto>();
		for(Produto prod:produtos) {
			if(prod.getNomeProduto().toLowerCase().contains(s.toLowerCase())) {
				encontrados.add(prod);
			}
		}
		return encontrados;
	}
	

	public PanelConsultaEstoqueAdmin() {
		setBackground(Color.WHITE);
		this.setBounds(0, 0, 768, 580);
		setLayout(null);

		JLabel lblEstoque = new JLabel("ESTOQUE");
		lblEstoque.setBounds(332, 12, 130, 20);
		lblEstoque.setFont(new Font("Fira Code", Font.PLAIN, 25));
		lblEstoque.setForeground(new Color(129, 129, 129));
		add(lblEstoque);

		JLabel lblFiltrarPor = new JLabel("Filtrar por:");
		lblFiltrarPor.setBounds(10, 47, 99, 14);
		lblFiltrarPor.setForeground(new Color(134, 134, 134));
		lblFiltrarPor.setFont(new Font("Fira Code", Font.PLAIN, 13));
		add(lblFiltrarPor);

		JTextField TextFieldFiltro = new JTextField();
		TextFieldFiltro.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				TextFieldFiltro.setText("");
				resetarTabela();
			}
			@Override
			public void focusGained(FocusEvent e) {
				produtos=ProdutoController.getProdutoList();
			}
		});
		TextFieldFiltro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				limparTabela();
				List<Produto> produtos = find(TextFieldFiltro.getText());
				for (Produto p : produtos) {
					dfm.addRow(new Object[] { p, p.getQtEmEstoque(), "R$ " + p.getPreco() });
				}
			}
		});
		TextFieldFiltro.setBackground(Color.WHITE);
		TextFieldFiltro.setBounds(10, 67, 206, 38);
		add(TextFieldFiltro);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelController.getInstance().retornar();
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(new Color(102, 206, 214));
		btnVoltar.setBounds(64, 520, 90, 28);
		add(btnVoltar);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 206, 214));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		panel.setBounds(10, 111, 740, 56);
		add(panel);
		panel.setLayout(null);

		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setBounds(41, 21, 102, 16);
		lblProduto.setFont(new Font("Fira Code", Font.PLAIN, 18));
		lblProduto.setForeground(Color.WHITE);
		panel.add(lblProduto);

		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(301, 21, 129, 16);
		lblQuantidade.setForeground(Color.WHITE);
		lblQuantidade.setFont(new Font("Fira Code", Font.PLAIN, 18));
		panel.add(lblQuantidade);

		JLabel lblPreco = new JLabel("Preço");
		lblPreco.setBounds(584, 21, 129, 16);
		lblPreco.setForeground(Color.WHITE);
		lblPreco.setFont(new Font("Fira Code", Font.PLAIN, 18));
		panel.add(lblPreco);

		table = new JTable();
		table.setBorder(new LineBorder(Color.LIGHT_GRAY));
		table.setModel(new DefaultTableModel(new Object[][] { { "livro", "30", "52" }, },
				new String[] { "New column", "New column", "New column" }) {
			boolean[] columnEditables = new boolean[] { true, true, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(247);
		table.getColumnModel().getColumn(0).setMinWidth(247);
		table.getColumnModel().getColumn(1).setMinWidth(247);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setMinWidth(245);
		table.setTableHeader(null);
		dfm=(DefaultTableModel)table.getModel();
		resetarTabela();
		table.setBounds(10, 180, 740, 328);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModalController.getInstance().createModal(new PanelAdicionarProduto());

			}
		});

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 180, 740, 328);
		add(scrollPane);
		btnAdicionar.setForeground(Color.WHITE);
		btnAdicionar.setBackground(new Color(102, 206, 214));
		btnAdicionar.setBounds(330, 520, 130, 28);
		add(btnAdicionar);

		JButton btnDeletar = new JButton("Atualizar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() > -1) {
					Produto p = (Produto) table.getModel().getValueAt(table.getSelectedRow(), 0);
					ModalController.getInstance().createModal(new PanelAtualizarProduto(p));
				} else {
					Utils.errorMessage("Selecione uma linha");
				}
				
			}
		});
		btnDeletar.setForeground(Color.WHITE);
		btnDeletar.setBackground(new Color(102, 206, 214));
		btnDeletar.setBounds(609, 520, 110, 28);
		add(btnDeletar);

	}
}
