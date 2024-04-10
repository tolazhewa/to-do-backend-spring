package com.tolazhewa.todobackendspring.models.converters;

import java.time.Instant;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class InstantAttributeConverter implements AttributeConverter<Instant, String> {

    @Override
    public String convertToDatabaseColumn(Instant attribute) {
        return attribute != null ? attribute.toString() : null;
    }

    @Override
    public Instant convertToEntityAttribute(String dbData) {
        return dbData != null ? Instant.parse(dbData) : null;
    }
}