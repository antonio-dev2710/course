package com.educandoweb.course.entities.enums;

public enum OrderStatus {

	WAITING_PAMENT(1), PAID(2), SHIPPED(3), DELIVERED(4), CANCELED(5);

	private int code;

	private OrderStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

//esse método permite obter uma instância 
	//específica da enumeração OrderStatus
	public static OrderStatus valueOf(int code) {
		// percorrer td os valores do status
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}

		}
		throw new IllegalArgumentException("Invalid OrderStauts code");
	}
}
