package com.kosmo.gui.demo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class MyList2 extends JPanel implements ListSelectionListener{
		
	JList list;
	DefaultListModel listModel;
	private JFrame frame;
	JButton btnDel;
	JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MyList window = new MyList();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	JFrame frame = new JFrame();
        		frame.setBounds(100, 100, 450, 300);
        		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        		 JComponent newContentPane = new MyList2();
        	        newContentPane.setOpaque(true); //content panes must be opaque
        	        frame.setContentPane(newContentPane);
        	        
        	        frame.pack();
        	        frame.setVisible(true);
                
            }
        });
	}
	
	
	public MyList2() { 
//		frame = new JFrame();
//		frame.setBounds(100, 100, 450, 300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		 //Create and set up the content pane.
       
 
       
	
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		
		
		JButton btnUp = new JButton("입력");
		panel_1.add(btnUp);
		UpListener hireListener = new UpListener(btnUp);
		btnUp.setActionCommand("입력");
		btnUp.addActionListener(hireListener);
		btnUp.setEnabled(false);
		
		
		
		
		
		JButton btnTrance = new JButton("전송");
		panel_1.add(btnTrance);
		
		       JButton btnDel_1 = new JButton("삭제");
		       panel_1.add(btnDel_1);
		       btnDel_1.setActionCommand("삭제");
		       
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(15);
		textField.addActionListener(hireListener);
		textField.getDocument().addDocumentListener(hireListener);
		       btnDel_1.addActionListener(new DelListener());
		
		
		
		
		listModel = new DefaultListModel();
        listModel.addElement("Jane");
        listModel.addElement("John");
        listModel.addElement("Kathy");
        
        JList list = new JList(listModel);
		frame.getContentPane().add(list, BorderLayout.CENTER);
        
        
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(list);
        String name = listModel.getElementAt(
                              list.getSelectedIndex()).toString();
		
	}
	
	class DelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //This method can be called only if
            //there's a valid selection
            //so go ahead and remove whatever's selected.
            int index = list.getSelectedIndex();
            listModel.remove(index);
 
            int size = listModel.getSize();
 
            if (size == 0) { //Nobody's left, disable firing.
            	btnDel.setEnabled(false);
 
            } else { //Select an index.
                if (index == listModel.getSize()) {
                    //removed item in last position
                    index--;
                }
 
                list.setSelectedIndex(index);
                list.ensureIndexIsVisible(index);
            }
        }
    }
	
	
	class UpListener implements ActionListener, DocumentListener {
        private boolean alreadyEnabled = false;
        private JButton btn;
 
        public UpListener(JButton btn) {
            this.btn = btn;
        }
 
        //Required by ActionListener.
        public void actionPerformed(ActionEvent e) {
            String name = textField.getText();
 
            //User didn't type in a unique name...
            if (name.equals("") || alreadyInList(name)) {
                Toolkit.getDefaultToolkit().beep();
                textField.requestFocusInWindow();
                textField.selectAll();
                return;
            }
 
            int index = list.getSelectedIndex(); //get selected index
            if (index == -1) { //no selection, so insert at beginning
                index = 0;
            } else {           //add after the selected item
                index++;
            }
 
            listModel.insertElementAt(textField.getText(), index);
            //If we just wanted to add to the end, we'd do this:
            //listModel.addElement(employeeName.getText());
 
            //Reset the text field.
            textField.requestFocusInWindow();
            textField.setText("");
 
            //Select the new item and make it visible.
            list.setSelectedIndex(index);
            list.ensureIndexIsVisible(index);
        }
 
        //This method tests for string equality. You could certainly
        //get more sophisticated about the algorithm.  For example,
        //you might want to ignore white space and capitalization.
        protected boolean alreadyInList(String name) {
            return listModel.contains(name);
        }
 
        //Required by DocumentListener.
        public void insertUpdate(DocumentEvent e) {
            enableButton();
        }
 
        //Required by DocumentListener.
        public void removeUpdate(DocumentEvent e) {
            handleEmptyTextField(e);
        }
 
        //Required by DocumentListener.
        public void changedUpdate(DocumentEvent e) {
            if (!handleEmptyTextField(e)) {
                enableButton();
            }
        }
 
        private void enableButton() {
            if (!alreadyEnabled) {
                btn.setEnabled(true);
            }
        }
 
        private boolean handleEmptyTextField(DocumentEvent e) {
            if (e.getDocument().getLength() <= 0) {
                btn.setEnabled(false);
                alreadyEnabled = false;
                return true;
            }
            return false;
        }
    }
 
    //This method is required by ListSelectionListener.
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {
 
            if (list.getSelectedIndex() == -1) {
            //No selection, disable fire button.
            	btnDel.setEnabled(false);
 
            } else {
            //Selection, enable the fire button.
            	btnDel.setEnabled(true);
            }
        }
    }
	
	

}
