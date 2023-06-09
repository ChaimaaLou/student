package View;

import javax.swing.*;

import Controller.authController;
import DAO.AuthDAO;
import Entity.User;
import service.authservice;

import java.awt.*;
import java.awt.event.*;

public class view01 extends JFrame {
	

	private JTextField usernameTextField;
	private JPasswordField passwordPasswordField;
	private JButton loginButton;

	private authController authController;

	public view01() {
		// set up UI components
		JLabel usernameLabel = new JLabel("Username:");
		JLabel passwordLabel = new JLabel("Password:");
		usernameTextField = new JTextField(20);
		passwordPasswordField = new JPasswordField(20);
		loginButton = new JButton("Login");
		
		// add components to frame
		JPanel panel = new JPanel(new GridLayout(0, 1));
		panel.add(usernameLabel);
		panel.add(usernameTextField);
		panel.add(passwordLabel);
		panel.add(passwordPasswordField);
		panel.add(loginButton);
		add(panel);
		
		// set up controller
		AuthDAO authdao = new AuthDAO();
		authservice authService = new authservice(authdao);
		authController = new authController(authService);
		
		// add action listener to login button
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				String username = usernameTextField.getText();
				String password = new String(passwordPasswordField.getPassword());
				
				
				try {
					if (authController.authenticate(username, password)) {
						
						//JOptionPane.showMessageDialog(view01.this, "Login successful!");
						new appView();

					} else {
						JOptionPane.showMessageDialog(view01.this, "Login failed.");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		// set up frame properties
		setTitle("Authentication");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		view01 view = new view01();
		view.setVisible(true);
	}
}
