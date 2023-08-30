package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bentolastudios.main.Game;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(LoginView.class.getResource("/view/images/alienBackground.png")));
		lblNewLabel_2.setBounds(320, 379, 78, 83);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.WHITE);
		passwordField.setBackground(new Color(128, 0, 128));
		passwordField.setBounds(137, 296, 214, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton_1 = new JButton("Cadastro");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(128, 0, 128));
		btnNewButton_1.setBounds(198, 387, 95, 20);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game telaDoJogo = new Game();
				telaDoJogo.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(128, 0, 128));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(188, 339, 116, 37);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Yu Gothic Light", Font.PLAIN, 40));
		lblNewLabel.setBounds(188, 109, 132, 73);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setBackground(new Color(128, 0, 128));
		textField.setColumns(10);
		textField.setBounds(137, 215, 214, 20);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(137, 190, 62, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Senha");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(137, 271, 62, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(LoginView.class.getResource("/view/images/backgroundroxo3.png")));
		lblNewLabel_6.setBounds(91, 89, 307, 373);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(LoginView.class.getResource("/view/images/backgroundroxo2.png")));
		lblNewLabel_5.setBounds(76, 74, 337, 403);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(LoginView.class.getResource("/view/images/background roxo.png")));
		lblNewLabel_4.setBounds(0, 0, 484, 561);
		contentPane.add(lblNewLabel_4);
	}
}
