package View;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controller.addController;
import Controller.deleteController;
import Controller.updateController;
import DAO.ConnectionDB;
import DAO.addDAO;
import DAO.deleteDAO;
import DAO.editDAO;
import service.addService;
import service.deleteService;
import service.editService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class appView extends JFrame {
	
    private JTable table;
    private DefaultTableModel tableModel;

    public appView() {
        // Create the main panel
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create the table model and table
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Create the buttons panel
        JPanel buttonsPanel = new JPanel(new FlowLayout());

        // Add the buttons to the buttons panel
        JButton addButton = new JButton("Add");
        buttonsPanel.add(addButton);

        JButton editButton = new JButton("Edit");
        buttonsPanel.add(editButton);

        JButton deleteButton = new JButton("Delete");
        buttonsPanel.add(deleteButton);

        JButton refreshButton = new JButton("Refresh");
        buttonsPanel.add(refreshButton);

        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        // Set the frame properties
        setTitle("Student Management");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        ConnectAndPopulate();
        
        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
            	addView view = new addView();
                view.setVisible(true);
            }
        });
        
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int rowIndex = table.getSelectedRow();
            	int modelIndex = table.convertRowIndexToModel(rowIndex);

            	// Get the values of each cell in the row
            	Object[] rowData = new Object[table.getColumnCount()];
            	for (int i = 0; i < table.getColumnCount(); i++) {
            	    rowData[i] = table.getValueAt(modelIndex, i);
            	}
            	
            	int id = Integer.parseInt(rowData[0].toString());
            	String cne = rowData[1].toString();
            	String name = rowData[2].toString(); 
            	String lname = rowData[3].toString(); 
            	Float note = Float.parseFloat(rowData[4].toString()); 
            	int tel =  Integer.parseInt(rowData[5].toString());
            	
            	editDAO adddao = new editDAO();
                editService addservice = new editService(adddao);
                updateController upController = new updateController(addservice);
            	
            	try {
					if (upController.updateS(id, cne, name, lname, note, tel)) {
						System.out.println("Retrieved values: id=" + id + ", cne=" + cne + ", name=" + name + ", lname=" + lname + ", note=" + note + ", tel=" + tel);

					    JOptionPane.showMessageDialog(appView.this, "edit action was successful!");
					} else {
					    JOptionPane.showMessageDialog(appView.this, "edit action failed.");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            
            }
        });

        
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int rowIndex = table.getSelectedRow();
            	int modelIndex = table.convertRowIndexToModel(rowIndex);

            	System.out.println("rowIndex is : " + rowIndex + "modelIndex is : " + modelIndex);
            	// Get the values of each cell in the row
            	Object[] rowData = new Object[table.getColumnCount()];
            	for (int i = 0; i < table.getColumnCount(); i++) {
            	    rowData[i] = table.getValueAt(modelIndex, i);
            	}
            	
            	int id = Integer.parseInt(rowData[0].toString());

            	System.out.println("id is : " + id);
            	deleteDAO deletedao = new deleteDAO();
            	deleteService deleteservice = new deleteService(deletedao);
            	deleteController DController = new deleteController(deleteservice);
            	
            	try {
					if (DController.deleteS(id)) {
						
					    JOptionPane.showMessageDialog(appView.this, "Delete action was successful!");
					} else {
					    JOptionPane.showMessageDialog(appView.this, "Delete action failed.");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            
            }
        });
        
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
            	ConnectAndPopulate();
            }
        });
        
        

        
        // Show the main frame
        setContentPane(mainPanel);
        setVisible(true);
    }

    
    public void ConnectAndPopulate(){
    	// Connect to the database and populate the table
    	tableModel.setRowCount(0);
    	tableModel.setColumnCount(0);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            ConnectionDB conn1 = new ConnectionDB();
        	Connection conn = conn1.getConn();
        	
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM studentadd");
            
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsmd.getColumnName(i);
                tableModel.addColumn(columnName);
            }
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                tableModel.addRow(row);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
    }
    
}
