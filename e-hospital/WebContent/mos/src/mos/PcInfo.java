/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author finalist
 */
public class PcInfo {
    String command,osinfo,hdd="",osname,osversion,osarch,diskreport="",status,finalStatus,keys="";
    double temp=0.0,cpuvalue,cpuxp;
    long ram;
    String disk,stored="",recommendation="",cpu="";
    int frag=0;
    int diskanalysis=0;
    int hddpas=0;
    String tmpDir = System.getProperty("java.io.tmpdir");//obtain the temp path
    File dir = new File(tmpDir);
    Thread t;
    float thdd=0,fhdd=0,percentage=0,averagePercentage=0;
    Runtime run;
    
     Map<String,Integer> analysis=new HashMap<>();
     ArrayList<String> ramchips = new ArrayList<>(); 
    
    private Process pr;
    
     public double checkram(){
     
        String cmd = "wmic MemoryChip get Capacity";//attrib -s -h -r g:/*.* /s /d;  defrag /c /a /h; wmic cpu get name
        //wmic cpu get name
         run = Runtime.getRuntime();
          pr = null; 
         try { 
         pr = run.exec(cmd);

         } catch (IOException e) {
         } try { 
         pr.waitFor(); 
         } catch (InterruptedException e) {
         } 

         BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream())); 

         try { 
         String show;
        show=buf.readLine();
         //char x;
         while(show!=null) {

                if(!show.startsWith("Capacity")){
                        ramchips.add(show);
                }

                show=buf.readLine();

         } 
         //end of while
         for(String s:ramchips){

                if(s!=null&&!s.equals("")){
                       //System.out.println(s+"Bytes");
                        ram+=Double.parseDouble(s);
                }
         }//end of for loop

         } catch (NumberFormatException | NullPointerException | IOException e) {         }

        return ram/1073741824;
    }//end of checkram
    
    public String checkHDDCapacity(){
        /* Get a list of all filesystem roots on this system */
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File[] roots = File.listRoots();

         /* For each filesystem root, print some info */
        for (File root : roots) {
        //check only for hard disk drives
        if(fsv.getSystemTypeDescription(root).startsWith("Local Disk")){
            
        thdd+=(float)root.getTotalSpace();
	fhdd+=(float)root.getFreeSpace();
	percentage=(float)fhdd/thdd;
        
          hdd+=fsv.getSystemDisplayName(root)+
          "\nTotal space : " + (((float)(thdd))/1073741824)+" GB "+
          "\nFree space : " + (((float)(fhdd))/1073741824)+" GB \n";
          
                  if((thdd >=200)&&(percentage>=7.5)){
                      hddpas=5;
                      hdd+="You have enough HDD space("+percentage*100+"%)\n\n";
                  }
                  else if((thdd >=200)&&(percentage<7.5)){
                      hddpas=-5;
                      hdd+="You do not have enough HDD space("+percentage*100+"%)\n\n";
                  }

                  if((thdd <200)&&(percentage>=9.5)){
                      hddpas=5;
                      hdd+="You have enough HDD space("+percentage*100+"%)\n\n";
                  }
                  else if((thdd <200)&&(percentage<9.5)){
                      hddpas=-5;
                      hdd+="You do not have enough HDD space("+percentage*100+"%)\n\n";
                  }
      
          }
        }
		hdd+="TOTAL HDD space:"+thdd/1073741824+" GB "+
		"\nFREE HDD space:"+fhdd/1073741824+" GB \n\n";
                
            averagePercentage+=(fhdd/thdd)*100;  
            hdd+="The average free disk space is : "+averagePercentage+"\n\n";
            
          
                
        return hdd.trim();
    }//end of checkhddcapacity
    
    
    public String checkProcessorCapacity(){
        this.command = "wmic cpu get name";
         run = Runtime.getRuntime();
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
         while ((line=buf.readLine())!=null) {
             String[] tokens=line.split("\\s");
             for (String token : tokens) {
                 if (token.endsWith("GHz") || token.endsWith("MHz")) {
                     cpu=token;
                     
                 }
             }
         } 
         //end of while
         
         } catch (IOException e) {
             JOptionPane.showMessageDialog(null, 
                    "e.getMessage()",
                    "IOException",
                    JOptionPane.ERROR_MESSAGE); 
         }
         
         return cpu;
    }//end of processor capacity
    
    public String checkOSInfo(){
        osname=System.getProperty("os.name");
        osversion=System.getProperty("os.version");
        osarch=System.getProperty("os.arch");
        
        osinfo="\nName of the OS: " +osname+
               "\nVersion of the OS: " +osversion +
               "\nArchitecture of THe OS: " + osarch;
        
       return osinfo.trim(); 
    }//end of checkOsinfo
    
    //the method that helps the checktemp folder method to do its work
      public long getTempSize(File dir) {
        long size = 0;

        if (dir.isFile()) {
                size = dir.length();
        } else {
        File[] subFiles = dir.listFiles();

        for (File file : subFiles) {
                if (file.isFile()) {
                size += file.length();
                } else {
                size += this.getTempSize(file);
                }

            }
        }

        return size;
    }//end of getDirSize method
      
    public String checkTempfolderCapacity(){
        this.temp+=getTempSize(dir)/1048576;
        return temp+" MBs";
    }//end of checktempfoldercapacity
    
    public void diskanalysis(){
        
         command = "defrag /c /a /h ";
         run = Runtime.getRuntime();
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
             
             if(line.trim().startsWith("Invoking")&&line.endsWith("...")){
                disk=line.substring(21,(line.length()-3));
             }else if(line.trim().startsWith("Total")&&line.endsWith("%")){
                frag=Integer.parseInt(line.substring((line.length()-2),(line.length()-1)));
             }
            if(disk!= null&&!"".equals(disk)){
                analysis.put(disk, frag);
             }
                line=buf.readLine();
         }//end of while

         } catch (IOException e) { 
             
         }
         
    }//end of disk analysis
    
    public String diskAnalysisInfo(){
        for(String key:analysis.keySet()){
                if(analysis.get(key)>=0&&analysis.get(key)<10){
                    diskreport+="\t\t"+key+"\t"+analysis.get(key)+"%\n";
                    stored="good";  
                }else if(analysis.get(key)>=10){
                    diskreport+="\t\t"+key+"\t"+analysis.get(key)+"\n";
                    stored="bad";
                    keys+=key+": ";
                    recommendation+=key+"\t"+analysis.get(key)+"\nYou need to defragment this volume\n";
                }
            
        //end of for loop
   
          }
        
        return diskreport.trim();
     }//end of the info method
    
    
    public String report(){
        
        cpuvalue=Double.parseDouble(cpu.substring(0, cpu.length()-3));
        
        if(osname.endsWith("7")&&osarch.endsWith("x86")){
            if(checkram()>=1.0&&cpuvalue>=1.0&&hddpas==5&&temp<500&&"good".equals(stored)){
                //color green message
                status="Good";
             }else if(checkram()>=1.0&&cpuvalue>=1.0&&hddpas==5&&temp<500&&"bad".equals(stored)){
                //color green message
                status="Fair";
             }else if(checkram()<1.0||cpuvalue<1.0||hddpas==-5||temp>=500||"bad".equals(stored)){
                 //color red message
                 status="Bad";
             }
        }else if(osname.endsWith("7")&&osarch.endsWith("x64")) {
            if(checkram()>=2.0&&cpuvalue>=1.0&&hddpas==5&&temp<500&&"good".equals(stored)){
                //color green message
                status="Good";
             }else if(checkram()>=2.0&&cpuvalue>=1.0&&hddpas==5&&temp<500&&"bad".equals(stored)){
                //color green message
                status="Fair";
             }else if(checkram()<2.0||cpuvalue<1.0||hddpas==-5||temp>=500||"bad".equals(stored)){
                 //color red message
                 status="Bad";
             }
        
        }
        if(osname.endsWith("8")&&osarch.endsWith("x86")){
             if(checkram()>=1.0&&cpuvalue>=1.0&&hddpas==5&&temp<500&&"good".equals(stored)){
                 //color green message
                status="Good";
             }else if(checkram()>=1.0&&cpuvalue>=1.0&&hddpas==5&&temp<500&&"bad".equals(stored)){
                 //color green message
                status="Fair";
             }else if(checkram()<1.0||cpuvalue<1.0||hddpas==-5||temp>=500||"bad".equals(stored)){
                 //color red message
                 status="Bad";
             }
        }else if(osname.endsWith("8")&&osarch.endsWith("x64")){
            if(checkram()>=2.0&&cpuvalue>=1.0&&hddpas==5&&temp<500&&"good".equals(stored)){
                //color green message
                status="Good";
            }else if(checkram()>=2.0&&cpuvalue>=1.0&&hddpas==5&&temp<500&&"bad".equals(stored)){
                //color green message
                status="Fiar";
             }else if(checkram()<2.0||cpuvalue<1.0||hddpas==-5||temp>=500||"bad".equals(stored)){
                 //color red message
                 status="Bad";
             }
        
        }
        if(osname.endsWith("XP")){
             cpuxp=(cpuvalue/1024);
            if(checkram()>=0.5&&cpuxp>=0.78125&&hddpas==5&&temp<500&&"good".equals(stored)){
                //color green message
                status="Good";
             }else if(checkram()>=0.5&&cpuxp>=0.78125&&hddpas==5&&temp<500&&"bad".equals(stored)){
                //color green message
                status="Fair";
             }else if(checkram()<0.5||cpuxp<0.78125||hddpas==-5||temp>=500||"bad".equals(stored)){
                 //color red message
                 status="Bad";
             }
        }
        
        return "Your PC status is "+status;
    }//end of report
     
     
     
}//end of class PcInfo