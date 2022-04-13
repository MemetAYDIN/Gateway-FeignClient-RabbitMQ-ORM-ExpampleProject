package com.example.emlakburada.banner.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.emlakburada.banner.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
}
