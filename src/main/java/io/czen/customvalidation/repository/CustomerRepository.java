package io.czen.customvalidation.repository;

import io.czen.customvalidation.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Long, CustomerEntity> {
}
