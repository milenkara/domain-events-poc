package com.kolotree.model;

import com.kolotree.common.ValueObject;
import io.vavr.collection.List;
import io.vavr.control.Either;
import lombok.Getter;

import java.util.regex.Pattern;

@Getter
public class Email extends ValueObject {

    private static String stringPattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    private static Pattern pattern = Pattern.compile(stringPattern);

    private String emailAsString;

    private Email(String emailAsString) {
        this.emailAsString = emailAsString;
    }

    @Override
    protected List<Object> GetEqualityComponents() {
        return List.of(emailAsString);
    }

    public static Either<String, Email> emailFrom(String emailAsString) {
        if(emailAsString == null || emailAsString.isEmpty()) {
            return Either.left("Argument email is null/empty.");
        }
        if(!pattern.matcher(emailAsString).matches()) {
            return Either.left("Invalid email provided.");
        }

        return Either.right(new Email(emailAsString));
    }
}
