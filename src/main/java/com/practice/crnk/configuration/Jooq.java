package com.practice.crnk.configuration;

import javax.validation.constraints.NotNull;

import org.jooq.DSLContext;
import org.jooq.conf.Settings;

/**
 * @author nrmaridu
 * @since May 08, 2020
 */
public interface Jooq {
    /**
     * Begins building a jOOQ query.
     *
     * @return A new {@link DSLContext}.  Not null.
     */
    @NotNull
    DSLContext build();

    /**
     * Begins building a jOOQ query, with custom settings used to configure the {@link DSLContext}.
     *
     * @param settings Settings used to configure the {@link DSLContext}.  Not null.
     * @return A new {@link DSLContext}.  Not null.
     */
    @NotNull
    DSLContext withSettings(@NotNull final Settings settings);
}
