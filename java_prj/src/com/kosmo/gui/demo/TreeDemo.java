package com.kosmo.gui.demo;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import java.net.URL;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class TreeDemo extends JPanel
                      implements TreeSelectionListener {
    private JEditorPane htmlPane;
    private JTree tree;
    DefaultTreeModel treeModel;
    DefaultMutableTreeNode top;
    
    JFrame frame;
    private JPanel panel;
    private JButton addButton;
    private JButton removeButton;
    private JTextField textField;
    
    public static void main(String[] args) {
    	EventQueue.invokeLater(new Runnable() {
            public void run() {
            	TreeDemo window = new TreeDemo();
				window.frame.pack();
				window.frame.setVisible(true);
            }
        });
    }
    
    
    
    public TreeDemo() {
//    	if (useSystemLookAndFeel) {
//            try {
//                UIManager.setLookAndFeel(
//                    UIManager.getSystemLookAndFeelClassName());
//            } catch (Exception e) {
//                System.err.println("Couldn't use system look and feel.");
//            }
//        }

        //Create and set up the window.
        frame = new JFrame("TreeDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 450, 300);
        

        //Create the nodes.
        //------------------------------------
        top = new DefaultMutableTreeNode("KOSMO회사");
        createNodes(top);
        treeModel = new DefaultTreeModel(top);
        tree = new JTree(treeModel);
        //------------------------------------
        
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.addTreeSelectionListener(this);
        
        panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        
        addButton = new JButton("ADD");
        addButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
//        		DefaultMutableTreeNode childNode = 
//        				new DefaultMutableTreeNode("NEW-ID");
        		
        		
        		String myName = textField.getText();
        		if(myName.equals("") || myName ==null) {
        			myName = "NEW-ID";
        		}
        		BookInfoVO vo = new BookInfoVO(myName,"2322");
        		DefaultMutableTreeNode newNode = 
        				new DefaultMutableTreeNode(vo.getId());
                
        		
        		DefaultMutableTreeNode parentNode = null;
        		TreePath selectionPath = tree.getSelectionPath();

        		if (selectionPath == null) {
        			parentNode = top;
        		} else {
        			parentNode = (DefaultMutableTreeNode)
        					(selectionPath.getLastPathComponent());
        			if (parentNode == null) {
        				parentNode = top;
        			}
        		}

        		treeModel.insertNodeInto(newNode, parentNode, 
        				parentNode.getChildCount());
        		tree.scrollPathToVisible(new TreePath(newNode.getPath()));
        		
        	}
        });
        
        textField = new JTextField();
        panel.add(textField);
        textField.setColumns(10);
        panel.add(addButton);
        
        removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		TreePath selectionPath = tree.getSelectionPath(); 
        		DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode)
        					(selectionPath.getLastPathComponent());
        	    treeModel.removeNodeFromParent(currentNode);
        		
        	}
        });
        panel.add(removeButton);
        JScrollPane topScroll = new JScrollPane(tree);
        topScroll.setPreferredSize(new Dimension(100,50));
        
        //Create the HTML viewing pane.
        htmlPane = new JEditorPane();
        htmlPane.setEditable(false);
        ////initHelp();
        JScrollPane buttomScroll = new JScrollPane(htmlPane);
        buttomScroll.setPreferredSize(new Dimension(100,50));
        
        
        //Add the scroll panes to a split pane.
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setTopComponent(topScroll);
        splitPane.setBottomComponent(buttomScroll);
        splitPane.setPreferredSize(new Dimension(500, 300));
        splitPane.setDividerLocation(100); 

//        Dimension minimumSize = new Dimension(100, 50);
//        buttomScroll.setMinimumSize(minimumSize);
//        topScroll.setMinimumSize(minimumSize);

        //Add the split pane to this panel.
        frame.getContentPane().add(splitPane);
        
        //Display the window.
//        frame.pack();
//        frame.setVisible(true);
    }

    //-------------------------------------------
    @Override
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                           tree.getLastSelectedPathComponent();

        
       
        if (node == null) return;

        //if (node.isLeaf()) {
        //	BookInfoVO vo = (BookInfoVO)node.getUserObject();
        //    htmlPane.setText(vo.getId() + "," + vo.getPw());
        // } else {
        	htmlPane.setText("선택 노드값:" + node.toString()); 
        //}
      
    }
    
    //-------------------------------------------
    private class BookInfoVO {
        public String id;
        public String pw;

        public BookInfoVO(String aaa, String bbb) {
            this.id = aaa;
            this.pw = bbb;
        }
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}

		public String getPw() {
			return pw;
		}
		public void setPw(String pw) {
			this.pw = pw;
		}
		public String toString() {
            return this.id;
        }
        
    }
    
//    private void initHelpsss() {
//        String s = "TreeDemoHelp.html";
//        helpURL = getClass().getResource(s);
//        if (helpURL == null) {
//            System.err.println("Couldn't open help file: " + s);
//        } else if (DEBUG) {
//            System.out.println("Help URL is " + helpURL);
//        }
//
//        displayURL(helpURL);
//    }

//    private void displayURLsss(URL url) {
//        try {
//            if (url != null) {
//                htmlPane.setPage(url);
//            } else { //null url
//            	htmlPane.setText("File Not Found");
//                if (DEBUG) {
//                    System.out.println("Attempted to display a null URL.");
//                }
//            }
//        } catch (IOException e) {
//            System.err.println("Attempted to read a bad URL: " + url);
//        }
//    }

    private void createNodes(DefaultMutableTreeNode top) {
        
        DefaultMutableTreeNode leafnode = null;

        DefaultMutableTreeNode topsub1 = new DefaultMutableTreeNode("영업부");
        top.add(topsub1);

        //original Tutorial
        BookInfoVO vo = null;
        
        vo = new BookInfoVO("park","333");
	    leafnode = new DefaultMutableTreeNode(vo.getId());
	    topsub1.add(leafnode);
	   
        vo = new BookInfoVO("kim","222");
        leafnode = new DefaultMutableTreeNode(vo.getId());
        topsub1.add(leafnode);

        //---------------------------------
        DefaultMutableTreeNode topsub2 = new DefaultMutableTreeNode("개발부");
        top.add(topsub2);
        
        //VM
        leafnode= new DefaultMutableTreeNode(new BookInfoVO("lee","111"));
        topsub2.add(leafnode);

    }
        
  
    
}