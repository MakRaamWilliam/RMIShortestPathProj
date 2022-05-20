package rmi.client;


import rmi.server.GraphServer;

public class GraphManipulation {
	public static void main(String args[]) {
		try {
//			    GraphServer graphThread = new GraphServer();
//			    graphThread.start();

				Client clientThread = new Client();
				clientThread.start();
			    Client clientThread2 = new Client();
			    clientThread2.start();
//				Client clientThread3 = new Client();
//				clientThread3.start();


		} catch (Exception e) {
			System.err.println("GraphService exception:");
			e.printStackTrace();
		}
	}

}
