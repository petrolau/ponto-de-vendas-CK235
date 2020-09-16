package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;

public class Login {

	private JFrame frmLogin;
	private JTextField loginField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		frmLogin.getContentPane().setEnabled(false);
		frmLogin.setTitle("Login");
		frmLogin.setResizable(false);
		frmLogin.getContentPane().setBackground(Color.WHITE);
		frmLogin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		//66CED6 102, 206, 214
		panel.setBackground(new Color(102, 206, 214));
		panel.setBounds(0, 145, 428, 342);
		frmLogin.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(243,243,243));
		panel_1.setBounds(427, 145, 335, 342);
		frmLogin.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		loginField = new JTextField();
		loginField.setBounds(61, 101, 247, 31);
		panel_1.add(loginField);
		loginField.setColumns(10);
		
		JButton LogarButton = new JButton("Logar");
		LogarButton.setBackground(new Color(102, 206, 214));
		LogarButton.setBounds(113, 251, 120, 33);
		panel_1.add(LogarButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(61, 164, 247, 31);
		
		panel_1.add(passwordField);
		
		JLabel LoginLabel = new JLabel("Login");
		LoginLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		LoginLabel.setBounds(60, 81, 55, 16);
		panel_1.add(LoginLabel);
		
		JLabel SenhaLabel = new JLabel("Senha");
		SenhaLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		SenhaLabel.setBounds(61, 144, 55, 16);
		panel_1.add(SenhaLabel);
		
		JLabel LivrariaNome = new JLabel("Livraria Papiro");
		LivrariaNome.setFont(new Font("Dialog", Font.BOLD, 24));
		LivrariaNome.setBounds(77, 50, 181, 28);
		frmLogin.getContentPane().add(LivrariaNome);
		frmLogin.setBackground(Color.WHITE);
		frmLogin.setBounds(100, 100, 768, 633);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
