package com.practice.crnk.service.repositories;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.practice.crnk.api.resources.UniversityResource;
import com.practice.crnk.service.dao.UniversityDao;

import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;

/**
 * @author nrmaridu
 * @since May 08, 2020
 */
@Component
public class UniversityRepository extends ResourceRepositoryBase<UniversityResource, UUID> {

    private final UniversityDao universityDao;

    public UniversityRepository(UniversityDao universityDao) {
        super(UniversityResource.class);
        this.universityDao = universityDao;
    }

    @Override
    public UniversityResource findOne(UUID id, QuerySpec querySpec) {
        return universityDao.findOne(id);
    }

    @Override
    public ResourceList<UniversityResource> findAll(QuerySpec querySpec) {
        return querySpec.apply(universityDao.findAll());
    }

    @Override
    public UniversityResource create(UniversityResource resource) {
        return universityDao.create(resource);
    }

    @Override
    public void delete(UUID id) {
        universityDao.delete(id);
    }
}
