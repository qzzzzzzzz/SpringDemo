package com.fdmgroup.spring.web.service;

import java.util.Random;

public class LoginService {
	
	public static String generateLuckyGem() {
		
		String[] gemArr = { "Diamond", "Carbonado", "Morganite", "Jade", "Zircon", "Amethyst", "Benitoite",
				"Neptunite", "Rutile", "Obsidian", "Alexandrite", "Euclase", "Peridot", "Antarcticite", "Sphene",
				"Sapphire", "Ruby", "Tourmaline", "Cinnabar", "Phosphophyllite" };

		Random r = new Random();
		int randomInt = r.nextInt(20);
		
		return gemArr[randomInt];
	}
}
