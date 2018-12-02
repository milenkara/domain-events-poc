package com.kolotree.model;

import com.kolotree.common.ValueObject;
import io.vavr.collection.List;
import io.vavr.control.Either;
import lombok.Getter;

@Getter
public class Name extends ValueObject {

    private String nameAsString;

    private Name(String nameAsString) {
        this.nameAsString = nameAsString;
    }

    @Override
    protected List<Object> GetEqualityComponents() {
        return List.of(nameAsString);
    }

    public static Either<String, Name> nameFrom(String nameAsString) {
        if(nameAsString == null || nameAsString.isEmpty()) {
            return Either.left("Argument email is null/empty.");
        }

        return Either.right(new Name(nameAsString));
    }
}
