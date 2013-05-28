

import java.rmi.*;                 
public interface ClientRemote extends Remote
{
   public void alert(String al) throws RemoteException;
}
 
