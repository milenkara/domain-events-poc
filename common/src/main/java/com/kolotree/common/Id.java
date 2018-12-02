package com.kolotree.common;

import io.vavr.collection.List;
import io.vavr.control.Either;
import lombok.Getter;

@Getter
public class Id extends ValueObject {

    private String id;

    private Id(String id) {
        this.id = id;
    }

    @Override
    protected List<Object> GetEqualityComponents() {
        return List.of(id);
    }

    public static Either<String, Id> idFrom(String idAsString) {
        if(idAsString == null || idAsString.isEmpty()) {
            return Either.left("Argument id is empty.");
        }
        return Either.right(new Id(idAsString));
    }
}
