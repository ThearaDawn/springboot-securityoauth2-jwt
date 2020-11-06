package com.ums.model.dao;

import com.ums.model.entity.Client;
import com.ums.model.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientDao extends JpaRepository<Client, Long>{

	@Query("from Region")
	public List<Region> findAllRegion();
}
