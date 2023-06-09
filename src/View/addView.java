package View;

import javax.swing.*;

import Controller.addController;
import Controller.authController;
import DAO.AuthDAO;
import DAO.addDAO;
import service.addService;
import service.authservice;

import java.awt.*;
import java.awt.event.*;


public class addView  extends JFrame {

	private JTextField CNETextField;
	private JTextField NameTextField;
	private JTextField PrenomTextField;
	private JTextField NoteTextField;
	private JTextField TelTextField;
	
    private JButton AddStudentButton;

    private addController addController;
    
    public addView() {
    	setResizable(false);
        // set up UI components
    	JLabel cneLabel = new JLabel("CNE:");
        JLabel nameLabel = new JLabel("Nom:");
        JLabel lnameLabel = new JLabel("Prenom:");
        JLabel noteLabel = new JLabel("Note:");
        JLabel telLabel = new JLabel("Telephone:");
        
        CNETextField = new JTextField(10);
        NameTextField = new JTextField(20);
        PrenomTextField = new JTextField(20);
        NoteTextField = new JTextField(10);
        TelTextField = new JTextField(10);
        
        AddStudentButton = new JButton("Add Student");
        AddStudentButton.setBackground(UIManager.getColor("Menu.acceleratorForeground"));
        
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(cneLabel);
        panel.add(CNETextField);
        panel.add(nameLabel);
        panel.add(NameTextField);
        panel.add(lnameLabel);
        panel.add(PrenomTextField);
        panel.add(noteLabel);
        panel.add(NoteTextField);
        panel.add(telLabel);
        panel.add(TelTextField);
        
        
        panel.add(AddStudentButton);
        getContentPane().add(panel);
        
     // set up controller
        addDAO adddao = new addDAO();
        addService addservice = new addService(adddao);
        addController = new addController(addservice);
        
        // add action listener to login button
        AddStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
            	String cne = CNETextField.getText();
                String name = NameTextField.getText();
                String lname = PrenomTextField.getText();
                String note = NoteTextField.getText();
                String tel = TelTextField.getText();
                
                try {
					if (addController.addStudent(cne, name, lname, Float.parseFloat(note), Integer.parseInt(tel))) {
						
					    JOptionPane.showMessageDialog(addView.this, "Add action was successful!");
					} else {
					    JOptionPane.showMessageDialog(addView.this, "Add action failed.");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        
        // set up frame properties
        setTitle("Add Student");

        pack();
        setLocationRelativeTo(null);
    }
    
    
}