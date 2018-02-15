package org.mvpigs.pigcoin.tests;

import static org.junit.Assert.*;

import java.security.KeyPair;

import org.junit.Before;
import org.junit.Test;
import org.mvpigs.pigcoin.GenSig;
import org.mvpigs.pigcoin.Wallet;

public class WalletTest {

	Wallet wallet;
	
	@Before
	public void setUp() {
		wallet = new Wallet();
		wallet.generateKeyPair();
	}
	
	@Test
	public void generateKeyPairTest() {		
		assertNotEquals(null, wallet.getAddress().hashCode());
	}
	
	@Test
	public void toStringTest() {
		System.out.println(" Wallet_1: \n" + wallet.toString());		
	}
	
	@Test
	public void setBalanceTest() {		
		wallet.setTotalInput(20);
		wallet.setTotalOutput(10);
		
		wallet.setBalance(wallet);
		
		assertEquals(10, wallet.getBalance(), 0);
	}
}
