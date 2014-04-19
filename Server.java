package example.hello;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//This is a random comment, part 2
//I added this comment in github's editor, just to check it out
//Now this comment is going to be updated in github
//making another change

public class Server implements Hello {
	
	private int count =0;
	
    public Server() {}
	
    public String sayHello() {
		count++;
        return "Hello, world! " + count + " times ^_^";
    }
	
    public static void main(String args[]) {
        
        try {
            Server obj = new Server();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);
			
            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("Hello", stub);
			
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
