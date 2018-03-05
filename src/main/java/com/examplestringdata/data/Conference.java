package com.examplestringdata.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "conference")
@Getter
@Setter
@SqlResultSetMappings(
        @SqlResultSetMapping(
                name = "conferenceSummary",
                columns = {
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "description", type = String.class)
                }
        )
)
@NamedNativeQueries(
        @NamedNativeQuery(
                name = "Conference.summary",
                query = "select id, description from conference where name = :name",
                resultSetMapping = "conferenceSummary"
        )
)
public class Conference {
    @Id
    @SequenceGenerator(name = "conference_sequence", sequenceName = "conference_sequence", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conference_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "name", columnDefinition = "TEXT")
    @NotNull(message = "Conference shouldn't be null")
    @NotEmpty(message = "Conference shouldn't be empty")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
}
