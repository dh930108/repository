package com.kosmo.javaproject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Jangbaguni extends JFrame {

	private JPanel contentPane;
	ArrayList<MenuVO> list;
	Jangbaguni jb;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Jangbaguni frame = new Jangbaguni();
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
	public Jangbaguni() {
		setTitle("장바구니");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		ArrayList<MenuVO> list = new ArrayList<MenuVO>();
		
		list = bagunipick2();
		this.list = list;
		ImageIcon deleteIcon = new ImageIcon(ShopDetail.class.getResource("/com/kosmo/javaproject/chicken/delete_sign.jpg"));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		int total = 0;
		if(list.size()<=13) {
			for(int i = 0; list.size()>i;i++) {
				total += list.get(i).getPrice();
			}
		}else {
			for(int i = 0; 13 >=i; i++) {
				total += list.get(i).getPrice();
			}
		}
		
		
		
		String ttp = String.valueOf(total);
		String tprice = null;
		System.out.println(ttp.length());
		if(ttp.length()==6) {
			tprice = "총액 : "+ttp.substring(0, 3)+","+ttp.substring(3, 6)+ "원";
		}else if(ttp.length()==5) {
			tprice = "총액 : "+ttp.substring(0, 2)+","+ttp.substring(2, 5)+ "원";
		}else if(ttp.length()==4){
			tprice = "총액 : "+ttp.substring(0, 1)+","+ttp.substring(1, 4)+ "원";
		}else {
			tprice = "총액 : "+ ttp + "원";
		}
		
		
		
		
		JLabel lblTotalPrice = new JLabel(tprice);
		lblTotalPrice.setFont(new Font("HY견고딕", Font.PLAIN, 15));
		lblTotalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblTotalPrice, BorderLayout.NORTH);
		
		JPanel panel_15 = new JPanel();
		panel.add(panel_15, BorderLayout.CENTER);
		
		JButton btnOrder = new JButton("주문하기");
		btnOrder.setFont(new Font("HY견고딕", Font.PLAIN, 15));
		panel_15.add(btnOrder);
		
		JButton btnDelete = new JButton("장바구니비우기");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				baguniAllDelete();
				Jangbaguni frame = new Jangbaguni();
				Jangbaguni.this.setVisible(false);
				frame.setVisible(true);
				
			}
		});
		btnDelete.setFont(new Font("HY견고딕", Font.PLAIN, 15));
		panel_15.add(btnDelete);
		
		JPanel Jangbapanel = new JPanel();
		Jangbapanel.setPreferredSize(new Dimension(250, 2000));
		JScrollPane scrollPane = new JScrollPane(Jangbapanel);
		Jangbapanel.setLayout(null);
		
		
		
		
		if(list.size() >= 1) {
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.PINK));
		panel_1.setBounds(0, 0, 260, 140);
		Jangbapanel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setPreferredSize(new Dimension(80, 140));
		panel_1.add(panel_1_1, BorderLayout.WEST);
		panel_1_1.setLayout(new BorderLayout(0, 0));
		
		ImageIcon jangba1 = new ImageIcon(ShopDetail.class.getResource(list.get(0).getFimage()));
		JLabel panelLabel1_1 = new JLabel(jangba1);
		panelLabel1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1_1.add(panelLabel1_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1.add(panel_1_2, BorderLayout.CENTER);
		panel_1_2.setLayout(new BorderLayout(0, 0));
		
		String pr1 = String.valueOf(list.get(0).getPrice());
		String price1 = null;
		if(pr1.length()==5) {
		price1 = pr1.substring(0, 2)+","+pr1.substring(2, 5)+ "원";
		}else {
		price1 = pr1.substring(0, 1)+","+pr1.substring(1, 4)+ "원";
		}
		JLabel panelLabel1_3 = new JLabel(price1);
		panelLabel1_3.setFont(new Font("HY견고딕", Font.PLAIN, 14));
		panelLabel1_3.setVerticalAlignment(SwingConstants.TOP);
		panelLabel1_3.setPreferredSize(new Dimension(80, 50));
		panel_1_2.add(panelLabel1_3, BorderLayout.SOUTH);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_2.add(panel_1_3, BorderLayout.CENTER);
		panel_1_3.setLayout(null);
		
	
		JLabel panelLabel1_2 = new JLabel(list.get(0).getFname());
		panelLabel1_2.setFont(new Font("HY견고딕", Font.PLAIN, 17));
		panelLabel1_2.setBounds(0, 37, 168, 43);
		panel_1_3.add(panelLabel1_2);
		
		JLabel panelLabel1_4 = new JLabel(deleteIcon);
		panelLabel1_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rs = baguniDelete(Jangbaguni.this.list.get(0).getFseq());
					//custom title, custom icon
					//default title and icon
					Jangbaguni frame = new Jangbaguni();
					JOptionPane.showMessageDialog(frame, Jangbaguni.this.list.get(0).getFname() +"이(가) 삭제되었습니다.");
					Jangbaguni.this.setVisible(false);
					frame.setVisible(true);
				
			}
		});
		panelLabel1_4.setBounds(153, 10, 15, 15);
		panel_1_3.add(panelLabel1_4);
		Jangbapanel.add(panel_1);
		//111111111111111111111111111111111111111111
		
		if(list.size() >= 2) {
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.PINK));
		panel_2.setBounds(0, 150, 260, 140);
		Jangbapanel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setPreferredSize(new Dimension(80, 140));
		panel_2.add(panel_2_1, BorderLayout.WEST);
		panel_2_1.setLayout(new BorderLayout(0, 0));
		
		ImageIcon jangba2 = new ImageIcon(ShopDetail.class.getResource(list.get(1).getFimage()));
		JLabel panelLabel2_1 = new JLabel(jangba2);
		panelLabel2_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2_1.add(panelLabel2_1);
		
		JPanel panel_2_2 = new JPanel();
		panel_2.add(panel_2_2, BorderLayout.CENTER);
		panel_2_2.setLayout(new BorderLayout(0, 0));
		
		String pr2 = String.valueOf(list.get(1).getPrice());
		String price2 = null;
		if(pr2.length()==5) {
		price2 = pr2.substring(0, 2)+","+pr2.substring(2, 5)+ "원";
		}else {
		price2 = pr2.substring(0, 1)+","+pr2.substring(1, 4)+ "원";
		}
		JLabel panelLabel2_3 = new JLabel(price2);
		panelLabel2_3.setFont(new Font("HY견고딕", Font.PLAIN, 14));
		panelLabel2_3.setVerticalAlignment(SwingConstants.TOP);
		panelLabel2_3.setPreferredSize(new Dimension(80, 50));
		panel_2_2.add(panelLabel2_3, BorderLayout.SOUTH);
		
		JPanel panel_2_3 = new JPanel();
		panel_2_2.add(panel_2_3, BorderLayout.CENTER);
		panel_2_3.setLayout(null);
		
	
		JLabel panelLabel2_2 = new JLabel(list.get(1).getFname());
		panelLabel2_2.setFont(new Font("HY견고딕", Font.PLAIN, 17));
		panelLabel2_2.setBounds(0, 37, 168, 43);
		panel_2_3.add(panelLabel2_2);
		
		JLabel panelLabel2_4 = new JLabel(deleteIcon);
		panelLabel2_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rs = baguniDelete(Jangbaguni.this.list.get(1).getFseq());
					//custom title, custom icon
					//default title and icon
					Jangbaguni frame = new Jangbaguni();
					JOptionPane.showMessageDialog(frame, Jangbaguni.this.list.get(1).getFname() +"이(가) 삭제되었습니다.");
					Jangbaguni.this.setVisible(false);
					frame.setVisible(true);
				
			}
		});
		panelLabel2_4.setBounds(153, 10, 15, 15);
		panel_2_3.add(panelLabel2_4);
		Jangbapanel.add(panel_2);
		//22222222222222222222222222222222222222222222
		
		if(list.size() >= 3) {
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 300, 260, 140);
		panel_3.setBorder(new LineBorder(Color.PINK));
		Jangbapanel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setPreferredSize(new Dimension(80, 140));
		panel_3.add(panel_3_1, BorderLayout.WEST);
		panel_3_1.setLayout(new BorderLayout(0, 0));
		
		ImageIcon jangba3 = new ImageIcon(ShopDetail.class.getResource(list.get(2).getFimage()));
		JLabel panelLabel3_1 = new JLabel(jangba3);
		panelLabel3_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3_1.add(panelLabel3_1);
		
		JPanel panel_3_2 = new JPanel();
		panel_3.add(panel_3_2, BorderLayout.CENTER);
		panel_3_2.setLayout(new BorderLayout(0, 0));
		
		String pr3 = String.valueOf(list.get(2).getPrice());
		String price3 = null;
		if(pr3.length()==5) {
		price3 = pr3.substring(0, 2)+","+pr3.substring(2, 5)+ "원";
		}else {
		price3 = pr3.substring(0, 1)+","+pr3.substring(1, 4)+ "원";
		}
		JLabel panelLabel3_3 = new JLabel(price3);
		panelLabel3_3.setFont(new Font("HY견고딕", Font.PLAIN, 14));
		panelLabel3_3.setVerticalAlignment(SwingConstants.TOP);
		panelLabel3_3.setPreferredSize(new Dimension(80, 50));
		panel_3_2.add(panelLabel3_3, BorderLayout.SOUTH);
		
		JPanel panel_3_3 = new JPanel();
		panel_3_2.add(panel_3_3, BorderLayout.CENTER);
		panel_3_3.setLayout(null);
		
	
		JLabel panelLabel3_2 = new JLabel(list.get(2).getFname());
		panelLabel3_2.setFont(new Font("HY견고딕", Font.PLAIN, 17));
		panelLabel3_2.setBounds(0, 37, 168, 43);
		panel_3_3.add(panelLabel3_2);
		
		JLabel panelLabel3_4 = new JLabel(deleteIcon);
		panelLabel3_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rs = baguniDelete(Jangbaguni.this.list.get(2).getFseq());
					//custom title, custom icon
					//default title and icon
					Jangbaguni frame = new Jangbaguni();
					JOptionPane.showMessageDialog(frame, Jangbaguni.this.list.get(2).getFname() +"이(가) 삭제되었습니다.");
					Jangbaguni.this.setVisible(false);
					frame.setVisible(true);
				
			}
		});
		panelLabel3_4.setBounds(153, 10, 15, 15);
		panel_3_3.add(panelLabel3_4);
		Jangbapanel.add(panel_3);
		//3333333333333333333333333333333333333333333333333333333333
		
		if(list.size() >= 4) {
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 450, 260, 140);
		panel_4.setBorder(new LineBorder(Color.PINK));
		Jangbapanel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setPreferredSize(new Dimension(80, 140));
		panel_4.add(panel_4_1, BorderLayout.WEST);
		panel_4_1.setLayout(new BorderLayout(0, 0));
		
		ImageIcon jangba4 = new ImageIcon(ShopDetail.class.getResource(list.get(3).getFimage()));
		JLabel panelLabel4_1 = new JLabel(jangba4);
		panelLabel4_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4_1.add(panelLabel4_1);
		
		JPanel panel_4_2 = new JPanel();
		panel_4.add(panel_4_2, BorderLayout.CENTER);
		panel_4_2.setLayout(new BorderLayout(0, 0));
		
		String pr4 = String.valueOf(list.get(3).getPrice());
		String price4 = null;
		if(pr4.length()==5) {
		price4 = pr4.substring(0, 2)+","+pr4.substring(2, 5)+ "원";
		}else {
		price4 = pr4.substring(0, 1)+","+pr4.substring(1, 4)+ "원";
		}
		JLabel panelLabel4_3 = new JLabel(price4);
		panelLabel4_3.setFont(new Font("HY견고딕", Font.PLAIN, 14));
		panelLabel4_3.setVerticalAlignment(SwingConstants.TOP);
		panelLabel4_3.setPreferredSize(new Dimension(80, 50));
		panel_4_2.add(panelLabel4_3, BorderLayout.SOUTH);
		
		JPanel panel_4_3 = new JPanel();
		panel_4_2.add(panel_4_3, BorderLayout.CENTER);
		panel_4_3.setLayout(null);
		
	
		JLabel panelLabel4_2 = new JLabel(list.get(3).getFname());
		panelLabel4_2.setFont(new Font("HY견고딕", Font.PLAIN, 17));
		panelLabel4_2.setBounds(0, 37, 168, 43);
		panel_4_3.add(panelLabel4_2);
		
		JLabel panelLabel4_4 = new JLabel(deleteIcon);
		panelLabel4_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rs = baguniDelete(Jangbaguni.this.list.get(3).getFseq());
					//custom title, custom icon
					//default title and icon
					Jangbaguni frame = new Jangbaguni();
					JOptionPane.showMessageDialog(frame, Jangbaguni.this.list.get(3).getFname() +"이(가) 삭제되었습니다.");
					Jangbaguni.this.setVisible(false);
					frame.setVisible(true);
				
			}
		});
		panelLabel4_4.setBounds(153, 10, 15, 15);
		panel_4_3.add(panelLabel4_4);
		Jangbapanel.add(panel_4);
		//44444444444444444444444444444444444444444444444444444444
		
		if(list.size() >= 5) {
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 600, 260, 140);
		panel_5.setBorder(new LineBorder(Color.PINK));
		Jangbapanel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setPreferredSize(new Dimension(80, 140));
		panel_5.add(panel_5_1, BorderLayout.WEST);
		panel_5_1.setLayout(new BorderLayout(0, 0));
		
		ImageIcon jangba5 = new ImageIcon(ShopDetail.class.getResource(list.get(4).getFimage()));
		JLabel panelLabel5_1 = new JLabel(jangba5);
		panelLabel5_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5_1.add(panelLabel5_1);
		
		JPanel panel_5_2 = new JPanel();
		panel_5.add(panel_5_2, BorderLayout.CENTER);
		panel_5_2.setLayout(new BorderLayout(0, 0));
		
		String pr5 = String.valueOf(list.get(4).getPrice());
		String price5 = null;
		if(pr5.length()==5) {
		price5 = pr5.substring(0, 2)+","+pr5.substring(2, 5)+ "원";
		}else {
		price5 = pr5.substring(0, 1)+","+pr5.substring(1, 4)+ "원";
		}
		JLabel panelLabel5_3 = new JLabel(price5);
		panelLabel5_3.setFont(new Font("HY견고딕", Font.PLAIN, 14));
		panelLabel5_3.setVerticalAlignment(SwingConstants.TOP);
		panelLabel5_3.setPreferredSize(new Dimension(80, 50));
		panel_5_2.add(panelLabel5_3, BorderLayout.SOUTH);
		
		JPanel panel_5_3 = new JPanel();
		panel_5_2.add(panel_5_3, BorderLayout.CENTER);
		panel_5_3.setLayout(null);
		
	
		JLabel panelLabel5_2 = new JLabel(list.get(4).getFname());
		panelLabel5_2.setFont(new Font("HY견고딕", Font.PLAIN, 17));
		panelLabel5_2.setBounds(0, 37, 168, 43);
		panel_5_3.add(panelLabel5_2);
		
		JLabel panelLabel5_4 = new JLabel(deleteIcon);
		panelLabel5_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rs = baguniDelete(Jangbaguni.this.list.get(4).getFseq());
					//custom title, custom icon
					//default title and icon
					Jangbaguni frame = new Jangbaguni();
					JOptionPane.showMessageDialog(frame, Jangbaguni.this.list.get(4).getFname() +"이(가) 삭제되었습니다.");
					Jangbaguni.this.setVisible(false);
					frame.setVisible(true);
				
			}
		});
		panelLabel5_4.setBounds(153, 10, 15, 15);
		panel_5_3.add(panelLabel5_4);
		Jangbapanel.add(panel_5);
		//555555555555555555555555555555555555555555555555555555
		
		if(list.size() >= 6) {
		
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 750, 260, 140);
		panel_6.setBorder(new LineBorder(Color.PINK));
		Jangbapanel.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setPreferredSize(new Dimension(80, 140));
		panel_6.add(panel_6_1, BorderLayout.WEST);
		panel_6_1.setLayout(new BorderLayout(0, 0));
		
		ImageIcon jangba6 = new ImageIcon(ShopDetail.class.getResource(list.get(5).getFimage()));
		JLabel panelLabel6_1 = new JLabel(jangba6);
		panelLabel6_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6_1.add(panelLabel6_1);
		
		JPanel panel_6_2 = new JPanel();
		panel_6.add(panel_6_2, BorderLayout.CENTER);
		panel_6_2.setLayout(new BorderLayout(0, 0));
		
		String pr6 = String.valueOf(list.get(5).getPrice());
		String price6 = null;
		if(pr6.length()==5) {
		price6 = pr6.substring(0, 2)+","+pr6.substring(2, 5)+ "원";
		}else {
		price6 = pr6.substring(0, 1)+","+pr6.substring(1, 4)+ "원";
		}
		JLabel panelLabel6_3 = new JLabel(price6);
		panelLabel6_3.setFont(new Font("HY견고딕", Font.PLAIN, 14));
		panelLabel6_3.setVerticalAlignment(SwingConstants.TOP);
		panelLabel6_3.setPreferredSize(new Dimension(80, 50));
		panel_6_2.add(panelLabel6_3, BorderLayout.SOUTH);
		
		JPanel panel_6_3 = new JPanel();
		panel_6_2.add(panel_6_3, BorderLayout.CENTER);
		panel_6_3.setLayout(null);
		
	
		JLabel panelLabel6_2 = new JLabel(list.get(5).getFname());
		panelLabel6_2.setFont(new Font("HY견고딕", Font.PLAIN, 17));
		panelLabel6_2.setBounds(0, 37, 168, 43);
		panel_6_3.add(panelLabel6_2);
		
		JLabel panelLabel6_4 = new JLabel(deleteIcon);
		panelLabel6_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rs = baguniDelete(Jangbaguni.this.list.get(5).getFseq());
					//custom title, custom icon
					//default title and icon
					Jangbaguni frame = new Jangbaguni();
					JOptionPane.showMessageDialog(frame, Jangbaguni.this.list.get(5).getFname() +"이(가) 삭제되었습니다.");
					Jangbaguni.this.setVisible(false);
					frame.setVisible(true);
				
			}
		});
		panelLabel6_4.setBounds(153, 10, 15, 15);
		panel_6_3.add(panelLabel6_4);
		Jangbapanel.add(panel_6);
		//66666666666666666666666666666666666666666666666666666666
		
		if(list.size() >= 7) {
		
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(0, 750, 260, 140);
		panel_7.setBorder(new LineBorder(Color.PINK));
		Jangbapanel.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7_1 = new JPanel();
		panel_7_1.setPreferredSize(new Dimension(80, 140));
		panel_7.add(panel_7_1, BorderLayout.WEST);
		panel_7_1.setLayout(new BorderLayout(0, 0));
		
		ImageIcon jangba7 = new ImageIcon(ShopDetail.class.getResource(list.get(6).getFimage()));
		JLabel panelLabel7_1 = new JLabel(jangba7);
		panelLabel7_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7_1.add(panelLabel7_1);
		
		JPanel panel_7_2 = new JPanel();
		panel_7.add(panel_7_2, BorderLayout.CENTER);
		panel_7_2.setLayout(new BorderLayout(0, 0));
		
		String pr7 = String.valueOf(list.get(6).getPrice());
		String price7 = null;
		if(pr7.length()==5) {
		price7 = pr7.substring(0, 2)+","+pr7.substring(2, 5)+ "원";
		}else {
		price7 = pr7.substring(0, 1)+","+pr7.substring(1, 4)+ "원";
		}
		JLabel panelLabel7_3 = new JLabel(price7);
		panelLabel7_3.setFont(new Font("HY견고딕", Font.PLAIN, 14));
		panelLabel7_3.setVerticalAlignment(SwingConstants.TOP);
		panelLabel7_3.setPreferredSize(new Dimension(80, 50));
		panel_7_2.add(panelLabel7_3, BorderLayout.SOUTH);
		
		JPanel panel_7_3 = new JPanel();
		panel_7_2.add(panel_7_3, BorderLayout.CENTER);
		panel_7_3.setLayout(null);
		
	
		JLabel panelLabel7_2 = new JLabel(list.get(6).getFname());
		panelLabel7_2.setFont(new Font("HY견고딕", Font.PLAIN, 17));
		panelLabel7_2.setBounds(0, 37, 168, 43);
		panel_7_3.add(panelLabel7_2);
		
		JLabel panelLabel7_4 = new JLabel(deleteIcon);
		panelLabel7_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rs = baguniDelete(Jangbaguni.this.list.get(6).getFseq());
					//custom title, custom icon
					//default title and icon
					Jangbaguni frame = new Jangbaguni();
					JOptionPane.showMessageDialog(frame, Jangbaguni.this.list.get(6).getFname() +"이(가) 삭제되었습니다.");
					Jangbaguni.this.setVisible(false);
					frame.setVisible(true);
				
			}
		});
		panelLabel7_4.setBounds(153, 10, 15, 15);
		panel_7_3.add(panelLabel7_4);
		Jangbapanel.add(panel_7);
		//77777777777777777777777777777777777777777777777777777777777
		
		if(list.size() >= 8) {
		
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(0, 900, 260, 140);
		panel_8.setBorder(new LineBorder(Color.PINK));
		Jangbapanel.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8_1 = new JPanel();
		panel_8_1.setPreferredSize(new Dimension(80, 140));
		panel_8.add(panel_8_1, BorderLayout.WEST);
		panel_8_1.setLayout(new BorderLayout(0, 0));
		
		ImageIcon jangba8 = new ImageIcon(ShopDetail.class.getResource(list.get(7).getFimage()));
		JLabel panelLabel8_1 = new JLabel(jangba8);
		panelLabel8_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8_1.add(panelLabel8_1);
		
		JPanel panel_8_2 = new JPanel();
		panel_8.add(panel_8_2, BorderLayout.CENTER);
		panel_8_2.setLayout(new BorderLayout(0, 0));
		
		String pr8 = String.valueOf(list.get(7).getPrice());
		String price8 = null;
		if(pr8.length()==5) {
		price8 = pr8.substring(0, 2)+","+pr8.substring(2, 5)+ "원";
		}else {
		price8 = pr8.substring(0, 1)+","+pr8.substring(1, 4)+ "원";
		}
		JLabel panelLabel8_3 = new JLabel(price8);
		panelLabel8_3.setFont(new Font("HY견고딕", Font.PLAIN, 14));
		panelLabel8_3.setVerticalAlignment(SwingConstants.TOP);
		panelLabel8_3.setPreferredSize(new Dimension(80, 50));
		panel_8_2.add(panelLabel8_3, BorderLayout.SOUTH);
		
		JPanel panel_8_3 = new JPanel();
		panel_8_2.add(panel_8_3, BorderLayout.CENTER);
		panel_8_3.setLayout(null);
		
	
		JLabel panelLabel8_2 = new JLabel(list.get(7).getFname());
		panelLabel8_2.setFont(new Font("HY견고딕", Font.PLAIN, 17));
		panelLabel8_2.setBounds(0, 37, 168, 43);
		panel_8_3.add(panelLabel8_2);
		
		JLabel panelLabel8_4 = new JLabel(deleteIcon);
		panelLabel8_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rs = baguniDelete(Jangbaguni.this.list.get(7).getFseq());
					//custom title, custom icon
					//default title and icon
					Jangbaguni frame = new Jangbaguni();
					JOptionPane.showMessageDialog(frame, Jangbaguni.this.list.get(7).getFname() +"이(가) 삭제되었습니다.");
					Jangbaguni.this.setVisible(false);
					frame.setVisible(true);
				
			}
		});
		panelLabel8_4.setBounds(153, 10, 15, 15);
		panel_8_3.add(panelLabel8_4);
		Jangbapanel.add(panel_8);
		//8888888888888888888888888888888888888888888888888888888888
		
		if(list.size() >= 9) {
		
		
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(0, 1050, 260, 140);
		panel_9.setBorder(new LineBorder(Color.PINK));
		Jangbapanel.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_9_1 = new JPanel();
		panel_9_1.setPreferredSize(new Dimension(80, 140));
		panel_9.add(panel_9_1, BorderLayout.WEST);
		panel_9_1.setLayout(new BorderLayout(0, 0));
		
		ImageIcon jangba9 = new ImageIcon(ShopDetail.class.getResource(list.get(8).getFimage()));
		JLabel panelLabel9_1 = new JLabel(jangba9);
		panelLabel9_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9_1.add(panelLabel9_1);
		
		JPanel panel_9_2 = new JPanel();
		panel_9.add(panel_9_2, BorderLayout.CENTER);
		panel_9_2.setLayout(new BorderLayout(0, 0));
		
		String pr9 = String.valueOf(list.get(8).getPrice());
		String price9 = null;
		if(pr9.length()==5) {
		price9 = pr9.substring(0, 2)+","+pr9.substring(2, 5)+ "원";
		}else {
		price9 = pr9.substring(0, 1)+","+pr9.substring(1, 4)+ "원";
		}
		JLabel panelLabel9_3 = new JLabel(price9);
		panelLabel9_3.setFont(new Font("HY견고딕", Font.PLAIN, 14));
		panelLabel9_3.setVerticalAlignment(SwingConstants.TOP);
		panelLabel9_3.setPreferredSize(new Dimension(80, 50));
		panel_9_2.add(panelLabel9_3, BorderLayout.SOUTH);
		
		JPanel panel_9_3 = new JPanel();
		panel_9_2.add(panel_9_3, BorderLayout.CENTER);
		panel_9_3.setLayout(null);
		
	
		JLabel panelLabel9_2 = new JLabel(list.get(8).getFname());
		panelLabel9_2.setFont(new Font("HY견고딕", Font.PLAIN, 17));
		panelLabel9_2.setBounds(0, 37, 168, 43);
		panel_9_3.add(panelLabel9_2);
		
		JLabel panelLabel9_4 = new JLabel(deleteIcon);
		panelLabel9_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rs = baguniDelete(Jangbaguni.this.list.get(8).getFseq());
					//custom title, custom icon
					//default title and icon
					Jangbaguni frame = new Jangbaguni();
					JOptionPane.showMessageDialog(frame, Jangbaguni.this.list.get(8).getFname() +"이(가) 삭제되었습니다.");
					Jangbaguni.this.setVisible(false);
					frame.setVisible(true);
				
			}
		});
		panelLabel9_4.setBounds(153, 10, 15, 15);
		panel_9_3.add(panelLabel9_4);
		Jangbapanel.add(panel_9);
		//99999999999999999999999999999999999999999999999999999999999999
		
		if(list.size() >= 10) {
		
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(0, 1200, 260, 140);
		panel_10.setBorder(new LineBorder(Color.PINK));
		Jangbapanel.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_10_1 = new JPanel();
		panel_10_1.setPreferredSize(new Dimension(80, 140));
		panel_10.add(panel_10_1, BorderLayout.WEST);
		panel_10_1.setLayout(new BorderLayout(0, 0));
		
		ImageIcon jangba10 = new ImageIcon(ShopDetail.class.getResource(list.get(9).getFimage()));
		JLabel panelLabel10_1 = new JLabel(jangba10);
		panelLabel10_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10_1.add(panelLabel10_1);
		
		JPanel panel_10_2 = new JPanel();
		panel_10.add(panel_10_2, BorderLayout.CENTER);
		panel_10_2.setLayout(new BorderLayout(0, 0));
		
		String pr10 = String.valueOf(list.get(9).getPrice());
		String price10 = null;
		if(pr10.length()==5) {
		price10 = pr10.substring(0, 2)+","+pr10.substring(2, 5)+ "원";
		}else {
		price10 = pr10.substring(0, 1)+","+pr10.substring(1, 4)+ "원";
		}
		JLabel panelLabel10_3 = new JLabel(price10);
		panelLabel10_3.setFont(new Font("HY견고딕", Font.PLAIN, 14));
		panelLabel10_3.setVerticalAlignment(SwingConstants.TOP);
		panelLabel10_3.setPreferredSize(new Dimension(80, 50));
		panel_10_2.add(panelLabel10_3, BorderLayout.SOUTH);
		
		JPanel panel_10_3 = new JPanel();
		panel_10_2.add(panel_10_3, BorderLayout.CENTER);
		panel_10_3.setLayout(null);
		
	
		JLabel panelLabel10_2 = new JLabel(list.get(9).getFname());
		panelLabel10_2.setFont(new Font("HY견고딕", Font.PLAIN, 17));
		panelLabel10_2.setBounds(0, 37, 168, 43);
		panel_10_3.add(panelLabel10_2);
		
		JLabel panelLabel10_4 = new JLabel(deleteIcon);
		panelLabel10_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rs = baguniDelete(Jangbaguni.this.list.get(9).getFseq());
					//custom title, custom icon
					//default title and icon
					Jangbaguni frame = new Jangbaguni();
					JOptionPane.showMessageDialog(frame, Jangbaguni.this.list.get(9).getFname() +"이(가) 삭제되었습니다.");
					Jangbaguni.this.setVisible(false);
					frame.setVisible(true);
				
			}
		});
		panelLabel10_4.setBounds(153, 10, 15, 15);
		panel_10_3.add(panelLabel10_4);
		Jangbapanel.add(panel_10);
		//101010101010101010101010110101010101101010
		
		if(list.size() >= 11) {
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(0, 1350, 260, 140);
		panel_11.setBorder(new LineBorder(Color.PINK));
		Jangbapanel.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_11_1 = new JPanel();
		panel_11_1.setPreferredSize(new Dimension(80, 140));
		panel_11.add(panel_11_1, BorderLayout.WEST);
		panel_11_1.setLayout(new BorderLayout(0, 0));
		
		ImageIcon jangba11 = new ImageIcon(ShopDetail.class.getResource(list.get(10).getFimage()));
		JLabel panelLabel11_1 = new JLabel(jangba11);
		panelLabel11_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_11_1.add(panelLabel11_1);
		
		JPanel panel_11_2 = new JPanel();
		panel_11.add(panel_11_2, BorderLayout.CENTER);
		panel_11_2.setLayout(new BorderLayout(0, 0));
		
		String pr11 = String.valueOf(list.get(10).getPrice());
		String price11 = null;
		if(pr11.length()==5) {
		price11 = pr11.substring(0, 2)+","+pr11.substring(2, 5)+ "원";
		}else {
		price11 = pr11.substring(0, 1)+","+pr11.substring(1, 4)+ "원";
		}
		JLabel panelLabel11_3 = new JLabel(price11);
		panelLabel11_3.setFont(new Font("HY견고딕", Font.PLAIN, 14));
		panelLabel11_3.setVerticalAlignment(SwingConstants.TOP);
		panelLabel11_3.setPreferredSize(new Dimension(80, 50));
		panel_11_2.add(panelLabel11_3, BorderLayout.SOUTH);
		
		JPanel panel_11_3 = new JPanel();
		panel_11_2.add(panel_11_3, BorderLayout.CENTER);
		panel_11_3.setLayout(null);
		
	
		JLabel panelLabel11_2 = new JLabel(list.get(10).getFname());
		panelLabel11_2.setFont(new Font("HY견고딕", Font.PLAIN, 17));
		panelLabel11_2.setBounds(0, 37, 168, 43);
		panel_11_3.add(panelLabel11_2);
		
		JLabel panelLabel11_4 = new JLabel(deleteIcon);
		panelLabel11_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rs = baguniDelete(Jangbaguni.this.list.get(10).getFseq());
					//custom title, custom icon
					//default title and icon
					Jangbaguni frame = new Jangbaguni();
					JOptionPane.showMessageDialog(frame, Jangbaguni.this.list.get(10).getFname() +"이(가) 삭제되었습니다.");
					Jangbaguni.this.setVisible(false);
					frame.setVisible(true);
				
			}
		});
		panelLabel11_4.setBounds(153, 10, 15, 15);
		panel_11_3.add(panelLabel11_4);
		Jangbapanel.add(panel_11);
		//1111111111111111111111111111111111111111111
		
		if(list.size() >= 12) {
		
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(0, 1500, 260, 140);
		panel_12.setBorder(new LineBorder(Color.PINK));
		Jangbapanel.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_12_1 = new JPanel();
		panel_12_1.setPreferredSize(new Dimension(80, 140));
		panel_12.add(panel_12_1, BorderLayout.WEST);
		panel_12_1.setLayout(new BorderLayout(0, 0));
		
		ImageIcon jangba12 = new ImageIcon(ShopDetail.class.getResource(list.get(11).getFimage()));
		JLabel panelLabel12_1 = new JLabel(jangba12);
		panelLabel12_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_12_1.add(panelLabel12_1);
		
		JPanel panel_12_2 = new JPanel();
		panel_12.add(panel_12_2, BorderLayout.CENTER);
		panel_12_2.setLayout(new BorderLayout(0, 0));
		
		String pr12 = String.valueOf(list.get(11).getPrice());
		String price12 = null;
		if(pr12.length()==5) {
		price12 = pr12.substring(0, 2)+","+pr12.substring(2, 5)+ "원";
		}else {
		price12 = pr12.substring(0, 1)+","+pr12.substring(1, 4)+ "원";
		}
		JLabel panelLabel12_3 = new JLabel(price12);
		panelLabel12_3.setFont(new Font("HY견고딕", Font.PLAIN, 14));
		panelLabel12_3.setVerticalAlignment(SwingConstants.TOP);
		panelLabel12_3.setPreferredSize(new Dimension(80, 50));
		panel_12_2.add(panelLabel12_3, BorderLayout.SOUTH);
		
		JPanel panel_12_3 = new JPanel();
		panel_12_2.add(panel_12_3, BorderLayout.CENTER);
		panel_12_3.setLayout(null);
		
	
		JLabel panelLabel12_2 = new JLabel(list.get(11).getFname());
		panelLabel12_2.setFont(new Font("HY견고딕", Font.PLAIN, 17));
		panelLabel12_2.setBounds(0, 37, 168, 43);
		panel_12_3.add(panelLabel12_2);
		
		JLabel panelLabel12_4 = new JLabel(deleteIcon);
		panelLabel12_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rs = baguniDelete(Jangbaguni.this.list.get(11).getFseq());
					//custom title, custom icon
					//default title and icon
					Jangbaguni frame = new Jangbaguni();
					JOptionPane.showMessageDialog(frame, Jangbaguni.this.list.get(11).getFname() +"이(가) 삭제되었습니다.");
					Jangbaguni.this.setVisible(false);
					frame.setVisible(true);
				
			}
		});
		panelLabel12_4.setBounds(153, 10, 15, 15);
		panel_12_3.add(panelLabel12_4);
		Jangbapanel.add(panel_12);
		
		//1212121212121212121212121212121212121212121212121212
		
		if(list.size() >= 13) {
		
		
		JPanel panel_13 = new JPanel();
		panel_13.setBounds(0, 1650, 260, 140);
		panel_13.setBorder(new LineBorder(Color.PINK));
		Jangbapanel.add(panel_13);
		panel_13.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_13_1 = new JPanel();
		panel_13_1.setPreferredSize(new Dimension(80, 140));
		panel_13.add(panel_13_1, BorderLayout.WEST);
		panel_13_1.setLayout(new BorderLayout(0, 0));
		
		ImageIcon jangba13 = new ImageIcon(ShopDetail.class.getResource(list.get(12).getFimage()));
		JLabel panelLabel13_1 = new JLabel(jangba13);
		panelLabel13_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_13_1.add(panelLabel13_1);
		
		JPanel panel_13_2 = new JPanel();
		panel_13.add(panel_13_2, BorderLayout.CENTER);
		panel_13_2.setLayout(new BorderLayout(0, 0));
		
		String pr13 = String.valueOf(list.get(12).getPrice());
		String price13 = null;
		if(pr13.length()==5) {
		price13 = pr13.substring(0, 2)+","+pr13.substring(2, 5)+ "원";
		}else {
		price13 = pr13.substring(0, 1)+","+pr13.substring(1, 4)+ "원";
		}
		JLabel panelLabel13_3 = new JLabel(price13);
		panelLabel13_3.setFont(new Font("HY견고딕", Font.PLAIN, 14));
		panelLabel13_3.setVerticalAlignment(SwingConstants.TOP);
		panelLabel13_3.setPreferredSize(new Dimension(80, 50));
		panel_13_2.add(panelLabel13_3, BorderLayout.SOUTH);
		
		JPanel panel_13_3 = new JPanel();
		panel_13_2.add(panel_13_3, BorderLayout.CENTER);
		panel_13_3.setLayout(null);
		
	
		JLabel panelLabel13_2 = new JLabel(list.get(12).getFname());
		panelLabel13_2.setFont(new Font("HY견고딕", Font.PLAIN, 17));
		panelLabel13_2.setBounds(0, 37, 168, 43);
		panel_13_3.add(panelLabel13_2);
		
		JLabel panelLabel13_4 = new JLabel(deleteIcon);
		panelLabel13_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rs = baguniDelete(Jangbaguni.this.list.get(12).getFseq());
					//custom title, custom icon
					//default title and icon
					Jangbaguni frame = new Jangbaguni();
					JOptionPane.showMessageDialog(frame, Jangbaguni.this.list.get(12).getFname() +"이(가) 삭제되었습니다.");
					Jangbaguni.this.setVisible(false);
					frame.setVisible(true);
				
			}
		});
		panelLabel13_4.setBounds(153, 10, 15, 15);
		panel_13_3.add(panelLabel13_4);
		Jangbapanel.add(panel_13);
		
		//131313131313131313131313131313131313131313131313131313
		
		if(list.size() >= 14) {
		
		
		JPanel panel_14 = new JPanel();
		panel_14.setBounds(0, 1800, 260, 140);
		panel_14.setBorder(new LineBorder(Color.PINK));
		Jangbapanel.add(panel_14);
		panel_14.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_14_1 = new JPanel();
		panel_14_1.setPreferredSize(new Dimension(80, 140));
		panel_14.add(panel_14_1, BorderLayout.WEST);
		panel_14_1.setLayout(new BorderLayout(0, 0));
		
		ImageIcon jangba14 = new ImageIcon(ShopDetail.class.getResource(list.get(13).getFimage()));
		JLabel panelLabel14_1 = new JLabel(jangba14);
		panelLabel14_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_14_1.add(panelLabel14_1);
		
		JPanel panel_14_2 = new JPanel();
		panel_14.add(panel_14_2, BorderLayout.CENTER);
		panel_14_2.setLayout(new BorderLayout(0, 0));
		
		String pr14 = String.valueOf(list.get(13).getPrice());
		String price14 = null;
		if(pr14.length()==5) {
		price14 = pr14.substring(0, 2)+","+pr14.substring(2, 5)+ "원";
		}else {
		price14 = pr14.substring(0, 1)+","+pr14.substring(1, 4)+ "원";
		}
		JLabel panelLabel14_3 = new JLabel(price14);
		panelLabel14_3.setFont(new Font("HY견고딕", Font.PLAIN, 14));
		panelLabel14_3.setVerticalAlignment(SwingConstants.TOP);
		panelLabel14_3.setPreferredSize(new Dimension(80, 50));
		panel_14_2.add(panelLabel14_3, BorderLayout.SOUTH);
		
		JPanel panel_14_3 = new JPanel();
		panel_14_2.add(panel_14_3, BorderLayout.CENTER);
		panel_14_3.setLayout(null);
		
	
		JLabel panelLabel14_2 = new JLabel(list.get(13).getFname());
		panelLabel14_2.setFont(new Font("HY견고딕", Font.PLAIN, 17));
		panelLabel14_2.setBounds(0, 37, 168, 43);
		panel_14_3.add(panelLabel14_2);
		
		JLabel panelLabel14_4 = new JLabel(deleteIcon);
		panelLabel14_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rs = baguniDelete(Jangbaguni.this.list.get(13).getFseq());
					//custom title, custom icon
					//default title and icon
					Jangbaguni frame = new Jangbaguni();
					JOptionPane.showMessageDialog(frame, Jangbaguni.this.list.get(13).getFname() +"이(가) 삭제되었습니다.");
					Jangbaguni.this.setVisible(false);
					frame.setVisible(true);
				
			}
		});
		panelLabel14_4.setBounds(153, 10, 15, 15);
		panel_14_3.add(panelLabel14_4);
		Jangbapanel.add(panel_14);
		
		//141414141414141414141414141414141414141414141414
		
		
		}
		}
		}
		}	
		}
		}
		}
		}
		}
		}
		}
		}
		}
		}
		//if end
		contentPane.add(scrollPane, BorderLayout.CENTER);
	}
	
	
	
	
