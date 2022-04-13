package com.example.emlakburada.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.emlakburada.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {

}
