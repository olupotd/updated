/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mos;


import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileSystemView;
/**
 *
 * @author kanyama
 */
public class Main extends JFrame{
    /**
     * @param args the command line arguments
     */
    private final CardLayout cardLayout = new CardLayout(20, 10);
    private JPanel cardPanel = new JPanel(cardLayout) ;
    private final JPanel options=new JPanel();
    JPanel options2=new JPanel();
    JButton pcPerformance, dataRecovery, cancel2,cancel6,ok1;
    Font font1 = new Font("Monospaced", Font.BOLD, 30);
//SansSerif, Serif, Monospaced, Dialog, or DialogInput
    private final JLabel card1=new JLabel("WELCOME TO MOS PC TUNER"),contactus;
    private final JPanel card2=new JPanel();
    private final JPanel card6=new JPanel();
    // Create a combo box for selecting countries
    JComboBox drives;
    String[] disks;
    String ss,choice,files="";
    DataRecovery dr=new DataRecovery();
    CheckStatus cs=new CheckStatus();
    /**
     * @param args the command line arguments
     */
    //drawing all the necessary giu objects
    public Main(){
        //set the fram's layout
        //creating contact us label
        
        pcPerformance = new JButton("PC PERFORMANCE");
        pcPerformance.setPreferredSize(new java.awt.Dimension(160, 35));
        dataRecovery = new JButton("DATA RECOVERY");
        dataRecovery.setPreferredSize(new java.awt.Dimension(150, 35));
        cancel6=new JButton("CANCEL");
        cancel6.setPreferredSize(new java.awt.Dimension(100, 35));
        cancel2=new JButton("CANCEL");
        cancel2.setPreferredSize(new java.awt.Dimension(100, 35));
        contactus=new JLabel("Contact Us");
        JLabel label6=new JLabel("DATA RECOVERY");
        //creating card 2 elements
        JLabel label2=new JLabel("PC PERFORMANCE");
            label2.setFont(font1);
        JPanel panel2 = new JPanel();
        String output="---STATUS AND RECOMMENDATION---\n"+cs.prepareStatus()+"\n\n"+cs.displayRecommendation();
        JTextArea ta = new JTextArea(output);
            ta.setBackground(Color.LIGHT_GRAY);
            ta.setEditable(false);
        JScrollPane jsp = new JScrollPane(ta);
        //this dimention is key for the cancel button to appear
        jsp.setPreferredSize(new java.awt.Dimension(550, 340));
        panel2.add(jsp,BorderLayout.CENTER); 
        //adding components to the card2
        card2.add(label2,BorderLayout.NORTH);
        card2.add(panel2,BorderLayout.CENTER);
        card2.add(cancel2,BorderLayout.SOUTH);
        
        // Panel p to hold card1
        JPanel cu = new JPanel();
        //using null layout for card1 panel
        cu.setLayout(null);
        card1.setBounds(60,40,440,50);
        cu.add(card1);
       
        //creating commands
        options.add(pcPerformance);
        options.add(dataRecovery);
        options.add(contactus);
        
        //creating card 6 elements
        ok1=new JButton("OK");
        ok1.setPreferredSize(new java.awt.Dimension(50, 35));
        card6.setLayout(null);
        ArrayList<String> compdisks=new ArrayList();
         /* Get a list of all filesystem roots on this system */
    FileSystemView fsv = FileSystemView.getFileSystemView();
    File[] roots = File.listRoots();
    /* For each filesystem root, print some info */
    for (File root : roots) {
	if(fsv.getSystemTypeDescription(root).equals("Local Disk")||
                fsv.getSystemTypeDescription(root).equalsIgnoreCase("Removable Disk")){
	  //System.out.println("Drive Name: " + fsv.getSystemDisplayName(root));
            compdisks.add(fsv.getSystemDisplayName(root));
      
	}
    }//end of the for loop
        String[] array= new String[compdisks.size()];
        disks=compdisks.toArray(array);
        drives = new JComboBox(disks);
        drives.setPreferredSize(new java.awt.Dimension(150, 35));
        label6.setFont(font1);
        JLabel name = new JLabel("Select Disk");
        JPanel panel6 = new JPanel();
            panel6.add(name,BorderLayout.WEST);
            panel6.add(drives,BorderLayout.CENTER);
            panel6.add(ok1,BorderLayout.EAST);
            
            label6.setBounds(150,20,440,50);
            panel6.setBounds(40,100,400,50);
                        
            card6.add(label6);
            card6.add(panel6);            
            
        
        //PANEL TO HOLD CARDs
        cardPanel.setBorder( new javax.swing.border.LineBorder(Color.red));
        card1.setFont(font1);
        cardPanel.add(cu,"card1");
        cardPanel.add(card2,"card2");
        cardPanel.add(card6,"card6");
        
        //creating card6
        

        // Place panels in the frame
        add(cardPanel, BorderLayout.CENTER);
        add(options, BorderLayout.SOUTH);
        
        // Register listeners with the source objects
        pcPerformance.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        // Show the first component in cardPanel
            cardLayout.show(cardPanel,"card2");
           
        }
        });
        
        dataRecovery.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        // Show the first component in cardPanel
            cardLayout.show(cardPanel,"card6");
 
        }
        });
        
        // Register listeners with the source objects
        ok1.addActionListener(new ActionListener() {
            
        @Override
        public void actionPerformed(ActionEvent e) {
        // Show the first component in cardPanel 
            //run data recovery
            dr.recoverdata("attrib -s -h -r "+getChoice()+":/*.* /s /d");
            dr.deleteShortcuts(getChoice());
            
            JTextArea ta6 = new JTextArea("THESE ARE THE FILES IN DISK "+getChoice().toUpperCase()+":\n\n"+showFiles().trim());
            ta6.setBackground(Color.LIGHT_GRAY);
            ta6.setEditable(false);
            JScrollPane jsp6 = new JScrollPane(ta6);
            jsp6.setBounds(20,150,500,250);
            cancel6.setBounds(200,410,100,35);
            card6.add(jsp6);
            card6.add(cancel6);
            card6.validate();
            cardLayout.show(cardPanel,"card6");
            
        }
        });
        
        // Register listeners with the source objects
        cancel2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        // Show the first component in cardPanel
            int option = JOptionPane.showConfirmDialog(new Main(),
                    "Are You Sure You want to cancel the action?",
                    "Cancel PC Performance", JOptionPane.YES_NO_OPTION);
        
            if (option == JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(new Main(), 
                    "stop the thread from executing",
                    "Cancelling PC Performance action...",
                    JOptionPane.PLAIN_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(new Main(), 
                    "resuming the thread execution",
                    "Reminder...",
                    JOptionPane.PLAIN_MESSAGE);
            }
            
            //hide is discouraged thats y its crossed
         }//end of action listener
        });
        
        // Register listeners with the source objects
        cancel6.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        // Show the first component in cardPanel
          int option = JOptionPane.showConfirmDialog(new Main(),
                    "Are You Sure You want to cancel the action?",
                    "Cancel Data Recovery", JOptionPane.YES_NO_OPTION);
        
            if (option == JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(new Main(), 
                    "stop the thread from executing",
                    "Cancelling Data Recovery action...",
                    JOptionPane.PLAIN_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(new Main(), 
                    "resuming the thread execution",
                    "Reminder...",
                    JOptionPane.PLAIN_MESSAGE);
            }  

        }
        });
    drives.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                //getItem returns an object so it gets cast
                //as a String to retrieve the item value
                ss = (String)e.getItem();
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    setChoice();
                }
                else
                {
                    
                }
            }
        });
    
    }//constructor end
    public void setChoice(){
       choice=ss.substring(ss.length()-3,ss.length()-2).toLowerCase();
    }
    public String getChoice(){return choice;}
    //show files method
    private String showFiles(){
        
        try { 
            File dir = new File(getChoice()+":/");
				     
            	if (dir.isDirectory()) {
                    File[] subFiles = dir.listFiles();

                for (File file : subFiles) {
                    if (file.isFile()) {    
                        files+=file.getName()+"\n";
                    } else if (file.isDirectory()) {  
                        files+=file.getName()+"\n";
                    }else{/*do nothing*/             
		    }

                }
				 
			}
	} catch (Exception e) {  
            JOptionPane.showMessageDialog(new Main(), 
                    "e.getMessage()",
                    "IOException",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        return files;
    }//end of show files
    //main method
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Use the event dispatch thread for Swing components
         EventQueue.invokeLater(new Runnable()
         {
            @Override
             public void run()
             {
                //Set Look and Feel
            try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }catch (UnsupportedLookAndFeelException e) {
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }//end of look and feel
            JFrame guiFrame = new Main();    
            guiFrame.setSize(600, 550); //Window size 300x100 pixels
        //center the window
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) ((dimension.getWidth() - guiFrame.getWidth()) / 2);
            int y = (int) ((dimension.getHeight() - guiFrame.getHeight()) / 2);
            guiFrame.setLocation(x, y);
            //Exit when X is clicked
            guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            //set the title
            guiFrame.setTitle("MOS PC TUNER");
            //No resize
            guiFrame.setResizable(false); 
            //set frame icon
            Image img = Toolkit.getDefaultToolkit().getImage("images/icon.jpg");
            guiFrame.setIconImage (img);
            //compress the components
            //guiFrame.pack();
            //validate the frame
            guiFrame.validate();
            //Make frame visible
            guiFrame.setVisible(true);  
        
             }
         });
        
        
    }//end of main method
    
}//end of main class
