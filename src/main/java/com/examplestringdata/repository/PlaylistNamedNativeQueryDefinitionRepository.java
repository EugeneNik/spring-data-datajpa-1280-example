package com.examplestringdata.repository;

import com.examplestringdata.data.Playlist;
import com.examplestringdata.data.dto.IdAndDescription;
import com.examplestringdata.data.dto.IdAndDescriptionOnly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlaylistNamedNativeQueryDefinitionRepository extends JpaRepository<Playlist, Long> {
    @Query(name = "Playlist.summary")
    <T> T findByName(@Param("name") String name, Class<T> beanProjection);

    @Query(name = "Playlist.summary")
    IdAndDescription findByNameClass(@Param("name") String name);

    @Query(name = "Playlist.summary")
    IdAndDescriptionOnly findByNameInterface(@Param("name") String name);
}
