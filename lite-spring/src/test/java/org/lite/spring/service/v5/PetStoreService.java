package org.lite.spring.service.v5;


import org.lite.spring.beans.factory.annotation.Autowired;
import org.lite.spring.dao.v5.AccountDao;
import org.lite.spring.dao.v5.ItemDao;
import org.lite.spring.stereotype.Component;
import org.lite.spring.util.MessageTracker;

@Component(value="petStore")
public class PetStoreService {
	@Autowired
	AccountDao accountDao;
	@Autowired
	ItemDao itemDao;
	
	public PetStoreService() {		
		
	}
	
	public ItemDao getItemDao() {
		return itemDao;
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}
	
	public void placeOrder(){
		System.out.println("place order");
		MessageTracker.addMsg("place order");
		
	}	
}
