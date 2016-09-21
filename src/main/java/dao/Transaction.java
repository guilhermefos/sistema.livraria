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
	
	/**
	 * Commit marks the end of a successful implicit or explicit transaction
	 * 
	 * @return void
	 * 
	 */
	public static void commit()
	{
		EM.getLocalEm().getTransaction().commit();
	}
	
	/**
	 * 
	 * statement to rollback the transaction meaning 
	 * that none of the data actually changed
	 * 
	 * @return void
	 * 
	 */
	public static void rollback()
	{
		EM.getLocalEm().getTransaction().rollback();
	}

}
