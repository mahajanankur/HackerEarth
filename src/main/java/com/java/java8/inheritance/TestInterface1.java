/**
 * 
 */
package com.java.java8.inheritance;

/**
 * @author amahajan
 *
 * @written 25-Jan-2017
 */
public class TestInterface1 implements Interface1, Interface2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		firstApproach();
		C c = new C();
		c.get(10L);
	}

	private static void firstApproach() {
		TestInterface1 test = new TestInterface1();
		test.defaultDetails();
		Interface1.staticDetails();
		test.defaultDetails();
		test.abstractDetails();

	}

	@Override
	public void abstractDetails() {
		System.out.println("abstractDetails in child class.");
	}

	@Override
	public void defaultDetails() {
		Interface1.super.defaultDetails();
	}

	public void staticDetails() {
		Interface1.staticDetails();
	}

}
