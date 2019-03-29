package com.example.pierceab.fileUtils;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Attributes extends JpaRepository<Attribute, Integer> {

}
