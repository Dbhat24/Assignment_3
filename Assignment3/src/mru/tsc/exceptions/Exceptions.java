package mru.tsc.exceptions;

import mru.tsc.controller.MainSceneController;

/**
 * Exceptions class that extends controller class
 * @author Faizan and Raj
 *
 */
public class Exceptions extends MainSceneController {

	/**
	 * Exceptions constructor
	 * @throws Exception needed for exceptions to work
	 */
	public Exceptions() throws Exception {
		super();
	}

	/**
	 * price is negative exceptions
	 * @param args any number of values
	 * @throws Exception needed to run application
	 */
	public static void main(String[] args) throws Exception {

		if (price < 0)
			throw new Exception("The input price is negative");

		try {
			System.out.println("Enter a positive value for price");
		} catch (Exception e) {
			System.out.println("The price entered is invalid");
			e.printStackTrace();
		}

		System.out.println("Completed");
	}


}
