package com.riwi.TechQuest.domain.services.crud;

public interface Create<EntityRequest, Entity>{
    public Entity create(EntityRequest entityRequest);
}
