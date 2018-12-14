package com.kosmo.gui.demo;
 
/*
 * SimpleTableDemo.java requires no other files.
 */
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.RowId;
import javax.swing.BoxLayout;
 
public class SimpleTableDemo extends JPanel {
    private boolean DEBUG = false;
    JFrame frame;
    TableModel model;
    SimpleTableDemo window;
    
 
    
    
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	SimpleTableDemo window = new SimpleTableDemo();
            	window.frame.setVisible(true);
            }
        });
    }
    public SimpleTableDemo() {
    	
        frame = new JFrame("TITLE이다");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,500,400);
 
        //Create and set up the content pane.
//        SimpleTableDemo newContentPane = new SimpleTableDemo();
//        newContentPane.setOpaque(true); //content panes must be opaque
//        frame.setContentPane(newContentPane);
 
//        //Display the window.
//        frame.pack();
//        frame.setVisible(true);
 
        String[] columnNames = {"EMPNO",
                                "ENAME",
                                "JOB",
                                "DEPTNO"};
 
        
        
        Object[][] data = {
        {new Integer(7733),"SMITH", "CLERK", new Integer(10) },
        {new Integer(7788),"ALERN", "MANAGER", new Integer(20) },
        {new Integer(7799),"KING", "PRESIDENT", new Integer(30)}};
 
//        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
//        JTable table = new JTable(tableModel);
//        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
//        table.setFillsViewportHeight(true);
         DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
         JTable table = new JTable(tableModel);
 
        
      //마우스가 눌리면 액션
        table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                	 int rowIndex = table.getRowCount();
                     int columnIndex = table.getColumnCount();
                     TableModel model = table.getModel();
                     Object val = model.getValueAt(rowIndex, columnIndex);
                     System.out.println(rowIndex+","+columnIndex+","+val.toString());
                }
            });
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        
        
        JScrollPane scrollPane = new JScrollPane(table);
         frame.getContentPane().add(scrollPane, BorderLayout.NORTH);
    }
 
//    private void printDebugData(JTable table) {
//        int numRows = table.getRowCount();
//        int numCols = table.getColumnCount();
//        javax.swing.table.TableModel model = table.getModel();
// 
//        System.out.println("Value of data: ");
//        for (int i=0; i < numRows; i++) {
//            System.out.print("    row " + i + ":");
//            for (int j=0; j < numCols; j++) {
//                System.out.print("  " + model.getValueAt(i, j));
//            }
//            System.out.println();
//        }
//        System.out.println("--------------------------");
//    }
 
 
}