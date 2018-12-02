package com.kolotree.persistence.converters;

import com.kolotree.common.AggregateRoot;

public interface ModelConverter<TDomain extends AggregateRoot, TPersistence> {
    TDomain toDomainModel(TPersistence persistenceObj);

    TPersistence toPersistenceModel(TDomain domainObj);
}
