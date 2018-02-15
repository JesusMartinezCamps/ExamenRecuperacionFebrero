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
	public void setSKTest() {
		KeyPair pair = GenSig.generateKeyPair();
		wallet.setSK(pair.getPrivate());
		
		
	}
}
