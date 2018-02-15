package org.mvpigs.pigcoin.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mvpigs.pigcoin.BlockChain;
import org.mvpigs.pigcoin.Transaction;
import org.mvpigs.pigcoin.Wallet;

public class BlockChainTest {
	private ArrayList<Transaction> blockChain = new ArrayList<Transaction>();	
	Transaction trx;
	BlockChain blockChainObject;
	
	@Before
	public void setUp() {
		Wallet wallet = new Wallet();   
		Wallet wallet2 = new Wallet();   
        wallet.generateKeyPair();
        wallet2.generateKeyPair();
        blockChainObject = new BlockChain();
        
        trx = new Transaction("hash_1", "0", wallet.getAddress(), wallet2.getAddress(), 20, "bacon eggs");
	}
	
	@Test
	public void addOriginTest() {
		blockChainObject.addOrigin(trx);
		
		assertNotEquals(0, blockChainObject.getBlockChain().size());
		assertEquals(1, blockChainObject.getBlockChain().size());
	}
	
	@Test
	public void summarizeWithIndexTestPass() {
		blockChainObject.addOrigin(trx);
		
		System.out.print("Se espera que salgan los datos correctamente: \n");
		blockChainObject.summarize(0);
	}

	@Test
	public void summarizeWithIndexTestAssert() {
		blockChainObject.addOrigin(trx);
		
		System.out.print("Se espera que salga un mensaje de error debido a que el índice esta fuera de rando: \n");
		blockChainObject.summarize(4);
		System.out.print("\n \n");
	}
}
