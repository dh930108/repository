package com.kosmo.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ApplicationTest {

	private JFrame frmBabidabida;
	private JTextField textField;
	private JTextArea chatLogArea;
	private JTextArea txtLog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationTest window = new ApplicationTest();
					window.frmBabidabida.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBabidabida = new JFrame();
		frmBabidabida.setTitle("BabiDabida");
		frmBabidabida.setBounds(100, 100, 450, 300);
		frmBabidabida.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmBabidabida.getContentPane().add(panel, BorderLayout.SOUTH);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(25);
		
		JButton btnNewButton = new JButton("전송");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("DDD : " + textField.getText());
				chatLogArea.append(textField.getText() + "\n");
				textField.setText("");
				
			}
		});
		panel.add(btnNewButton);
		
		chatLogArea = new JTextArea();
		chatLogArea.setRows(10);
		frmBabidabida.getContentPane().add(chatLogArea, BorderLayout.NORTH);
		

		JScrollPane scrollPane = new JScrollPane(chatLogArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		frmBabidabida.getContentPane().add(scrollPane);



	
		
	}

}
