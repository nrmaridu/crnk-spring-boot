package com.practice.crnk.service.repositories;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.practice.crnk.api.resources.StudentResource;
import com.practice.crnk.service.dao.StudentDao;

import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;

/**
 * @author nrmaridu
 * @since May 09, 2020
 */
@Component
public class StudentRepository extends ResourceRepositoryBase<StudentResource, UUID> {

    private final StudentDao studentDao;

    public StudentRepository(StudentDao studentDao) {
        super(StudentResource.class);
        this.studentDao = studentDao;
    }

    @Override
    public StudentResource findOne(UUID id, QuerySpec querySpec) {
        return studentDao.findOne(id);
    }

    @Override
    public ResourceList<StudentResource> findAll(QuerySpec querySpec) {
        return querySpec.apply(studentDao.findAll());
    }


}
