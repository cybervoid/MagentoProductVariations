package com.ryanwemmer.options.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import com.ryanwemmer.options.data.sortattributes.AttributeExportOrder;
import com.ryanwemmer.options.pojo.Attributes;

public class ReorderAttributesGui /*extends ListCellRenderer*/{
	
	public void reorder(){
		
		//Create instance variables
		AttributeExportOrder aeo = new AttributeExportOrder();
		final DefaultListModel model = new DefaultListModel();
		//Setup frame
		JFrame frame = new JFrame();
		//New JPanel
		JPanel panel = new JPanel();
		//Setup instance variables
	    JButton jButtonBottom = new JButton();
	    JButton jButtonDown = new JButton();
	    JButton jButtonReset = new JButton();
	    JButton jButtonSave = new JButton();
	    JButton jButtonTop = new JButton();
	    JButton jButtonUp = new JButton();
	    
	    //http://www.java2s.com/Code/Java/Swing-JFC/UseJListcomponenttodisplaycustomobjectswithListCellRenderer.htm	    
	    //Create JList to hold sorted list with the data type attributes
	    List sortedAttributesList = new ArrayList<Attributes>();
	    sortedAttributesList = (List) aeo.getSortedOrder();
	    
	    
	    
	    //Add Items to jlist
	    //Put sortedAttributeList into an Attribute[] Array
	    Attributes[] sortedAttributesArray = (Attributes[]) sortedAttributesList.toArray(new Attributes[sortedAttributesList.size()]); 
	    
	    final JList attributeJList = new JList(sortedAttributesArray);
	    attributeJList.setCellRenderer(new AttributeCellRenderer());
	    attributeJList.setVisibleRowCount(20);
	    
	   // attributeJList.setModel(model);
	    
	    //Create scrollpane
	    JScrollPane pane = new JScrollPane(attributeJList);
	    //Add List to scrollpane
        //add Pane to panel.
        panel.add(pane);
        //Set JList properties.
        attributeJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Setup buttons                
        jButtonTop.setText("^^");
        jButtonTop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               	jButtonTopActionPerformed(evt);
                
            }
        });

        jButtonUp.setText("^");


        jButtonDown.setText("V");
        jButtonDown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonDownActionPerformed(evt, attributeJList);
            }
        });

        jButtonBottom.setText("VV");
        jButtonBottom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonBottomActionPerformed(evt);
            }
        });

        jButtonReset.setText("Reset");
        jButtonSave.setText("Save");

		//create group layout
		GroupLayout layout = new GroupLayout(panel);
		//add layout to panel
		panel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonReset, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSave, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                    .addComponent(pane, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonUp, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonDown, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonTop, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonBottom)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jButtonTop, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonUp, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonDown, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonBottom, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(pane, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonReset)
                            .addComponent(jButtonSave))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        
        
        //Add panel to jframe
        frame.add(panel);
        frame.setSize(265, 400);
		frame.setVisible(true);
        jButtonUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
             try{
            	jButtonUpActionPerformed(evt, attributeJList, model);
            } catch (Exception e) {
				System.out.println(e.toString());
			}
            }
        });
	}	
	//http://compgroups.net/comp.lang.java.gui/user-order-jlist-items-via-up-down-buttons/35133

	
	    
	public void swapElements(int pos1, int pos2, DefaultListModel model)   {
		Attributes attribute = (Attributes) model.get(pos1);
		model.set(pos1, model.get(pos2));
		model.set(pos2, attribute);
		
	}

//Move item to top	
   private void jButtonTopActionPerformed(ActionEvent evt) {
	   
	   
   }                                          
	
	   //Move selected item up one
   
   //https://community.oracle.com/thread/2077051
	private void jButtonUpActionPerformed(ActionEvent evt, JList list, DefaultListModel model) {
		int index = list.getSelectedIndex();
		if(index == -1){
			JOptionPane.showMessageDialog(null, "Select an item to move.");
		}else if(index > 0 ){
			//int indexOfSelected = list.getSelectedIndex();
			/*try {			
			
				swapElements(index, index + 1, model);
			} catch (Exception e) {
				System.out.println("jButtonUpActionPerformed:" + e.toString());
			}*/
			//indexOfSelected = indexOfSelected - 1;
			list.setSelectedIndex(index - 1);
			list.updateUI();
			System.out.println(list.getSelectedIndex());
		}
	}                                         
	
	//Move selected item down one
	private void jButtonDownActionPerformed(ActionEvent evt, JList list) {
	}                                           
	//move selected item to bottom of the list
	private void jButtonBottomActionPerformed(ActionEvent evt) {
	    // TODO add your handling code here:
	}

	//Renders individual cell's value
	private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);
	class AttributeCellRenderer extends JLabel implements ListCellRenderer{
		public AttributeCellRenderer() {
			setOpaque(true);
			setIconTextGap(12);
		}
		
		 //Return a component with a label of the magento code.
		 public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus) {
			Attributes attribute = (Attributes) value;
			setText(attribute.getMagentoCode());
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
}
