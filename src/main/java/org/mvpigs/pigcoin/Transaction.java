package org.mvpigs.pigcoin;

import java.security.PublicKey;

public class Transaction {

	//attributes
	private String hash = "";
	private String prev_hash = "";
	private PublicKey pKey_sender = null;
	private PublicKey pKey_recipient = null;
	private int pigcoins = 0;
	private String message = "";
	
	
	//constructor
	public Transaction() {
		
	}
	public Transaction(String hash, String prev_hash, PublicKey pKey_sender, PublicKey pKey_recipient, int pigcoins, String message) {
		this.hash = hash;
		this.prev_hash = prev_hash;
		this.pKey_sender = pKey_sender;
		this.pKey_recipient = pKey_recipient;
		this.pigcoins = pigcoins;
		this.message = message;
	}
	
	//getters & setters
	public String getHash() {
		return this.hash;
	}
	public String getPrevHash() {
		return this.prev_hash;
	}
	public PublicKey getpKeySender() {
		return this.pKey_sender;
	}
	public PublicKey getpKeyRecipient() {
		return this.pKey_recipient;
	}
	public int getPigcoins() {
		return this.pigcoins;
	}
	public String getMessage() {
		return this.message;
	}
	
	//methods
	public String toString() {
		String message = " hash: "+ getHash() + "\n prev_hash: " + getPrevHash() + "\n pKey_sender: " + getpKeySender().hashCode();
		message +=  "\n pKey_recipient: " + getpKeyRecipient().hashCode() + "\n pigcoins: " +getPigcoins() + "\n message: " +getMessage() + "\n";
		
		return message;
	}
}
