package com.ryanwemmer.options.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ryanwemmer.options.database.Crud;
import com.ryanwemmer.options.util.Positions;

public class NewAttributeGui {
	public void newAttributeGui(){
		//Setup GUI variables.
		JLabel jLabelNewAttribute = new JLabel();
		JLabel jLabelMagentoCode = new JLabel();
		final JTextField jTextFieldMagentoCode = new JTextField();
		JLabel jLabelDefaultValue = new JLabel();
		final JTextField jTextFieldDefaultValue = new JTextField();
		final JCheckBox jCheckBoxIsConfigurable = new JCheckBox();
		final JCheckBox jCheckBoxActive = new JCheckBox();
		JButton jButtonInsert = new JButton();
		final JCheckBox jCheckBoxReplaceApost = new JCheckBox();
		final JCheckBox jCheckBoxReplaceQuote = new JCheckBox();		
		jButtonInsert.setText("Insert");
		//Set Text jJabels
		jLabelNewAttribute.setText("New Attribute");		
		jLabelMagentoCode.setText("Magento Label");		
		jLabelDefaultValue.setText("Default Value");		
		jCheckBoxIsConfigurable.setText("Configurable");
		jCheckBoxReplaceApost.setText("Replace Apostrophes with HTML");
		jCheckBoxReplaceQuote.setText("Replace Quotes with HTML");
		//Setup default values.
		jCheckBoxActive.setSelected(true);
		jCheckBoxActive.setText("Active");
				
		//Define "Insert" Button behavior
		jButtonInsert.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Insert new attribute into database
				JFrame popupFrame = new JFrame(); 
				String magentoCode = jTextFieldMagentoCode.getText();
				if(jTextFieldMagentoCode.getText().equals("")){
					//The only Required value is the magento code. Display an alert if blank
					JOptionPane.showMessageDialog(popupFrame, "Enter Magento Code Name!", 
							null, JOptionPane.ERROR_MESSAGE);					
				}else{															 
					boolean active = jCheckBoxActive.isSelected();
					String defaultValue = jTextFieldDefaultValue.getText(); 
					boolean isConfigurableOption = jCheckBoxIsConfigurable.isSelected();
					boolean replaceApost = jCheckBoxReplaceApost.isSelected();
					boolean replaceQuote = jCheckBoxReplaceQuote.isSelected();
					//Access create attributes in database CRUD class.
					Crud c = new Crud();
					c.attributesCreate(magentoCode, active, 5, defaultValue, 
							isConfigurableOption, replaceApost, replaceQuote);
					JOptionPane.showMessageDialog(popupFrame, "New Attribute Created");
					jTextFieldDefaultValue.setText("");
					jTextFieldMagentoCode.setText("");					
				}
			}
		});		
		//Setup GUI's layout
		JFrame frame = new JFrame();		
		JPanel panel = new JPanel();		
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);
		layout.setHorizontalGroup(
        		 layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addGroup(layout.createSequentialGroup()
                     .addGap(29, 29, 29)
                     .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(jCheckBoxReplaceQuote)
                         .addGroup(layout.createSequentialGroup()
                             .addComponent(jCheckBoxActive)
                             .addGap(18, 18, 18)
                             .addComponent(jCheckBoxIsConfigurable))
                         .addComponent(jCheckBoxReplaceApost)
                         .addGroup(layout.createSequentialGroup()
                             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                 .addComponent(jLabelDefaultValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                 .addComponent(jLabelNewAttribute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                 .addComponent(jLabelMagentoCode, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                 .addComponent(jTextFieldMagentoCode)
                                 .addComponent(jTextFieldDefaultValue, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))))
                     .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                 .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                     .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addComponent(jButtonInsert)
                     .addContainerGap())
             );
             layout.setVerticalGroup(
                 layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addGroup(layout.createSequentialGroup()
                     .addContainerGap()
                     .addComponent(jLabelNewAttribute)
                     .addGap(15, 15, 15)
                     .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabelMagentoCode)
                         .addComponent(jTextFieldMagentoCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                     .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jTextFieldDefaultValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jLabelDefaultValue))
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                     .addComponent(jCheckBoxReplaceApost)
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                     .addComponent(jCheckBoxReplaceQuote)
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                     .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jCheckBoxIsConfigurable, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jCheckBoxActive))
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                     .addComponent(jButtonInsert)
                     .addGap(23, 23, 23))
             );
             //Initialize GUI
	        frame.add(panel);
			int frameWidth = 260;
			int frameHeight = 260;
			frame.setSize(frameWidth, frameHeight);
			Positions p = new Positions();
			frame.setLocation(p.screenRandomMiddlePoint());
			frame.setVisible(true);
	}
}
