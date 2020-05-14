package com.practice.crnk.service.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.practice.crnk.service.configuration.Jooq;
import com.practice.crnk.service.jooq.StudentJooq;

import com.practice.crnk.api.resources.*;

/**
 * @author nrmaridu
 * @since May 09, 2020
 */
@Repository
public class StudentDao {

    private final StudentJooq studentJooq = StudentJooq.INSTANCE;

    private final Jooq jooq;

    public StudentDao(Jooq jooq) {
        this.jooq = jooq;
    }

    public StudentResource findOne(UUID studentId) {
        return jooq.build()
            .select(studentJooq.id,
                studentJooq.name,
                studentJooq.universityId)
            .from(studentJooq.studentTable)
            .where(studentJooq.id.eq(studentId))
            .fetchSingle()
            .into(StudentResource.class);
    }

    public List<StudentResource> findAll() {
        return jooq.build()
            .select(studentJooq.id,
                studentJooq.name,
                studentJooq.universityId)
            .from(studentJooq.studentTable)
            .fetch()
            .into(StudentResource.class);
    }
}
