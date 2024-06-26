package com.schimibusiness.hackerman.repositories;

import com.schimibusiness.hackerman.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
    Optional<Document> findByName(String name);
}
