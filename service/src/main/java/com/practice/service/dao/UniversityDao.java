package com.practice.service.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.practice.api.resources.UniversityResource;
import com.practice.service.configuration.Jooq;
import com.practice.service.jooq.UniversityJooq;

/**
 * @author nrmaridu
 * @since May 09, 2020
 */
@Repository
public class UniversityDao {

    private final UniversityJooq universityJooq = UniversityJooq.INSTANCE;

    private final Jooq jooq;

    public UniversityDao(Jooq jooq) {
        this.jooq = jooq;
    }

    public UniversityResource findOne(UUID id) {
        return jooq.build()
            .select(universityJooq.id,
                universityJooq.name)
            .from(universityJooq.universityTable)
            .where(universityJooq.id.eq(id))
            .fetchSingle()
            .into(UniversityResource.class);
    }

    public List<UniversityResource> findAll() {
        return jooq.build()
            .select(universityJooq.id,
                universityJooq.name)
            .from(universityJooq.universityTable)
            .fetch()
            .into(UniversityResource.class);
    }

    public UniversityResource create(UniversityResource resource) {
        return jooq.build()
            .insertInto(universityJooq.universityTable)
            .set(universityJooq.id, resource.getId())
            .set(universityJooq.name, resource.getName())
            .returning(universityJooq.id, universityJooq.name)
            .fetchOne()
            .into(UniversityResource.class);
    }

    public int delete(UUID id) {
        return jooq.build()
            .deleteFrom(universityJooq.universityTable)
            .where(universityJooq.id.eq(id))
            .execute();
    }
}
