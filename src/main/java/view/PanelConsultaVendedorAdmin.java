package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import controller.ProdutoController;
import controller.UsuarioController;
import model.Produto;
import model.Tipo;
import model.Usuario;
import util.Utils;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ListSelectionModel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;

public class PanelConsultaVendedorAdmin extends JPanel {
	private JTextField txtNome;
	private JFormattedTextField txtCpf;
	private JTextField txtSenha;
	private JTextField txtLogin;
	private JTable table;
	private DefaultTableModel dfm;

	List<Usuario> vendedores;
	/**
	 * Create the panel.
	 */
	//Reseta a tabela, e coloca os valores do banco de dados nela
	public void limparTabela() {
		
		while (dfm.getRowCount() > 0) {
			dfm.removeRow(dfm.getRowCount() - 1);
		}
	}
	private void resetarTabela() {
		List<Usuario> vendedores = UsuarioController.getInstance().getVendedorList();
		while (dfm.getRowCount() > 0) {
			dfm.removeRow(dfm.getRowCount() - 1);
		}
		for (Usuario vendedor : vendedores) {
			// System.out.println(vendedor);
			dfm.addRow(new Object[] { vendedor });
		}
	}
	public List<Usuario> find(String s){

		List<Usuario> encontrados=new ArrayList<Usuario>();
		for(Usuario user:vendedores) {
			if(user.getNome().toLowerCase().contains(s.toLowerCase())) {
				encontrados.add(user);
			}
		}
		return encontrados;
	}

