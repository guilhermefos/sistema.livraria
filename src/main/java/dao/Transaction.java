package dao;

import dao.impl.EM;

public class Transaction {
	
	/**
	 * Begin marks the starting point of an explicit, local transaction
	 * 
	 * @return void
	 * 
	 */
	public static void begin()
	{
		EM.getLocalEm().getTransaction().begin();
	}

}
