package com.ums.model.services;

import com.ums.model.entity.Bill;
import com.ums.model.entity.Client;
import com.ums.model.entity.Product;
import com.ums.model.entity.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientService {

	public List<Client> findAll();
	
	public Page<Client> findAll(Pageable pageable);
	
	public Client findById(Long id);
	
	public Client save(Client client);
	
	public void delete(Long id);
	
	public List<Region> findAllRegion();
	
	public Bill findInvoiceById(Long id);
	
	public Bill saveInvoice(Bill invoice);
	
	public void deleteInvoiceById(Long id);
	
	public List<Product> findProductByName(String term);

}