	public PanelConsultaVendedorAdmin() {

		setBackground(Color.WHITE);
		this.setBounds(0, 0, 768, 580);
		setLayout(null);

		JLabel lblEstoque = new JLabel("VENDEDORES");
		lblEstoque.setBounds(332, 12, 200, 28);
		lblEstoque.setFont(new Font("Fira Code", Font.PLAIN, 25));
		lblEstoque.setForeground(new Color(129, 129, 129));
		add(lblEstoque);

		JLabel lblFiltrarPor = new JLabel("Filtrar por:");
		lblFiltrarPor.setBounds(428, 180, 99, 14);
		lblFiltrarPor.setForeground(new Color(134, 134, 134));
		lblFiltrarPor.setFont(new Font("Fira Code", Font.PLAIN, 13));
		add(lblFiltrarPor);

		JTextField txtFiltro = new JTextField();		
		txtFiltro.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				txtFiltro.setText("");
				resetarTabela();
			}
			@Override
			public void focusGained(FocusEvent e) {
				vendedores = UsuarioController.getVendedorList();
			}
		});
		txtFiltro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				limparTabela();
				List<Usuario> vendedores = find(txtFiltro.getText());
				for (Usuario p : vendedores) {
					dfm.addRow(new Object[]  { p });
				}
			}
		});
		txtFiltro.setToolTipText("");
		txtFiltro.setForeground(new Color(30, 144, 255));
		txtFiltro.setBackground(Color.WHITE);
		txtFiltro.setBounds(428, 200, 206, 38);
		add(txtFiltro);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelController.getInstance().retornar();
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(new Color(0, 191, 255));
		btnVoltar.setBounds(73, 510, 104, 28);
		add(btnVoltar);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 191, 255));
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 191, 255), 30, true));
		panel.setBounds(20, 124, 347, 56);
		add(panel);
		panel.setLayout(null);

		JLabel lblVendedores = new JLabel("VENDEDORES");
		lblVendedores.setBounds(109, 15, 156, 28);
		panel.add(lblVendedores);
		lblVendedores.setFont(new Font("Fira Code", Font.PLAIN, 20));
		lblVendedores.setForeground(Color.WHITE);

		JLabel lblAdicionarVendedor = new JLabel("Adicionar vendedor:");
		lblAdicionarVendedor.setForeground(new Color(134, 134, 134));
		lblAdicionarVendedor.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblAdicionarVendedor.setBounds(428, 277, 173, 14);
		add(lblAdicionarVendedor);

		txtNome = new JTextField();
		txtNome.setText("Nome");
		txtNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtNome.getText().equals("Nome")) {
					txtNome.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtNome.getText().isEmpty()) {
					txtNome.setText("Nome");
				}
			}
		});
		txtNome.setToolTipText("Nome\r\n");
		txtNome.setForeground(Color.DARK_GRAY);
		txtNome.setBounds(428, 303, 206, 38);

		txtNome.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(txtNome);
		txtNome.setColumns(10);

		MaskFormatter CPFMask = null;
		try {
			CPFMask = new MaskFormatter("###.###.###-##");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		txtCpf = new JFormattedTextField();
		txtCpf.setToolTipText("CPF");
		txtCpf.setFormatterFactory(new DefaultFormatterFactory(CPFMask));
		txtCpf.setForeground(Color.DARK_GRAY);
		txtCpf.setColumns(10);
		txtCpf.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtCpf.setBounds(428, 342, 206, 38);
		add(txtCpf);

		txtSenha = new JTextField();
		txtSenha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtSenha.getText().equals("Senha")) {
					txtSenha.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtSenha.getText().isEmpty()) {
					txtSenha.setText("Senha");
				}
			}

		});
		txtSenha.setToolTipText("Senha");
		txtSenha.setText("Senha");
		txtSenha.setForeground(Color.DARK_GRAY);
		txtSenha.setColumns(10);
		txtSenha.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtSenha.setBounds(428, 416, 206, 38);
		add(txtSenha);

		table = new JTable();
		table.setBackground(Color.WHITE);

		table.setShowGrid(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(
				new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Vendedor"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(345);
		table.getColumnModel().getColumn(0).setMinWidth(345);

		dfm = (DefaultTableModel) table.getModel();
		resetarTabela();
//		for (int i = 0; i < 100; i++)
//			dfm.addRow(new Object[] { "teste" + i, "teste" });

		table.setFont(new Font("Fira Code", Font.PLAIN, 13));
		table.setTableHeader(null);

		JScrollPane panel_1 = new JScrollPane(table);
		panel_1.setBorder(new LineBorder(new Color(128, 128, 128)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(20, 180, 347, 314);
		add(panel_1);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() > -1) {
					Usuario u = (Usuario) table.getModel().getValueAt(table.getSelectedRow(), 0);
					ModalController.getInstance().createModal(new PanelAtualizarVendedor(u));
				} else {
					Utils.errorMessage("Selecione uma linha");
				}
			}
		});
		btnAtualizar.setForeground(Color.WHITE);
		btnAtualizar.setBackground(new Color(0, 191, 255));
		btnAtualizar.setBounds(208, 510, 104, 28);
		add(btnAtualizar);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				String login = txtLogin.getText();
				String cpf = txtCpf.getText();
				String senha = txtSenha.getText();
				if (!(nome.contentEquals("Nome") || login.contentEquals("Login") || senha.contentEquals("Senha"))) {
					txtNome.setText("Nome");
					txtLogin.setText("Login");
					txtCpf.setText("");
					txtSenha.setText("Senha");
					if (!(nome.isEmpty() || cpf.isEmpty() || senha.isEmpty() || cpf.length() < 11)) {
						Usuario u = new Usuario();
						u.setNome(nome);
						u.setLogin(login);
						u.setCPF(cpf);
						u.setSenha(senha);
						u.setTipo(Tipo.VENDEDOR);
						UsuarioController.getInstance().cadastrarUsuario(u);

					} else {
						Utils.errorMessage("não é possível adicionar campos vazios");
					}
				} else {
					Utils.errorMessage("não é possível cadastrar com os campos com valores padrão");
				}
			}
		});
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(new Color(0, 191, 255));
		btnCadastrar.setBounds(482, 466, 104, 28);
		add(btnCadastrar);

		txtLogin = new JTextField();
		txtLogin.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtLogin.getText().equals("Login")) {
					txtLogin.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtLogin.getText().isEmpty()) {
					txtLogin.setText("Login");
				}
			}
		});
		txtLogin.setText("Login");
		txtLogin.setToolTipText("Login");
		txtLogin.setForeground(Color.DARK_GRAY);
		txtLogin.setColumns(10);
		txtLogin.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtLogin.setBounds(428, 378, 206, 38);
		add(txtLogin);
	}


}
