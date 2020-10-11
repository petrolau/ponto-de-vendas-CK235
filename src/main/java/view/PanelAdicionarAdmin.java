package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import controller.UsuarioController;
import model.Tipo;
import model.Usuario;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;

public class PanelAdicionarAdmin extends JPanel {
	private JFormattedTextField txtCpf;
	private JPasswordField txtSenha;
	private JTextField txtLogin;
	private JTextField txtNome;

	/**
	 * Create the panel.
	 */
	public PanelAdicionarAdmin() {
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(0,0,551,365);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 206, 214));
		panel.setBounds(0, 0, 551, 53);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblAdicionarProduto = new JLabel("ADICIONAR ADMINISTRADOR");
		lblAdicionarProduto.setForeground(Color.WHITE);
		lblAdicionarProduto.setBounds(161, 19, 308, 15);
		lblAdicionarProduto.setFont(new Font("Fira Code", Font.PLAIN, 20));
		panel.add(lblAdicionarProduto);
		
		JLabel lblQ = new JLabel("Nome");
		lblQ.setForeground(Color.DARK_GRAY);
		lblQ.setBounds(28, 98, 146, 14);
		lblQ.setFont(new Font("Fira Code", Font.PLAIN, 13));
		add(lblQ);
		
		JLabel lblQuantidade = new JLabel("CPF");
		lblQuantidade.setForeground(Color.DARK_GRAY);
		lblQuantidade.setBounds(28, 216, 93, 14);
		lblQuantidade.setFont(new Font("Fira Code", Font.PLAIN, 13));
		add(lblQuantidade);
		
		JLabel lblPreco = new JLabel("Login");
		lblPreco.setForeground(Color.DARK_GRAY);
		lblPreco.setBounds(329, 98, 55, 14);
		lblPreco.setFont(new Font("Fira Code", Font.PLAIN, 13));
		add(lblPreco);
		
		JLabel lblNewLabel = new JLabel("Senha");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBounds(329, 216, 93, 14);
		lblNewLabel.setFont(new Font("Fira Code", Font.PLAIN, 13));
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ADICIONAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cpf=txtCpf.getText();
				String nome=txtNome.getText();
				String Senha=String.copyValueOf(txtSenha.getPassword());
				String login=txtLogin.getText();
				if(!(login.isEmpty()||nome.isEmpty()||Senha.isEmpty()||cpf.length()<11)) {
					Usuario u= new Usuario();
					u.setCPF(cpf);
					u.setNome(nome);
					u.setSenha(Senha);
					u.setLogin(login);
					u.setTipo(Tipo.ADMINISTRADOR);
					UsuarioController.getInstance().cadastrarUsuario(u);
					txtCpf.setText("");
					txtNome.setText("");
					txtSenha.setText("");
					txtLogin.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "não é possível adicionar campos vazios","erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBackground(new Color(102, 206, 214));
		btnNewButton.setBounds(403, 305, 109, 39);
		btnNewButton.setFont(new Font("Fira Code", Font.PLAIN, 13));
		add(btnNewButton);
		
		MaskFormatter CPFMask = null;
		try {
			CPFMask = new MaskFormatter("###.###.###-##");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtCpf = new JFormattedTextField();
		txtCpf.setBounds(28, 242, 193, 26);
		txtCpf.setFormatterFactory(new DefaultFormatterFactory(CPFMask));
		add(txtCpf);
		txtCpf.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(325, 242, 187, 26);
		add(txtSenha);
		txtSenha.setColumns(10);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(325, 124, 187, 26);
		add(txtLogin);
		txtLogin.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(28, 124, 193, 26);
		add(txtNome);
		

	}
}
