package com.lix.domain.master.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lix.domain.master.productores.model.Productores;

@Repository("productoresRepository")
public interface ProductoresRepository extends
		JpaRepository<Productores, Integer> {

}
