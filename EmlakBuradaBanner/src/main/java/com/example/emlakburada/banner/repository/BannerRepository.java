package com.example.emlakburada.banner.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.emlakburada.banner.model.Banner;

@Repository
public interface BannerRepository extends JpaRepository<Banner,Long> {
}
