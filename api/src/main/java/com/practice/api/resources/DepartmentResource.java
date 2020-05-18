package com.practice.api.resources;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.practice.api.resources.base.ApiResource;

import io.crnk.core.resource.annotations.JsonApiField;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiRelationId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.practice.api.resources.DepartmentResource.RESOURCE_PATH;
import static com.practice.api.resources.DepartmentResource.RESOURCE_TYPE;

/**
 * @author nrmaridu
 * @since May 08, 2020
 */
@JsonApiResource(type = RESOURCE_TYPE, resourcePath = RESOURCE_PATH)
public class DepartmentResource extends ApiResource {

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

    public DepartmentResource() {
    }

    public DepartmentResource(UUID id, String name, UUID universityId) {
        this.id = id;
        this.name = name;
        this.universityId = universityId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUniversityId() {
        return universityId;
    }

    public void setUniversityId(UUID universityId) {
        this.universityId = universityId;
    }

    public UniversityResource getUniversity() {
        return university;
    }

    public void setUniversity(UniversityResource university) {
        this.university = university;
    }

    public List<MentorResource> getMentors() {
        return mentors;
    }

    public void setMentors(List<MentorResource> mentors) {
        this.mentors = mentors;
    }
}
