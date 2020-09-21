package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelTelaAdmin extends JPanel {
	private JTextField Nome;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PanelTelaAdmin() {
		setBackground(new Color(0, 0, 0));
		setLayout(null);
		this.setBounds(0, 0, 768, 580);
		
		JPanel PainelInfo = new JPanel();
		PainelInfo.setBackground(new Color(255, 255, 255));
		PainelInfo.setBounds(206, 0, 562, 580);
		add(PainelInfo);
		PainelInfo.setLayout(null);
		
		JLabel InformacoesLabel = new JLabel("Informa\u00E7\u00F5es");
		InformacoesLabel.setFont(new Font("Fira Code", Font.PLAIN, 24));
		InformacoesLabel.setForeground(new Color(51,51,51));
		InformacoesLabel.setBounds(10, 23, 292, 29);
		PainelInfo.add(InformacoesLabel);
		
		JPanel PainelInterno = new JPanel();
		PainelInterno.setBackground(new Color(237,237,237));
		PainelInterno.setBounds(10, 63, 524, 428);
		PainelInfo.add(PainelInterno);
		PainelInterno.setLayout(null);
		
		Nome = new JTextField();
		Nome.setBounds(200, 106, 271, 27);
		PainelInterno.add(Nome);
		Nome.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(200, 140, 271, 27);
		PainelInterno.add(textField);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Fira Code", Font.PLAIN, 18));
		lblNome.setForeground(new Color(129,129,129));
		lblNome.setBounds(107, 112, 81, 16);
		PainelInterno.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Fira Code", Font.PLAIN, 18));
		lblCpf.setForeground(new Color(129,129,129));
		lblCpf.setBounds(133, 146, 55, 16);
		
		PainelInterno.add(lblCpf);
		JPanel panelButtons = new JPanel();
		panelButtons.setBackground(new Color(102, 206, 214));
		panelButtons.setBounds(0, 0, 208, 580);
		add(panelButtons);
		panelButtons.setLayout(null);
		
		JLabel TipoUsuario = new JLabel("Administrador");
		TipoUsuario.setFont(new Font("Fira Code", Font.BOLD, 20));
		TipoUsuario.setForeground(new Color(255,255,255));
		TipoUsuario.setEnabled(true);
		TipoUsuario.setBounds(12, 22, 196, 26);
		panelButtons.add(TipoUsuario);
		
		JButton btnConVendas = new JButton("CONSULTAR VENDAS");
		btnConVendas.setBackground(Color.WHITE);
		btnConVendas.setFont(new Font("Fira Code", Font.PLAIN, 10));
		btnConVendas.setBounds(34, 60, 142, 52);
		panelButtons.add(btnConVendas);
		
		JButton btConEstoque = new JButton("CONSULTAR ESTOQUE");
		btConEstoque.setBackground(Color.WHITE);
		btConEstoque.setFont(new Font("Fira Code", Font.PLAIN, 10));
		btConEstoque.setBounds(34, 124, 146, 52);
		panelButtons.add(btConEstoque);
		
		JButton btConVendedor = new JButton("CONSULTAR VENDEDORES");
		btConVendedor.setBackground(Color.WHITE);
		btConVendedor.setFont(new Font("Fira Code", Font.PLAIN, 8));
		btConVendedor.setBounds(34, 185, 146, 52);
		panelButtons.add(btConVendedor);
		
		JButton btSair = new JButton("SAIR");
		btSair.setFont(new Font("Fira Code", Font.PLAIN, 14));
		btSair.setBackground(Color.WHITE);
		btSair.setBounds(34, 425, 146, 52);
		panelButtons.add(btSair);

	}
}