public static ArrayList<MenuVO> bagunipick2() {
		
		
		ArrayList<MenuVO> list = new ArrayList<MenuVO>();
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBManager dbm = new DBManager();
		try {
			conn = dbm.dbConn();
			String sql = "select fseq, name, image, price from jangbaguni";
			
			pstmt = conn.prepareStatement(sql);
		
			rs =pstmt.executeQuery();
		while(rs.next()) {
			MenuVO mvo = new MenuVO();
			mvo.setFseq(rs.getInt("fseq"));
			mvo.setFname(rs.getString("name"));
			mvo.setFimage(rs.getString("image"));
			mvo.setPrice(rs.getInt("price"));
			
			list.add(mvo);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { 
			dbm.dbClose(rs,pstmt,conn );
		}
	return list;
		
	}

public int baguniDelete(int fseq) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	int rs = 0;
	DBManager dbm = new DBManager();
	try {
		conn = dbm.dbConn();
		String sql = "delete from jangbaguni where fseq = ?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, fseq);
		
		rs =pstmt.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally { 
		dbm.dbClose(pstmt,conn);
	}


	return rs;
};

public int baguniAllDelete() {
	Connection conn = null;
	PreparedStatement pstmt = null;
	int rs = 0;
	DBManager dbm = new DBManager();
	try {
		conn = dbm.dbConn();
		String sql = "delete from jangbaguni";
		pstmt = conn.prepareStatement(sql);
		
		rs =pstmt.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally { 
		dbm.dbClose(pstmt,conn);
	}


	return rs;
};


}
