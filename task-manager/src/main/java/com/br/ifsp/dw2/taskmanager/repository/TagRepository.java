package com.br.ifsp.dw2.taskmanager.repository;

import com.br.ifsp.dw2.taskmanager.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    Optional<Tag> findByName(final String name);
    Boolean existsByName(String name);
}
