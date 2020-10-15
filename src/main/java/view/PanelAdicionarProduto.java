package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import controller.ProdutoController;
import controller.UsuarioController;
import model.Produto;
import model.Usuario;
import util.Utils;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class PanelAdicionarProduto extends JPanel {
	private JFormattedTextField txtQuantidade;
	private JTextField txtDesc;
	private JFormattedTextField txtPreco;
	private JTextField txtProdNome;

	/**
	 * Create the panel.
	 * 
	 * @param u
	 */
	public PanelAdicionarProduto() {
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(0, 0, 550, 365);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 206, 214));
		panel.setBounds(0, 0, 551, 53);
		add(panel);
		panel.setLayout(null);

		JLabel lblAdicionarProduto = new JLabel("ADICIONAR PRODUTO");
		lblAdicionarProduto.setForeground(Color.WHITE);
		lblAdicionarProduto.setBounds(161, 19, 308, 15);
		lblAdicionarProduto.setFont(new Font("Fira Code", Font.PLAIN, 20));
		panel.add(lblAdicionarProduto);

		JLabel lblQ = new JLabel("QUAL O PRODUTO?");
		lblQ.setForeground(Color.DARK_GRAY);
		lblQ.setBounds(28, 98, 146, 14);
		lblQ.setFont(new Font("Fira Code", Font.PLAIN, 13));
		add(lblQ);

		JLabel lblQuantidade = new JLabel("QUANTIDADE:");
		lblQuantidade.setForeground(Color.DARK_GRAY);
		lblQuantidade.setBounds(28, 216, 93, 14);
		lblQuantidade.setFont(new Font("Fira Code", Font.PLAIN, 13));
		add(lblQuantidade);

		JLabel lblPreco = new JLabel("PREÇO:");
		lblPreco.setForeground(Color.DARK_GRAY);
		lblPreco.setBounds(329, 98, 55, 14);
		lblPreco.setFont(new Font("Fira Code", Font.PLAIN, 13));
		add(lblPreco);

		JLabel lblNewLabel = new JLabel("DESCRIÇÃO:");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBounds(329, 216, 93, 14);
		lblNewLabel.setFont(new Font("Fira Code", Font.PLAIN, 13));
		add(lblNewLabel);

		JButton btnNewButton = new JButton("ADICIONAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String descricao = txtDesc.getText();
				String nome = txtProdNome.getText();
				NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
				Number precoNumber = null;
				double preco = 0;
				try {
					precoNumber = format.parse(txtPreco.getText());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					Utils.errorMessage("Erro no formato do preço");
					ModalController.getInstance().closeModal();

				}
				preco = precoNumber.doubleValue();

				Number quantidadeNumber = null;
				try {
					quantidadeNumber = format.parse(txtQuantidade.getText());
				} catch (ParseException e1) {
					e1.printStackTrace();
					Utils.errorMessage("Erro no formato da quantidade");
					ModalController.getInstance().closeModal();

				}

				Integer quantidade = quantidadeNumber.intValue();
				Produto u = new Produto();

				if (!(Utils.areEmpty(nome,descricao)||quantidade < 1 || preco == 0)) {
					u.setDescricao(descricao);
					u.setNomeProduto(nome);
					u.setPreco(preco);
					u.setTipo("");
					u.setQtEmEstoque(quantidade);
					ProdutoController.InserirProduto(u);
					ModalController.getInstance().closeModal();
				} else {
					Utils.errorMessage("não é possível adicionar campos vazios");
				}

			}
		});
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBackground(new Color(102, 206, 214));
		btnNewButton.setBounds(403, 305, 109, 39);
		btnNewButton.setFont(new Font("Fira Code", Font.PLAIN, 13));
		add(btnNewButton);

		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(0);
		formatter.setMaximum(Integer.MAX_VALUE);
		formatter.setAllowsInvalid(false);
		formatter.setCommitsOnValidEdit(false);

		txtQuantidade = new JFormattedTextField(formatter);
		txtQuantidade.setBounds(28, 242, 193, 26);
		add(txtQuantidade);
		txtQuantidade.setColumns(10);

		txtDesc = new JTextField();
		txtDesc.setBounds(325, 242, 187, 26);
		add(txtDesc);
		txtDesc.setColumns(10);

		NumberFormat doubleFormat = DecimalFormat.getInstance();

		doubleFormat.setMinimumFractionDigits(2);
		doubleFormat.setMaximumFractionDigits(2);
		txtPreco = new JFormattedTextField(doubleFormat);
		txtPreco.setBounds(325, 124, 187, 26);
		add(txtPreco);
		txtPreco.setColumns(10);

		txtProdNome = new JTextField();
		txtProdNome.setColumns(10);
		txtProdNome.setBounds(28, 124, 193, 26);
		add(txtProdNome);

	}
}
