package com.practice.crnk.service.configuration;

import javax.sql.DataSource;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.RenderNameStyle;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.springframework.stereotype.Component;

/**
 * @author nrmaridu
 * @since May 08, 2020
 */
@Component
public class JooqImpl implements Jooq {

    private final Settings defaultSettings = new Settings()
        .withRenderNameStyle(RenderNameStyle.AS_IS);

    private final DataSource dataSource;

    public JooqImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public DSLContext build() {
        return withSettings(defaultSettings);
    }

    @Override
    public DSLContext withSettings(Settings settings) {
        return DSL.using(
            new DefaultConfiguration()
                .set(SQLDialect.POSTGRES)
                .set(dataSource)
                .set(settings)
        );
    }

}
