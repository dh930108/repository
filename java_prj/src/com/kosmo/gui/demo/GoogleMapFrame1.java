package com.kosmo.gui.demo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.kosmo.gui.swit.BFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GoogleMapFrame1 extends JFrame {

	private JPanel contentPane;
	private JTextField searchTextField;
	String zoomSize="15";
	
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

	
	public void GoogleMapFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		contentPane = new JPanel();  
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//---------------------지도 -----------------------
		JPanel centerPanel = new JPanel();
		centerPanel.setPreferredSize(new Dimension(800, 550));
		contentPane.add(centerPanel, BorderLayout.CENTER);

		//---------------------검색어/검색버튼 -----------------------
		JPanel northPanel = new JPanel();
		contentPane.add(northPanel, BorderLayout.NORTH);
		
		JButton searchButton = new JButton("search");
		
		searchTextField = new JTextField();
		searchTextField.setColumns(10);
		searchTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					searchButton.doClick();
		        }
			}
		});
		
		//---------------- 줌 사이즈 JLIst ----------------------
		String[] data = {"3","15","20"};
		JList list = new JList(data);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				zoomSize = list.getSelectedValue().toString();
			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(1);
		list.setVisibleRowCount(1);
		JScrollPane listScrollPane = new JScrollPane(list);
		listScrollPane.setPreferredSize(new Dimension(50,30));
		
		
		//-------------------검색어 입력 후 검색버튼 클릭 --------------------------
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				centerPanel.removeAll();
				
				//-----------------------------
				//구글 맵 jpg로 만들기
				GoogleMapIOTest test = new GoogleMapIOTest();
				if(searchTextField.getText().equals("")) {
					//searchTextField.setText("시청");
					JOptionPane.showMessageDialog(null, "검색어 입력 필수");
					searchTextField.requestFocus();
        			return;
				}
				String jpgPath = test.createMapJpg(searchTextField.getText(), zoomSize);
				//-----------------------------
				
				searchTextField.setText("");
				searchTextField.requestFocus();
				
				//위에서 만든 jpg 이미지 보이기 
				ImageIcon icon = new ImageIcon(jpgPath);
				ImageIcon resizeicon = new ImageIcon(icon.getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH));
				JLabel mapLabel = new JLabel(resizeicon);
				centerPanel.add(mapLabel);
				centerPanel.revalidate();
			}
		});
		
		northPanel.add(searchTextField);
		northPanel.add(searchButton);
		northPanel.add(listScrollPane);
	}

}
