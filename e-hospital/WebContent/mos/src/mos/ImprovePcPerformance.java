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
public class ImprovePcPerformance {
    
    private Process pr;
    String command;
    Runtime run;
    
    public void defrag(String keys){
        
        this.command = "defrag "+keys+" /h /u";// or use dfrgui.exe to prompt a pop up
         run = Runtime.getRuntime();
         try { 
         pr = run.exec(command);

         } catch (IOException e) {
         } try { 
         pr.waitFor(); 
         } catch (InterruptedException e) {
         }
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream())); 
     
        
        try { 

         while(buf.readLine()!=null) {
                
         }//end of while
         //display successful message
         JOptionPane.showMessageDialog(null, 
                    "Defragmentation Action successfully done",
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE);
            
         } catch (IOException e) { 
             JOptionPane.showMessageDialog(null, 
                    "e.getMessage()",
                    "IOException",
                    JOptionPane.ERROR_MESSAGE); 
         }
    }//end of defrag
      
    public void cleartemp(){
        try { 
            String tmpDir = System.getProperty("java.io.tmpdir");//obtain the temp path
            File dir = new File(tmpDir);
            	if (dir.isFile()) {
                    //do nothing
                 } else {
                File[] subFiles = dir.listFiles();

                for (File file : subFiles) {
                    if (file.isFile()) {
                        file.delete();
                    } else {
                        file.delete();
                    }

                }
            }
	} catch (Exception e) {
        } 
        //display successful message
        JOptionPane.showMessageDialog(null, 
                    "Temp folder cleared successfully",
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE);
    }//end of temp clearing
    
    public void diskcleanUp(){
        this.command = "cleanmgr /sageset:1";

         run = Runtime.getRuntime();
         try { 
         pr = run.exec(command);

         } catch (IOException e) {
         } try { 
         pr.waitFor(); 
         } catch (InterruptedException e) {
         }
         //end of setting clean up options
         this.command = "cleanmgr /sagerun:1";
         try { 
         pr = run.exec(command);

         } catch (IOException e) {
         } try { 
         pr.waitFor(); 
         } catch (InterruptedException e) {
         }
        
        
         //display successful message
         JOptionPane.showMessageDialog(null, 
                    "Disks successfully cleaned up",
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE);
            
         
    }//end of diskcleanup
    
    public void diskcheck(){
        /*watch out if it pops up a confirmation to schedule running on the nxt start up
         * 
         */
        this.command = "chkdsk /r /f";//repare and fix bad sectors
         run = Runtime.getRuntime();
         try { 
         pr = run.exec(command);

         } catch (IOException e) {
         } try { 
         pr.waitFor(); 
         } catch (InterruptedException e) {
         }
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream())); 
        
        try { 

         while(buf.readLine()!=null) {
                
         }//end of while
         //display successful message
         JOptionPane.showMessageDialog(null, 
                    "Disk Checking set",
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE);
            //invoke delete shorcuts method to delete shortcuts
            
         } catch (IOException e) { 
             JOptionPane.showMessageDialog(null, 
                    "e.getMessage()",
                    "IOException",
                    JOptionPane.ERROR_MESSAGE); 
         }
    }//end of disk check
    
    
}//end of class
