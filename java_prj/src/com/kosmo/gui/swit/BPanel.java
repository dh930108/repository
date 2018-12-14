package com.kosmo.gui.swit;

import java.awt.Color;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class BPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public BPanel() {
		setBackground(Color.RED);
		setLayout(new BorderLayout(0, 0));
		
		JButton btnBpanel = new JButton("BPanel");
		add(btnBpanel, BorderLayout.WEST);

	}

}
