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
	}
	
	@Test
	public void generateKeyPairTest() {		
		wallet.generateKeyPair();		
		assertNotEquals(null, wallet.getAddress().hashCode());
	}
	
	@Test
	public void toStringTest() {
		wallet.generateKeyPair();
		System.out.println("Wallet_1: \n" + wallet.toString());		
	}
}
