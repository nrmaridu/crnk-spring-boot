package com.practice.service.repositories;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.practice.api.resources.CourseResource;
import com.practice.service.dao.CourseDao;
import com.practice.service.dao.StudentDao;

import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;
import lombok.extern.log4j.Log4j2;

/**
 * @author nrmaridu
 * @since May 15, 2020
 */
@Log4j2
@Component
public class CourseRepository extends ResourceRepositoryBase<CourseResource, UUID> {

    private final CourseDao courseDao;

    public CourseRepository(CourseDao courseDao) {
        super(CourseResource.class);
        this.courseDao = courseDao;
    }

    @Override
    public CourseResource findOne(UUID id, QuerySpec querySpec) {
        return courseDao.findOne(id);
    }

    @Override
    public ResourceList<CourseResource> findAll(QuerySpec querySpec) {
        return querySpec.apply(courseDao.findAll());
    }
}
