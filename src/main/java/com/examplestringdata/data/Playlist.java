package com.examplestringdata.data;

import com.examplestringdata.data.dto.IdAndDescription;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "playlist")
@Getter
@Setter
@SqlResultSetMappings(
        @SqlResultSetMapping(
                name = "summary",
                classes = @ConstructorResult(
                        targetClass = IdAndDescription.class,
                        columns = {
                                @ColumnResult(name = "id", type = Long.class),
                                @ColumnResult(name = "description", type = String.class)
                        })
        )
)
@NamedNativeQueries(
        @NamedNativeQuery(
                name = "Playlist.summary",
                query = "select id, description from playlist where name = :name",
                resultSetMapping = "summary"
        )
)
public class Playlist {
    @Id
    @SequenceGenerator(name = "playlist_sequence", sequenceName = "playlist_sequence", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "playlist_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "name", columnDefinition = "TEXT")
    @NotNull(message = "Playlist shouldn't be null")
    @NotEmpty(message = "Playlist shouldn't be empty")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
}
