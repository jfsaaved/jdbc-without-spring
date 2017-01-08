package com.jfsaaved.main;

import com.jfsaaved.dao.JDBCDAO;
import com.jfsaaved.model.Circle;

public class Main {
	
	public static void main(String[] args) {
		Circle circle = new JDBCDAO().getCircle(1);
		System.out.println(circle.getName());
	}

}
