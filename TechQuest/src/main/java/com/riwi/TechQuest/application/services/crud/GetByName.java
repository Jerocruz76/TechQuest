package com.riwi.TechQuest.application.services.crud;

public interface GetByName<Entity, String>{
    public Entity getByName(String name);
}
