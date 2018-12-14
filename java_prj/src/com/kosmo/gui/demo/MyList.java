package com.kosmo.gui.demo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyList extends JFrame {

	private JPanel contentPane;
	private JTextField eastTextField;
	private JList jList;
	private JPanel southPanel;
	private JTextField insertTextField;
	private JButton insertButton;
	private JButton deleteButton;
	private JButton sendButton;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyList frame = new MyList();
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
	public MyList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		DefaultListModel listModel = new DefaultListModel();
		listModel.addElement("aa");
		listModel.addElement("bb");
		listModel.addElement("cc");
		jList = new JList(listModel);
		jList.setSelectedIndex(0);
		JScrollPane scrollPane = new JScrollPane(jList);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		//---------------------------
		JPanel eastPanel = new JPanel();
		eastPanel.setPreferredSize(new Dimension(200, 300));
		contentPane.add(eastPanel, BorderLayout.EAST);
		
		textPane = new JTextPane();
		textPane.setContentType("text/html");
		eastPanel.add(textPane);
		
		eastTextField = new JTextField();
		eastTextField.setColumns(10);
		eastPanel.add(eastTextField);
		//---------------------------
		
		
		southPanel = new JPanel();
		contentPane.add(southPanel, BorderLayout.SOUTH);
		
		insertTextField = new JTextField();
		insertTextField.setColumns(10);
		southPanel.add(insertTextField);
		
		insertButton = new JButton("INSERT");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectIndex = jList.getSelectedIndex();
				int insertIndexPosition = selectIndex+1;
				listModel.insertElementAt(insertTextField.getText(), insertIndexPosition);
				insertTextField.setText("");
				//옵션기능:리스트 선택되게. 보기좋게
				jList.setSelectedIndex(insertIndexPosition);
	            jList.ensureIndexIsVisible(insertIndexPosition);
	            
			}
		});
		southPanel.add(insertButton);
		
		deleteButton = new JButton("DELETE");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectIndex = jList.getSelectedIndex();
				int deleteIndexPosition = selectIndex-1;
	            listModel.remove(selectIndex);
	            //옵션기능:리스트 선택되게
	            if(deleteIndexPosition >= 0 ) {
		            jList.setSelectedIndex(deleteIndexPosition);
	                jList.ensureIndexIsVisible(deleteIndexPosition);
	            }
			}
		});
		southPanel.add(deleteButton);
		
		sendButton = new JButton("SEND");
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectIndex = jList.getSelectedIndex();
				String selectValue = jList.getSelectedValue().toString();
				eastTextField.setText(selectIndex + "," + selectValue);
				textPane.setText("<b>"+selectIndex + "," + selectValue+"</b>");
			}
		});
		southPanel.add(sendButton);
		
	}

}
