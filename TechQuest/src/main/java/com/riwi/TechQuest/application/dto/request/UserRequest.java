package com.riwi.TechQuest.application.dto.request;

import com.riwi.TechQuest.domain.model.enums.Roles;
import lombok.Builder;
import lombok.Data;

import javax.management.relation.Role;

@Data
@Builder
public class UserRequest {
    private String name;
    private String lastname;
    private String email;
    private String password; // Considera encriptar esta información
    private Roles role; // Por ejemplo: "USER", "ADMIN", etc.
}
