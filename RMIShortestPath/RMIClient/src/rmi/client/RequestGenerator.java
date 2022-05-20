package rmi.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RequestGenerator {
	private ArrayList<String> operations ; 
	private double writingPercentage ;
	private int numOfQueries;
	private int numOfNodes ;
	Random nodeRandomGenerator ;
	Random operRandomGenerator ;
	public RequestGenerator(double writingPercentage , int numOfQueries , int numOfNodes) {
		 this.operations = new ArrayList<String>();
		 this.nodeRandomGenerator = new Random();
		 this.operRandomGenerator = new Random();
		 this.writingPercentage = writingPercentage;
		 this.numOfQueries = numOfQueries;
		 this.numOfNodes = numOfNodes;
	}
	
	public void setWritingPercentage(double writingPercentage) {
		this.writingPercentage = writingPercentage;
	}
	
	public void setNumOfQueries(int numOfQueries) {
		this.numOfQueries = numOfQueries;
	}
	
	public Request getReqeust() {
		
		constructRequest();
		String parsedRequest = "" ;
		for(String oper : operations) {
			parsedRequest+=oper;
			parsedRequest+="\n";
		}
		parsedRequest+="F";
		return new Request(parsedRequest , operations.size());
	}
	
	private  void constructRequest() {
		this.operations = new ArrayList<String>();
		for(int i=0;i<numOfQueries;i++) {
			if(i < numOfQueries*writingPercentage) {
				operations.add(generateWriteOperation());
			}else {
				operations.add(generateReadOperation());
			}
		}
        Collections.shuffle(operations);
	}
	
	private String generateTwoNodes() {
		int node1 = nodeRandomGenerator.nextInt(numOfNodes)+1;
		int node2 = nodeRandomGenerator.nextInt(numOfNodes)+1;
		return node1 + " " + node2 ;
	}
	
	private String generateWriteOperation() {
		int isAdd = operRandomGenerator.nextInt(2);
		if(isAdd== 1) {
			return "A " + generateTwoNodes();
		}else {
			return "D " + generateTwoNodes();
		}
	}
	
	private String generateReadOperation() {
		return "Q " + generateTwoNodes();
	}
}
