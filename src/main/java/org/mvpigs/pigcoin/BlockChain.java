package org.mvpigs.pigcoin;

import java.util.ArrayList;

public class BlockChain {
	//attributes
	private ArrayList<Transaction> blockChain = new ArrayList<Transaction>();
	
	//constructor
	public BlockChain() {
		
	}
	
	
	//getters & setters
	public ArrayList<Transaction> getBlockChain(){
		return blockChain;
	}
	
	//method
	public void addOrigin(Transaction transaction) {
		getBlockChain().add(transaction);		
	}
	
	public void summarize() {
		
	}
}
