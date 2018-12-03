package com.kolotree.persistence.repository;

import com.kolotree.common.AggregateRoot;
import com.kolotree.common.Id;
import com.kolotree.persistence.converters.ModelConverter;
import com.kolotree.repository.ports.Repository;
import io.vavr.collection.List;
import io.vavr.control.Option;
import org.springframework.data.mongodb.repository.MongoRepository;

public abstract class MappingRepository<TDomain extends AggregateRoot, TPersistence> implements Repository<TDomain> {

    private MongoRepository<TPersistence, String> springMongoRepository;
    private ModelConverter<TDomain, TPersistence> converter;

    public MappingRepository(ModelConverter<TDomain, TPersistence> converter,
                             MongoRepository<TPersistence, String> springMongoRepository) {
        this.converter = converter;
        this.springMongoRepository = springMongoRepository;
    }

    @Override
    public List<TDomain> getAll() {
        return List.ofAll(springMongoRepository.findAll())
                .map(persistenceObj -> converter.toDomainModel(persistenceObj));
    }

    @Override
    public Option<TDomain> findBy(Id id) {
        return Option.ofOptional(springMongoRepository.findById(id.getId()))
                .map(converter::toDomainModel);
    }

    @Override
    public TDomain save(TDomain domainObj) {
        var persistenceObj = springMongoRepository.save(converter.toPersistenceModel(domainObj));
        return converter.toDomainModel(persistenceObj);
    }

    @Override
    public TDomain delete(TDomain domainObj) {
        springMongoRepository.delete(converter.toPersistenceModel(domainObj));
        return domainObj;
    }
}
