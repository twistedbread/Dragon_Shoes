package com.pos.dragonShoes;

import org.springframework.boot.SpringApplication;

public class TestDragonShoesApplication {

	public static void main(String[] args) {
		SpringApplication.from(DragonShoesApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
