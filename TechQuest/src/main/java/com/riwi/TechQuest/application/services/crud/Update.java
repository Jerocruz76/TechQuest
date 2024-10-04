package com.riwi.TechQuest.application.services.crud;

public interface Update<ID,Entity>{
    public Entity update(ID id, Entity entity);
}
