package com.kosmo.chat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Insets;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class ChatLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		 
		 EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						ChatLogin frame = new ChatLogin();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		 //-------------------------------새 코드
		 
		   
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		
		
		
	}

	/**
	 * Create the frame.
	 */
	public ChatLogin() {
		
		
		
		setTitle("로그인이다");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 100));
		
		JLabel lblNewLabel = new JLabel("닉네임 : ");
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				//ChatMain cm = new ChatMain(textField.getText());
				//cm.setVisible(true);
				setVisible(false);
				
				
				/*
				sk = new Socket("127.0.0.1", 7777);
				System.out.println("[client] 서버연결성공");
				os = sk.getOutputStream();
				out = new PrintStream(os);
				
				ReadThread read = new ReadThread(sk, chatLoginObject);
				Thread rt = new Thread(read);
				rt.start();
				
				//----------------GUI 추가------------------
				nickname = nicknameTextField.getText();
				out.println(nickname); //닉네임전송
				
				loginPanel.setVisible(false);
				chatPanel.setVisible(true);
				*/
			
			}
		});
		panel.add(btnLogin);
	}

}
