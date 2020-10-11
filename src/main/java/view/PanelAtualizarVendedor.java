package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import controller.UsuarioController;
import model.Tipo;
import model.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class PanelAtualizarVendedor extends JPanel {
	private JTextField txtLogin;
	private JPasswordField txtPassword;
	private JTextField txtCpf;
	private JTextField txtNome;

	/**
	 * Create the panel.
	 */

	public PanelAtualizarVendedor(final Usuario u) {

		setBackground(Color.WHITE);
		setBounds(0, 0, 551, 365);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 206, 214));
		panel.setBounds(0, 0, 551, 53);
		add(panel);
		panel.setLayout(null);

		JLabel lblAdicionarProduto = new JLabel("ATUALIZAR VENDEDOR");
		lblAdicionarProduto.setForeground(Color.WHITE);
		lblAdicionarProduto.setBounds(161, 19, 308, 15);
		lblAdicionarProduto.setFont(new Font("Fira Code", Font.PLAIN, 20));
		panel.add(lblAdicionarProduto);

		JLabel lblQ = new JLabel("NOME:");
		lblQ.setForeground(Color.DARK_GRAY);
		lblQ.setBounds(28, 98, 146, 14);
		lblQ.setFont(new Font("Fira Code", Font.PLAIN, 13));
		add(lblQ);

		JLabel lblQuantidade = new JLabel("LOGIN:");
		lblQuantidade.setForeground(Color.DARK_GRAY);
		lblQuantidade.setBounds(28, 216, 93, 14);
		lblQuantidade.setFont(new Font("Fira Code", Font.PLAIN, 13));
		add(lblQuantidade);

		JLabel lblPreco = new JLabel("CPF:");
		lblPreco.setForeground(Color.DARK_GRAY);
		lblPreco.setBounds(329, 98, 55, 14);
		lblPreco.setFont(new Font("Fira Code", Font.PLAIN, 13));
		add(lblPreco);

		JLabel lblNewLabel = new JLabel("SENHA:");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBounds(329, 216, 155, 14);
		lblNewLabel.setFont(new Font("Fira Code", Font.PLAIN, 13));
		add(lblNewLabel);

		JButton btnNewButton = new JButton("ATUALIZAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String login = txtLogin.getText();
				String pw = String.copyValueOf(txtPassword.getPassword());
				String cpf=txtCpf.getText();
				String nome = txtNome.getText();
				if (!(util.Utils.areEmpty(cpf, nome, pw) || cpf.length() < 11)) {
					u.setCPF(cpf);
					u.setNome(nome);
					u.setSenha(pw);
					u.setLogin(login);
					UsuarioController.getInstance().atualizarUsuario(u);
					ModalController.getInstance().closeModal();
				} else {
					JOptionPane.showMessageDialog(null, "não é possível adicionar campos vazios", "erro",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBackground(new Color(102, 206, 214));
		btnNewButton.setBounds(403, 305, 109, 39);
		btnNewButton.setFont(new Font("Fira Code", Font.PLAIN, 13));
		add(btnNewButton);

		txtLogin = new JTextField();
		txtLogin.setBounds(28, 242, 193, 26);
		txtLogin.setText(u.getLogin());
		add(txtLogin);
		txtLogin.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(325, 242, 187, 26);
		add(txtPassword);
		txtPassword.setColumns(10);

		txtCpf = new JTextField();
		txtCpf.setBounds(325, 124, 187, 26);
		txtCpf.setText(u.getCPF());
		add(txtCpf);
		txtCpf.setColumns(10);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(28, 124, 187, 26);
		txtNome.setText(u.getNome());
		add(txtNome);

	}
}