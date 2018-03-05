package com.examplestringdata.repository;

import com.examplestringdata.data.Conference;
import com.examplestringdata.data.dto.IdAndDescription;
import com.examplestringdata.data.dto.IdAndDescriptionOnly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConferenceNamedNativeQueryDefinitionRepository extends JpaRepository<Conference, Long> {
    @Query(name = "Conference.summary")
    <T> T findByName(@Param("name") String name, Class<T> beanProjection);

    @Query(name = "Conference.summary")
    IdAndDescription findByNameClass(@Param("name") String name);

    @Query(name = "Conference.summary")
    IdAndDescriptionOnly findByNameInterface(@Param("name") String name);
}
