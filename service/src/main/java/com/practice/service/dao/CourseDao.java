package com.practice.service.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jooq.lambda.tuple.Tuple2;
import org.simpleflatmapper.jdbc.JdbcMapper;
import org.simpleflatmapper.jdbc.JdbcMapperFactory;
import org.simpleflatmapper.util.TypeReference;
import org.springframework.stereotype.Repository;

import com.practice.api.resources.CourseResource;
import com.practice.service.configuration.Jooq;
import com.practice.service.jooq.CourseEnrollmentJooq;
import com.practice.service.jooq.CourseJooq;

/**
 * @author nrmaridu
 * @since May 15, 2020
 */
@Repository
public class CourseDao implements AbstractDao<CourseResource, UUID> {

    private final Jooq jooq;
    private final StudentDao studentDao;

    private final CourseJooq courseJooq = CourseJooq.INSTANCE;
    private final CourseEnrollmentJooq courseEnrollmentJooq = CourseEnrollmentJooq.INSTANCE;

    public CourseDao(Jooq jooq, StudentDao studentDao) {
        this.jooq = jooq;
        this.studentDao = studentDao;
    }

    JdbcMapper<Tuple2<CourseResource, List<UUID>>> mapper =
        JdbcMapperFactory
            .newInstance()
            .addKeys("course_id")
            .newMapper(new TypeReference<Tuple2<CourseResource, List<UUID>>>() {
            });


    @Override
    public CourseResource findOne(UUID id) {
        ResultSet resultSet = jooq.build()
            .select(courseJooq.id.as("course_id"),
                courseJooq.name,
                courseJooq.credits,
                courseJooq.departmentId,
                courseEnrollmentJooq.studentId)
            .from(courseJooq.courseTable)
            .leftJoin(courseEnrollmentJooq.courseEnrollmentTable)
            .on(courseJooq.id.eq(courseEnrollmentJooq.courseId))
            .where(courseJooq.id.eq(id))
            .fetchResultSet();

        Stream<Tuple2<CourseResource, List<UUID>>> resultStream = null;
        try {
            resultStream = mapper.stream(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        assert resultStream != null;

        return resultStream.findFirst()
            .stream()
            .map((tuple) -> {
                tuple.v1.setStudentIds(tuple.v2);
                return tuple.v1;
            })
            .findFirst()
            .orElse(new CourseResource());
    }

    @Override
    public Collection<CourseResource> findAll() {
        ResultSet resultSet = jooq.build()
            .select(courseJooq.id.as("course_id"),
                courseJooq.name,
                courseJooq.credits,
                courseJooq.departmentId,
                courseEnrollmentJooq.studentId)
            .from(courseJooq.courseTable)
            .leftJoin(courseEnrollmentJooq.courseEnrollmentTable)
            .on(courseJooq.id.eq(courseEnrollmentJooq.courseId))
            .fetchResultSet();

        Stream<Tuple2<CourseResource, List<UUID>>> resultStream = null;
        try {
            resultStream = mapper.stream(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        assert resultStream != null;

        return resultStream
            .map((tuple) -> {
                tuple.v1.getStudentIds().addAll(tuple.v2);
                return tuple.v1;
            })
            .collect(Collectors.toList());
    }

    @Override
    public CourseResource create(CourseResource resource) {
        return null;
    }

    @Override
    public CourseResource save(CourseResource resource) {
        return null;
    }

    @Override
    public int delete(UUID id) {
        return 0;
    }
}
