package com.ista.backend.apirest.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public abstract class GenericServiceImpl <T, ID extends Serializable> implements GenericService<T, ID>{

	public abstract CrudRepository<T, ID> getDao();

	public T save(T Entity) {
        return getDao().save(Entity);
    }

	public T findById(ID id) {
        Optional<T> obj = getDao().findById(id);
        if (obj.isPresent()) {
            return obj.get();
        }
        return null;
    }

	public List<T> findByAll() {
        List<T> list = new ArrayList<>();
        getDao().findAll().forEach(obj -> list.add(obj));
        return list;
    }

	public void delete(ID id) {
        getDao().deleteById(id);
    }

}
