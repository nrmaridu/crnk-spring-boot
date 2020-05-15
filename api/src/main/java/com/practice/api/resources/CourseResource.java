package com.practice.api.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.practice.api.resources.base.ApiResource;

import io.crnk.core.resource.annotations.JsonApiField;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiRelationId;
import io.crnk.core.resource.annotations.JsonApiResource;
import io.crnk.core.resource.annotations.SerializeType;

import static com.practice.api.resources.CourseResource.RESOURCE_PATH;
import static com.practice.api.resources.CourseResource.RESOURCE_TYPE;

/**
 * @author nrmaridu
 * @since May 08, 2020
 */
@JsonApiResource(type = RESOURCE_TYPE, resourcePath = RESOURCE_PATH)
public class CourseResource extends ApiResource {

    public static final String RESOURCE_TYPE = "course";
    public static final String RESOURCE_PATH = "courses";

    @JsonApiId
    private UUID id;

    @JsonApiField
    private String name;

    @JsonApiField
    private Long credits;

    @JsonApiRelationId
    private List<UUID> studentIds;

    @JsonApiRelation(idField = "studentIds", serialize = SerializeType.ONLY_ID)
    private List<StudentResource> students = new ArrayList<>();

    public CourseResource() {

    }

    public CourseResource(UUID id, String name, Long credits, List<UUID> studentIds) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.studentIds = studentIds;
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

    public Long getCredits() {
        return credits;
    }

    public void setCredits(Long credits) {
        this.credits = credits;
    }

    public List<UUID> getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(List<UUID> studentIds) {
        this.studentIds = studentIds;
    }

    public List<StudentResource> getStudents() {
        return students;
    }

    public void setStudents(List<StudentResource> students) {
        this.students = students;
    }
}
