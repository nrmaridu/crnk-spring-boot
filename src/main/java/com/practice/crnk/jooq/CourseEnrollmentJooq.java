package com.practice.crnk.jooq;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;
import org.jooq.impl.DSL;

/**
 * @author nrmaridu
 * @since May 08, 2020
 */
public class CourseEnrollmentJooq {

    public static final CourseEnrollmentJooq INSTANCE = new CourseEnrollmentJooq();

    private static final String tableName = "course_enrollment";

    public final Table<Record> courseEnrollmentTable = DSL.table(tableName);

    public final Field<UUID> courseId = DSL.field(DSL.name(tableName, "course_id"), UUID.class);

    public final Field<UUID> studentId = DSL.field(DSL.name(tableName, "student_id"), UUID.class);

    private CourseEnrollmentJooq() {
        // Enforce singleton
    }
}
