package com.br.ifsp.dw2.taskmanager.repository;

import com.br.ifsp.dw2.taskmanager.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    Boolean existsByName(String name);
}
