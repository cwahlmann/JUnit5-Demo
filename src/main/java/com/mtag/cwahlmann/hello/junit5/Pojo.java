package com.mtag.cwahlmann.hello.junit5;
public class Pojo {
	private int value;
	
	public final static Pojo NULL = new Pojo(0);

	Pojo(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public void inc() {
		this.value++;
	}

	public void dec() {
		this.value--;
	}
}
