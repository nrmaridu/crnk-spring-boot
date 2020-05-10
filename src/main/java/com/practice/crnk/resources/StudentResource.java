package com.practice.crnk.resources;

import java.util.List;
import java.util.UUID;

import io.crnk.core.resource.annotations.JsonApiField;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiRelationId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.practice.crnk.resources.StudentResource.RESOURCE_PATH;
import static com.practice.crnk.resources.StudentResource.RESOURCE_TYPE;

/**
 * @author nrmaridu
 * @since May 08, 2020
 */
@Getter
@Setter
@NoArgsConstructor
@JsonApiResource(type = RESOURCE_TYPE, resourcePath = RESOURCE_PATH)
public class StudentResource {

    public static final String RESOURCE_TYPE = "student";
    public static final String RESOURCE_PATH = "students";

    @JsonApiId
    private UUID id;

    @JsonApiField
    private String name;

    @JsonApiRelationId
    private UUID universityId;

    @JsonApiRelation
    private UniversityResource university;

    @JsonApiRelation
    private List<CourseResource> courses;

    public StudentResource(UUID id, String name, UUID universityId) {
        this.id = id;
        this.name = name;
        this.universityId = universityId;
    }
}
