package com.riwi.TechQuest.application.services.crud;

public interface GetByTitle<Entity, String>{
    public Entity getByTitle(String title);
}
