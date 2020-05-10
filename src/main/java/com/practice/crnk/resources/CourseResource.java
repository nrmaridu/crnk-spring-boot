package com.practice.crnk.resources;

import java.util.UUID;

import io.crnk.core.resource.annotations.JsonApiField;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.practice.crnk.resources.MentorResource.RESOURCE_PATH;
import static com.practice.crnk.resources.MentorResource.RESOURCE_TYPE;

/**
 * @author nrmaridu
 * @since May 08, 2020
 */
@Getter
@Setter
@NoArgsConstructor
@JsonApiResource(type = RESOURCE_TYPE, resourcePath = RESOURCE_PATH)
public class CourseResource {

    public static final String RESOURCE_TYPE = "mentor";
    public static final String RESOURCE_PATH = "mentors";

    @JsonApiId
    private UUID id;

    @JsonApiField
    private String name;

    @JsonApiField
    private Long credits;

    public CourseResource(UUID id, String name, Long credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
    }
}
