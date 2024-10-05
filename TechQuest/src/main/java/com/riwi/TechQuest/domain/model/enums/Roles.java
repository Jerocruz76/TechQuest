package com.riwi.TechQuest.domain.model.enums;

public enum Roles {
    ROLE_ADMIN,
    ROLE_TEACHER,
    ROLE_STUDENT;

    public String getName() {
        return this.name();
    }
}
