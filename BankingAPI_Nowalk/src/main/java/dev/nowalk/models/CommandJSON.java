package dev.nowalk.models;

public class CommandJSON {
	
	private String command;
	private double amount;
	public CommandJSON() {
		super();
	}
	
	public CommandJSON(String command, double amount) {
		super();
		this.command = command;
		this.amount = amount;
	}
	
	public String getCommand() {
		return command;
	}
	
	public void setCommand(String command) {
		this.command = command;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
