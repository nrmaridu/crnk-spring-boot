package com.practice.service.dao;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import com.practice.api.resources.base.ApiResource;

/**
 * @author nrmaridu
 * @since May 15, 2020
 */
public interface AbstractDao<T extends ApiResource, I> {


    T findOne(I id);

    Collection<T> findAll();

    T create(T resource);

    T save(T resource);

    int delete(I id);

}
