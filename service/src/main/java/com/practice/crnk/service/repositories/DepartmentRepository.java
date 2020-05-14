package com.practice.crnk.service.repositories;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.practice.crnk.api.resources.DepartmentResource;
import com.practice.crnk.service.dao.DepartmentDao;

import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;

/**
 * @author nrmaridu
 * @since May 09, 2020
 */
@Component
public class DepartmentRepository extends ResourceRepositoryBase<DepartmentResource, UUID> {

    private final DepartmentDao departmentDao;

    public DepartmentRepository(DepartmentDao departmentDao) {
        super(DepartmentResource.class);
        this.departmentDao = departmentDao;
    }

    @Override
    public DepartmentResource findOne(UUID id, QuerySpec querySpec) {
        return departmentDao.findOne(id);
    }

    @Override
    public ResourceList<DepartmentResource> findAll(QuerySpec querySpec) {
        return querySpec.apply(departmentDao.findAll());
    }

    @Override
    public DepartmentResource create(DepartmentResource resource) {
        return departmentDao.create(resource);
    }

    @Override
    public void delete(UUID id) {
        departmentDao.delete(id);
    }
}
