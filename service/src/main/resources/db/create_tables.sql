CREATE TABLE public.university
(
    id uuid NOT NULL,
    name character varying(100) NOT NULL,
    CONSTRAINT user_pkey PRIMARY KEY (id)
);

CREATE TABLE public.department
(
    id uuid NOT NULL,
    name character varying(100) NOT NULL,
    university_id uuid NOT NULL,
    CONSTRAINT department_pkey PRIMARY KEY (id),
    CONSTRAINT university_fk FOREIGN KEY (university_id)
        REFERENCES public.university (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE public.course
(
    id uuid NOT NULL,
    name character varying(100) NOT NULL,
    credits bigint NOT NULL default 0,
    department_id uuid NOT NULL,
    CONSTRAINT course_pkey PRIMARY KEY (id),
    CONSTRAINT department_fk FOREIGN KEY (department_id)
        REFERENCES public.department (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE public.mentor
(
    id uuid NOT NULL,
    name character varying(100) NOT NULL,
    department_id uuid NOT NULL,
    CONSTRAINT mentor_pkey PRIMARY KEY (id),
    CONSTRAINT department_fk FOREIGN KEY (department_id)
        REFERENCES public.department (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

-- Assumption : course <-> mentor  => one-to-one relationship
CREATE TABLE public.student
(
    id uuid NOT NULL,
    name character varying(100) NOT NULL,
    university_id uuid NOT NULL,
    CONSTRAINT student_pkey PRIMARY KEY (id),
    CONSTRAINT university_fk FOREIGN KEY (university_id)
        REFERENCES public.university (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE public.course_mentor
(
    course_id uuid NOT NULL,
    mentor_id uuid NOT NULL,
    CONSTRAINT course_mentor_ukey UNIQUE (course_id, mentor_id),
    CONSTRAINT course_mentor_fk FOREIGN KEY (course_id)
        REFERENCES public.course (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT mentor_fk FOREIGN KEY (mentor_id)
        REFERENCES public.mentor (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

-- a student can enroll in multiple courses
-- a course can have multiple students
-- course <-> stuent  => many-to-many relationship
CREATE TABLE public.course_enrollment
(
    student_id uuid NOT NULL,
    course_id uuid NOT NULL,
    CONSTRAINT course_fk FOREIGN KEY (course_id)
        REFERENCES public.course (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT student_fk FOREIGN KEY (student_id)
        REFERENCES public.student (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);








