package com.kosmo.gui.demo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import com.kosmo.gui.swit.BFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GoogleMapFrame extends JFrame{

	private JPanel contentPane;
	private JTextField searchTextField;
	JButton searchButton;
	String zoomSize;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GoogleMapFrame frame = new GoogleMapFrame();
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
	public GoogleMapFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
////		GoogleMapIOTest gmtio = new GoogleMapIOTest();
////		String jpgPath = gmtio.createMapJpg(path);
//		
//		ImageIcon icon = new ImageIcon(jpgPath);
//		//ImageIcon icon = new ImageIcon(getClass().getResource(mapstr));
//		ImageIcon resizeicon = new ImageIcon(icon.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH));
		
		JPanel centerPanel = new JPanel();
		centerPanel.setPreferredSize(new Dimension(700, 550));
		contentPane.add(centerPanel, BorderLayout.CENTER);
		
//		JLabel mapLabel = new JLabel();
//		centerPanel.add(mapLabel);
		
		JPanel northPanel = new JPanel();
		contentPane.add(northPanel, BorderLayout.NORTH);
		
		searchTextField = new JTextField();
		searchTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					searchButton.doClick();
			}
		});
		northPanel.add(searchTextField);
		searchTextField.setColumns(10);
		
		
		JButton searchButton = new JButton("검색");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				centerPanel.removeAll();
				GoogleMapIOTest gmtio = new GoogleMapIOTest();
				String jpgPath = null;
				if(searchTextField.getText().equals("")) {
					jpgPath = gmtio.createMapJpg("쌍문동", "16");
				}else {
					jpgPath = gmtio.createMapJpg(searchTextField.getText(), zoomSize);
				}
				ImageIcon icon = new ImageIcon(jpgPath);
				ImageIcon resizeicon = new ImageIcon(icon.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH));
				JLabel mapLabel = new JLabel(resizeicon);
				centerPanel.add(mapLabel);
				centerPanel.revalidate();
			}
		});
		northPanel.add(searchButton);
		
		
		
			String[] values = new String[] {"3","15","16","17","20"};
			JList list = new JList(values);
			list.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					zoomSize = list.getSelectedValue().toString();
				}
			});
			
			 list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		        list.setSelectedIndex(1);
		        list.setVisibleRowCount(1);
		        JScrollPane Scroolist = new JScrollPane(list);
		        northPanel.add(Scroolist);
	}

}
