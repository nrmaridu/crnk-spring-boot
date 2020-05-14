package com.practice.crnk.api.resources;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.crnk.core.resource.annotations.JsonApiField;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiRelationId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.practice.crnk.api.resources.DepartmentResource.RESOURCE_PATH;
import static com.practice.crnk.api.resources.DepartmentResource.RESOURCE_TYPE;

/**
 * @author nrmaridu
 * @since May 08, 2020
 */
@Getter
@Setter
@NoArgsConstructor
@JsonApiResource(type = RESOURCE_TYPE, resourcePath = RESOURCE_PATH)
public class DepartmentResource {

    public static final String RESOURCE_TYPE = "department";
    public static final String RESOURCE_PATH = "departments";

    @JsonApiId
    private UUID id;

    @JsonApiField
    private String name;

    @JsonApiRelationId
    @JsonProperty("university-id")
    private UUID universityId;

    @JsonApiRelation
    private UniversityResource university;

    @JsonApiRelation
    private List<MentorResource> mentors;

    public DepartmentResource(UUID id, String name, UUID universityId) {
        this.id = id;
        this.name = name;
        this.universityId = universityId;
    }
}
