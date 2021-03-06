package org.mvpigs.pigcoin;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Wallet {
	//attributes
	private PublicKey address = null;
	private PrivateKey sKey = null;
	private double total_input = 0d;
	private double total_output = 0d;
	private double balance = 0d;	
	private ArrayList<Transaction> inputTransactions = new ArrayList<Transaction>();
	private ArrayList<Transaction> outputTransactions = new ArrayList<Transaction>();
	
	//constructor
	public Wallet() {
		
	}

	//getters & setters
	public ArrayList<Transaction> getInputTransactions(){
		return this.inputTransactions;
	}
	public ArrayList<Transaction> getOutputTransactions() {
		return this.outputTransactions;
	}
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
	public void setTotalInput(double input) {
		this.total_input += input;
	}
	public void setTotalOutput(double output) {
		this.total_output += output;
	}
	
	
	//methods
	public void generateKeyPair() {
		KeyPair pair = GenSig.generateKeyPair();
		setSK(pair.getPrivate());
		setAddress(pair.getPublic());
	}
	
	public String toString() {
		String message = " Wallet: " + getAddress().hashCode() + "\n Total input: "+ getTotalInput();
		message += "\n Total output: " + getTotalOutput() + "\n Balance: " + getBalance() + "\n";
		return message;
	}

	public void loadCoins(BlockChain bChain) {
		Wallet wallet = null;
		for (Transaction transaction : bChain.getBlockChain()) {
			
			wallet = this;
			if(wallet.getAddress() == transaction.getpKeyRecipient()) 
				wallet.setTotalInput(transaction.getPigcoins());
			
			
			if(wallet.getAddress() == transaction.getpKeySender()) 
				wallet.setTotalOutput(transaction.getPigcoins());			
		}
		
		setBalance(wallet);
	}

	public void setBalance(Wallet wallet) {
		this.balance = getTotalInput() - getTotalOutput();
	}

	public void loadInputTransactions(BlockChain bChain) {
		for (Transaction transaction : bChain.getBlockChain()) {
			
			if(this.getAddress() == transaction.getpKeyRecipient())
				getInputTransactions().add(transaction);
		}
	}

	public void loadOutputTransactions(BlockChain bChain) {
		for (Transaction transaction : bChain.getBlockChain()) {
			
			if(this.getAddress() == transaction.getpKeySender())
				getOutputTransactions().add(transaction);
		}
	}

	public void sendCoins(PublicKey pKey_recipient, double coins, String message, BlockChain bChain) {
		
	}

	public Map<String, Double> collectCoins(Double pigcoins) {
		ArrayList<Transaction> newOutputTransactions = discardOutputTransactions();
		Map<String, Double> consumedCoins = new HashMap<String, Double>();
		
		for (Transaction inputTransaction : newOutputTransactions) {
			
			consumedCoins.put(inputTransaction.getHash(), (double) inputTransaction.getPigcoins());
		}
		
		System.out.println("------------------------------------------------Test-------------------------------------");
		return consumedCoins;
	}
	
	public ArrayList<Transaction> discardOutputTransactions(){
		ArrayList<Transaction> newInputTransactions = new ArrayList<Transaction>();
		
		for (Transaction inputTransaction : getInputTransactions()) {
			Boolean found = false;
			
			for (Transaction outputTransaction : getOutputTransactions()) {
				if(inputTransaction == outputTransaction)
					found = true;
			}			
			if(!found)
				newInputTransactions.add(inputTransaction);
		}
		return newInputTransactions;
	}
}
