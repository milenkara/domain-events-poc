package com.kolotree.model;

import com.kolotree.common.Id;
import io.vavr.control.Option;

public class TestObjects {
    public static final String street = "Vojvodjanskih partizana";
    public static final String city = "Sremska Kamenica";
    public static final int number = 25;
    public static final Id id = Id.idFrom("123456789").get();
    public static final Name firstName = Name.nameFrom("John").get();
    public static final Option<Name> middleName = Option.of(Name.nameFrom("Lucas").get());
    public static final Name lastName = Name.nameFrom("Doe").get();
    public static final Email email = Email.emailFrom("john.doe@gmail.com").get();
    public static final Address address = Address.addressFrom(street,city, number).get();


}
