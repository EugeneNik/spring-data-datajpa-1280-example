package com.examplestringdata.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "talk")
@Getter
@Setter
public class Talk {
    @Id
    @SequenceGenerator(name = "talk_sequence", sequenceName = "talk_sequence", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "talk_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "name", columnDefinition = "TEXT")
    @NotNull(message = "Talk shouldn't be null")
    @NotEmpty(message = "Talk shouldn't be empty")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
}
