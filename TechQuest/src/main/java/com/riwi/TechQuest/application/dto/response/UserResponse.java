package com.riwi.TechQuest.application.dto.response;

import com.riwi.TechQuest.domain.model.enums.Roles;
import lombok.Builder;
import lombok.Data;

import javax.management.relation.Role;

@Data
@Builder
public class UserResponse {
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private Roles role;
}
