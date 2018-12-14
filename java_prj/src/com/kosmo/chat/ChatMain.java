package com.kosmo.chat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChatMain extends JFrame {
    public ChatMain chatMain = this;
	public Socket sk1;
	public JPanel contentPane;
	public JTextArea textArea_chat;
	public JTextArea textArea_nick;
	public JTextField textField_msg;
	public JTextArea textArea;
	public JTextArea textArea_1;
	private String id;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		
		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ChatMain frame = new ChatMain(id);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		
		
	}

	/**
	 * Create the frame.
	 */
	public ChatMain() {
		setTitle("채팅이다");
		
		PrintStream out = null;
		Socket sk1 = null;
		try {
			sk1 = new Socket("127.0.0.1"
					+ "", 7777);
			System.out.println("[client] 서버연결성공");
			
			
			ReadThread rt = new ReadThread(sk1,chatMain);
			Thread t1 = new Thread(rt);
			t1.start();
	
	 
		 
	
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 641);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//하단
		JPanel under_panel = new JPanel();
		contentPane.add(under_panel, BorderLayout.SOUTH);
		
		JLabel label_nick = new JLabel(id + " : ");
		under_panel.add(label_nick);
		
		textField_msg = new JTextField();
		under_panel.add(textField_msg);
		textField_msg.setColumns(20);
		textField_msg.setText("");
		
		
		JButton btn_Chat = new JButton("전송");
		
		under_panel.add(btn_Chat);
		//----
		
		
		
		//채팅창
		JTextArea textArea_chat = new JTextArea();
		
		JScrollPane scrollPane_chat = new JScrollPane(textArea_chat);
		contentPane.add(scrollPane_chat, BorderLayout.CENTER);
		//----
		
		
		//닉네임창
		JTextArea textArea_nick = new JTextArea();
		textArea_nick.setEnabled(false);
		
		JScrollPane scrollPane_nick = new JScrollPane(textArea_nick);
		scrollPane_nick.setPreferredSize((new Dimension(150, 300)));
		contentPane.add(scrollPane_nick, BorderLayout.EAST);
		//----
		
		
		
		//전송버튼 클릭 또는 엔터 누를 시 전송하기
		
		btn_Chat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_chat.append(id+" : "+textField_msg.getText());
				textField_msg.setText("");
			}
		});
		
		textField_msg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();

			    if (key == KeyEvent.VK_ENTER) {
			    	textArea_chat.setText(id+" : "+textField_msg.getText());
			    	textField_msg.setText("");
			}
			}
		});
		
		//----
		
	}

}
