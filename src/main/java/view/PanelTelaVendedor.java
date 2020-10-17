package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;

import controller.UsuarioController;
import model.Usuario;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelTelaVendedor extends JPanel {

	private JTextField Nome;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PanelTelaVendedor() {
		Usuario user = UsuarioController.getInstance().getLoggedUser();

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
		InformacoesLabel.setForeground(new Color(51, 51, 51));
		InformacoesLabel.setBounds(20, 23, 182, 30);
		PainelInfo.add(InformacoesLabel);

		JPanel PainelInterno = new JPanel();
		PainelInterno.setBackground(new Color(237, 237, 237));
		PainelInterno.setBounds(20, 87, 524, 428);
		PainelInfo.add(PainelInterno);
		PainelInterno.setLayout(null);

		Nome = new JTextField();
		Nome.setEditable(false);
		Nome.setBounds(176, 96, 271, 27);
		PainelInterno.add(Nome);
		Nome.setColumns(10);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(176, 127, 271, 27);
		PainelInterno.add(textField);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Fira Code", Font.PLAIN, 18));
		lblNome.setForeground(new Color(129, 129, 129));
		lblNome.setBounds(103, 99, 55, 16);
		PainelInterno.add(lblNome);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Fira Code", Font.PLAIN, 18));
		lblCpf.setForeground(new Color(129, 129, 129));
		lblCpf.setBounds(103, 130, 55, 16);

		PainelInterno.add(lblCpf);
		JPanel panelButtons = new JPanel();
		panelButtons.setBackground(new Color(102, 206, 214));
		panelButtons.setBounds(0, 0, 208, 580);
		add(panelButtons);
		panelButtons.setLayout(null);

		JLabel TipoUsuario = new JLabel("VENDEDOR");
		TipoUsuario.setFont(new Font("Fira Code", Font.BOLD, 20));
		TipoUsuario.setForeground(Color.DARK_GRAY);
		TipoUsuario.setEnabled(true);
		TipoUsuario.setBounds(50, 25, 146, 26);
		panelButtons.add(TipoUsuario);

		JButton btnConVendas = new JButton("VENDER");
		btnConVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelController.getInstance().trocar(new PanelVendasVendedor());
			}
		});
		btnConVendas.setBackground(Color.WHITE);
		btnConVendas.setFont(new Font("Fira Code", Font.PLAIN, 10));
		btnConVendas.setBounds(38, 96, 142, 52);
		panelButtons.add(btnConVendas);

		JButton btConEstoque = new JButton("CONSULTAR DE VENDAS");
		btConEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelController.getInstance().trocar(new PanelConsultaVendasVendedor());
			}
		});
		btConEstoque.setBackground(Color.WHITE);
		btConEstoque.setFont(new Font("Fira Code", Font.PLAIN, 10));
		btConEstoque.setBounds(38, 181, 142, 52);
		panelButtons.add(btConEstoque);

		JButton btSair = new JButton("SAIR");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelController.getInstance().encerrar();
			}
		});
		btSair.setFont(new Font("Fira Code", Font.PLAIN, 14));
		btSair.setBackground(Color.WHITE);
		btSair.setBounds(34, 425, 146, 52);
		panelButtons.add(btSair);

		Nome.setText(user.getNome());
		textField.setText(user.getCPF());

	}
}
