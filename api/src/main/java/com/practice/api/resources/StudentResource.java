package com.practice.api.resources;

import java.util.List;
import java.util.UUID;

import com.practice.api.resources.base.ApiResource;

import io.crnk.core.resource.annotations.JsonApiField;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiRelationId;
import io.crnk.core.resource.annotations.JsonApiResource;

import static com.practice.api.resources.StudentResource.RESOURCE_PATH;
import static com.practice.api.resources.StudentResource.RESOURCE_TYPE;

/**
 * @author nrmaridu
 * @since May 08, 2020
 */
@JsonApiResource(type = RESOURCE_TYPE, resourcePath = RESOURCE_PATH)
public class StudentResource extends ApiResource {

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

    @JsonApiRelationId
    private List<UUID> courseIds;

    @JsonApiRelation(idField = "courseIds")
    private List<CourseResource> courses;

    public StudentResource(UUID id, String name, UUID universityId, List<UUID> courseIds) {
        this.id = id;
        this.name = name;
        this.universityId = universityId;
        this.courseIds = courseIds;
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

    public List<UUID> getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(List<UUID> courseIds) {
        this.courseIds = courseIds;
    }

    public List<CourseResource> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseResource> courses) {
        this.courses = courses;
    }
}
