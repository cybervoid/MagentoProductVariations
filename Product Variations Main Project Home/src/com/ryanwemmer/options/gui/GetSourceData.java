package com.ryanwemmer.options.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 * This class controls the initial pop-up 
 * window which identifies the target file.
 * 
 * @author Ryan Wemmer
 */
public class GetSourceData extends JPanel{
	
	JTextField path = new JTextField();
	static String filePath;
	JFileChooser fc;
	
	
	public String filePath(){
		//Returns the source file's string location.
		String path = "";						
		return path;		
	}
	
	//GUI that controls file identification
	
	//Set up the data source window.
	public void dataSourceWindow(){		
		//Set up the frame, use with Border and Flow Layout managers.
		JFrame frame = new JFrame("Choose Source File");
		frame.setLocation(55, 55);
		JPanel panel = new JPanel(new BorderLayout());		
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		//Create Text field, and Buttons	
		JButton ok = new JButton("OK");
		JButton choose = new JButton("Choose a File");
		
		//Setup filechooser

		// Add action listener to the 'choose' button
		choose.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JFileChooser fc = new JFileChooser();
				//Filter files to only show csv files.
				FileNameExtensionFilter filter = new FileNameExtensionFilter("csv", "CSV");
				//Select only files
				int returnVal = fc.showOpenDialog(GetSourceData.this);
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				File file = fc.getSelectedFile();
				filePath = file.getPath().toString();
				path.setText(filePath);
				
				
			}
		});
		
		//Add action listener for the "ok" button.
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			//Move to the next screen using the selected file path.
			}
		});
		
		//Add buttons to panel. NEW BUTTONS HERE:
		JTextField pathTextField = new JTextField(30);	
		pathTextField.setSize(10, 30);
		//Add path text field, align to left.		
		/** @TODO
		 * Fix layout
		 */
		//position text field.
		panel.add(pathTextField, BorderLayout.WEST);
		//position choose
		panel.add(choose, BorderLayout.LINE_END);
		//position ok.
		panel.add(ok, BorderLayout.PAGE_END);		
		//add panel to frame.
		frame.add(panel, BorderLayout.NORTH);		
		//Display window.
		int frameWidth = 560;
		int frameHeight = 160;
		frame.setSize(frameWidth, frameHeight);
		frame.setVisible(true);
	}	

	//Setup the file selection window
	public void fileWindow(){
		//Setup components
		JLabel jLabelPath = new JLabel("File Path:");
		JLabel jLabelNote = new JLabel("*Example: C:\\User\\Documents\\myfile.csv");
		final JTextField textFieldFilePath = new JTextField();
		JButton bChoose = new JButton("Choose File");
		JButton bOk = new JButton("OK");	
		//Setup window frame and layout
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);		
	    layout.setHorizontalGroup(
	             layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	             .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                 .addGap(26, 26, 26)
	                 .addComponent(jLabelPath)
	                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
	                     .addGroup(layout.createSequentialGroup()
	                         .addComponent(jLabelNote, GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                         .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                         .addComponent(bChoose))
	                     .addGroup(layout.createSequentialGroup()
	                         .addComponent(textFieldFilePath, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
	                         .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                         .addComponent(bOk)))
	                 .addGap(71, 71, 71))
	         );
	         layout.setVerticalGroup(
	             layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	             .addGroup(layout.createSequentialGroup()
	                 .addContainerGap()
	                 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                     .addComponent(jLabelPath)
	                     .addComponent(bChoose)
	                     .addComponent(textFieldFilePath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                     .addComponent(bOk)
	                     .addComponent(jLabelNote))
	                 .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	         );      
			layout.linkSize(SwingConstants.HORIZONTAL, bChoose, bOk);			
			//End of Layout setup
			
			
			
			//Setup button actions		
			bChoose.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					JFileChooser fc = new JFileChooser();
					//Filter files to only show csv files.
					FileNameExtensionFilter filter = new FileNameExtensionFilter("csv", "CSV");
					//Select only files, folder cannot be an option
					int returnVal = fc.showOpenDialog(GetSourceData.this);
					fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
					File file = fc.getSelectedFile();
					String s = file.getPath().toString();
					textFieldFilePath.setText(filePath);
				}
			});
			//Finalize gui
			frame.add(panel);		
			//Show window
			int frameWidth = 560;
			int frameHeight = 160;
			frame.setSize(frameWidth, frameHeight);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
				
			bOk.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
				//Move to the next screen using the selected file path.
				//Close file select window				
				}
			});	
	}
}
	
	
	

