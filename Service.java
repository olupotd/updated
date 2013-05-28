
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Service {
  public Service() throws RemoteException{
	}
public static void main(String args[])  {
   String host="localhost";    // RMI host name
    try  {
      // bind to RMI server
      ServiceImplem h = new ServiceImplem();
      Naming.rebind("rmi://douglas-R580/ServiceRemote", h);
      System.out.println("Host Up and Running...."); 
    }
    catch (RemoteException re)
    {
      System.out.println("Remote Exception " + re);
    }
    catch (Exception e)
    {
      System.out.println(" Exception " + e);
    }
  }
  
 }
