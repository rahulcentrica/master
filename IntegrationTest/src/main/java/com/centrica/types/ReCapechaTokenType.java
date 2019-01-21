package com.centrica.types;

public enum ReCapechaTokenType {

	PAYMENT(2),APPOINTMENT(1);
	
	private final int type;
	
	ReCapechaTokenType(int value) {
		type=value;
	}

	public int getType() {
		return type;
	}

	
	
}
