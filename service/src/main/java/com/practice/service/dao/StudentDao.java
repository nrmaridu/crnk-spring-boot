package com.practice.service.dao;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

import org.jooq.Record;
import org.jooq.RecordMapper;
import org.springframework.stereotype.Repository;

import com.practice.api.resources.StudentResource;
import com.practice.service.configuration.Jooq;
import com.practice.service.jooq.StudentJooq;

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

    private Function<Record, StudentResource> studentResourceMapper = record ->
        new StudentResource(record.get(studentJooq.id),
            record.get(studentJooq.name),
            record.get((studentJooq.universityId)),
            Collections.emptyList());

    RecordMapper<Record, StudentResource> studentRecordMapper = studentResourceMapper::apply;

    public StudentResource findOne(UUID studentId) {
        return jooq.build()
            .select(studentJooq.id,
                studentJooq.name,
                studentJooq.universityId)
            .from(studentJooq.studentTable)
            .where(studentJooq.id.eq(studentId))
            .fetchSingle(studentRecordMapper);
    }

    public List<StudentResource> findAll() {
        return jooq.build()
            .select(studentJooq.id,
                studentJooq.name,
                studentJooq.universityId)
            .from(studentJooq.studentTable)
            .fetch()
            .map(record -> studentResourceMapper.apply(record));
    }
}
