package com.kolotree.common;

import io.vavr.collection.List;
import io.vavr.control.Option;

public abstract class ValueObject {

    protected abstract List<Object> GetEqualityComponents();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        if (o instanceof ValueObject) {
            ValueObject other = (ValueObject) o;

            if (GetEqualityComponents().size() != other.GetEqualityComponents().size()) {
                return false;
            }


            return GetEqualityComponents().equals(other.GetEqualityComponents());
        }

        return false;
    }

    @Override
    public int hashCode() {
        return GetEqualityComponents()
                .map(Object::hashCode)
                .foldLeft(1, (current, obj) -> current * 23 + Option.of(obj).map(Object::hashCode).getOrElse(0));
    }
}
