package com.kosmo.gui.swit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnEdit;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmClose;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public BFrame(AFrame aframaddr) {
		
		//프레임 크기 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		ImageIcon icon = new ImageIcon("com/kosmo/gui/swit/imgs/122.png");
		ImageIcon resizeicon = new ImageIcon(icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		mnFile.setIcon(resizeicon);
		
		
		mnFile.setMnemonic('F');
		menuBar.add(mnFile);
		
		mntmSave = new JMenuItem("Save");
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("저장저장");
			}
		});
		mntmSave.setIcon(null);
		mnFile.add(mntmSave);
		
		mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("오픈 아이템 클릭.....");
			}
		});
	
				
		
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnFile.add(mntmOpen);
		
		mntmClose = new JMenuItem("Close");
		mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		mntmClose.setIcon(new ImageIcon(BFrame.class.getResource("/com/kosmo/gui/swit/imgs/close2.jpg")));
		mntmClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mnFile.add(mntmClose);
		
		mnEdit = new JMenu("Edit");
		mnEdit.setMnemonic('E');
		menuBar.add(mnEdit);
		
		//JPanel 설정
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.RED);
		
		//JFrame에 JPanel 올리기
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("BFrame");
		contentPane.add(btnNewButton, BorderLayout.EAST);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
		textField.setText(aframaddr.appTextField.getText());
		//frame.getContentPane().add(btnNewButton, BorderLayout.CENTER);
	}

}
