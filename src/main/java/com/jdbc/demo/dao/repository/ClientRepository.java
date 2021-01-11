package com.jdbc.demo.dao.repository;

import com.jdbc.demo.dao.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
