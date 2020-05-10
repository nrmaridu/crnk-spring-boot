package com.practice.crnk;

import com.practice.crnk.resources.UniversityQuerySpec;
import com.practice.crnk.resources.UniversityResource;

import io.crnk.core.queryspec.QuerySpec;

/**
 * @author nrmaridu
 * @since May 10, 2020
 */
public class TypedQuerySpecTest {

    public void get() {
        QuerySpec querySpec = new QuerySpec(UniversityResource.class);
        UniversityQuerySpec universityQuerySpec = new UniversityQuerySpec();
    }

}
