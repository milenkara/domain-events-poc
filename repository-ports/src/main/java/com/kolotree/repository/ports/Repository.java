package com.kolotree.repository.ports;

import com.kolotree.common.AggregateRoot;
import com.kolotree.common.Id;
import io.vavr.collection.List;
import io.vavr.control.Option;

public interface Repository<T extends AggregateRoot> {
    List<T> getAll();
    Option<T> findBy(Id id);
    T save(T obj);
    T delete(T obj);
}
