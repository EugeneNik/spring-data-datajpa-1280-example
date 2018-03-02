package com.examplestringdata.repository;

import com.examplestringdata.data.Talk;
import com.examplestringdata.data.dto.IdAndDescription;
import com.examplestringdata.data.dto.IdAndDescriptionOnly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TalkQueryDefinitionRepository extends JpaRepository<Talk, Long> {

    @Query(value = "select id, description from talk where name = ?1", nativeQuery = true)
    <T> T findByName(String name, Class<T> beanProjection);

    @Query(value = "select id, description from talk where name = ?1", nativeQuery = true)
    IdAndDescription findByNameClass(String name);

    @Query(value = "select id, description from talk where name = ?1", nativeQuery = true)
    IdAndDescriptionOnly findByNameInterface(String name);
}
