/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

/**
 *
 * @author finalist
 */
public class DataRecovery{//remember to pass the drive letters to each commands
    private Process pr;
    String command,recoveredData;//recoverData should be placed in the gui
    
    //recover hidden data by viruses
    public void recoverdata(String disk){
        //this.command = "attrib -s -h -r g:/*.* /s /d";
        this.command = disk;
        Runtime run = Runtime.getRuntime();
         try { 
         pr = run.exec(command);

         } catch (IOException e) {
         } try { 
         pr.waitFor(); 
         } catch (InterruptedException e) {
         }
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream())); 
        String line;
        
        try { 

         line=buf.readLine();
         while(line!=null) {
                recoveredData=line;
                line=buf.readLine();
         }//end of while
         //display successful message
         JOptionPane.showMessageDialog(null, 
                    "Data Hidden by viruses successfully recovered",
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE);
            //invoke delete shorcuts method to delete shortcuts
            
         } catch (IOException e) { 
             JOptionPane.showMessageDialog(null, 
                    "e.getMessage()",
                    "IOException",
                    JOptionPane.ERROR_MESSAGE); 
         }
        
    }//end of recover data method
    
    public void deleteShortcuts(String disk){
        /* loop thru the disk files and delete .lnk files 
         * instead of using the code below that wont work 
         */
        //this.process.createProcess("del *.exe");
        
        try { 
            File dir = new File(disk+":/");
				     
            	if (dir.isDirectory()) {
                    File[] subFiles = dir.listFiles();

                for (File file : subFiles) {
                    if (file.isFile()&&(file.getName().endsWith(".lnk"))) {    
                        file.delete();
                    } else if (file.isDirectory()&&(file.getName().endsWith(".lnk"))) {  
                        file.delete();
                    }else{/*do nothing*/             
		    }

                }
				 
			}
	} catch (Exception e) {  
            JOptionPane.showMessageDialog(null, 
                    "e.getMessage()",
                    "IOException",
                    JOptionPane.ERROR_MESSAGE);
        }
        
    }//end of delete shortcuts method

}//end of class data recovery
