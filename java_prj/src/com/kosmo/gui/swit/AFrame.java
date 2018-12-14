package com.kosmo.gui.swit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AFrame extends JFrame {

	private JPanel contentPane;

	AFrame aframe;
	BFrame bframe;
	String appTextStr;
	JTextField appTextField;
	AFrame aa;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AFrame frame = new AFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AFrame(FrameSwitchTest switarrd) {
		aa = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.BLUE);
		setContentPane(contentPane);
		
		appTextField = new JTextField();
		appTextField.setText("applicationValue : 60" + "\n" + 
							  switarrd.textField.getText());
		appTextField.setColumns(10);
		appTextStr = appTextField.getText();
		contentPane.add(appTextField, BorderLayout.EAST);
		
		
		JButton btnNewButton = new JButton("AFrame");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bframe = new BFrame(aa);//AFrame의 주소전달
				bframe.setVisible(true);
			}
		});
		contentPane.add(btnNewButton, BorderLayout.WEST);
		
	}

}
