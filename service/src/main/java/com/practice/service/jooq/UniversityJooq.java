package com.practice.service.jooq;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;
import org.jooq.impl.DSL;

/**
 * @author nrmaridu
 * @since May 08, 2020
 */
public class UniversityJooq {

    public static final UniversityJooq INSTANCE = new UniversityJooq();

    private static final String tableName = "university";

    public final Table<Record> universityTable = DSL.table(tableName);

    public final Field<UUID> id = DSL.field(DSL.name(tableName, "id"), UUID.class);

    public final Field<String> name = DSL.field(DSL.name(tableName, "name"), String.class);

    private UniversityJooq() {
        // Enforce singleton
    }

}
