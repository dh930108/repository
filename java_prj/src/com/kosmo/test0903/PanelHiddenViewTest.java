package com.kosmo.test0903;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class PanelHiddenViewTest extends JFrame {
    private	JPanel panelA;
    private	JPanel panelB;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelHiddenViewTest frame = new PanelHiddenViewTest();
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
	public PanelHiddenViewTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JPanel panelS = new JPanel();
		contentPane.add(panelS, BorderLayout.CENTER);
		panelS.setLayout(new CardLayout(0, 0));
		
		
		panelS.add(panelA,1);
		panelS.add(panelB,1);
		
		
		JPanel panelA_1 = new JPanel();
		panelS.add(panelA_1, "name_1652950934742732");
		panelA_1.setBackground(Color.BLUE);
		panelA_1.setForeground(Color.RED);
		
		JPanel panelB_1 = new JPanel();
		panelS.add(panelB_1, "name_1652953790829252");
		panelB_1.setBackground(Color.RED);
		panelB_1.setForeground(Color.BLUE);
		panelB_1.setVisible(false);
		panelA_1.setVisible(false);
		
		JButton btnA = new JButton("A버튼이야");
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelB_1.setVisible(false);
				panelA_1.setVisible(true);
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(btnA);
		
		JButton btnB = new JButton("B버튼이야");
		btnB.setMinimumSize(new Dimension(0, 0));
		btnB.setMaximumSize(new Dimension(0, 0));
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelA_1.setVisible(false);
				panelB_1.setVisible(true);
			}
		});
		panel.add(btnB);
	}

}
