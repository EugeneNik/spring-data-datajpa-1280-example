package com.examplestringdata.repository;

import com.examplestringdata.data.Playlist;
import com.examplestringdata.data.dto.IdAndDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlaylistByNameMappingRepository extends JpaRepository<Playlist, Long> {
    @Query
    <T> T summary(@Param("name") String name, Class<T> beanProjection);

    @Query
    IdAndDescription summary(@Param("name") String name);
}