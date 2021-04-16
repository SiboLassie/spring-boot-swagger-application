package com.springbootswaggerapplication.repository;

import com.springbootswaggerapplication.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends CrudRepository<Item, Long> {
}
