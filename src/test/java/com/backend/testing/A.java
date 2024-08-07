package com.backend.testing;

public  class A {
	public static  A a() {
		System.out.println("Execute method a ");
		return new A();
	}
	
	public static A b() {
		System.out.println("Execute method b ");
		return new A();
	}
	
	public static B c() {
		System.out.println("Execute method c ");
		return new B();
	}

}
