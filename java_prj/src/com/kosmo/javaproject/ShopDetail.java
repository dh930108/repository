package com.kosmo.javaproject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.kosmo.gui.demo.IconTest;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.ScrollPane;
import java.util.ArrayList;
import java.util.concurrent.Phaser;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShopDetail extends JFrame {

	private JPanel contentPane;
	boolean switch1, switch2, switch3, switch4, switch5, switch6;
	
	
	public ShopDetail(ArrayList<MenuVO> list) {
		
		
		
		MenuVO smvo = list.get(0);
		
		
		setTitle(list.get(0).getSname());
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel northpanel = new JPanel();
		northpanel.setPreferredSize(new Dimension(300, 110));
		contentPane.add(northpanel, BorderLayout.NORTH);
		
		
		ImageIcon shopImage = new ImageIcon(ShopDetail.class.getResource(smvo.getSimage()));
		northpanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblIcon = new JLabel(shopImage);
		northpanel.add(lblIcon, BorderLayout.NORTH);
		
		JLabel lbShopName = new JLabel(smvo.getSname());
		lbShopName.setFont(new Font("HY견고딕", Font.PLAIN, 16));
		lbShopName.setVerticalAlignment(SwingConstants.CENTER);
		lbShopName.setHorizontalAlignment(SwingConstants.CENTER);
		northpanel.add(lbShopName);
		
		JPanel SouthPanel = new JPanel();
		contentPane.add(SouthPanel, BorderLayout.SOUTH);
		
		JButton btnJangbaguni = new JButton("장바구니 담기");
		btnJangbaguni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(switch1 == true) {
					MenuVO mvo = foodpick(list.get(0).getFseq());
					int rs = baguniInsert(mvo);
					System.out.println(rs);
				}
				if(switch2 == true) {
					MenuVO mvo = foodpick(list.get(1).getFseq());
					int rs = baguniInsert(mvo);
					System.out.println(rs);
				}
				if(switch3 == true) {
					MenuVO mvo = foodpick(list.get(2).getFseq());
					int rs = baguniInsert(mvo);
					System.out.println(rs);
				}
				if(switch4 == true) {
					MenuVO mvo = foodpick(list.get(3).getFseq());
					int rs = baguniInsert(mvo);
					System.out.println(rs);
				}
				if(switch5 == true) {
					MenuVO mvo = foodpick(list.get(4).getFseq());
					int rs = baguniInsert(mvo);
					System.out.println(rs);
				}
				if(switch6 == true) {
					MenuVO mvo = foodpick(list.get(5).getFseq());
					int rs = baguniInsert(mvo);
					System.out.println(rs);
				}
				
				
			}
		});
		SouthPanel.add(btnJangbaguni);
		btnJangbaguni.setFont(new Font("HY견고딕", Font.PLAIN, 15));
		
		JButton btnJangbago = new JButton("장바구니 이동");
		btnJangbago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Jangbaguni baguni = new Jangbaguni();
				baguni.setVisible(true);
				
				
			}
		});
		btnJangbago.setFont(new Font("HY견고딕", Font.PLAIN, 15));
		SouthPanel.add(btnJangbago);
		
		JPanel centerPanel =  new JPanel();
		centerPanel.setPreferredSize(new Dimension(250, 400));
		JScrollPane centerScroll = new JScrollPane(centerPanel);
		centerScroll.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		centerPanel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(switch1 == false) {
				panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				panel_1.setBackground(Color.PINK);
				}else
				{
				panel_1.setBorder(UIManager.getBorder("PanelUI"));
				panel_1.setBackground(UIManager.getColor("Panel.background"));
				}
				switch1 = !switch1;
			    System.out.println(switch1);
			}
		});
		panel_1.setBounds(10, 10, 125, 125);
		centerPanel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
			
		ImageIcon nenechic1 = new ImageIcon(ShopDetail.class.getResource(list.get(0).getFimage()));
		JLabel lblChicken_1_1 = new JLabel(nenechic1);
		panel_1.add(lblChicken_1_1, BorderLayout.NORTH);
		
		JLabel lblChicken_1_2 = new JLabel(list.get(0).getFname());
		panel_1.add(lblChicken_1_2, BorderLayout.CENTER);
		
		
		String pr1 = String.valueOf(list.get(0).getPrice());
		String price1 = null;
		if(pr1.length()==5) {
		price1 = pr1.substring(0, 2)+","+pr1.substring(2, 5)+ "원";
		}else {
		price1 = pr1.substring(0, 1)+","+pr1.substring(1, 4)+ "원";
		}
		JLabel lblChicken_1_3 = new JLabel(price1);
		panel_1.add(lblChicken_1_3, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(switch2 == false) {
				panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				panel_2.setBackground(Color.PINK);
				}else
				{
				panel_2.setBorder(UIManager.getBorder("PanelUI"));
				panel_2.setBackground(UIManager.getColor("Panel.background"));
				}
				switch2 = !switch2;
			    System.out.println(switch2);
			}
		});
		panel_2.setBounds(135, 10, 125, 125);
		centerPanel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		ImageIcon nenechic2 = new ImageIcon(ShopDetail.class.getResource(list.get(1).getFimage()));
		JLabel lblChicken_2_1 = new JLabel(nenechic2);
		panel_2.add(lblChicken_2_1, BorderLayout.NORTH);
		
		JLabel lblChicken_2_2 = new JLabel(list.get(1).getFname());
		panel_2.add(lblChicken_2_2, BorderLayout.CENTER);
		
		
		String pr2 = String.valueOf(list.get(1).getPrice());
		String price2 = null;
		if(pr2.length()==5) {
		price2 = pr2.substring(0, 2)+","+pr2.substring(2, 5)+ "원";
		}else {
		price2 = pr2.substring(0, 1)+","+pr2.substring(1, 4)+ "원";
		}
		JLabel lblChicken_2_3 = new JLabel(price2);
		panel_2.add(lblChicken_2_3, BorderLayout.SOUTH);

		
		JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(switch3 == false) {
				panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				panel_3.setBackground(Color.PINK);
				}else
				{
				panel_3.setBorder(UIManager.getBorder("PanelUI"));
				panel_3.setBackground(UIManager.getColor("Panel.background"));
				}
				switch3 = !switch3;
			    System.out.println(switch3);
			}
		});
		panel_3.setBounds(10, 135, 125, 125);
		centerPanel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		ImageIcon nenechic3 = new ImageIcon(ShopDetail.class.getResource(list.get(2).getFimage()));
		JLabel lblChicken_3_1 = new JLabel(nenechic3);
		panel_3.add(lblChicken_3_1, BorderLayout.NORTH);
		
		JLabel lblChicken_3_2 = new JLabel(list.get(2).getFname());
		panel_3.add(lblChicken_3_2, BorderLayout.CENTER);
		
		
		String pr3 = String.valueOf(list.get(2).getPrice());
		String price3 = null;
		if(pr3.length()==5) {
		price3 = pr3.substring(0, 2)+","+pr3.substring(2, 5)+ "원";
		}else {
		price3 = pr3.substring(0, 1)+","+pr3.substring(1, 4)+ "원";
		}
		JLabel lblChicken_3_3 = new JLabel(price3);
		panel_3.add(lblChicken_3_3, BorderLayout.SOUTH);
		
		
		//-----이런 if 문으로 컴포넌트 갯수 제어
		if(list.size()>3) {
			
		
		
		JPanel panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(switch4 == false) {
				panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				panel_4.setBackground(Color.PINK);
				}else
				{
				panel_4.setBorder(UIManager.getBorder("PanelUI"));
				panel_4.setBackground(UIManager.getColor("Panel.background"));
				}
				switch4 = !switch4;
			    System.out.println(switch4);
			}
		});
		panel_4.setBounds(135, 135, 125, 125);
		centerPanel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		ImageIcon nenechic4 = new ImageIcon(ShopDetail.class.getResource(list.get(3).getFimage()));
		JLabel lblChicken_4_1 = new JLabel(nenechic4);
		panel_4.add(lblChicken_4_1, BorderLayout.NORTH);
		
		JLabel lblChicken_4_2 = new JLabel(list.get(3).getFname());
		panel_4.add(lblChicken_4_2, BorderLayout.CENTER);
		
		
		String pr4 = String.valueOf(list.get(3).getPrice());
		String price4 = null;
		if(pr4.length()==5) {
		price4 = pr4.substring(0, 2)+","+pr4.substring(2, 5)+ "원";
		}else {
		price4 = pr4.substring(0, 1)+","+pr4.substring(1, 4)+ "원";
		}
		JLabel lblChicken_4_3 = new JLabel(price4);
		panel_4.add(lblChicken_4_3, BorderLayout.SOUTH);
		
		
		
		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(switch5 == false) {
				panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				panel_5.setBackground(Color.PINK);
				}else
				{
				panel_5.setBorder(UIManager.getBorder("PanelUI"));
				panel_5.setBackground(UIManager.getColor("Panel.background"));
				}
				switch5 = !switch5;
			    System.out.println(switch5);
			}
		});
		panel_5.setBounds(10, 260, 125, 125);
		centerPanel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		ImageIcon nenechic5 = new ImageIcon(ShopDetail.class.getResource(list.get(4).getFimage()));
		JLabel lblChicken_5_1 = new JLabel(nenechic5);
		panel_5.add(lblChicken_5_1, BorderLayout.NORTH);
		
		JLabel lblChicken_5_2 = new JLabel(list.get(4).getFname());
		panel_5.add(lblChicken_5_2, BorderLayout.CENTER);
		
		
		String pr5 = String.valueOf(list.get(4).getPrice());
		String price5 = null;
		if(pr5.length()==5) {
		price5 = pr5.substring(0, 2)+","+pr5.substring(2, 5)+ "원";
		}else {
		price5 = pr5.substring(0, 1)+","+pr5.substring(1, 4)+ "원";
		}
		JLabel lblChicken_5_3 = new JLabel(price5);
		panel_5.add(lblChicken_5_3, BorderLayout.SOUTH);
		
		JPanel panel_6 = new JPanel();
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(switch6 == false) {
				panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				panel_6.setBackground(Color.PINK);
				}else
				{
				panel_6.setBorder(UIManager.getBorder("PanelUI"));
				panel_6.setBackground(UIManager.getColor("Panel.background"));
				}
				switch6 = !switch6;
			    System.out.println(switch6);
			}
		});
		panel_6.setBounds(135, 260, 125, 125);
		centerPanel.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		ImageIcon nenechic6 = new ImageIcon(ShopDetail.class.getResource(list.get(5).getFimage()));
		JLabel lblChicken_6_1 = new JLabel(nenechic6);
		panel_6.add(lblChicken_6_1, BorderLayout.NORTH);
		
		JLabel lblChicken_6_2 = new JLabel(list.get(5).getFname());
		panel_6.add(lblChicken_6_2, BorderLayout.CENTER);
		
		
		String pr6 = String.valueOf(list.get(5).getPrice());
		String price6 = null;
		if(pr6.length()==5) {
		price6 = pr6.substring(0, 2)+","+pr6.substring(2, 5)+ "원";
		}else {
		price6 = pr6.substring(0, 1)+","+pr6.substring(1, 4)+ "원";
		}
		JLabel lblChicken_6_3 = new JLabel(price6);
		panel_6.add(lblChicken_6_3, BorderLayout.SOUTH);
		
		
		contentPane.add(centerScroll, BorderLayout.CENTER);
		
		}
		else {
		contentPane.add(centerScroll, BorderLayout.CENTER);
		}
		//---------------------------
	
	}
	
	
	
	
	public static MenuVO foodpick(int fseq) {
		
		MenuVO mvo = new MenuVO();
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBManager dbm = new DBManager();
		try {
			conn = dbm.dbConn();
			String sql = "select fseq, name, image, price from food where fseq = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, fseq);
			
			rs =pstmt.executeQuery();
			
			rs.next();
			
			
			
			mvo.setFseq(rs.getInt("fseq"));
			mvo.setFname(rs.getString("name"));
			mvo.setFimage(rs.getString("image"));
			mvo.setPrice(rs.getInt("price"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { 
			dbm.dbClose(rs,pstmt,conn );
		}
	return mvo;
		
	}

	public int baguniInsert(MenuVO mvo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		DBManager dbm = new DBManager();
		try {
			conn = dbm.dbConn();
			String sql = "insert into jangbaguni (FSEQ,NAME,IMAGE,PRICE) values (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setInt(1, mvo.getFseq());
			pstmt.setString(2,mvo.getFname());
			pstmt.setString(3, mvo.getFimage());
			pstmt.setInt(4, mvo.getPrice());
			
			
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
