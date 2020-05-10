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
public class StudentJooq {
    public static final StudentJooq INSTANCE = new StudentJooq();

    public static final String tableName = "student";

    public Table<Record> studentTable = DSL.table(tableName);

    public final Field<UUID> id = DSL.field(DSL.name(tableName, "id"), UUID.class);

    public final Field<String> name = DSL.field(DSL.name(tableName, "name"), String.class);

    public final Field<UUID> universityId = DSL.field(DSL.name(tableName, "university_id"), UUID.class);

    private StudentJooq() {
        // Enforce singleton
    }
}
