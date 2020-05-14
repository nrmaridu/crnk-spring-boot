package com.practice.crnk.api.resources;

import java.util.List;
import java.util.UUID;

import io.crnk.core.resource.annotations.JsonApiField;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.practice.crnk.api.resources.UniversityResource.RESOURCE_PATH;
import static com.practice.crnk.api.resources.UniversityResource.RESOURCE_TYPE;

/**
 * @author nrmaridu
 * @since May 08, 2020
 */
@Data
@NoArgsConstructor
@JsonApiResource(type = RESOURCE_TYPE, resourcePath = RESOURCE_PATH, sortable = true, filterable = true,
    patchable = true)
public class UniversityResource {

    public static final String RESOURCE_TYPE = "university";
    public static final String RESOURCE_PATH = "universities";

    @JsonApiId
    private UUID id;

    @JsonApiField(filterable = true, sortable = true)
    private String name;

    @JsonApiRelation
    private List<DepartmentResource> departments;

    public UniversityResource(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return this.id != null ? id : UUID.randomUUID();
    }
}
