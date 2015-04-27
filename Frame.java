import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;


public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNamepawsid;
	private JLabel lblEvent;
	private JLabel lblExperience;
	private JLabel lblTotalNeeded;
	private JLabel lblNotescomments;
	private JComboBox<?> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void clearTextFields(Container container) {

		for (Component c : container.getComponents()) {
			if (c instanceof JTextField) {
				JTextField f = (JTextField) c;
				f.setText("");
			} 
			else if (c instanceof Container)
				clearTextFields((Container)c);
		 }
	}
	
	/**
	 * Create the frame.
	 */
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, textField, 34, SpringLayout.WEST, panel);
		panel.add(textField);
		textField.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setBackground(Color.GREEN);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 34, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, -28, SpringLayout.EAST, panel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Name: " + textField.getText() + "\nEvent: " + textField_2.getText() + "\nExperience: " + comboBox.getSelectedItem().toString()
						+ "\nTotal Needed: " + textField_3.getText() + "\nComments: " + textField_4.getText());
				clearTextFields(contentPane);
			}
		});
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Post My Group");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 147, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, 58, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -135, SpringLayout.EAST, panel);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		textField_2 = new JTextField();
		sl_panel.putConstraint(SpringLayout.EAST, textField, -113, SpringLayout.WEST, textField_2);
		sl_panel.putConstraint(SpringLayout.WEST, textField_2, 314, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_2, -28, SpringLayout.EAST, panel);
		textField_2.setColumns(10);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, textField_3, 0, SpringLayout.WEST, textField_2);
		sl_panel.putConstraint(SpringLayout.EAST, textField_3, -28, SpringLayout.EAST, panel);
		textField_3.setColumns(10);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_4, 212, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textField_4, 0, SpringLayout.WEST, btnNewButton);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_4, -20, SpringLayout.NORTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.EAST, textField_4, -28, SpringLayout.EAST, panel);
		textField_4.setColumns(10);
		panel.add(textField_4);
		
		lblNamepawsid = new JLabel("Name/PawsID");
		sl_panel.putConstraint(SpringLayout.NORTH, textField, 6, SpringLayout.SOUTH, lblNamepawsid);
		sl_panel.putConstraint(SpringLayout.WEST, lblNamepawsid, 0, SpringLayout.WEST, textField);
		panel.add(lblNamepawsid);
		
		lblEvent = new JLabel("Event");
		sl_panel.putConstraint(SpringLayout.WEST, lblEvent, 184, SpringLayout.EAST, lblNamepawsid);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNamepawsid, 0, SpringLayout.NORTH, lblEvent);
		sl_panel.putConstraint(SpringLayout.NORTH, textField_2, 6, SpringLayout.SOUTH, lblEvent);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblEvent, -273, SpringLayout.SOUTH, panel);
		panel.add(lblEvent);
		
		lblExperience = new JLabel("Experience");
		sl_panel.putConstraint(SpringLayout.SOUTH, textField, -26, SpringLayout.NORTH, lblExperience);
		sl_panel.putConstraint(SpringLayout.WEST, lblExperience, 34, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblExperience, -201, SpringLayout.SOUTH, panel);
		panel.add(lblExperience);
		
		lblTotalNeeded = new JLabel("Total Needed");
		sl_panel.putConstraint(SpringLayout.NORTH, textField_3, 6, SpringLayout.SOUTH, lblTotalNeeded);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_2, -26, SpringLayout.NORTH, lblTotalNeeded);
		sl_panel.putConstraint(SpringLayout.WEST, lblTotalNeeded, 199, SpringLayout.EAST, lblExperience);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblTotalNeeded, -201, SpringLayout.SOUTH, panel);
		panel.add(lblTotalNeeded);
		
		lblNotescomments = new JLabel("Notes/Comments");
		sl_panel.putConstraint(SpringLayout.WEST, lblNotescomments, 34, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNotescomments, -6, SpringLayout.NORTH, textField_4);
		panel.add(lblNotescomments);
		
		comboBox = new JComboBox();
		sl_panel.putConstraint(SpringLayout.WEST, comboBox, 34, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, comboBox, -113, SpringLayout.WEST, textField_3);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_3, 4, SpringLayout.SOUTH, comboBox);
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox, 3, SpringLayout.SOUTH, lblExperience);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Division 1", "Division 2", "Division 3"}));
		panel.add(comboBox);
		
		
	}
}
