/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mos;

import javax.swing.JOptionPane;

/**
 *
 * @author finalist
 */
public class CheckStatus extends PcInfo{
    
    ImprovePcPerformance improve = new ImprovePcPerformance();
    int option;
    public String prepareStatus(){
        diskanalysis();
        finalStatus=checkOSInfo()+"\n\nRam Capacity is "+checkram()+" GB"+"\n\nProcessor Speed is "+checkProcessorCapacity()+"\n\nTemp folder size is "+
                checkTempfolderCapacity()+"\n\n"+checkHDDCapacity()+"\n\n\t\t"+diskAnalysisInfo()+"\n\n\t\t"+report();

        return finalStatus.trim();
    }//end of preparestatus
    
    public String displayRecommendation(){
        if(osname.endsWith("7")&&osarch.endsWith("x86")){
             if(checkram()>=1.0&&cpuvalue>=1.0&&hddpas==5&&temp<500){
                recommendation+="Blow dust out of Your PC incase You have taken long without doing so\n\n";
             }else if(checkram()<1.0){
                 recommendation+="Upgrade your RAM\n";
             }else if(cpuvalue<1.0){
                 recommendation+="Buy a new Computer with better processing speed\n";
             }else if(hddpas==-5){
                 recommendation+="Clean up your disks colored red\n";
                        option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clean your red disks?",
                                "Disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();
                        }else{
                            //do nothing
                        }
                 
             }else if(temp>=500){
                 recommendation+="Clear Temp folder\n";
                        option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder?",
                                "Temp cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.cleartemp();
                        }else{
                            //do nothing
                        }
                
             }else if(checkram()<1.0&&cpuvalue<1.0){
                 recommendation+="Upgrade your RAM or Buy a new Computer with better processing and RAM capacities";
             }else if(checkram()<1.0&&hddpas==-5){
                recommendation+="Upgrade your RAM and Clean up your disks colored red\n";
                        option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clean your red disks?",
                                "Disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();
                        }else{
                            //do nothing
                        }
                
             }else if(checkram()<1.0&&temp>=500){
                recommendation+="Upgrade your RAM and Clear Temp folder\n";
                        option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder?",
                                "Temp cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.cleartemp();
                        }else{
                            //do nothing
                        }
                
             }else if(cpuvalue<1.0&&hddpas==-5){
                recommendation+="Clean up your disks colored red or Buy a new Computer with better processing speed\n";
                        option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clean your red disks?",
                                "Disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();
                        }else{
                            //do nothing
                        }
                
             }else if(cpuvalue<1.0&&temp<500){
                recommendation+="Clear Temp folder or Buy a new Computer with better processing speed\n";
                       option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder?",
                                "Temp cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.cleartemp();
                        }else{
                            //do nothing
                        }
               
             }else if(checkram()<1.0&&cpuvalue<1.0&&hddpas==-5){
                recommendation+="Upgrade your RAM,Clean up your disks colored red or "
                        + "Buy a new Computer with better processing and RAM capacities\n";
                        option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clean your red disks?",
                                "Disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();
                        }else{
                            //do nothing
                        }
                
             }else if(checkram()<1.0&&cpuvalue<1.0&&temp>=500){
                recommendation+="Upgrade your RAM,Clear your Temp folder or Buy a new Computer with better processing and RAM capacities\n";
                        option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder?",
                                "Temp cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.cleartemp();
                        }else{
                            //do nothing
                        }
 
             }else if(cpuvalue<1.0&&hddpas==-5&&temp>=500){
                recommendation+="Clear your Temp folder,Clean up your disks colored red or "
                        + "Buy a new Computer with better processing and RAM capacities \n";
                        option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder and Clean up the red diks?",
                                "Temp and disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();improve.cleartemp();
                        }else{
                            //do nothing
                        }
                
             }else if(checkram()<1.0&&hddpas==-5&&temp>=500){
                recommendation+="Upgrade your RAM,Clean up your disks colored red and Clear Temp folder\n";
                         option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder and Clean up the red diks?",
                                "Temp and disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();improve.cleartemp();
                        }else{
                            //do nothing
                        }
                
             }else if(checkram()<1.0&&cpuvalue<1.0&&hddpas==-5&&temp>=500){
                recommendation+="Upgrade your RAM,Clean up your disks colored red, Clear Temp folder or "
                        + "Buy a new Computer with better processing and RAM capacities\n";
                        option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder and Clean up the red diks?",
                                "Temp and disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();improve.cleartemp();
                        }else{
                            //do nothing
                        }
                
             }
             //call defragmentation
             if(recommendation.contains("You need to defragment this volume")){
                        option = JOptionPane.showConfirmDialog(null,
                                "Do you want to defragment this volume?",
                                "defragmenting volume", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.defrag(keys);
                        }else{
                            //do nothing
                        }
                 
             }
            
        }else if(osname.endsWith("7")&&osarch.endsWith("x64")){
            if(checkram()>=2.0&&cpuvalue>=1.0&&hddpas==5&&temp<500){
                recommendation+="Blow dust out of Your PC incase You have taken long without doing so\n\n";
             }else if(checkram()<2.0){
                 recommendation+="Upgrade your RAM\n";
             }else if(cpuvalue<1.0){
                 recommendation+="Buy a new Computer with better processing speed\n";
             }else if(hddpas==-5){
                 recommendation+="Clean up your disks colored red\n";
                 option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clean your red disks?",
                                "Disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();
                        }else{
                            //do nothing
                        }
             }else if(temp>=500){
                 recommendation+="Clear Temp folder\n";
                 option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder?",
                                "Temp cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }else if(checkram()<2.0&&cpuvalue<1.0){
                 recommendation+="Upgrade your RAM or Buy a new Computer with better processing and RAM capacities";
             }else if(checkram()<2.0&&hddpas==-5){
                recommendation+="Upgrade your RAM and Clean up your disks colored red\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clean your red disks?",
                                "Disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();
                        }else{
                            //do nothing
                        }
             }else if(checkram()<2.0&&temp>=500){
                recommendation+="Upgrade your RAM and Clear Temp folder\n";
                        option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder?",
                                "Temp cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }else if(cpuvalue<1.0&&hddpas==-5){
                recommendation+="Clean up your disks colored red or Buy a new Computer with better processing speed\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clean your red disks?",
                                "Disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();
                        }else{
                            //do nothing
                        }
             }else if(cpuvalue<1.0&&temp<500){
                recommendation+="Clear Temp folder or Buy a new Computer with better processing speed\n";
                        option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder?",
                                "Temp cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }else if(hddpas==-5&&temp>=500){
                recommendation+="Clean up your disks colored red and Clear Temp folder\n";
                        option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder and Clean up the red diks?",
                                "Temp and disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }else if(checkram()<2.0&&cpuvalue<1.0&&hddpas==-5){
                recommendation+="Upgrade your RAM,Clean up your disks colored red or "
                        + "Buy a new Computer with better processing and RAM capacities\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clean your red disks?",
                                "Disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();
                        }else{
                            //do nothing
                        }
             }else if(checkram()<2.0&&cpuvalue<1.0&&temp>=500){
                recommendation+="Upgrade your RAM,Clear your Temp folder or Buy a new Computer with better processing and RAM capacities\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder?",
                                "Temp cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }else if(cpuvalue<1.0&&hddpas==-5&&temp>=500){
                recommendation+="Clear your Temp folder,Clean up your disks colored red or "
                        + "Buy a new Computer with better processing and RAM capacities \n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder and Clean up the red diks?",
                                "Temp and disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }else if(checkram()<2.0&&hddpas==-5&&temp>=500){
                recommendation+="Upgrade your RAM,Clean up your disks colored red and Clear Temp folder\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder and Clean up the red diks?",
                                "Temp and disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }else if(checkram()<2.0&&cpuvalue<1.0&&hddpas==-5&&temp>=500){
                recommendation+="Upgrade your RAM,Clean up your disks colored red, Clear Temp folder or "
                        + "Buy a new Computer with better processing and RAM capacities\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder and Clean up the red diks?",
                                "Temp and disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }
            if(recommendation.contains("You need to defragment this volume")){
                 option = JOptionPane.showConfirmDialog(null,
                                "Do you want to defragment this volume?",
                                "defragmenting volume", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.defrag(keys);
                        }else{
                            //do nothing
                        }
             }
        }
        if(osname.endsWith("8")&&osarch.endsWith("x86")){
             if(checkram()>=1.0&&cpuvalue>=1.0&&hddpas==5&&temp<500){
                 recommendation+="Blow dust out of Your PC incase You have taken long without doing so\n\n";
             }else if(checkram()<1.0){
                 recommendation+="Upgrade your RAM\n";
             }else if(cpuvalue<1.0){
                 recommendation+="Buy a new Computer with better processing speed\n";
             }else if(hddpas==-5){
                 recommendation+="Clean up your disks colored red\n";
                 option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clean your red disks?",
                                "Disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();
                        }else{
                            //do nothing
                        }
             }else if(temp>=500){
                 recommendation+="Clear Temp folder\n";
                 option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder?",
                                "Temp cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }else if(checkram()<1.0&&cpuvalue<1.0){
                 recommendation+="Upgrade your RAM or Buy a new Computer with better processing and RAM capacities";
             }else if(checkram()<1.0&&hddpas==-5){
                recommendation+="Upgrade your RAM and Clean up your disks colored red\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clean your red disks?",
                                "Disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();
                        }else{
                            //do nothing
                        }
             }else if(checkram()<1.0&&temp>=500){
                recommendation+="Upgrade your RAM and Clear Temp folder\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder?",
                                "Temp cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }else if(cpuvalue<1.0&&hddpas==-5){
                recommendation+="Clean up your disks colored red or Buy a new Computer with better processing speed\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clean your red disks?",
                                "Disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();
                        }else{
                            //do nothing
                        }
             }else if(cpuvalue<1.0&&temp<500){
                recommendation+="Clear Temp folder or Buy a new Computer with better processing speed\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder?",
                                "Temp cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }else if(hddpas==-5&&temp>=500){
                recommendation+="Clean up your disks colored red and Clear Temp folder\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder and Clean up the red diks?",
                                "Temp and disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }else if(checkram()<1.0&&cpuvalue<1.0&&hddpas==-5){
                recommendation+="Upgrade your RAM,Clean up your disks colored red or "
                        + "Buy a new Computer with better processing and RAM capacities\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clean your red disks?",
                                "Disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();
                        }else{
                            //do nothing
                        }
             }else if(checkram()<1.0&&cpuvalue<1.0&&temp>=500){
                recommendation+="Upgrade your RAM,Clear your Temp folder or "
                        + "Buy a new Computer with better processing and RAM capacities\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder?",
                                "Temp cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }else if(cpuvalue<1.0&&hddpas==-5&&temp>=500){
                recommendation+="Clear your Temp folder,Clean up your disks colored red or "
                        + "Buy a new Computer with better processing and RAM capacities \n";
               option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder and Clean up the red diks?",
                                "Temp and disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }else if(checkram()<1.0&&hddpas==-5&&temp>=500){
                recommendation+="Upgrade your RAM,Clean up your disks colored red and Clear Temp folder\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder and Clean up the red diks?",
                                "Temp and disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }else if(checkram()<1.0&&cpuvalue<1.0&&hddpas==-5&&temp>=500){
                recommendation+="Upgrade your RAM,Clean up your disks colored red, Clear Temp folder or "
                        + "Buy a new Computer with better processing and RAM capacities\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder and Clean up the red diks?",
                                "Temp and disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }
             if(recommendation.contains("You need to defragment this volume")){
                 option = JOptionPane.showConfirmDialog(null,
                                "Do you want to defragment this volume?",
                                "defragmenting volume", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.defrag(keys);
                        }else{
                            //do nothing
                        }
             }
             
        }else if(osname.endsWith("8")&&osarch.endsWith("x64")) {
            if(checkram()>=2.0&&cpuvalue>=1.0&&hddpas==5&&temp<500){
                recommendation+="Blow dust out of Your PC incase You have taken long without doing so\n\n";
             }else if(checkram()<2.0){
                 recommendation+="Upgrade your RAM\n";
             }else if(cpuvalue<1.0){
                 recommendation+="Buy a new Computer with better processing speed\n";
             }else if(hddpas==-5){
                 recommendation+="Clean up your disks colored red\n";
                 option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clean your red disks?",
                                "Disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();
                        }else{
                            //do nothing
                        }
             }else if(temp>=500){
                 recommendation+="Clear Temp folder\n";
                 option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder?",
                                "Temp cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }else if(checkram()<2.0&&cpuvalue<1.0){
                 recommendation+="Upgrade your RAM or Buy a new Computer with better processing and RAM capacities";
             }else if(checkram()<2.0&&hddpas==-5){
                recommendation+="Upgrade your RAM and Clean up your disks colored red\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clean your red disks?",
                                "Disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();
                        }else{
                            //do nothing
                        }
             }else if(checkram()<2.0&&temp>=500){
                recommendation+="Upgrade your RAM and Clear Temp folder\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder?",
                                "Temp cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }else if(cpuvalue<1.0&&hddpas==-5){
                recommendation+="Clean up your disks colored red or Buy a new Computer with better processing speed\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clean your red disks?",
                                "Disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();
                        }else{
                            //do nothing
                        }
             }else if(cpuvalue<1.0&&temp<500){
                recommendation+="Clear Temp folder or Buy a new Computer with better processing speed\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder?",
                                "Temp cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }else if(hddpas==-5&&temp>=500){
                recommendation+="Clean up your disks colored red and Clear Temp folder\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder and Clean up the red diks?",
                                "Temp and disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }else if(checkram()<2.0&&cpuvalue<1.0&&hddpas==-5){
                recommendation+="Upgrade your RAM,Clean up your disks colored red or "
                        + "Buy a new Computer with better processing and RAM capacities\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clean your red disks?",
                                "Disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();
                        }else{
                            //do nothing
                        }
             }else if(checkram()<2.0&&cpuvalue<1.0&&temp>=500){
                recommendation+="Upgrade your RAM,Clear your Temp folder or "
                        + "Buy a new Computer with better processing and RAM capacities\n";
                        option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder?",
                                "Temp cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }else if(cpuvalue<1.0&&hddpas==-5&&temp>=500){
                recommendation+="Clear your Temp folder,Clean up your disks colored red or "
                        + "Buy a new Computer with better processing and RAM capacities \n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder and Clean up the red diks?",
                                "Temp and disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }else if(checkram()<2.0&&hddpas==-5&&temp>=500){
                recommendation+="Upgrade your RAM,Clean up your disks colored red and Clear Temp folder\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder and Clean up the red diks?",
                                "Temp and disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }else if(checkram()<2.0&&cpuvalue<1.0&&hddpas==-5&&temp>=500){
                recommendation+="Upgrade your RAM,Clean up your disks colored red, Clear Temp folder or "
                        + "Buy a new Computer with better processing and RAM capacities\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder and Clean up the red diks?",
                                "Temp and disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }
            if(recommendation.contains("You need to defragment this volume")){
                 option = JOptionPane.showConfirmDialog(null,
                                "Do you want to defragment this volume?",
                                "defragmenting volume", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.defrag(keys);
                        }else{
                            //do nothing
                        }
             }
        
        }
        if(osname.endsWith("XP")){
            cpuxp=(cpuvalue/1024);
            if(checkram()>=0.5&&cpuxp<0.78125&&hddpas==5&&temp<500){
                recommendation+="Blow dust out of Your PC incase You have taken long without doing so\n\n";
             }else if(checkram()<0.5){
                 recommendation+="Upgrade your RAM\n";
             }else if(cpuxp<0.78125){
                 recommendation+="Buy a new Computer with better processing speed\n";
             }else if(hddpas==-5){
                 recommendation+="Clean up your disks colored red\n";
                 option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clean your red disks?",
                                "Disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();
                        }else{
                            //do nothing
                        }
             }else if(temp>=500){
                 recommendation+="Clear Temp folder\n";
                 option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder?",
                                "Temp cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }else if(checkram()<0.5&&cpuxp<0.78125){
                 recommendation+="Upgrade your RAM or Buy a new Computer with better processing and RAM capacities";
             }else if(checkram()<0.5&&hddpas==-5){
                recommendation+="Upgrade your RAM and Clean up your disks colored red\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clean your red disks?",
                                "Disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();
                        }else{
                            //do nothing
                        }
             }else if(checkram()<0.5&&temp>=500){
                recommendation+="Upgrade your RAM and Clear Temp folder\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder?",
                                "Temp cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }else if(cpuxp<0.78125&&hddpas==-5){
                recommendation+="Clean up your disks colored red or Buy a new Computer with better processing speed\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clean your red disks?",
                                "Disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();
                        }else{
                            //do nothing
                        }
             }else if(cpuxp<0.78125&&temp<500){
                recommendation+="Clear Temp folder or Buy a new Computer with better processing speed\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder?",
                                "Temp cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }else if(hddpas==-5&&temp>=500){
                recommendation+="Clean up your disks colored red and Clear Temp folder\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder and Clean up the red diks?",
                                "Temp and disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }else if(checkram()<0.5&&cpuxp<0.78125&&hddpas==-5){
                recommendation+="Upgrade your RAM,Clean up your disks colored red or "
                        + "Buy a new Computer with better processing and RAM capacities\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clean your red disks?",
                                "Disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();
                        }else{
                            //do nothing
                        }
             }else if(checkram()<0.5&&cpuxp<0.78125&&temp>=500){
                recommendation+="Upgrade your RAM,Clear your Temp folder or Buy a new Computer with better processing and RAM capacities\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder?",
                                "Temp cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }else if(cpuxp<0.78125&&hddpas==-5&&temp>=500){
                recommendation+="Clear your Temp folder,Clean up your disks colored red or "
                        + "Buy a new Computer with better processing and RAM capacities \n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder and Clean up the red diks?",
                                "Temp and disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }else if(checkram()<0.5&&hddpas==-5&&temp>=500){
                recommendation+="Upgrade your RAM,Clean up your disks colored red and Clear Temp folder\n";
                option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder and Clean up the red diks?",
                                "Temp and disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }else if(checkram()<0.5&&cpuxp<0.78125&&hddpas==-5&&temp>=500){
                recommendation+="Upgrade your RAM,Clean up your disks colored red, Clear Temp folder or "
                        + "Buy a new Computer with better processing and RAM capacities\n";
               option = JOptionPane.showConfirmDialog(null,
                                "Do you want to clear Temp Folder and Clean up the red diks?",
                                "Temp and disk cleaning", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.diskcleanUp();improve.cleartemp();
                        }else{
                            //do nothing
                        }
             }
            if(recommendation.contains("You need to defragment this volume")){
                 option = JOptionPane.showConfirmDialog(null,
                                "Do you want to defragment this volume?",
                                "defragmenting volume", JOptionPane.YES_NO_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            improve.defrag(keys);
                        }else{
                            //do nothing
                        }
             }
        }
        
        
      return recommendation.trim();  
         
    }//end of recommendation
    
    
}
