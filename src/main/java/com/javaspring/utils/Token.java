package com.javaspring.utils;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class Token {
	private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz";

	public static String generateRandomString(int length) {
		Random random = new Random();
		StringBuilder stringBuilder = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(CHARACTERS.length());
			stringBuilder.append(CHARACTERS.charAt(index));
		}
		return stringBuilder.toString();
	}
	public static String getToken() {
		String randomString = generateRandomString(20);
		return randomString;
	}
	public static Boolean isLoggedIn(HttpServletRequest request) {
	    String token = (String) Session.getAttribute(request, "token");
	    request.setAttribute("token", token);
		if (token != null) {
            return true;
        }else {
        	return false;
        }
	}
}
