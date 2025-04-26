/*
 * Author: Brandon Edison
 * Date: 4/26/25
 * Summary: This program is going to be a client server model where users can connect and send messages
 * through a server to other clients using socket programming and multithreading 
 */


//import classes used for input and socket programming
import java.io.*;
import java.net.*;

public class MainClass {
	
	public void runServer()throws IOException{
		
		ServerSocket newSocketConnect = new ServerSocket(8080); //open socket and turn on with while loop
		boolean serverStatus = true;
		while (serverStatus) {
			
			try(Socket soc = newSocketConnect.accept(); //wait for a new socket connection
					//
				PrintWriter pval = new PrintWriter(soc.getOutputStream(), true);
				BufferedReader clientContent = new BufferedReader(new InputStreamReader(soc.getInputStream()));
					){
				String myData;
				while((myData = clientContent.readLine())!=null) {
					System.out.println(myData);
					pval.println("Server: Connected, sending this message to client");
					
				}
				
				serverStatus = false; //jump out of infinite loop
				
			}catch (IOException e) {
				System.out.println("I/O error occured: Client Closed the connection");
				break;
				
			}
		}
		//close the connection 
		newSocketConnect.close();
		System.out.println("Client has stopped, closing connection");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
