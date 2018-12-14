package com.kosmo.test0903;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JScrollBar;

public class MyFrameClass extends MyPanelClass {

	private JFrame frame;
	private JTextField msgField;
	private JTextArea chatLogArea;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrameClass window = new MyFrameClass();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyFrameClass() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		msgField = new JTextField();
		msgField.setColumns(22);
		panel.add(msgField);
		
		chatLogArea = new JTextArea();
		chatLogArea.setRows(10);
		
		
		//scrollPane = new JScrollPane(chatLogArea);
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(chatLogArea);  //add
		scrollPane.setPreferredSize(new Dimension(100,220));
		//scrollPane.add(chatLogArea);
		
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
		
		JButton sendButton = new JButton("전송");
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//서버로 메세지 전송
				System.out.println("DDD:" + msgField.getText());
				chatLogArea.append(msgField.getText() + "\n");
				msgField.setText("");
			}
		});
		panel.add(sendButton);
		
		
		
		
		
	}

}
