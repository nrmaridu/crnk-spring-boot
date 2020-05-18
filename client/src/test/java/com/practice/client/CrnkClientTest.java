package com.practice.client;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.practice.api.resources.UniversityPathSpec;
import com.practice.api.resources.UniversityQuerySpec;
import com.practice.api.resources.UniversityResource;
import com.practice.client.config.CrnkClientConfiguration;

import io.crnk.client.CrnkClient;
import io.crnk.core.queryspec.pagingspec.OffsetLimitPagingSpec;
import io.crnk.core.repository.ResourceRepository;

/**
 * @author nrmaridu
 * @since May 18, 2020
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {CrnkClientConfiguration.class})
public class CrnkClientTest {

    @Autowired
    private CrnkClient crnkClient;

    @Test
    public void setup() {

        ResourceRepository<UniversityResource, UUID> universityRepository = crnkClient.getRepositoryForType(UniversityResource.class);

        UniversityQuerySpec universityQuerySpec = new UniversityQuerySpec();
        UniversityPathSpec universityPathSpec = new UniversityPathSpec();
        universityQuerySpec.setPaging(new OffsetLimitPagingSpec(1L, 1L));
        universityQuerySpec.includeRelation(universityPathSpec.departments());

        List<UniversityResource> universityResources = universityRepository.findAll(universityQuerySpec);

        Assertions.assertNotNull(universityResources);


    }
}
