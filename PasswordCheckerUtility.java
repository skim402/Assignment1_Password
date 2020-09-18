/**
 * CMSC 204
 * Assignment 1 _ password
 * Author: Sungmin Kim
 * Date: 09/17/2020
 */

import java.util.regex.Pattern;

import java.util.regex.Matcher;

import java.util.ArrayList;

public class PasswordCheckerUtility {

	public PasswordCheckerUtility(){
	
	}
	
	/**
	 * Compare length of two passwords
	 * @param password
	 * @param passwordConfirm
	 */
	public static void comparePasswords(String password, String passwordConfirm) {
		if (password.equals(passwordConfirm)) {
		}else {
		}
	}
	
	/**
	 * Compare length of two passwords
	 * @param password
	 * @param passwordConform
	 * @return
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		if (password.equals(passwordConfirm)) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Reads a file of passwords and the passwords 
	 * that failed the check will be added to an invalidPasswords with the reason
	 * @param passwords
	 * @return
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		ArrayList<String> invalidPassword = new ArrayList<String>();
		for (int i=0; i < passwords.size() ; i++ ) {
			if (!isValidPassword(passwords.get(i))) {
				invalidPassword.add(passwords.get(i));
			}
		}
		return invalidPassword;
	}
	
	/**
	 * Weak password length check
	 * @param password
	 * @return
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {
		if (password.length() >=6 && password.length() < 10) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Check the password Digit requirement 
	 * @param password
	 * @return
	 */
	public static boolean hasDigit(String password) {
		for(int i=0 ; i < password.length() ; i++) {
			if (password.charAt(i) >= '0' && password.charAt(i) <= '9' )
				return true;
		}
		return false;
	}
	
	/**
	 * Checks the password lowercase requirement
	 * @param password
	 * @return
	 */
	public static boolean hasLowerAlpha(String password) {
		for(int i=0 ; i < password.length() ; i++) {
			if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z' )
				return true;
		}
		return false;
	}
	
	/**
	 * Checks the password Sequence requirement
	 * @param password
	 * @return
	 */
	public static boolean hasSameCharInSequence(String password) {
		for(int i=0; i < (password.length()-2) ; i++) {
			if (password.charAt(i) == password.charAt(i+1) && password.charAt(i) == password.charAt(i+2)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks the password Special Character requirement
	 * @param password
	 * @return
	 */
	public static boolean hasSpecialChar(String password) {
		for (int i = 0; i < password.length() ; i++) {
			if (password.charAt(i) >= ' ' && password.charAt(i) <= '/') {
				return true;
			}else if (password.charAt(i) >= ':' && password.charAt(i) <= '@') {
				return true;
			}else if ( password.charAt(i) >= '[' && password.charAt(i) < 'a') {
				return true;
			}else if ( password.charAt(i) >= '{' && password.charAt(i) <= '~') {
				return true;
			}	
		}
		return false;
	}
	
	/**
	 * Checks the password alpha character requirement
	 * @param password
	 * @return
	 */
	public static boolean hasUpperAlpha(String password) {
		for(int i=0 ; i < password.length() ; i++) {
			if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z' )
				return true;
		}
		return false;
	}
	
	/**
	 * Checks the password length requirement
	 * @param password
	 * @return
	 */
	public static boolean isValidLength(String password) {
		if (password.length() > 6) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Return true if valid password, 
	 * return false if an invalid password
	 * @param password
	 * @return
	 */
	public static boolean isValidPassword(String password) {
		try {
			if (!isValidLength(password)) {
				throw new LengthException();
			}
		}catch (LengthException e){
			System.out.println(e.getMessage());
			return true;
		}
		
		try {
			if (!hasUpperAlpha(password)) {
				throw new NoUpperAlphaException();	
			}
		}catch (NoUpperAlphaException e) {
			System.out.println(e.getMessage());
			return true;
		}
		
		try {
			if (!hasLowerAlpha(password)) {
				throw new NoLowerAlphaException();
			}
		}catch (NoLowerAlphaException e) {
			System.out.println(e.getMessage());
			return true;
		}
		
		
		try { 
			if (!hasDigit(password)) {
				throw new NoDigitException();
			}
		}catch (NoDigitException e) {
			System.out.println(e.getMessage());
			return true;
		}
		
		try {
			if (!hasSpecialChar(password)) {
				throw new NoSpecialCharacterException();
			}
		}catch (NoSpecialCharacterException e) {
			System.out.println(e.getMessage());
			return true;
		}
		
		try {
			if (hasSameCharInSequence(password)) {
				throw new InvalidSequenceException();	
			}
		}catch (InvalidSequenceException e) {
			System.out.println(e.getMessage());
			return true;
		}
		
		try {
			if (hasBetweenSixAndNineChars(password)) {
				throw new WeakPasswordException();
			}
		}catch (WeakPasswordException e) {
			System.out.println(e.getMessage());
			return true;
		}
		
		
		return true;
	}
	
	/**
	 * Checks if password is valid but between 6-9 characters
	 * @param password
	 * @return
	 */
	public static boolean isWeakPassword(String password) {
		if (hasBetweenSixAndNineChars(password)) {
			return true;
		}else {
			return false;
		}
	}

	
}
