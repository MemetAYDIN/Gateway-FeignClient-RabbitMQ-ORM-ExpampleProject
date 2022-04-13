package com.example.emlakburada.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.emlakburada.model.Advert;

import java.util.Optional;

@Repository
public interface AdvertRepository extends JpaRepository<Advert,Long> {
    Optional<Advert>  findByAdvertNo(Long advertNo);

}
