package rmi.client;

public class Request {
	private String operations ; 
	private int numOfOperations ;
	private long responseTime ;
	private String reponse ;
	private double writePercentage ;
	public Request(String operations , int numOfOperations) {
		this.operations = operations;
		this.numOfOperations = numOfOperations;
	}
	public String getOperations() {
		return operations;
	}
	public int getNumOfOperations() {
		return numOfOperations;
	}
	public long getResponseTime() {
		return responseTime;
	}
	
	public void setResponseTime(long responseTime) {
		this.responseTime = responseTime;
	}
	
	public String getReponse() {
		return reponse;
	}
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	
	public double getWritePercentage() {
		return writePercentage ;
	}

	public void setWritePercentage(double writePercentage) {
		this.writePercentage = writePercentage;
	}
}
