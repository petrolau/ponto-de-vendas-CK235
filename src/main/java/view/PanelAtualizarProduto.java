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
import model.Produto;
import util.Utils;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class PanelAtualizarProduto extends JPanel {
	private JFormattedTextField quantProd;
	private JFormattedTextField preco;
	private JTextField descricao;

	/**
	 * Create the panel.
	 */
	/**
	 * @param p
	 */
	public PanelAtualizarProduto(Produto p) {
		setBackground(Color.WHITE);
		setBounds(0, 0, 551, 365);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 206, 214));
		panel.setBounds(0, 0, 551, 53);
		add(panel);
		panel.setLayout(null);

		JLabel lblAdicionarProduto = new JLabel("ATUALIZAR PRODUTO");
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
		lblQuantidade.setBounds(27, 205, 93, 14);
		lblQuantidade.setFont(new Font("Fira Code", Font.PLAIN, 13));
		add(lblQuantidade);

		JLabel lblPreco = new JLabel("PREÇO:");
		lblPreco.setForeground(Color.DARK_GRAY);
		lblPreco.setBounds(329, 98, 55, 14);
		lblPreco.setFont(new Font("Fira Code", Font.PLAIN, 13));
		add(lblPreco);

		JButton btnNewButton = new JButton("ATUALIZAR");

		JLabel lblDescrio = new JLabel("DESCRIÇÃO:");
		lblDescrio.setForeground(Color.DARK_GRAY);
		lblDescrio.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblDescrio.setBounds(329, 205, 93, 14);
		add(lblDescrio);
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBackground(new Color(102, 206, 214));
		btnNewButton.setBounds(403, 305, 109, 39);
		btnNewButton.setFont(new Font("Fira Code", Font.PLAIN, 13));
		add(btnNewButton);

		JTextField produtoNome = new JTextField();
		produtoNome.setBounds(24, 124, 197, 26);
		produtoNome.setText(p.getNomeProduto());
		add(produtoNome);

		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(0);
		formatter.setMaximum(Integer.MAX_VALUE);
		formatter.setAllowsInvalid(false);
		formatter.setCommitsOnValidEdit(true);

		descricao = new JTextField();
		descricao.setBounds(329, 236, 183, 26);
		descricao.setText(p.getDescricao());
		add(descricao);
		descricao.setColumns(10);
		quantProd = new JFormattedTextField(formatter);
		quantProd.setText(p.getQtEmEstoque().toString());
		quantProd.setBounds(28, 236, 193, 26);
		add(quantProd);
		quantProd.setColumns(10);

		NumberFormat doubleFormat = DecimalFormat.getInstance();

		doubleFormat.setMinimumFractionDigits(2);
		doubleFormat.setMaximumFractionDigits(2);
		preco = new JFormattedTextField(doubleFormat);
		preco.setText(p.getPreco().toString());
		preco.setBounds(325, 124, 187, 26);
		add(preco);
		preco.setColumns(10);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pnome = produtoNome.getText();
				String desc = descricao.getText();
				String quantidade = quantProd.getText();
				String precoS = preco.getText();
				if (!(Utils.areEmpty(pnome, desc, quantidade, precoS))) {
					p.setDescricao(desc);
					p.setNomeProduto(pnome);
					NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
					Number precoNumber = null;
					try {
						precoNumber = format.parse(precoS);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						Utils.errorMessage("Erro no formato do preço");
						ModalController.getInstance().closeModal();

					}
					p.setPreco(precoNumber.doubleValue());
					Number qtNumber = null;
					try {
						qtNumber = format.parse(quantidade);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						Utils.errorMessage("Erro no formato da quantidade");
						ModalController.getInstance().closeModal();

					}
					p.setQtEmEstoque(qtNumber.intValue());
					ProdutoController.atualizarProduto(p);
					ModalController.getInstance().closeModal();
				} else {
					Utils.errorMessage("não é possível adicionar campos vazios");
				}

			}
		});

	}
}