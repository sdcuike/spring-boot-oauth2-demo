package com.sdcuike.practice.domain;

public class CourseEnrollmentKey {
    private Long courseId;

    private Long studId;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getStudId() {
        return studId;
    }

    public void setStudId(Long studId) {
        this.studId = studId;
    }
}