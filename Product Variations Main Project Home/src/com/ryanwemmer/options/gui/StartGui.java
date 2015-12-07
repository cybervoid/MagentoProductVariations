package com.ryanwemmer.options.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.ryanwemmer.options.data.sortattributes.ChangeExportOrder;
import com.ryanwemmer.options.deprecated.SetupMysqlGui;

public class StartGui extends JFrame {
	
	//Instantiate class
	static GetSourceData gsd = new GetSourceData();
	//Initial Starting Menu. Contains a list of actions for the user to select
/*	public void startGui(){	
		JFrame frame = new JFrame("Import Manager");
		BorderLayout bord = new BorderLayout();
		JPanel panel = new JPanel(bord);
		
		frame.setLocation(50, 50);
		JButton bMysql = new JButton("Setup MySQL"); 
		JButton bImport = new JButton("Import Product Data");
		JButton bExport = new JButton("Export Manufacturer");
		JButton bExit = new JButton("Exit Application");
		//String[] actionNames = {"New Import File","Setup MySQL"};		
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		//Setup Action Listeners. NEW BUTTONS HERE:
		bImport.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Open the file location information.				
				gsd.dataSourceWindow();
			}
		});
		
		
		//Set up exit button
		bExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Terminate program
				System.exit(0);				
			}
		});
		
		panel.add(bImport, bord.PAGE_START);
		panel.add(bExport, bord.CENTER);
		

		panel.add(bMysql,bord.CENTER);	
		panel.add(bExit, bord.PAGE_END);
		
		
		//add panel to frame.
		frame.add(panel, BorderLayout.NORTH);
		
		//Display window.		
		int frameWidth = 260;
		int frameHeight = 300;
		frame.setSize(frameWidth, frameHeight);
		//Use red X on start screen to terminate the program
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);			
	}
	*/
	/**
	 * Revised GUI
	 */
	
	
	public void launchGui(){
		//Setup frame
		JFrame frame = new JFrame();
		//New JPanel
		JPanel panel = new JPanel();
		//Create buttons
		JButton bMysql = new JButton("Setup MySQL"); 
		JButton bImport = new JButton("Import Product Data");
		JButton bExport = new JButton("Export Product Data");
		JButton bExit = new JButton("Exit Application");
		
		
		//Menu Variables
		JMenu jMenuConfig = new JMenu();
		JMenu jMenuAttributes  = new JMenu();
		JMenuItem jMenuItemNewAttributes = new JMenuItem();
		JMenuItem jMenuItemChangeAttributes = new JMenuItem();
		JMenuItem jMenuItemAttributeExportOrder = new JMenuItem();
		JMenuBar jMenuBar1 = new JMenuBar();
		
		/* BEGIN MENU BAR*/
		jMenuConfig.setText("Configuration");
		jMenuAttributes.setText("Attributes");
		jMenuItemAttributeExportOrder.setText("Edit Export Order");
		
		jMenuItemAttributeExportOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//ReorderAttributesGui rag = new ReorderAttributesGui();
				//rag.reorder();
				ChangeExportOrder ceo = new ChangeExportOrder();
				ceo.reorder();
				
			}
		});
		
		
		jMenuItemChangeAttributes.setText("Change Attributes");
		//New Attributes Option
		jMenuItemNewAttributes.setText("New Attribute");
		jMenuItemNewAttributes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				NewAttributeGui na = new NewAttributeGui();
				na.newAttributeGui();
				
			}
		});
		
		//Add attribute menu items to attribute menu
		jMenuAttributes.add(jMenuItemChangeAttributes);
		jMenuAttributes.add(jMenuItemNewAttributes);
        jMenuAttributes.add(jMenuItemAttributeExportOrder);
        //Add attribute menu to config menu
        jMenuConfig.add(jMenuAttributes);
        //Add config menu to menu bar
        jMenuBar1.add(jMenuConfig);
        
        //Add menu bar to frame
		frame.setJMenuBar(jMenuBar1);
		/* END MENU BARS */
		
		
		
		
		
		
		//NEW BUTTONS: EDIT HERE
		
		//Add Action listeners
		//Import button to launch file chooser
		bImport.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Open the file location information.				
				gsd.fileWindow();
			}
		});
		
		
		bMysql.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				SetupMysqlGui m = new SetupMysqlGui();
				m.setupMysqlGui();
			}
		});
		
		/**
		 * @TODO Create button to run setup
		 */
		//Set up exit button
		bExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Terminate program
				System.exit(0);				
			}
		});
		
		//Create layout
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);
		
		//Setup layout positions
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
				.addGap(50,50,50)
				.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						//NEW BUTTONS: EDIT HERE
						.addComponent(bImport)
						.addComponent(bExport)
						.addComponent(bMysql)
						.addComponent(bExit))
					.addContainerGap(100, Short.MAX_VALUE))				
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(40,40,40)
						//NEW BUTTONS: EDIT HERE
						.addComponent(bImport)
						.addGap(5)
						.addComponent(bExport)
						.addGap(5)
						.addComponent(bMysql)
						.addGap(5)
						.addComponent(bExit)
						.addContainerGap(50, Short.MAX_VALUE)
					)				
				);	
		

		//Make all buttons the same size
		layout.linkSize(SwingConstants.HORIZONTAL, bImport, bExport, bMysql, bExit);
		//Add panel to frame
		frame.add(panel);
		//Set close operation
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);		
		//Window display settings		
		int frameWidth = 260;
		int frameHeight = 260;
		frame.setSize(frameWidth, frameHeight);
		//Launch frame in middle of the window
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}	
}

