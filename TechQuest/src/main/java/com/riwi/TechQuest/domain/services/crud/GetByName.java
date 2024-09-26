package com.riwi.TechQuest.domain.services.crud;

public interface GetByName<Entity, String>{
    public Entity getByName(String name);
}
