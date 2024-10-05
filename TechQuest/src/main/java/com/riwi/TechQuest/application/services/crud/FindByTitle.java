package com.riwi.TechQuest.application.services.crud;

public interface FindByTitle<Entity, String>{
    public Entity findByTitle(String title);
}
