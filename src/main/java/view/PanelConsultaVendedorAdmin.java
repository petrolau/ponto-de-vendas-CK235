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
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

public class PanelConsultaVendedorAdmin extends JPanel {
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtSenha;

	/**
	 * Create the panel.
	 */
	public PanelConsultaVendedorAdmin() {
		setBackground(Color.WHITE);
		this.setBounds(0, 0, 768, 580);
		setLayout(null);
		
		JLabel lblEstoque = new JLabel("VENDEDORES");
		lblEstoque.setBounds(332, 12, 200, 28);
		lblEstoque.setFont(new Font("Fira Code", Font.PLAIN, 25));
		lblEstoque.setForeground(new Color(129,129,129));
		add(lblEstoque);
		
		JLabel lblFiltrarPor = new JLabel("Filtrar por:");
		lblFiltrarPor.setBounds(428, 199, 99, 14);
		lblFiltrarPor.setForeground(new Color(134, 134, 134));
		lblFiltrarPor.setFont(new Font("Fira Code",Font.PLAIN,13));
		add(lblFiltrarPor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setForeground(new Color(30, 144, 255));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(428, 219, 206, 38);
		add(comboBox);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(new Color(0, 191, 255));
		btnVoltar.setBounds(73, 510, 104, 28);
		add(btnVoltar);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 191, 255));
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 191, 255), 30, true));
		panel.setBounds(10, 124, 364, 56);
		add(panel);
		panel.setLayout(null);
		

		JLabel lblVendedores = new JLabel("VENDEDORES");
		lblVendedores.setBounds(109, 15, 156, 28);
		panel.add(lblVendedores);
		lblVendedores.setFont(new Font("Fira Code",Font.PLAIN,20));
		lblVendedores.setForeground(Color.WHITE);
		
		JLabel lblAdicionarVendedor = new JLabel("Adicionar vendedor:");
		lblAdicionarVendedor.setForeground(new Color(134, 134, 134));
		lblAdicionarVendedor.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblAdicionarVendedor.setBounds(428, 291, 173, 14);
		add(lblAdicionarVendedor);
		
		txtNome = new JTextField();
		txtNome.setForeground(Color.DARK_GRAY);
		txtNome.setText("nome");
		txtNome.setBounds(428, 318, 206, 38);
	
		txtNome.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setText("CPF");
		txtCpf.setForeground(Color.DARK_GRAY);
		txtCpf.setColumns(10);
		txtCpf.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtCpf.setBounds(428, 369, 206, 38);
		add(txtCpf);
		
		txtSenha = new JTextField();
		txtSenha.setText("Senha");
		txtSenha.setForeground(Color.DARK_GRAY);
		txtSenha.setColumns(10);
		txtSenha.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtSenha.setBounds(428, 419, 206, 38);
		add(txtSenha);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(128, 128, 128)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(20, 180, 347, 314);
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"CINTHIA, LAURA, Dani"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setToolTipText("CINTHIA");
		list.setEnabled(false);
		list.setBounds(29, 55, 335, 209);
		panel_1.add(list);
		
		add(panel_1);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setForeground(Color.WHITE);
		btnAtualizar.setBackground(new Color(0, 191, 255));
		btnAtualizar.setBounds(208, 510, 104, 28);
		add(btnAtualizar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(new Color(0, 191, 255));
		btnCadastrar.setBounds(482, 466, 104, 28);
		add(btnCadastrar);
	}
	private Color Color(int i, int j, int k) {
		// TODO Auto-generated method stub
		return null;
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
