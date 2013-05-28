

import java.rmi.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author douglas
 */
public class Client extends java.rmi.server.UnicastRemoteObject  implements ClientRemote
{  
	//Default constructor to throw Exception on behalf of the class
  public Client() throws RemoteException{
	super();
  }
	
  public static void main(String args[])  {
  String eval = null;
  ArrayList events = null;
  String username = null, host = "douglas-R580";
  
  ArrayList <String>qwe = new ArrayList <>(); //used to store events to be creaed by the user 
  	//shall be activated when there is need for dynamic class loading
    /* System.setSecurityManager(new RMISecurityManager()); */
    try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
    {
     if(args.length <= 0){
     System.out.println("ERROR! \nUsage==> java rmid.Client serverIp username");
     System.exit(-1);}
     else{
    	host = args[0];
    	username = args[1];
     }
      // lookup RMI Calendar server
      ServiceRemote look = (ServiceRemote) Naming.lookup("rmi://"+host+"/ServiceRemote");
      Client climb = new Client();
      look.addEventCallBack(climb);
      try{
      //display the menu for the user to follow when picking an option.
      do{
      System.out.println("\nWelcome "+username+
      			" Please proceed with an option below\n\t"+
      			"add===>create an event\n\t"+
      			"modify===>update an event date\n\t"+
      			"view===>View a list of all your events");
      String option = reader.readLine();// wait for input from a user as a selection
      //if user inputs an option starting with add
      if(option.startsWith("add")){
      //prompt for more information about the event
      	 System.out.println("What type of event is this(private, public group(specify the group name in this case))");
      	 eval = reader.readLine();
      	 qwe.add(eval);//type====>0
      	 qwe.add(username);//user====>1
      	 System.out.println("Please describe the event");
      	 eval = reader.readLine();
      	 qwe.add(eval);//desc====>2

      	 System.out.println("Enter Date of Commencement(dd/mm/yy/hour/min)");
    		eval = reader.readLine();
    		qwe.add(eval);//===>3
    		
      	 System.out.println("Enter Date of Expiry(dd/mm/yy/hour/min)");
    		eval = reader.readLine();
      	 qwe.add(eval);//stopd===>4
      	 //send the information to the server and print the feedbask
      	 look.add(qwe);
         qwe.clear();//clear the arraylist so that it can be reused. No caching
      }else if(option.startsWith("modify")){ //if user inputs an option starting with modify for changing the event
      	int opt = 0;
      	boolean full = false;
      	do{
      	System.out.println("Enter 1 to modify or 2 to delete and event");
      	opt = Integer.parseInt(reader.readLine());
      		switch(opt){
      			case 1: 
      				System.out.println("Apologies! "+username+" This functionality Still under maintanance");
      				full = true;
      				/*in case a user wants to delete
      			ArrayList update = new ArrayList();
      				System.out.println("Please select an event to update from below:"); int m = 0;
      				//display the events currently available and let the user select from the list. only events he can modify
      				ArrayList even = look.view(username);
      				for(int j=0; j<even.size(); j++){
      				System.out.println("ID>>"+j+": "+even.get(j));  	}
      				//allow the user to edit the event by entering the line number to edit
      				System.out.println("Enter the Id of the event to update");
      				String ident = reader.readLine();
      				//retreive the event details
      				String event = (String) even.get(Integer.parseInt(ident));
      				//get the update/new version to be saved 
      				System.out.println("Enter the new Description:");
      				String updat = reader.readLine();
      				update.add(updat);
      				System.out.println("Enter the new start date. Format:(dd/mm//yy)");
      				String startd = reader.readLine();
      				update.add(startd);
      				System.out.println("Enter the new stop date. Format:(dd/mm//yy)");
      				String stopd = reader.readLine();
      				update.add(stopd);
      				System.out.println("Enter the type of event to be updated:");
      				String type = reader.readLine();
      				//send the information to the server and print the feedbask
      				look.modify(username, update, event, type);
      				full = true;*/
      			break;
      			case 2: //if the user desires to make an update on the events.Display all events available
      				int p = 0; //used to keep track of the index of events in the arraylist
     				System.out.println("Please select an event to remove from below:");
     				//retreive the events in store and display them for the user to make a selection.
 			     	ArrayList eve = look.view(username);
      				for(int j=0; j<eve.size(); j++){
      				System.out.println("ID>>"+j+": "+eve.get(j));  	}
			        System.out.println("Enter the Id of the event to remove");
			        String id = reader.readLine();
			        System.out.println("Enter the type of the event to remove");
			        String typ = reader.readLine();
			        String evnt = (String) eve.get(Integer.parseInt(id));
			        //call the remote method to execute the removal of the event using the created object.
			        look.remove(evnt, username, typ);
			        full = true;
      			break;
      			default: //if the user make an invalid choice. ie didn't enter the right value
      				System.out.println("Invlaid choice made try again");
      			break;
      		}
      	}while(full != true);
      	
      	
      } else if(option.startsWith("view")){
      int k = 0;
	//display the events in store by invoking the view object at the server.   
       System.out.println("Below are the Events currently in store:");
      	ArrayList even = look.view(username);
      	for(int j=0; j<even.size(); j++){
      	System.out.println(k+": "+even.get(j)); k++;
      	}
     }
     //in case the user made an invalid choice, alert them and let them retry again
     else{
     System.out.println("You did not make a Valid choice, Please try again...");
     }  
     }while(true);
     //Register for Server Callbacks in case of any upcoming or openevents available from the server.
     }catch(Exception fall){
     //remove the client un register the client from the server in case he disconnects
      look.removeEventCallBack(climb);
     }
    }// en as usual throw an exception in case any thing crazy happened.
 	
    catch (IOException | NotBoundException | NumberFormatException e)
    {
      System.out.println("Exception in main " + e);
      
    }
  }
  
  //this is the implementation of the call back from the server in case there is need for the server to alert the client
  @Override
  public void alert(String alerts) throws RemoteException{
  System.out.println("Notification: "+alerts);
  }
} 
