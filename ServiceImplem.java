
import java.io.*;
import java.rmi.RemoteException;
import java.util.*;
import java.util.Calendar;
import java.util.concurrent.PriorityBlockingQueue;

public class ServiceImplem extends java.rmi.server.UnicastRemoteObject implements ServiceRemote//, Runnable {
{
private static final long serialVersionUID = -2752195941407964900L;
File file;
 BufferedReader reader;
 String line = null;
 Calendar c;
 PrintWriter printer;
 PriorityBlockingQueue<String> users;
 PriorityBlockingQueue<String> events;
 private int length;
 ClientRemote client;
 private Vector list = new Vector();
 
public ServiceImplem() throws RemoteException
{
 super();
        this.c = Calendar.getInstance();
}

   public void addEventCallBack(ClientRemote client) throws RemoteException{
     System.out.println ("adding Client -" + client);
	list.add (client);
   }
   
   public void removeEventCallBack(ClientRemote client) throws RemoteException{
   	System.out.println ("removing Client -" + client);
	list.remove (client);
   }
   
  	
private void notifyListeners(String item) {
	// Notify every listener in the registered list
	for (Enumeration e = list.elements(); e.hasMoreElements(); ) {
	ClientRemote listener = (ClientRemote)e.nextElement();
	// Notify, if possible a listener
	try{
	listener.alert (item);
	}catch (RemoteException re){System.out.println ("removing listener -" + listener);
	// Remove the listener
	list.remove( listener );
	}
	}
}

private ArrayList dates(String user, String type){
String line = null;
ArrayList dat = new ArrayList();
	try{
	if(type.equalsIgnoreCase("private") || type.equalsIgnoreCase("public")){
	BufferedReader real = new BufferedReader(new FileReader(new File("UserEvents.log")));
	while((line = real.readLine()) != null){
        String[] x = line.split(" ", 0);
        if((x[0].matches("PRIVATE")  && x[2].matches(user)) || x[0].matches("PUBLIC")){
        dat.add(x[6]+" "+x[8]);
        continue;
        }
       	x = null;
        line = reader.readLine();
        }
	real.close();
	}else {
	BufferedReader real = new BufferedReader(new FileReader(new File("GroupEvents.log")));
	while((line = reader.readLine()) != null){
        String[] l = line.split(" ", 0);
        for(int y=0; y<getGroup(user).size(); y++){
        if((l[0].matches("GROUP") && l[3].matches(user)) || l[1].matches(getGroup(user).get(y).toString())){
        dat.add(l[7]+" "+l[9]);
        }
        continue; 
        }
       	l = null;
        line = reader.readLine();
        }
	}
	}catch(Exception f) {}
return dat;
}

private boolean validateDates(String date, String type, String user){
//first get the dates already existing in specified type of event
boolean ok = false;
ArrayList dats = dates(user, type);
for(int j=0; j<dats.size(); j++){
	String []pair = dats.get(j).toString().split(" ");
	if(pair[0].matches(date) || pair[1].matches(date)){
	ok = true;
	break;
	}
	pair = null;
}

return ok;
}
@Override
public synchronized void add(ArrayList<String> list) throws RemoteException {
String dt = "Event Not Added";
String start = list.get(0).toString();
	//validate the dates being added with those already existing
	if(!validateDates(list.get(3), start, list.get(1))){
	try{
	File u = new File("UserEvents.log"); //both user and public events shal be written in this file
	File g = new File("GroupEvents.log");
	//create the missing files if they are not there
	if(!u.exists() &&!g.exists()){
	g.createNewFile();
	u.createNewFile(); 
	}
	//check for type of event to be written in the 3 if's
	if(start.startsWith("private")){
	printer = new PrintWriter(new FileWriter(u, true));
	printer.println("PRIVATE Creator "+list.get(1)+" Event "+list.get(2)+" StartDate "+list.get(3)+" StopDate "+list.get(4)+" Created "+c.getTime());
	printer.flush();
	dt = "Private event has been created";
	}
	else if(start.startsWith("public")){
	printer = new PrintWriter(new FileWriter(u, true));
	printer.println("PUBLIC Creator "+list.get(1)+" Event "+list.get(2)+" StartDate "+list.get(3)+" StopDate "+list.get(4)+" Created "+c.getTime());
	printer.flush();
	dt = "Public event has been created";
	}
	else { //assume type is group and brands type to be the group name
	printer = new PrintWriter(new FileWriter(g, true));
	printer.println("GROUP "+list.get(0)+" Creator "+list.get(1)+" Event "+list.get(2)+" StartDate "+list.get(3)+" StopDate "+list.get(4)+" Created "+c.getTime());
	printer.flush();
	dt = "Group event has been created";
	}
	}catch(Exception q){}
	
	}else{
	dt="Conflicting Dates, Try again";
	}	
	notifyListeners(dt);
}

@Override
public ArrayList<String> view(String user) throws RemoteException {
ArrayList <String>event = new ArrayList<>();;
String realine = null, line;
	try{  
	if(new File("UserEvents.log").exists() && new File("GroupEvents.log").exists()){  
	//read the private and public event events first
	synchronized(this){
	BufferedReader reader = new BufferedReader(new FileReader(new File("UserEvents.log")));
        while((realine = reader.readLine()) != null){
        String[] x = realine.split(" ", 0);
        if((x[0].matches("PRIVATE")  && x[2].matches(user)) || x[0].matches("PUBLIC")){
        event.add(realine);
        continue;
        }
       	x = null;
        realine = reader.readLine();
        }
        reader.close();
        //read the group events for that user
        reader = new BufferedReader(new FileReader(new File("GroupEvents.log")));
        while((line = reader.readLine()) != null){
        String[] l = line.split(" ", 0);
        for(int y=0; y<getGroup(user).size(); y++){
        if((l[0].matches("GROUP") && l[3].matches(user)) || l[1].matches(getGroup(user).get(y).toString())){
       // notifyListeners(""+l[3].matches(user));
        event.add(line);
        }
        continue; 
        }
       	l = null;
        line = reader.readLine();
        }
        reader.close();
   	}
   	}else{
	notifyListeners("Looks like You Don't have any Viewable Events");	
   	}
   	}catch(Exception real){}

 return event;
}
private ArrayList getGroup(String user){
ArrayList grp = new ArrayList();
int d = 0;
String line = null;
	try{
	BufferedReader reader = new BufferedReader(new FileReader(new File("GroupEvents.log")));
        while((line = reader.readLine()) != null){
        String[] l = line.split(" ", 0);
        if(l[3].matches(user)){
       	grp.add(l[1]);
        continue;    
        }
       	l = null;
        line = reader.readLine();
        }
        reader.close();
	}catch(Exception f) {}
return grp;
}

private boolean delete(String user, String type, String id ){
String realine = null;
boolean fin = false;
	try{
	if(type.startsWith("private") || type.startsWith("public")){
	//private or public event to be remove
	File temp = new File("tempUser.log");
	PrintWriter write = new PrintWriter(new FileWriter(temp, true));
	BufferedReader reader = new BufferedReader(new FileReader(new File("UserEvents.log")));
        while((realine = reader.readLine()) != null){
        String[] x = realine.split(" ", 0);
        if((x[0].matches("PRIVATE")  && x[2].matches(user)) || (x[0].matches("PUBLIC") && x[2].matches(user))){
        if(!realine.matches(id)){
        write.println(realine);
        write.flush();
        fin = true;
        }
        continue;
        }
       	x = null;
        realine = reader.readLine();
        }
        reader.close();
        write.close();
 	//rename the file to original one
 	new File("UserEvents.log").delete();
 	temp.renameTo(new File("UserEvents.log"));
 	}else{
 	//group events
 	String line = null;
 	File temp = new File("tempGroup.log");
	PrintWriter write = new PrintWriter(new FileWriter(temp, true));
	BufferedReader reader = new BufferedReader(new FileReader(new File("GroupEvents.log")));
     	while((line = reader.readLine()) != null){
        String[] l = line.split(" ", 0);
        if(l[0].matches("GROUP") && l[3].matches(user)){
        if(!realine.matches(id)){
        write.println(realine);
        write.flush();
        fin = true;
        }
      	continue; 
        }
       	l = null;
        line = reader.readLine();
        }
        reader.close();
        write.close();
 	//rename the file to original one
 	new File("GroupEvents.log").delete();
 	temp.renameTo(new File("GroupEvents.log"));
 	}
	}catch(Exception del) {}
return fin;
}
@Override
public synchronized void remove(String id, String username, String type) throws RemoteException{
	if(delete(username,  type, id )) notifyListeners(username+" removed a "+id+" event at "+ new java.util.Date());
	else notifyListeners(username+" was unable to remove Event of type"+type+" and id "+id);
}

private boolean modify(String id, String username, String oldevent, ArrayList update){
boolean modified = false;
String realine = null;
//y(username, update, event, type);

	try{
	if(id.startsWith("private") || id.startsWith("public")){
	File temp = new File("tempUser.log");
	PrintWriter write = new PrintWriter(new FileWriter(temp, true));
	BufferedReader reader = new BufferedReader(new FileReader(new File("UserEvents.log")));
        while((realine = reader.readLine()) != null){
        String[] x = realine.split(" ", 0);
        //check for the type of event 
        if(x[0].matches(id.toUpperCase())  && x[2].matches(username)){
        	if(!realine.matches(oldevent)){
        	write.println(realine);
        	write.flush();
        	}else{
write.println(id.toUpperCase()+" Creator "+username+" Event "+update.get(0)+" StartDate "+update.get(1)+" StopDate "+update.get(2)+" Created "+new java.util.Date().toString());
        	write.flush();
        	}
        modified = true;
        continue;
        }
        x = null;
        realine = reader.readLine();
        }
         reader.close();
        write.close();
 	//rename the file to original one
 	new File("UserEvents.log").delete();
 	temp.renameTo(new File("UserEvents.log"));

        }
       	else{
	
	}
	
	}catch(Exception mod) {}
return modified;
}

@Override
public synchronized void modify(String username, ArrayList update, String oldevent, String type) throws RemoteException{

	if(modify(type, username, oldevent, update)) notifyListeners(username+" updated a "+type+" event");
	else notifyListeners(username+" failed to update a "+type+" event");
  
}
}
