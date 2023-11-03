package com.test.testcases;

import org.testng.annotations.Test;

public class PriorityCheck {
	@Test(priority = 0)
	public void dbc() {
		System.out.println("First Test");
	}
	
	@Test
	public void ccv() {
		System.out.println("Fifth Test");
	}

	@Test
	public void bac() {
		System.out.println("Second Test");
	}

	@Test (priority = -1)
	public void cba() {
		System.out.println("Third Test");
	}

	@Test(priority = 2)
	public void abc() {
		System.out.println("Fourth Test");
	}

}
