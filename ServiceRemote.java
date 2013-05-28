
// ServiceRemote.java  - the interface
 
import java.util.*;
 
import java.rmi.*;                 
public interface ServiceRemote extends Remote
{
   public ArrayList<String> view(String user) throws RemoteException ;
   public void add(ArrayList<String> list) throws RemoteException;
   public void remove(String id, String username, String type) throws RemoteException;
   public void modify( String username, ArrayList update, String old, String type) throws RemoteException;
   public void addEventCallBack(ClientRemote client) throws RemoteException;
   public void removeEventCallBack(ClientRemote client) throws RemoteException;
}
 
