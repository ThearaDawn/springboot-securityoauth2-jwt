package com.ums.model.dao;

import com.ums.model.entity.Bill;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceDao extends CrudRepository<Bill, Long>{

}
