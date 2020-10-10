package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.UIManager;

import controller.UsuarioController;
import util.ResourceFinder;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmLogin;
	private JTextField loginField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		GraphicsEnvironment grEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		grEnv.registerFont(ResourceFinder.getFiraCodeFont());
		UsuarioController.getInstance().cadastraAdmin();
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			System.err.println(e);
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.getContentPane().setEnabled(false);
		frmLogin.setTitle("Login");
		frmLogin.getContentPane().setBackground(Color.WHITE);
		frmLogin.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		// 66CED6 102, 206, 214
		panel.setBackground(new Color(102, 206, 214));
		panel.setBounds(0, 145, 428, 342);
		frmLogin.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel imgBook = new JLabel(new ImageIcon(ResourceFinder.getScaledBookImage(350)));
		imgBook.setBounds(0, 0, 428, 342);
		panel.add(imgBook);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(243, 243, 243));
		panel_1.setBounds(427, 145, 335, 342);
		frmLogin.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		loginField = new JTextField();
		loginField.setBounds(61, 101, 247, 31);
		panel_1.add(loginField);
		loginField.setColumns(10);

		JButton LogarButton = new JButton("Logar");
		LogarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = loginField.getText();
				char[] password = passwordField.getPassword();
				String pw = String.valueOf(password);
				if (UsuarioController.getInstance().logar(login, pw)) {
					PanelController.getInstance().start();
					frmLogin.setVisible(false);
					frmLogin.dispose();
				} else {
					JOptionPane.showMessageDialog(frmLogin, "Usuário ou senha errados");
				}
			}
		});
		LogarButton.setBackground(new Color(102, 206, 214));
		LogarButton.setBounds(113, 251, 120, 33);
		LogarButton.setFont(new Font("Fira Code", Font.PLAIN, 15));
		panel_1.add(LogarButton);

		passwordField = new JPasswordField();
		passwordField.setBounds(61, 164, 247, 31);

		panel_1.add(passwordField);

		JLabel LoginLabel = new JLabel("Login");
		LoginLabel.setFont(new Font("Fira Code", Font.BOLD, 15));
		LoginLabel.setBounds(60, 81, 55, 16);
		panel_1.add(LoginLabel);

		JLabel SenhaLabel = new JLabel("Senha");
		SenhaLabel.setFont(new Font("Fira Code", Font.BOLD, 15));
		SenhaLabel.setBounds(61, 144, 55, 16);
		panel_1.add(SenhaLabel);

		JLabel LivrariaNome = new JLabel("LIVRARIA PAPIRO");
		LivrariaNome.setFont(new Font("Fira Code", Font.PLAIN, 24));
		LivrariaNome.setBounds(66, 30, 327, 28);
		frmLogin.getContentPane().add(LivrariaNome);

		JLabel lblNewLabel = new JLabel(new ImageIcon(ResourceFinder.getScaledBookImage(32)));
		lblNewLabel.setBounds(21, 26, 44, 32);
		frmLogin.getContentPane().add(lblNewLabel);
		frmLogin.setBackground(Color.WHITE);
		frmLogin.setBounds(100, 100, 768, 633);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
