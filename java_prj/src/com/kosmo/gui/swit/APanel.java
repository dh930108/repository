package com.kosmo.gui.swit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class APanel extends JPanel {
	public JButton btnNewButton;
	JTextField textField;
	JButton Submit;
	

	/**
	 * Create the panel.
	 */
	public APanel() {
		setBackground(Color.BLUE);
		setLayout(new BorderLayout(0,0));
		JButton btnNewButton = new JButton("APanel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnNewButton, BorderLayout.WEST);
		
		textField = new JTextField();
		add(textField, BorderLayout.EAST);
		textField.setColumns(10);
		
	

	}

}
