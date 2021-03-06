package org.mvpigs.pigcoin;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
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
		for (Transaction transaction : getBlockChain()) 
			System.out.println(transaction.toString());		
	}

	public void summarize(Integer index) {
	    try {
	    	System.out.println(getBlockChain().get(index));
        } catch (Exception e) {
            System.out.println("La posicion a�adida no �s v�lida.");;
        }		
	}
}
