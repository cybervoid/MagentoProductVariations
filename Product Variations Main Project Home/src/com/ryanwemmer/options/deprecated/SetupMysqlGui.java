package com.ryanwemmer.options.deprecated;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.ryanwemmer.options.handlers.PropertyFileHandler;

public class SetupMysqlGui {
	
	public void setupMysqlGui(){
		
		JButton bOk = new JButton("OK");
		final JTextField address = new JTextField();
		final JTextField username = new JTextField();
		final JTextField password = new JTextField();
		final JTextField database = new JTextField();
		
		JLabel labelAddress = new JLabel("Address");
		JLabel labelUsername = new JLabel("Username");
		JLabel labelPassword = new JLabel("Password");
		JLabel labelDatabase = new JLabel("Database");		
		//Setup GUI
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);
		
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(bOk)
                            .addGap(5, 5, 5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelPassword)
                                    .addComponent(labelDatabase))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                    .addComponent(password, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(database, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelUsername)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(address))))
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelAddress)
                        .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelUsername)
                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelPassword)
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(database, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelDatabase))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(bOk)
                    .addContainerGap(18, Short.MAX_VALUE))
            );
            


	
            layout.linkSize(SwingConstants.HORIZONTAL, address, username, password, database);
			//Finalize gui
			frame.add(panel);		
			//Show window
			int frameWidth = 260;
			int frameHeight = 260;
			frame.setSize(frameWidth, frameHeight);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			
            //Set up OK Button
            bOk.addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent e){
    				JFrame popupFrame = new JFrame();
    				//Open the file location information.				
    				if(address == null || username == null || password == null || database == null){
    					
    					JOptionPane.showMessageDialog(popupFrame, "Missing Information", null, JOptionPane.ERROR_MESSAGE);
    				}else{
    					PropertyFileHandler pfh = new PropertyFileHandler();
    					String encPass = pfh.encryptPw(password.getText());
    					pfh.updateMysqlPropFile(address.getText(), username.getText(), encPass, database.getText());
    					JOptionPane.showMessageDialog(popupFrame, "Information Saved");
    					//frame.setVisible(false);
    				}
    			}
    		});	
	}
}
