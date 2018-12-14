package com.kosmo.javaproject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout.Alignment;


import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.border.LineBorder;

import com.kosmo.javaproject.DBManager;

public class ShopList {

	private JFrame frmform;
	private CardLayout CardLay;
	private JPanel mainPanel;
	ShopDetail menuFrame;
	ArrayList<ShopVO> slist;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopList window = new ShopList();
					window.frmform.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShopList() {
		frmform = new JFrame();
		frmform.setFocusTraversalKeysEnabled(false);
		frmform.setTitle("배달앱FORM");
		frmform.setBounds(100, 100, 300, 560);
		frmform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmform.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmform.getContentPane().add(panel, BorderLayout.NORTH);
		
		 JButton btnChicken = new JButton("치킨");
			btnChicken.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLay.show(mainPanel, "chicken");
				}
			});
			panel.add(btnChicken);
			
			JButton btnPizza = new JButton("피자");
			btnPizza.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLay.show(mainPanel, "pizza");
				}
			});
			panel.add(btnPizza);
			
			JButton btnJazang = new JButton("짜장");
			btnJazang.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLay.show(mainPanel, "jazang");
				}
			});
			panel.add(btnJazang);
			
			JButton btnPigfoot = new JButton("족발");
			btnPigfoot.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLay.show(mainPanel, "pigfoot");
				}
			});
			panel.add(btnPigfoot);
		
		mainPanel = new JPanel();
		frmform.getContentPane().add(mainPanel, BorderLayout.CENTER);
		
		   
		
		
		CardLay = new CardLayout(); 
	      mainPanel.setLayout(CardLay);
	    
	      slist = shoppick();
	      
		
	      
	      JPanel card1 = new JPanel();
	      mainPanel.add( card1, "chicken" ); // add carddeck
	      
	      JPanel chickenPanel_1 = new JPanel();
	      chickenPanel_1.addMouseListener(new MouseAdapter() {
	      	@Override
	      	public void mouseClicked(MouseEvent e) {
	      		System.out.println("네네통닭");
	      		
	      		ArrayList<MenuVO> list = menupick(slist.get(0).getSseq());
	      		
	      		menuFrame = new ShopDetail(list);
	      		menuFrame.setVisible(true);
	      		
	      	}
	      });
	      
	      JPanel chickenPanel_2 = new JPanel();
	      chickenPanel_2.addMouseListener(new MouseAdapter() {
	      	@Override
	      	public void mouseClicked(MouseEvent e) {
	      		System.out.println("굽네통닭");
	      		
	      		ArrayList<MenuVO> list = menupick(slist.get(1).getSseq());
	      		
	      		menuFrame = new ShopDetail(list);
	      		menuFrame.setVisible(true);
	      	}
	      });
	      
	      
	      
	      
	      GroupLayout gl_card1 = new GroupLayout(card1);
	      gl_card1.setHorizontalGroup(
	      	gl_card1.createParallelGroup(Alignment.LEADING)
	      		.addComponent(chickenPanel_1, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
	      		.addGroup(gl_card1.createSequentialGroup()
	      			.addComponent(chickenPanel_2, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
	      			.addContainerGap(71, Short.MAX_VALUE))
	      );
	      gl_card1.setVerticalGroup(
	      	gl_card1.createParallelGroup(Alignment.LEADING)
	      		.addGroup(gl_card1.createSequentialGroup()
	      			.addComponent(chickenPanel_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
	      			.addPreferredGap(ComponentPlacement.RELATED)
	      			.addComponent(chickenPanel_2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
	      			.addContainerGap(222, Short.MAX_VALUE))
	      );
	      chickenPanel_1.setLayout(new BorderLayout(0, 0));
	      chickenPanel_2.setLayout(new BorderLayout(0, 0));
	      
	      ImageIcon nenechic = new ImageIcon(ShopList.class.getResource(slist.get(0).getImage()));
	      JLabel chickenLabel1_1 = new JLabel(nenechic);
	      chickenPanel_1.setPreferredSize(new Dimension(80, 80));
	      chickenPanel_1.add(chickenLabel1_1, BorderLayout.WEST);
	      
	      JLabel chickenLabel1_2 = new JLabel(slist.get(0).getName());
	      chickenLabel1_2.setFont(new Font("HY견고딕", Font.PLAIN, 18));
	      chickenPanel_1.add(chickenLabel1_2, BorderLayout.CENTER);
	      
	      
	      ImageIcon gubnechic = new ImageIcon(ShopList.class.getResource(slist.get(1).getImage()));
	      JLabel chickenLabel2_1 = new JLabel(gubnechic);
	      chickenPanel_1.setPreferredSize(new Dimension(80, 80));
	      chickenPanel_2.add(chickenLabel2_1, BorderLayout.WEST);
	      
	      JLabel chickenLabel2_2 = new JLabel(slist.get(1).getName());
	      chickenPanel_2.add(chickenLabel2_2, BorderLayout.CENTER);
	      chickenLabel2_2.setFont(new Font("HY견고딕", Font.PLAIN, 18));
	      
	      card1.setLayout(gl_card1);
	      
	      
	      
	      
	      
	      
	      JPanel card2 = new JPanel();
	      mainPanel.add( card2, "pizza" ); // add card to deck
	      
	      JPanel pizzaPanel_1 = new JPanel();
	      pizzaPanel_1.addMouseListener(new MouseAdapter() {
	      	@Override
	      	public void mouseClicked(MouseEvent e) {
	      		System.out.println("피자글릭");
	      		
	      		ArrayList<MenuVO> list = menupick(slist.get(2).getSseq());
	      		
	      		menuFrame = new ShopDetail(list);
	      		menuFrame.setVisible(true);
	      		
	      	}
	      });
	      
	      JPanel pizzaPanel_2 = new JPanel();
	      pizzaPanel_2.addMouseListener(new MouseAdapter() {
	      	@Override
	      	public void mouseClicked(MouseEvent e) {
	      		System.out.println("피자꾼");
	      		
	      		ArrayList<MenuVO> list = menupick(slist.get(3).getSseq());
	      		
	      		menuFrame = new ShopDetail(list);
	      		menuFrame.setVisible(true);
	      	}
	      });
	      
	      
	      
	      
	      GroupLayout gl_card2 = new GroupLayout(card2);
	      gl_card2.setHorizontalGroup(
	      	gl_card2.createParallelGroup(Alignment.LEADING)
	      		.addComponent(pizzaPanel_1, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
	      		.addGroup(gl_card2.createSequentialGroup()
	      			.addComponent(pizzaPanel_2, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
	      			.addContainerGap(71, Short.MAX_VALUE))
	      );
	      gl_card2.setVerticalGroup(
	      	gl_card2.createParallelGroup(Alignment.LEADING)
	      		.addGroup(gl_card2.createSequentialGroup()
	      			.addComponent(pizzaPanel_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
	      			.addPreferredGap(ComponentPlacement.RELATED)
	      			.addComponent(pizzaPanel_2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
	      			.addContainerGap(222, Short.MAX_VALUE))
	      );
	      pizzaPanel_1.setLayout(new BorderLayout(0, 0));
	      pizzaPanel_2.setLayout(new BorderLayout(0, 0));
	      
	      ImageIcon pizzaimg1 = new ImageIcon(ShopList.class.getResource(slist.get(2).getImage()));
	      JLabel pizzaLabel1_1 = new JLabel(pizzaimg1);
	      pizzaPanel_1.setPreferredSize(new Dimension(80, 80));
	      pizzaPanel_1.add(pizzaLabel1_1, BorderLayout.WEST);
	      
	      JLabel pizzaLabel1_2 = new JLabel(slist.get(2).getName());
	      pizzaLabel1_2.setFont(new Font("HY견고딕", Font.PLAIN, 18));
	      pizzaPanel_1.add(pizzaLabel1_2, BorderLayout.CENTER);
	      
	      
	      ImageIcon pizzaimg2 = new ImageIcon(ShopList.class.getResource(slist.get(3).getImage()));
	      JLabel pizzaLabel2_1 = new JLabel(pizzaimg2);
	      pizzaPanel_1.setPreferredSize(new Dimension(80, 80));
	      pizzaPanel_2.add(pizzaLabel2_1, BorderLayout.WEST);
	      
	      JLabel pizzaLabel2_2 = new JLabel(slist.get(3).getName());
	      pizzaPanel_2.add(pizzaLabel2_2, BorderLayout.CENTER);
	      pizzaLabel2_2.setFont(new Font("HY견고딕", Font.PLAIN, 18));
	      
	      card2.setLayout(gl_card2);
	      
	      
	      JPanel card3 = new JPanel();
	      mainPanel.add( card3, "jazang" ); // add card to deck
	      
	      JPanel jazangPanel_1 = new JPanel();
	      jazangPanel_1.addMouseListener(new MouseAdapter() {
	      	@Override
	      	public void mouseClicked(MouseEvent e) {
	      		System.out.println("락궁");
	      		
	      		ArrayList<MenuVO> list = menupick(slist.get(4).getSseq());
	      		
	      		menuFrame = new ShopDetail(list);
	      		menuFrame.setVisible(true);
	      		
	      	}
	      });
	      
	      JPanel jazangPanel_2 = new JPanel();
	      jazangPanel_2.addMouseListener(new MouseAdapter() {
	      	@Override
	      	public void mouseClicked(MouseEvent e) {
	      		System.out.println("요리왕");
	      		
	      		ArrayList<MenuVO> list = menupick(slist.get(5).getSseq());
	      		
	      		menuFrame = new ShopDetail(list);
	      		menuFrame.setVisible(true);
	      	}
	      });
	      
	      
	      
	      
	      GroupLayout gl_card3 = new GroupLayout(card3);
	      gl_card3.setHorizontalGroup(
	      	gl_card3.createParallelGroup(Alignment.LEADING)
	      		.addComponent(jazangPanel_1, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
	      		.addGroup(gl_card3.createSequentialGroup()
	      			.addComponent(jazangPanel_2, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
	      			.addContainerGap(71, Short.MAX_VALUE))
	      );
	      gl_card3.setVerticalGroup(
	      	gl_card3.createParallelGroup(Alignment.LEADING)
	      		.addGroup(gl_card3.createSequentialGroup()
	      			.addComponent(jazangPanel_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
	      			.addPreferredGap(ComponentPlacement.RELATED)
	      			.addComponent(jazangPanel_2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
	      			.addContainerGap(222, Short.MAX_VALUE))
	      );
	      jazangPanel_1.setLayout(new BorderLayout(0, 0));
	      jazangPanel_2.setLayout(new BorderLayout(0, 0));
	      
	      ImageIcon jazangimg1 = new ImageIcon(ShopList.class.getResource(slist.get(4).getImage()));
	      JLabel jazangLabel1_1 = new JLabel(jazangimg1);
	      jazangPanel_1.setPreferredSize(new Dimension(80, 80));
	      jazangPanel_1.add(jazangLabel1_1, BorderLayout.WEST);
	      
	      JLabel jazangLabel1_2 = new JLabel(slist.get(4).getName());
	      jazangLabel1_2.setFont(new Font("HY견고딕", Font.PLAIN, 18));
	      jazangPanel_1.add(jazangLabel1_2, BorderLayout.CENTER);
	      
	      
	      ImageIcon jazangimg2 = new ImageIcon(ShopList.class.getResource(slist.get(5).getImage()));
	      JLabel jazangLabel2_1 = new JLabel(jazangimg2);
	      jazangPanel_1.setPreferredSize(new Dimension(80, 80));
	      jazangPanel_2.add(jazangLabel2_1, BorderLayout.WEST);
	      
	      JLabel jazangLabel2_2 = new JLabel(slist.get(5).getName());
	      jazangPanel_2.add(jazangLabel2_2, BorderLayout.CENTER);
	      jazangLabel2_2.setFont(new Font("HY견고딕", Font.PLAIN, 18));
	      
	      card3.setLayout(gl_card3);
	      
	      
	      
	     
	      JPanel card4 = new JPanel();
	      mainPanel.add( card4, "pigfoot" ); // add card to deck
	      
	      JPanel pigputPanel_1 = new JPanel();
	      pigputPanel_1.addMouseListener(new MouseAdapter() {
	      	@Override
	      	public void mouseClicked(MouseEvent e) {
	      		System.out.println("장충동족발");
	      		
	      		ArrayList<MenuVO> list = menupick(slist.get(6).getSseq());
	      		
	      		menuFrame = new ShopDetail(list);
	      		menuFrame.setVisible(true);
	      		
	      	}
	      });
	      
	      JPanel pigputPanel_2 = new JPanel();
	      pigputPanel_2.addMouseListener(new MouseAdapter() {
	      	@Override
	      	public void mouseClicked(MouseEvent e) {
	      		System.out.println("장수족발");
	      		
	      		ArrayList<MenuVO> list = menupick(slist.get(7).getSseq());
	      		
	      		menuFrame = new ShopDetail(list);
	      		menuFrame.setVisible(true);
	      	}
	      });
	      
	      
	      
	      
	      GroupLayout gl_card4 = new GroupLayout(card4);
	      gl_card4.setHorizontalGroup(
	      	gl_card4.createParallelGroup(Alignment.LEADING)
	      		.addComponent(pigputPanel_1, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
	      		.addGroup(gl_card4.createSequentialGroup()
	      			.addComponent(pigputPanel_2, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
	      			.addContainerGap(71, Short.MAX_VALUE))
	      );
	      gl_card4.setVerticalGroup(
	      	gl_card4.createParallelGroup(Alignment.LEADING)
	      		.addGroup(gl_card4.createSequentialGroup()
	      			.addComponent(pigputPanel_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
	      			.addPreferredGap(ComponentPlacement.RELATED)
	      			.addComponent(pigputPanel_2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
	      			.addContainerGap(222, Short.MAX_VALUE))
	      );
	      pigputPanel_1.setLayout(new BorderLayout(0, 0));
	      pigputPanel_2.setLayout(new BorderLayout(0, 0));
	      
	      ImageIcon pigputimg1 = new ImageIcon(ShopList.class.getResource(slist.get(6).getImage()));
	      JLabel pigputLabel1_1 = new JLabel(pigputimg1);
	      pigputPanel_1.setPreferredSize(new Dimension(80, 80));
	      pigputPanel_1.add(pigputLabel1_1, BorderLayout.WEST);
	      
	      JLabel pigputLabel1_2 = new JLabel(slist.get(6).getName());
	      pigputLabel1_2.setFont(new Font("HY견고딕", Font.PLAIN, 18));
	      pigputPanel_1.add(pigputLabel1_2, BorderLayout.CENTER);
	      
	      
	      ImageIcon pigputimg2 = new ImageIcon(ShopList.class.getResource(slist.get(7).getImage()));
	      JLabel pigputLabel2_1 = new JLabel(pigputimg2);
	      pigputPanel_1.setPreferredSize(new Dimension(80, 80));
	      pigputPanel_2.add(pigputLabel2_1, BorderLayout.WEST);
	      
	      JLabel pigputLabel2_2 = new JLabel(slist.get(7).getName());
	      pigputPanel_2.add(pigputLabel2_2, BorderLayout.CENTER);
	      pigputLabel2_2.setFont(new Font("HY견고딕", Font.PLAIN, 18));
	      
	      card4.setLayout(gl_card4);
	      
	     
	      
	}
	
	
	public static ArrayList<MenuVO> menupick(int shopnum) {
		
		
		ArrayList<MenuVO> list = new ArrayList<MenuVO>();
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBManager dbm = new DBManager();
		try {
			conn = dbm.dbConn();
			String sql = "select s.name as sname ,  f.name as fname , price , s.image as simage , f.image as fimage , f.fseq from shop s, food f where s.sseq = f.sseq and s.sseq = ?";
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setInt(1, shopnum);
			
			rs =pstmt.executeQuery();
		while(rs.next()) {
			MenuVO mvo = new MenuVO();
			mvo.setFseq(rs.getInt("fseq"));
			mvo.setSname(rs.getString("sname"));
			mvo.setFname(rs.getString("fname"));
			mvo.setPrice(rs.getInt("price"));
			mvo.setSimage(rs.getString("simage"));
			mvo.setFimage(rs.getString("fimage"));
			
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
	
public static ArrayList<ShopVO> shoppick() {
		
	    ArrayList<ShopVO> list = new ArrayList<ShopVO>();
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBManager dbm = new DBManager();
		try {
			conn = dbm.dbConn();
			String sql = "select name, image, sseq from shop order by sseq";
			pstmt = conn.prepareStatement(sql);
			
			rs =pstmt.executeQuery();
			
			while(rs.next()) {
			ShopVO svo = new ShopVO();
			
			svo.setSseq(rs.getInt("sseq"));
			svo.setName(rs.getString("name"));
			svo.setImage(rs.getString("image"));
			
			list.add(svo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { 
			dbm.dbClose(rs,pstmt,conn );
		}
	return list;
		
	}
	
	
	
	
	
}
