package com.practice.api.resources;

import java.util.List;
import java.util.UUID;

import com.practice.api.resources.base.ApiResource;

import io.crnk.core.resource.annotations.JsonApiField;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.NoArgsConstructor;

import static com.practice.api.resources.UniversityResource.RESOURCE_PATH;
import static com.practice.api.resources.UniversityResource.RESOURCE_TYPE;

/**
 * @author nrmaridu
 * @since May 08, 2020
 */
@NoArgsConstructor
@JsonApiResource(type = RESOURCE_TYPE, resourcePath = RESOURCE_PATH)
public class UniversityResource extends ApiResource {

    public static final String RESOURCE_TYPE = "university";
    public static final String RESOURCE_PATH = "universities";

    @JsonApiId
    private UUID id;

    @JsonApiField
    private String name;

    @JsonApiRelation
    private List<DepartmentResource> departments;

    public UniversityResource(UUID id, String name) {
        this.id = id;
        this.name = name;
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

    public List<DepartmentResource> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DepartmentResource> departments) {
        this.departments = departments;
    }

    public UUID getId() {
        return this.id != null ? id : UUID.randomUUID();
    }
}
