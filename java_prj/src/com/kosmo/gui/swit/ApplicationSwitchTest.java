package com.kosmo.gui.swit;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ApplicationSwitchTest {

	//private JFrame frame;
	AFrame aframe;
	BFrame bframe;
	private JTextField appTextField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ApplicationSwitchTest window = new ApplicationSwitchTest();
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public ApplicationSwitchTest(FrameSwitchTest switarrd) {
		
		//Window 크기 설정
//		frame = new JFrame();
//		frame.setBounds(100, 100, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		

		
//		JButton btnNewButton = new JButton("BFrame");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				frame.setVisible(false);
//				bframe = new BFrame();
//				bframe.setVisible(true);
//			
//			}
//		});
//		
		//패널 frame.getContentPane().add()
		//frame.getContentPane().add(btnNewButton, BorderLayout.WEST);
		//       contentPane.add(btnNewButton, BorderLayout.CENTER);
		
		
		aframe = new AFrame(switarrd);
		aframe.setVisible(true);
		
		
		
		//window.frame.setVisible(true);
		
	}

}
