package com.tolazhewa.todobackendspring.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tolazhewa.todobackendspring.models.converters.InstantAttributeConverter;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Data
@Getter
@Table(name = "todos")
public class Todo {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "user_id")
    @JsonProperty("userId")
    private Long userId;

    @Column(name = "text")
    private String text;

    @Column(name = "completed")
    private boolean completed;

    @CreationTimestamp
    @Column(name = "creation_datetime",  columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @Convert(converter = InstantAttributeConverter.class)
    @JsonProperty("creationDatetime")
    private Instant creationDatetime;

    @UpdateTimestamp
    @Column(name = "latest_update_datetime")
    @JsonProperty("latestUpdateDatetime")
    private Instant latestUpdateDatetime;
}