package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FormCadastroView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormCadastroView frame = new FormCadastroView();
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
	public FormCadastroView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(FormCadastroView.class.getResource("/view/images/alienBackground.png")));
		lblNewLabel_7.setBounds(320, 379, 78, 83);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel = new JLabel("id");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(134, 174, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(134, 230, 65, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(134, 297, 65, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(134, 199, 226, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(134, 255, 226, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(134, 322, 226, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("CADASTRAR");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(128, 0, 128));
		btnNewButton.setBounds(196, 366, 106, 44);
		contentPane.add(btnNewButton);
		
		lblNewLabel_6 = new JLabel("CADASTRO");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Yu Gothic Light", Font.PLAIN, 40));
		lblNewLabel_6.setBounds(134, 115, 249, 73);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(FormCadastroView.class.getResource("/view/images/backgroundroxo3.png")));
		lblNewLabel_5.setBounds(91, 89, 307, 373);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(FormCadastroView.class.getResource("/view/images/backgroundroxo2.png")));
		lblNewLabel_4.setBounds(76, 74, 337, 403);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(FormCadastroView.class.getResource("/view/images/background roxo.png")));
		lblNewLabel_3.setBounds(0, 0, 484, 561);
		contentPane.add(lblNewLabel_3);
	}
}
