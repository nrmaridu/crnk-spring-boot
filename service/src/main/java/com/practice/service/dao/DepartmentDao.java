package com.practice.service.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.practice.api.resources.DepartmentResource;
import com.practice.service.configuration.Jooq;
import com.practice.service.jooq.DepartmentJooq;

/**
 * @author nrmaridu
 * @since May 09, 2020
 */
@Repository
public class DepartmentDao implements AbstractDao<DepartmentResource, UUID> {

    private final DepartmentJooq departmentJooq = DepartmentJooq.INSTANCE;

    private final Jooq jooq;

    public DepartmentDao(Jooq jooq) {
        this.jooq = jooq;
    }


    @Override
    public DepartmentResource findOne(UUID id) {
        return jooq.build()
            .select(departmentJooq.id,
                departmentJooq.name,
                departmentJooq.universityId)
            .from(departmentJooq.departmentTable)
            .where(departmentJooq.id.eq(id))
            .fetchSingle()
            .into(DepartmentResource.class);
    }

    @Override
    public List<DepartmentResource> findAll() {
        return jooq.build()
            .select(departmentJooq.id,
                departmentJooq.name,
                departmentJooq.universityId)
            .from(departmentJooq.departmentTable)
            .fetch()
            .into(DepartmentResource.class);
    }

    @Override
    public DepartmentResource create(DepartmentResource resource) {
        return jooq.build()
            .insertInto(departmentJooq.departmentTable)
            .set(departmentJooq.id, resource.getId())
            .set(departmentJooq.name, resource.getName())
            .set(departmentJooq.universityId, resource.getUniversityId())
            .returning(departmentJooq.id, departmentJooq.name, departmentJooq.universityId)
            .fetchOne()
            .into(DepartmentResource.class);
    }

    @Override
    public DepartmentResource save(DepartmentResource resource) {
        return null;
    }

    @Override
    public int delete(UUID id) {
        return jooq.build()
            .deleteFrom(departmentJooq.departmentTable)
            .where(departmentJooq.id.eq(id))
            .execute();
    }

}
