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
public class DepartmentJooq {

    public static final DepartmentJooq INSTANCE = new DepartmentJooq();

    private static final String tableName = "department";

    public final Table<Record> departmentTable = DSL.table(tableName);

    public final Field<UUID> id = DSL.field(DSL.name(tableName, "id"), UUID.class);

    public final Field<String> name = DSL.field(DSL.name(tableName, "name"), String.class);

    public final Field<UUID> universityId = DSL.field(DSL.name(tableName, "university_id"), UUID.class);

    private DepartmentJooq() {
        // Enforce singleton
    }
}
