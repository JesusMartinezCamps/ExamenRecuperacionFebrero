package org.mvpigs.pigcoin.tests;

import static org.junit.Assert.*;

import java.security.PublicKey;

import org.junit.Before;
import org.junit.Test;
import org.mvpigs.pigcoin.Transaction;
import org.mvpigs.pigcoin.Wallet;

public class TransactionTest {

	Wallet wallet;
	Wallet wallet2;
	
	@Before
	public void setUp() {
		wallet = new Wallet();
		wallet2 = new Wallet();
		
		wallet.generateKeyPair();
		wallet2.generateKeyPair();
	}
	
	@Test
	public void constructorTest() {
		String hash1 = "hash_1";
		String hash2 = "0";
		PublicKey pKey = wallet.getAddress();
		PublicKey pKey2 = wallet2.getAddress();
		int pigcoins = 20;
		String message = "a flying pig!";
		
		Transaction trx = new Transaction(hash1, hash2, pKey, pKey2, pigcoins, message);
		
		assertEquals(hash1, trx.getHash());
		assertEquals(hash2, trx.getPrevHash());
		assertEquals(pKey, trx.getpKeyRecipient());
		assertEquals(pKey2, trx.getpKeySender());
		assertEquals(pigcoins, trx.getPigcoins());
		assertEquals(message, trx.getMessage());		
	}
	
	@Test
	public void toStringTest() {
		String hash1 = "hash_1";
		String hash2 = "0";
		PublicKey pKey = wallet.getAddress();
		PublicKey pKey2 = wallet2.getAddress();
		int pigcoins = 20;
		String message = "a flying pig!";
		
		Transaction trx = new Transaction(hash1, hash2, pKey, pKey2, pigcoins, message);
		
		System.out.println(trx.toString());
	}

}
