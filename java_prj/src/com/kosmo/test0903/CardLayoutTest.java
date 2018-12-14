package com.kosmo.test0903;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

public class CardLayoutTest extends JFrame {

	private JPanel contentPane;
	CardLayout cardLayout;
	JPanel cardPanel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardLayoutTest frame = new CardLayoutTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CardLayoutTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.NORTH);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnA = new JButton("A버튼이야");
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardPanel.setVisible(true);
				cardLayout.show(cardPanel, "add_name_A");
			}
		});
		
		buttonPanel.add(btnA);
		
		JButton btnB = new JButton("B버튼이야");
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardPanel.setVisible(true);
				cardLayout.show(cardPanel, "add_name_B");
			}
		});
		buttonPanel.add(btnB);
		
		cardPanel = new JPanel();
		cardPanel.setVisible(false);
		cardLayout = new CardLayout(0, 0);
		cardPanel.setLayout(cardLayout);
		contentPane.add(cardPanel, BorderLayout.CENTER);
		
		JPanel panelA = new JPanel();
		panelA.setBackground(Color.RED);
		cardPanel.add(panelA, "add_name_A");
		
		JPanel panelB = new JPanel();
		panelB.setBackground(Color.BLUE);
		cardPanel.add(panelB, "add_name_B");
		
		
		
		
		
		
	}

}
