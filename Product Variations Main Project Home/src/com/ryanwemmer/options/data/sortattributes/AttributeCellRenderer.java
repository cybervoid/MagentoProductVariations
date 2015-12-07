package com.ryanwemmer.options.data.sortattributes;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;

import com.ryanwemmer.options.pojo.Attributes;

public class AttributeCellRenderer extends JLabel implements ListCellRenderer{
	 private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);
	
	 public AttributeCellRenderer() {
		 setOpaque(true);
		 setIconTextGap(12);
	 }
	
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		Attributes attribute = (Attributes) value;
		setText(attribute.getMagentoCode());
		int exportOrder = (attribute.getExportOrder());
		int id = attribute.getId();
		if (isSelected) {
			setBackground(Color.blue);
			setForeground(Color.white);
		}else{
			setBackground(Color.white);
			setForeground(Color.black);
		}
		return this;		
	}
}
