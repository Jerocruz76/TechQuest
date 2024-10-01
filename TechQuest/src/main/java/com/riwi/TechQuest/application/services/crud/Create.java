package com.riwi.TechQuest.application.services.crud;

public interface Create<EntityRequest, Entity>{
    public Entity create(EntityRequest entityRequest);
}
