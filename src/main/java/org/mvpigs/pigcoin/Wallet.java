package org.mvpigs.pigcoin;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;

public class Wallet {
	//attributes
	private PublicKey address = null;
	private PrivateKey sKey = null;
	private double total_input = 0d;
	private double total_output = 0d;
	private double balance = 0d;
	
	//constructor
	public Wallet() {
		
	}

	//getters & setters
	public void setSK(PrivateKey privateKey) {
		this.sKey = privateKey;		
	}

	public void setAddress(PublicKey publicKey) {
		this.address = publicKey;
	}

	public PublicKey getAddress() {
		return this.address;
	}
	public double getTotalInput() {
		return this.total_input;
	}
	public double getTotalOutput() {
		return this.total_output;
	}
	public double getBalance() {
		return this.balance;
	}
	//methods
	public void generateKeyPair() {
		KeyPair pair = GenSig.generateKeyPair();
		setSK(pair.getPrivate());
		setAddress(pair.getPublic());
	}
	
	public String toString() {
		String message = "Wallet: " + getAddress().hashCode() + "\n Total input: "+ getTotalInput();
		message += "\n Total output: " + getTotalOutput() + "\n Balance: " + getBalance() + "\n";
		return message;
	}
}
