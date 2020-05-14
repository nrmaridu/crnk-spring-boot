package com.practice.crnk.service.jooq;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;
import org.jooq.impl.DSL;

/**
 * @author nrmaridu
 * @since May 08, 2020
 */
public class CourseJooq {

    public static final CourseJooq INSTANCE = new CourseJooq();

    private static final String tableName = "course";

    public final Table<Record> courseTable = DSL.table(tableName);

    public final Field<UUID> id = DSL.field(DSL.name(tableName, "id"), UUID.class);

    public final Field<String> name = DSL.field(DSL.name(tableName, "name"), String.class);

    public final Field<Long> credits = DSL.field(DSL.name(tableName, "credits"), Long.class);

    public final Field<UUID> departmentId = DSL.field(DSL.name(tableName, "department_id"), UUID.class);

    private CourseJooq() {
        // Enforce singleton
    }
}
