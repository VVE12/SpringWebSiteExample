package com.example.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.model.App;

@Repository
public interface AppRepository extends CrudRepository<App, Integer> {
}
