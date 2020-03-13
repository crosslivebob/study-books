package org.lite.spring.service.v4;

import org.lite.spring.beans.factory.annotation.Autowired;
import org.lite.spring.dao.v3.AccountDao;
import org.lite.spring.dao.v3.ItemDao;
import org.lite.spring.stereotype.Component;

@Component(value="petStore")

public class PetStoreService {
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private ItemDao  itemDao;
	
	public AccountDao getAccountDao() {
		return accountDao;
	}

	public ItemDao getItemDao() {
		return itemDao;
	}
	
	
}