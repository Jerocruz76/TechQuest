package com.riwi.TechQuest.domain.services.crud;

public interface Update<ID,Entity>{
    public Entity update(ID id);
}
